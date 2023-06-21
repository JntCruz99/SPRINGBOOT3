package br.com.farmaciaideal.FarmaciaIdeal.repositories;

import br.com.farmaciaideal.FarmaciaIdeal.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
