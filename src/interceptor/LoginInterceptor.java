package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import models.Users;

import java.util.*;

public class LoginInterceptor extends AbstractInterceptor{
    public String intercept(ActionInvocation ai)throws Exception{
        Map session=ai.getInvocationContext().getSession();
        Users user=(Users)session.get("user");
        if(user!=null){
            return ai.invoke();
        }else{
            ActionContext ac=ai.getInvocationContext();
            ac.put("popedom","请登录！");
            return "reglogin";
        }
    }
}
