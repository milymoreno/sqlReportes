package com.bootfactory.microinformes.domain.model.enums;


/** Representa los tipos de esquema de seguridad que manejan las EFs en el sistema*/
public enum EnumEsquemaSeguridad {
	
	/** No aplica*/
	NO_APLICA("EMN.ESQUEMASEG.1"),
	/** Tasa variable*/
	ENCUESTA_MANUAL("EMN.ESQUEMASEG.2"),
	/** Tasa variable*/
	ENCUESTA_AUTOMATICA("EMN.ESQUEMASEG.3"),
	TOKEN("EMN.ESQUEMASEG.4");
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
    private EnumEsquemaSeguridad(String codMes) {
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

