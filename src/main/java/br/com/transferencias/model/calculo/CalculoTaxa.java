package br.com.transferencias.model.calculo;

import java.math.BigDecimal;

import br.com.transferencias.model.Agendamento;

public interface CalculoTaxa {
	public BigDecimal calculandoValor(Agendamento agendamento);
}
