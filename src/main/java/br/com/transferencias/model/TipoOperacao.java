package br.com.transferencias.model;

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
