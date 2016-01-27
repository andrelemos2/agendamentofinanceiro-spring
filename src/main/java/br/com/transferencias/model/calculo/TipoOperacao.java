package br.com.transferencias.model.calculo;

import br.com.transferencias.model.taxa.TaxaA;
import br.com.transferencias.model.taxa.TaxaB;
import br.com.transferencias.model.taxa.TaxaC;
import br.com.transferencias.model.taxa.TaxaD;

public enum TipoOperacao {
	A("Taxa A") {
		@Override
		public CalculoTaxa getTaxa() {
			return new TaxaA();
		}
	},
	B("Taxa B") {
		@Override
		public CalculoTaxa getTaxa() {
			return new TaxaB();
		}
	},
	C("Taxa C") {
		@Override
		public CalculoTaxa getTaxa() {
			return new TaxaC();
		}
	},
	D("Taxa D") {
		@Override
		public CalculoTaxa getTaxa() {
			return new TaxaD();
		}
	};

	private final String nome;

	TipoOperacao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public abstract CalculoTaxa getTaxa();
}
