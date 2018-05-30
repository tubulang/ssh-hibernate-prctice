package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.TicketsDao;
import models.Booking;
import models.Users;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;

public class QueryTimeOrNameByPageAction extends ActionSupport {
    Users user;
    TicketsDao td;
    List<Booking> air_tickets;
    String query_data;

    int id;
    int pageNo=1;
    final int pageSize=5;
    int currentPage;
    int totalPage;

    public QueryTimeOrNameByPageAction(){

    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public TicketsDao getTd() {
        return td;
    }

    public void setTd(TicketsDao td) {
        this.td = td;
    }

    public List<Booking> getAir_tickets() {
        return air_tickets;
    }

    public void setAir_tickets(List<Booking> air_tickets) {
        this.air_tickets = air_tickets;
    }

    public String getQuery_data() {
        return query_data;
    }

    public void setQuery_data(String query_data) {
        this.query_data = query_data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
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

    public String execute(){
        Map map=ActionContext.getContext().getSession();
        query_data=(String)map.get("query_data");
        user=(Users) ActionContext.getContext().getSession().get("user");
        air_tickets=td.queryTicketsById(user.getId());
        //处理分页的数据
        if(air_tickets.size()%pageSize==0){
            totalPage=air_tickets.size()/pageSize;
        }else{
            totalPage=air_tickets.size()/pageSize+1;
        }
        //判断上一页下一页
        if(pageNo<=0){
            pageNo=1;
        }else if (pageNo>totalPage){
            pageNo=totalPage;
        }
        //设置当前页
        currentPage=pageNo;

        air_tickets=td.queryTimeOrNameByPage(query_data,user.getId(),
                pageNo,pageSize);

        if (air_tickets!=null){
            return SUCCESS;
        }else{
            return INPUT;
        }

    }
}
