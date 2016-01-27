package br.com.transferencias.model.taxa;

import java.math.BigDecimal;

import br.com.transferencias.model.Agendamento;
import br.com.transferencias.model.calculo.CalculoTaxa;

/*
Operacoes do tipo B tem uma taxa de valor
            10 para pedidos com agendamento ate 30 dias da data de cadastro
            8 para os demais
 */
public class TaxaB implements CalculoTaxa {

	@Override
	public BigDecimal calculandoValor(Agendamento agendamento) {
		BigDecimal taxaAdicional = BigDecimal.ZERO;
		if (agendamento.getIntervaloDias() <= 30)
			taxaAdicional = BigDecimal.TEN;	
			else 
				taxaAdicional = new BigDecimal("8");	

		return agendamento.getValor().add(taxaAdicional);
	}
}
