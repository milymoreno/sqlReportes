package com.bootfactory.microinformes.domain.model.enums;


public enum EnumRolCliente {
	/**Rol Cliente Deudor*/
	DEUDOR("ENM.ROLCLIENTE.1"),
	/**Rol Cliente Fuente de Pago*/
	FUENTEPAGO("ENM.ROLCLIENTE.2"),
	/**Rol Cliente Codeudor*/
	CODEUDOR("ENM.ROLCLIENTE.3"),
	/**Rol Cliente socio*/
	SOCIO("ENM.ROLCLIENTE.4");


	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "Rol Cliente"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumRolCliente(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización para el rol del
	 * cliente
	 * 
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}			
}
