<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
<h2>please enter your search criteria</h2>
<form:form method="post" action="searchCandidate.do">
 
    <table>
    <tr>
        <td><form:label path="skills">Skills</form:label></td>
        <td><form:input path="skills" /></td>
    </tr>
    
    <tr>
        <td colspan="2">
            <input type="submit" value="Search Candidate"/>
        </td>
    </tr>
</table> 
     
</form:form>
   
<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>