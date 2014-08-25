<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
<h1> Job Posted </h1>
       
       <table border="0" class="searchResults">
       		       
			<tr>
				<th>ID</th>
				<th>Job Title</th>
				<th>Employer</th>
				<th>Client</th>
				<th>Jobs Applied</th>
			</tr>
	       	<c:forEach items="${job}" var="job">
				<tr>
					<!-- td><a href="/dice.com/secure/servlets/JobDetailsServlet?job=${job.jobId}"> ${job.jobId}</a></td-->
					<td>${job.jobTitle}</td>
					<td>${job.experience}</td>
					<td>${job.client}</td>
					<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="${job.applied == true}">
						<img align="absmiddle" src="/dice.com/images/applied.gif" width="15px" height="15px">
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>	


<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>