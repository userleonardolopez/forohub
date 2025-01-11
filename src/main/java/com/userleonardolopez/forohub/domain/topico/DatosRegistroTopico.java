package com.userleonardolopez.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DatosRegistroTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotBlank
        String autor,

        @NotBlank
        String curso

) {
}
