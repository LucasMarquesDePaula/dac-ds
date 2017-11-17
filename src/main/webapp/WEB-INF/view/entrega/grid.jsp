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
<c:set var="title" value="Entrega" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><c:out value="${title}" /></title>
        <jsp:include page="../../include/vue-material.jsp"/>
        <st:css res="view/entrega/grid.css" />
    </head>
    <body>
        <jsp:include page="../../include/layout.jsp">
            <jsp:param name="title" value="${title}" />
        </jsp:include>
        <div id="app">
            <script type="text/x-template" id="modal-template">
                <transition name="modal">
                <div class="modal-mask">
                <div class="modal-wrapper">
                <div class="modal-container">

                <div class="modal-header">
                <slot name="header">
                default header
                </slot>
                </div>

                <div class="modal-body">
                <slot name="body">
                default body
                </slot>
                </div>

                <div class="modal-footer">
                <slot name="footer">
                default footer
                <button class="modal-default-button" @click="$emit('close')">
                OK
                </button>
                </slot>
                </div>
                </div>
                </div>
                </div>
                </transition>
            </script>
            <div id="app">
                <md-toolbar id="painel">
                    <md-button class="md-icon-button">
                        <md-icon>menu</md-icon>
                    </md-button>
                    <h1 class="md-title">TADS Delivery System</h1>
                </md-toolbar>

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
                                    <div class="radio">
                                        <label><input type="radio" name="radioopt">Minhas entregas</label>
                                    </div>
                                    <div class="radio">
                                        <label><input type="radio" name="radioopt">Entregas abertas</label>
                                    </div>
                                    <div class="radio">
                                        <label><input type="radio" name="radioopt">Entregas concluídas</label>
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
                    <md-button class="md-raised md-primary bt-align" id="confirmar" @click="showModalConfirmar = true">Confirmar entrega(s)
                    </md-button>
                    <md-button class="md-raised md-primary bt-align" id="problema" @click="showModalProblema = true">Informar problema
                    </md-button>
                    <md-button class="md-raised md-primary bt-align" id="cancelar" @click="showModalCancelar = true">Cancelar entrega(s)
                    </md-button>
                </div>
                <modal v-if="showModalConfirmar" @close="showModalConfirmar = false">
                    <h3 slot="header">Selecionar entregador</h3>
                    <h5 slot="body">AQUI: RESUMO DAS SELEÇÕES</h5>
                    <h5 slot="footer">AQUI: COMBOBOX DE FUNCIONARIOS
                        <div style="display:inline">
                            <button class="modal-default-close-button" @click="showModalConfirmar = false">Cancelar
                                <button class="modal-default-button" @click="showModalConfirmar = false">OK
                                </button></div></h5>
                </modal>
                <modal v-if="showModalProblema" @close="showModalProblema = false">
                    <h3 slot="header">Informar problema nas entregas</h3>
                    <h5 slot="body">AQUI: RESUMO DAS SELEÇÕES</h5>
                    <h5 slot="footer">AQUI: COMBOBOX DE PROBLEMAS PRÉ DEFINIDOS E CAMPO DE TEXTO PARA JUSTIFICAR OS PROBLEMAS DIFERENTES
                        <div style="display:inline">
                            <button class="modal-default-close-button" @click="showModalProblema = false">Cancelar
                                <button class="modal-default-button" @click="showModalProblema = false">OK
                                </button></div></h5>
                </modal>
                <modal v-if="showModalCancelar" @close="showModalCancelar = false">
                    <h3 slot="header">Cancelar entregas?</h3>
                    <h5 slot="body">AQUI: RESUMO DAS SELEÇÕES</h5>
                    <h5 slot="footer">AQUI: PERGUNTA: "VOCÊ REALMENTE DESEJA CANCELAR ESSAS ENTREGAS?
                        <div style="display:inline">
                            <button class="modal-default-close-button" @click="showModalCancelar = false">Cancelar
                                <button class="modal-default-button" @click="showModalCancelar = false">OK
                                </button></div></h5>
                </modal>
            </div>
            <script src='https://cdnjs.cloudflare.com/ajax/libs/vue/2.1.6/vue.min.js'></script>
            <script src='https://unpkg.com/vue-material@latest'></script>

            <script  src="js/index.js"></script>

    </body>
</html>
