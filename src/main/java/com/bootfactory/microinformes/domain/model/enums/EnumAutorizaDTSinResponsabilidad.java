package com.bootfactory.microinformes.domain.model.enums;


/**
 * Representa los valores que puede tomar el atributo
 * autorizaDTSinResponsabilidad de ParametroEntidad
 */
public enum EnumAutorizaDTSinResponsabilidad {
    
    /**
     * Indica que el Cliente es el que autoriza DT Sin Responsabilidad
     */
    CLIENTE("ENM.AUTORIZADTSINRESPONSABILIDAD.1"),
    /**
     * Indica que la Entidad Financiera es la que autoriza DT Sin Responsabilidad
     */
    ENTIDADFINANCIERA("ENM.AUTORIZADTSINRESPONSABILIDAD.2");

    /**
     * Código para el mensaje de internacionalización
     */
    private final String codMessg;

    /**
     * Constructor para el enum "Autoriz DT Sin Responsabilidad"
     * 
     * @param codMes
     *            Es el código para el mensaje de internacionalización
     */
    private EnumAutorizaDTSinResponsabilidad(String codMes) {
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
