
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String msgs = request.getParameter("msg");  %>
<c:if test="${msgs.equals('agregado')}">
	<div class="alert alert-success alert-dismissible fade show"
		role="alert">
		<strong>Datos Correctos:</strong> Nueva linea agregada correctamente
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
</c:if>
${msg}
hola
<c:if test="${msgs.equals('editado')}">
			<div class="alert alert-primary alert-dismissible fade show"
				role="alert">
				<strong>Datos Editados:</strong> Los datos han sido editados correctamente
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
<c:if test="${msgs.equals('error')}">
	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		<strong>Datos Incorrectos:</strong> Error al realizar la operacion
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
</c:if>