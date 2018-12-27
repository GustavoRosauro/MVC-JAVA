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
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    </head>
    <body>
        <div>
            <%
                PessoasDAO dao = new PessoasDAO();
                int id = Integer.parseInt((String)request.getAttribute("id"));
                Pessoa p = dao.PessoaId(id);
            %>
        <h1>Atualizar Nomes</h1>
        <div class="col-md-12">
        <form action="Controlador">
            <input type="number" name="txtId" value="<%= p.getId()%>" hidden="true">
            <input type="text" name="txtNome" class="form-control" value="<%= p.getNome()%>">
            <input type="submit" name="accion" value="editar" class="btn btn-success">
        </form>
            </div>
        </div>
    </body>
</html>
