package io.github.testesspring.controller.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.github.testesspring.dto.ErroResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponseDTO> handleValidation(MethodArgumentNotValidException ex) {
        var erros = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> new ErroResponseDTO.FieldError(err.getField(), err.getDefaultMessage())).toList();

        return ResponseEntity.badRequest()
                .body(new ErroResponseDTO(LocalDateTime.now(), 400, "Campo(s) inválido(s)", erros));
    }
}
