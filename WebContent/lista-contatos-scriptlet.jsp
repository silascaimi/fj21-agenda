<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ page
  import="java.util.*,
          br.com.caelum.dao.*,
          br.com.caelum.modelo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <table>
    <thead>
      <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Endereço</th>
        <th>Data de nascimento</th>
      </tr>
    </thead>
    <tbody>
      <%
      	ContatoDao dao = new ContatoDao();
      List<Contato> contatos = dao.getLista();

      for (Contato contato : contatos) {
      %>
      <tr>
        <td><%=contato.getNome()%></td>
        <td><%=contato.getEmail()%></td>
        <td><%=contato.getEndereco()%></td>
        <%
        	DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String dataNascimento = f.format(contato.getDataNascimento().getTime());
        %>
        <td><%=dataNascimento%></td>
      </tr>
      <%
      	}
      %>
    </tbody>
  </table>
</body>
</html>