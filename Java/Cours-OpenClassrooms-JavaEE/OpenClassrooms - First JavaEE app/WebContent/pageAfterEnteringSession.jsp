<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Page bonjour</title>
</head>
<body>
	<p>Vous �tes sur pageAfterEnteringSession.jsp</p>
	
	<c:if test="${ !empty sessionScope.firstName && !empty sessionScope.lastName }">
		<c:out value="Vous �tes ${ sessionScope.firstName } ${ sessionScope.lastName }"></c:out>
	</c:if>

</body>
</html>