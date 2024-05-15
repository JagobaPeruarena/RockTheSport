<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Detalles del Evento</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	rel="stylesheet">
<style>
body, html {
	height: 100%;
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: column;
}

.container, .logo-section, .footer, .event-content {
	width: 100%;
}

.logo-section, .footer {
	background-color: #343a40;
	display: flex;
	justify-content: center;
	padding: 20px 0;
	color: white;
}

.event-content {
	flex: 1;
	display: flex;
	flex-direction: row;
	justify-content: space-around;
	align-items: stretch;
}

.event-description, .login-section {
	flex: 1;
	padding: 20px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	border-right: 2px solid #ccc;
}

.login-section {
	border-right: none;
}

.nav-tabs {
	width: 100%;
	display: flex;
	justify-content: center;
}

.tab-content {
	width: 100%;
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
	   <a href="PanelDeInicio2">	<img src="imagen\images.jpg" alt="Logo de Eventos Deportivos"
			style="height: 100px;"> </a>
	</div>

	<!-- Contenido de la página -->
	<div class="event-content">
		<div class="event-description">
			<h2>${edicion.eventoDeportivo.nombre}</h2>
			<p>${edicion.eventoDeportivo.descripcion}</p>
		</div>
		<div class="login-section">
			<!-- Pestañas -->
			<ul class="nav nav-tabs">
				<li class="nav-item"><a class="nav-link active" href="#signup"
					data-toggle="tab">No tengo cuenta</a></li>
				<li class="nav-item"><a class="nav-link" href="#login"
					data-toggle="tab">Tengo cuenta</a></li>
			</ul>
			<!-- Contenido de las pestañas -->
			<div class="tab-content">
				<div id="signup" class="container tab-pane active">
					<br>
					<h3>Registro</h3>
					<form action="inscripcionAgregarNuevo" var="deportista" method="post">
						<div class="form-row">
						<input type="hidden" name="edicionId" id="edicionId" value="${edicion.id}">
							<div class="col-md-6 mb-3">
								<label for="nombre">Nombre</label> <input type="text"
									class="form-control" id="addNombre" name="addNombre" required>
								<div class="valid-feedback">¡Se ve bien!</div>
							</div>
							<div class="col-md-3 mb-3">
								<label for="edad">Edad</label>
								<input type="number" class="form-control" min="1" max="110"
									id="addEdad" name="addEdad" required>

								<div class="valid-feedback">¡Se ve bien!</div>
							</div>
							<div class="col-md-3 mb-3">
								<label for="genero">Género </label> <br>
								<select class="form-select"
									id="addGenero" name="addGenero">
									<option value="" disabled>Generos</option>
									<c:forEach var="genero" items="${generos}">
										<option value="${genero.nombre}">${genero.nombre}</option>

									</c:forEach>
								</select>
								<div class="valid-feedback">¡Se ve bien!</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col-md-6 mb-3">
								<label for="email">Email</label><input type="email"
									class="form-control" id="addEmail" name="addEmail" required>

								<div class="valid-feedback">¡Se ve bien!</div>
							</div>
							<div class="col-md-3 mb-3">
								<label for="telefono">Teléfono</label> <input type="text"
								class="form-control" id="addTelefono" name="addTelefono" required>

								<div class="valid-feedback">¡Se ve bien!</div>
							</div>
							<div class="col-md-3 mb-3">
								<label for="dni">DNI</label> <input type="text"
								class="form-control" id="addDNI" name="addDNI" required>

								<div class="valid-feedback">¡Se ve bien!</div>
							</div>
						</div>
						<button class="btn btn-primary" type="submit">Registrar</button>
					</form>

				</div>

				<div id="login" class="container tab-pane fade">
					<br>
					<h3>Login</h3>
					<form action="inscripcionAgregarExistente" method="post">
					<input type="hidden" name="edicionId" id="edicionId"
								value="${edicion.id}">
						<div class="form-group">
							<label for="dni">DNI:</label> <input type="text"
								class="form-control" id="addDNI" name="addDNI">

						</div>
						<button type="submit" class="btn btn-primary">Buscar
							perfil</button>
					</form>
				</div>
			</div>
		</div>
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

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>