<%@page import="com.protalento.implementaciones.ImplementacionConsulta"%>
<%@page import="com.protalento.entidades.Consulta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Respuesta-Consulta</title>
</head>
<body>

<%
	Consulta consulta = (Consulta) request.getAttribute("consultaX");
	ImplementacionConsulta implementacionConsulta = new ImplementacionConsulta();
	implementacionConsulta.insertar(consulta);
	//Consulta consulta = (Consulta) request.getAttribute("consultaX");
	//out.print(request.getAttribute("consultaX"));
%>

<%-- <h1><%="El texto ingresado es: "+ consulta.getTexto() %></h1> --%>
<%
	String cadena = consulta.getUrl();
	String palabraBuscada = consulta.getTexto();
	String cadena2 = " ";
	int recurrencia = 0;
	
	for (int i = 0; i < cadena.length(); i++) {
		if (i == cadena.length()-(palabraBuscada.length()-1)) {
				break;
		}else {
			cadena2 = cadena.substring(i, i+palabraBuscada.length());
			//System.out.println(cadena2);
			 
			if (palabraBuscada.equals(cadena2)) {
				recurrencia++;
			}
		}
	}
%>
<h1><%=("El texto ingresado " + '"'+ consulta.getTexto() + '"' + " Se encuentra " + recurrencia + ((recurrencia == 1) ? " vez" : " veces") + " en la URL " + '"' + consulta.getUrl() +'"')%></h1>
<a href= <%="https://" + consulta.getUrl() %>>ir al sitio</a>
<br>
<a href="tablaBusquedas.jsp">Busquedas realizadas</a>

</body>
</html>