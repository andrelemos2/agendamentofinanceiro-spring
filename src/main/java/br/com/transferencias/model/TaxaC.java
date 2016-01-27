package br.com.transferencias.model;

import java.math.BigDecimal;
/*
Operacoes do tipo C tem uma taxa regressiva conforme a data de agendamento:
            maior que 30 dias da data de cadastro ­ 1.2
            até 30 dias da data de cadastro ­ 2.1
            até 25 dias da data de cadastro ­ 4.3
            até 20 dias da data de cadastro ­ 5.4
            até 15 dias da data de cadastro ­ 6.7
            até 10 dias da data de cadastro ­ 7.4
            até  5 dias da data de cadastro ­ 8.3
 */
public class TaxaC implements CalculoTaxa {
	
	private static final BigDecimal DIVIDE_100 = new BigDecimal("100");

	@Override
	public BigDecimal calculandoValor(Agendamento agendamento) {

		BigDecimal porcentagemAdicional = BigDecimal.ONE;

		if(agendamento.getIntervaloDias() <= 5)
			porcentagemAdicional = new BigDecimal("8.3");
			else if (agendamento.getIntervaloDias() <= 10)
			porcentagemAdicional = new BigDecimal("7.4");
				else if (agendamento.getIntervaloDias() <= 15)
					porcentagemAdicional = new BigDecimal("6.7");
					else if (agendamento.getIntervaloDias() <= 20)
						porcentagemAdicional = new BigDecimal("5.4");
						else if (agendamento.getIntervaloDias() <= 25)
							porcentagemAdicional = new BigDecimal("4.3");
							else if (agendamento.getIntervaloDias() <= 30)
								porcentagemAdicional = new BigDecimal("2.1");
								else if (agendamento.getIntervaloDias() > 30)
									porcentagemAdicional = new BigDecimal("1.2");

		return agendamento.getValor().add(porcentagemAdicional.divide(DIVIDE_100));
	}
}
