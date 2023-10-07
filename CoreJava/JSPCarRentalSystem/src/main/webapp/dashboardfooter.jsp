<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<footer class="footer">
	<div class="blocke">
		<div class="fblock1">
		<h3>Car Rental System</h3><br>
		<ul class="nav navbar-nav">
					<li><a href="index.html" class="active">Home</a></li>
					<li><a href="#">AboutUs</a></li>
					<li><a href="customerregisterform">Register</a></li>
					<li><a href="index.html">Login</a></li>
					
				</ul>
		</div>
		<div class="fblock1">@copy 2021 Online Car Rental System</div>
		<div class="fblock1">
		
		
					<form action="userlogin" method="post" style="width: 300px">
					<h3><b>Contact Us</b></h3>
						<div class="form-group">
							<label for="email1">Email address</label> <input type="email"
								class="form-control" id="email1" name="email"
								placeholder="Email" />
						</div>
						<div class="form-group">
							<label for="note">Note:</label> <input type="password"
								class="form-control" id="note" name="note"
								placeholder="Note text" />
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
		</div>
	</div>
	</footer>
</body>
</html>