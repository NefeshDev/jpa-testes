package io.github.testesspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.testesspring.models.Produto;
import io.github.testesspring.repo.ProdutoRepo;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoRepo produtoRepo;

    public ProdutoController(ProdutoRepo produtoRepo) {
        this.produtoRepo = produtoRepo;
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoRepo.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }
}
