package com.bootfactory.microinformes.domain.model.enums;


/**
 * Representa los valores que puede tomar el atributo 
 * numeracionObligaciones de ParametroEntidad
 */
public enum EnumNumeracionObligacion {

    

    /**
     * "Por Consecutivo" </br>
     * Indica que la asignacion de la numeración a las 
     * Obligaciones se realizará por el sistema único 
     * para cada Entidad Financiera
     */
    POR_ENTIDAD("ENM.NUMOBLIGACION.1"),
    
    /**
     * "Por Oficina BOC" </br>
     * Indica que la asignacion de la numeración a las 
     * Obligaciones se realizará de acuerdo a la oficina 
     * asociada a la condición.
     */
    POR_OFICINA("ENM.NUMOBLIGACION.2"),
    
    /**
     * "Por Consecutivo y Dígito" </br>
     * Indica que la asignacion de la numeración a las 
     * Obligaciones se realizará por el sistema único 
     * para cada Entidad Financiera, concatenado con
     * dígito de verificación
     */
    POR_CONSECUTIVODIGITO("ENM.NUMOBLIGACION.3");


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
    private EnumNumeracionObligacion(String codMes) {
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

