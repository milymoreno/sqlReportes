package com.bootfactory.microinformes.domain.model.enums;

/**
 * Representa las formas en las que puede calcularse el valor de una comisión
 * 
 * @author ogiral
 */
public enum EnumEstadoTitulo {
    /**
     * El titúlo se encuentra en proceso de autorización
     */
    EN_PROCESO_AUTORIZACION("ENM.ESTTITULO.1"),
    /**
     * El titúlo se encuentra en proceso de corrección
     */
    EN_PROCESO_CORRECCION("ENM.ESTTITULO.2"),
    /**
     * El titúlo se encuentra en proceso de pago
     */
    EN_PROCESO_DE_PAGO("ENM.ESTTITULO.3"),
    /**
     * El titúlo se encuentra pendiente por aprobar
     */
    PENDIENTE_APROBACION_DISPONIBLE("ENM.ESTTITULO.4"),
    /**
     * El titulo esta pagado
     */
    PAGADA("ENM.ESTTITULO.5"),
    /**
     * El titúlo se encuentra pendiente de aprobación por la entidad financiera
     */
    PENDIENTE_AUTORIZACION_EF("ENM.ESTTITULO.6"),
    /**
     * El titúlo se encuentra pendiente de aprobación por el vendedor
     */
    PENDIENTE_APROBACION_VENDEDOR("ENM.ESTTITULO.7"),
    /**
     * El titúlo se encuentra pendiente de aprobación por el comprador
     */
    PENDIENTE_APROBACION_COMPRADOR("ENM.ESTTITULO.8"),
    /**
     * El titúlo se encuentra recahzado
     */
    RECHAZADO("ENM.ESTTITULO.9"),
    /**
     * El titúlo se encuentra anulado
     */
    ANULADA("ENM.ESTTITULO.10"),
    /**
     * El titúlo se encuentra pendiente de radicacion
     */
    PENDIENTE_RADICACION("ENM.ESTTITULO.11"),
    /**
     * El titúlo se encuentra pendiente verificacion
     */
    PENDIENTE_VERIFICACION("ENM.ESTTITULO.12"),
    /**
     * El titúlo se encuentra pendiente segunda verificacion
     */    
    PENDIENTE_SEGVERIFICACION("ENM.ESTTITULO.13"),
    /**
     * El titúlo se encuentra en proceso de cargue
     */
    EN_PROCESO_CARGUE("ENM.ESTTITULO.14"),
    /**
     * El titúlo es aprobado con seguro
     */
    APROBADO_ASEGURADO("ENM.ESTTITULO.15"),
    /**
     * El titúlo es aprobado sin seguro
     */
    APROBADO("ENM.ESTTITULO.16"),   
    /**
     * El titúlo se encuentra en estado desembolsado
     */
    DESEMBOLSADO("ENM.ESTTITULO.17"),
    
    /**
     * El titúlo se encuentra en proceso de autorización de su anulación
     */
    EN_PROCESO_AUTORIZACION_ANULACION("ENM.ESTTITULO.18"),
    
    /**
     * El titúlo se encuentra pendiente de revisión de la notificación
     */
    PENDIENTE_REVISION_NOTIFICACION("ENM.ESTTITULO.19"),
    
    /** El título se encuentra pendiente de autorizacion de mora */
    PENDIENTE_AUTORIZACION_MORA("ENM.ESTTITULO.20"),
    
    /** 
     * CC698: El título se encuentra pendiente de su primera autorización de desembolso 
     */
    PENDIENTE_PRIMERA_AUTORIZACION("ENM.ESTTITULO.21"),
    
    /**
     * CC725: nuevo estado para el manejo de titulos especiales
     */
    PENDIENTE_AUTORIZACION_ESPECIAL("ENM.ESTTITULO.22"),
    
    /**
     * CC768 Estado para agrupar facturas de Títulos valores y CF
     */
    PENDIENTE_AGRUPACION("ENM.ESTTITULO.23"),
    
    /**
     * ESTADO PENDIENTE AUTORIZACION DE PAGO
     */
    PENDIENTE_AUTORIZACION_DE_PAGO("ENM.ESTTITULO.24"),
    /**
     * ESTADO NETEADA
     */
    NETEADA("ENM.ESTTITULO.25"),
    
    /**
     * ESTADO PENDIENTE AUTORIZACION DIFERENCIAL TASA
     */
    PENDIENTE_AUTORIZACION_DIFERENCIAL_TASA("ENM.ESTTITULO.26");
    
    
	/**
	 * Código para el mensaje de internacionalización
	 */
	private final String codMessg;

	/**
	 * Constructor para el enum "Tipo Comisión"
	 * 
	 * @param codMes
	 *            Es el código para el mensaje de internacionalización
	 */
	private EnumEstadoTitulo(String codMes) {
		this.codMessg = codMes;
	}

	/**
	 * Retorna el código del mensaje de internacionalización para el tipo de
	 * comisión
	 * 
	 * @return codMessg Código de internacionalización
	 */
	public String getCodMessg() {
		return codMessg;
	}
}


