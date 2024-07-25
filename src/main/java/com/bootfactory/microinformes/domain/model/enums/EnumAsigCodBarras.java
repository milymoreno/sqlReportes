package com.bootfactory.microinformes.domain.model.enums;

public enum EnumAsigCodBarras{
	/** Estado Manual*/
	MANUAL("ENM.ESTASIGCODBAR.1"),
	/** Estado Automático */
	AUTOMATICO("ENM.ESTASIGCODBAR.2");
	
	/** To internationalitation code
	*/
	private final String codeMessage;
	
	/**
	* Constructor to EnumAsigCodBarras Enumeration
	*/
	private EnumAsigCodBarras(String codeMessage) {
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

