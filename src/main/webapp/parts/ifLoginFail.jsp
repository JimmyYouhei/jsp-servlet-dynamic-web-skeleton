<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<c:if test= "${empty sessionScope.userSession}">
	<c:redirect url="A2Servlet">
		<c:param name="command" value="firstLogin"></c:param>
	</c:redirect>
</c:if>
	