<%-- 
    Document   : solohtml
    Created on : 7 sep 2024, 9:24:23 a.m.
    Author     : emanu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>Formulario Empleados</h1>
        <a href="index.jsp">Menu</a>
        <div class="container">
        <form action="#" method="get" class="form-group"> <!-- get = envio por url, post = oculto --> 
            <label for="lbl_id" class="form-label"> <b>ID</b></label>
            <input type="text" name="txt_id" id="txt_id"  class="form-control" value="0" readonly>
            <label for="lbl_codigo" class="form-label"> <b>Codigo</b></label>
            <input type="text" name="txt_codigo" id="txt_codigo" class="form-control" placeholder="Ejemplo:E001" pattern="[E]{1}[0-9]{3}" required>
            <label for="lbl_nombres" class="form-label"> <b>Nombres</b></label>
            <input type="text" name="txt_nombres" id="txt_apellidos" class="form-control" placeholder="Ejemplo:E001" required>
            <label for="lbl_apellidos" class="form-label"> <b>Apellidos</b></label>
            <input type="text" name="txt_apellidos" id="txt_apeliidos" class="form-control" |placeholder="Ejemplo:E001" required> 
            <label for="lbl_direccion" class="form-label"> <b>Direccion</b></label>
            <input type="text" name="txt_direccion" id="txt_direccion" class="form-control" placeholder="Ejemplo:E001" required>
            <label for="lbl_telefono" class="form-label"> <b>Telefono</b></label>
            <input type="number" name="txt_telefono" id="txt_telefono" class="form-control" placeholder="Ejemplo:14151214" required> 
            <label for="lbl_fn" class="form-label"> <b>Nacimiento</b></label>
            <input type="date" name="txt_fn" id="txt_fn" class="form-control" placeholder="Ejemplo:1990-12-31" required> 
            <label for="lbl_puesto"> <b>Puestos</b></label>
            <select name="drop_puesto" id="drop_puesto"class="form-select">
                <option select>Seleccione</option>
                <option value="1">Programador</option>
                <option value="2">Analista</option>
            </select>   
            </br>
            <button name="btn_crear" id="btn_crear" class="btn btn-primary" value="crear">Crear</button>
            <button name="btn_actualizar" id="btn_actualizar" class="btn btn-warning" value="actualizar">Actualizar</button>
            <button name="btn_borrar" id="btn_borrar" class="btn btn-danger" value="borrar">Borrar</button>        
        </form>
        </div>
    </body>
</html>
