package com.bootfactory.microinformes.domain.model.enums;


/**
 * Representa los valores que puede tomar el atributo 
 * manejoCalificacionClientes de ParametroEntidad
 */
public enum EnumManejoCalificacion {
    
	TEMPORALIDAD("ENM.MANEJOCALIF.1"),
	EXTERNA("ENM.MANEJOCALIF.2"),
	TEMPORALIDAD_Y_EXTERNA("ENM.MANEJOCALIF.3");


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
    private EnumManejoCalificacion(String codMes) {
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
