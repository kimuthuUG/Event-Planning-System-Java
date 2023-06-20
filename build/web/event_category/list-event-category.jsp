<%@page import="java.util.Iterator"%>
<%@page import="Models.EventCategory"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.EventCategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Event Planning System</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom styles -->
    <link href="../css/dashboard.css" rel="stylesheet">

  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Event Planning System</a>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="admin.jsp">Home</a></li>
            <li><a href="EventServlet?action=list">Events</a></li>
            <li class="active"><a href="EventCategoryServlet?action=list">Event Categories <span class="sr-only">(current)</span></a></li>
            <li><a href="PackageServlet?action=list">Packages</a></li>
            <li><a href="UserServlet?action=list">Users</a></li>
            <li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <div class="flex" style="display: flex; gap: 24px; align-items: center;">
            <h2 class="sub-header">Event Categories</h2>
            <button type="button" class="btn btn-success" style="max-height: 35px;"><a href="EventCategoryServlet?action=add"><i class="fa fa-plus" aria-hidden="true"></i></a></button>
          </div>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Name</th>
                  <th>Description</th>
                  <th class="text-center">Modify</th>
                </tr>
              </thead>
              <%
                EventCategoryDAO dao=new EventCategoryDAO();
                List<EventCategory>list=dao.list_array();
                Iterator<EventCategory>iter=list.iterator();
                EventCategory ec=null;
                while(iter.hasNext()){
                    ec=iter.next();
                    
              %>
              <tbody>
                <tr>
                  <td><%= ec.getCategoryName()%></td>
                  <td><%= ec.getCategoryDesc()%></td>
                  <td class="text-center">
                    <a class="btn btn-warning" href="EventCategoryServlet?action=edit&id=<%= ec.getCategoryId()%>">Edit</a>
                    <a class="btn btn-danger" href="EventCategoryServlet?action=delete&id=<%= ec.getCategoryId()%>">Delete</a>
                  </td>
                </tr>
                <%}%>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>
