package Controller;

import Models.Package;
import ModelDAO.PackageDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PackageServlet", urlPatterns = {"/PackageServlet"})
public class PackageServlet extends HttpServlet {
    
    // Get url patterns to variables
    String list="package/list-package.jsp";
    String add="package/add-package.jsp";
    String edit="package/edit-package.jsp";    
    
    Package p=new Package();
    PackageDAO dao=new PackageDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PackageServlet</title>");            
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
            String package_name=request.getParameter("txtPackageName");
            String package_code=request.getParameter("txtPackageCode");
            int package_cost=Integer.parseInt(request.getParameter("txtPackageCost"));
            p.setPackageName(package_name);
            p.setPackageCode(package_code);
            p.setPackageCost(package_cost);
            dao.add(p);
            url=list;
        }else if(action.equalsIgnoreCase("edit")){
            request.setAttribute("packageId",request.getParameter("id"));
            url=edit;
        }else if(action.equalsIgnoreCase("editrow")){
            id=Integer.parseInt(request.getParameter("txtPackageId"));
            String event_name=request.getParameter("txtPackageName");
            String event_venue=request.getParameter("txtPackageCode");
            int package_cost=Integer.parseInt(request.getParameter("txtPackageCost"));
            p.setPackageId(id);
            p.setPackageName(event_name);
            p.setPackageCode(event_venue);
            p.setPackageCost(package_cost);
            dao.edit(p);
            url=list;
        }else if(action.equalsIgnoreCase("delete")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setPackageId(id);
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