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
<c:set var="title" value="Entregas" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><c:out value="${title}" /></title>
        <jsp:include page="../../include/vue-material.jsp"/>
        <st:css res="view/entrega/form.css" />
    </head>
    <body>
        <jsp:include page="../../include/layout.jsp">
            <jsp:param name="title" value="${title}" />
        </jsp:include>
        <div id="app">
            <md-layout md-align="center">
                <md-layout md-flex="66">
                    <c:if test="${!empty message}">
                        <md-card class="${messages == null || messages.length == 0 ? 'md-primary' : 'md-warn'}">
                            <md-card-header>
                                <div class="md-title">${message}</div>
                            </md-card-header>
                        </md-card>
                    </c:if>
                    <md-card>
                        <form method="POST" action='${contextPath}/entrega/${empty model.id ? "create" : "update"}/${model.id}' accept-charset="ISO-8859-1">
                            <md-card-content>
                                <md-layout :md-gutter="true">
                                    <c:if test="${!empty model.id}">
                                        <md-layout md-flex="10">
                                            <md-input-container>
                                                <label>Código</label>
                                                <md-input :readonly="true" name="id" type="number" value="${model.id}"></md-input>
                                            </md-input-container>
                                        </md-layout>
                                    </c:if>
                                    <md-layout>
                                        <md-input-container class="${empty messages.nome ? '' : 'md-input-invalid'}">
                                            <label>ID Pedido</label>
                                            <md-input name="pedido_id" :required="true" value="${model.pedidoId}"></md-input>
                                            <span class="md-error"><c:out value="${messages.pedidoId}"/></span>
                                        </md-input-container>
                                    </md-layout>
                                </md-layout>
                                <md-card-actions>
                                    <md-button type="submit" class="md-raised md-primary bt-align">Salvar</md-button>	
                                </md-card-actions>
                            </md-card-content>
                        </form>
                    </md-card>
                </md-layout>
            </md-layout>
        </div>
        <st:js res="vue-the-mask/vue-the-mask.js"/>
        <st:js res="view/entrega/form.js"/>
    </body>
</html>
