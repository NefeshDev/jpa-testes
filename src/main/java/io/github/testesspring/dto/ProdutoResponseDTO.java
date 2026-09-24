package io.github.testesspring.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ProdutoResponseDTO(UUID id, String nome, String descricao, LocalDate dataDeLancamento) {
}
