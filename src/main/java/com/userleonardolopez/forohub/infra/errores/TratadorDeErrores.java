package com.userleonardolopez.forohub.infra.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<DatosRespuestaError> camposUnicosDuplicados(RuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new DatosRespuestaError(e.getCause().getCause().getLocalizedMessage()));
    }

}
