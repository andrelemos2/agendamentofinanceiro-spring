package br.com.transferencias.model;

import java.math.BigDecimal;

/*
Operacoes do tipo D tem a taxa igual a A, B ou C dependendo do valor da transferência.
            Valores ate 25.000 seguem a taxacao tipo A.
            Valores de 25.001 ate 120.000 seguem a taxacao tipo B.
            Valores maiores que 120.000 seguem a taxacao tipo C.
 */
public class TaxaD implements CalculoTaxa {
	
	private static final BigDecimal VALOR_TETO_1 = new BigDecimal("25000");
	private static final BigDecimal VALOR_TETO_2 = new BigDecimal("120000");

	@Override
	public BigDecimal calculandoValor(Agendamento agendamento) {
		BigDecimal valor = agendamento.getValor();

		if (valor.compareTo(VALOR_TETO_1) <= 0)
			return TipoOperacao.A.getTaxa().calculandoValor(agendamento);
				else if (valor.compareTo(VALOR_TETO_1) > 0 && valor.compareTo(VALOR_TETO_2) <= 0)
					return TipoOperacao.B.getTaxa().calculandoValor(agendamento);
					else
						return TipoOperacao.C.getTaxa().calculandoValor(agendamento);

	}
}
