package br.ufpr.tads.dac.ds.facede;

import java.util.Map;

/**
 *
 * @author Lucas
 */
public class IllegalOperationException extends FacedeException {
    public IllegalOperationException() {
        super();
    }

    public IllegalOperationException(String message) {
        super(message);
    }

    public IllegalOperationException(String message, Map<String, String> messages) {
        super(message, messages);
    }
}
