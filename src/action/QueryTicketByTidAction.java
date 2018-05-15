package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.TicketsDao;
import models.Booking;

import sun.security.krb5.internal.Ticket;

import java.util.List;

public class QueryTicketByTidAction extends ActionSupport {
    Booking air_ticket;
    int tid;
    TicketsDao td=new TicketsDao();

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Booking getAir_ticket() {
        return air_ticket;
    }

    public void setAir_ticket(Booking air_ticket) {
        this.air_ticket = air_ticket;
    }

    public TicketsDao getTd() {
        return td;
    }

    public void setTd(TicketsDao td) {
        this.td = td;
    }

    public QueryTicketByTidAction(){

    }

    public String execute(){
        air_ticket=td.queryTicketsByTid(tid);

        if(air_ticket!=null){
            return SUCCESS;
        }else{
            return INPUT;
        }
    }

}
