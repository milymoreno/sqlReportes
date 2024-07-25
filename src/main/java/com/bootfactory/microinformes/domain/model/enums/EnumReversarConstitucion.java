package com.bootfactory.microinformes.domain.model.enums;


/**
 * Indica cuando se debe reversar una constitución para la entidad financiera.
 * 
 */
public enum EnumReversarConstitucion{
	
	   /** Reversar Constitución Siempre*/
    SIEMPRE("ENM.REVERSARCONST.1"),
    /** Reversar Constitución cuando exista obligaciones desembolsadas */
    OBLIGACION_DESEMBOLSADA("ENM.REVERSARCONST.2"),
    /** Reversar Constitución cuando existan obligaciones sin desembolsar*/
    OBLIGACION_SIN_DESEMBOLSAR("ENM.REVERSARCONST.3");
	/**
	* To internationalitation code
	*/
	private final String codeMessage;
	
	/**
	* Constructor to EnumReversarConstitucion Enumeration
	*/
	private EnumReversarConstitucion(String codeMessage) {
		this.codeMessage = codeMessage;
	}
	
	/**
	* Returns the code to internationalitation for this enumeration
	* @return internationalitation code
	*/
	public String getCodeMessage(){
		return codeMessage;
	}		
}

