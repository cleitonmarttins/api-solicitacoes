package br.com.cotiinformatica.api_solicitacoes.domain.interfaces;

import br.com.cotiinformatica.api_solicitacoes.domain.dtos.SolicitacaoRequest;
import br.com.cotiinformatica.api_solicitacoes.domain.dtos.SolicitacaoResponse;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface SolicitacaoService {

    SolicitacaoResponse criar(SolicitacaoRequest request) throws Exception;

    SolicitacaoResponse alterar(UUID id, SolicitacaoRequest request) throws Exception;

    SolicitacaoResponse alterarStatus(UUID id, String status) throws Exception;

    SolicitacaoResponse excluir(UUID id) throws Exception;

    Page<SolicitacaoResponse> consultar(int page, int size) throws Exception;

    SolicitacaoResponse obterPorId(UUID id) throws Exception;
}
