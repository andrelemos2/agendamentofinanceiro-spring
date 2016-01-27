package br.com.transferencias.model;

import java.math.BigDecimal;

/*
Operacoes do tipo A tem uma taxa de valor 2 mais 3 porcento do valor da transferencia
 */
public class TaxaA  implements CalculoTaxa{
	
	private static final BigDecimal VALOR_TAXA_ADICIONAL = new BigDecimal("2");
	private static final BigDecimal PORCENTAGEM_ADICIONAL = new BigDecimal("0.03");
	
	@Override
	public BigDecimal calculandoValor(Agendamento agendamento) {
		BigDecimal taxaFinal = agendamento.getValor().multiply(PORCENTAGEM_ADICIONAL).add(VALOR_TAXA_ADICIONAL);
		return agendamento.getValor().add(taxaFinal) ;
	}	

}
