package com.bootfactory.microinformes.domain.model.enums;

/**
 * Representa los tipos de empresas del sistema
 * @author Diego Grajales
 *
 */
public enum EnumTipoEmpresa {
	
	
	/** Tipo empresa publica*/
	PUBLICA("ENM.TEMPR.1"),
	/** Tipo empresa privada*/
	PRIVADA("ENM.TEMPR.2"),
	/** Tipo empresa mixta*/
	MIXTA("ENM.TEMPR.3"),
	/** Otro tipo empresa*/
	OTRO("ENM.TEMPR.4");
	
	   /**
     * Código para el mensaje de internacionalización
     */
    private final String codMessg;

    /**
     * Constructor para un valor de una enumeracion
     * 
     * @param codMes
     *                Es el código para el mensaje de internacionalización
     */
    private EnumTipoEmpresa(String codMes) {
        this.codMessg = codMes;
    }

    /**
     * Retorna el código del mensaje de internacionalización para el valor del
     * elemento de la enumeracion
     * 
     * @return codMessg Código de internacionalización
     */
    public String getCodMessg() {
        return codMessg;
    }
		
}
