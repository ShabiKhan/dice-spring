<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<!-- header starts -->
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <title>dice.com : Register</title>
   <link href="<c:url value="/resources/style/style.css" />" rel="stylesheet">
 <script>
   function selectRole() {
		var radios = document.getElementsByName("role");
		var selectedValue;
		for( i = 0; i < radios.length; i++ ) {
			if( radios[i].checked) {
				selectedValue = radios[i].value;
				//return true;
			}
		}

		if (selectedValue == 'job_seeker') {
			document.getElementById("skills").style.visibility="visible";
			document.getElementById("experience").style.visibility="visible";
			document.getElementById("employer").style.visibility="hidden";
		}
		else {
			document.getElementById("skills").style.visibility="hidden";
			document.getElementById("experience").style.visibility="hidden";
			document.getElementById("employer").style.visibility="visible";
		}
	}
  
  </script>

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

<h2>User Details</h2>
<form:form method="post" action="register.do">
 
    <table border="0">
    <tr>
        <td><form:label path="name"> Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password" /></td>
    </tr>
    <tr>
            <tr>
        <td><form:label path="conPassword">Confirm Password</form:label></td>
        <td><form:input path="conPassword" /></td>
    </tr>
    <tr>
    <tr>
        <td><form:label path="dob">Date Of Birth</form:label></td>
        <td><form:input path="dob" /></td>
    </tr>
    <tr>
    <tr>
        <td><form:label path="gender">Gender</form:label></td>
        <td><form:input path="gender" /></td>
    </tr>
    <tr>
    <tr>
		<td><form:label path="role">Role</form:label></td>
        <td>
			Job Seeker <input type="radio" name="role" value="job_seeker" onClick="selectRole()" />
			Recruiter <input type="radio" name="role" value="recruiter" onClick="selectRole()" />
		</td>
    </tr>
    <tr>
    <tr>
		<tr id="skills" style="hidden ">
        <td><form:label path="skills">Skills</form:label></td>
        <td><form:input path="skills" /></td>
    </tr>
    <tr>
    <tr>
		<tr id="experience" style="visibility:hidden">
        <td><form:label path="experience">Experience</form:label></td>
        <td><form:input path="experience" /></td>
    </tr>
    <tr>
		<tr id="employer" style="visibility:hidden">
        <td><form:label path="employer">Employer</form:label></td>
        <td><form:input path="employer" /></td>
    </tr>
    <tr>    
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table> 
     
</form:form>
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
