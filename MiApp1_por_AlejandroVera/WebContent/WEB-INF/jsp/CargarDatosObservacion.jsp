<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cargar Datos Observación</title>
<link rel="stylesheet" type="text/css" href="css/avatar.css">
</head>
<body style="background-color:black;">
<a href="home.html"><img src="images/logo.png" alt=""></a>
<h1>Seleccione el avatar y complete los campos:</h1><br>
 
  <div id="avatars">
  <form  action="./CargarDatosObservacion" method="post">
  <label class="avatars">
    <input type="radio" name="avatar" value="1" required/>
    <img src="./images/avatar1.jpg" alt=""/>
  </label>
  
  <label class="avatars">
    <input type="radio" name="avatar" value="2"/>
    <img src="./images/avatar2.jpg" alt=""/>
  </label>
  
  <label class="avatars">
    <input type="radio"name="avatar" value="3"/>
    <img src="./images/avatar3.jpg" alt=""/>
  </label>
  
  <label class="avatars">
    <input type="radio" name="avatar" value="4"/>
    <img src="./images/avatar4.jpg" alt=""/>
  </label>
  
  <label class="avatars">
    <input type="radio" name="avatar" value="5"/>
    <img src="./images/avatar5.jpg" alt="" />
  </label>
  
  <label class="avatars">
    <input type="radio" name="avatar" value="6"/>
    <img src="./images/avatar6.jpg" alt="" />
  </label>
  <br />
  <label class="avatars">
    <input type="radio" name="avatar" value="7"/>
    <img src="./images/avatar7.jpg" alt="" />
  </label>
  
  <label class="avatars">
    <input type="radio" name="avatar" value="8"/>
    <img src="./images/avatar8.jpg" alt="" />
  </label>
  
  <label class="avatars">
    <input type="radio" name="avatar" value="9"/>
    <img src="./images/avatar9.jpg" alt="" />
  </label>
  
  <label class="avatars">
    <input type="radio" name="avatar" value="10"/>
    <img src="./images/avatar10.jpg" alt="" />
  </label>
  
  <label class="avatars">
    <input type="radio" name="avatar" value="11"/>
    <img src="./images/avatar11.jpg" alt="" />
  </label>
  
  <label class="avatars">
    <input type="radio" name="avatar" value="12"/>
    <img src="./images/avatar12.jpg" alt="" />
  </label>
  
  <br>
  
   <label for="fname">Descripción</label>
    <input type="text" id="desc" required name="desc" placeholder=""> 
	
	<label for="fname">Objetivo</label>
    <input type="text" id="obj" required name="obj" placeholder=""> 
		
   <label for="fname">Observaciones</label>
    <input type="text" id="obs" required name="obs" placeholder=""> 
    <br>
    <br>
	
    <button name="id_alu" value='${alu_id}' type="submit">Actualizar Observaciones</button>
    
  
  </form>
  
</div>

  </body>
</html>