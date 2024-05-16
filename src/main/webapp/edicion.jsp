<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Panel de Control de Ediciones</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<style>
body, html {
	height: 100%;
	margin: 0;
	padding: 0;
	font-family: 'Roboto', sans-serif;
	background-color: #f4f4f9;
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
	padding-top: 70px;
}

.sidebar {
	background-color: #333;
	color: #fff;
	height: 100%;
	width: 250px;
	position: fixed;
	top: 50px;
	left: 0;
	overflow-x: hidden;
	padding-top: 20px;
}

.sidebar a {
	color: #fff;
	text-decoration: none;
	display: block;
	padding: 10px;
}

.sidebar a:hover {
	background-color: #575757;
}

.main-content {
	margin-left: 250px;
	padding: 20px;
}

table {
	width: 100%;
	margin-bottom: 1rem;
	background-color: #fff;
	border-radius: 5px;
	overflow: hidden;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

td, th {
	border: 1px solid #ddd;
	padding: 0.75rem;
	text-align: center;
}

th {
	background-color: #0688B4;
	color: white;
}

td {
	color: #333;
}

.btn-custom {
	background-color: #0688B4; /* Azul personalizado */
	border-color: #0688B4;
	color: #fff;
}

.btn-custom:hover {
	background-color: #056a91;
	border-color: #056a91;
}

.btn-sm i {
	margin-right: 5px;
}

.modal-content {
	border-radius: 10px;
}

.modal-header, .modal-footer {
	border: none;
}
</style>
</head>
<body>

	<!-- Barra de Navegación -->
	<%@ include file="/partes/navbar.jsp"%>

	<!-- Contenido Principal -->
	<div class="container-fluid">
		<div class="row">
			<!-- Barra lateral -->
			<%@ include file="/partes/sidebar.jsp"%>
			<!-- Contenido principal -->
			<div class="col-md-9 main-content">
				<!-- Tabla de información de la tabla seleccionada -->
				<h2>Edición</h2>
				<!-- Botón de agregar -->
				<button type="button" class="btn btn-success mb-3" data-toggle="modal" data-target="#addModal">
					<i class="fas fa-plus"></i> Agregar
				</button>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID Edición</th>
							<th>Fecha</th>
							<th>Cupos Disponibles</th>
							<th>Evento</th>
							<th>Ciudad</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="edicion" items="${ediciones}">
							<tr>
								<td>${edicion.id}</td>
								<td>${edicion.fecha}</td>
								<td>${edicion.cuposDisponibles}</td>
								<td>${edicion.eventoDeportivo.nombre}</td>
								<td>${edicion.ciudad.nombre}</td>
								<td>
									<button type="button" class="btn btn-primary btn-sm edit-btn" data-toggle="modal" data-target="#editModal${edicion.id}">
										<i class="fas fa-edit"></i> Editar
									</button> 
									<a href="edicionEliminar?idEdicion=${edicion.id}" type="button" class="btn btn-danger btn-sm delete-btn">
										<i class="fas fa-trash-alt"></i> Eliminar
									</a>
									<a class="btn btn-info btn-sm view-btn" href="edicionVer?idEdicion=${edicion.id}">
										<i class="fas fa-eye"></i> Ver
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Modal de Agregar -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addModalLabel">Agregar Edición</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- Formulario de Agregar Edición -->
					<form action="edicionAgregar" method="post">
						<div class="form-group">
							<label for="addCuposDisponibles">Cupos Disponibles</label>
							<input type="number" min="1000" max="50000" class="form-control" id="addCuposDisponibles" name="addCuposDisponibles">
						</div>
						<div class="form-group">
							<label for="addFecha">Fecha</label>
							<input type="date" class="form-control" id="addFecha" name="addFecha">
						</div>
						<div class="form-group">
							<label for="addEventoDeportivo">Evento Deportivo</label>
							<select class="form-select" id="addEventoDeportivo" name="addEventoDeportivo">
								<option value="" selected>Eventos Deportivos</option>
								<c:forEach var="eventoDeportivo" items="${eventoDeportivos}">
									<option value="${eventoDeportivo.id}">${eventoDeportivo.nombre}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="addCiudad">Ciudad</label>
							<select class="form-select" id="addCiudad" name="addCiudad">
								<option value="" selected>Ciudades</option>
								<c:forEach var="ciudad" items="${ciudades}">
									<option value="${ciudad.id}">${ciudad.nombre}</option>
								</c:forEach>
							</select>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
							<button type="submit" class="btn btn-primary">Agregar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal de Editar -->
	<c:forEach var="edicion" items="${ediciones}">
		<div class="modal fade" id="editModal${edicion.id}" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="editModalLabel">Editar Edición</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Formulario de Editar -->
						<form action="edicionEditar" method="post">
							<input type="hidden" name="editId" id="editId" value="${edicion.id}">
							<div class="form-group">
								<label for="editCuposDisponibles">Cupos Disponibles</label>
								<input type="number" min="1000" max="50000" class="form-control" id="editCuposDisponibles" name="editCuposDisponibles" value="${edicion.cuposDisponibles}">
							</div>
							<div class="form-group">
								<label for="editFecha">Fecha</label>
								<input type="date" class="form-control" id="editFecha" name="editFecha" value="${edicion.fecha}">
							</div>
							<div class="form-group">
								<label for="editEventoDeportivo">Evento Deportivo</label>
								<select class="form-select" id="editEventoDeportivo" name="editEventoDeportivo">
									<option value="" selected>Eventos Deportivos</option>
									<c:forEach var="eventoDeportivo" items="${eventoDeportivos}">
										<option value="${eventoDeportivo.id}" ${eventoDeportivo.id == edicion.eventoDeportivo.id ? 'selected' : ''}>
											${eventoDeportivo.nombre}
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="editCiudad">Ciudad</label>
								<select class="form-select" id="editCiudad" name="editCiudad">
									<option value="" selected>Ciudades</option>
									<c:forEach var="ciudad" items="${ciudades}">
										<option value="${ciudad.id}" ${ciudad.id == edicion.ciudad.id ? 'selected' : ''}>
											${ciudad.nombre}
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
								<button type="submit" class="btn btn-primary">Guardar cambios</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<!-- Scripts de Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
