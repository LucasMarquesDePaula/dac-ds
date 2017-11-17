package br.ufpr.tads.dac.ds.ws;

import br.ufpr.tads.dac.ds.facede.CrudFacede;
import br.ufpr.tads.dac.ds.facede.EntregaFacede;
import br.ufpr.tads.dac.ds.facede.ValidationException;
import br.ufpr.tads.dac.ds.model.Entrega;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lucas
 */
@Path("ws")
public class WebService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message get(Message message) {
        return new Message("hello", new HashMap<String, String>() {
            {
                put("arg1", "value1");
                put("arg2", "value2");
            }
        });
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(Message message) {

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message post(Message message) throws ValidationException {
        final Map<String, String> parameters = message.getParameters();
        final Entrega model = new Entrega();

        // Valores default
        model.setCancelado((byte) 0x0);
        model.setDataHoraCadastro(new Date());
        model.setEntregaFrustrada((byte) 0x0);
        model.setEntregue((byte) 0x0);

        // Valores passados como parâmetro
        model.setNomeCliente(parameters.get("nomeCliente"));
        model.setEndereco(parameters.get("endereco"));
        model.setObservacao(parameters.get("observacao"));
        model.setPedidoId(Integer.parseInt(parameters.get("pedidoId")));

        final CrudFacede<Entrega> facede = new EntregaFacede();

        facede.save(model);

        return new Message("ok", new HashMap<String, String>() {
            {
                put("entregaId", model.getId().toString());
            }
        });
    }
}
