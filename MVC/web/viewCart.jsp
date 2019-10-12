<%-- 
    Document   : viewCart
    Created on : Jun 12, 2019, 9:57:07 AM
    Author     : Acer
--%>

<%@page import="java.util.Map"%>
<%@page import="sample.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BOOK STORE</title>
    </head>
    <body>
        <h1>View Your Cart</h1>
        <c:set var="session" value="${pageContext.session}"/>
        <c:if test="${not empty session}">
            <c:set var="cart" value="${sessionScope.CART}"/>
            <c:if test="${not empty cart}">
                <c:set var="items" value="${cart.items}"/>
                <c:if test="${not empty items}">

                    <table border="1">
                        <thead>
                            <tr>
                                <th>NO.</th>
                                <th>Title</th>
                                <th>Quantity</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <form action="removeItemsFromCart">
                            <tbody>

                                <c:forEach var="item" items="${items.entrySet()}" varStatus="counter">
                                    <tr>
                                        <td>
                                            ${counter.count}
                                        </td>
                                        <td>
                                            ${item.key}
                                        </td>
                                        <td>
                                            ${item.value}
                                        </td>
                                        <td>
                                            <input type="checkbox" name="chkItem" value="${item.key}" />
                                            
                                        </td>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td colspan="3">
                                        <a href="shoppingOnline.html">Add more book to your</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="remove selected items" name="btAction" />
                                    </td>


                                </tr>


                            </tbody>
                        </form>

                    </table>
                    <c:url var="checkOutLink" value="checkout">
                        


                    </c:url>
                    <a href="${checkOutLink}">Checkout</a>

                </c:if>
            </c:if>
        </c:if>
        <c:if test="${empty items}">
            <h2>No cart is existed!!!!</h2>
        </c:if>

<%--
        <%
            //1. kh den cho de xe
            if (session != null) {
                //2. kh lay xe
                CartObj cart = (CartObj) session.getAttribute("CART");
                if (cart != null) {
                    //3. get item
                    Map<String, Integer> items = cart.getItems();
                    if (items != null) {
        %> 
        <table border="1">
            <thead>
                <tr>
                    <th>NO.</th>
                    <th>Title</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <form action="DispatchServlet">
                <tbody>

                    <%
                        int count = 0;
                        for (Map.Entry item : items.entrySet()) {
                    %> 

                    <tr>
                        <td>
                            <%= ++count%>
                        </td>
                        <td>
                            <%= item.getKey()%>
                        </td>
                        <td>
                            <%= item.getValue()%>
                        </td>
                        <td>
                            <input type="checkbox" name="chkItem" value="<%= item.getKey()%>" />
                        </td>
                    </tr>
                    <%
                        }
                    %>

                    <tr>
                        <td colspan="3">
                            <a href="shoppingOnline.html">Add more book to your</a>
                        </td>
                        <td>
                            <input type="submit" value="remove selected items" name="btAction" />
                        </td>


                    </tr>


                </tbody>
            </form>

        </table>
        <br>
        <% String urlRewriting = "DispatchServlet?btAction=checkout";%>
        <a href="<%= urlRewriting%>">Checkout</a>


        <%
                        return;
                    }
                }
            }

        %>
        <h2>No cart is existed!!!!</h2> --%>

    </body>
</html>
