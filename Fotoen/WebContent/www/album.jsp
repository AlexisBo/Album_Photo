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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="/Fotoen/www/style/album_listing.css"
	type="text/css">
<link rel="stylesheet" href="/Fotoen/www/style/connect_commun.css"
	type="text/css">
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
		<a class="navbar-brand" href="accueil?idUtilisateur=${utilisateur['id']}"><i
			class="fa d-inline fa-lg fa-cloud"></i> <b>Fotoen</b></a>
		<div class="collapse navbar-collapse text-center justify-content-end"
			id="navbar2SupportedContent">
			<a href="profil?idUtilisateur=${utilisateur['id']}"
				class="btn navbar-btn ml-2 text-white btn-secondary"><i
				class="fa d-inline fa-lg fa-user-circle-o"></i> <c:out
					value="${ utilisateur.pseudo }" /></a>
			<button style="color: white;" onclick="album_show();"
				class="btn navbar-btn ml-2 text-white btn-secondary material-icons">&#xe2cc;</button>
			<button style="color: white;"
				class="btn navbar-btn ml-2 text-white btn-secondary material-icons">&#xe439;</button>

			<a href="deconnexion"
				class="btn navbar-btn ml-2 text-white btn-secondary">Déconnexion</a>
		</div>
	</div>
	</nav>
	<div class="py-5 text-center bg-secondary">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="mb-4 text-white">Vos Medias</h1>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${album.medias}" var="media">
					<div class="col-md-3 col-6 p-1">
						<a
							href="consulterMedia?idUtilisateur=${utilisateur['id']}&media=${media['id']}">
							<img class="d-block img-fluid" src="${media['lien']}">
						</a>
					</div>
				</c:forEach>
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

	<div id="popAlbum" class="popCSS">
		<div id="popupForm">
			<form method="post" action="albumAjout">
				<img id="close"
					src="https://icon-icons.com/icons2/936/PNG/512/cross-mark-on-a-black-circle-background_icon-icons.com_73605.png"
					width="40px" onclick="album_hide();">

				<h2>Ajouter un album</h2>
				<input class="form-control" type="hidden"
					value="${utilisateur['id']}" name="idUtilisateur">
				<div class="form-group">
					<label for="InputName">Titre</label> <input type="text"
						class="form-control" name="titre" placeholder="Votre titre">
				</div>
				<div class="form-group">
					<label for="Textarea">Description</label>
					<textarea class="form-control" name="description" rows="3"
						placeholder="Ecrivez ici"></textarea>
				</div>
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</form>
		</div>
	</div>

	<div id="popMedia" class="popCSS">
		<div id="popupForm">
			<form method="post" action="mediaAjout">
				<img id="close"
					src="https://icon-icons.com/icons2/936/PNG/512/cross-mark-on-a-black-circle-background_icon-icons.com_73605.png"
					width="40px" onclick="media_hide();">

				<h2>Ajouter un media</h2>
				<input class="form-control" type="hidden"
					value="${utilisateur['id']}" name="idUtilisateur">
				<div class="form-group">
					<input type="file" name="media" accept="image/*">
				</div>
				<div class="form-group">
					<label for="Textarea">Description</label>
					<textarea class="form-control" name="description" rows="3"
						placeholder="Ecrivez ici"></textarea>
				</div>
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</form>
		</div>
	</div>

	<script src="/Fotoen/www/js/connect_commun.js" type="text/javascript"></script>
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