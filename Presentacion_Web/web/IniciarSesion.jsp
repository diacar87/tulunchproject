<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Page1
    Created on : 30-mar-2008, 17:37:28
    Author     : acactown
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{IniciarSesion.page1}" id="page1">
            <webuijsf:html binding="#{IniciarSesion.html1}" id="html1">
                <webuijsf:head binding="#{IniciarSesion.head1}" id="head1" title="Iniciar Sesion - Sistema para Gestion de Pedidos Tu Lunch.">
                    <webuijsf:link binding="#{IniciarSesion.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{IniciarSesion.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{IniciarSesion.form1}" id="form1">
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
                                                <span class="currentcrumb">Login - Iniciar Sesion</span>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div id="content">
                            <form action="#" id="member_login_form" method="post">
                                <table align="center" border="0" cellpadding="0" cellspacing="0" class="tableborder" style="width: 335 px">
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
                                                <div class="itempadbig" style="width: 325px">
                                                    <webuijsf:button actionExpression="#{IniciarSesion.actividad_action}" binding="#{IniciarSesion.actividad}"
                                                        id="actividad" style="margin: 5px 10px 5px 5px; font-size: 36px; height: 50px; width: 130px" text="Reset"/>
                                                    <webuijsf:textField binding="#{IniciarSesion.password}" columns="5" id="password" style="font-size: 40px" styleClass="campoPass"/>
                                                    <webuijsf:hiddenField binding="#{IniciarSesion.campoTemporal}" id="campoTemporal"/>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tableCellOne" colspan="2">
                                                <div class="panelDigitos" style="width: 330px">
                                                <webuijsf:button actionExpression="#{IniciarSesion.button1_action}" binding="#{IniciarSesion.button1}"
                                                    id="button1" style="margin: 5px; font-size: 50px; height: 100px; width: 100px" text="1"/>
                                                <webuijsf:button actionExpression="#{IniciarSesion.button2_action}" binding="#{IniciarSesion.button2}"
                                                    id="button2" style="margin: 5px; font-size: 50px; height: 100px; width: 100px" text="2"/>
                                                <webuijsf:button actionExpression="#{IniciarSesion.button3_action}" binding="#{IniciarSesion.button3}"
                                                    id="button3" style="margin: 5px; font-size: 50px; height: 100px; width: 100px" text="3"/>
                                                <webuijsf:button actionExpression="#{IniciarSesion.button4_action}" binding="#{IniciarSesion.button4}"
                                                    id="button4" style="margin: 5px; font-size: 50px; height: 100px; width: 100px" text="4"/>
                                                <webuijsf:button actionExpression="#{IniciarSesion.button5_action}" binding="#{IniciarSesion.button5}"
                                                    id="button5" style="margin: 5px; font-size: 50px; height: 100px; width: 100px" text="5"/>
                                                <webuijsf:button actionExpression="#{IniciarSesion.button6_action}" binding="#{IniciarSesion.button6}"
                                                    id="button6" style="margin: 5px; font-size: 50px; height: 100px; width: 100px" text="6"/>
                                                <webuijsf:button actionExpression="#{IniciarSesion.button7_action}" binding="#{IniciarSesion.button7}"
                                                    id="button7" style="margin: 5px; font-size: 50px; height: 100px; width: 100px" text="7"/>
                                                <webuijsf:button actionExpression="#{IniciarSesion.button8_action}" binding="#{IniciarSesion.button8}"
                                                    id="button8" style="margin: 5px; font-size: 50px; height: 100px; width: 100px" text="8"/>
                                                <webuijsf:button actionExpression="#{IniciarSesion.button9_action}" binding="#{IniciarSesion.button9}"
                                                    id="button9" style="margin: 5px; font-size: 50px; height: 100px; width: 100px" text="9"/>
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
