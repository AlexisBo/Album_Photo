<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="style/error.css" type="text/css">
</head>

<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-secondary">
	<div class="container">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbar2SupportedContent"
			aria-controls="navbar2SupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<c:choose>
			<c:when test="${utilisateur == null}">
				<a class="navbar-brand" href="/Fotoen/www/index.jsp"><i
					class="fa d-inline fa-lg fa-cloud"></i>&nbsp;<b>Fotoen</b></a>
				<div
					class="collapse navbar-collapse text-center justify-content-end"
					id="navbar2SupportedContent">
					<a href="/Fotoen/www/connexion.jsp"
						class="btn navbar-btn ml-2 text-white btn-secondary"><i
						class="fa d-inline fa-lg fa-user-circle-o"></i> Connexion</a> <a
						href="/Fotoen/www/inscription.jsp"
						class="btn navbar-btn ml-2 text-white btn-secondary">
						Inscription</a>
				</div>
			</c:when>
			<c:otherwise>
				<a class="navbar-brand" href="/Fotoen/www/accueil.jsp"><i
					class="fa d-inline fa-lg fa-cloud"></i> <b>Fotoen</b></a>
				<div
					class="collapse navbar-collapse text-center justify-content-end"
					id="navbar2SupportedContent">
					<a href="/Fotoen/www/profil.jsp"
						class="btn navbar-btn ml-2 text-white btn-secondary"><i
						class="fa d-inline fa-lg fa-user-circle-o"></i> <c:out
							value="${ utilisateur.pseudo }" /></a> <a href="deconnexion"
						class="btn navbar-btn ml-2 text-white btn-secondary">
						Déconnexion <br>
					</a>
				</div>
			</c:otherwise>
		</c:choose>

	</div>
	</nav>
	<div class="py-5 text-center bg-secondary h-100">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-12">
							<h1 class="text-light w-100 h-25" style="font-size: 100px">ERREUR...
								:(</h1>
							<p class="text-light">
								<c:out value="${ erreur }" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="bg-dark text-white py-2">
		<div class="container">
			<div class="row">
				<div class="col-md-12 mt-3 text-center">
					<p>© Copyright 2017 Fotoen - All rights reserved.</p>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
	<pingendo
		style="cursor:pointer;position: fixed;bottom: 10px;right:10px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:180px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white">By
	Fotoen 5&nbsp;&nbsp; <img
		src="https://pingendo.com/site-assets/Pingendo_logo_big.png"
		class="d-block" alt="Pingendo logo" height="16"> </pingendo>
</body>

</html>