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

public class AddBookingAction extends ActionSupport {
    Booking air_ticket;
    List<Booking> air_tickets;
    TicketsDao td=new TicketsDao();

    private int id; //界面显示数据的索引
    private final int pageSize=5; //每页显示记录的个数
    private int pageNo=1; //计数器,从第1页开始显示
    private int currentPage; //当前页
    private int totalPage; //总页数
    public AddBookingAction(){

    }
    public TicketsDao getTd() {
        return td;
    }

    public void setTd(TicketsDao td) {
        this.td = td;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
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
        Map m=ActionContext.getContext().getSession();
        Users c=(Users)m.get("user");
        System.out.println(c.getName());
        System.out.println(air_ticket.getSex());
        System.out.println(c.getId());
        air_ticket.setUid(c.getId());
        air_ticket.setUser(c);
        if(td.addTicket(air_ticket)>0){
            System.out.println(air_ticket.getUid()+"this is uid");
            air_tickets=td.queryTicketsById(air_ticket.getUid());
            //分页显示
            if(air_tickets.size()%pageSize==0){
                totalPage=air_tickets.size()/pageSize;
            }else{
                totalPage=air_tickets.size()/pageSize+1;
            }
            if(pageNo<=0){
                pageNo=1;
            }else if(pageNo>totalPage){
                pageNo=totalPage;
            }
            //根据当前页查询要在该页上显示的数据
            air_tickets=td.queryByPage(c.getId(),pageNo,pageSize);
            //设置当前页
            currentPage=pageNo;


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
