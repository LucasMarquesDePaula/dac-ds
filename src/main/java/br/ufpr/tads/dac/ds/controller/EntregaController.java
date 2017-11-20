package br.ufpr.tads.dac.ds.controller;

import br.ufpr.tads.dac.ds.facede.CrudFacede;
import br.ufpr.tads.dac.ds.facede.EntregaFacede;
import br.ufpr.tads.dac.ds.model.Authenticable;
import br.ufpr.tads.dac.ds.model.Entrega;
import br.ufpr.tads.dac.ds.model.Funcionario;
import br.ufpr.tads.dac.ds.ws.Message;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "EntregaController", urlPatterns = {"/entrega/*"})
public class EntregaController extends CrudController<Entrega> {

    private static final Logger logger = LoggerFactory.getLogger(FuncionarioController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void processNotCrudRequest(HttpServletRequest request, HttpServletResponse response, NotCrudActionException actionException) {
        try {
            String action = actionException.getAction();
            String[] pathParts = actionException.getPathParts();
            Integer id = Integer.parseInt(pathParts[2]);

            Funcionario funcionario = null;
            EntregaFacede facede = new EntregaFacede();
            Entrega model = null;
            
            Message message = null;
            Client client = null;

            try {
                funcionario = (Funcionario) request.getSession().getAttribute(Authenticable.class.getSimpleName());
            } catch (Exception ignored) {
            }

            switch (action) {
                case "confirm-delivery":
                    request.setAttribute("model", facede.confirmarEntrega(id, funcionario, new Date()));
                    request.setAttribute("message", "Entrega confirmada com sucesso!");
                    break;
                case "confirm-frustration":
                    String justificativa = request.getParameter("justificativaFrustracaoEntrega");
                    model = facede.confirmarFrustracao(id, justificativa, new Date());
                    request.setAttribute("model", model);

                    client = ClientBuilder.newClient();

                    message = new Message("justificativa", justificativa);

                    client.target(String.format("http://localhost:8080/lol/webresources/ws/delivery-frustrated/%d", model.getPedidoId()))
                            .request(MediaType.APPLICATION_JSON)
                            .put(Entity.entity(message, MediaType.APPLICATION_JSON), Message.class);

                    request.setAttribute("message", "Entrega frustrada gravada com sucesso!");
                    break;
                case "cancel-delivery":
                    request.setAttribute("model", facede.cancelarEntrega(id, funcionario, new Date()));
                    request.setAttribute("message", "Entrega cancelada com sucesso!");
                    break;
            }
        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            getLogger().debug("", ex);
        }
    }

    @Override
    protected void beforeCreate(HttpServletRequest request, HttpServletResponse response, Entrega model) {
        model.setDataHoraCadastro(new Date());
        model.setEntregue((byte) 0x0);
        model.setEntregaFrustrada((byte) 0x0);
        model.setCancelado((byte) 0x0);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    protected Entrega getModel() {
        return new Entrega();
    }

    @Override
    protected CrudFacede<Entrega> getFacede() {
        return new EntregaFacede();
    }

    @Override
    protected String getBasePath() {
        return "entrega";
    }
}
