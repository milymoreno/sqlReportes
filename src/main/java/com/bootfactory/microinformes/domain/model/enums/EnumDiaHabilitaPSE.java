package com.bootfactory.microinformes.domain.model.enums;

/**
 * Indica qué días podrá hacerse pagos a través de PSE.
  */
public enum EnumDiaHabilitaPSE{
	
	/** Indica que siempre se pueden realizar los pagos  */
	SIEMPRE("ENM.DIAHABILPSE.1"),
	/** Indica que se pueden realizar los pagos sólo los días hábiles */
	DIAHABIL("ENM.DIAHABILPSE.2");	
	
	/**
	* To internationalitation code
	*/
	private final String codeMessage;
	
	/**
	* Constructor to EnumEstadoToken Enumeration
	*/
	private EnumDiaHabilitaPSE(String codeMessage) {
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
