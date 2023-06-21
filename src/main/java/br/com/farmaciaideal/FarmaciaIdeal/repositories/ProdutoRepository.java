package br.com.farmaciaideal.FarmaciaIdeal.repositories;

import br.com.farmaciaideal.FarmaciaIdeal.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
