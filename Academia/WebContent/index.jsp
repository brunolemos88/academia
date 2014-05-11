<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ACADEMIA LP4</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style-painel.css" rel="stylesheet">
</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="brand" href="index.jsp">ACADEMIA LP4 - IFMS</a>
				<div class="nav-collapse collapse">
					<p class="navbar-text pull-right">
						Seja Bem vindo(a) <a href="#" class="navbar-link"> </a>
					</p>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid">

		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">MENU</li>
						<li><a href="index.jsp?pagina=modalidades">Modalidades</a></li>
						<li><a href="index.jsp?pagina=equipamentos">Equipamentos</a></li>
						<li><a href="index.jsp?pagina=cursos">Cursos</a></li>
					</ul>
				</div>
			</div>

			<div class="span9">
				<c:choose>
					<c:when test="${param['pagina']=='modalidades'}">
						<c:import url="paginas/modalidades.jsp"></c:import>
					</c:when>
					<c:when test="${param['pagina']=='equipamentos'}">
						<c:import url="paginas/equipamentos.jsp"></c:import>
					</c:when>
					<c:when test="${param['pagina']=='cursos'}">
						<c:import url="paginas/cursos.jsp"></c:import>
					</c:when>
					<c:otherwise>
						<c:import url="paginas/inicio.jsp"></c:import>
					</c:otherwise>
				</c:choose>
			</div>

		</div>

		<hr>


		<p>
			&copy; 2014 <strong>ACADEMIA LP4 - IFMS</strong>
		</p>
		academia@mail.com

	</div>

	<!-- CARREGA OS JAVASCRIPT DA PAGINA-->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="../js/funcoes.js"></script>

</body>
</html>