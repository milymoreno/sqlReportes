package com.bootfactory.microinformes.domain.model.enums;

/**
 * Representa los valores posibles del tipo Causación de Interés de mora
 *
 */
public enum EnumTipoCausacionMora {
	
	
	/** CC422-CU137 Indica que el tipo de causacion tendra el valor lineal */
	LINEAL("ENM.CAUTIPINTMOR.1"),

	/** CC422-CU137 Indica que el tipo de causacion tendra el valor exponencial */
	EXPONENCIAL("ENM.CAUTIPINTMOR.2");
	
	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "TipoCausacionMora"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumTipoCausacionMora(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización para el tipo de
	 * de causación de interés de mora
	 * 
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}		
	

}
