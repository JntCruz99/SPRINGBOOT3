package br.com.farmaciaideal.FarmaciaIdeal.repositories;

import br.com.farmaciaideal.FarmaciaIdeal.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
