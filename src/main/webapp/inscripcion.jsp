<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Panel de Control de Inscripción</title>
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

.alert {
    margin-bottom: 20px;
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
                <h2>Inscripción</h2>

                <!-- Mensajes de acciones -->
                <%@ include file="/partes/mensajes.jsp" %>

               
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Dorsal</th>
                            <th>Fecha de Inscripción</th>
                            <th>Deportista</th>
                            <th>Evento</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="inscripcion" items="${inscripciones}">
                            <tr>
                                <td>${inscripcion.id}</td>
                                <td>${inscripcion.dorsal}</td>
                                <td>${inscripcion.fechaInscripcion}</td>
                                <td>${inscripcion.deportista.nombre}</td>
                                <td>${inscripcion.edicion.eventoDeportivo.nombre}</td>
                                <td>
                                    
                                    <a href="inscripcionEliminar?idInscripcion=${inscripcion.id}" type="button" class="btn btn-danger btn-sm delete-btn">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Modal de Edición -->
    <c:forEach var="inscripcion" items="${inscripciones}">
        <div class="modal fade" id="editModal${inscripcion.id}" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editModalLabel">Editar Inscripción</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- Formulario de Edición -->
                        <form action="inscripcionEditar" method="post">
                            <input type="hidden" name="editId" id="editId" value="${inscripcion.id}">
                            <div class="form-group">
                                <label for="editDorsal">Dorsal</label>
                                <input type="text" class="form-control" id="editDorsal" name="editDorsal" value="${inscripcion.dorsal}">
                            </div>
                            <div class="form-group">
                                <label for="editFechaInscripcion">Fecha de Inscripción</label>
                                <input type="date" class="form-control" id="editFechaInscripcion" name="editFechaInscripcion" value="${inscripcion.fechaInscripcion}">
                            </div>
                            <div class="form-group">
                                <label for="editDeportista">Deportista</label>
                                <select class="form-control" id="editDeportista" name="editDeportista">
                                    <option value="">Seleccionar Deportista</option>
                                    <c:forEach var="deportista" items="${deportistas}">
                                        <option value="${deportista.id}" ${deportista.id == inscripcion.deportista.id ? 'selected' : ''}>
                                            ${deportista.nombre}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="editEdicion">Edición</label>
                                <select class="form-control" id="editEdicion" name="editEdicion">
                                    <option value="">Seleccionar Edición</option>
                                    <c:forEach var="edicion" items="${ediciones}">
                                        <option value="${edicion.id}" ${edicion.id == inscripcion.edicion.id ? 'selected' : ''}>
                                            ${edicion.eventoDeportivo.nombre}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>

    <!-- Modal de Agregar -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addModalLabel">Agregar Inscripción</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Formulario de Agregar -->
                    <form action="inscripcionAgregar" method="post">
                        <div class="form-group">
                            <label for="addDorsal">Dorsal</label>
                            <input type="text" class="form-control" id="addDorsal" name="addDorsal">
                        </div>
                        <div class="form-group">
                            <label for="addFechaInscripcion">Fecha de Inscripción</label>
                            <input type="date" class="form-control" id="addFechaInscripcion" name="addFechaInscripcion">
                        </div>
                        <div class="form-group">
                            <label for="addDeportista">Deportista</label>
                            <select class="form-control" id="addDeportista" name="addDeportista">
                                <option value="">Seleccionar Deportista</option>
                                <c:forEach var="deportista" items="${deportistas}">
                                    <option value="${deportista.id}">${deportista.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="addEdicion">Edición</label>
                            <select class="form-control" id="addEdicion" name="addEdicion">
                                <option value="">Seleccionar Edición</option>
                                <c:forEach var="edicion" items="${ediciones}">
                                    <option value="${edicion.id}">${edicion.eventoDeportivo.nombre}</option>
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

    <!-- Scripts de Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
