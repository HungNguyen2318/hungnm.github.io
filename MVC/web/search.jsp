<%-- 
    Document   : search
    Created on : Jun 5, 2019, 9:47:56 AM
    Author     : Acer
--%>

<%@page import="sample.registration.RegistrationCreateError"%>
<%@page import="sample.registration.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <font color="red">
        Welcome, ${sessionScope.USER} <br>
        <a href="logout">Logout</a>
        </font>
        <h1> Search Page </h1>
        <form  action="searchLastname">
            Search Value <input type="text" name="txtSearch" value="${param.txtSearch}"/> <br>
            <input type="submit" value="Search" name="btAction" />
        </form>

        <c:set var="searchValue" value="${param.txtSearch}"/>

        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>NO.</th>
                            <th>UserName</th>
                            <th>Password</th>
                            <th>Last Name</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form  action="update" method="POST">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${dto.userName}
                                    <input type="hidden" name="txtUsername" value="${dto.userName}" />
                                    
                                </td>
                                <td>

                                    <input type="text" name="txtPassword" value="${dto.password}" />
                                </td>
                                <td>
                                    ${dto.lastName}
                                </td>
                                <td>
                                    <input type="checkbox" name="chkAdmin" value="ON"
                                           <c:if test="${dto.role}">
                                               checked ="checked"
                                           </c:if>


                                           />
                                </td>
                                <td>
                                    <c:url var="delLink" value="deleteAcount">

                                        <c:param name="pk" value="${dto.userName}"/>
                                        <c:param name="lastSearchValue" value="${param.txtSearch}"/>

                                    </c:url>
                                    <a href="${delLink}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btAction" />
                                    <input type="hidden" name="lastSearchValue" value="${param.txtSearch}" />
                                </td>
                            </tr>
                        </form>

                    </c:forEach>
                </tbody>
            </table>
            <c:set var="error" value="${requestScope.UPDATEERROR}"/>
            <c:if test="${not empty error}" >
                <font color="red">
                ${error.passwordLengthErr}
                </font>
            </c:if>
        </c:if>
        <c:if test="${empty result}">
            <h2>No record is match</h2>
        </c:if>
    </c:if>
    <%--  <%
          Cookie[] cookies = request.getCookies();
          if (cookies != null) {
//                String username = cookies[cookies.length - 1].getName();
              String username = "";
              for (Cookie cookie : cookies) {
                  String temp = cookie.getName();
                  if (!temp.equals("JSESSIONID")) {
                      username = temp;
                  }
              }


        %> 
        <font color="red"> 
        welcome, <%= username%>
        </font>
        
        <a href="LogoutServlet">Logout</a>
        <%
            }
        %>

        <h1>Search Page</h1>
        <form name="txtSearch" action="DispatchServlet">
            Search Value <input type="text" name="txtSearch" value="<%= request.getParameter("txtSearch") != null ? request.getParameter("txtSearch") : "" %>"/> <br>
            <input type="submit" value="Search" name="btAction" />
        </form>
        <%
            String searchValue = request.getParameter("txtSearch");
            if (searchValue != null) {
                List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");
                if (result != null) {
        %> 
        <table border="1">
            <thead>
                <tr>
                    <th>NO.</th>
                    <th>UserName</th>
                    <th>Password</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (RegistrationDTO dto : result) {
                        String urlRewriting = "DispatchServlet"
                                + "?btAction=delete"
                                + "&pk="
                                + dto.getUserName()
                                + "&lastSearchValue="
                                + searchValue;

                %>
            <form action="DispatchServlet" method="POST">
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <%= dto.getUserName()%>

                        <input type="hidden" name="txtUsername" value="<%= dto.getUserName()%>" />
                    </td>
                    <td>
                        <input type="text" name="txtPassword" value="<%= dto.getPassword()%>" />
                    </td>

                    <td>
                        <%= dto.getLastName()%>
                    </td>
                    <td>
                        <input type="checkbox" name="chkAdmin" value="ON"
                               <%
                                   if (dto.isRole()) {
                               %> 
                               checked ="checked"
                               <%
                                   }

                               %>

                               />

                    </td>
                    <td>
                        <a href="<%= urlRewriting%>">Delete</a>
                    </td>
                    <td>
                        <input type="submit" value="Update" name="btAction" />
                        <input type="hidden" name="lastSearchValue" value="<%= searchValue%>" />

                    </td>
                </tr>

            </form>
                        
                        
                        
            <%
                }
            %>
        </tbody>
    </table>
        
        <% 
        RegistrationCreateError error = (RegistrationCreateError) request.getAttribute("UPDATEERROR");
        if(error != null) {
            if(error.getPasswordLengthErr() != null) {
                %>
                <font color="red">
                <%= error.getPasswordLengthErr() %>
                </font>
               <%
            }
            
        }
        %>
    <%
    } else {
    %> 
    <h2>No record is match</h2>
    <%
            }
        }//end if value is not null
    %> --%>
</body>
</html>
