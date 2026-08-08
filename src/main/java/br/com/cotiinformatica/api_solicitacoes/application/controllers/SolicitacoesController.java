package br.com.cotiinformatica.api_solicitacoes.application.controllers;

import br.com.cotiinformatica.api_solicitacoes.domain.dtos.SolicitacaoRequest;
import br.com.cotiinformatica.api_solicitacoes.domain.dtos.SolicitacaoResponse;
import br.com.cotiinformatica.api_solicitacoes.domain.interfaces.SolicitacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/solicitacoes")
@RequiredArgsConstructor
public class SolicitacoesController {

    private final SolicitacaoService solicitacaoService;

    @PostMapping
    public ResponseEntity<SolicitacaoResponse> post(
            @Valid @RequestBody SolicitacaoRequest request)
            throws Exception {
        var response = solicitacaoService.criar(request);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<SolicitacaoResponse> put(
            @PathVariable UUID id,
            @Valid @RequestBody SolicitacaoRequest request)
            throws Exception {
        var response = solicitacaoService.alterar(id, request);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("{id}/status")
    public ResponseEntity<SolicitacaoResponse> patch(
            @PathVariable UUID id,
            @RequestParam String status)
            throws Exception {
        var response = solicitacaoService.alterarStatus(id, status);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SolicitacaoResponse> delete(
            @PathVariable UUID id)
            throws Exception {
        var response = solicitacaoService.excluir(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<Page<SolicitacaoResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size)
            throws Exception {
        var response = solicitacaoService.consultar(page, size);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<SolicitacaoResponse> getById(
            @PathVariable UUID id)
            throws Exception {
        var response = solicitacaoService.obterPorId(id);
        return ResponseEntity.ok().body(response);
    }
}
