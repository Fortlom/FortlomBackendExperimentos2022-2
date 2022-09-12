package com.example.fortlomisw.shared.exception;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class HttpException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private HttpStatus estado;
    private String mensaje;


    public HttpException(HttpStatus estado, String mensaje) {
        super();
        this.estado = estado;
        this.mensaje = mensaje;
    }
    public HttpException(HttpStatus estado, String mensaje,String mensaje1) {
        super();
        this.estado = estado;
        this.mensaje = mensaje;
        this.mensaje=mensaje1;
    }
}
