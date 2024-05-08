
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Panel de Control de Inscripción</title>
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
	border: 1px solid #666;
	padding: 0.5rem;
	text-align: center;
	background-color: #222;
}

.btn-custom {
	background-color: #0688B4; /* Azul personalizado */
	border-color: #0688B4;
	color: #fff;
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
				<h2>Inscripción</h2>
				<!-- Botón de agregar -->
				<button type="button" class="btn btn-success mb-3"
					data-toggle="modal" data-target="#addModal">Agregar</button>
				<table>
					<thead>
						<tr>
							<th>#</th>
							<th>dorsal</th>
							<th>fechaInscipcion</th>
							<th>Deportista</th>
							<th>Evento</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${inscripciones}" var="inscripcion">
							<tr>
								<td>${inscripcion.id}</td>
								<td>${inscripcion.dorsal}</td>
								<td>${inscripcion.fechaInscripcion}</td>
								<td>${inscripcion.deportista.nombre}</td>
								<td>${inscripcion.edicion.eventoDeportivo.nombre}</td>
								<td>
									<button type="button" class="btn btn-primary btn-sm edit-btn"
										data-toggle="modal" data-target="#editModal">
										<i class="fas fa-edit"></i>
									</button>
									<button type="button" class="btn btn-danger btn-sm delete-btn">
										<i class="fas fa-trash-alt"></i>
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Modal de Edición -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
		aria-labelledby="editModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="editModalLabel">Editar Inscripción</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- Formulario de Edición -->
					<form action="inscripcionEditar" var="deportista" method="post">
						<input type="hidden" name="editId" id="editId"
							value="${inscripcion.id}">
						<div class="form-group">
							<label for="editDorsal">Dorsal</label> <input type="text"
								class="form-control" id="editDorsal">
						</div>
						<div class="form-group">
							<label for="editFechaInscripcion">Fecha de Inscripción</label> <input
								type="date" class="form-control" id="editFechaInscripcion">
						</div>
						<div class="form-group">
							<label for="editIdDeportista">ID Deportista</label> <input
								type="text" class="form-control" id="editIdDeportista">
						</div>
						<div class="form-group">
							<label for="editIdEdicion">ID Edición</label> <input type="text"
								class="form-control" id="editIdEdicion">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cerrar</button>
							<button type="submit" class="btn btn-primary">Guardar
								Cambios</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- Modal de Agregar -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="addModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addModalLabel">Agregar Inscripción</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- Formulario de Agregar -->
					<form>
						<div class="form-group">
							<label for="addDorsal">Dorsal</label> <input type="text"
								class="form-control" id="addDorsal">
						</div>
						<div class="form-group">
							<label for="addFechaInscripcion">Fecha de Inscripción</label> <input
								type="date" class="form-control" id="addFechaInscripcion">
						</div>
						<div class="form-group">
							<label for="addIdDeportista">ID Deportista</label> <input
								type="text" class="form-control" id="addIdDeportista">
						</div>
						<div class="form-group">
							<label for="addIdEdicion">ID Edición</label> <input type="text"
								class="form-control" id="addIdEdicion">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cerrar</button>
							<button type="submit" class="btn btn-primary">Agregar</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- Scripts de Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
