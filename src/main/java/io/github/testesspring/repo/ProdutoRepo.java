package io.github.testesspring.repo;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import io.github.testesspring.models.Produto;

public interface ProdutoRepo extends JpaRepository<Produto, UUID> {
}
