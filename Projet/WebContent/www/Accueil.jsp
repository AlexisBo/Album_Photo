<%-- <%@ page import="modele_entity.Media"%> --%>

<%-- <% --%>
<!--	List<Media> medias = (List<Media>) request.getAttribute("Medias"); -->
<%-- %> --%>

<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="accueil/style.css" />
<link rel="SHORTCUT ICON" href="accueil/images/3.ico" />
<!--[if lte IE 7]>
        <link rel="stylesheet" href="style_ie.css" />
        <![endif]-->
<!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<title>Accueil</title>
</head>
<body>
	<div id="page">
		<header>
			<div id="titre_principal">
				<h1>Titre</h1>
			</div>

			<nav>
				<ul>
					<li><a href="Accueil.html">Accueil</a></li>
					<li><a href="">Profil</a></li>
					<li><a href="">Dossiers</a></li>
				</ul>
			</nav>
		</header>

		<section>
			<div id="menu">
				<h1>Actualités</h1>
<%-- 				<% for (Media media : medias) { %> --%>
<!-- 					<div> -->
<%-- 						<%=media.getLibelle()%> --%>
<!-- 					</div> -->
<%-- 				<% } %> --%>
			</div>
		</section>
	</div>

</body>
</html>