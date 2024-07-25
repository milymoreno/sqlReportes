package com.bootfactory.microinformes.domain.model.enums;


/**
 * Representa los valores que puede tomar el atributo 
 * consecutivoObligaciones de ParametroEntidad
  */
public enum EnumConsecutivoObligaciones {

    

    /**
     * "Único por Sistema" </br>
     */
    UNICO_POR_SISTEMA("ENM.CONOBLIGACION.1"),
    
    /**
     * "Uno por cada Producto" </br>
     */
    UNO_POR_PRODUCTO("ENM.CONOBLIGACION.2");
    
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
    private EnumConsecutivoObligaciones(String codMes) {
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

