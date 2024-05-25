package com.Api.infra.validacoes;

import com.Api.dto.DadosAgendamentoConsulta;
import com.Api.infra.exception.ValidacaoException;
import com.Api.repository.PacienteRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    private PacienteRepository repository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) throws ValidacaoException {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo){
            throw new ValidacaoException("O paciente está excluido");
        }
    }
}
