package com.userleonardolopez.forohub.controller;

import com.userleonardolopez.forohub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosPayload,
                                                                UriComponentsBuilder uri) {
        var topico = new Topico(datosPayload);
            topicoRepository.save(topico);

            var datosRespuestaTopico = new DatosRespuestaTopico(topico);
            URI url = uri.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
            return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoTopico>> mostrarTopicos() {
        List<DatosListadoTopico> topicos = topicoRepository.findAll().stream()
                .map(DatosListadoTopico::new)
                .toList();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopico> buscarTopico(@PathVariable Long id) {
        DatosListadoTopico topico;
        var topicoBuscado = topicoRepository.findById(id);

        if (topicoBuscado.isPresent()) {
            topico = new DatosListadoTopico(topicoBuscado.get());
            return ResponseEntity.ok(topico);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosPayload,
                                                                 @PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(datosPayload);

        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        var topicoBuscado = topicoRepository.findById(id);

        if (topicoBuscado.isPresent()) {
            topicoRepository.delete(topicoBuscado.get());

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
