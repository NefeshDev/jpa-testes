package io.github.testesspring.controller.mapper;

import org.mapstruct.Mapper;

import io.github.testesspring.dto.ProdutoRequestDTO;
import io.github.testesspring.dto.ProdutoResponseDTO;
import io.github.testesspring.models.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    Produto toEntityProduto(ProdutoRequestDTO dto);

    ProdutoResponseDTO toDtoProduto(Produto produto);
}
