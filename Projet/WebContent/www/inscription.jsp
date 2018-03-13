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
<link rel="stylesheet" href="/Projet/www/style/inscription.css"
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
	<div class="py-5"
		style="background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/form_red.jpg&quot;);">
		<div class="container">
			<div class="row">
				<div class="align-self-center col-md-6 text-white">
					<h1 class="text-center text-md-left display-3">Inscription</h1>
					<p class="lead">Veuillez vous incrire avec le formulaire à
						droite</p>
				</div>
				<div class="col-md-6" id="book">
					<div class="card">
						<div class="card-body p-5">
							<h3 class="pb-3">Inscrivez-vous</h3>
							<form method="post" action="albums">
								<input class="form-control" type="hidden" value="inscription"
									name="operation">
								<div class="form-group">
									<label>Pseudo</label> <input class="form-control"
										placeholder="Votre pseudo" name="pseudo">
								</div>
								<div class="form-group">
									<label>Mot de passe</label> <input class="form-control"
										placeholder="Mot de passe" name="mdp" type="password">
								</div>
								<div class="form-group">
									<label>Confirmation mot de passe</label> <input
										class="form-control" placeholder="confirmer mmot de passe"
										name="mdpConfirmation" type="password">
								</div>
								<div class="form-group">
									<label>Adresse e-mail</label> <input class="form-control"
										placeholder="Votre e-mail" name="email">
								</div>
								<div class="form-group">
									<label>Numéro de téléphone</label> <input
										class="form-control"
										placeholder="Votre numéro de téléphone" name="telephone">
								</div>
								<div class="form-group">
									<label>Date de naissance</label> <input type="date"
										class="form-control" name="dateNaissance">
								</div>
								<button type="submit" class="btn mt-2 btn-outline-dark">S'inscrire</button>
							</form>
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
	<pingendo onclick="window.open('https://pingendo.com/', '_blank')"
		style="cursor:pointer;position: fixed;bottom: 10px;right:10px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:180px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white">By
	Projet 5&nbsp;&nbsp; <img
		src="https://pingendo.com/site-assets/Pingendo_logo_big.png"
		class="d-block" alt="Pingendo logo" height="16"></pingendo>
</body>

</html>