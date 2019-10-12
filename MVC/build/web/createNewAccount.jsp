<%-- 
    Document   : createNewAccount
    Created on : Jun 14, 2019, 10:54:31 AM
    Author     : Acer
--%>

<%@page import="sample.registration.RegistrationCreateError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Create new Account</h1>
        <form action="createNewAccount" method="POST">
            <c:set var="error" value="${requestScope.CREATEER}"/>
            username <input type="text" name="txtUsername" value="${param.txtUsername}" /> (6 - 20 characters ) <br>
            
                <c:if test="${not empty error.userLengthErr}">
                    <font color="red">
                    ${error.userLengthErr} <br>
                    </font>
                </c:if>

            
            password <input type="password" name="txtPassword" value="" /> (6 - 30 characters ) <br>
            
                <c:if test="${not empty error.passwordLengthErr}">
                    <font color="red">
                    ${error.passwordLengthErr} <br>
                    </font>
                </c:if>

           
            confirm <input type="password" name="txtConfirm" value="" /> <br>
            
                <c:if test="${not empty error.confirmNotMatch}">
                    <font color="red">
                    ${error.confirmNotMatch} <br>
                    </font>
                </c:if>

            
            full name <input type="text" name="txtFullname" value="${param.txtFullname}" /> (6 - 20 characters ) <br>
            
                <c:if test="${not empty error.fullNameLengthErr}">
                    <font color="red">
                    ${error.fullNameLengthErr} <br>
                    </font>
                </c:if>

            
            <input type="submit" value="Sign up" name="btAction" />
            <input type="reset" value="Reset"  />
        </form>
        <%--       <%
                   RegistrationCreateError error = (RegistrationCreateError) request.getAttribute("CREATEER");
               %>
   <!--            username <input type="text" name="txtUsername" value="<%= request.getParameter("txtUsername")%>" /> (6 - 20 characters ) <br>-->
               <%
                   if (error != null) {
                       if (error.getUserLengthErr() != null) {
               %> 
               <font color="red">
               <%= error.getUserLengthErr()%>
               </font>
               <br>
               <%
                       }
                   }
               %> 
               password <input type="password" name="txtPassword" value="" /> (6 - 30 characters ) <br>
               <%
                   if (error != null) {
                       if (error.getPasswordLengthErr() != null) {
               %> 
               <font color="red">
               <%= error.getPasswordLengthErr()%>
               </font>
               <br>
               <%
                       }
                   }
               %>
               confirm <input type="password" name="txtConfirm" value="" /> <br>
               <%
                   if (error != null) {
                       if (error.getConfirmNotMatch() != null) {
               %> 
               <font color="red">
               <%= error.getConfirmNotMatch()%>
               </font>
               <br>
               <%
                       }
                   }
               %>
               full name <input type="text" name="txtFullname" value="<%= request.getParameter("txtFullname")%>" /> (6 - 20 characters ) <br>
               <%
                   if (error != null) {
                       if (error.getFullNameLengthErr() != null) {
               %> 
               <font color="red">
               <%= error.getFullNameLengthErr()%>
               </font>
               <br>
               <%
                       }
                   }
               %>
               <input type="submit" value="Sign up" name="btAction" />
               <input type="reset" value="Reset"  />

        </form>
        <%
            if (error != null) {
                if (error.getUsernameIsExisted() != null) {
        %> 
        <font color="red">
        <%= error.getUsernameIsExisted()%>
        </font>
        <br>
        <%
                }
            }
        %> --%>
    </body>
</html>
