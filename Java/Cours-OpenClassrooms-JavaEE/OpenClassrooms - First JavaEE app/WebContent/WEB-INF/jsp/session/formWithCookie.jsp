<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Page bonjour</title>
</head>
<body>
	<%@ include file="../menu.jsp" %>

	<c:out value="${ firstName }"/>
	
	<form method="post" action="FormWithCookie">
		<p>
			<label for="firstName">First name: </label>
			<input type="text" id="firstName" name="firstName" />
		</p>
		<p>
			<label for="lastName">Last name: </label>
			<input type="text" id="lastName" name="lastName" />
		</p>
		<input type="submit">
	</form>
</body>
</html>