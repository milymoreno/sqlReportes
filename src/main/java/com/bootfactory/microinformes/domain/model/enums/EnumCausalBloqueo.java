package com.bootfactory.microinformes.domain.model.enums;

public enum EnumCausalBloqueo {

	CAUSALBLOQUEOADM("ENM.CAUSALBLOQ.1"), CAUSALLISTAEXCEP("ENM.CAUSALBLOQ.2");

	private final String codMessg;

	/**
	 * Constructor para el enum "Causal Bloqueo"
	 * 
	 * @param codMes Es el código para el mensaje de internacionalización
	 */
	private EnumCausalBloqueo(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización para la causal de
	 * bloqueo
	 * 
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}
}
