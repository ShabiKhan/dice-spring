<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
   <title>dice.com : My Profile</title>
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
	  <div id="menubar">
        <ul id="menu">
          <!-- put class="tab_selected" in the li tag for the selected page - to highlight which page you're on -->
          <li class="tab_selected"><a href="homePage">Home</a></li>
          <li><a href="myProfile.page">My Profile</a></li>
	       <c:choose>
				<c:when test="${user.experience != null && user.skills != null}">
					<li><a href="searchJob.page">Search Job</a></li>
				</c:when>
				<c:otherwise>
					 <li><a href="postJob.page">Post Job</a></li>
					 <li><a href="searchCandidate.page">Search Candidate</a></li>
				</c:otherwise>
			</c:choose>
          <li><a href="logOut.Do">Log Out</a></li>
        </ul>
      </div>
    </div>
    <div id="site_content" style="border:0px solid green">
      <div id="content">
        <!-- insert the page content here -->
