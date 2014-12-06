<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Page SQL with a DAO in JDBC</title>
</head>
<body>
	<%@ include file="../menu.jsp" %>

	<c:if test="${ !empty error }"><p style="color:red;"><c:out value="${ error }" /></p></c:if>
	<form method="post" action="SQLWithDao">
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
	
	<ul>
		<c:forEach var="utilisateur" items="${ utilisateurs }">
			<li><c:out value="${ utilisateur.firstName }"/> <c:out value="${ utilisateur.lastName }"/></li>
		</c:forEach>
	</ul>
</body>
</html>