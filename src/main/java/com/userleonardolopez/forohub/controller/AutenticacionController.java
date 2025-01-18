package com.userleonardolopez.forohub.controller;

import com.userleonardolopez.forohub.domain.usuario.DatosAutenticacionUsuario;
import com.userleonardolopez.forohub.domain.usuario.Usuario;
import com.userleonardolopez.forohub.infra.security.DatosJwtToken;
import com.userleonardolopez.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {

        Authentication token = new UsernamePasswordAuthenticationToken(
                datosAutenticacionUsuario.login(), datosAutenticacionUsuario.clave());

        var tokenAutenticado = authenticationManager.authenticate(token);
        var jwt = tokenService.generarToken((Usuario) tokenAutenticado.getPrincipal());

        return ResponseEntity.ok(new DatosJwtToken(jwt));
    }

}
