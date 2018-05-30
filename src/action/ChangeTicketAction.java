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
    TicketsDao td;

    private int id; //界面显示数据的索引
    private final int pageSize=5; //每页显示记录的个数
    private int pageNo=1; //计数器,从第1页开始显示
    private int currentPage; //当前页
    private int totalPage; //总页数

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
