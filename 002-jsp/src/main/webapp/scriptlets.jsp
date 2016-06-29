<%-- 
    Document   : page1
    Created on : 29-Jun-2016, 21:45:22
    Author     : Marc Bouvier
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scriptlets Java</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/public/css/style.css"/>
    </head>
    <body>
        <h1>Scriptlets Java</h1>
        <p>
            <%
                //Scriptlet dans laquelle on peut écrire du code Java
                out.print("Date du jour : ");
                out.println(new Date());
                
                %>
        </p>
        
        <p><a href="<%=request.getContextPath()%>">Retour</a></p>
    </body>
</html>
