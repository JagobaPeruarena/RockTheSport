
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Panel de Control de Eventos Deportivos</title>
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
				<h2>Evento Deportivo</h2>
				<!-- Botón de agregar -->
				<button type="button" class="btn btn-success mb-3"
					data-toggle="modal" data-target="#addModal">Agregar</button>
				<table>
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>Descripción</th>
							<th>Tipo de Deporte</th>
							<th>Organizador</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${eventoDeportivo}" var="eventoDeportivo">
							<tr>
								<td>${eventoDeportivo.id}</td>
								<td>${eventoDeportivo.nombre}</td>
								<td>${eventoDeportivo.descripcion}</td>
								<td>${eventoDeportivo.tipoDeporte.nombre}</td>
								<td>${eventoDeportivo.organizador.nombre}</td>
								<td>
									<button type="button" class="btn btn-primary btn-sm edit-btn"
										data-toggle="modal"
										data-target="#editModal${eventoDeportivo.id}">
										<i class="fas fa-edit"></i>
									</button> <a
									href="eventoDeportivoEliminar?idEventoDeportivo=${eventoDeportivo.id}"
									type="button" class="btn btn-danger btn-sm delete-btn"> <i
										class="fas fa-trash-alt"></i></a>
										<a class="btn btn-info btn-sm delete-btn"
									href="eventoDeportivoVer?idEventoDeportivo=${eventoDeportivo.id}"> <i class="fas fa-eye"></i></a>
										
								
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Modal de Edición -->
	<c:forEach items="${eventoDeportivo}" var="eventoDeportivo">
		<div class="modal fade" id="editModal${eventoDeportivo.id}"
			tabindex="-1" role="dialog" aria-labelledby="editModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="editModalLabel">Editar Evento
							Deportivo</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Formulario de Edición -->
						<form action="eventoDeportivoEditar" var="eventoDeportivo"
							method="post">
							<input type="hidden" name="editId" id="editId"
								value="${eventoDeportivo.id}">
							<div class="form-group">
								<label for="editNombre">Nombre</label> <input type="text"
									class="form-control" id="editNombre" name="editNombre"
									value="${eventoDeportivo.nombre}">
							</div>
							<div class="form-group">
								<label for="editDescripcion">Descripción</label> <input
									type="text" class="form-control" id="editDescripcion"
									name="editDescripcion" value="${eventoDeportivo.descripcion}">
							</div>
							<div class="form-group">
								<label for="editTipoDeporte">Tipo Deporte</label> <select class="form-select" id="editTipoDeporte" name="editTipoDeporte">
									<option value="" disabled>TipoDeporte</option>
									<c:forEach var="deportes" items="${deportess}">
										<option value="${deportes.id}"
											${deportes.id == eventoDeportivo.tipoDeporte.id ? 'selected' : ''}>${deportes.nombre}</option>

									</c:forEach>
									</select>
							</div>
							<div class="form-group">
								<label for="editIdOrganizador">Organizador</label> <select
									class="form-select" id="editOrganizador" name="editOrganizador">
									<option value="" disabled>Organizadores</option>
									<c:forEach var="organizador" items="${organizadores}">
										<option value="${organizador.id}"
											${organizador.id == eventoDeportivo.organizador.id ? 'selected' : ''}>${organizador.nombre}</option>

									</c:forEach>
								</select>
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
	</c:forEach>
	<!-- Modal de Agregar -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="addModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addModalLabel">Agregar Evento
						Deportivo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- Formulario de Agregar -->
					<form action="eventoDeportivoAgregar" var="deportista"
						method="post">
						<div class="form-group">
							<label for="addNombre">Nombre</label> <input type="text"
								class="form-control" id="addNombre" name="addNombre">
						</div>
						<div class="form-group">
							<label for="addDescripcion">Descripción</label> <input
								type="text" class="form-control" id="addDescripcion"
								name="addDescripcion">
						</div>
						<div class="form-group">
								<label for="editTipoDeporte">Tipo Deporte</label> <select class="form-select" id="editTipoDeporte" name="editTipoDeporte">
									<option value="" disabled>TipoDeporte</option>
									<c:forEach var="deportes" items="${deportess}">
										<option value="${deportes.id}">${deportes.nombre}</option>

									</c:forEach>
									</select>
							</div>
						<div class="form-group">
							<label for="addIdOrganizador">Organizador</label> <select
								class="form-select" id="addOrganizador" name="addOrganizador">
								<option value="">Organizadores</option>
								<c:forEach var="organizador" items="${organizadores}">
									<option value="${organizador.id}">
										${organizador.nombre}</option>

								</c:forEach>
							</select>
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
