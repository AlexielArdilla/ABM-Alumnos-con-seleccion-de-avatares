<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cargar Final</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" type="text/css" rel="stylesheet">
    <link href="css/styleFinalesAlumno.css" type="text/css" rel="stylesheet">
<script>
function confirmarCancelar() {
	if (confirm("Está seguro que desea cancelar?") == true) {
		document.location.href = './home.html';
	}
}

function confirmarCrear() {
	return confirm("Está seguro que desea crear el final?");
}
</script>

</head>
<body bgcolor='black'>
<a href="home.html"><img src="images/logo.png" alt=""></a>

<div class="container">
<div class="main">

<table style="width: 100%;">
	<tr bgcolor='#888891' align='center' valign= 'middle' height='20'>
		<td><h3>Carga de finales </h3></td>
	</tr>
</table>

<p style="color:red; font-weight:bolder">${ok}</p>

<form action="./CargarFinal" method="post" onSubmit="return confirmarCrear()">
	
	
	<label>Materia</label>
	<select name="materias" required>
		<c:forEach items="${materias}" var="val"> 
	        <option value="${val.id}"> ${val.descripcion }</option>   
	    </c:forEach>
	</select>
	
	<br><br>
	
	
	<label>Alumno</label>
	<select  name="alumno" required>
		<c:forEach items="${alumnos}" var="val">
			<option value="${val.id_alumno}">${val.apel_nombre}</option>
		</c:forEach>
    </select>
    
    <br>
    
    <h2>Ingrese la nota</h2>
    <input type="number" max="10" min="1" step="0.5" required name="nota">
    
    <br><br>
    
    <input type="submit" value="Enviar"><br>
	<input type="button" value="Cancelar" onClick="confirmarCancelar()">
	<!-- <a href="./">Cancelar</a> -->
	
</form>

	</div>
</div>

</body>
</html>