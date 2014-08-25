<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

     <h1> Candidate Search Result </h1>
       <table border="0" class="searchResults">
			<tr>
				<th>ID</th>
				<th>Experience</th>
				<th>Name</th>
				<th>Skills</th>
			</tr>
			
			     
	       	<c:forEach var="candidate" items="${candidates}">
	       	
				<tr>
					<td><a href="#">${candidate.id}</a></td>
					<td>${candidate.experience}<br></td>
					<td>${candidate.name}<br></td>
					<td>${candidate.skills}<br></td>
					<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="applied == true">
						<img align="absmiddle" src="/dice-spring/images/applied.gif" width="15px" height="15px">
					</c:if >
					</td>
				</tr>
			</c:forEach>
		</table>	

<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>