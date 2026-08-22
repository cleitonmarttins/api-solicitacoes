package br.com.cotiinformatica.api_solicitacoes.infrastructure.repositories;

import br.com.cotiinformatica.api_solicitacoes.domain.model.Auditoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuditoriaRepository extends MongoRepository<Auditoria, UUID> {

}
