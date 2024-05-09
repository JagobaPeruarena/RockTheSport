<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Landing Page de Eventos Deportivos</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet"> 
  <style>
  	
  	
    body, html {
      height: 100%;
    }
    .container {
      min-height: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
      padding-top: 30px; /* Altura de la barra de navegación */
      padding-bottom: 50px; /* Altura del footer */
      
    }
    .navbar-brand img {
      height: 100px; /* Tamaño del logo */
    }
    .social-icon {
      color: #fff; /* Cambia el color del texto de las redes sociales */
      text-decoration: none; /* Elimina el subrayado del texto de las redes sociales */
      margin: 0 10px; /* Ajusta el espacio entre los íconos y el texto de las redes sociales */
    }
  </style>
</head>
<body>

  <!-- Barra de Navegación -->
  <%@ include file="/partes/navbar.jsp"%>

 <!-- Contenido de la Landing Page -->
 <div class="container">
  <div class="text-center">
    <h1>Bienvenido a RockTheSport</h1> 
    <p class="lead">Descubre los mejores eventos deportivos cerca de ti.</p> 
    <a href="PanelDeInicio2" class="btn btn-primary btn-lg" style="background-color: #0688B4;">Ver Eventos</a> 
  </div>
</div>


  <!-- Footer -->
  <footer class="footer py-3 bg-dark text-white fixed-bottom">
    <div class="container text-center">
      <span>&copy; 2024 Eventos Deportivos</span>
      <div class="social-icons">
        <a href="#" class="social-icon"><i class="fab fa-facebook-f"></i> RockTheSport</a>
        <a href="#" class="social-icon"><i class="fab fa-twitter"></i> RockTheSport</a>
        <a href="#" class="social-icon"><i class="fab fa-instagram"></i> RockTheSport</a>
      </div>
    </div>
  </footer>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
