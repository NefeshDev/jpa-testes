package io.github.testesspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.testesspring.dto.ProdutoRequestDTO;
import io.github.testesspring.dto.ProdutoResponseDTO;
import io.github.testesspring.models.Produto;
import io.github.testesspring.repo.ProdutoRepo;
import io.github.testesspring.service.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> salvar(@Valid @RequestBody ProdutoRequestDTO produto) {
        var produtoSalvo = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> pesquisarPorId(@RequestParam("id") String id) {
        var produtoEncontrado = produtoService.buscarPorId(id);
        return ResponseEntity.ok().body(produtoEncontrado);
    }
}
