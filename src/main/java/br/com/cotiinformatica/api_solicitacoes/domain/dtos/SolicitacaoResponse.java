package br.com.cotiinformatica.api_solicitacoes.domain.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record SolicitacaoResponse(
        UUID id,
        String solicitante,
        String descricao,
        LocalDateTime dataHora,
        String status,
        String prioridade
) {
}
