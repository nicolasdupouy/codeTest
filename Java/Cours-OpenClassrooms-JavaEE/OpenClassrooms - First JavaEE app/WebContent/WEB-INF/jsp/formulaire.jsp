<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Page bonjour</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	
	<c:if test="${ !empty ConnectionForm.result }">
		<p><c:out value="${ ConnectionForm.result }" /></p>
	</c:if>
	<form method="post" action="Formulaire">
		<p>
			<label for="login">Login</label>
			<input type="text" id="login" name="login" />
		</p>
		<p>
			<label for="password">Password</label>
			<input type="password" id="password" name="password" />
		</p>
		<input type="submit">
	</form>

</body>
</html>