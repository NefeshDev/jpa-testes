package io.github.testesspring.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ErroResponseDTO(LocalDateTime timestamp, int status, String message, List<FieldError> fields) {
    public record FieldError(String field, String message) {
    }
}
