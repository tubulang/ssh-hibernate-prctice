package action;
//import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import bean.*;
import java.util.*;
import dao.*;
import models.*;
public class RegAction extends ActionSupport{
//    private String regname;
//    private String regpassword;
//    private String ensureregpwd;
    Users user;
    UsersDao ud=new UsersDao();
//    Map session;
//    Person customer1;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public RegAction(){

    }

    public String execute() throws Exception{
        if(ud.registerUser(user)>0){
            Map map=ActionContext.getContext().getSession();
            map.put("user",user);
            return SUCCESS;
        }else{
            return INPUT;
        }
    }

//    public String register(){
////        System.out.println(customer1.getName());
//        if(customer1.getName()!=null && customer1.getPassword()!=null && customer1.getEnsurepwd()!=null){
////            Person person=new Person(regname,regpassword);
//            if(DBCon.registerUser(customer1)){
//                //保存当前的登录用户
//                Map session=ActionContext.getContext().getSession();
//                session.put("reguser", customer1);
//                users=DBCon.queryUsers();
//                System.out.print(users);
//                session.put("users", users);
//
//                return "success";
//            }else{
//                return "input";
//            }
//        }else{
//            return "input";
//        }
//    }
}
