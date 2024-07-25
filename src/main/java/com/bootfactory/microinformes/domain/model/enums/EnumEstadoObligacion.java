package com.bootfactory.microinformes.domain.model.enums;

/**
 * Representa los estados de una obligacion
 * 
 * @author Administrador
 */
public enum EnumEstadoObligacion {

    /** Estado de obligacion activa */
    ACTIVA("ENM.ESTOBLIGA.1"),
    /** Estado de obligacion reversada */
    REVERSADA("ENM.ESTOBLIGA.2"),

    PAGADO("ENM.ESTOBLIGA.3"),
    /**
     * Este estado indica que la obligación ha sido pagada por PSE, pero aún no se ha confirmado el
     * proceso por esa entidad
     */
    PENDIENTECONFIRMACIONPSE("ENM.ESTOBLIGA.4"),
    /**
     * Este estado indíca que se ha pagado por PSE, y se ha echo efectivo el pago, pero que esta
     * pendiente la aplicación
     */
    CONFIRMADOPSE_PORAPLICAR("ENM.ESTOBLIGA.5");

    /**
     * Código para el mensaje de internacionalización
     */
    private final String codMessg;

    /**
     * Constructor para el enum "Tipo Comisión"
     * 
     * @param codMes
     *                Es el código para el mensaje de internacionalización
     */
    private EnumEstadoObligacion(String codMes) {
        this.codMessg = codMes;
    }

    /**
     * Retorna el código del mensaje de internacionalización para el tipo de comisión
     * 
     * @return codMessg Código de internacionalización
     */
    public String getCodMessg() {
        return codMessg;
    }
}
