package galgje.ui.util;

import java.io.IOException;

public class GalgjeException extends RuntimeException {

    public GalgjeException(String message) {
        super(message);
    }

    public GalgjeException(String message, IOException e) {
        super(message, e);
    }
}
