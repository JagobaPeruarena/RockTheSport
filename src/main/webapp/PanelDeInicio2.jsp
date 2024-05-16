<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Landing Page de Eventos Deportivos</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<style>
body, html {
	height: 100%;
	margin: 0;
	padding: 0;
	background-color: #f8f9fa;
}

.logo-section {
	width: 100%;
	background-color: #343a40;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 20px 0;
}

.logo-section img {
	height: 100px;
}

.main-content {
	height: 78%;
	display: flex;
	justify-content: center;
	padding: 20px;
	background-color: cyan; /* For browsers that do not support gradients */
	background-image: linear-gradient(to right, cyan, white);
	width: 100%;
}

.card {
	margin: 10px;
	border: none;
	border-radius: 15px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.card h5 {
	font-size: 1.25rem;
}

.card p {
	font-size: 1rem;
}

.footer {
	background-color: #343a40;
	color: #fff;
	padding: 10px 0;
	width: 100%;
	position: relative;
	bottom: 0;
}
</style>
</head>
<body>

	<!-- Sección del logo con fondo -->
	<div class="logo-section">
		<a href="PanelDeInicio1"><img src="imagen/images.jpg" alt="Logo de Eventos Deportivos"></a>
	</div>

	<!-- Mensajes de alerta -->
	<c:if test="${msg.equals('inscrito')}">
		<div class="alert alert-success alert-dismissible fade show" role="alert">
			<strong>Datos Correctos:</strong> Inscripcion realizada correctamente
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<c:if test="${msg.equals('error')}">
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
			<strong>Datos Incorrectos:</strong> Error al realizar la inscripcion
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>


	<!-- Contenido de la Landing Page -->
	<div id="carouselEventos" class="carousel slide main-content" data-ride="carousel" data-interval="3000">
		<ol class="carousel-indicators">
			<c:forEach items="${ediciones}" var="edicion" varStatus="status">
				<li data-target="#carouselEventos" data-slide-to="${status.index}" class="${status.first ? 'active' : ''}"></li>
			</c:forEach>
		</ol>
		<div class="carousel-inner">
			<c:forEach items="${ediciones}" var="edicion" varStatus="status">
				<div class="carousel-item ${status.first ? 'active' : ''}">
					<div class="card">
						<div class="card-body text-center">
							<h2 class="card-title">${edicion.eventoDeportivo.nombre}</h2>
							<img src="imagen/${edicion.eventoDeportivo.tipoDeporte.id}.jpg" alt="Logo de Eventos Deportivos" width="1000" height="453">
							<p><strong>Fecha:</strong> ${edicion.fecha}</p>
							<a href="PanelDeInicio3?edicionId=${edicion.id}" class="btn btn-primary">Inscribirse</a>
						</div>
					</div>

				</div>
			</c:forEach>
		</div>
		<a class="carousel-control-prev" href="#carouselEventos" role="button" data-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="carousel-control-next" href="#carouselEventos" role="button" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

	<!-- Footer -->
	<footer class="footer text-center">
		<div class="container">
			<span>&copy; 2024 Eventos Deportivos</span>
			<div class="social-icons mt-2">
				<a href="#" class="social-icon"><i class="fab fa-facebook-f"></i> RockTheSport</a>
				<a href="#" class="social-icon"><i class="fab fa-twitter"></i> RockTheSport</a>
				<a href="#" class="social-icon"><i class="fab fa-instagram"></i> RockTheSport</a>
			</div>
		</div>
	</footer>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
