package br.inatel.labs.repository;

import br.inatel.labs.entity.NotaCompraItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaCompraItemRepository extends JpaRepository<NotaCompraItem, Long> {
}
