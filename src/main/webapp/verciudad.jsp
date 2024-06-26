<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Panel de Control de Base de Datos</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
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

.table thead th {
	background-color: #f8f9fa;
	border-bottom: 2px solid #dee2e6;
}

.table tbody tr td {
	background-color: #ffffff;
	border-top: 1px solid #dee2e6;
	text-align: right;
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

			<!-- Área central para listar elementos -->
			<div class="col-md-9 main-content">
				<!-- Detalles de la ciudad -->
				<h2 class="my-4">Detalles de Ciudad</h2>
				<div class="card mb-4">
					<div class="card-body">
						<h5 class="card-title">${ciudad.nombre}</h5>
						<p class="card-text">
							<strong>ID:</strong> ${ciudad.id} <br> 
							<strong>Ubicación Geográfica:</strong> ${ciudad.ubicacionGeografica} <br> 
							<strong>Población:</strong> ${ciudad.poblacion} <br>						
						</p>
					</div>
				</div>

				<h3 class="my-4">Ediciones</h3>
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Fecha</th>
							<th>Cupos Disponibles</th>
							<th>Nombre de Evento</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="edicion" items="${ediciones}">
							<tr>
								<td>${edicion.id}</td>
								<td>${edicion.fecha}</td>
								<td>${edicion.cuposDisponibles}</td>
								<td>
									<a class="btn btn-info btn-sm" href="eventoDeportivoVer?idEventoDeportivo=${edicion.eventoDeportivo.id}">
										<i class="fas fa-eye"></i> ${edicion.eventoDeportivo.nombre}
									</a>
								</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<a href="javascript:history.back()" class="btn btn-primary mt-3">Volver</a>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
