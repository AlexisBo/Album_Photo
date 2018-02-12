<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="style/Connexion.css" type="text/css">
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
			<a class="navbar-brand"
				href="/Album_Photo/Projet/index.html"><i
				class="fa d-inline fa-lg fa-cloud"></i>&nbsp;<b>Fotoen</b></a>
			<div class="collapse navbar-collapse text-center justify-content-end"
				id="navbar2SupportedContent">
				<a href="/Album_Photo/Projet/WebContent/www/connexion.jsp"
					class="btn navbar-btn ml-2 text-white btn-secondary"><i
					class="fa d-inline fa-lg fa-user-circle-o"></i> Connexion</a> <a
					href="/Album_Photo/Projet/WebContent/www/inscription.jsp"
					class="btn navbar-btn ml-2 text-white btn-secondary">
					Inscription</a>
			</div>
		</div>
	</nav>
	<div class="py-5 text-white opaque-overlay"
		style="background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/cover_restaurant.jpg&quot;);">
		<div class="container">
			<div class="row my-5">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<center>
						<h1 class="text-gray-dark" style="font-size: 60px">Se
							connecter</h1>
						<form class="py-3" method="post" action="https://formspree.io/">
							<div class="form-group" style="font-size: 30px">
								<label>Email address</label> <input type="email" name="email"
									class="form-control" placeholder="Enter email">
							</div>
							<div class="form-group" style="font-size: 30px">
								<label>Password</label> <input type="password" name="password"
									class="form-control" placeholder="Password">
							</div>
							<button type="submit" class="btn btn-primary"
								style="font-size: 20px">Connexion</button>
							&lt;
						</form>
					</center>
				</div>
			</div>
		</div>
	</div>
	<div class="bg-dark text-white py-0">
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
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<pingendo onclick="window.open('https://pingendo.com/', '_blank')"
		style="cursor:pointer;position: fixed;bottom: 10px;right:10px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:180px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white">By
	Projet 5&nbsp;&nbsp; <img
		src="https://pingendo.com/site-assets/Pingendo_logo_big.png"
		class="d-block" alt="Pingendo logo" height="16"> </pingendo>
</body>

</html>