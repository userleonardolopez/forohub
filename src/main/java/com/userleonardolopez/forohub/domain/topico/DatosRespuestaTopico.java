package com.userleonardolopez.forohub.domain.topico;

public record DatosRespuestaTopico(

        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String status,
        String autor,
        String curso

) {
    public DatosRespuestaTopico(Topico topico) {
        this(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getFechaCreacion(),
            topico.getStatus(),
            topico.getAutor(),
            topico.getCurso()
        );
    }
}
