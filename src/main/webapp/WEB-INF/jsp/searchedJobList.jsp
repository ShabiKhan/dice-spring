<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

     <h1> Job Search Result </h1>
       <table border="0" class="searchResults">
			<tr>
				<th>ID</th>
				<th>Job Title</th>
				<th>Employer</th>
				<th>Client</th>
				<th>Jobs Applied</th>
			</tr>

	       	<c:forEach var="job" items="${jobs}">
	       	
				<tr>
					<td><a href="#">${job.id}</a></td>
					<td>${job.jobTitle}<br></td>
					<td>${job.employer}<br></td>
					<td>${job.client}<br></td>
					<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="applied == true">
						<img align="absmiddle" src="/dice-spring/images/applied.gif" width="15px" height="15px">
					</c:if >
					</td>
				</tr>
			</c:forEach>
		</table>	



<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>