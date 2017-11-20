<%-- 
    Document   : form-actions
    Created on : 20/11/2017, 14:39:53
    Author     : Tom
--%>
<c:if test="${!empty model.id && model.entregue == 0 && model.cancelado == 0}">
    <md-card-actions>
        <md-layout md-flex="50">
            <form method="POST" action='${contextPath}/${basePath}/confirm-frustration/${model.id}'>                               
                <md-input-container>
                    <label>Justificativa da Frustração</label>
                    <md-input name="justificativaFrustracaoEntrega" :required="true" value="${model.justificativaFrustracaoEntrega}"></md-input>
                </md-input-container>
                <md-button type="submit" class="md-raised md-primary">
                    Entrega Frustrada
                </md-button>
            </form>
        </md-layout>

        <md-layout md-flex="25">
            <form method="POST" action='${contextPath}/${basePath}/confirm-delivery/${model.id}'>
                <md-button type="submit" class="md-raised md-primary">
                    Confirmar Entrega
                </md-button>
            </form>
        </md-layout>

        <md-layout md-flex="25">
            <form method="POST" action='${contextPath}/${basePath}/cancel-delivery/${model.id}'>
                <md-button type="submit" class="md-raised md-primary">
                    Cancelar Entrega
                </md-button>
            </form>
        </md-layout>

    </md-card-actions>
</c:if>