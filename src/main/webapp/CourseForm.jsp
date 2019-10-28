<%@ include file="parts/ifLoginFail.jsp" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="parts/header.jsp" %>
<title>Course Form Page</title>
</head>

<c:url var="backToMainPage" value="A2Servlet">
	<c:param name="command" value="backToMainPage"></c:param>
</c:url>

<body class="bg-secondary">

<div class="container">
	<h1 class="text-info text-center font-weight-bold">Course Form Page</h1>
	<hr>
	
	<form action="CourseValidation" method="post">
	
		
		<table class="table table-bordered table-dark">
			<tbody>
				<tr>
					<td scope="row"><label>Full Name</label></td>
					<td><input type="text" name="fullName" value="${fullName}"/></td>
					
					<c:if test="${fullNameError}">
						<td><p>Name cannot be null or contain Number</p></td>
					</c:if>
					
				</tr>
				
				<tr>
					<td scope="row"><label>Age</label></td>
					<td><input type="number" name="age" value="${age}"/></td>
					<c:if test="${ageError}">
						<td><p>Age must be >18 and <40 </p></td>
					</c:if>
				</tr>
				

				<tr>
					<td scope="row"><label>Nation</label></td>
					<td>
					
						<select name="nation">
							<option value=""></option> 
							<option value="Vietnam">Vietnam</option>
							<option value="US">US</option>
							<option value="UK">UK</option>
							<option value="China">China</option>
							<option value="France">France</option>
						</select>
					</td>
					
					<c:if test="${nationError}">
						<td><p>Please properly choose</p></td>
					</c:if>
					
				</tr>
				
				
				<tr>
					<td scope="row"><label>Course</label></td>
					<td>
						<select name="courses" multiple="multiple">
							<option value="C#">C#</option>
							<option value="Java">Java</option>
							<option value="C++">C++</option>
							<option value="Python">Python</option>
							<option value="Ruby">Ruby</option>
						</select>
					</td>
					
					<c:if test="${courseError}">
						<td><p>Please choose at least 1 course</p></td>
					</c:if>
					
				</tr>
				
				<tr>
					<td scope="row"><label>Language you want to learn</label></td>
					<td>
					
						<input type="checkbox" name="languages" value="Vietnamese"> Vietnamese </input>
						<input type="checkbox" name="languages" value="English">English</input>
						<input type="checkbox" name="languages" value="French">French</input>
					</td>
					
					<c:if test="${languageError}">
						<td><p>Please choose at least 1 language</p></td>
					</c:if>
					
				</tr>
				
				<tr>
					<td scope="row"></td>
					<td>
						<button type="submit">Submit</button>
						<a href="${backToMainPage}"><button type="button">Cancel</button></a>
					</td>
				</tr>
				
			</tbody>
		</table>
	</form>
	
	<%@ include file ="parts/footer.jsp" %>
</div>
</body>
</html>

