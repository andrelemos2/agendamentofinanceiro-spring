package br.com.transferencias.model;

import java.math.BigDecimal;

public interface CalculoTaxa {
	public BigDecimal calculandoValor(Agendamento agendamento);
}
