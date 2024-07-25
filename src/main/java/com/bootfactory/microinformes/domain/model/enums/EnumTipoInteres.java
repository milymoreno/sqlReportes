package com.bootfactory.microinformes.domain.model.enums;

public enum EnumTipoInteres {
    
	EFECTANUAL("ENM.TIPOINTEREFECTANUAL.1"),
	TRIMANTICIPADA("ENM.TIPOINTERTRIMANTI.2"),
	NOMINAL("ENM.TIPONOMINAL.3");
	
	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "TipoTasa"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumTipoInteres(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización para 
	 * los conceptos
	 * 
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}		

}
