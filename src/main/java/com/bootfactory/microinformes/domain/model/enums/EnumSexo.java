package com.bootfactory.microinformes.domain.model.enums;


/**
 * Representa los tipos de sexo
 * @author Administrador
 *
 */
public enum EnumSexo {
	
	/** Indica sexo femenimo  */
	FEMENINO("ENM.SEXO.1"),
	/** Indica sexo masculino */
	MASCULINO("ENM.SEXO.2");

	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "Tipo Comisión"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumSexo(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización para el tipo de
	 * comisión
	 * 
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}	
}

