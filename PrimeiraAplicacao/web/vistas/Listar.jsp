<%-- 
    Document   : Listar
    Created on : 27/12/2018, 11:28:22
    Author     : Usuario
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PessoasDAO"%>
<%@page import="modelo.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Gustavo Calesita</title>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    </head>
    <body>
        <div class="col-md-12">
            
        <h1>Pessoas</h1>
        <a href="Controlador?accion=add" class="btn btn-success">Adicionar</a>
        <br/>
            <table border="1" class="table table-striped">
                <thead>
                    <tr>
                        <th>Registro</th>
                        <th>Nome</th>
                    </tr>
                </thead>
                <%
                    PessoasDAO dao = new PessoasDAO();
                    List<Pessoa> list = dao.retornaPessoas();
                    Iterator<Pessoa>iter = list.iterator();
                    Pessoa p = null;
                    while(iter.hasNext()){
                      p = iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= p.getId()%></td>
                        <td><%= p.getNome()%></td>
                        <td>
                            <a href="Controlador?accion=remover&id=<%= p.getId()%>" class="btn btn-danger">Deletar</a>
                            <a href="Controlador?accion=atualiza&id=<%= p.getId()%>" class="btn btn-warning">Editar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
