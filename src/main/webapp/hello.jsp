<%-- //[START all]--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
</head>

<body>
    Hello <%= request.getAttribute("message") %>
</body>
</html>
<%-- //[END all]--%>