package br.com.moby7.poi.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DetalhesErro {
    private LocalDate timestamp;
    private String message;

    public DetalhesErro(LocalDate timestamp, String message) {
        super();
        this.timestamp = timestamp;
        this.message = message;
    }
}
