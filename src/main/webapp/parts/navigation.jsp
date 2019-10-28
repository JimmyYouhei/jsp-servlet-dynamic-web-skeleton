<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html>
<c:url var="homePage" value="A2Servlet">
	<c:param name="command" value="backToMainPage"></c:param>
</c:url>

<c:url var="logout" value="A2Servlet">
	<c:param name="command" value="logout"></c:param>
</c:url>

<c:url var="page2" value="A2Servlet">
	<c:param name="command" value="page2"></c:param>
</c:url>

<div class="cointainer">
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="${homePage}">Welcome to my assignment 2</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="${homePage}">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="${page2}">Page 2</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="${logout}">Logout</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</div>