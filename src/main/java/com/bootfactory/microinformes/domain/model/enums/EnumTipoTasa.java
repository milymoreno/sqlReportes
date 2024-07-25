package com.bootfactory.microinformes.domain.model.enums;


public enum EnumTipoTasa {
	TMLV("ENM.TIPOTASATMLV.1"),
	IVA("ENM.TIPOTASAIVA.2"),
	REFFTE("ENM.TIPOTASAREFFTE.3"),
	DTF("ENM.TIPOTASADTF.4"),
	TRM("ENM.TIPOTASATRM.5"),
	CUATROXMIL("ENM.TIPOTASADTF.6"), 
	TMLVMC("ENM.TIPOTASATMLVMC.7"),
	FIJA("ENM.TIPOTASAFIJA.8"),
	PORCENTAJE("ENM.TIPOTASAPORCENTAJE.9"),
	NO_APLICA("ENM.TIPOTASANOAPLICA.10");
		
	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "TipoTasa"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumTipoTasa(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización para 
	 * los conceptos
	 * 
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}		

}
