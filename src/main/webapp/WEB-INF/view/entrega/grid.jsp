<%-- 
    Document   : grid
    Created on : 17/11/2017, 01:08:52
    Author     : kaueholt
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="st" uri="/WEB-INF/static.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="title" value="Entregas" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><c:out value="${title}" /></title>
        <jsp:include page="../../include/vue-material.jsp"/>
        <st:css res="view/entrega/grid.css"/>
    </head>
    <body>
        <jsp:include page="../../include/layout.jsp">
            <jsp:param name="title" value="${title}" />
        </jsp:include>           
        <div id="app">
            <!-- FILTRO -->
            <div class="main-content">
                <md-card>
                    <md-card-header>
                        <div class="md-title">Editar Entregas</div>
                    </md-card-header>
                    <form novalidate @submit.stop.prevent="submit">
                        <md-input-container>
                            <label for="filtro">Selecionar entregas por...</label>
                            <md-select name="filtro" id="filtro" v-model="filtro">
                                <md-option value="dtatual">Data atual</md-option>
                                <md-option value="perdt">Período de datas</md-option>
                                <md-option value="pednresolv">A entregar</md-option>
                            </md-select>
                        </md-input-container>

                        <md-layout md-gutter>
                            <md-layout>
                                <md-input-container>
                                    <label>Data Inicial</label>
                                    <md-input type="date" name="dt-inicial"></md-input>
                                </md-input-container>
                            </md-layout>
                            <md-layout>
                                <md-input-container>
                                    <label>Data Final</label>
                                    <md-input type="date" name="dt-final"></md-input>
                                </md-input-container>
                            </md-layout>
                            <md-layout>
                                <div id="formRadios">
                                    <label><input type="radio" name="filtro" id="radioopt1">Minhas entregas</label></br>
                                    <label><input type="radio" name="filtro" id="radioopt2">Entregas abertas</label></br>
                                    <label><input type="radio" name="filtro" id="radioopt3">Entregas concluídas</label></br>
                                </div>
                            </md-layout>
                        </md-layout>
                        <md-button class="md-raised md-primary bt-align" id="filtrar">Filtrar</md-button>
                    </form>
                </md-card>
            </div>

            <!-- LISTA DE PEDIDOS -->
            <div class="main-content-table">
                <md-card>
                    <md-table v-once>
                        <md-table-header>
                            <md-table-row>
                                <md-table-head></md-table-head>
                                <md-table-head>Data Pedido</md-table-head>
                                <md-table-head>ID Pedido</md-table-head>
                                <md-table-head>Cliente</md-table-head>
                                <md-table-head>Endereço</md-table-head>
                                <md-table-head>Entregador</md-table-head>
                                <md-table-head>Entregue</md-table-head>
                                <md-table-head>Data Entrega</md-table-head>
                                <md-table-head>Cancelado</md-table-head>
                                <md-table-head>Data Cancelamento</md-table-head>
                                <md-table-head>Entrega Frustrada</md-table-head>
                                <md-table-head>Data Frustração</md-table-head>
                                <md-table-head>Justificativa</md-table-head>
                                <md-table-head>Observação</md-table-head>
                            </md-table-row>
                        </md-table-header>

                        <md-table-body>
                            <md-table-row v-for="(row, index) in 5" :key="index" md-selection>
                                <md-table-cell>01/01/2017</md-table-cell>
                                <md-table-cell>00000</md-table-cell>
                                <md-table-cell>John Doe</md-table-cell>
                                <md-table-cell>Rua XV, 15</md-table-cell>
                                <md-table-cell>Sr. Entregador</md-table-cell>
                                <md-table-cell>sim</md-table-cell>
                                <md-table-cell>17/09/2017</md-table-cell>
                                <md-table-cell></md-table-cell>
                                <md-table-cell></md-table-cell>
                                <md-table-cell></md-table-cell>
                                <md-table-cell></md-table-cell>
                                <md-table-cell></md-table-cell>
                                <md-table-cell>obs.</md-table-cell>
                            </md-table-row>
                        </md-table-body>
                    </md-table>
                </md-card>
            </div>
            <st:js res="view/${basePath}/grid.js"/>
    </body>
</html>
