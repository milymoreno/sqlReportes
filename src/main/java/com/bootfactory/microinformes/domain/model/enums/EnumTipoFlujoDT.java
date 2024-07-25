package com.bootfactory.microinformes.domain.model.enums;



/**
 * Descripción: Clase que determina el enum para el tipo de flujo DT
 */
public enum EnumTipoFlujoDT {
    
    
    /**
     * Atributo que determina el flujo estandar 
     */
    FLUJOESTANDAR("ENM.TIPOFLUJODT.1"),
    
    /**
     * Atributo que determina el flujo para Banco de Bogota 
     */
    FLUJOBANCODEBOGOTA("ENM.TIPOFLUJODT.2");

    /**
     * Código para el mensaje de internacionalización
     */
    private final String codMessg;

    
    /**
     * Constructor de la clase.
     * @param codMes
     */
    private EnumTipoFlujoDT(String codMes) {
            this.codMessg = codMes;
    }

    
    /**
     * Metodo encargado de obtener el mensaje
     * @author Adriana Cárdenas - lcardenas@heinsohn.com.co
     * 
     * @return
     */
    public String getCodMessg() {
            return codMessg;
    }
}
