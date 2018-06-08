<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Borrar Alumno</title>
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
function confirmarBorrar() {
	return confirm("Está seguro que desea BORRAR a este alumno?");
}
</script>

</head>
<body background="black">

<a href="home.html"><img src="images/logo.png" alt=""></a>

<div class="container">
<div class="main">

<form name="formulario" action="./BorrarAlumno" method="post" onSubmit="return confirmarBorrar()">

<table style="width: 100%;">
	<tr bgcolor='#888891' align='center' valign= 'middle' height='20'>
		<td><h3>Ingrese: Apellido, Nombre</h3></td>
	</tr>
</table>

    <h2>Seleccione al alumno</h2>
		<label>Alumno</label>
		<select name="id_alumno">
		<c:forEach items="${alumnos}" var="val">
			<option value="${val.id_alumno}">${val.apel_nombre}</option>
		</c:forEach>
    </select>
    <br><br>

<input type="submit" value="borrar">
				<input type="Button" value="Cancelar" onclick="confirmarCancelar()"> 
</form>

</div>
</div>

</body>
</html>