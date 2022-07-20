<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div>
		<form action="ValSesion" method="post">
			<label for="correo">Correo </label>
			<input type="email" id="correo" name="correo"
			 	placeholder="usuario@dominio.ext" required/>
		 	<label for="clave">Clave</label>
		 	<input type="password" id="clave" name="clave" placeholder="clave..." required/>
		 	<i class="bi-eye-slash" id="verClave" ></i>
		 	<button type="submit" class="success">Iniciar Sesion</button>
		 	<button type="reset" class="warning">Limpiar Formulario</button>
		</form>
	</div>
</body>
</html>