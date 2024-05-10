
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Landing Page de Eventos Deportivos</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	rel="stylesheet">
<style>
body, html {
	height: 100%;
}

.container {
	min-height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	align-items: center;
	padding-bottom: 50px;
}

.logo-section {
	width: 100%;
	background-color: #343a40;
	display: flex;
	justify-content: center;
	padding: 20px 0;
}

.navbar-brand img {
	height: 100px;
}

.event-box {
	width: 200px;
	margin: 10px;
	padding: 10px;
	border: 1px solid #ccc;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	margin-top: 60px;
}

.social-icon {
	color: white;
	text-decoration: none;
	margin: 0 10px;
}
</style>
</head>
<body>

	<!-- Sección del logo con fondo -->
	<div class="logo-section">
		<a href="PanelDeInicio1"><img src="imagen\images.jpg"
			alt="Logo de Eventos Deportivos" style="height: 100px;"></a>
	</div>

	<!-- Contenido de la Landing Page -->
	<div class="d-flex justify-content-center flex-wrap">
		<c:forEach items="${ediciones}" var="edicion">
		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">${edicion.eventoDeportivo.nombre}</h5>
				<p class="card-text">Fecha:<p> ${edicion.fecha}</p>
				<a href="PanelDeInicio3?edicionId=${edicion.id}" class="btn btn-primary">Inscribirse</a>
				
			</div>
		</div>
		</c:forEach>
	</div>

	<!-- Footer -->
	<footer class="footer py-3 bg-dark text-white fixed-bottom">
		<div class="container text-center">
			<span>&copy; 2024 Eventos Deportivos</span>
			<div class="social-icons">
				<a href="#" class="social-icon"><i class="fab fa-facebook-f"></i>
					RockTheSport</a> <a href="#" class="social-icon"><i
					class="fab fa-twitter"></i> RockTheSport</a> <a href="#"
					class="social-icon"><i class="fab fa-instagram"></i>
					RockTheSport</a>
			</div>
		</div>
	</footer>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
