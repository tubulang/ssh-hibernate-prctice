package dao;

import common.HibernateSessionFactory;
import models.Booking;
import models.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketsDao {

    //添加预定信息
    public int addTicket(Booking ticket){
        int num=0;
        Session session=null;
        Transaction transaction=null;
        try{
            session=HibernateSessionFactory.getSession();
            transaction=session.beginTransaction();
            num=Integer.parseInt(session.save(ticket).toString());
            transaction.commit(); //写入数据库，
        }catch (Exception e) {
            e.printStackTrace();
            num=0;
        }finally{//关闭session
            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
        return num;
    }


    //查询用户全部机票信息
    public List<Booking> queryTicketsById(int uid){
        //得到session
        Session session=null;
        Transaction transaction=null;
        try{
            session=HibernateSessionFactory.getSession();
            String queryString="from Booking where uid=?";
            Query queryObject=session.createQuery(queryString);
            queryObject.setParameter(0, uid);
            List<Booking> list=queryObject.list();
            System.out.println(list.toString());
            return list;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{//关闭session
            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }



    //修改预定信息
//    public boolean changeTicket(Users user,String oldPwd,String newPwd){
//        boolean flag=true;
//        //得到session
//        Session session=null;
//        Transaction transaction=null;
//        try{
//            session=HibernateSessionFactory.getSession();
//            //hql语句,Users代表是models里的实体类,name和password代表实体类的属性
//            String queryString="from Users where name=? and password=?";
//            //创建查询
//            Query queryObject=session.createQuery(queryString);
//            queryObject.setParameter(0, user.getName());
//            queryObject.setParameter(1, oldPwd);
//            //执行查询获得的结果,list中的每一个元素代表一个Users的对象
//            List<Users> list=queryObject.list();
//            if(list.size()==0){
//                flag=false;//旧密码错误
//            }else{
//                user=list.get(0); //找到要修改密码的用户对象
//                user.setPassword(newPwd);
//                transaction=session.beginTransaction();
//                session.update(user);//在缓存中保存数据，受影响行数
//                transaction.commit();//写入数据库表
//            }
//            return flag;
//        }catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }finally{//关闭session
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
//        }
//    }
//
//    //删除预定信息
//    public boolean deleteTicket(int id){
//        Session session=null;
//        try{
//            session=HibernateSessionFactory.getSession();
//            //根据id获取要修改的用户数据
//            Users user=(Users)session.get(Users.class, id);
//            //删除user数据
//            Transaction trans=session.beginTransaction();
//            session.delete(user);
//            trans.commit();
//            return true;
//
//        }catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }finally{//关闭session
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
//        }
//    }
}
