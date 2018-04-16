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
<link rel="stylesheet" href="/Fotoen/www/style/album_listing.css"
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
		<a class="navbar-brand" href="/Fotoen/www/accueil.jsp"><i
			class="fa d-inline fa-lg fa-cloud"></i> <b>Fotoen</b></a>
		<div class="collapse navbar-collapse text-center justify-content-end"
			id="navbar2SupportedContent">
			<a href="/Fotoen/www/profil.jsp"
				class="btn navbar-btn ml-2 text-white btn-secondary"><i
				class="fa d-inline fa-lg fa-user-circle-o"></i> <c:out
					value="${ utilisateur.pseudo }" /></a> <a href="deconnexion"
				class="btn navbar-btn ml-2 text-white btn-secondary">
				D�connexion <br>
			</a>
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
								pouvez creer, consulter et supprimer vos albums photos.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="bg-dark text-white py-2">
		<div class="container">
			<div class="row">
				<c:forEach items="${utilisateur.albums}" var="album">
					<div class="col-md-6">
						<div class="card">
							<img class="card-img-top"
								src="https://seniors-en-vadrouille.fr/wp-content/uploads/2016/07/Ecosse.jpg"
								alt="Card image cap">
							<div class="card-body bg-dark">
								<c:choose>
									<c:when test="${album['courant']}">
										<h5 class="card-title" style="font-size: 30px">
											<c:out value="${album['nom']}" />
											(Album courant)
										</h5>
									</c:when>
									<c:otherwise>
										<h5 class="card-title" style="font-size: 30px">
											<c:out value="${album['nom']}" />
										</h5>
									</c:otherwise>
								</c:choose>

								<p class="card-text text-primary" style="font-size: 20px">
									<c:out value="${album['description']}" />
								</p>
								<button class="btn btn-primary"
									id="autorisations">Autorisations</button>
								<a
									href="consulterAlbum?idUtilisateur=${utilisateur['id']}&album=${album['id']}"
									class="btn btn-primary">Consulter</a>
								<button class="btn btn-primary dropdown-toggle"
									data-toggle="dropdown" contenteditable="true"
									style="float:right">R�glages</button>
								<div class="dropdown-menu">
									<a class="dropdown-item"
										href="albumCourant?idUtilisateur=${utilisateur['id']}&album=${album['id']}">D�finir
										dossier courant</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item"
										href="albumSuppression?idUtilisateur=${utilisateur['id']}&album=${album['id']}"
										style="background-color: red; color: white;">Supprimer
										l'album</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
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
							<form method="post" action="albumAjout">
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
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 mt-3 text-center">
					<p>� Copyright 2017 Fotoen - All rights reserved.</p>
				</div>
			</div>
		</div>
	</div>

	<dialog id="AutorisationsDialog">
	<form method="dialog">
		<section>
		<p>
			<label for="favAnimal">Favorite animal:</label> <select
				id="favAnimal">
				<option></option>
				<option>Brine shrimp</option>
				<option>Red panda</option>
				<option>Spider monkey</option>
			</select>
		</p>
		</section>
		<button id="annuler" type="reset">Annuler</button>
		<button type="submit">Valider</button>
	</form>
	</dialog>

	<script type="text/javascript">
		(function() {
			var autorisations = document.getElementById('autorisations');
			var annuler = document.getElementById('annuler');
			var autorisationsDialog = document
					.getElementById('AutorisationsDialog');

			// Update button opens a modal dialog
			autorisations.addEventListener('click', function() {
				autorisationsDialog.showModal();
			});

			// Form cancel button closes the dialog box
			annuler.addEventListener('click', function() {
				autorisationsDialog.hide();
			});
		})();
	</script>
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