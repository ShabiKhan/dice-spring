<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
<h2>please enter your search criteria</h2>
<form:form method="post" action="searchJob.do">
 
    <table>
    <tr>
        <td><form:label path="skills">Skills</form:label></td>
        <td><form:input path="skills" /></td>
    </tr>
    <tr>
       
        <td><form:hidden path="userId" value="${user.id}" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table> 
     
</form:form>
   
<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>