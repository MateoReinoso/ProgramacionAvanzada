<%-- 
    Document   : listar
    Created on : 04/12/2019, 0:47:21
    Author     : Mateo
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.Zona"%>
<%@page import="java.util.List"%>
<%@page import="modelDAO.ZonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Zonas</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Ciudad</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <%
                    ZonaDAO zdao = new ZonaDAO();
                    List<Zona> list = zdao.listar();
                    Iterator<Zona> iter = list.iterator();
                    Zona zn = null;
                    while (iter.hasNext()) {
                        zn = iter.next();
                %>
                <tbody>
                    <tr>
                        <td><%= zn.getCodigo()%></td>
                        <td><%= zn.getNombre()%></td>
                        <td><%= zn.getCiudad()%></td>
                        <td></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
