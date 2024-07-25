package com.bootfactory.microinformes.domain.model.enums;


/**
 * Representa los valores posibles del momento en el que el sistema hará la
 * prórroga.
 */
public enum EnumMomentoCobrarProrroga {

	AL_PRORROGAR("ENM.MOMENTCOBRPROR.1"),

	AL_VENCIMIENTO("ENM.MOMENTCOBRPROR.2");

	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "EnumMomentoCobrarProrroga"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumMomentoCobrarProrroga(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización para el momento en
	 * el que el sistema hará la prórroga.
	 * 
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}

}
