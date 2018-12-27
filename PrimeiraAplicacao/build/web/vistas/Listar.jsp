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
    </head>
    <body>
        <h1>Pessoas</h1>
        <a href="Controlador?accion=add">Adicionar</a>
        <div>
            <table border="1">
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
                            <a href="Controlador?accion=remover&id=<%= p.getId()%>">Deletar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
