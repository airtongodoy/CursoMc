package br.com.airtongodoy.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente Pagamento"),
	QUITADO(2, "Pagamento Quitado"),
	CANCELADO(3, "Pagamento Cancelado");
	
	private int codigo;
	private String descricao;
	
	private EstadoPagamento(int  codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(EstadoPagamento estado : EstadoPagamento.values()) {
			if(codigo.equals(estado.getCodigo())) {
				return estado;
			}
		}
		
		throw new IllegalArgumentException("Código estado de pagamento não identificado");
		
	}
}
