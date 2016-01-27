package br.com.financeiro.transferencias.builder;

import br.com.transferencias.model.Agendamento;

public class AgendamentoBuilderValido {

	private Agendamento instancia;

	public AgendamentoBuilderValido(Agendamento instancia) {
		this.instancia = instancia;
	}

	public Agendamento construir() {
		return this.instancia;
	}
}
