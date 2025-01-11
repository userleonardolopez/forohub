package com.userleonardolopez.forohub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    private String status;
    private String autor;
    private String curso;

    public Topico(DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.status = "Abierto";
        this.autor = datos.autor();
        this.curso = datos.curso();
    }

    public Topico() {}

    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getMensaje() {
        return mensaje;
    }
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public String getStatus() {
        return status;
    }
    public String getAutor() {
        return autor;
    }
    public String getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", status='" + status + '\'' +
                ", autor='" + autor + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Topico topico)) return false;
        return Objects.equals(getId(), topico.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    public void actualizarDatos(@Valid DatosActualizarTopico datosPayload) {
        this.titulo = datosPayload.titulo();
        this.mensaje = datosPayload.mensaje();
        this.autor = datosPayload.autor();
        this.curso = datosPayload.curso();
    }
}
