package com.Api.infra.validacoes;

import com.Api.dto.DadosAgendamentoConsulta;
import com.Api.infra.exception.ValidacaoException;

public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosAgendamentoConsulta dados) throws ValidacaoException;
}
