<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Mesero
    Created on : 31-mar-2008, 0:02:28
    Author     : acactown
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{Mesero.page1}" id="page1">
            <webuijsf:html binding="#{Mesero.html1}" id="html1">
                <webuijsf:head binding="#{Mesero.head1}" id="head1" title="Interfaz Mesero - Sistema para Gestion de Pedidos Tu Lunch.">
                    <webuijsf:link binding="#{Mesero.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Mesero.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{Mesero.form1}" id="form1">
                        <div id="pageheader">
                            <table border="0" cellpadding="0" cellspacing="0" style="width: 100%;">
                                <tbody>
                                    <tr>
                                        <td>
                                            <div class="heading">Sistema para Gestion de Pedidos Tu Lunch.</div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div id="subheader">
                            <table border="0" cellpadding="0" cellspacing="0" style="width: 99%;">
                                <tbody>
                                    <tr>
                                        <td>
                                            <div class="breadcrumb">
                                                <span class="currentcrumb">Vista Interfaz Mesero</span>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div id="content">
                            <form action="#" id="member_login_form" method="post">
                                <table align="center" border="0" cellpadding="0" cellspacing="0" class="tableborder" style="width: 700px">
                                    <tbody>
                                        <tr>
                                            <td class="profileHeadingBG" colspan="2" style="height: 25px">
                                                <div class="tableHeading">Autenticacion Requerida</div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tableRowHeadingBold" colspan="2">Por favor indique su ID:</td>
                                        </tr>
                                        <tr>
                                            <td class="tableCellTwo" style="height: 69px">
                                                <div class="itempadbig"
                                                        style="width: 500px">
                                                 
                                                <webuijsf:textField
                                                        binding="#{Mesero.t}" id="t"/>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tableCellOne" colspan="2">
                                                <div class="panelMesero" style="width: 500px">
                                                    hola
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                        <div id="footer">
                            Sistema para Gestion de Pedidos Tu Lunch. + <a href="http://www.developerdreamteam.co.nr/">Powered by Developer Dream Team</a>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
