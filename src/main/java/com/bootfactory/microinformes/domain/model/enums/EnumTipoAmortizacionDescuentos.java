package com.bootfactory.microinformes.domain.model.enums;

/**
 * Indica la forma como se realiza el cálculo de la amortización de descuentos en el sistema.
 */
public enum EnumTipoAmortizacionDescuentos {
	
	/** Indica que se realizará el cálculo EXPONENCIAL */
	EXPONENCIAL("ENM.TIPOAMORTDESCUENTOS.1"),
	/** Indica que se realizará el cálculo LINEAL */
	LINEAL("ENM.TIPOAMORTDESCUENTOS.2");	
	
	/**
	* To internationalitation code
	*/
	private final String codMessg;
	
	/**
	* Constructor to EnumEstadoToken Enumeration
	*/
	private EnumTipoAmortizacionDescuentos(String codMessg) {
		this.codMessg = codMessg;
	}
	
	/**
	* Returns the code to internationalitation for this enumeration
	* @return internationalitation code
	*/
	public String getCodMessg(){
		return codMessg;
	}		
}
