package br.com.financeiro.transferencias.builder;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.transferencias.model.Agendamento;
import br.com.transferencias.model.calculo.CalculoTaxa;
import br.com.transferencias.model.calculo.TipoOperacao;

public class AgendamentoBuilder {

	private Agendamento instancia;
	

	public AgendamentoBuilder() {
		this.instancia = new Agendamento();
	}

	public AgendamentoBuilder comContaDe(String contaDe) {
		this.instancia.setContaDe(contaDe);
		return this;
	}
	
	public AgendamentoBuilder comContaPara(String contaPara) {
		this.instancia.setContaPara(contaPara);
		return this;
	}
	
	public AgendamentoBuilder comDataAgendamento(LocalDate dataAgendamento) {
		this.instancia.setDataAgendamento(dataAgendamento);
		return this;
	}
	
	public AgendamentoBuilder comValor(BigDecimal valor) {
		this.instancia.setValor(valor);
		return this;
	}
	
	public AgendamentoBuilder comTipoOperacao(TipoOperacao tipoOperacao) {
		this.instancia.setTipoOperacao(tipoOperacao);
		return this;
	}
	
	public AgendamentoBuilderValido comCalculoValor(){
		TipoOperacao tipoOperacao = this.instancia.getTipoOperacao();
		CalculoTaxa calculoTaxa = tipoOperacao.getTaxa();
		BigDecimal valor = calculoTaxa.calculandoValor(this.instancia);
		this.instancia.setValor(valor);
		return new AgendamentoBuilderValido(instancia);
	}

}
