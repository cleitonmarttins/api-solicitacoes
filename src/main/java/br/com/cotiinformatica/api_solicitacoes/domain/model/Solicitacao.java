package br.com.cotiinformatica.api_solicitacoes.domain.model;

import br.com.cotiinformatica.api_solicitacoes.domain.enums.PrioridadeSolicitacao;
import br.com.cotiinformatica.api_solicitacoes.domain.enums.StatusSolicitacao;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "solicitacoes")
@Data
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column(length = 150, nullable = false)
    private String solicitante;

    @Column(length = 1000, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusSolicitacao status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PrioridadeSolicitacao prioridade;
}
