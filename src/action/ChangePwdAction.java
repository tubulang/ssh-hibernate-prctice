package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.UsersDao;
import models.Users;

import java.util.Map;

public class ChangePwdAction extends ActionSupport {
    String oldPwd;
    String newPwd;
    String newPwd2;
    Users user;
    UsersDao ud;
    public ChangePwdAction(){

    }

    public UsersDao getUd() {
        return ud;
    }

    public void setUd(UsersDao ud) {
        this.ud = ud;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getNewPwd2() {
        return newPwd2;
    }

    public void setNewPwd2(String newPwd2) {
        this.newPwd2 = newPwd2;
    }

    public String execute(){
        Map map= ActionContext.getContext().getSession();
        user=(Users)map.get("user");
        System.out.println(oldPwd);
        if(ud.changePassword(user,oldPwd,newPwd)){
            return SUCCESS;
        }else{
            return INPUT;
        }
    }

}
