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
	<%@ include file="/partes/navbar.jsp"%>

	<!-- Contenido Principal -->
	<div class="container-fluid">
		<div class="row">
			<!-- Barra lateral -->
			<%@ include file="/partes/sidebar.jsp"%>
            
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
                            <th>Ciudad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="edicion" items="${ediciones}">
                            <tr>
                                <td>${edicion.id}</td>
                                <td>${edicion.fecha}</td>
                                <td>${edicion.cuposDisponibles}</td>
                                <td><a class="btn btn-info btn-sm delete-btn"
									href="edicionVer?idEdicion=${edicion.id}"> <i class="fas fa-eye"> ${edicion.eventoDeportivo.nombre}</i></a></td>
                                <td><a class="btn btn-info btn-sm delete-btn"
									href="ciudadVer?ciudadId=${edicion.ciudad.id}"> <i class="fas fa-eye"> ${edicion.ciudad.nombre}</i></a></td>
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
