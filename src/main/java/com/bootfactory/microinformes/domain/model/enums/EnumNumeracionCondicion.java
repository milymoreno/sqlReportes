package com.bootfactory.microinformes.domain.model.enums;


/**
 * Representa los valores que puede tomar el atributo
 * numeracionCondiciones de ParametroEntidad
  */
public enum EnumNumeracionCondicion {

    /**
     * Indica que la asignacion de numeración a las 
     * condiciones será un consecutivo administrado
     * por el sistema unico para la entidad financiera
     */
    POR_SISTEMA("ENM.NUMCONDICION.1"),
    /**
     * Indica que la asignacion de numeración a las 
     * condiciones se realizará de acuerdo a la 
     * definicion del Banco de Occidente
     */
    POR_OCCIDENTE("ENM.NUMCONDICION.2");
    
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
    private EnumNumeracionCondicion(String codMes) {
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
