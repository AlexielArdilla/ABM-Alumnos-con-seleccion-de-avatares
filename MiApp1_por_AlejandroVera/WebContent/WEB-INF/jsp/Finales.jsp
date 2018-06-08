<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
<title></title>
 <link rel="stylesheet" type="text/css" media="screen" href="css/finales.css">
</head>
<body style="background-color:black;">
<div id="dvContainer">
<a href="home.html"><img src="images/logo.png" alt=""></a>
<table style="width: 100%;">
	<tr bgcolor='#888891' align='center' valign= 'middle' height='20'>
	<td>
		<c:choose>
	    	<c:when test="${empty alumno}">
	        	<h3 class="titulo">Todos los Finales</h3>
	    	</c:when>
	    	<c:otherwise>
	       		<h3>Finales del Alumno : <c:out value="${alumno.id_alumno}" /> - <c:out value="${alumno.apel_nombre}" />   </h3>
	    	</c:otherwise>
		</c:choose>
		</td>
	</tr>
</table>

<table style="width: 100%;">
	<tr  bgcolor="#CCCCCC" >
		<th>Final ID</th>
		<th>Alumno</th>
		<th>Materia</th>
		<th>Nota</th>
		<th>Borrar</th>
	</tr>
	
	<c:forEach var="finalNota" items="${finales2}">
		<tr>
			<td>${finalNota.id}</td>
			<td>${finalNota.apel_nombre}</td>
			<td>${finalNota.descripcion_materia}</td>
			<td>${finalNota.nota}</td>
			<td><input type="button" value="BORRAR" name="BORRAR" onclick="confirmarEliminar( '${finalNota.deleteURL}')" /></td>
			<!-- <td><input type="button" value="BORRAR" name="BORRAR" onclick="funcionBorrar( '${finalNota.deleteURL}')" /></td>--->    
		</tr>
	</c:forEach>
			<tr>
				<td><a href="./EliminarFinalesByAlumno">Eliminar todos los
						finales de un alumno</a></td>
			</tr>
		</table>
</div>
<table>
 <tr>
<td>
Presione el boton para imprimir la página
<input type="button" value="Imprimir" id="btnPrint" />
</td>
</tr>
</table>
</body>

 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        $("#btnPrint").live("click", function () {
            var divContents = $("#dvContainer").html();
            var printWindow = window.open('', '', 'height=400,width=800');
            printWindow.document.write('<html><head><title>Materias</title>');
            printWindow.document.write('</head><body >');
            printWindow.document.write(divContents);
            printWindow.document.write('</body></html>');
            printWindow.document.close();
            printWindow.print();
        });

function funcionBorrar(url){
	 
	 window.location.href = url; 
	
	
}

function confirmarEliminar(url_to_delete) {
	if (confirm("Está seguro que desea BORRAR este final?") == true) {
		funcionBorrar(url_to_delete);
		
	}else{
		
		document.location.href = './Finales';
		
	}
}

</script>
</html>
