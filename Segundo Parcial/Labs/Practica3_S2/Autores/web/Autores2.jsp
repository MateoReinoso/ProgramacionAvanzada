<%-- 
    Document   : Autores2
    Created on : 02/12/2019, 13:26:43
    Author     : Mateo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autor</title>
    </head>
    <body>
        <h1>Authors</h1>
        <div>
            <h3>Choose an author</h3>
            <form method="get">
                <input type="checkbox" name="author" value="Daniel">Daniel</br>
                <input type="checkbox" name="author" value="Mateo">Mateo</br>
                <input type="checkbox" name="author" value="Luis">Luis</br>
                <input type="submit" value="Save Authors">
            </form>
            <%
                String[] authors = request.getParameterValues("author");
                if (authors != null) {
            %>
            <h3> You have selected authors:</h3>
            <ol>
                <%
                    for (int i = 0; i < authors.length; ++i) {
                %>
                <li>
                    <%=authors[i]%>
                </li>
                <%
                    }
                %>
            </ol> 
            <a href ="<%request.getRequestURI();%>">BACK</a>
            <%}
            %>
    </body>
</html>
