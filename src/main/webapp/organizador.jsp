<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Panel de Control de Organizadores</title>
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
                <h2>Organizadores</h2>

                <!-- Mensajes de acciones -->
                <%@ include file="/partes/mensajes.jsp" %>

                <!-- Botón de agregar -->
                <button type="button" class="btn btn-success mb-3" data-toggle="modal" data-target="#addModal">
                    <i class="fas fa-plus"></i> Agregar
                </button>

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Email</th>
                            <th>Teléfono</th>
                            <th>DNI</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="organizador" items="${organizadores}">
                            <tr>
                                <td>${organizador.id}</td>
                                <td>${organizador.nombre}</td>
                                <td>${organizador.email}</td>
                                <td>${organizador.telefono}</td>
                                <td>${organizador.dni}</td>
                                <td>
                                    <button type="button" class="btn btn-primary btn-sm edit-btn" data-toggle="modal" data-target="#editModal${organizador.id}">
                                        <i class="fas fa-edit"></i> Editar
                                    </button>
                                    <a href="organizadorEliminar?idOrganizador=${organizador.id}" type="button" class="btn btn-danger btn-sm delete-btn">
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
    <c:forEach var="organizador" items="${organizadores}">
        <div class="modal fade" id="editModal${organizador.id}" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editModalLabel">Editar Organizador</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- Formulario de Edición -->
                        <form action="organizadorEditar" method="post">
                            <input type="hidden" name="editId" id="editId" value="${organizador.id}">
                            <div class="form-group">
                                <label for="editNombre">Nombre</label>
                                <input type="text" class="form-control" id="editNombre" name="editNombre" value="${organizador.nombre}">
                            </div>
                            <div class="form-group">
                                <label for="editEmail">Email</label>
                                <input type="email" class="form-control" id="editEmail" name="editEmail" value="${organizador.email}">
                            </div>
                            <div class="form-group">
                                <label for="editTelefono">Teléfono</label>
                                <input type="tel" class="form-control" id="editTelefono" name="editTelefono" value="${organizador.telefono}">
                            </div>
                            <div class="form-group">
                                <label for="editDNI">DNI</label>
                                <input type="text" class="form-control" id="editDNI" name="editDNI" value="${organizador.dni}">
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
                    <h5 class="modal-title" id="addModalLabel">Agregar Organizador</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Formulario de Agregar -->
                    <form action="organizadorAgregar" method="post">
                        <div class="form-group">
                            <label for="addNombre">Nombre</label>
                            <input type="text" class="form-control" id="addNombre" name="addNombre">
                        </div>
                        <div class="form-group">
                            <label for="addEmail">Email</label>
                            <input type="email" class="form-control" id="addEmail" name="addEmail">
                        </div>
                        <div class="form-group">
                            <label for="addTelefono">Teléfono</label>
                            <input type="tel" class="form-control" id="addTelefono" name="addTelefono">
                        </div>
                        <div class="form-group">
                            <label for="addDNI">DNI</label>
                            <input type="text" class="form-control" id="addDNI" name="addDNI">
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
