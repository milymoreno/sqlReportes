package com.bootfactory.microinformes.domain.model.enums;


/**
 * Representa los valores posibles de la forma cómo el sistema hará el cálculo de los valores utilizados para una prórroga.
 */
public enum EnumFormaCalcularValorProrroga {
	
	BOT("ENM.FORMCALVALPRORROGA.1"),

	OCCIDENTE("ENM.FORMCALVALPRORROGA.2");
	
	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "EnumFormaCalcularValorProrroga"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumFormaCalcularValorProrroga(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización para la forma cómo el sistema hará el cálculo de los valores utilizados para una prórroga
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}		
	

}
