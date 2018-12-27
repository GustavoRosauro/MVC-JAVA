<%-- 
    Document   : Atualizar
    Created on : 27/12/2018, 18:07:25
    Author     : Usuario
--%>

<%@page import="modelo.Pessoa"%>
<%@page import="ModeloDAO.PessoasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualiza Pagina</title>
    </head>
    <body>
        <div>
            <%
                PessoasDAO dao = new PessoasDAO();
                int id = Integer.parseInt((String)request.getAttribute("id"));
                Pessoa p = dao.PessoaId(id);
            %>
        <h1>Atualizar Nomes</h1>
        <form action="Controlador">
            <input type="number" name="txtId" value="<%= p.getId()%>" hidden="true">
            <input type="text" name="txtNome" value="<%= p.getNome()%>">
            <input type="submit" name="accion" value="editar">
        </form>
        </div>
    </body>
</html>
