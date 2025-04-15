package co.com.mercadolibre.obteniendoedaddepersona.obteniendolaedaddeunapersona.exception;

import org.springframework.http.HttpStatus;

public class NumberException extends RuntimeException {

    public NumberException(String message) {
        super(message);
    }
}
