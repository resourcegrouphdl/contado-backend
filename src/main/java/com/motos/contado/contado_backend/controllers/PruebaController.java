package com.motos.contado.contado_backend.controllers;


import com.motos.contado.contado_backend.dto.ResponsePrueba;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @GetMapping
    public ResponseEntity<ResponsePrueba> devController() {
        ResponsePrueba prueba = new ResponsePrueba();
        prueba.setCampoPrueba("probando probando ..");
        return ResponseEntity.ok().body(prueba);
    }

}
