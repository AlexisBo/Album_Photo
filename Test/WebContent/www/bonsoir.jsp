<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8" />
<title>Bonsoir</title>
</head>
<body>
	<form method="post" action="bonsoir">
		<p>
			<label for="nom">Nom : </label> <input type="text" name="nom"
				id="nom" />
		</p>
		<p>
			<label for="prenom">Prénom : </label> <input type="text"
				name="prenom" id="prenom" />
		</p>

		<input type="submit" />
	</form>

	<ul>
		<c:forEach var="utilisateur" items="${ utilisateurs }">
			<li><c:out value="${ utilisateur.prenom }" /> <c:out
					value="${ utilisateur.nom }" /></li>
		</c:forEach>
	</ul>
</body>
</html>