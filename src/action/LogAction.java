package action;

import bean.DBCon;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import bean.*;
import dao.UsersDao;
import models.Users;
import java.util.*;
public class LogAction extends ActionSupport{
//    private String logname;
//    private String logpassword;
//    Person customer;
//    Map session;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    Users user;
    UsersDao ud=new UsersDao();
//    List<Person> users;

    public LogAction(){

    }
//    public Person getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Person customer) {
//        this.customer = customer;
//    }
    public String execute(){
        if(ud.checkLoginByCriteria(user)){
            Map map=ActionContext.getContext().getSession();
            map.put("user",user);
            return SUCCESS;
        }else{
            return INPUT;
        }
    }

//    public String login(){
////        if(logname!=null&&logpassword!=null){
////            if(DBCon.validateLogin(logname,logpassword)){
////                session.put("loginUser",logname);
////                return SUCCESS;
////            }else{
////                return INPUT;
////            }
////        }else{
////            return INPUT;
////        }
//        if(customer.getName()!=null&&customer.getPassword()!=null){
//            Map m;
//            m=ActionContext.getContext().getSession();
//            System.out.println(customer.getName());
//            if(DBCon.validateLogin(customer.getName(), customer.getPassword())){
//                m.put("user",customer.getName());
//                users=DBCon.queryUsers();
//                System.out.print(users);
//                m.put("users", users);
//                return "success";
//            }else{
//                return "input";
//            }
//        }else{
//            return INPUT;
//        }
//    }

}