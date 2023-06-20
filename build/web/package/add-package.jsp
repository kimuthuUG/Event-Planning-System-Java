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
            <li><a href="EventServlet?action=list">Events</a></li>
            <li><a href="EventCategoryServlet?action=list">Event Categories</a></li>
            <li class="active"><a href="PackageServlet?action=list">Packages <span class="sr-only">(current)</span></a></li>
            <li><a href="UserServlet?action=list">Users</a></li>
            <li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

          <h2 class="sub-header">Add a Package</h2>
          <div class="user-form" style="width: 50%;">
            <form action="PackageServlet">
              <div class="form-group">
                <label for="txtPackageName">Package Name</label>
                <input name="txtPackageName" type="text" class="form-control" id="txtPackageName" placeholder="Enter the Package Name" required>
              </div>
              <div class="form-group">
                <label for="txtPackageCode">Package Code</label>
                <input name="txtPackageCode" type="text" class="form-control" id="txtPackageCode" placeholder="Enter the Package Code" required>
              </div>
              <div class="form-group">
                <label for="txtPackageCost">Package Cost</label>
                <input name="txtPackageCost" type="text" class="form-control" id="txtPackageCost" placeholder="Enter the Package Cost" required>
              </div>
                <button type="submit" name="action" value="addrow" class="btn btn-primary">Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>

    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>
