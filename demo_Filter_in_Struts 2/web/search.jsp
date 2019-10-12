<%-- 
    Document   : search
    Created on : Sep 4, 2019, 4:16:58 PM
    Author     : SE130008
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        Welcome, <font color="red">${sessionScope.USER.fullName}</font><br/>
        <s:a action="logout">Logout</s:a>       
        <s:form action="searchMobile">
            <s:textfield name="searchValue" label="Search value"/>
            <s:submit value="Search"/>
        </s:form>
        <s:if test="%{list != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Mobile name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="%{list}">
                        <tr>
                            <td>
                                <s:property value="mobileId"/>
                            </td>
                            <td>
                                <s:property value="mobileName"/>                                
                            </td>
                            <td>
                                <s:property value="price"/>                                
                            </td>
                            <td>
                                <s:property value="quantity"/>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>                    
            </table>
        </s:if>
        <s:if test="list == null and searchValue != null">
            <h2>
                No result found!!
            </h2>
        </s:if>
    </body>
</html>
