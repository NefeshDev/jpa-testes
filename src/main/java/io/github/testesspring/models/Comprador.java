package io.github.testesspring.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_comprador")
@Getter
@Setter
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_comprador")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL)
    private List<Produto> produtos;
}
