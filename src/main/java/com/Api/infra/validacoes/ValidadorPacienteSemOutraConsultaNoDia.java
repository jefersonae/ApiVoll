package com.Api.infra.validacoes;

import com.Api.dto.DadosAgendamentoConsulta;
import com.Api.infra.exception.ValidacaoException;
import com.Api.repository.ConsultaRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta{

    private ConsultaRepository repository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) throws ValidacaoException {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoException("Paciente já tem uma consulta nesse dia");
        }
    }
}
