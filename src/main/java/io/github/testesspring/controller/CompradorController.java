package io.github.testesspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.testesspring.models.Comprador;
import io.github.testesspring.repo.CompradorRepo;

@RestController
@RequestMapping("/comprador")
public class CompradorController {

    private final CompradorRepo compradorRepo;

    public CompradorController(CompradorRepo compradorRepo) {
        this.compradorRepo = compradorRepo;
    }

    @PostMapping
    public ResponseEntity<Comprador> salvar(@RequestBody Comprador comprador) {
        Comprador compradorSalvo = compradorRepo.save(comprador);
        return ResponseEntity.status(HttpStatus.CREATED).body(compradorSalvo);
    }
}
