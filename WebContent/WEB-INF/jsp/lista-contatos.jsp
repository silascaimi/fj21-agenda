<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <c:import url="cabecalho.jsp" />

  <table border="1">
    <thead>
      <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Endere�o</th>
        <th>Nascimento</th>
      </tr>
    </thead>
    <tbody>
      <!-- percorre contatos montando as linhas da tabela -->
      <c:forEach var="contato" items="${contatos}" varStatus="id">
        <tr bgcolor="#${id.count % 2 == 0 ? 'dcdcdc' : 'ffffff'}">
          <td>${contato.nome}</td>
          <td><c:choose>
              <c:when test="${not empty contato.email}">
                <a href="malito:${contato.email}">${contato.email}</a>
              </c:when>
              <c:otherwise>
                Email n�o encontrado
              </c:otherwise>
            </c:choose></td>
          <td>${contato.endereco}</td>
          <td><fmt:formatDate
              value="${contato.dataNascimento.time}"
              pattern="dd/MM/yyyy" /></td>
          <td><a
            href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a>
          </td>
      </c:forEach>
    </tbody>
  </table>

  <c:import url="rodape.jsp" />
</body>
</html>