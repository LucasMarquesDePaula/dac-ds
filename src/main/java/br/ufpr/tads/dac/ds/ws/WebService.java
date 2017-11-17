package br.ufpr.tads.dac.ds.ws;

import java.util.HashMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
}
