package com.bootfactory.microinformes.domain.model.enums;

/**
 * Representa las maneras en que se le puede entregar una contraseña a un usuario
 * 
 */
public enum EnumTipoEntregaClaves {
	
	/** PGP  */
	PGP("ENM.TIPENTCLAVE.1"),
	/** LDAP */
	LDAP("ENM.TIPENTCLAVE.2"),
	/** Correo electronico */
	CORREO("ENM.TIPENTCLAVE.3"),
	/** Encuesta normal */
	ENCUESTA("ENM.TIPENTCLAVE.4");

	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumTipoEntregaClaves(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización para el tipo de
	 * aplicación
	 * 
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}	
}
