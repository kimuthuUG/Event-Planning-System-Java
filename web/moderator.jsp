<%@page import="java.util.Iterator"%>
<%@page import="Models.Event"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.EventDAO"%>
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
    <link href="css/dashboard.css" rel="stylesheet">

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
            <li class="active"><a href="admin.jsp">Home <span class="sr-only">(current)</span></a></li>
            <li><a href="EventServlet?action=list">Events</a></li>
            <li><a href="EventCategoryServlet?action=list">Event Categories</a></li>
            <li><a href="PackageServlet?action=list">Packages</a></li>
            <li><a href="UserServlet?action=list">Users</a></li>
            <li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>

          <div class="container">
              <div class="row">
                  <div class="col-lg-3 col-sm-6">
                      <div class="card-box bg-blue">
                          <div class="inner">
                              <h3> Events </h3>
                          </div>
                          <div class="icon">
                              <i class="fa fa-calendar" aria-hidden="true"></i>
                          </div>
                          <a href="EventServlet?action=list" class="card-box-footer">View More<i class="fa fa-arrow-circle-right"></i></a>
                      </div>
                  </div>

                  <div class="col-lg-3 col-sm-6">
                      <div class="card-box bg-green">
                          <div class="inner">
                              <h3> Packages</h3>
                          </div>
                          <div class="icon">
                              <i class="fa fa-bell" aria-hidden="true"></i>
                          </div>
                          <a href="PackageServlet?action=list" class="card-box-footer">View More <i class="fa fa-arrow-circle-right"></i></a>
                      </div>
                  </div>
              </div>
          </div>
          <h2 class="sub-header">Events</h2>
          
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Name</th>
                  <th>Venue</th>
                  <th>Date</th>
                  <th>Status</th>
                  <th>Category</th>
                </tr>
              </thead>
              <%
                EventDAO dao=new EventDAO();
                List<Event>list=dao.list_array();
                Iterator<Event>iter=list.iterator();
                Event ev=null;
                while(iter.hasNext()){
                    ev=iter.next();
                    
              %>
              <tbody>
                <tr>
                  <td><%= ev.getEventName()%></td>
                  <td><%= ev.getVenue()%></td>
                  <td><%= ev.getEventDate()%></td>
                  <td><%= ev.getStatus()%></td>
                  <td><%= ev.getCategoryId()%></td>
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

