package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.TicketsDao;
import dao.UsersDao;
import models.Booking;
import models.Users;

import java.util.List;
import java.util.Map;

public class QueryTicketsAction extends ActionSupport {

    private List<Booking> air_tickets;
    private Users user;
    private TicketsDao td=new TicketsDao();

    public QueryTicketsAction(){

    }

    public List getAir_tickets() {
        return air_tickets;
    }

    public void setAir_tickets(List air_tickets) {
        this.air_tickets = air_tickets;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }


    public String execute() throws Exception{
        Map m=ActionContext.getContext().getSession();
        user=(Users)m.get("user");
        air_tickets=td.queryTicketsById(user.getId());
        if(air_tickets!=null){
            return SUCCESS;
        }else {
            return "input";
        }

    }
}
