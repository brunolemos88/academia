<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style-painel.css" rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="brand" href="/mvc/painel">ACADEMIA LP4 - IFMS</a>
				<div class="nav-collapse collapse">
					<p class="navbar-text pull-right">
						Seja Bem vindo(a) <a href="#" class="navbar-link"> </a>
					</p>
					<!-- MENU SUPERIOR
            <ul class="nav">
               <li class="active"><a href="#">Dashboard</a></li>
               <li><a href="#about">Ajuda</a></li>
               <li><a href="#contact">Contato</a></li>
             </ul>-->
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">MENU</li>
						<li><a href="painel/PedidoMusica">Modalidades</a></li>
						<li><a href="painel/Cliente">Equipamentos</a></li>
						<li><a href="painel/LandingPage">Cursos</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span9">
				<?=$pagina?>				
			</div>
			<!--/span-->
		</div>
		<!--/row-->

		<hr>

		<footer>
		<p>
			&copy; 2014 <strong>ACADEMIA LP4 - IFMS</strong>
		</p>
		academia@mail.com </footer>

	</div>
	<!--/.fluid-container-->

	<!-- CARREGA OS JAVASCRIPT DA PAGINA-->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="../js/funcoes.js"></script>

	<script src="js/bootstrap-fileupload.min.js"></script>

	<!--CARREGA O EDITOR DE TEXTO NOS TEXT AREA-->
	<script src="js/wysihtml5-0.3.0.min.js"></script>
	<script src="js/bootstrap-wysihtml5.js"></script>

</body>
</html>