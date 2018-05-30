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
    private TicketsDao td;

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
        air_tickets=td.queryByPage(user.getId(),pageNo,pageSize);
        //设置当前页
        currentPage=pageNo;

        if(air_tickets!=null){
            return SUCCESS;
        }else {
            return "input";
        }

    }
}
