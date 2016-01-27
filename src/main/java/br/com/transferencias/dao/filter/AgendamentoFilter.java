package br.com.transferencias.dao.filter;


import java.math.BigDecimal;

import br.com.transferencias.model.TipoOperacao;

/**
 * Created by andreasl on 22/12/15.
 */
public class AgendamentoFilter {


  private BigDecimal valorInicial;
  private BigDecimal valorFinal;
  private TipoOperacao tipoOperacao;

  public BigDecimal getValorInicial() {
    return valorInicial;
  }

  public void setValorInicial(BigDecimal valorInicial) {
    this.valorInicial = valorInicial;
  }

  public BigDecimal getValorFinal() {
    return valorFinal;
  }

  public void setValorFinal(BigDecimal valorFinal) {
    this.valorFinal = valorFinal;
  }

  public TipoOperacao getTipoOperacao() {
    return tipoOperacao;
  }

  public void setTipoOperacao(TipoOperacao tipoOperacao) {
    this.tipoOperacao = tipoOperacao;
  }
}
