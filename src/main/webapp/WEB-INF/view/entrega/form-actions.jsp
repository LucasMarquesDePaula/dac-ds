<%-- 
    Document   : form-actions
    Created on : 20/11/2017, 14:39:53
    Author     : Tom
--%>
<c:if test="${!empty model.id && model.cancelado == 0}">
    <md-card-actions>
        <c:if test="${model.entregaFrustrada == 0 && model.entregue == 0}">
            <form method="POST" action='${contextPath}/${basePath}/confirm-delivery/${model.id}'>
                <md-button type="submit" class="md-raised md-primary">
                    Confirmar Entrega
                </md-button>
            </form>
        </c:if>

        <c:if test="${model.entregaFrustrada == 0 && model.entregue == 0}">
            <form method="POST" action='${contextPath}/${basePath}/confirm-frustration/${model.id}'>
                <md-button type="submit" class="md-raised md-primary">
                    Entrega Frustrada
                </md-button>
            </form>
        </c:if>

        <c:if test="${model.entregue == 0}">
            <form method="POST" action='${contextPath}/${basePath}/cancel-delivery/${model.id}'>
                <md-button type="submit" class="md-raised md-primary">
                    Cancelar Entrega
                </md-button>
            </form>
        </c:if>

    </md-card-actions>
</c:if>