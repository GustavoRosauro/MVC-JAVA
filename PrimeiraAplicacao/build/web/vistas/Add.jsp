<%-- 
    Document   : Add
    Created on : 27/12/2018, 14:57:12
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <title>Adicionando mais um orelha</title>
    </head>
    <body>
        <h1>Adicionando mais um orelha!</h1>
        <div class="col-md-12">
        <form action="Controlador">
           Nome:<br>
           <div class="col-md-5">
           <input type="text" name="txtNome" class="form-control">
           </div>
           <br>
           <input type="submit" name="accion" value="Adicionar" class="btn btn-success">
        </form>
            </div>
    </body>
</html>
