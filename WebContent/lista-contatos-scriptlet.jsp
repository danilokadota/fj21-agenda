<%@page import="java.sql.Connection"%>
<%@page import="agenda.Contato"%>
<%@page import="java.util.List"%>
<%@page import="agenda.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
  <body>
    <table>
      <%
      Connection connection = (Connection) request
      .getAttribute("conexao");
      ContatoDao dao = new ContatoDao(connection);
      List<Contato> contatos = dao.getLista();
      
      for (Contato contato : contatos ) {
      %>
      <tr>
      	<td>Nome</td>
      	<td>Email</td>
      	<td>Endere�o</td>
      	<td>Data de Nascimento</td>
      </tr>
      
        <tr>
          <td><%=contato.getNome() %></td> 
          <td><%=contato.getEmail() %></td>
          <td><%=contato.getEndereco() %></td>
          <td><%=contato.getDataNascimento().getTime() %></td>
        </tr>
        
      <%
      }
      %>
    </table>
  </body>
</html>