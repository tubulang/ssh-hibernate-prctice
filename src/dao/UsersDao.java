package dao;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Expression;

import models.*;
//import common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class UsersDao {
//    @Resource(value="sessionFactory")
    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //使用HQL语句和Query来实现验证登录
    public Users checkLogin(Users user){
        boolean flag=true;
        //得到session
        Session session=null;
        try{
            session=sessionFactory.openSession();
            //hql语句,Users代表是models里的实体类,name和password代表实体类的属性
            String queryString="from Users where name=? and password=?";
            //创建查询
            Query queryObject=session.createQuery(queryString);
            queryObject.setParameter(0, user.getName());
            queryObject.setParameter(1, user.getPassword());
            //执行查询获得的结果,list中的每一个元素代表一个Users的对象
            List<Users> list=queryObject.list();
            if(list.size()==0){
                return null;//登陆不成功
            }else {
                return list.get(0);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

    //使用HQL语句和Criteria来实现验证登录
    public boolean checkLoginByCriteria(Users user){
        boolean flag=true;
        //得到session
        Session session=null;
        try{
            session=sessionFactory.openSession();
            //创建Criteria对象
            Criteria criteria = session.createCriteria(Users.class);
            //封装查询条件
            criteria.add(Expression.and(Expression.eq("name", user.getName()), Expression.eq("password", user.getPassword())));
            //执行查询
            List list=criteria.list();

            if(list.size()==0){
                flag=false;//登陆不成功
            }
            return flag;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

    //查询所有用户,返回的是持久化类集合对象
    public List<Users> queryAllUsersByCriteria(){
        //得到session
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Criteria criteria=session.createCriteria(Users.class);
            //执行查询获得的结果,list中的每一个元素代表一个Users的对象
            List list=criteria.list();
            if(list.size()>0)
                return list;
            else{
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

    //查询所有用户,返回的是持久化类集合对象
    public List<Users> queryUsers(){
        //得到session
        Session session=null;
        try{
            session=sessionFactory.openSession();
            //hql语句,Users代表是models里的实体类,name和password代表实体类的属性
            String queryString="from Users";
            //创建查询
            Query query=session.createQuery(queryString);
            //执行查询获得的结果,list中的每一个元素代表一个Users的对象
            List list=query.list();
            if(list.size()>0)
                return list;
            else{
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

    //注册用户
    public int registerUser(Users user){
        int num=0;
        //得到session
        Session session=null;
        Transaction transaction=null;
        try{
//            ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext-common.xml");
//            sessionFactory=(SessionFactory) ac.getBean("sesssionFactory");
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            num=Integer.parseInt(session.save(user).toString());
            transaction.commit(); //写入数据库，
        }catch (Exception e) {
            e.printStackTrace();
            num=0;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
        return num;
    }

    //查询每页需要显示的数据(每次最多5条记录)
    public List<Users> queryByPage(int pageNo,int pageSize){
        //得到session
        Session session=null;
        try{
            session=sessionFactory.openSession();
            String queryString="from Users";
            Query query=session.createQuery(queryString);
            //每次获取第一条数据的索引
            query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
            //这一页显示的记录个数
            query.setMaxResults(pageSize);

            //每次最多5条记录
            List<Users> list=query.list();
            return list;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

    //根据id来更新数据方法
    public boolean updateUserById(int id,Users newUser){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            //根据id获取要修改的用户数据
            Users oldUser=(Users)session.get(Users.class, id);
            //设置新的数据
            oldUser.setName(newUser.getName());
            oldUser.setPassword(newUser.getPassword());
//            oldUser.setSex(newUser.getSex());
//            oldUser.setAge(newUser.getAge());
//            oldUser.setEmail(newUser.getEmail());
            //保存oldUser数据回数据库
            Transaction trans=session.beginTransaction();
            //获取受影响的行数
            //num=Integer.parseInt(session.save(oldUser).toString());
            session.update(oldUser);
            trans.commit();
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

    //根据id来更新数据方法
    public Users queryUserById(int id){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            //根据id获取要修改的用户数据
            Users user=(Users)session.get(Users.class, id);
            return user;

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

    //根据id来更新数据方法
    public boolean updateUser(Users newUser){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            //保存oldUser数据回数据库
            Transaction trans=session.beginTransaction();
            session.saveOrUpdate(newUser);
            trans.commit();
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

    //根据id来删除数据方法
    public boolean deleteUserById(int id){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            //根据id获取要修改的用户数据
            Users user=(Users)session.get(Users.class, id);
            //删除user数据
            Transaction trans=session.beginTransaction();
            session.delete(user);
            trans.commit();
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

    //使用Criteria查询所有用户,返回的是持久化类集合对象
    public List<Users> queryUsersByCriteria(){
        //得到session
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Criteria criteria=session.createCriteria(Users.class);
            //执行查询获得的结果,list中的每一个元素代表一个Users的对象
            List list=criteria.list();
            if(list.size()>0)
                return list;
            else{
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

    //修改密码
    public boolean changePassword(Users user,String oldPwd,String newPwd){
        boolean flag=true;
        //得到session
        Session session=null;
        Transaction transaction=null;
        try{
            System.out.println("this is changepassword");
            session=sessionFactory.openSession();
            //hql语句,Users代表是models里的实体类,name和password代表实体类的属性
            String queryString="from Users where name=? and password=?";
            //创建查询
            Query queryObject=session.createQuery(queryString);
            queryObject.setParameter(0, user.getName());
            queryObject.setParameter(1, oldPwd);
            //执行查询获得的结果,list中的每一个元素代表一个Users的对象
            List<Users> list=queryObject.list();
            if(list.size()==0){
                flag=false;//旧密码错误
                System.out.println("this is changepassword2");
            }else{
                user=list.get(0); //找到要修改密码的用户对象
                user.setPassword(newPwd);
                transaction=session.beginTransaction();
                session.update(user);//在缓存中保存数据，受影响行数
                System.out.println("this is changepassword3");
                transaction.commit();//写入数据库表
            }
            return flag;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }

    }
}