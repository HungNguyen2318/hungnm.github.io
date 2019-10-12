<%-- 
    Document   : processLogin
    Created on : Jun 20, 2019, 8:16:59 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Process Login</h1>
        <jsp:useBean id="loginAtt" class="sample.javabeans.LoginBean" scope="session"/>
        <jsp:setProperty name="loginAtt" property="username" param="txtUsername"/>
        <jsp:setProperty name="loginAtt" property="password" param="txtPassword"/>
        <%
            if (loginAtt.checkLogin()) {
                Cookie cookie = new Cookie(loginAtt.getUsername(), loginAtt.getPassword());
                cookie.setMaxAge(60 * 3);
                response.addCookie(cookie);
                response.sendRedirect("search.jsp");
            } else {
                response.sendRedirect("Invalid.html");
            }
        %>
    </body>
</html>
