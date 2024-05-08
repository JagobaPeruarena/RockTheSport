
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Panel de Control de Base de Datos</title>
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
}

.navbar {
	background-color: #222;
	border-bottom: 2px solid #0c4a6e; /* Acento azul */
}

.navbar-brand img {
	height: 30px;
	width: auto;
}

.nav-link {
	color: #fff;
}

.container-fluid {
	padding-top: 50px;
}

.sidebar {
	background-color: #222;
	color: #fff;
	height: 100%;
	width: 250px;
	position: fixed;
	top: 50px;
	left: 0;
	overflow-x: hidden;
	padding-top: 20px;
}

.main-content {
	margin-left: 250px;
	padding: 20px;
}

table {
	width: 100%;
	margin-bottom: 1rem;
	color: #fff;
}

td {
	border: 1px solid #666;
	padding: 0.5rem;
	text-align: center;
	color: black;
}

th {
	background-color: #222;
	border: 1px solid #666;
	padding: 0.5rem;
	text-align: center;
}

.btn-custom {
	background-color: #0688B4; /* Azul personalizado */
	border-color: #0688B4;
	color: #fff;
}
</style>
</head>

<body>
	<%@ include file="/partes/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/partes/sidebar.jsp"%>

			<!-- ï¿½rea central para listar elementos -->
			<div class="col-md-9 main-content">
				<!-- Tabla de información de la tabla seleccionada -->
				<h2>Ciudad</h2>
				<div class="container">
					<p>ID: ${ciudad.id}</p>
					<p>Nombre: ${ciudad.nombre}</p>
					<p>Ubicación Geográfica: ${ciudad.ubicacionGeografica}</p>
					<p>Población: ${ciudad.poblacion}</p>
				</div>
				<form method="post" action="">
					<input type="hidden" name="ciudadId" value="${ciudad.id}">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>ID</th>
									<th>Fehca</th>
									<th>CuposDisponibles</th>
									<th>Evento</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach var="edicion" items="${ediciones}">
									<tr>
										<td>${edicion.id}</td>
										<td>${edicion.fecha}</td>
										<td>${edicion.cuposDisponibles}</td>
										<td>${edicion.eventoDeportivo.nombre}</td>								
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>					
				</form>





			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>