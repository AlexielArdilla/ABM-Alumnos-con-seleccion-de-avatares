<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
<title>Observación</title>
</head>
<body style="background-color:black;">
<a href="home.html"><img src="images/logo.png" alt=""></a>
<br>
<div class="profile-img">
<img src='<c:out value="${avatar}"></c:out>' style='float:left'>
</div>
<h2>Observaciones alumno: <c:out value="${nombre}"></c:out></h2><br><br><br><br><br>
<h2>Descripción</h2>
<h3><c:out value="${descripcion}"></c:out></h3>
<h2>Objetivo/lema</h2>
<h3><c:out value="${objetivo}"></c:out></h3>
<h2>Observaciones:</h2>
<h3><c:out value="${observaciones}"></c:out></h3>
<h3><a href="./CargarDatosObservacion?alu_id=<c:out value="${alu_id}"></c:out>">Actualizar Observaciones</a></h3>

<h2>UNPAZ</h2>

</body>
</html>