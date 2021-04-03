<%@ page import="java.sql.*" %>
<%@ page  session="true" %>
<link rel="stylesheet" type="text/css" href="InitialStyle.css">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home</title>

</head>

<body>


<form method="POST" action="SERVERLOGIN">
<br>
<center><h2>Party Reservation System</h2></center>

 <div class="container">
   
    <p>Please fill in this form to login.</p>
    <hr>
    <label for="email"><b>Enter Your Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>
    <label for="password"><b>Enter Your Password </b></label>
    <input type="password" placeholder="Enter password" name="password" required>
    <label for="typeofusers"><b>User Type: </b></label>
  <select name="typeofusers">

<option value="GUEST">Guest </option>
<option value="HOST">Host</option>


</select>
	
	<div class="clearfix">
      <button type="submit" name="signupbtn" class="signupbtn">Log-in</button>
    </div>
    	&nbsp;&nbsp;&nbsp; <a href="sign-up.jsp"> Sign-up </a>
    </div>


</form>


<% 
	HttpSession ses = request.getSession();
	String typeuser = "";
	String email = "";
	if(request.getAttribute("typeuser")!=null){
		typeuser = (String)request.getAttribute("typeuser");
		email = (String)request.getAttribute("email");
		if(typeuser.equals("HOST")){
			session.setAttribute("email", request.getAttribute("email"));
			session.setAttribute("typeuser", typeuser);
			response.sendRedirect("Host.jsp");
		}
		
	}
	if(request.getParameter("close") !=null){
		System.out.println("close");
		session.invalidate();
	}
%>
</body>

</html>