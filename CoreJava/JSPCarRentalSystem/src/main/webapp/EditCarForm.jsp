<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.neosoft.dao.*, com.neosoft.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CAR Rental System</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="main.css" />
</head>
<body>

<%
int carid=Integer.parseInt(request.getParameter("id"));

CarBean bean=CarDao.getCarById(carid);


%>
<jsp:include page="navadmin.html"></jsp:include>

<section class="bodycar">
<h3>Edit Car Details</h3>
  <form action="editcar.jsp" method="post" style="width:300px">
  <div class="form-group">
  <label for="name1">Car Id</label>
    <input type="number" class="form-control" name="id" value="<%= bean.getId() %>" readonly="readonly"/>
  </div>
  <div class="form-group">
    <label for="name1">Car Name</label>
    <input type="text" class="form-control" name="carname" value="<%= bean.getCarname() %>" placeholder="Car Name"/>
  </div>
  
  <div class="form-group">
    <label for="cartype">Car Type</label>
    <input type="text" class="form-control" name="cartype" value="<%= bean.getCartype() %>" placeholder="Car Type"/>
  </div>
  
  <div class="form-group">
    <label for="carcompany">Car Company</label>
    <input type="text" class="form-control" name="carcompany" value="<%= bean.getCarcompany() %>" placeholder="Car Company"/>
  </div>
  
  <div class="form-group">
    <label for="carcity">Car City</label>
    <input type="text" class="form-control" name="carcity" id="carcity1" value="<%= bean.getCarcity() %>" placeholder="Car Company"/>
  </div>
  
  <div class="form-group">
    <label for="carnumber">Car Number</label>
    <input type="text" class="form-control" name="carnumaber" id="carnumber1" value="<%= bean.getCarnumaber() %>" placeholder="Car number"/>
  </div>  
  <div class="form-group">
    <label for="priceperday">Price Per Day</label>
    <input type="number" class="form-control" name="priceperday" id="priceperday1" value="<%= bean.getPriceperday() %>" placeholder="price per day"/>
  </div>  
  <div class="form-group">
    <label for="carnumber">Car Availability Status</label>
    <section name="">
    
    </section>
    
    <input type="text" class="form-control" name="issustatus" value="<%= bean.getIssustatus() %>" placeholder="Availability"/>
  </div>  
  
  <div class="form-group">
    <label for="describe">Description</label><br>
    <input type="text" class="form-control" name="cardescription" id="cardescription" value="<%= bean.getCardescription() %>" placeholder="price per day"/>
    
<%--     <textarea rows="3" cols="30" name="cardescription" value="<%= bean.getCardescription() %>" id="cardescription1"></textarea> --%>
    
  </div>
  <button type="submit" class="btn btn-primary">Update</button>
  
</form>
</section>
 <jsp:include page="dashboardfooter.jsp"></jsp:include>
</body>
</html>