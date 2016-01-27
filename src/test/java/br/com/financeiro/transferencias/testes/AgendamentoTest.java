package br.com.financeiro.transferencias.testes;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Test;

import br.com.financeiro.transferencias.builder.AgendamentoBuilder;
import br.com.transferencias.model.Agendamento;
import br.com.transferencias.model.TipoOperacao;

public class AgendamentoTest {
	/*
	 * Operações do tipo A tem uma taxa de $2 mais 3% do valor da transferência
	 */
	@Test
	public void calculaTaxaA(){
		Agendamento agendamento = new AgendamentoBuilder()
				.comContaDe("05050-1")
				.comContaPara("04949-0")
				.comDataAgendamento(LocalDate.now().plusDays(1))
				.comValor(BigDecimal.TEN)
				.comTipoOperacao(TipoOperacao.A)
				.comCalculoValor()
				.construir();
		
		BigDecimal valorTotal = agendamento.getValor();

		assertEquals(new BigDecimal("12.3").doubleValue(), valorTotal.doubleValue(), 0.0001);
	}
	
	/*
	Operacoes do tipo B tem uma taxa de valor
	            10 para pedidos com agendamento ate 30 dias da data de cadastro
	            8 para os demais
	 */
	@Test
	public void calculaTaxaB() {
		Agendamento agendamento = new AgendamentoBuilder()
				.comContaDe("05050-1")
				.comContaPara("04949-0")
				.comDataAgendamento(LocalDate.now().plusDays(10))
				.comValor(BigDecimal.TEN)
				.comTipoOperacao(TipoOperacao.B)
				.comCalculoValor()
				.construir();
		
		BigDecimal valorTotal = agendamento.getValor();

		assertEquals(new BigDecimal("20.0").doubleValue(), valorTotal.doubleValue(), 0.0001);
	}
	
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
	@Test
	public void calculaTaxaC() {
		Agendamento agendamento = new AgendamentoBuilder()
				.comContaDe("05050-1")
				.comContaPara("04949-0")
				.comDataAgendamento(LocalDate.now().plusDays(4))
				.comValor(BigDecimal.TEN)
				.comTipoOperacao(TipoOperacao.C)
				.comCalculoValor()
				.construir();
		
		BigDecimal valorTotal = agendamento.getValor();

		assertEquals(new BigDecimal("10.083").doubleValue(), valorTotal.doubleValue(), 0.0001);
	}
	
	/*
	Operacoes do tipo D tem a taxa igual a A, B ou C dependendo do valor da transferência.
	            Valores ate 25.000 seguem a taxacao tipo A.
	            Valores de 25.001 ate 120.000 seguem a taxacao tipo B.
	            Valores maiores que 120.000 seguem a taxacao tipo C.
	 */
	@Test
	public void calculaTaxaD() {
		Agendamento agendamento = new AgendamentoBuilder()
				.comContaDe("05050-1")
				.comContaPara("04949-0")
				.comDataAgendamento(LocalDate.now().plusDays(40))
				.comValor(new BigDecimal("120000"))
				.comTipoOperacao(TipoOperacao.D)
				.comCalculoValor()
				.construir();
		
		BigDecimal valorTotal = agendamento.getValor();

		assertEquals(new BigDecimal("120008").doubleValue(), valorTotal.doubleValue(), 0.0001);
	}
	

}
