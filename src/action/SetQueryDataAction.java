package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class SetQueryDataAction extends ActionSupport {
    String query_data;
    public SetQueryDataAction(){

    }

    public String getQuery_data() {
        return query_data;
    }

    public void setQuery_data(String query_data) {
        this.query_data = query_data;
    }

    public String execute(){
        System.out.println(query_data+"this is query_data");
        if(query_data!=null){
            Map map=ActionContext.getContext().getSession();
            map.put("query_data",query_data);
            return SUCCESS;
        }else {
            return INPUT;
        }



    }
}
