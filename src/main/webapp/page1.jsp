<%@ include file="parts/ifLoginFail.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="parts/header.jsp" %>

<title>HomePage</title>
</head>
<body class="bg-secondary">
	<%@ include file = "parts/navigation.jsp"%>
	<div class="container">
		<h1 class="text-info text-center font-weight-bold">Hi ${sessionScope.userSession.username} this is the main page</h1>
	</div>
<%@ include file ="parts/footer.jsp" %>
</body>
</html>