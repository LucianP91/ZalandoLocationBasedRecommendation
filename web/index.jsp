<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <jsp:include page="/test"/>
</head>
<body>
<form action="dressPage.jsp" method="post">
    <table>
        <tr>
            <td>
                <table>
                    <tr>
                        <td colspan="2">
                            <h1>Welcome to <img src="https://secure-media.ztat.net/media/teaser/logo/zalando-logo.png">
                                location-based recommendations</h1>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table id="clothItems">
                                <tr>
                                    <td id="dress0">
                                        ${dress0}<br>
                                        <input type="image" src="${pic0}" width="304px">
                                        <input type="hidden" name="dressid" value="${dressid0}">
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress1">
                                        ${dress1}<br>
                                        <input type="image" src="${pic1}" width="304px">
                                        <input type="hidden" name="dressid" value="${dressid1}">
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress2">
                                        ${dress2}<br>
                                        <input type="image" src="${pic2}" width="304px">
                                        <input type="hidden" name="dressid" value="${dressid2}">
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress3">
                                        ${dress3}<br>
                                        <input type="image" src="${pic3}" width="304px">
                                        <input type="hidden" name="dressid" value="${dressid3}">
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress4">
                                        ${dress4}<br>
                                        <input type="image" src="${pic4}" width="304px">
                                        <input type="hidden" name="dressid" value="${dressid4}">
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress5">
                                        ${dress5}<br>
                                        <input type="image" src="${pic5}" width="304px">
                                        <input type="hidden" name="dressid" value="${dressid5}">
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress6">
                                        ${dress6}<br>
                                        <input type="image" src="${pic6}" width="304px">
                                        <input type="hidden" name="dressid" value="${dressid6}">
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress7">
                                        ${dress7}<br>
                                        <input type="image" src="${pic7}" width="304px">
                                        <input type="hidden" name="dressid" value="${dressid7}">
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress8">
                                        ${dress8}<br>
                                        <input type="image" src="${pic8}" width="304px">
                                        <input type="hidden" name="dressid" value="${dressid8}">
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress9">
                                        ${dress9}<br>
                                        <input type="image" src="${pic9}" width="304px">
                                        <input type="hidden" name="dressid" value="${dressid9}">
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td valign="top">Chosse the IP <br>
                <fieldset>
                    <input type="radio" name="ip" value="134.61.129.229">Aachen<br>
                    <input type="radio" name="ip" value="134.130.234.100">Aachen<br>
                    <input type="radio" name="ip" value="91.102.137.146">Aachen<br>
                    <input type="radio" name="ip" value="194.15.156.99">Aachen<br>
                    <input type="radio" name="ip" value="129.187.51.52">München<br>
                    <input type="radio" name="ip" value="130.149.20.30">Berlin<br>
                </fieldset>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
