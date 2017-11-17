<%-- 
    Document   : form
    Created on : 17/11/2017, 01:08:43
    Author     : kaueholt
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="st" uri="/WEB-INF/static.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="title" value="Entrega" />

<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><c:out value="${title}" /></title>
        <jsp:include page="../../include/vue-material.jsp"/>
        <st:css res="view/entrega/form.css" />
        <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic'>
        <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
        <link rel='stylesheet prefetch' href='https://unpkg.com/vue-material@latest/dist/vue-material.css'>
        <jsp:include page="../../include/layout.jsp">
            <jsp:param name="title" value="${title}" />
        </jsp:include>


    </head>

    <body>
        <div id="app">
            <md-toolbar id="painel">
                <md-button class="md-icon-button">
                    <md-icon>menu</md-icon>
                </md-button>
                <h1 class="md-title">TADS Delivery System</h1>
            </md-toolbar>
            <div class="main-content">
                <md-table-card>
                    <md-toolbar>
                        <h2 class="md-title" style="flex: 1">Cadastro de Entrega</h2>
                    </md-toolbar>
                    <form novalidate @submit.stop.prevent="submit">

                        <md-layout md-gutter>
                            <md-layout>
                                <md-input-container>
                                    <label>ID Pedido</label>
                                    <md-input></md-input>
                                </md-input-container>
                            </md-layout>
                            <md-layout>
                                <md-input-container>
                                    <label>Data Pedido</label>
                                    <md-input></md-input>
                                </md-input-container>
                            </md-layout>

                        </md-layout>

                        <md-layout md-gutter>
                            <md-layout>
                                <md-input-container>
                                    <label>Nome Cliente</label>
                                    <md-input></md-input>
                                </md-input-container>
                            </md-layout>
                            <md-layout>
                                <md-input-container>
                                    <label>Endereço</label>
                                    <md-input></md-input>
                                </md-input-container>
                            </md-layout>
                        </md-layout>
                        <input type="checkbox" id="concluido" value="finished" onclick="toggleConcluidosVisibility()"style="cursor:pointer"><a id="textoConcluido" onclick="toggleCheckbox()" >Entrega Concluída</a>
                        <md-layout md-gutter id="concluidos">
                            <md-layout>
                                <md-input-container>
                                    <label>Nome Entregador</label>
                                    <md-input></md-input>
                                </md-input-container>
                            </md-layout>
                            <md-layout> 
                                <md-input-container>
                                    <label>Data Entrega</label>
                                    <md-textarea></md-textarea>
                                </md-input-container>
                            </md-layout>
                        </md-layout>
                    </form>

                </md-table-card>
                <md-button class="md-fab md-fab-bottom-right" id="salvar">
                    <md-icon>save</md-icon>
                </md-button>
            </div>
        </div>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/vue/2.1.6/vue.min.js'></script>
        <script src='https://unpkg.com/vue-material@latest'></script>

        <script  src="js/index.js"></script>

    </body>
</html>
