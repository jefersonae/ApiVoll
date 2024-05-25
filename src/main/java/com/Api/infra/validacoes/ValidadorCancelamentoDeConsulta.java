package com.Api.infra.validacoes;

import com.Api.dto.DadosCancelamentoConsulta;
import com.Api.infra.exception.ValidacaoException;

public interface ValidadorCancelamentoDeConsulta {
    void validar(DadosCancelamentoConsulta dados) throws ValidacaoException;
}
