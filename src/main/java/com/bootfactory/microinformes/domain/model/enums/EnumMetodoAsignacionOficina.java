package com.bootfactory.microinformes.domain.model.enums;


/**
 * Descripción: Clase que determina la lista de valores que indica el método a
 * emplear para la asignación de una oficina a una Obligación, al momento de
 * hacer la generación de la misma
 */
public enum EnumMetodoAsignacionOficina {

	/**
	 * Determina el método "Ninguno"
	 */
	NINGUNO("ENM.METASIGOFIC.1"),

	/**
	 * Determina el método "Multibank"
	 */
	MULTIBANK("ENM.METASIGOFIC.2");

	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor 
	 * 
	 * @param codMes
	 */
	private EnumMetodoAsignacionOficina(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Método encargado de obtener el mensaje
	 * 
	 * @return
	 */
	public String getCodMessg() {
		return codMessg;
	}
}
