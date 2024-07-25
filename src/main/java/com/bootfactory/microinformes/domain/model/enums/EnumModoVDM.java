package com.bootfactory.microinformes.domain.model.enums;

/**
 * Representa el modo en el que una entidad financiera quiere 
manipular la administración del Valor Máximo Disponible
 */
public enum EnumModoVDM {
	/** Indica que la entidad financiera delega el manejo de los disponibles 
	a la aplicación en su totalidad**/
	NINGUNO("ENM.MODOVDM.1"),
	/** Indica que el manejo de los disponibles será totalmente manejado por 
	los archivos definidos por la entidad financiera y no por la apliación**/
	TOTAL("ENM.MODOVDM.2"),
	/** Indica que el manejo de los disponibles se manejará de manera 
	compartida por la aplicación y la entidad financiera**/
	PARCIAL("ENM.MODOVDM.3");
	
	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "ModoVDM"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumModoVDM(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización
	 * 
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}
}
