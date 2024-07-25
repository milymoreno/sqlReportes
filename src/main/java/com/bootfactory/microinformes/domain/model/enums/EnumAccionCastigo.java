package com.bootfactory.microinformes.domain.model.enums;


/**
 * Representa los valores posibles de la acción a realizar cuando se castiga una obligación.
 *
 */
public enum EnumAccionCastigo {
	
	
	/** Indica si al autorizar un castigo no se realiza ninguna accion */
	NINGUNA("ENM.ACCIONCAST.1"),

	/** Indica si al autorizar un castigo se lleva la cartera de la obligación a ceros */
	CANCELA_OBLIGACION("ENM.ACCIONCAST.2");
	
	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "EnumAccionCastigo"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumAccionCastigo(String codMes) {
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
