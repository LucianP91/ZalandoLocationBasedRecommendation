<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <jsp:include page="/actionServlet"/>
</head>
<body>
<table>
    <tr>
        <td>
            <h1>Dein wundervolles Kleid auf das du gerade drauf geklickt hast.</h1>
        </td>
    </tr>
    <tr>
        <td>
            <table>
                <tr>
                    <td><img src="${bild}" height=400px></td>
                </tr>
            </table>
        </td>
        <td valign="top">
            <table>
                <tr>
                    <td>${preis}</td>
                </tr>
                <tr>
                    <td>${name}</td>
                </tr>
                <tr>
                    <td>
                        <form>
                            <input type="submit" name="Kaufen">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>IP: ${ip}</td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
