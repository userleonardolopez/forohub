package com.userleonardolopez.forohub.domain.topico;

public record DatosListadoTopico(

        String titulo,
        String mensaje,
        String fechaCreacion,
        String status,
        String autor,
        String curso

) {
    public DatosListadoTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
