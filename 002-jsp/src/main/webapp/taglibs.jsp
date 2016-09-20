<%-- 
    Document   : page1
    Created on : 29-Jun-2016, 21:45:22
    Author     : marc.bouvier@davidson.fr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Taglibs</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/public/css/style.css"/>
    </head>
    <body>
        <h1>Taglibs</h1>
        <p>
            Initialisation d'une variable à partir d'une scriptlet<br/>
            <c:set var="dateCourante" value="<%=new java.util.Date()%>" />
            Utilisation de cette variable via EL (expression Language) dans une taglib de formattage de date.<br/>
        </p>
        <p class='code'><fmt:formatDate value="${dateCourante}" pattern='dd/MM/yyyy'/></p>
        
        <p><a href="<%=request.getContextPath()%>">Retour</a></p>
    </body>
</html>
