package io.github.testesspring.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public record ProdutoRequestDTO(@NotBlank(message = "Não permito campo em braco") @Size(min = 2, max = 100) String nome,
        @NotBlank(message = "Não permito campo em braco") @Size(min = 2, max = 1000) String descricao,
        @NotNull(message = "Não permito campo em braco") @Past LocalDate dataDeLancamento,
        @NotNull(message = "Não permito campo em braco") UUID compradorId) {
}