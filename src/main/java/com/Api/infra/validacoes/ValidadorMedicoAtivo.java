package com.Api.infra.validacoes;

import com.Api.dto.DadosAgendamentoConsulta;
import com.Api.infra.exception.ValidacaoException;
import com.Api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private MedicoRepository repository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) throws ValidacaoException {
        if(dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findByAtivoTrue(dados.idMedico());
        if(!medicoEstaAtivo) {
            throw new ValidacaoException("Não é possível realizar o agendamento da consulta");
        }
    }
}
