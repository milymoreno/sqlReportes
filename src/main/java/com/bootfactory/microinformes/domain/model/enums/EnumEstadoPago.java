package com.bootfactory.microinformes.domain.model.enums;

/**
 * Representa los estados de los pagos
 * 
 * @author Administrador
 */
public enum EnumEstadoPago {

    /** Estado del pago por aplicar */
    /** Estado del pago por aplicar */
    POR_APLICAR("ENM.ESTPAGO.1"),
    /** Estado de pago aplicado */
    APLICADO("ENM.ESTPAGO.2"),
    /** Estado del pago reversado */
    REVERSADO("ENM.ESTPAGO.3"),
    /** Estado del pago rechazado */
    RECHAZADO("ENM.ESTPAGO.4"),
    /** Estado pendiente creacion para distribucion de desembolsos */
    PENDIENTECREACION("ENM.ESTPAGO.5"),
    /** Estado del pago PendienteAutorizcion */
    PENDIENTEAUTORIZACION("ENM.ESTPAGO.6"),
    /** Estado del pago Por pagar en Oficina */
    PORPAGARENOFICINA("ENM.ESTPAGO.7"),
    /** Estado autorizado para distribucion de desembolsos */
    AUTORIZADO("ENM.ESTPAGO.8"),
    /** Estado en proceso correcion para distribucion de desembolsos */
    ENPROCESOCORRECCION("ENM.ESTPAGO.9"),
    /**
     * Este estado indica que se ha pagado por PSE, pero a�n no se ha confirmado el proceso por esa
     * entidad
     */
    PENDIENTECONFIRMACIONPSE("ENM.ESTPAGO.10"),
    /**
     * Este estado ind�ca que se ha pagado por PSE, y se ha echo efectivo el pago, pero que esta
     * pendiente la aplicaci�n
     */
    CONFIRMADOPSE_PORAPLICAR("ENM.ESTPAGO.11"),
    
    /**
     * Estado que indica que un pago no se pude realizar, � es valido para aplicar, � no se puede reintentar como pago
     * electronico
     */
    CANCELADO("ENM.ESTPAGO.12");

    /**
     * C�digo para el mensaje de internacionalizaci�n
     */
    private final String codMessg;

    /**
     * Constructor para el enum "Tipo Comisi�n"
     * 
     * @param codMes
     *                Es el c�digo para el mensaje de internacionalizaci�n
     */
    private EnumEstadoPago(String codMes) {
        this.codMessg = codMes;
    }

    /**
     * Retorna el c�digo del mensaje de internacionalizaci�n para el tipo de comisi�n
     * 
     * @return codMessg C�digo de internacionalizaci�n
     */
    public String getCodMessg() {
        return codMessg;
    }

}
