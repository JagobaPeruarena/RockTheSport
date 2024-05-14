<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mysql.cj.jdbc.interceptors.SessionAssociationInterceptor"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Detalles del Evento Deportivo</title>
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

.card {
    margin-top: 20px;
}

.table-striped {
    margin-top: 20px;
}

.sidebar {
    background-color: #222;
    color: #fff;
    height: 100%;
    width: 250px;
    position: fixed;
    top: 50px; /* Ajuste para estar debajo de la barra de navegación */
    left: 0;
    overflow-x: hidden;
    padding-top: 20px;
}

.main-content {
    margin-left: 250px; /* Ajuste para dejar espacio para la barra lateral */
    padding: 20px;
}

.btn-block {
    margin-bottom: 10px;
}
</style>
</head>
<body>
    <!-- Barra de Navegación -->
    <nav class="navbar navbar-expand-lg navbar-dark text-white fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#"> 
                <img src="imagen/images.jpg" alt="Logo de la Empresa">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" href="PanelDeInicio2">Inicio</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Usuarios</a></li>
                    <li class="nav-item"><a class="nav-link" href="ciudad">Tablas</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Configuración</a></li>
                    <li class="nav-item"><a class="nav-link" href="PanelDeInicio1">Salir</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <!-- Barra lateral -->
            <div class="col-md-3 sidebar">
                <!-- Botones para seleccionar tablas -->
                <a type="button" class="btn btn-primary btn-block mt-3" href="ciudad">Ciudad</a>
                <a type="button" class="btn btn-primary btn-block mt-3" href="EventoDeportivo">Evento deportivo</a>
                <a type="button" class="btn btn-primary btn-block mt-3" href="organizador">Organizador</a>
                <a type="button" class="btn btn-primary btn-block mt-3" href="edicion">Edicion</a>
                <a type="button" class="btn btn-primary btn-block mt-3" href="deportista">Deportista</a>
                <a type="button" class="btn btn-primary btn-block mt-3" href="inscripcion">Inscripción</a>
                <a type="button" class="btn btn-primary btn-block mt-3" href="resultado">Resultado</a>
            </div>
            
            <!-- Contenido principal -->
            <div class="col-md-9 main-content">
                <h2 class="my-4">Detalles del Evento Deportivo</h2>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${eventoDeportivo.nombre}</h5>
                        <p class="card-text">
                            <strong>Descripción:</strong> ${eventoDeportivo.descripcion} <br>
                            <strong>Tipo de Deporte:</strong> ${eventoDeportivo.tipoDeporte} <br>
                            <strong>Organizador:</strong> ${eventoDeportivo.organizador.nombre} <br>
                        </p>
                    </div>
                </div>
                
                <h3 class="my-4">Ediciones</h3>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Fecha</th>
                            <th>Cupos Disponibles</th>
                            <th>Nombre de Edición</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="edicion" items="${ediciones}">
                            <tr>
                                <td>${edicion.id}</td>
                                <td>${edicion.fecha}</td>
                                <td>${edicion.cuposDisponibles}</td>
                                <td>${edicion.nombre}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <a href="javascript:history.back()" class="btn btn-primary mt-3">Volver</a>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
