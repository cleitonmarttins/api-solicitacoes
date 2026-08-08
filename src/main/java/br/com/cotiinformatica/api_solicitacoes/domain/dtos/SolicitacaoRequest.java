package br.com.cotiinformatica.api_solicitacoes.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SolicitacaoRequest(

        @NotBlank(message = "Por favor, informe o solicitante.")
        @Size(min = 6, max = 150, message = "O solicitante deve ter de 6 a 150 caracteres.")
        String solicitante,

        @NotBlank(message = "Por favor, informe a descrição.")
        @Size(min = 6, max = 1000, message = "O solicitante deve ter de 6 a 1000 caracteres.")
        String descricao,

        @NotBlank(message = "Por favor, informe a prioridade.")
        @Pattern(
            regexp = "^(BAIXA|MEDIA|ALTA|URGENTE)$",
            message = "A prioridade deve ter um dos valores: 'BAIXA', 'MEDIA', 'ALTA' ou 'URGENTE'."
        )
        String prioridade
) {
}
