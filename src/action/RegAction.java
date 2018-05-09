package action;
//import com.opensymphony.xwork2.ActionContext;
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



//    List<Person> users;
//    public Person getCustomer1() {
//        return customer1;
//    }
//
//    public void setCustomer1(Person customer1) {
//        this.customer1 = customer1;
//    }


    public RegAction(){

    }
//    public void validate(){
//        if(!customer1.getPassword().equals(customer1.getEnsurepwd())){
//            this.addFieldError("customer1.password","密码不一致！！");
//        }
//    }
//    public String execute()throws Exception{
//        System.out.println("react!11");
//        users=DBCon.queryUsers();
//        System.out.print(users);
//        session.put("users", users);
//        return SUCCESS;
//    }

    public String execute() throws Exception{
        if(ud.registerUser(user)>0){
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
