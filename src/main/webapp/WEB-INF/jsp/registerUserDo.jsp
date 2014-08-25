<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<!-- header starts -->
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <title>dice.com : Register</title>
   <link href="<c:url value="/resources/style/style.css" />" rel="stylesheet">
 </head>
<body>
  <div id="main" style="border:0px solid red">
    <div id="links"></div>
    <div id="header" style="border:0px solid blue">
      <div id="logo" style="border:0px solid green">
        <div id="logo_text" style="border:0px solid red">
			<marquee><h1>dice<span class="alternate_colour">.com</span></h1></marquee>
        </div>
      </div>
    </div>
<!-- header ends -->
<!-- body starts -->
    <div id="site_content" style="border:0px solid green">
		<div id="content">

        <!-- insert the page content here -->
<h3> Thanks for registering us with us ${user.name}</h3>

<h3> Please login to continue <a href="login.page">click here</a></h3>

		</div>
		<div id="site_content_bottom"></div>
    </div>
<!-- body ends -->
<!-- footer starts -->
    <div id="footer">
		Copyright &copy; Shabi-Dice.com. All Rights Reserved. | 
		<a href="#">About Us</a> | 
		<a href="#">Contact Us</a> | 
	</div>
  </div>
</body>
</html>
<!-- footer ends -->		
