<%--
  Created by IntelliJ IDEA.
  User: Lucian
  Date: 20.11.2015
  Time: 00:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <jsp:include page="/test"/>
</head>
<body>
<form action="actionServlet" method="post">
<table>
    <tr>
        <td colspan="2">
            <h1>Welcome to Zalando location-based recommendations</h1>
        </td>
    </tr>
    <tr>
            <td><input id="searchField" name="searchField" value="" title="mySearchField"></td>
            <td align="left"><input type="submit" value="Submit"/>
    </tr>
    <tr>
        <td>
            <table id="clothItems">
                <tr>
                    <td>
                        <p>Message: ${myKey}</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        item2
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</form>
</body>
</html>
