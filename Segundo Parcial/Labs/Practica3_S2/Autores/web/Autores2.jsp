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
        <h1>Autor!</h1>
        <div>
            <h3>
                Autor
                <form method="get">
                    <input type="checkbox" name="author" value="Mateo">Mateo <br>// hacer un jsp que vaya a la base un jsp con js llame un restfull
                    <input type="checkbox" name="author" value="Daniel">Daniel
                    <input type="checkbox" name="author" value="Luis">Luis
                    <input type="submit" value="Save Autor">
                </form>
                <% String[] autors = request.getParameterValues("autor");
                    if (autors != null) {

                %>
                <h3> tou have selected autors(s):</h3>
                <ol>
                    <% for (int i = 0; i < autors.length; i++) {
                    %>
                    <li><%=autors[i]%></li>
                        <%}%>
                </ol>
                <a href="<%=request.getRequestURI()%>">BACK</a>
                <%}%>
                
            </h3>
        </div>    
    </body>
</html>
