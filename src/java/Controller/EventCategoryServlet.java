package Controller;

import Models.EventCategory;
import ModelDAO.EventCategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EventCategoryServlet", urlPatterns = {"/EventCategoryServlet"})
public class EventCategoryServlet extends HttpServlet {
    
    // Get url patterns to variables
    String list="event_category/list-event-category.jsp";
    String add="event_category/add-event-category.jsp";
    String edit="event_category/edit-event-category.jsp";    
    
    EventCategory ec=new EventCategory();
    EventCategoryDAO dao=new EventCategoryDAO();
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
            String category_name=request.getParameter("txtCategoryName");
            String category_desc=request.getParameter("txtCategoryDesc");
            ec.setCategoryName(category_name);
            ec.setCategoryDesc(category_desc);
            dao.add(ec);
            url=list;
        }else if(action.equalsIgnoreCase("edit")){
            request.setAttribute("categoryId",request.getParameter("id"));
            url=edit;
        }else if(action.equalsIgnoreCase("editrow")){
            id=Integer.parseInt(request.getParameter("txtCategoryId"));
            String event_name=request.getParameter("txtCategoryName");
            String event_venue=request.getParameter("txtCategoryDesc");
            ec.setCategoryId(id);
            ec.setCategoryName(event_name);
            ec.setCategoryDesc(event_venue);
            dao.edit(ec);
            url=list;
        }else if(action.equalsIgnoreCase("delete")){
            id=Integer.parseInt(request.getParameter("id"));
            ec.setCategoryId(id);
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