package com.bootfactory.microinformes.domain.model.enums;
 
public enum EnumEsquemaConexionLDAP{
	
	NO_TIENE("ENM.ESQCONEXLDAP.1"),
	JNDI("ENM.ESQCONEXLDAP.2"),
	SERVICIO_ENTIDAD("ENM.ESQCONEXLDAP.3");
	/**
	* To internationalitation code
	*/
	private final String codeMessage;
	
	/**
	* Constructor to EnumEsquemaConexionLDAP Enumeration
	*/
	private EnumEsquemaConexionLDAP(String codeMessage) {
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
