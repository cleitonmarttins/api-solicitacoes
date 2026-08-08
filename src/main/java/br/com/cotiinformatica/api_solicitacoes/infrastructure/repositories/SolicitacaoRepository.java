package br.com.cotiinformatica.api_solicitacoes.infrastructure.repositories;

import br.com.cotiinformatica.api_solicitacoes.domain.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, UUID> {

}
