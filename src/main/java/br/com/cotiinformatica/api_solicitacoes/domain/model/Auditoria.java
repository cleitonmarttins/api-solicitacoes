package br.com.cotiinformatica.api_solicitacoes.domain.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(collection = "auditoria")
public class Auditoria {

    @Id
    private UUID id;
    private LocalDateTime dataHora;
    private String solicitacao;
    private String operacao;
}
