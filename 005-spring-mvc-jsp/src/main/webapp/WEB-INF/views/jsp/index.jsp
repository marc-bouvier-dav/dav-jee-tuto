<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Exemple Spring MVC</title>


        <spring:url value="/resources/css/style.css" var="styleCss" />
        <link href="${styleCss}" rel="stylesheet" />
    </head>

    <div>
        <div>
            <h1>${title}</h1>
            <p>
                <c:if test="${not empty msg}">
                    Hello ${msg} (affiché si le message n'est pas vide)
                </c:if>

                <c:if test="${empty msg}">
                    Welcome Welcome! (affiché si le message est vide)
                </c:if>
            </p>
            <p>
                <a class="btn btn-primary btn-lg" href="<%= request.getContextPath() %>/hello/world" role="button"><%= request.getContextPath() %>/hello/world</a>
                <a class="btn btn-primary btn-lg" href="<%= request.getContextPath() %>/hello/n'importe quelle valeur" role="button"><%= request.getContextPath() %>/hello/n'importe quelle valeur</a>
            </p>
        </div>
    </div>

</div>

</body>
</html>