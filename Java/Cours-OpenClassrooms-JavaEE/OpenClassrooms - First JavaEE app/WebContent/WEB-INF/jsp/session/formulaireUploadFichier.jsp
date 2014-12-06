<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Page bonjour</title>
</head>
<body>
	<%@ include file="../menu.jsp" %>
	<c:if test="${ !empty fichier }">
		<c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" />
	</c:if>
	<form method="post" action="FormulaireUploadFichier" enctype="multipart/form-data">
		<p>
			<label for="description">Description du fichier : </label>
			<input type="text" name="description" id="description" />
		</p>
		<p>
			<label for="fichier">Fichier à envoyer : </label>
			<input type="file" name="fichier" id="fichier" />
		</p>
		
		<input type="submit" />
	</form>

</body>
</html>