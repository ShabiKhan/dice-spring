<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

 <% String errorMsg = (String)request.getAttribute("errorMsg");
        	if (errorMsg != null){
        %>		
        	<div Style="color:red"><%=errorMsg%></div>
        <%	
        	}
     %>
<h2>please post your job</h2>

<form:form method="post" action="postJob.do">
 
    <table>
    
    <tr>
        
        <td><form:label path="id">${user.id}</form:label></td>
        <td><form:hidden path="id" value="${user.id}" /></td>
            
    </tr>    
    
    <tr>
        <td><form:label path="skill">Skills</form:label></td>
        <td><form:input path="skill" /></td>
    </tr>
    <tr>
        <td><form:label path="experience">experience</form:label></td>
        <td><form:input path="experience" /></td>
    </tr>
    <tr>
        <td><form:label path="jobTitle">jobTitle</form:label></td>
        <td><form:input path="jobTitle" /></td>
    </tr>
    <tr>
        <td><form:label path="description">description</form:label></td>
        <td><form:input path="description" /></td>
    </tr>
    <tr>
        <td><form:label path="client">client</form:label></td>
        <td><form:input path="client" /></td>
    </tr>
     <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table> 
     
</form:form>




<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>