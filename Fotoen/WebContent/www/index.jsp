<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="/Fotoen/www/style/index.css"
	type="text/css">
</head>

<body class="bg-light">
	<nav class="navbar navbar-expand-md navbar-dark bg-secondary">
		<div class="container">
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbar2SupportedContent"
				aria-controls="navbar2SupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand" href="/Fotoen/www/index.jsp"><i
				class="fa d-inline fa-lg fa-cloud"></i>&nbsp;<b>Fotoen</b></a>
			<div class="collapse navbar-collapse text-center justify-content-end"
				id="navbar2SupportedContent">
				<a href="/Fotoen/www/connexion.jsp"
					class="btn navbar-btn ml-2 text-white btn-secondary"><i
					class="fa d-inline fa-lg fa-user-circle-o"></i> Connexion</a> <a
					href="/Fotoen/www/inscription.jsp"
					class="btn navbar-btn ml-2 text-white btn-secondary">
					Inscription</a>
			</div>
		</div>
	</nav>
	<div class="text-center h-100 py-5 opaque-overlay"
		style="background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/cover_event.jpg&quot;);">
		<div class="container py-5">
			<div class="row">
				<div class="col-md-12 text-white py-5">
					<h1 class="mb-4 display-2 text-dark">
						<b>Bienvenue sur Fotoen !</b>
					</h1>
					<p style="font-size: 25px;" class="py-3 text-dark">
						Fotoen est un site d'album media permettant de partager ses medias
						avec ses amis. <br>Pour commencer, connectez-vous ou
						inscrivez-vous en cliquant ci-dessous.
					</p>
					<center>
						<a href="/Fotoen/www/connexion.jsp"
							class="btn btn-lg btn-secondary mx-3">Connexion</a> <a
							href="/Fotoen/www/inscription.jsp"
							class="btn btn-lg btn-primary my-5">Inscription</a>
					</center>
				</div>
			</div>
		</div>
	</div>
	<div class="bg-dark text-white py-2">
		<div class="container">
			<div class="row">
				<div class="col-md-12 mt-3 text-center">
					<p>� Copyright 2017 Fotoen - All rights reserved.</p>
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