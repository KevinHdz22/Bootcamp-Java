<%@page import="com.protalento.entidades.Consulta"%>
<%@page import="com.protalento.implementaciones.ImplementacionConsulta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="mainTablas.css">
<title>Tabla de busquedas</title>
</head>
<body>
	<h2>Busquedas Realizadas </h2>
	<table class="">
	  <tr class="cabecera">
	    <th>Texto</th>
	    <th>URL</th>
	    <th>Fecha</th>
	  </tr>
	   
	  <%
	  	  ImplementacionConsulta implementacionConsulta= new ImplementacionConsulta();
		  for (Consulta consulta : implementacionConsulta.listar()) {
			  out.print("<tr class='datos'>");
			  out.print("<td>" + consulta.getTexto() + "</td>");
			  out.print("<td>");
			  out.print("<br>");
			  out.print("<a href= https://" + consulta.getUrl() + ">" + consulta.getUrl() + "</a>");
			  out.print("<br>");
			  out.print("</td>");
			  out.print("<td>" + consulta.getFecha() + "</td>");
			  out.print("</tr>");
			}
	  %>
	</table>
</body>
</html>