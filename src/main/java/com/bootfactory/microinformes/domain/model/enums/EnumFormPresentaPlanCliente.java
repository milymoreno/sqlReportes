package com.bootfactory.microinformes.domain.model.enums;


/**
 * Indica como el sistema presentara a los clientes la 
 * informacion de un Plan de Linea Triangular
 *
 */
public enum EnumFormPresentaPlanCliente {
    
    /**
     * Indica cómo el sistema presentará a los clientes la información de un Plan de Línea Triangular Completa
     */
    COMPLETA("ENM.FORMAPLANCOMPLETA.1"),
    /**
     * Indica cómo el sistema presentará a los clientes la información de un Plan de Línea Triangular Resumida
     */
    RESUMIDA("ENM.FORMAPLANRESUMIDA.2");

    /**
     * Código para el mensaje de internacionalización
     */
    private final String codMessg;

    /**
     * Constructor
     * 
     * @param codMes
     *            Es el código para el mensaje de internacionalización
     */
    private EnumFormPresentaPlanCliente(String codMes) {
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
