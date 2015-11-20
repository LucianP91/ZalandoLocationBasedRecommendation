<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title></title>
    <jsp:include page="/test"/>
</head>
<body>
<form name="myForm" action="dressPage.jsp" method="post">
    <input type="hidden" name="dressid1" id="dressid1">
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
                                        <button type="button" onclick="document.getElementById('dressid1').value='${dressid0}'; document.myForm.submit();">
                                            <img width="304px" src="${pic0}">
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress1">
                                        ${dress1}<br>
                                        <button type="button" onclick="document.getElementById('dressid1').value='${dressid1}'; document.myForm.submit();">
                                            <img width="304px" src="${pic1}">
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress2">
                                        ${dress2}<br>
                                            <button type="button" onclick="document.getElementById('dressid2').value='${dressid1}'; document.myForm.submit();">
                                                <img width="304px" src="${pic2}">
                                            </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress3">
                                        ${dress3}<br>
                                            <button type="button" onclick="document.getElementById('dressid1').value='${dressid3}'; document.myForm.submit();">
                                                <img width="304px" src="${pic3}">
                                            </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress4">
                                        ${dress4}<br>
                                            <button type="button" onclick="document.getElementById('dressid1').value='${dressid4}'; document.myForm.submit();">
                                                <img width="304px" src="${pic4}">
                                            </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress5">
                                        ${dress5}<br>
                                            <button type="button" onclick="document.getElementById('dressid1').value='${dressid5}'; document.myForm.submit();">
                                                <img width="304px" src="${pic5}">
                                            </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress6">
                                        ${dress6}<br>
                                            <button type="button" onclick="document.getElementById('dressid1').value='${dressid6}'; document.myForm.submit();">
                                                <img width="304px" src="${pic6}">
                                            </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress7">
                                        ${dress7}<br
                                            <button type="button" onclick="document.getElementById('dressid1').value='${dressid7}'; document.myForm.submit();">
                                                <img width="304px" src="${pic7}">
                                            </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress8">
                                        ${dress8}<br>
                                            <button type="button" onclick="document.getElementById('dressid1').value='${dressid8}'; document.myForm.submit();">
                                                <img width="304px" src="${pic8}">
                                            </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td id="dress9">
                                        ${dress9}<br>
                                            <button type="button" onclick="document.getElementById('dressid1').value='${dressid9}'; document.myForm.submit();">
                                                <img width="304px" src="${pic9}">
                                            </button>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td valign="top">Chosse the IP <br>
                <fieldset>
                    <input type="radio" name="ip" value="134.61.129.229" checked>Aachen<br>
                    <input type="radio" name="ip" value="134.130.234.100">Aachen<br>
                    <input type="radio" name="ip" value="91.102.137.146">Aachen<br>
                    <input type="radio" name="ip" value="194.15.156.99">Aachen-Stollberg<br>
                    <input type="radio" name="ip" value="129.187.51.52">München<br>
                    <input type="radio" name="ip" value="130.149.20.30">Berlin<br>
                </fieldset>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
