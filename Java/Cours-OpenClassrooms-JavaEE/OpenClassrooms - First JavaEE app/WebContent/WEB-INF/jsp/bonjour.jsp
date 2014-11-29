<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Page bonjour</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	
	<%-- 
		<p>Bonjour ${ !empty name ? name : '' }</p>
		<p>${ names[1] } ${ names[2] }</p>
	 --%>
	 <p><c:out value="Bonjour !" /></p>
	 <%-- 
	 	// c:out => JSTL (JSP Standard Tag Library)
	 	// ${ }  => JSP - Expression Language (EL)
	  --%>
	 <p><c:out value="${ auteur.firstName } ${ auteur.lastName }" /></p> 
	 <p><c:out value="${ auteur.actif ? 'Vous êtes actif !' : 'Vous êtes inactif !' }" /></p>
	 <p><c:out value="${ variable }" default="variable par défaut"/></p>
	 
	 <c:set target="${ auteur }" property="firstName" value="Hanounti" />
	 <p><c:out value="${ auteur.firstName } ${ auteur.lastName }" /></p>
	 
	 <c:set var="pseudo" value="doud" scope="page" /> <!-- page / request / session / application -->
	 <p><c:out value="pseudo: ${ pseudo }" /></p>
	 <c:set var="pseudo" value="Raymond" scope="page" />
	 <p><c:out value="pseudo: ${ pseudo }" /></p>
	 <c:remove var="pseudo"/>
	 <p><c:out value="pseudo: ${ pseudo }" /></p>
	 
	 <%-- Conditions JSTL --%>
	 <c:if test="${ 50 > 10 }" var="varTestScopePage" scope="request">
	 	C'est vrai
	 </c:if>
	 
	 <c:choose>
	 	<c:when test="${ varTestScopePage }">Du texte</c:when>
	 	<c:when test="${ uneAutreVariable }">Du texte</c:when>
	 	<c:otherwise>Du texte</c:otherwise>
	 </c:choose>
	 
	 <%-- Boucles JSTL --%>
	 <c:forEach var="i" begin="0" end="10" step="2">
	 	<p>Un message n°<c:out value="${ i }"></c:out></p>
	 </c:forEach>
	 <c:forEach items="${ titres }" var="titre" varStatus="status">
	 	<p>
	 		N°<c:out value="${ status.count }" /> : <c:out value="${ titre }"/>
	 		/ index = <c:out value="${ status.index }" />
	 		/ current = <c:out value="${ status.current }" />
	 		/ first = <c:out value="${ status.first }" />
	 	</p>
	 </c:forEach>
	 
	 <c:forTokens var="morceau" items="un élément/encore un élément/un dernier pour la route" delims="/">
	 	<p><c:out value="${ morceau }" /></p>
	 </c:forTokens>
</body>
</html>