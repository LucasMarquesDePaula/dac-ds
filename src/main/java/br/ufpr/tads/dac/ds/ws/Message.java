package br.ufpr.tads.dac.ds.ws;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lucas
 */
public class Message implements Serializable {

    private Map<String, String> parameters;

    public Message(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public Message(String... parameters) {
        for (int i = 0; i < parameters.length; i += 2) {
            addParameter(parameters[i], parameters[i + 1]);
        }
    }

    public Message() {
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(String key, String value) {
        if (getParameters() == null) {
            setParameters(new HashMap<>());
        }

        getParameters().put(key, value);
    }

    public String getParameter(String key) {
        if (getParameters() == null) {
            setParameters(new HashMap<>());
        }

        return getParameters().get(key);
    }
}
