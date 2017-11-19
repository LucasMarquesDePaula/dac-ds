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
            <md-layout md-align="center">
                <md-layout md-flex="90">
                    <!-- FILTROS -->
                    <md-table-card>
                        <form>
                            <div class="field-group">
                                <md-layout :md-gutter="true">
                                    <md-layout md-flex="40">
                                        <md-input-container>
                                            <label for="select">Filtrar...</label>
                                            <md-select v-model="tipoFiltro">
                                                <md-option value="ep">Entregas Pendentes</md-option>
                                                <md-option value="ec">Entregas Concluídas</md-option>
                                            </md-select>
                                        </md-input-container>
                                    </md-layout>   
                                    <md-layout md-flex="10">
                                        <md-toolbar>
                                            <md-button type="submit" class="md-icon-button">
                                                <md-icon>search</md-icon>
                                            </md-button>
                                        </md-toolbar>
                                    </md-layout>
                                </md-layout>
                            </div>
                        </form>
                        
                        <!-- LISTA DE ENTREGAS -->
                        <md-table @sort="onSort" md-sort="${param.sortField}" md-sort-type="${param.sortDirection}">
                            <md-table-header>
                                <md-table-row>
                                    <md-table-head md-sort-by="id">Cód.</md-table-head>
                                    <md-table-head md-sort-by="nomeCliente">Nome Cliente</md-table-head>
                                    <md-table-head md-sort-by="endereco">Endereço</md-table-head>
                                    <md-table-head md-sort-by="observacao">Observação</md-table-head>
                                    <md-table-head md-sort-by="dataHoraCadastro">Data/Hora Cadastro</md-table-head>
                                    <md-table-head md-sort-by="pedidoId">ID Pedido</md-table-head>
                                    <md-table-head md-sort-by="entregue">Entregue?</md-table-head>
                                    <md-table-head md-sort-by="dataHoraEntrega">Data/Hora Entrega</md-table-head>
                                    <md-table-head md-sort-by="funcionarioEntregaId">ID Func. Entrega</md-table-head>
                                    <md-table-head md-sort-by="entregaFrustrada">Entrega Frustrada?</md-table-head>
                                    <md-table-head md-sort-by="dataHoraFrustracaoEntrega">Data/Hora Frustração</md-table-head>
                                    <md-table-head md-sort-by="justificativaFrustracaoEntrega">Justificativa</md-table-head>
                                    <md-table-head md-sort-by="cancelado">Cancelado?</md-table-head>
                                    <md-table-head md-sort-by="dataHoraCancelamento">Data/Hora Cancelamento</md-table-head>
                                    <md-table-head md-sort-by="funcionarioCancelamentoId">ID Func. Cancelamento</md-table-head>
                                </md-table-row>
                            </md-table-header>
                            <md-table-body>
                                <c:forEach var="item" items="${queryResult.list}">
                                    <md-table-row>
                                        <md-table-cell><c:out value="${item.id}"/></md-table-cell>
                                        <md-table-cell><c:out value="${item.nomeCliente}"/></md-table-cell>
                                        <md-table-cell><c:out value="${item.endereco}"/></md-table-cell>
                                        <md-table-cell><c:out value="${item.observacao}"/></md-table-cell>
                                        <md-table-cell><fmt:formatDate type="both" value="${item.dataHoraCadastro}"/></md-table-cell>
                                        <md-table-cell><c:out value="${item.pedidoId}"/></md-table-cell>
                                        <md-table-cell><c:out value="${(item.entregue==1) ? 'Sim' : 'Não'}"/></md-table-cell>
                                        <md-table-cell><fmt:formatDate type="both" value="${item.dataHoraEntrega}"/></md-table-cell>
                                        <md-table-cell><c:out value="${item.funcionarioEntrega}"/></md-table-cell>
                                        <md-table-cell><c:out value="${(item.entregaFrustrada==1) ? 'Sim' : 'Não'}"/></md-table-cell>
                                        <md-table-cell><fmt:formatDate type="both" value="${item.dataHoraFrustracaoEntrega}"/></md-table-cell>
                                        <md-table-cell><c:out value="${item.justificativaFrustracaoEntrega}"/></md-table-cell>
                                        <md-table-cell><c:out value="${(item.cancelado==1) ? 'Sim' : 'Não'}"/></md-table-cell>
                                        <md-table-cell><fmt:formatDate type="both" value="${item.dataHoraCancelamento}"/></md-table-cell>
                                        <md-table-cell><c:out value="${item.funcionarioCancelamento}"/></md-table-cell>
                                        <md-table-cell>
                                            <md-button class="md-icon-button" href="${contextPath}/${basePath}/form/${item.id}" target="_blank">
                                                <md-icon>edit</md-icon>
                                            </md-button>
                                        </md-table-cell>
                                    </md-table-row>
                                </c:forEach>
                            </md-table-body>
                        </md-table>
                        <div class="md-table-pagination">
                            <span class="md-table-pagination-label">Nº de Linhas: </span>
                            <span>${offset} - ${offset + limit > queryResult.count ? queryResult.count : offset + limit} de ${queryResult.count}</span>
                            <md-button class="md-icon-button" @click="prevPage(${limit}, ${offset}, ${queryResult.count})"  :disabled="${offset <= 0}">
                                <md-icon>keyboard_arrow_left</md-icon>
                            </md-button>
                            <md-button class="md-icon-button" @click="nextPage(${limit}, ${offset}, ${queryResult.count})" :disabled="${offset + limit > queryResult.count}">
                                <md-icon>keyboard_arrow_right</md-icon>
                            </md-button>
                        </div>
                    </md-table-card>
                </md-layout>
            </md-layout>
        </div>      
        <st:js res="view/entrega/grid.js"/>
    </body>
</html>
