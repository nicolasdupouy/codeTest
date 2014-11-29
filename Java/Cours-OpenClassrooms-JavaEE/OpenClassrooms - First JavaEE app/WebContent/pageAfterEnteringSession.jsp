<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Page bonjour</title>
</head>
<body>
	<p>Vous êtes sur pageAfterEnteringSession.jsp</p>
	
	<c:if test="${ !empty sessionScope.firstName && !empty sessionScope.lastName }">
		<c:out value="Vous êtes ${ sessionScope.firstName } ${ sessionScope.lastName }"></c:out>
	</c:if>

</body>
</html>