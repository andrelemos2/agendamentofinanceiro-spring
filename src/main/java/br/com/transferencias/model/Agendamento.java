package br.com.transferencias.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by andreasl on 22/12/15.
 */
@Entity
@Table(name = "agendamento")
public class Agendamento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codigo;
  private String contaDe;
  private String contaPara;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataAgendamento;
  private String descricao;
  @NotNull
  @Enumerated(EnumType.STRING)
  private TipoOperacao tipoOperacao;
  private BigDecimal valor;

  public Long getCodigo() {
    return codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public String getContaDe() {
    return contaDe;
  }

  public void setContaDe(String contaDe) {
    this.contaDe = contaDe;
  }

  public String getContaPara() {
    return contaPara;
  }

  public void setContaPara(String contaPara) {
    this.contaPara = contaPara;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public LocalDate getDataAgendamento() {
    return dataAgendamento;
  }

  public void setDataAgendamento(LocalDate dataAgendamento) {
    this.dataAgendamento = dataAgendamento;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public TipoOperacao getTipoOperacao() {
    return tipoOperacao;
  }

  public void setTipoOperacao(TipoOperacao tipoOperacao) {
    this.tipoOperacao = tipoOperacao;
  }
  
  public LocalDate getDataCadastro() {
		return LocalDate.now();
	}

  
  public long getIntervaloDias() {
		long dias = ChronoUnit.DAYS.between(getDataCadastro(), getDataAgendamento());
		return dias;
	}

}
