package br.com.moby7.poi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableException extends Exception{

    private static final long serialVersionUID = 1L;

    public ServiceUnavailableException(String mensagem)  {
        super(mensagem);
    }
}
