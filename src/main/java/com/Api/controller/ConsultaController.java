package com.Api.controller;

import com.Api.dto.DadosAgendamentoConsulta;
import com.Api.dto.DadosCancelamentoConsulta;
import com.Api.infra.exception.ValidacaoException;
import com.Api.service.AgendaDeConsultas;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) throws ValidacaoException {
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) throws ValidacaoException {
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
