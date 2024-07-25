package com.bootfactory.microinformes.domain.model.enums;


/** Representa las caractetisticas de lo tipos de tasa en el sistema*/
public enum EnumCaracteristicaTasa {
	
	/** Caracteristica Tasa fija*/
	FIJA("EMN.CARACTERISTICA.TASA.1"),
	/** Caracteristica Tasa variable*/
	VARIABLE("EMN.CARACTERISTICA.TASA.2"),
	/** Caracteristica Tasa Ningunga*/
	NINGUNA("EMN.CARACTERISTICA.TASA.3"),
	/** Caracteristica Tasa Porcentaje*/
	PORCENTAJE("EMN.CARACTERISTICA.TASA.4"),
	/** Caracteristica Tasa Mora*/
	MORA("EMN.CARACTERISTICA.TASA.5");
	
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
    private EnumCaracteristicaTasa(String codMes) {
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
