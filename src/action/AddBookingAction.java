package action;
import bean.Booking;
import bean.Booking.*;
import bean.DBCon;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;
import java.util.Map;

public class AddBookingAction {
    Booking air_ticket;
    List<Booking> air_tickets;
    public AddBookingAction(){

    }
    public Booking getAir_ticket() {
        return air_ticket;
    }

    public void setAir_ticket(Booking air_ticket) {
        this.air_ticket = air_ticket;
    }

    public String addBooking(){
        if(air_ticket.getName()!=null&&air_ticket.getSex()!=null&&air_ticket.getFrom_city()!=null
                &&air_ticket.getId_card()!=null&&air_ticket.getStart_time()!=null&&air_ticket.getTo_city()!=null){
            Map m;
            m= ActionContext.getContext().getSession();
            System.out.println(air_ticket.getName());
            if(DBCon.addbooking(air_ticket)){
                m.put("airticket",air_ticket);
                air_tickets=DBCon.queryAirTicket();
//                System.out.print(users);
                m.put("air_tickets", air_tickets);
                return "success";
            }else{
                return "input";
            }
        }else{
            return "input";
        }
    }
}
