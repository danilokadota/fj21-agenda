
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<jsp:useBean id="dao" class="agenda.ContatoDao"/>
	
	<table>
		<c:forEach var="contato" items="${dao.lista }">
		<tr>
			<td>${contato.nome }</td>
			 <td>
      			<c:if test="${not empty contato.email}">
       			 <a href="mailto:${contato.email}">${contato.email}</a>
    			  </c:if>
    			        <c:if test="${empty contato.email}">
      				  E-mail n�o informado
     				 </c:if>
   			 </td>
			<td>${contato.email }</td>
			<td>${contato.endereco }</td>
			<td>${contato.dataNascimento.time }</td>
		</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>