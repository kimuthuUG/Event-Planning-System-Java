package Controller;

import Models.Event;
import ModelDAO.EventDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EventServlet", urlPatterns = {"/EventServlet"})
//using inheritance
public class EventServlet extends HttpServlet {
    
    // Get url patterns to variables
    String list="event/list-event.jsp";
    String add="event/add-event.jsp";
    String edit="event/edit-event.jsp";    
    
    Event ec=new Event();
    EventDAO dao=new EventDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EventServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EventServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url="";
        String action=request.getParameter("action");
        
        if(action.equalsIgnoreCase("list")){
            url=list;            
        }else if(action.equalsIgnoreCase("add")){
            url=add;
        }else if(action.equalsIgnoreCase("addrow")){
            String event_name=request.getParameter("txtEventName");
            String venue=request.getParameter("txtEventVenue");
            Date event_date=Date.valueOf(request.getParameter("dateEventDate"));
            String status=request.getParameter("chkStatus");
            int category_id=Integer.parseInt(request.getParameter("cmbCategory"));
            String description=request.getParameter("textDescription");
            
            ec.setEventName(event_name);
            ec.setVenue(venue);
            ec.setEventDate(event_date);
            ec.setStatus(status);
            ec.setCategoryId(category_id);
            ec.setDescription(description);

            dao.add(ec);
            url=list;
        }else if(action.equalsIgnoreCase("edit")){
            request.setAttribute("eventId",request.getParameter("id"));
            url=edit;
        }else if(action.equalsIgnoreCase("editrow")){
            id=Integer.parseInt(request.getParameter("txtEventId"));
            String event_name=request.getParameter("txtEventName");
            String venue=request.getParameter("txtEventVenue");
            Date event_date=Date.valueOf(request.getParameter("dateEventDate"));
            String status=request.getParameter("chkStatus");
            int category_id=Integer.parseInt(request.getParameter("cmbCategory"));
            String description=request.getParameter("textDescription");
            
            ec.setEventId(id);
            ec.setEventName(event_name);
            ec.setVenue(venue);
            ec.setEventDate(event_date);
            ec.setStatus(status);
            ec.setCategoryId(category_id);
            ec.setDescription(description);
            
            dao.edit(ec);
            url=list;
        }else if(action.equalsIgnoreCase("delete")){
            id=Integer.parseInt(request.getParameter("id"));
            ec.setEventId(id);
            dao.delete(id);
            url=list;
        }
        
        RequestDispatcher event=request.getRequestDispatcher(url);
        event.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}