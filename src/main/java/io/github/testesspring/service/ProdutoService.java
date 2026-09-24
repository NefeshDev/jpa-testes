package io.github.testesspring.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.testesspring.controller.mapper.ProdutoMapper;
import io.github.testesspring.dto.ProdutoRequestDTO;
import io.github.testesspring.dto.ProdutoResponseDTO;
import io.github.testesspring.exception.ResourceNotFoundException;
import io.github.testesspring.repo.CompradorRepo;
import io.github.testesspring.repo.ProdutoRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepo produtoRepo;
    private final ProdutoMapper produtoMapper;
    private final CompradorRepo compradorRepo;

    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {
        var produto = produtoMapper.toEntityProduto(dto);
        var comprador = compradorRepo.findById(dto.compradorId())
                .orElseThrow(() -> new RuntimeException("Comprador não encontrado!"));
        produto.setComprador(comprador);
        var produtoSalvo = produtoRepo.save(produto);
        return produtoMapper.toDtoProduto(produtoSalvo);
    }

    public ProdutoResponseDTO buscarPorId(String id) {
        var produtoEncontrado = produtoRepo.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        return produtoMapper.toDtoProduto(produtoEncontrado);
    }
}
