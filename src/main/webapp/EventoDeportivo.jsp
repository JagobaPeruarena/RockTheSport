
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Panel de Control de Eventos Deportivos</title>
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
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">
        <img src="imagen\images.jpg" alt="Logo de la Empresa">
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Inicio</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Usuarios</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Tablas</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Configuración</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Salir</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Contenido Principal -->
  <div class="container-fluid">
    <div class="row">
      <!-- Barra lateral -->
      <div class="col-md-3 sidebar">
        
        <!-- Botones para seleccionar tablas -->
        <a href="ciudad" class="btn btn-primary btn-block mt-3">Ciudad</a>
        <a href="EventoDeportivo" class="btn btn-primary btn-block mt-3">Evento deportivo</a>
        <a href="organizador" class="btn btn-primary btn-block mt-3">Organizador</a>
        <a href="edicion" class="btn btn-primary btn-block mt-3">Edicion</a>
        <a href="deportista" class="btn btn-primary btn-block mt-3">Deportista</a>
        <a href="inscripcion" class="btn btn-primary btn-block mt-3">Inscripción</a>
        <a href="resultado" class="btn btn-primary btn-block mt-3">Resultado</a>
      </div>
      <!-- Contenido principal -->
      <div class="col-md-9 main-content">
        <!-- Tabla de información de la tabla seleccionada -->
        <h2> Evento Deportivo</h2>
        <!-- Botón de agregar -->
        <button type="button" class="btn btn-success mb-3" data-toggle="modal" data-target="#addModal">Agregar</button>
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
              <td>${eventoDeportivo.tipoDeporte}</td>
              <td>${eventoDeportivo.organizador.nombre}</td>
              <td>
                <button type="button" class="btn btn-primary btn-sm edit-btn" data-toggle="modal" data-target="#editModal"><i class="fas fa-edit"></i></button>
                <button type="button" class="btn btn-danger btn-sm delete-btn"><i class="fas fa-trash-alt"></i></button>
              </td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>

  <!-- Modal de Edición -->
  <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="editModalLabel">Editar Evento Deportivo</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <!-- Formulario de Edición -->
          <form>
            <div class="form-group">
              <label for="editNombre">Nombre</label>
              <input type="text" class="form-control" id="editNombre">
            </div>
            <div class="form-group">
              <label for="editDescripcion">Descripción</label>
              <input type="text" class="form-control" id="editDescripcion">
            </div>
            <div class="form-group">
              <label for="editTipoDeporte">Tipo de Deporte</label>
              <select class="form-control" id="editTipoDeporte">
                <option value="Triatlon">Triatlón</option>
                <option value="Ciclismo">Ciclismo</option>
                <option value="Maraton">Maratón</option>
                <option value="Piragüismo">Piragüismo</option>
                <option value="Futbol">Fútbol</option>
                <option value="Eskupilota">Eskupilota</option>
                <option value="CestaPunta">Cesta Punta</option>
              </select>
            </div>
            <div class="form-group">
              <label for="editIdOrganizador">ID Organizador</label>
              <input type="number" class="form-control" id="editIdOrganizador">
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
          <button type="button" class="btn btn-primary">Guardar Cambios</button>
        </div>
      </div>
    </div>
  </div>

  <!-- Modal de Agregar -->
  <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="addModalLabel">Agregar Evento Deportivo</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <!-- Formulario de Agregar -->
          <form>
            <div class="form-group">
              <label for="addNombre">Nombre</label>
              <input type="text" class="form-control" id="addNombre">
            </div>
            <div class="form-group">
              <label for="addDescripcion">Descripción</label>
              <input type="text" class="form-control" id="addDescripcion">
            </div>
            <div class="form-group">
              <label for="addTipoDeporte">Tipo de Deporte</label>
              <select class="form-control" id="addTipoDeporte">
                <option value="Triatlon">Triatlón</option>
                <option value="Ciclismo">Ciclismo</option>
                <option value="Maraton">Maratón</option>
                <option value="Piragüismo">Piragüismo</option>
                <option value="Futbol">Fútbol</option>
                <option value="Eskupilota">Eskupilota</option>
                <option value="CestaPunta">Cesta Punta</option>
              </select>
            </div>
            <div class="form-group">
              <label for="addIdOrganizador">ID Organizador</label>
              <input type="number" class="form-control" id="addIdOrganizador">
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
          <button type="button" class="btn btn-primary">Agregar</button>
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
