<%@page import="Models.Event"%>
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
            <li class="active"><a href="EventServlet?action=list">Events <span class="sr-only">(current)</span></a></li>
            <li><a href="EventCategoryServlet?action=list">Event Categories</a></li>
            <li><a href="PackageServlet?action=list">Packages</a></li>
            <li><a href="UserServlet?action=list">Users</a></li>
            <li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

          <h2 class="sub-header">Edit Event</h2>
          <div class="user-form" style="width: 50%;">
              <%
              EventDAO dao=new EventDAO();
              int id=Integer.parseInt((String)request.getAttribute("eventId"));
              Event ev=(Event)dao.list(id);
              %>
            <form>
              <div class="form-group">
                <label for="eventName">Event Name</label>
                <input value="<%= ev.getEventName()%>"  name="txtEventName" type="text" class="form-control" id="txtEventName" placeholder="Enter the Event Name" required>
              </div>
              <div class="form-group">
                <label for="txtEventVenue">Venue</label>
                <input value="<%= ev.getVenue()%>" name="txtEventVenue" type="text" class="form-control" id="txtEventVenue" placeholder="Enter the Venue" required>
              </div>
              <div class="form-group">
                <label for="dateEventDate">Event Date</label>
                <input value="<%= ev.getEventDate()%>" name="dateEventDate" type="date" class="form-control" id="dateEventDate" placeholder="Enter the Date" required>
              </div>
              <div class="form-group">
                  <label for="cmbCategory">Event Category</label>
                  <select name="cmbCategory" class="form-control" required>
                      <option value="1">Event Category 1</option>
                      <option value="2">Event Category 2</option>
                      <option value="3">Event Category 3</option>
                  </select>   
              </div>
              <div class="form-group">
                <label for="textDescription">Description</label>
                <textarea name="textDescription" type="date" class="form-control" id="textDescription" placeholder="Enter Description" required><%= ev.getDescription()%></textarea>
              </div>  
              <div class="form-group">
                  <label for="chkStatus">Status</label>
                  <select name="chkStatus" class="form-control" required>
                      <option value="Active">Active</option>
                      <option value="Inactive">Inactive</option>
                  </select>   
              </div>
                <input type="hidden" name="txtEventId" value="<%= ev.getEventId()%>">
                <button type="submit" name="action" value="editrow" class="btn btn-primary">Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>

    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>