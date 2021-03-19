<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <c:import url="cabecalho.jsp" />

  <!-- Cria o DAO -->
  <jsp:useBean id="dao" class="br.com.caelum.dao.ContatoDao" />

  <table border="1">
    <thead>
      <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Endereço</th>
        <th>Nascimento</th>
      </tr>
    </thead>
    <tbody>
      <!-- percorre contatos montando as linhas da tabela -->
      <c:forEach var="contato" items="${dao.lista}" varStatus="id">
        <tr bgcolor="#${id.count % 2 == 0 ? 'dcdcdc' : 'ffffff'}">
          <td>${contato.nome}</td>
          <td><c:choose>
              <c:when test="${not empty contato.email}">
                <a href="malito:${contato.email}">${contato.email}</a>
              </c:when>
              <c:otherwise>
                Email não encontrado
              </c:otherwise>
            </c:choose></td>
          <td>${contato.endereco}</td>
          <td>${contato.dataNascimento.time}</td>
      </c:forEach>
    </tbody>
  </table>

  <c:import url="rodape.jsp" />
</body>
</html>