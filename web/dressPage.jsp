<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title></title>
    <jsp:include page="/actionServlet"/>
</head>
<body>
<table>
    <tr>
        <td colspan="2">
            <h1>Dein wundervolles Kleid auf das du gerade drauf geklickt hast.</h1>
        </td>
    </tr>
    <tr>
        <td>
            <table>
                <tr>
                    <td><img src="${bild}" height=600px></td>
                </tr>
            </table>
        </td>
        <td valign="top">
            <table>
                <tr>
                    <td colspan="2">${preis}</td>
                </tr>
                <tr>
                    <td colspan="2">${name}</td>
                </tr>
                <tr>
                    <td width="1%">
                        <form action="index.jsp" method="post">
                            <input type="hidden" value="${id}" name="id">
                            <input type="hidden" value="${ip}" name="ip">
                            <input type="submit" name="Kaufen" value="Kaufen">
                        </form>
                    </td>
                    <td>
                        <form action="index.jsp" method="post">
                            <input type="submit" value="Zurück">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">${warnung}</td>
                </tr>
                <tr>
                    <td>
                        <form name="myForm" action="dressPage.jsp" method="post">
                            <input type="hidden" name="dressid1" id="dressid1">
                            <input type="hidden" name="ip" id="ip">
                            ${htmlText}
                        </form>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
