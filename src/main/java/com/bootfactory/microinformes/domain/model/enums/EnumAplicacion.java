package com.bootfactory.microinformes.domain.model.enums;


/**
 * Representa los tipos de aplicacion de los parámetros
 *
 */
public enum EnumAplicacion {
	
	/** Indica que el parametro aplica  */
	APLICA("comun.etiqueta.aplica"),
	/** Indica que el parametro NO aplica */
	NOAPLICA("comun.etiqueta.noaplica");

	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "Aplicación Contable"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumAplicacion(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización para el tipo de
	 * aplicación
	 * 
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}	
}

