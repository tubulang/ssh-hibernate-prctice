package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import models.Users;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import java.util.Map;
@SuppressWarnings("serial")
public class OutLoginAction extends ActionSupport {
    public String execute(){
        System.out.println("this is outlogin");
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null){
            session.removeAttribute("user");
        }
        return SUCCESS;
    }
}
