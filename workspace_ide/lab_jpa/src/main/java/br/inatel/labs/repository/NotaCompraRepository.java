package br.inatel.labs.repository;

import br.inatel.labs.entity.NotaCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaCompraRepository extends JpaRepository<NotaCompra, Long> {
}
