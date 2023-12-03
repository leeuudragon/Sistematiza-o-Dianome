package br.com.projeto.faculdade.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PacoteNaoEncontradoException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public PacoteNaoEncontradoException(String ex) {
        super(ex);
    }

}
