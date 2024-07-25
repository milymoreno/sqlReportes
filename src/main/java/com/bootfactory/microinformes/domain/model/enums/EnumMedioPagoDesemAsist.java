package com.bootfactory.microinformes.domain.model.enums;


/**
 * Indica cómo la entidad financiera hace que sus clientes determinen los Medios de Pago que deben utilizar en la opción de Administrar Desembolso Asistido
 */

public enum EnumMedioPagoDesemAsist {
	
	SELECCIONA("ENM.MEDIOPAGODESEM.1"),

	SUMINISTRA("ENM.MEDIOPAGODESEM.2");
	
	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "EnumMedioPagoDesemAsist"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumMedioPagoDesemAsist(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización indicando cómo la entidad financiera hace que sus clientes determinen los 
	 * Medios de Pago que deben utilizar en la opción de Administrar Desembolso Asistido
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}

}

