<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <%@ page import="modele_entity.Utilisateur"%> --%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="/Projet/www/style/album_listing.css" type="text/css">
</head>

<body>
	<%
		/*Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");*/
	%>
<%-- 	<h1 class="text-light" style="font-size: 80px"><%=u.getPseudo()%></h1> --%>
	<nav class="navbar navbar-expand-md navbar-dark bg-secondary">
		<div class="container">
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbar2SupportedContent"
				aria-controls="navbar2SupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand" href="/Projet/www/accueil.jsp"><i
				class="fa d-inline fa-lg fa-cloud"></i>&nbsp;<b>Fotoen</b></a>
			<div class="collapse navbar-collapse text-center justify-content-end"
				id="navbar2SupportedContent">
				<a href="/Projet/www/connexion.jsp"
					class="btn navbar-btn ml-2 text-white btn-secondary"><i
					class="fa d-inline fa-lg fa-user-circle-o"></i> Connexion</a> <a
					href="/Projet/www/inscription.jsp"
					class="btn navbar-btn ml-2 text-white btn-secondary">
					Inscription</a>
			</div>
		</div>
	</nav>
	<div class="py-5 text-center bg-secondary">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-12">
							<h1 class="text-light" style="font-size: 80px">Vos Albums</h1>
							<p class="text-light" style="font-size: 20px">Ici, vous
								pouvez créer et consulter vos albums photos.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="bg-dark text-white py-2">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="card">
						<img class="card-img-top"
							src="https://seniors-en-vadrouille.fr/wp-content/uploads/2016/07/Ecosse.jpg"
							alt="Card image cap">
						<div class="card-body bg-dark">
							<h5 class="card-title" style="font-size: 30px">Ecosse</h5>
							<p class="card-text text-primary" style="font-size: 20px">Voyage
								en Ecosse (jj/mm/aaaa)</p>
							<a href="#" class="btn btn-primary">Consulter</a>
							<button class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown" contenteditable="true"
								style="float: right">Réglages</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">Définir dossier courant</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#"
									style="background-color: red; color: white;">Supprimer
									l'album</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="card">
						<img class="card-img-top"
							src="https://www.nationalgeographic.com/content/dam/travel/Guide-Pages/north-america/united-states/newyork/newyork_NationalGeographic_2328428.jpg"
							alt="Card image cap">
						<div class="card-body bg-dark">
							<h5 class="card-title" style="font-size: 30px">Etats-Unis</h5>
							<p class="card-text text-primary" style="font-size: 20px">Voyage
								aux Etats-Unis (jj/mm/aaaa)</p>
							<a href="#" class="btn btn-primary">Consulter</a>
							<button class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown" contenteditable="true"
								style="float: right">Réglages</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">Définir dossier courant</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#"
									style="background-color: red; color: white;">Supprimer
									l'album</a>
							</div>
						</div>
					</div>
					<div class="btn-group"></div>
				</div>
			</div>
			<div class="py-5 text-white bg-dark">
				<div class="container">
					<div class="row">
						<div class="col-md-6">
							<img class="card-img-top"
								src="https://previews.123rf.com/images/tele52/tele521106/tele52110600001/9657545-ic%C3%B4ne-de-vecteur-photo-album-xxl-.jpg"
								alt="Card image cap">
						</div>
						<div class="col-md-6">
							<h1>Ajouter un album</h1>
							<p>Remplissez tous les champs s'il vous plait.</p>
							<form>
								<div class="form-group">
									<label for="InputName">Titre</label> <input type="text"
										class="form-control" name="titre" placeholder="Votre titre">
								</div>
								<div class="form-group">
									<label for="InputEmail1">Date album</label> <input type="date"
										class="form-control" name="date_album"
										placeholder="Date de l'album">
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
				</div>
			</div>
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
	<pingendo onclick="window.open('https://pingendo.com/', '_blank')"
		style="cursor:pointer;position: fixed;bottom: 10px;right:10px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:180px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white">By Projet 5&nbsp;&nbsp; <img
		src="https://pingendo.com/site-assets/Pingendo_logo_big.png"
		class="d-block" alt="Pingendo logo" height="16"> </pingendo>
</body>

</html>