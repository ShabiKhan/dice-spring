<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
       <!-- insert the page content here -->
       
        <h1> Profile Details - </h1>
		<div class="form_settings">	
			<!-- s:iterator value="#session.diceUser"-->
			<table border="0" class="searchResults">
				<tr>
					<th>Name</th>
					<td>${user.name}<br></td>
				</tr>
				<tr>
					<th>Date of Birth</th>
					<td>${user.dob}<br></td>
				</tr>
				<tr>
					<th>Email</th>
					<td>${user.email}<br></td>
				</tr>
				<tr>
					<th>Gender</th>
					<td>${user.gender}<br></td>
				</tr>
				<tr>
					<th>Role</th>
					<td>${user.role}<br></td>
				</tr>
				<tr>
					<th>ID</th>
					<td>${user.id}<br></td>
				</tr>
				<c:choose>

					<c:when test="user.experience != null && user.skills != null">
					<tr>
						<th>Skills</th>
						<td>${user.skills}<br></td>
					</tr>
					<tr>
						<th>Experience</th>
						<td>${user.experience}<br></td>
					</tr>
					</c:when>
					<c:otherwise>
					
					<tr>
						<th>Employer</th>
						<td>${user.employer}<br></td>
					</tr>
					</c:otherwise>
				</c:choose>
			</table>
			<!--/s:iterator-->
			<br>
			</div>	
		  </div>
   
<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>