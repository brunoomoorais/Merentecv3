package br.etec.merenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.etec.merenda.model.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {

}
