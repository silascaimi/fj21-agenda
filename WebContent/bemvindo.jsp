<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%-- comet�rio em JSP aqui: nossa primeira p�gina JSP --%>

  <%
  	String mensagem = "Bem vindo ao sistema de ageda do FJ-21";
  %>
  <%
  	out.println(mensagem);
  %>

  <br />

  <%
  	String desenvolvido = "Desenvolvido por (Silas)";
  %>
  <%=desenvolvido%>

  <br />

  <%
  	System.out.println("Tudo foi executado!");
  %>
</body>
</html>