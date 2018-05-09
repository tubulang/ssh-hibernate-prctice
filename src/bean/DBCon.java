package bean;
import java.sql.*;
import java.util.*;

import action.AddBookingAction;
import bean.Person;
public class DBCon {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/user?characterEncoding=utf-8";
    static String user = "root";//连接时的用户名
    static String password = "root";//连接时的密码
    static Connection conn;
    public DBCon(){

    }
    //连接数据库的方法
    public static Connection JDBCon(){
        try{
            //加载驱动程序
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            //连接数据库
//            String url="jdbc:sqlserver://localhost:1433; DatabaseName=UsersDB";
//            Connection conn=DriverManager.getConnection(url,"sa","");
            Class.forName(driver).newInstance();
//            String url = "jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=gb2312";
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接成功!");
            return conn;
        }catch(ClassNotFoundException ex1){
            System.out.println("数据库连接失败!");
            ex1.printStackTrace();
            return null;
        }catch(SQLException ex2){
            System.out.println("数据库连接失败!");
            ex2.printStackTrace();
            return null;
        }catch(Exception ex3){
            ex3.printStackTrace();
            return null;
        }
    }
    //验证用户登录的方法
    public static boolean validateLogin(String name,String password){
        Connection conn=JDBCon();
        Statement stmt=null;
        try{
            stmt=conn.createStatement();
            String sql="select * from Users where name='"+name+"' and password='"+password+"'";
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
                return true;
            }else{
                return false;
            }
//            stmt.close();

        }catch(SQLException ex){
            System.out.println("数据库连接失败!");
            ex.printStackTrace();
            return false;
        }
    }
    //注册用户的方法
    public static boolean registerUser(Person person){
        Connection conn=JDBCon();
        Statement stmt=null;
        try{
            stmt=conn.createStatement();
            String sql="insert into Users values('"+person.getName()+"','"+person.getPassword()+"')";
            int r=stmt.executeUpdate(sql);
            if(r>0){
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println("数据库访问失败!");
            ex.printStackTrace();
            return false;
        }
    }
    public static Vector<Person> queryUsers(){
        try{
            Connection conn=JDBCon();
            Statement stmt=conn.createStatement();
            String sql="select * from Users";
            ResultSet rs=stmt.executeQuery(sql);
            Vector <Person>data=new Vector<Person>();
            while(rs.next()){
                System.out.println("this is test");
                Person user1=new Person();
                user1.setName(rs.getString(1));
                user1.setPassword(rs.getString(2));
                System.out.println(user1.getName());
                System.out.println(rs.getString(1));
                data.add(user1);
            }
            return data;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    //预定机票
    public static boolean addbooking(Booking booking){
        Connection conn=JDBCon();
        Statement stmt=null;
        try{
            stmt=conn.createStatement();
            String sql="insert into airtickets " +
                    "values('"+booking.getName()+
                    "','"+booking.getSex()+"','"+booking.getFrom_city()+
                    "','"+booking.getTo_city()+"','"+booking.getStart_time()+
                    "','"+booking.getId_card()+"')";
            int r=stmt.executeUpdate(sql);
            if(r>0){
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println("数据库访问失败!");
            ex.printStackTrace();
            return false;
        }
    }

    //获取预定信息
    public static Vector<Booking> queryAirTicket(){
        try{
            Connection conn=JDBCon();
            Statement stmt=conn.createStatement();
            String sql="select * from airtickets";
            ResultSet rs=stmt.executeQuery(sql);
            Vector <Booking>airtickets=new Vector<Booking>();
            while(rs.next()){
//                System.out.println("this is test");
                Booking airticket=new Booking();
                airticket.setName(rs.getString(1));
                airticket.setSex(rs.getString(2));
                airticket.setFrom_city(rs.getString(3));
                airticket.setTo_city(rs.getString(4));
                airticket.setStart_time(rs.getString(5));
                airticket.setId_card(rs.getString(6));
//                System.out.println(user1.getName());
//                System.out.println(rs.getString(1));
                airtickets.add(airticket);
            }
            return airtickets;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
