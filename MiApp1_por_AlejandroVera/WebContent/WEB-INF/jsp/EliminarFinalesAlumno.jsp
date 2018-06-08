<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Eliminar Finales Por Alumno</title>
		  <style type="text/css">
    </style>
	 <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" type="text/css" rel="stylesheet">
    <link href="css/styleFinalesAlumno.css" type="text/css" rel="stylesheet">
<script>
function confirmarCancelar() {
		if (confirm("Está seguro que desea cancelar?") == true) {
			document.location.href = './home.html';
		}
	}
function confirmarEliminar() {
	return confirm("Está seguro que desea ELIMINAR todos los finales?");
}
</script>
</head>
<body bgcolor='black'>
<a href="home.html"><img src="images/logo.png" alt=""></a>

<div class="container">
<div class="main">

<table style="width: 100%;">
	<tr bgcolor='#888891' align='center' valign= 'middle' height='20'>
		<td><h3>Eliminar todos los Finales Alumno </h3></td>
	</tr>
</table>

<p style="color:red; font-weight:bolder">${ok}</p>

<form name="formu" action="./EliminarFinalesByAlumno" method="post" onSubmit="return confirmarEliminar()">
	
				
				<br>
			
		<h2>Seleccione al alumno</h2>
		<label>Alumno</label>
		<select name="id_alumno">
		<c:forEach items="${alumnos}" var="val">
			<option value="${val.id_alumno}">${val.apel_nombre}</option>
		</c:forEach>
    </select>
    
    <br><br>
   
				 <label>Carrera:</label>
				<select name='perfil'>
						<option value='an_prog'>Analista Programador</option>
						<option value='abogacia'>Abogacia</option>
						<option value='enfermeria'>Enfermeria</option>
						<option value='gimnasia'>Profesorado de gimnasia</option>
				</select>&nbsp;
			<br><br>
				
				<input type="submit" value="Eliminar Finales">
				<input type="Button" value="Cancelar" onclick="confirmarCancelar()"> 

			</form>
	</div>
	</div>
</body>
</html>