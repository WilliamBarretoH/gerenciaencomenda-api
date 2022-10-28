package br.com.encomenda.gerenciaencomenda.repository;

import br.com.encomenda.gerenciaencomenda.entities.Encomenda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {

    Page<Encomenda> findAllOrderByNomeDestinatario(PageRequest pageRequest);
}
