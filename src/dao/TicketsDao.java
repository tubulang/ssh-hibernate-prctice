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
    //查询某一机票信息
    public Booking queryTicketsByTid(int tid){
        //得到session
        Session session=null;
        Transaction transaction=null;
        try{
            System.out.println(tid+"this is tid");
            session=HibernateSessionFactory.getSession();
            String queryString="from Booking where tid=?";
            Query queryObject=session.createQuery(queryString);
            queryObject.setParameter(0, tid);
            List<Booking> list=queryObject.list();
            System.out.println(list.toString());
            if(list.size()>0) {
                return list.get(0);
            }else{
                System.out.println("list size 0");
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{//关闭session
            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }



    //修改预定信息
    public boolean changeTicket(Booking airticket){
        boolean flag=true;
        //得到session
        int num=0;
        Session session=null;
        Transaction transaction=null;
        try{
            session=HibernateSessionFactory.getSession();
            transaction=session.beginTransaction();
            session.update(airticket);
            transaction.commit();//写入数据库表
            return flag;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{//关闭session
            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

    //删除预定信息
    public boolean deleteTicket(Booking air_ticket){
        Session session=null;
        try{
            session=HibernateSessionFactory.getSession();
            //根据id获取要修改的用户数据
//            Users user=(Users)session.get(Users.class, id);
            //删除user数据
            Transaction trans=session.beginTransaction();
            session.delete(air_ticket);
            trans.commit();
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{//关闭session
            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

    //查询每页需要显示的数据(每次最多5条记录)
    public List<Booking> queryByPage(int uid,int pageNo,int pageSize){
        //得到session
        Session session=null;
        try{
            session=HibernateSessionFactory.getSession();
            String queryString="from Booking where uid=?";
            Query query=session.createQuery(queryString);
            query.setParameter(0, uid);
//            List<Booking> list=query.list();
//            Query query=session.createQuery(queryString);
            //每次获取第一条数据的索引
            query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
            //这一页显示的记录个数
            query.setMaxResults(pageSize);
            System.out.println(pageSize+"this is pagesize");
            System.out.println(uid+"this is uid,pagesize");
            //每次最多5条记录
            List<Booking> list=query.list();
            return list;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{//关闭session
            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }
}
