package com.userleonardolopez.forohub.infra.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity camposPayloadVacios(MethodArgumentNotValidException e) {
        var errores = e.getFieldErrors().stream()
                .map(DatosErrorPayloadCamposVacios::new)
                .toList();

        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity sqlUniqueConstraintViolated(SQLIntegrityConstraintViolationException e) {
        var mensajeError = new DatosErrorSql(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(mensajeError);
    }

    private record DatosErrorPayloadCamposVacios(
            String campo, String error
    ){
        public DatosErrorPayloadCamposVacios(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

    private record DatosErrorSql(
            String error
    ){}
}
