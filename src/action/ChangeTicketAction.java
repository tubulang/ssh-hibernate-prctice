package action;

import bean.DBCon;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.TicketsDao;
import models.Booking;
import models.Users;
import sun.security.krb5.internal.Ticket;

import java.util.List;
import java.util.Map;

public class ChangeTicketAction extends ActionSupport {
    Booking air_ticket;
    List<Booking> air_tickets;
    TicketsDao td=new TicketsDao();
    public ChangeTicketAction(){

    }

    public List<Booking> getAir_tickets() {
        return air_tickets;
    }

    public void setAir_tickets(List<Booking> air_tickets) {
        this.air_tickets = air_tickets;
    }

    public Booking getAir_ticket() {
        return air_ticket;
    }

    public void setAir_ticket(Booking air_ticket) {
        this.air_ticket = air_ticket;
    }

    public String execute()throws Exception{
        //上下文对象
        Map m=ActionContext.getContext().getSession();
        Users c=(Users)m.get("user");
        air_ticket.setUser(c);
        //更新预定信息
        if(td.changeTicket(air_ticket)){
            System.out.println(c.getId()+"this is uid");
            //返回显示所有该用户的预定信息
            air_tickets=td.queryTicketsById(c.getId());
            return SUCCESS;
        }else{
            return "input";
        }
    }
//    public String addBooking(){
//        if(air_ticket.getName()!=null&&air_ticket.getSex()!=null&&air_ticket.getFrom_city()!=null
//                &&air_ticket.getId_card()!=null&&air_ticket.getStart_time()!=null&&air_ticket.getTo_city()!=null){
//            Map m;
//            m= ActionContext.getContext().getSession();
//            System.out.println(air_ticket.getName());
//            if(DBCon.addbooking(air_ticket)){
//                m.put("airticket",air_ticket);
//                air_tickets=DBCon.queryAirTicket();
////                System.out.print(users);
//                m.put("air_tickets", air_tickets);
//                return "success";
//            }else{
//                return "input";
//            }
//        }else{
//            return "input";
//        }
//    }
}
