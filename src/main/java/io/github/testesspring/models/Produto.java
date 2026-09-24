package io.github.testesspring.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_produtos")
@Getter
@Setter
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_produto")
    private UUID id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "descricao_produto")
    private String descricao;

    @Column(name = "data_de_lancamento")
    private LocalDate dataDeLancamento;

    @ManyToOne
    private Comprador comprador;
}
