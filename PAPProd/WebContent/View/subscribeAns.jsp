<%@ page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%
	Exception e = (Exception) request.getAttribute("erreur");
	String nomClient = request.getParameter("name");
	String emailClient = request.getParameter("email");
	String passClient = request.getParameter("pass");
	String villeClient = request.getParameter("city");
%>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>PAP</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="./style/css/bootstrap.min.css" />

	<!-- Slick -->
	<link type="text/css" rel="stylesheet" href="./style/css/slick.css" />
	<link type="text/css" rel="stylesheet" href="./style/css/slick-theme.css" />

	<!-- nouislider -->
	<link type="text/css" rel="stylesheet" href="./style/css/nouislider.min.css" />

	<!-- Font Awesome Icon -->
	<link rel="stylesheet" href="./style/css/font-awesome.min.css">

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="./style/css/style.css" />

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>
	<!-- HEADER -->
	<header>
		<!-- top Header -->
		<div id="top-header">
			<div class="container">
				<div class="pull-left">
					<span>Bienvenue sur PAP!</span>
				</div>
				<div class="pull-right">
					<ul class="header-top-links">
						<li class="dropdown default-dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">USD <i class="fa fa-caret-down"></i></a>
							<ul class="custom-menu">
								<li><a href="#">USD ($)</a></li>
								<li><a href="#">EUR (€)</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- /top Header -->

		<!-- header -->
		<div id="header">
			<div class="container">
				<div class="pull-left">
					<!-- Logo -->
					<div class="header-logo">
						<a class="logo" href="index.html">
							<img src="./style/img/logo.png" alt="">
						</a>
					</div>
					<!-- /Logo -->

					<!-- Search -->
							<div class="header-search">
						<form id="form" action="./CAppli" method="post">
							<input class="input search-input" type="text" placeholder="Entrez des mots clés" name="name">
							<input class="input search-categories" type="text" placeholder="Ville" name="city">
							<div>
							<input type="hidden" name="function" value ="search" />
							<button class="search-btn"><i class="fa fa-search"></i></button>
							</div>
						</form>
					</div>
					<!-- /Search -->
				</div>
				<div class="pull-right">
					<ul class="header-btns">
						<!-- Account -->
						<li class="header-account dropdown default-dropdown">
							<div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true">
								<div class="header-btns-icon">
									<i class="fa fa-user-o"></i>
								</div>
								<strong class="text-uppercase">compte<i class="fa fa-caret-down"></i></strong>
								<p> Rejoindre</p>
							</div>
							
							<ul class="custom-menu">
								<li><a href="./View/login.html"><i class="fa fa-user-o"></i>Se connecter</a></li>
								<!-- <li><a href="#"><i class="fa fa-heart-o"></i> My Wishlist</a></li> -->
								<!-- <li><a href="#"><i class="fa fa-exchange"></i> Compare</a></li> -->
								<!-- <li><a href="#"><i class="fa fa-check"></i> Checkout</a></li> -->
								<!-- <li><a href="#"><i class="fa fa-unlock-alt"></i> Login</a></li> -->
								<li><a href="./View/subscribe.html"><i class="fa fa-user-plus"></i>S'inscrire</a></li>
							</ul>
						</li>
						<!-- /Account -->

						

						<!-- Mobile nav toggle-->
						<li class="nav-toggle">
							<button class="nav-toggle-btn main-btn icon-btn"><i class="fa fa-bars"></i></button>
						</li>
						<!-- / Mobile nav toggle -->
					</ul>
				</div>
			</div>
			<!-- header -->
		</div>
		<!-- container -->
	</header>
	<!-- /HEADER -->

	<!-- NAVIGATION -->
	<div id="navigation">
		<!-- container -->
		<div class="container">
			<div id="responsive-nav">
				<!-- category nav -->
				<div class="category-nav show-on-click">
					<span class="category-header">acheter<i class="fa fa-list"></i></span>
					<ul class="category-list">
				
						<li><a href="./View/buy.html">tout voir</a></li>
					</ul>
				</div>
				<!-- /category nav -->

				<!-- menu nav -->
				<div class="menu-nav">
					<span class="menu-header">Menu <i class="fa fa-bars"></i></span>
					<ul class="menu-list">
						<li><a href="./View/sell.html">mettre un objet à vendre</a></li>
					</ul>
				</div>
				<!-- menu nav -->
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /NAVIGATION -->

		<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="./View/index.html">Accueil</a></li>
				<li class="active">Inscription</li>
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->

	<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
			
					<div class="col-md-6 offset-md-3">
						<div class="billing-details">
							<p>Déjà inscrit ?<a href="./View/login.html"> Connectez-vous</a></p>
							<div class="section-title">
								<h3 class="title">inscription</h3>
							</div>
								<p>
									<% if (e == null) { %>
										Le compte <span style="color: red;"><%= nomClient %></span> a bien été créé!
									<%}	else { %>
										<span style="color: red;"> Erreur, un compte avec l'adresse email <%= emailClient %> existe déjà.</span>
									<%} %>
								</p>

						</div>
						</div>

					<!-- </div> -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /section -->

	
	<!-- FOOTER -->
	<footer id="footer" class="section section-grey">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- footer widget -->
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div class="footer">
						<!-- footer logo -->
						<div class="footer-logo">
							<a class="logo" href="#">
		            <img src="./style/img/logo.png" alt="">
		          </a>
						</div>
						<!-- /footer logo -->

						<p>PAP est un site de vente entre particuliers garantissant une sécurité dans tous vos achats et vente.</p>

						<!-- footer social -->
						<ul class="footer-social">
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-instagram"></i></a></li>
							<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
						</ul>
						<!-- /footer social -->
					</div>
				</div>
				<!-- /footer widget -->

				<!-- footer widget -->
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div class="footer">
						<h3 class="footer-header">Mon compte</h3>
						<ul class="list-links">
							<li><a href="#">Compte</a></li>
							<li><a href="#">Panier</a></li>							
							<li><a href="#">Objets en vente</a></li>
							<li><a href="#">Objets vendus</a></li>
						</ul>
					</div>
				</div>
				<!-- /footer widget -->

				<div class="clearfix visible-sm visible-xs"></div>

				<!-- footer subscribe -->
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div class="footer">
						<h3 class="footer-header">Restez connectés</h3>
						<p>Entrez votre adresse e-mail pour reçevoir des notifications sur de nouveaux articles mis en ligne</p>
						<form>
							<div class="form-group">
								<input class="input" placeholder="Adresse e-mail">
							</div>
							<button class="primary-btn">Je m'abonne</button>
						</form>
					</div>
				</div>
				<!-- /footer subscribe -->
			</div>
			<!-- /row -->
			<hr>
			<!-- row -->
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<!-- footer copyright -->
					<div class="footer-copyright">
						Site réalisé par le super binôme Elisabeth MERIC & Yannis LE GUENN - Copyright 2018
					</div>
					<!-- /footer copyright -->
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</footer>
	<!-- /FOOTER -->

	<!-- jQuery Plugins -->
	<script src="./style/js/jquery.min.js"></script>
	<script src="./style/js/bootstrap.min.js"></script>
	<script src="./style/js/slick.min.js"></script>
	<script src="./style/js/nouislider.min.js"></script>
	<script src="./style/js/jquery.zoom.min.js"></script>
	<script src="./style/js/main.js"></script>

</body>

</html>
