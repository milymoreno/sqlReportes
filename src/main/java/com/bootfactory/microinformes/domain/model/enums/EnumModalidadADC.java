package com.bootfactory.microinformes.domain.model.enums;


public enum EnumModalidadADC {
	
	//Con descuento valor ordinal 0
	CONDESCUENTO("ENM.CONDESCUENTO.1"),
	//Sin descuento valor ordinal 1
	SINDESCUENTO("ENM.SINDESCUENTO.2"),
	//Con y Sin Descuento valor ordinal 2
	CONYSINDESCUENTO("ENM.CONYSINDESCUENTO.3");
	
	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "Modalidad ADC"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumModalidadADC(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización para el tipo Modalidad ADC
	 * 
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}

}

