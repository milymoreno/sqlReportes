package com.bootfactory.microinformes.domain.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import com.bootfactory.microinformes.domain.model.enums.EnumAccionCastigo;
import com.bootfactory.microinformes.domain.model.enums.EnumAsigCodBarras;
import com.bootfactory.microinformes.domain.model.enums.EnumAutorizaDTSinResponsabilidad;
import com.bootfactory.microinformes.domain.model.enums.EnumConsecutivoObligaciones;
import com.bootfactory.microinformes.domain.model.enums.EnumDiaHabilitaPSE;
import com.bootfactory.microinformes.domain.model.enums.EnumEsquemaConexionLDAP;
import com.bootfactory.microinformes.domain.model.enums.EnumEsquemaSeguridad;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoTitulo;
import com.bootfactory.microinformes.domain.model.enums.EnumFormPresentaPlanCliente;
import com.bootfactory.microinformes.domain.model.enums.EnumFormaCalcularValorProrroga;
import com.bootfactory.microinformes.domain.model.enums.EnumManejoCalificacion;
import com.bootfactory.microinformes.domain.model.enums.EnumMedioPagoDesemAsist;
import com.bootfactory.microinformes.domain.model.enums.EnumMetodoAsignacionOficina;
import com.bootfactory.microinformes.domain.model.enums.EnumModalidadADC;
import com.bootfactory.microinformes.domain.model.enums.EnumModoVDM;
import com.bootfactory.microinformes.domain.model.enums.EnumMomentoCobrarProrroga;
import com.bootfactory.microinformes.domain.model.enums.EnumNumeracionCondicion;
import com.bootfactory.microinformes.domain.model.enums.EnumNumeracionObligacion;
import com.bootfactory.microinformes.domain.model.enums.EnumReversarConstitucion;
import com.bootfactory.microinformes.domain.model.enums.EnumTipoAmortizacionDescuentos;
import com.bootfactory.microinformes.domain.model.enums.EnumTipoCausacionMora;
import com.bootfactory.microinformes.domain.model.enums.EnumTipoEntregaClaves;
import com.bootfactory.microinformes.domain.model.enums.EnumTipoFlujoDT;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PARAMETROENTIDAD")
public class ParametroEntidad  implements Serializable, Cloneable{
	
	@Column(name = "TIEMPOLIMPROCESOCONPAGOS" )
	private Long tiempoLimProcesoConPagos;
	
	@Column(name = "MAXNUMEROPAGOSENLINEA" )
	private Long maxNumeroPagosEnLinea;

	@Column(name = "P1HORAINICIO"  , columnDefinition = "TIMESTAMP") 
	private Date p1HoraInicio;
	
	@Column(name = "P1HORAFINAL"  , columnDefinition = "TIMESTAMP") 
	private Date p1HoraFinal;
	
	@Column(name = "P1DIAHABIL" )
	private Boolean p1DiaHabil;
	
	@Column(name = "P2HORAINICIO"  , columnDefinition = "TIMESTAMP") 
	private Date p2HoraInicio;
	
	@Column(name = "P2HORAFINAL"  , columnDefinition = "TIMESTAMP") 
	private Date p2HoraFinal;
	
	@Column(name = "P2DIAHABIL" )
	private Boolean p2DiaHabil;
	
	@Column(name = "P3HORAINICIO"  , columnDefinition = "TIMESTAMP") 
	private Date p3HoraInicio;
	
	@Column(name = "P3HORAFINAL"  , columnDefinition = "TIMESTAMP") 
	private Date p3HoraFinal;
	
	@Column(name = "P3DIAHABIL" )
	private Boolean p3DiaHabil;

	/** Required by the Java Serialization Mechanism */
	private static final long serialVersionUID = 1L;

	/**
	 * Dias de notificación de vencimiento
	 */
	@Column(name = "DIASNOTIFICACIONVENCIMIENTO" )
	private Long diasNotificacionVencimiento;

	/**
	 * Algoritmo de dígito de verificación utilizado para  la entidad financiera
	 */
	@Column(name = "ALGORITMO" )
	private String algoritmo;

	/**
	 * The primary key.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Valor límite micro crédito
	 */
	@Column(name = "VALORLIMITEMICROCREDITO",length = 0, unique = false, precision = 0, scale = 0, nullable = true, columnDefinition = "NUMBER(18,2)", insertable = true, updatable = true)
	private BigDecimal valorLimiteMicroCredito;

	/**
	 * @todo add comment for javadoc
	 */
	@OneToOne(optional = true, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@PrimaryKeyJoinColumn(name = "ENTIDADFINANCIERA_ID" )
	private EntidadFinanciera entidadFinanciera;


	
	/**
	 * version de la entidad
	 */
	@SuppressWarnings("unused")
	@Version
	@Column(name = "VERSION" )
	private Long version;

	/**
	 * Número de meses del calendario
	 */
	@Column(name = "NUMEROMESESCALENDARIO" )
	private Long numeroMesesCalendario;

	/**
	 * Consecutivo de radicación asignado al titulo.
	 */
	@Lob
	@Column(name = "POLITICASSEGURIDAD" )
	private String politicasSeguridad;

	/**
	 * Consecutivo de radicación asignado al titulo.
	 */
	@Column(name = "NOMBRESKIN" )
	private String nombreSkin;

	/**
	 * Consecutivo de radicación asignado al titulo.
	 */
	@Column(name = "NOMBRELOGO" )
	private String nombreLogo;

	/**
	 * Consecutivo de radicación asignado al titulo.
	 */
	@Lob
	@Column(name = "POLITICASPRIVACIDAD" )
	private String politicasPrivacidad;

	/**
	 * null
	 */
	@Column(name = "CONFIGURACIONSEGURIDAD" )
	private String configuracionSeguridad;

	/**
	 * Contiene la informacion que aparece en el pie de página en la sección de 'Contáctenos'
	 */
	@Column(name = "INFOCONTACTO" )
	private String infoContacto;

	/**
	 * Contiene la informacion que aparece en el pie de página en la sección de 'Datos de dirección'

	 */
	@Column(name = "INFODIRECCION" )
	private String infoDireccion;

		
	
	/**
	 * Parámetro SI/NO indica si existe control de desembolso asistido

	 */
	@Column(name = "CONTROLDESEMBOLSOASISTIDO" )
	private Boolean controlDesembolsoAsistido;

	/**
	 * Parámetro SI/NO indica si la Entidad Financiera dispone de un servicio para realizar la validacion de Lista de Bloqueo

	 */
	@Column(name = "SERVICIOLISTABLOQUEO" )
	private Boolean servicioListaBloqueo;

	/**
	 * Parámetro SI/NO indica si administra o no Gerente Comercial en el Sistema


	 */
	@Column(name = "ADMINTASASMANUAL" )
	private Boolean adminTasasManual;

	/**
	 * Número de días de anticipación al vencimiento de las obligaciones 
	 */
	@Column(name = "NUMERODIASANTICVENCOBLIG" )
	private Long numeroDiasAnticVencOblig;

	/**
	 * Número de días del vencimiento que se deben reportar 
	 */
	@Column(name = "NUMERODIASVENCREPORTAR" )
	private Long numeroDiasVencReportar;

	/**
	 * Dias de notificación de vencimiento
	 */
	@Column(name = "DIASNOTIFICACIONVENCIMIENTOOBL" )
	private String diasNotificacionVencimientoObl;

	/**
	 * Es la manera como esta entidad financiera realiza la 
	 * administración de sus disponibles.  
	 * @See EnumModoVDM
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "INFORMACIONVDM" )
	private EnumModoVDM informacionVDM;

	/**
	 * null
	 */
	@Column(name = "PARAMREVPLANLT",length = 0, unique = false, precision = 0, scale = 0, nullable = true, columnDefinition = "NUMBER(9,6)", insertable = true, updatable = true)
	private Double paramRevPlanLT;

	/**
	 * Plazo (Número de días) máximo de días futuros que un cheque podrá ser recibido en el sistema para ser negociado
	 */
	@Column(name = "PLAMAXPLANES" )
	private Long plaMaxPlanes;

	/**
	 * Parámetro SI/NO indica si los valores que conforman el código de barras son de longitud fija o variable
	 */
	@Column(name = "CODIGOBARRASVARIABLE" )
	private Boolean codigoBarrasVariable;

	/**
	 * Parámetro con valores SI/NO que indica si la Entidad financiera consolidará los desembolsos para sus vendedores. 
	 */
	@Column(name = "CONSOLIDADESEMBOLSOS" )
	private Boolean consolidaDesembolsos;

	/**
	 * @todo add comment for javadoc
	 */
	@Column(name = "NOMBRECARTANOTIFICACION" )
	private String nombreCartaNotificacion;

	/**
	 * @todo add comment for javadoc
	 */
	@Column(name = "FIRMACARTANOTIFICACION" )
	private String firmaCartaNotificacion;

	/**
	 * @todo add comment for javadoc
	 */
	@Column(name = "NOMBRECARGOCARTANOTIFICACION" )
	private String nombreCargoCartaNotificacion;

	/**
	 * @todo add comment for javadoc
	 */
	@Column(name = "CARGOCARTANOTIFICACION" )
	private String cargoCartaNotificacion;

	/**
	 * Indica si el número de cuenta bancaria debe ser validado por el algoritmo de dígito de verificación
	 */
	@Column(name = "VALIDANUMEROSCUENTA" )
	private Boolean validaNumerosCuenta;

	/**
	 * @todo add comment for javadoc
	 */
	@Column(name = "ALGORITMOVALIDACIONCUENTAS" )
	private String algoritmoValidacionCuentas;

	/**
	 * null
	 */
	@Column(name = "VALIDASERVICIOLEAINDIRECTO" )
	private Boolean validaServicioLeaIndirecto;

	/**
	 * null
	 */
	@Column(name = "VALIDASERVICIODESEMBOLSO" )
	private Boolean validaServicioDesembolso;

	/**
	 * Esquema de seguridad
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ESQUEMASEGURIDAD" )
	private EnumEsquemaSeguridad esquemaSeguridad;

	/**
	 * Plazo (Número de días) máximo de días de desembolso una vez actualizado el saldo a favor.
	 */
	@Column(name = "NUMERODIASDESEMBOLSO" )
	private Long numeroDiasDesembolso;

	/**
	 * Valida si la Entidad Financiera necesita validar o no, el castigo de una obligacion con respecto al monto de las obligaciones.


	 */
	@Column(name = "VALIDAPROVISIONESCASTIGAR" )
	private Boolean validaProvisionesCastigar;

	/**
	 * Parametro que permite determinar quien debe hacer la autorización de un Título cuando se está manejando el negocio de Títulos Valores SIN Responsabilidad. El atributo tendrá el nombre Quién Autoriza.

	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "AUTORIZADTSINRESPONSABILIDAD" )
	private EnumAutorizaDTSinResponsabilidad autorizaDTSinResponsabilidad;

	/**
	 * Indica si al momento de solicitar un desembolso en cheque el sistema solicita un número de oficina.
	 */
	@Column(name = "REQUIEREOFDESEMBOLSOCHEQUE" )
	private Boolean requiereOfDesembolsoCheque;

	/**
	 * indica si al momento de solicitar un desembolso asistido en cheque el sistema debe proteger el valor que se haya almacenado en el campo Referencia.
	 */
	@Column(name = "PROTEGEREFERENCIA" )
	private Boolean protegeReferencia;

	/**
	 * Indica si se usara la funcionalidad de administración de cuentas 
	 */
	@Column(name = "ADMINISTRACUENTASCONTABLES" )
	private Boolean administraCuentasContables;

	/**
	 * Indica si la asignación de numeración a las  Obligaciones será un consecutivo administrado por el sistema único para cada Entidad Financiera, o si la numeración se realizará de acuerdo a la oficina asociada a la condición.
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "NUMERACIONOBLIGACIONES" )
	private EnumNumeracionObligacion numeracionObligaciones;

	

	
	/**
	 * Indica si la asignación de numeración a las Condiciones será un consecutivo administrado por el sistema único para cada Entidad Financiera, o si la  numeración se realizará de acuerdo a la definición proporcionada por el Banco de Occidente.
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "NUMERACIONCONDICIONES" )
	private EnumNumeracionCondicion numeracionCondiciones;

	/**
	 * Algoritmo Referencia
	 */
	@Column(name = "ALGORITMOREFERENCIA" )
	private String algoritmoReferencia;

	/**
	 * Indica el número de días antes del vencimiento de la vigencia de una contraseña y desde los cuales se debe comenzar a notificar a los
usuarios del vencimiento de la misma
	 */
	@Column(name = "DIASNOTVIGPASSWORDUSUARIO" )
	private Long diasNotVigPasswordUsuario;

	/**
	 * Indica si se debe realizar el correspondiente cobro del impuesto a las transacciones financieras 4x1000
	 */
	@NotNull
	@Column(name = "COBRAIMPUESTO4X1000" )
	private Boolean cobraImpuesto4x1000;

	/**
	 * Indica si se debe realizar el cobro del impuesto a las transacciones financieras de linea triangular
	 */
	@NotNull
	@Column(name = "COBRAIMPUESTOLT" )
	private Boolean cobraImpuestoLT;

	/**
	 * Indica si la entidad financiera utiliza el servicio de obtención de la información de clientes de Banco de Occidente
	 */
	@Column(name = "UTILIZASERCLIENTESOCCIDENTE" )
	private Boolean utilizaSerClientesOccidente;

	/**
	 * Indica si la entidad financiera utiliza la invocación del servicio de actualización de la información de Productos del Banco de Occidente
	 */
	@Column(name = "UTILIZASERPRODUCTOSOCCIDENTE" )
	private Boolean utilizaSerProductosOccidente;

	/**
	 * Indica si las notificaciones con perfil de cliente deben consolidarse o si por el contrario deben enviarse por cada operacion.
	 */
	@Column(name = "CONSOLIDANOTIFICACIONESCLIENTE" )
	private Boolean consolidaNotificacionesCliente;

	/**
	 * Asignación de código de barras Facturas en la Entidad Financiera.
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ASIGNACIONCODBARRASFAC" )
	private EnumAsigCodBarras asignacionCodBarrasFac;

	/**
	 * Reintentos al finalizar PSE.
	 */
	@Column(name = "REINTENTOSFINALIZARPSE" )
	private Long reintentosFinalizarPSE;

	/**
	 * Indica si se va a utilizar o no la estructura de Archivador, Caja y Carpeta para las Bodegas
	 */
	@Column(name = "UTILIZADETALLEBODEGA" )
	private Boolean utilizaDetalleBodega;

	/**
	 * Tiempo de invocación cambio de estado
	 */
	@Column(name = "TIEMPOINVOCACIONCAMBIOESTADO" )
	private Long tiempoInvocacionCambioEstado;

	/**
	 * Tiempo de invocación Pendiente
	 */
	@Column(name = "TIEMPOINVOCACIONPENDIENTE" )
	private Long tiempoInvocacionPendiente;

	/**
	 * Tiempo Máximo de Confirmación PSE
	 */
	@Column(name = "TIEMPOMAXCONFIRMACIONPSE" )
	private Long tiempoMaxConfirmacionPSE;

	/**
	 * Define la manera en como se deben entregar las claves para usuarios de entidad financiera
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ENTREGACLAVESEF" )
	private EnumTipoEntregaClaves entregaClavesEF;

	/**
	 * Define la manera en como se deben entregar las claves para usuarios de cliente
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ENTREGACLAVESCLIENTE" )
	private EnumTipoEntregaClaves entregaClavesCliente;

	/**
	 * Tipo de servicio que utilizará la entidad financiera para el manejo de autenticación de usuarios
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ESQUEMACONEXIONLDAP" )
	private EnumEsquemaConexionLDAP esquemaConexionLDAP;

	/**
	 * Define si la entidad financiera usa saldos a favor para automaticamente  pagar obligaciones en mora de los cliente.
	 */
	@Column(name = "PAGAMORASALDOFAVOR" )
	private Boolean pagaMoraSaldoFavor;

	/**
	 * Define si se usa el modo Passive en el modulo FTP, si el valor es false se usa el modo Activo<br />
	 */
	@Column(name = "MODOFTPPASSIVE" )
	private Boolean modoFTPPassive;

	/**
	 * Indica el separador de la cadena de respuesta para el servicio web de autenticación AVVillas:<strong>CU541- Invocar Servicio Autenticación</strong><br />
	 */
	@Column(name = "SEPARADORRTAWSAUTENTICACION" )
	private String separadorRtaWSAutenticacion;

	/**
	 * Indica el nombre que tiene la aplicación para invocar el servicio de autorizacion AVVillas <strong>CU542- Invocar Servicio Autorización</strong>
	 */
	@Column(name = "APPWSAUTORIZACION" )
	private String appWSAutorizacion;

	/**
	 * Cuando la entidad financiera permite reversar una constitución
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "CUANDOREVERSARCONSTITUCION" )
	private EnumReversarConstitucion cuandoReversarConstitucion;

	/**
	 * Indica el separador de la cadena de respuesta para el servicio web de autenticación AVVillas:<strong>CU542- Invocar Servicio Autorización</strong>
	 */
	@Column(name = "SEPARADORRTAWSAUTORIZACION" )
	private String separadorRtaWSAutorizacion;

	/**
	 * Indica si la causación de los intereses de mora se pueda hacer utilizando un cálculo diferente al que actualmente efectúa el sistema.
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "CAUSACIONINTERESMORA" )
	private EnumTipoCausacionMora causacionInteresMora;

	/**
	 * Este parámetro podrá tomar el valor SI o podrá tomar el valor NO, para la validacion del ID Desembolsos Distribuidos
	 */
	@Column(name = "VALIDADESEMBOLSODISTRIBUIDO" )
	private Boolean validaDesembolsoDistribuido;

	
	/**
	 * Fecha del proceso.
	 */
	@Column(name = "FECHAPROCESO"  , columnDefinition = "TIMESTAMP") 
	private Date fechaProceso;

	/**
	 * Indica si al autorizar un castigo se lleva la cartera de la obligación a ceros o no se realiza ninguna accion.
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ACCIONCASTIGO" )
	private EnumAccionCastigo accionCastigo;

	/**
	 *  Este parámetro podrá tomar los valores SI/NO. Indica si el sistema realizará un llamado a un servicio dependiendo de cada Entidad Financiera para verificar si un cliente está en lista de excepción de la Entidad Financiera.
	 */
	@Column(name = "UTILIZASERVALIDARCLIENTES" )
	private Boolean utilizaSerValidarClientes;
	
	/**
	 * Permite SI/NO, si toma el valor 'SI', valida que la diferencia entre el valor del pago a cargar y el valor del pago asociado a la referencia de pago (Valor real del pago - Valor del pago) no sea mayor o igual a 1
	 */
	@Column(name = "AJUSTAVOLANTEUNIDAD" )
	private Boolean ajustaVolanteUnidad;

	/**
	 * Indica si se debe Digitalizar el título si el pago fue efectuado por la fuente de pago
	 */
	@Column(name = "DIGITALIZATITULOS" )
	private Boolean digitalizaTitulos;

	/**
	 * Indica si el sistema permitirá hacer la consolidación de los desembolsos por analizar para un mismo cliente, producto, origen y moneda.
	 */
	@Column(name = "CONSOLIDADESEMBOLSOSANALIZAR" )
	private Boolean consolidaDesembolsosAnalizar;
	
	/**
	 * Permite añadir un mensaje de la entidad financiera, que permite informarle al cliente que tiene pagos en linea pendientes de confirmacion, a la hora de realizar un nuevo pago
	 */
	@Lob
	@Column(name = "INFORMATIVOPAGOPSE" )
	private String informativoPagoPSE;
	
	/**
	 * Parametro que permite añadir un mensaje de la entidad financiera, que muestra los datos de contacto con la entidad financiera en el pie del comprobante de pago de una pago en linea PSE
	 */
	@Lob
	@Column(name = "CONTACTOINFOPSE" )
	private String contactoInfoPSE;
	
	@Column(name = "LIQUIDATOTALIDADSALDOFAVOR" )
	private Boolean liquidaTotalidadSaldoFavor;
	
	/**
	 * Autorizar Negocios Producto LT
	 */
	@Column(name = "AUTORIZARNEGOCIOSLT" )
	private String autorizarNegociosLT;

	/**
	 * Autorizar Negocios Producto Confirming
	 */
	@Column(name = "AUTORIZARNEGOCIOSCF" )
	private String autorizarNegociosCF;

	/**
	 * Autorizar Negocios Producto ADC
	 */
	@Column(name = "AUTORIZARNEGOCIOSADC" )
	private String autorizarNegociosADC;

	/**
	 * Autorizar Negocios Producto DT
	 */
	@Column(name = "AUTORIZARNEGOCIOSDT" )
	private String autorizarNegociosDT;
	
	@Column(name = "MAXNUMEROFACTURASCARGUELINEA" )
	private Long maxNumeroFacturasCargueLinea;
	
	/**
	 * Permite SI/NO, si toma el valor 'SI', Indica si la entidad financiera cobrará el gravamen a los movimientos financieros para los desembolsos ADC
	 */
	@Column(name = "COBRAGMFADC",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean cobraGMFADC = false;

	/**
	 * Permite SI/NO, si toma el valor 'SI', . Indica si la entidad financiera cobrará el gravamen a los movimientos financieros para los desembolsos por saldos a favor
	 */
	@Column(name = "COBRAGMFASALDOFAVOR",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean cobraGMFASaldoFavor = false;

	/**
	 * Permite SI/NO, si toma el valor 'SI', Indica si la entidad financiera cobrará el gravamen a los movimientos financieros para los pagos a obligaciones generados por un desembolso
	 */
	@Column(name = "COBRAGMFDESEMBOLSO",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean cobraGMFDesembolso = false;
	
	/**
	 * Permite SI/NO, Indica que el sistema mostrará o no a las fuentes de pago,
	 * la información de la Fecha Esperada de Pago para los Títulos Valores o la
	 * Fecha de Vencimiento para las Obligaciones
	 */
    @Column(name = "MUESTRAFECHAPAGOFUENTEPAGO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean muestraFechaPagoFuentePago = false;
    
    /**
     * 
     */
    @Column(name = "PERMITEPAGOOBLIGACIONPAGA",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean permitePagoObligacionPaga = false;
    
	/**
	 * Permite SI/NO, si toma el valor 'SI', indica si la Entidad Financiera
	 * maneja el atributo Fecha de Pago para la entidad financiera a nivel del
	 * producto Descuento de Títulos
	 * 
	 */
	@Column(name = "MANEJAFECHAPAGO",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean manejaFechaPago = false;
	
	
	/**
	 * Permite SI/NO realizarse abonos a una obligación específica
	 */
	@Column(name = "ABONOSAOBLIGACIONESPECIFICA",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean abonosAObligacionEspecifica = false;

    /**
     * Parámetro que indica la llave que será utilizada para realizar la encripción del campo claveScratch
     * al realizar la invocación al servicio del CU535
     */
	@Column(name = "LLAVEENCRIPCIONSCRATCH" )
    private String llaveEncripcionScratch;
    
        /**
     * Indica si la entidad financiera permite o no realizar el pago a Referencias de pago
     */
    @Column(name = "PERMITEPAGOREFERENCIAPAGO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean permitePagoReferenciaPago = false;
    
    /**
     * Indica si la entidad financiera permitirá que el CU 128 haga el cargue de recaudos a Obligaciones
     */
    @Column(name = "PERMITEPAGOOBLIGACIONES",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean permitePagoObligaciones = false;
        

	/**
	 * CC676: Permite SI/NO, Indica si se muestra o no el número de la factura asociada a la 
	 * obligación en el volante de Pago.
	 */
    @Column(name = "MUESTRANUMFACTURAVOLANTEPAGO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean muestraNumFacturaVolantePago = false;

	/**
	 * CC590: Indica los días que se habilitará la opción de pago en línea.
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "DIAHABILITAPSE" )
    private EnumDiaHabilitaPSE diaHabilitaPSE;

	/**
	 * CC590: Indica la hora desde la que se habilitará la opción de pago en línea.
	 * el formato debe ser hh:mm am/pm
	 */	
	@Column(name = "HORAINICIOPSE" )
	private String horaInicioPSE;

	/**
	 * CC590: Indica la hora desde la que se habilitará la opción de pago en línea.
	 * el formato debe ser hh:mm am/pm
	 */	
	@Column(name = "HORAFINALPSE" )
	private String horaFinalPSE;

	/**
	 * CC590: Indica el mensaje que se debe mostrar, cuando la opción de pago en línea no
	 * es desplegada en pantalla.
	 */	
	@Column(name = "MENSAJEDIAHABILITAPSE" )
	private String mensajeDiaHabilitaPSE;
    
    	/**
	 * CC692: Permite SI/NO, Indica si la entidad financiera permite o no realizar la captura 
	 * de caracteres especiales dentro de determinados campos de la aplicación.
	 */
    @Column(name = "PERMITECARACTERESESPECIALES",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean permiteCaracteresEspeciales = false;
    
    /**
     * Indica una URL Externa a la cual el sistema se redireccionará al cerrar sesión para los
     * usuarios de la entidad financiera
     */
    @Column(name = "URLEXTERNACIERRESESIONEF" )
    private String urlExternaCierreSesionEF;
    
    
    /**
     * Indica una URL Externa a la cual el sistema se redireccionará al cerrar sesión para los
     * usuarios de la entidad financiera
     */
    @Column(name = "URLEXTERNACIERRESESIONCLIENTE" )
    private String urlExternaCierreSesionCliente;
    
    
	/**
	 * CC682: Permite SI/NO, Indica si se solicita el dominio del correo electrónico al realizar 
	 * la creación o modificación de un usuario del cliente.
	 */
    @Column(name = "OBLIGACORREOSMISMODOMINIO" ,nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean obligaCorreosMismoDominio = false;
    
	/**
	 * CC683: Permite SI/NO, Indica si se muestra o no el Plazo Máximo de Prórroga al consultar 
	 * la información de la condición.
	 */
    @Column(name = "MUESTRAPLAZOMAXIMOPRORROGA",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean muestraPlazoMaximoProrroga = false;
    
	/**
	 * CC682: Permite SI/NO, Indica si se realizará o no Control Dual para el desembolso de títulos.
	 */
    @Column(name = "CONTROLDUALDESEMBOLSO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean controlDualDesembolso = false;
    
    	@Enumerated(value = EnumType.ORDINAL)
    	@Column(name = "AMORTIZACIONDESCUENTOS" )
    private EnumTipoAmortizacionDescuentos amortizacionDescuentos;
    
    	
    /**
   	 * CC722: Permite SI/NO, Indica si se permite o no generar cargos ajustes sobre los saldos a favor de obligaciones pagas.
	 */
    @Column(name = "DEVSALDOSAFAVORAPLICATIVO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 1")
    private Boolean devSaldosAFavorAplicativo = true;
    
    /**
     * CC720 Número de días de gracia que tiene un cliente en mora del producto
     * Confirming
     */
    @Column(name = "DIASGRACIACONFIRMING" )
    private Long diasGraciaConfirming = 0L;

    /**
     * CC720 Días de gracia que tiene un cliente en mora del producto Descuento
     * de Títulos
     */
    @Column(name = "DIASGRACIADESCUENTOTITULOS" )
    private Long diasGraciaDescuentoTitulos = 0L;

    /**
     * CC720 días de gracia que tiene un cliente en mora del producto Línea
     * Triangular
     */
    @Column(name = "DIASGRACIALINEATRIANGULAR" )
    private Long diasGraciaLineaTriangular = 0L;

    /**
     * CC720 Dias de Gracia que tiene un cliente en mora del producto ADC
     */
    @Column(name = "DIASGRACIAADC" )
    private Long diasGraciaADC = 0L;
    
      
    /**
     * CC740 Controla Tasa Usura LT
     */
    @Column(name = "CONTROLTASAUSURALT",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean controlTasaUsuraLT = false;

    /**
     * CC740 Controla Tasa Usura ADC
     */
    @Column(name = "CONTROLTASAUSURAADC",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean controlTasaUsuraADC = false;
    
       
    @Column(name = "INGRESOEXCLUYENTERC" ,nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean ingresoExcluyenteRC=false; 
    
    @Column(name = "MUESTRAUSULDAP",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 1")
    private Boolean muestraUsuLDAP=true; 
    
    /**
     * CU001 inicio 
     * nuevo campo Muestra Usuarios Funcionales Clientes
     */
    @Column(name = "MUESTRAUSUFUNCLIENTE",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 1")
    private Boolean muestraUsuFunCliente=true; 
    /**
     * CU001
     */
  	
    
    /**
     * 
     */
    @Column(name = "TEXTAUTORIZACIONFACTESPECIALES",nullable=true)
    private String textAutorizacionFactEspeciales;
    
    
    /**
     *  Indica si la entidad financiera solicitará en la página de autenticación
     *  del aplicativo el campo Confirmación Computador Seguro
     */
    @Column(name = "CONFIRMCOMPUTADORSEGURO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 1")
    private Boolean confirmComputadorSeguro=Boolean.FALSE;


    /**
     * Indica si la entidad financiera solicita o no la información
     *  del valor de la factura con IVA para Descuento de Títulos
     */
    @Column(name = "SOLICITAVALORFACIVA",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 1")
    private Boolean solicitaValorFacIVA=Boolean.FALSE;
    

    @Column(name = "CANTIDADPRORROGASPERMITIDAS" )
    private Long cantidadProrrogasPermitidas = 1L;
    
    @Column(name = "PERMITEPRORROGASOBLVENC",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean permiteProrrogasOblVenc = Boolean.FALSE;
    
	/**
	 * Indica si al autorizar un castigo se lleva la cartera de la obligación a ceros o no se realiza ninguna accion.
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "FORMACALCULARVALORPRORROGA" )
	private EnumFormaCalcularValorProrroga formaCalcularValorProrroga;
	
	 /**
     * 
     */
    @Column(name = "PERMITEABONOSCUENTADEUDOR" ,nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean permiteAbonosCuentaDeudor = false;
	
	
	/**
	 * el número de días que se le dará de plazo adicional para el vencimiento de la 
	 * contraseña a un usuario en dónde el sistema le hace la administración de la contraseña. Campo requerido
	 */
    @Column(name = "DIASADICVIGPASSWORDUSUARIO" )
	private Long diasAdicVigPasswordUsuario = 0L;
	
	/**
	 * Indica cómo la entidad financiera hace que sus clientes determinen las cuentas 
	 * Bancarias a las cuales se debe hacer un desembolso en la opción de Administrar Desembolso Asistido
	 */
    @Column(name = "CANTPAGINASAUTENTICACION" )
	private String cantPaginasAutenticacion;
	
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "MEDIOPAGODESEMBASIST" )
	private EnumMedioPagoDesemAsist medioPagoDesembAsist;
	
	/**
	 * CC770
	 * indica si un titulo se puede anticipar
	 */
    @Column(name = "PERMITEANTICIPOTITULOS",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean permiteAnticipoTitulos = false;	
    
    /**
     * CC770
     * indica la constante que se adjunta en el numero del titulo que nace como un anticipo a 
     * un titulo original
     */
    @Column(name = "NUMEROTITULOANTICIPADO" )
	private String numeroTituloAnticipado;
	
	/**
	 * CC770
	 * Indica si el sistema mostrara o no el Endeudamiento del cliente 
	 * en las opciones de autorizar desembolso de Titulos Valores
	 */
    @Column(name = "MUESTRAENDEUDAMIENTO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean muestraEndeudamiento = false;	
    
    @Column(name = "MENSAJENAVEGADOR" )
	private String mensajeNavegador;
	
	
	@Column(name = "PERMITEAGRUPACIONTITULOSDT",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean permiteAgrupacionTitulosDT;
	
	
	@Column(name = "PERMITEAGRUPACIONFACTURASCF",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean permiteAgrupacionFacturasCF;
	
	@Column(name = "TERMINOSCONDCFSINRESPVEND" )
	private String terminosCondCFsinRespVend;
	
	@Column(name = "TERMINOSCONDCFSINRESPCOMP" )
	private String terminosCondCFsinRespComp;
	
	@Column(name = "TERMINOSCONDCFCONRESPCOMP" )
	private String terminosCondCFconRespComp;
	
	@Column(name = "TERMINOSCONDLTCARGCOMP" )
	private String terminosCondLTCargComp;

	@Column(name = "TERMINOSCONDLTCARGVEND" )
	private String terminosCondLTCargVend;

	@Column(name = "TERMINOSCONDLTAUTORIZACIONVEND" )
	private String terminosCondLTAutorizacionVend;
	
	
    @Column(name = "CONSOLIDADESEMBOLSOSASISTIDOS",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean consolidaDesembolsosAsistidos = false;		
    
    @Column(name = "MENSAJEBIENVENIDA" )
	private String mensajeBienvenida;
    
    @Column(name = "MENSAJEINFORMACION" )
	private String mensajeInformacion;
    
    @Column(name = "ACEPTATERMINOSCONDICIONES",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean aceptaTerminosCondiciones=false;
    
    /**
	 * Parametro que permite determinar la forma en que el sistema presentará a 
	 * los clientes la información de un Plan de Línea Triangular
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "FORMAPRESENTAPLANLT" )
	private EnumFormPresentaPlanCliente formaPresentaPlanLt;
    
	/**
	 * parametro que permite crear perfiles asociados a rol y producto
	 */
    @Column(name = "CTRLPERFILESPRODUCTOROLCLIENTE",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean ctrlPerfilesProductoRolCliente=false;
    
    /**
	 * parametro que permite manejar una Tabla para determinar la 
	 * Tasa de Descuento para los Productos que manejan el descuento por Tabla
	 */
    @Column(name = "MANEJATABLADESCUENTO",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean manejaTablaDescuento=false;
    
    @Column(name = "TERMINOSCONDDTAUTORIZACIONCOMP" )
	private String terminosCondDtAutorizacionComp;
    
    /**
	 * CC860- Parametro que permite determinar Tipo Flujo DT
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "TIPOFLUJODT" )
	private EnumTipoFlujoDT tipoFlujoDT;
	
	/**
	 * 
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ESTADOFORMNEGOCIACION" )
	private EnumEstadoTitulo estadoFormNegociacion;
	
	/**
	 * Parámetro que permite determinar el método de asginación de oficina
	 * Mantis 0225828
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "METODOASIGNACIONOFICINA" )
	private EnumMetodoAsignacionOficina metodoAsignacionOficina;
	
	/**
	 * CC820 - Parámetro para determinar si se hará o no el cargue de los 
	 * montos máximos a través del proceso de cargue de disponibles
	 */
	@Column(name = "CARGAMONTOSMAXIMOS",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean cargaMontosMaximos = Boolean.FALSE;
	
	/**
	 * 249654 - Parámetro para determinar si se solicitará o no el Acta de
	 * Aprobación del Cupo al momento de hacer el registro del VMD a nivel de
	 * Producto.
	 */
	@Column(name = "SOLICITAACTAAPROBACIONCUPO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
	private Boolean solicitaActaAprobacionCupo = Boolean.FALSE;
	
	/**
	 * Permite SI/NO realizarse abono parcial a cuenta
	 */
	@Column(name = "ABONOPARCIALACUENTA",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean abonoParcialACuenta = false;
	
	/**
	 * OM0233100 - Permite SI/NO Reconocer Devolución Descuento Comprador
	 */
	@Column(name = "RECONOCEDEVDCTOCOMPRADOR" ,nullable=true, columnDefinition="NUMBER(1) DEFAULT 1")
	private Boolean reconoceDevDctoComprador;
	
	/**
	 * OM0233100 - Permite SI/NO Financiación LT
	 */
	@Column(name = "PERMITEFINANCIACIONLT",nullable=true, columnDefinition="NUMBER(1) DEFAULT 1")
	private Boolean permiteFinanciacionLT;
	
	/**
	 * OM0233100 - Primera Prórroga Cancela Obligación SI/NO 
	 */
	@Column(name = "PRIMERAPRORROGACANCELAOBL",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean primeraProrrogaCancelaObl;
	
	/**
	 * OM 234731 
	 */
	@Column(name = "TERMINOSCONDPRORROGA" )
	private String terminosCondProrroga;
	
	
	/**
	 * OM 232799 - Incluye formato usuarios ef
	 */
	@Column(name = "INCLUYEFORMATOUSUARIOSEF",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean incluyeFormatoUsuariosEF = Boolean.FALSE;
	
	/**
	 * OM 248020 - atributo Autogestión Seguridad Confirming Sin Responsabilidad
	 */
	
	@Column(name = "AUTOGESTIONSEGCFSINRESP",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean autogestionSegCFSinResp = Boolean.FALSE;
	
	/**
	 * OM 255788 - atributo Maneja Reembolso
	 */
	@Column(name = "MANEJAREEMBOLSO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean manejaReembolso = Boolean.FALSE;
	
	/**
	 * OM 255788 - atributo Maneja Confirming nuevo
	 */
	@Column(name = "CONFIRMINGNUEVO" ,nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean confirmingNuevo = Boolean.FALSE;
	
	/**
	 * OM 255788 - atributo Maneja Reembolso
	 */
	@Column(name = "MUESTRATERMINOS",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean muestraTerminos = Boolean.FALSE;
	
	/**
	 * OM 255788 - atributo Asignar Información Contacto
	 */
	@Column(name = "ASIGNAINFOCONTACTO" ,nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean asignaInfoContacto = Boolean.FALSE;
	
	/**
	 * OM 232799 - Responsable Asignación Claves
	 */
	@Column(name = "RESPONSABLEASIGCLAVES" )
	private String responsableAsigClaves;
	
	/**
	 * OM 232799 - Puesto Asignación Claves
	 */
	@Column(name = "PUESTOASIGCLAVES" )
	private String puestoAsigClaves;
	
	
	/**
	 * OM 232799 -	Manejo Calificación Clientes
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "MANEJOCALIFICACIONCLIENTES" )
	private EnumManejoCalificacion manejoCalificacionClientes;
	
	
	/**
	 * OM 0244321 
	 * Parámetro SI/NO Indica si el sistema hará la causación de los intereses de mora de forma diferenciada para cada uno de los clientes

	 */
	@Column(name = "CAUSACIONMORADIFERENCIADA" )
	private Boolean causacionMoraDiferenciada;
	
	/**
	 * OM 0244321 
	 * Indica la cantidad de días con los cuales se debe calcular el descuento de una operación 

	 */
	@Column(name = "DIASBASEDESCUENTO" )
	private Long diasBaseDescuento=360L;
	
	/**
	 * OM 0244321 
	 * Parámetro SI/NO Indica si el sistema hará o no la validación de la información de la Factura Electrónica

	 */
	@Column(name = "VALIDAFACTURAELECTRONICA" )
	private Boolean validaFacturaElectronica;
	
	/**
	 * OM 0247097
	 * Parámetro AUTORIZA/NO AUTORIZA Indica la acción que hará el sistema al momento de autorizar una factura electrónica
	 
	 */
	@Column(name = "ACCFACTELECT" )
	private Boolean accFactElect;
	
	/**
	 * OM 0247097
	 * Parámetro SI/NO Indica si el sistema hará o no la validación sobre el valor neto de la Factura Electrónica
	 */
	@Column(name = "VALVARNETFACTELECT" )
	private Boolean valVarNetFactElect;
	/** CC939  CU219 
	 * */
	@Column(name = "CANTREGCONS" )
	private Long cantRegCons;
	
	@Column(name = "MUESTRACUPOCOMPRADORES",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean muestraCupoCompradores;
	
	//Mantis 246591
	/**
	 * Parámetro SI/NO que indica si la entidad financiera permite débitos automáticos o no
	 */
	@Column(name = "PERMITEDEBITOSAUTOMATICOS" )
	private Boolean permiteDebitosAutomaticos;
	/**
	 * Parámetro SI/NO que indica si la entidad financiera paga facturas no negociadas
	 */
	@Column(name = "PAGAFACTURASNONEGOCIADAS" )
	private Boolean pagaFacturasNoNegociadas;
	
	//Mantis 247795
	@Column(name = "MANEJACENTAVOSDESEMBOLSO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean manejaCentavosDesembolso = false;	
	
	
	//Mantis 0246874
	/**
	 * Indica 'unico por Sistema' si la numeracion de las obligación utilizará un único consecutivo por sistema o el valor 'Uno por cada Producto' si se requiere un consecutivo por cada producto.
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "CONSECUTIVOOBLIGACIONES" )
	private EnumConsecutivoObligaciones consecutivoObligaciones;
	
	//Mantis 0248885 nota 0594383
	
	/**
	 * Campo para almacenar los terminos y condiciones de la autorizaciónde las facturas de un comprador de confirming. 
	 */
	@Column(name = "TERMINOSCONDCFSINRESPCOMPAUT" )
	private String terminosCondCFSinRespCompAut;
	
	//248289
		/**
		 *  Indica el momento cuando el sistema va a cobrar la prórroga
		 */
		@Enumerated(value = EnumType.ORDINAL)
		@Column(name = "MOMENTOCOBRARPRORROGA" )
		private EnumMomentoCobrarProrroga momentoCobrarProrroga;
		
		/**
	     * CC720 Días de gracia que tiene un cliente en mora del producto Descuento
	     * de Títulos
	     */
		@Column(name = "DIASPARASOLICITARPRORROGAS" )
	    private Long diasParaSolicitarProrrogas = 0L;
	    
	    
	    //CU 001 V94
	    
	  //Hora Máxima para Solicitar Prórrogas
		@Column(name = "HORAMAXSOLICITUDPRORROGAS"  , columnDefinition = "TIMESTAMP") 
		private Date horaMaxSolicitudProrrogas;
	    
	  //Hora Permite Tasa Prórroga
		@Column(name = "PERMITETASAPRORROGA" ,nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
		private Boolean permiteTasaProrroga = false;

	  //Hora Fecha Prórroga Automática
		@Column(name = "FECHAPRORROGAAUTOMATICA",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
		private Boolean fechaProrrogaAutomatica = false;
			
//	  // Productos con Prórroga
//		@Column(name = "PRODUCTOSPRORROGA")
//		@OneToMany(fetch = FetchType.LAZY, mappedBy = "parametroEntidad", cascade = CascadeType.REFRESH)
//		private List<PraEnt_Producto> productosConProgorra;
//		
//		
		
	//255882
		@Column(name = "HORAMAXIMAGENERACION"  , columnDefinition = "TIMESTAMP") 
	private Date horaMaximaGeneracion;
	
	//CC974
	/**
	 * OM 255788 - atributo Maneja Reembolso
	 */
	@Column(name = "MANEJANOTASCREDITO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean manejaNotasCredito = Boolean.FALSE;
	
	/**
	 * OM 255788 - atributo Maneja Reembolso
	 */
	@Column(name = "PERMITEDESEMBOLSOMORA",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean permiteDesembolsoMora = Boolean.FALSE;
	
	/**
	 * CC973 - Permite SI/NO usuario de seguridad con perfiles funcionales para los usuarios de seguridad
	 */
	@Column(name = "PERMITEUSUARIOSSEGFUNC",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean permiteUsuariosSegFunc = false;
	
	/**
	 * CC973 - Maneja SI/NO usuario calendarios de pagos para los compradores de confirming.
	 */
	@Column(name = "MANEJACALENDARIOSCF",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean manejaCalendariosCF = false;
	
	/**
	 * CC973 - Muestra SI/NO token para el ingreso de los usuarios.
	 */
	@Column(name = "MUESTRATOKENINGRESO",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean muestraTokenIngreso = false;
	
	/**
	 * OM 263805 variable que maneja el tiempo limite valido para los registros
	 * de concurrencia de la tabla PROCESOAUTORIZARFACTURASCF.
	 */
	@Column(name = "TIEMPOLIMPROCESAUTORIFACTCF" )
	private Long tiempoLimProcesAutoriFactCF;
	
	/**
	 * Indica si se debe ejecutar el flujo alternativo 4.4 del CU121 Generar Desembolsos V55
	 * M0263926
	 */
	@Column(name = "PAGAMORACONDESEMBOLSO",nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean pagaMoraConDesembolso;
	
	/**
     * CC971. Indica si el sistema permitirá o no habilitar la funcionalidad 
     * de Abono a Cuenta para la aplicación de pagos que hagan los 
     * deudores cuando no se valida la referencia de pago
     */
    @Column(name = "ABONOSCUENTASINREFERENCIA",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean abonosCuentaSinReferencia = false;
    
    /**
     * CC964. Parametro que indica que se cobra el GMF: 
     * "Gravámen a los Movimientos Financieros (4x1.000)" 
     * cuando un producto de Linea Triangular no tiene asociado un descuento
     */
    @Column(name = "COBRAGMFDESCUENTOCERO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean cobraGMFDescuentoCero = false;
    
    /**
	 * Indica el tipo de modalidad ADC. M0267259
	 */
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "MODALIDADADC" )
	private EnumModalidadADC modalidadADC;
	
	 @Column(name = "CUPODTPORCNEGOCIACION",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 1")
	 private Boolean cupoDTPorcNegociacion = true;
	 	 
	/**
	 * CU233- Obtener Información Factura Electrónica
	 */
	 @Column(name = "TERMINOSCONDFACTELECTRONICA" )
	private String terminosCondFactElectronica;
	
	//Mantis 0281502 jhmonroy
	/**
	 * Tiene la información de contacto del servicio al cliente de PSE para el 
	 * CU901 - Invocar Servicio de Pago en línea por PSE versión 03
	 */
	 @Column(name = "PSETEXTOSERVICIOCLIENTE" )
	private String pseTextoServicioCliente;
	
	//Mantis 0282661 jhmonroy
	/**
	 * Indica si el CUFE será o no obligatorio al momento de cargar una factura.
	 */
	@Column(name = "CUFEOBLIGATORIO",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean cufeObligatorio = false;
	
	/**
	 * Indica si la entidad Maneja tasa diferencial
	 */
	@Column(name = "MANEJATASADIFERENCIAL",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean manejaTasaDiferencial = false;
	
	/**
	 * Indica si la entidad maneja validacion de eventos radian
	 */
	@Column(name = "RADIANVALIDAEVENTOS",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
	private Boolean radianValidaEventos = false;
	 
	/**
	 * Indica si la entidad maneja endosa 
	 */
	@Column(name = "RADIANPRIMEROENDOSA",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
	private Boolean radianPrimeroEndosa = false;
	
	
	/**
	 * 
	 * 
	 */
	@Column(name = "CIIU" )
	private String CIIU;
	/**
	 * 
	 */
	@Column(name = "CUATROXMILPSE",nullable = true, columnDefinition = "NUMBER(1) DEFAULT 0")
	private Boolean cuatroxmilpse;
	
	/**
	 * 
	 * Ultima fecha en el que se consulto fecha a los bancos PSE
	 */
	@Column(name = "PSE_FECHA_ULTIMA_LISTA_BANCOS"  , columnDefinition = "TIMESTAMP") 
	private Date pse_fecha_ultima_lista_bancos;
	
	@Column(name = "PSE_MENSAJE_TIPO_PERSONA" )	
	private String pse_mensaje_tipo_persona;
	
	
	/*************************************************************************/

	/**
	 * No-Arg Constructor
	 */
	public ParametroEntidad() {
	}

	/**
	 * Constructor
	 */
	public ParametroEntidad(final Long id) {
		this.id = id;
	}


	/*************************************************************************/
	
	
	
	public String getContactoInfoPSE() {
		return contactoInfoPSE;
	}

	public void setContactoInfoPSE(String contactoInfoPSE) {
		this.contactoInfoPSE = contactoInfoPSE;
	}

	/**
	 * Returns diasNotificacionVencimiento value
	 */
	public Long getDiasNotificacionVencimiento() {
		return diasNotificacionVencimiento;
	}
	
	/** 
	 * Sets diasNotificacionVencimiento value
	 */
	public void setDiasNotificacionVencimiento(final Long diasNotificacionVencimiento) {
		this.diasNotificacionVencimiento = diasNotificacionVencimiento;
	}

	/**
	 * Returns algoritmo value
	 */
	public String getAlgoritmo() {
		return algoritmo;
	}
	
	/** 
	 * Sets algoritmo value
	 */
	public void setAlgoritmo(final String algoritmo) {
		this.algoritmo = algoritmo;
	}

	/**
	 * Returns id value
	 */
	public Long getId() {
		return id;
	}
	
	/** 
	 * Sets id value
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Returns valorLimiteMicroCredito value
	 */
	public BigDecimal getValorLimiteMicroCredito() {
		return valorLimiteMicroCredito;
	}
	
	/** 
	 * Sets valorLimiteMicroCredito value
	 */
	public void setValorLimiteMicroCredito(final BigDecimal valorLimiteMicroCredito) {
		this.valorLimiteMicroCredito = valorLimiteMicroCredito;
	}

	/**
	 * Returns entidadFinanciera value
	 */
	public EntidadFinanciera getEntidadFinanciera() {
		return entidadFinanciera;
	}
	
	/** 
	 * Sets entidadFinanciera value
	 */
	public void setEntidadFinanciera(final EntidadFinanciera entidadFinanciera) {
		this.entidadFinanciera = entidadFinanciera;
	}
	
	/**
	 * Returns numeroMesesCalendario value
	 */
	public Long getNumeroMesesCalendario() {
		return numeroMesesCalendario;
	}
	
	/** 
	 * Sets numeroMesesCalendario value
	 */
	public void setNumeroMesesCalendario(final Long numeroMesesCalendario) {
		this.numeroMesesCalendario = numeroMesesCalendario;
	}

	/**
	 * Returns politicasSeguridad value
	 */
	public String getPoliticasSeguridad() {
		return politicasSeguridad;
	}
	
	/** 
	 * Sets politicasSeguridad value
	 */
	public void setPoliticasSeguridad(final String politicasSeguridad) {
		this.politicasSeguridad = politicasSeguridad;
	}

	/**
	 * Returns nombreSkin value
	 */
	public String getNombreSkin() {
		return nombreSkin;
	}
	
	/** 
	 * Sets nombreSkin value
	 */
	public void setNombreSkin(final String nombreSkin) {
		this.nombreSkin = nombreSkin;
	}

	/**
	 * Returns nombreLogo value
	 */
	public String getNombreLogo() {
		return nombreLogo;
	}
	
	/** 
	 * Sets nombreLogo value
	 */
	public void setNombreLogo(final String nombreLogo) {
		this.nombreLogo = nombreLogo;
	}

	/**
	 * Returns politicasPrivacidad value
	 */
	public String getPoliticasPrivacidad() {
		return politicasPrivacidad;
	}
	
	/** 
	 * Sets politicasPrivacidad value
	 */
	public void setPoliticasPrivacidad(final String politicasPrivacidad) {
		this.politicasPrivacidad = politicasPrivacidad;
	}

	/**
	 * Returns configuracionSeguridad value
	 */
	public String getConfiguracionSeguridad() {
		return configuracionSeguridad;
	}
	
	/** 
	 * Sets configuracionSeguridad value
	 */
	public void setConfiguracionSeguridad(final String configuracionSeguridad) {
		this.configuracionSeguridad = configuracionSeguridad;
	}

	/**
	 * Returns infoContacto value
	 */
	public String getInfoContacto() {
		return infoContacto;
	}
	
	/** 
	 * Sets infoContacto value
	 */
	public void setInfoContacto(final String infoContacto) {
		this.infoContacto = infoContacto;
	}

	/**
	 * Returns infoDireccion value
	 */
	public String getInfoDireccion() {
		return infoDireccion;
	}
	
	/** 
	 * Sets infoDireccion value
	 */
	public void setInfoDireccion(final String infoDireccion) {
		this.infoDireccion = infoDireccion;
	}

	/**
	 * Returns controlDesembolsoAsistido value
	 */
	public Boolean getControlDesembolsoAsistido() {
		return controlDesembolsoAsistido;
	}
	
	/** 
	 * Sets controlDesembolsoAsistido value
	 */
	public void setControlDesembolsoAsistido(final Boolean controlDesembolsoAsistido) {
		this.controlDesembolsoAsistido = controlDesembolsoAsistido;
	}

	/**
	 * Returns servicioListaBloqueo value
	 */
	public Boolean getServicioListaBloqueo() {
		return servicioListaBloqueo;
	}
	
	/** 
	 * Sets servicioListaBloqueo value
	 */
	public void setServicioListaBloqueo(final Boolean servicioListaBloqueo) {
		this.servicioListaBloqueo = servicioListaBloqueo;
	}

	/**
	 * Returns adminTasasManual value
	 */
	public Boolean getAdminTasasManual() {
		return adminTasasManual;
	}
	
	/** 
	 * Sets adminTasasManual value
	 */
	public void setAdminTasasManual(final Boolean adminTasasManual) {
		this.adminTasasManual = adminTasasManual;
	}

	/**
	 * Returns numeroDiasAnticVencOblig value
	 */
	public Long getNumeroDiasAnticVencOblig() {
		return numeroDiasAnticVencOblig;
	}
	
	/** 
	 * Sets numeroDiasAnticVencOblig value
	 */
	public void setNumeroDiasAnticVencOblig(final Long numeroDiasAnticVencOblig) {
		this.numeroDiasAnticVencOblig = numeroDiasAnticVencOblig;
	}

	/**
	 * Returns numeroDiasVencReportar value
	 */
	public Long getNumeroDiasVencReportar() {
		return numeroDiasVencReportar;
	}
	
	/** 
	 * Sets numeroDiasVencReportar value
	 */
	public void setNumeroDiasVencReportar(final Long numeroDiasVencReportar) {
		this.numeroDiasVencReportar = numeroDiasVencReportar;
	}

	/**
	 * Returns diasNotificacionVencimientoObl value
	 */
	public String getDiasNotificacionVencimientoObl() {
		return diasNotificacionVencimientoObl;
	}
	
	/** 
	 * Sets diasNotificacionVencimientoObl value
	 */
	public void setDiasNotificacionVencimientoObl(final String diasNotificacionVencimientoObl) {
		this.diasNotificacionVencimientoObl = diasNotificacionVencimientoObl;
	}

	/**
	 * Returns informacionVDM value
	 */
	public EnumModoVDM getInformacionVDM() {
		return informacionVDM;
	}
	
	/** 
	 * Sets informacionVDM value
	 */
	public void setInformacionVDM(final EnumModoVDM informacionVDM) {
		this.informacionVDM = informacionVDM;
	}

	/**
	 * Returns paramRevPlanLT value
	 */
	public Double getParamRevPlanLT() {
		return paramRevPlanLT;
	}
	
	/** 
	 * Sets paramRevPlanLT value
	 */
	public void setParamRevPlanLT(final Double paramRevPlanLT) {
		this.paramRevPlanLT = paramRevPlanLT;
	}

	/**
	 * Returns plaMaxPlanes value
	 */
	public Long getPlaMaxPlanes() {
		return plaMaxPlanes;
	}
	
	/** 
	 * Sets plaMaxPlanes value
	 */
	public void setPlaMaxPlanes(final Long plaMaxPlanes) {
		this.plaMaxPlanes = plaMaxPlanes;
	}

	/**
	 * Returns codigoBarrasVariable value
	 */
	public Boolean getCodigoBarrasVariable() {
		return codigoBarrasVariable;
	}
	
	/** 
	 * Sets codigoBarrasVariable value
	 */
	public void setCodigoBarrasVariable(final Boolean codigoBarrasVariable) {
		this.codigoBarrasVariable = codigoBarrasVariable;
	}

	/**
	 * Returns consolidaDesembolsos value
	 */
	public Boolean getConsolidaDesembolsos() {
		return consolidaDesembolsos;
	}
	
	/** 
	 * Sets consolidaDesembolsos value
	 */
	public void setConsolidaDesembolsos(final Boolean consolidaDesembolsos) {
		this.consolidaDesembolsos = consolidaDesembolsos;
	}

	/**
	 * Returns nombreCartaNotificacion value
	 */
	public String getNombreCartaNotificacion() {
		return nombreCartaNotificacion;
	}
	
	/** 
	 * Sets nombreCartaNotificacion value
	 */
	public void setNombreCartaNotificacion(final String nombreCartaNotificacion) {
		this.nombreCartaNotificacion = nombreCartaNotificacion;
	}

	/**
	 * Returns firmaCartaNotificacion value
	 */
	public String getFirmaCartaNotificacion() {
		return firmaCartaNotificacion;
	}
	
	/** 
	 * Sets firmaCartaNotificacion value
	 */
	public void setFirmaCartaNotificacion(final String firmaCartaNotificacion) {
		this.firmaCartaNotificacion = firmaCartaNotificacion;
	}

	/**
	 * Returns nombreCargoCartaNotificacion value
	 */
	public String getNombreCargoCartaNotificacion() {
		return nombreCargoCartaNotificacion;
	}
	
	/** 
	 * Sets nombreCargoCartaNotificacion value
	 */
	public void setNombreCargoCartaNotificacion(final String nombreCargoCartaNotificacion) {
		this.nombreCargoCartaNotificacion = nombreCargoCartaNotificacion;
	}

	/**
	 * Returns cargoCartaNotificacion value
	 */
	public String getCargoCartaNotificacion() {
		return cargoCartaNotificacion;
	}
	
	/** 
	 * Sets cargoCartaNotificacion value
	 */
	public void setCargoCartaNotificacion(final String cargoCartaNotificacion) {
		this.cargoCartaNotificacion = cargoCartaNotificacion;
	}

	/**
	 * Returns validaNumerosCuenta value
	 */
	public Boolean getValidaNumerosCuenta() {
		return validaNumerosCuenta;
	}
	
	/** 
	 * Sets validaNumerosCuenta value
	 */
	public void setValidaNumerosCuenta(final Boolean validaNumerosCuenta) {
		this.validaNumerosCuenta = validaNumerosCuenta;
	}

	/**
	 * Returns algoritmoValidacionCuentas value
	 */
	public String getAlgoritmoValidacionCuentas() {
		return algoritmoValidacionCuentas;
	}
	
	/** 
	 * Sets algoritmoValidacionCuentas value
	 */
	public void setAlgoritmoValidacionCuentas(final String algoritmoValidacionCuentas) {
		this.algoritmoValidacionCuentas = algoritmoValidacionCuentas;
	}

	/**
	 * Returns validaServicioLeaIndirecto value
	 */
	public Boolean getValidaServicioLeaIndirecto() {
		return validaServicioLeaIndirecto;
	}
	
	/** 
	 * Sets validaServicioLeaIndirecto value
	 */
	public void setValidaServicioLeaIndirecto(final Boolean validaServicioLeaIndirecto) {
		this.validaServicioLeaIndirecto = validaServicioLeaIndirecto;
	}

	/**
	 * Returns validaServicioDesembolso value
	 */
	public Boolean getValidaServicioDesembolso() {
		return validaServicioDesembolso;
	}
	
	/** 
	 * Sets validaServicioDesembolso value
	 */
	public void setValidaServicioDesembolso(final Boolean validaServicioDesembolso) {
		this.validaServicioDesembolso = validaServicioDesembolso;
	}

	/**
	 * Returns esquemaSeguridad value
	 */
	public EnumEsquemaSeguridad getEsquemaSeguridad() {
		return esquemaSeguridad;
	}
	
	/** 
	 * Sets esquemaSeguridad value
	 */
	public void setEsquemaSeguridad(final EnumEsquemaSeguridad esquemaSeguridad) {
		this.esquemaSeguridad = esquemaSeguridad;
	}

	/**
	 * Returns numeroDiasDesembolso value
	 */
	public Long getNumeroDiasDesembolso() {
		return numeroDiasDesembolso;
	}
	
	/** 
	 * Sets numeroDiasDesembolso value
	 */
	public void setNumeroDiasDesembolso(final Long numeroDiasDesembolso) {
		this.numeroDiasDesembolso = numeroDiasDesembolso;
	}

	/**
	 * Returns validaProvisionesCastigar value
	 */
	public Boolean getValidaProvisionesCastigar() {
		return validaProvisionesCastigar;
	}
	
	/** 
	 * Sets validaProvisionesCastigar value
	 */
	public void setValidaProvisionesCastigar(final Boolean validaProvisionesCastigar) {
		this.validaProvisionesCastigar = validaProvisionesCastigar;
	}

	/**
	 * Returns autorizaDTSinResponsabilidad value
	 */
	public EnumAutorizaDTSinResponsabilidad getAutorizaDTSinResponsabilidad() {
		return autorizaDTSinResponsabilidad;
	}
	
	/** 
	 * Sets autorizaDTSinResponsabilidad value
	 */
	public void setAutorizaDTSinResponsabilidad(final EnumAutorizaDTSinResponsabilidad autorizaDTSinResponsabilidad) {
		this.autorizaDTSinResponsabilidad = autorizaDTSinResponsabilidad;
	}

	/**
	 * Returns requiereOfDesembolsoCheque value
	 */
	public Boolean getRequiereOfDesembolsoCheque() {
		return requiereOfDesembolsoCheque;
	}
	
	/** 
	 * Sets requiereOfDesembolsoCheque value
	 */
	public void setRequiereOfDesembolsoCheque(final Boolean requiereOfDesembolsoCheque) {
		this.requiereOfDesembolsoCheque = requiereOfDesembolsoCheque;
	}

	/**
	 * Returns protegeReferencia value
	 */
	public Boolean getProtegeReferencia() {
		return protegeReferencia;
	}
	
	/** 
	 * Sets protegeReferencia value
	 */
	public void setProtegeReferencia(final Boolean protegeReferencia) {
		this.protegeReferencia = protegeReferencia;
	}

	/**
	 * Returns administraCuentasContables value
	 */
	public Boolean getAdministraCuentasContables() {
		return administraCuentasContables;
	}
	
	/** 
	 * Sets administraCuentasContables value
	 */
	public void setAdministraCuentasContables(final Boolean administraCuentasContables) {
		this.administraCuentasContables = administraCuentasContables;
	}

	/**
	 * Returns numeracionObligaciones value
	 */
	public EnumNumeracionObligacion getNumeracionObligaciones() {
		return numeracionObligaciones;
	}
	
	/** 
	 * Sets numeracionObligaciones value
	 */
	public void setNumeracionObligaciones(final EnumNumeracionObligacion numeracionObligaciones) {
		this.numeracionObligaciones = numeracionObligaciones;
	}

	/**
	 * Returns numeracionCondiciones value
	 */
	public EnumNumeracionCondicion getNumeracionCondiciones() {
		return numeracionCondiciones;
	}
	
	/** 
	 * Sets numeracionCondiciones value
	 */
	public void setNumeracionCondiciones(final EnumNumeracionCondicion numeracionCondiciones) {
		this.numeracionCondiciones = numeracionCondiciones;
	}

	/**
	 * Returns algoritmoReferencia value
	 */
	public String getAlgoritmoReferencia() {
		return algoritmoReferencia;
	}
	
	/** 
	 * Sets algoritmoReferencia value
	 */
	public void setAlgoritmoReferencia(final String algoritmoReferencia) {
		this.algoritmoReferencia = algoritmoReferencia;
	}

	/**
	 * Returns diasNotVigPasswordUsuario value
	 */
	public Long getDiasNotVigPasswordUsuario() {
		return diasNotVigPasswordUsuario;
	}
	
	/** 
	 * Sets diasNotVigPasswordUsuario value
	 */
	public void setDiasNotVigPasswordUsuario(final Long diasNotVigPasswordUsuario) {
		this.diasNotVigPasswordUsuario = diasNotVigPasswordUsuario;
	}

	/**
	 * Returns cobraImpuesto4x1000 value
	 */
	public Boolean getCobraImpuesto4x1000() {
		return cobraImpuesto4x1000;
	}
	
	/** 
	 * Sets cobraImpuesto4x1000 value
	 */
	public void setCobraImpuesto4x1000(final Boolean cobraImpuesto4x1000) {
		this.cobraImpuesto4x1000 = cobraImpuesto4x1000;
	}

	/**
	 * Returns cobraImpuestoLT value
	 */
	public Boolean getCobraImpuestoLT() {
		return cobraImpuestoLT;
	}
	
	/** 
	 * Sets cobraImpuestoLT value
	 */
	public void setCobraImpuestoLT(final Boolean cobraImpuestoLT) {
		this.cobraImpuestoLT = cobraImpuestoLT;
	}

	/**
	 * Returns utilizaSerClientesOccidente value
	 */
	public Boolean getUtilizaSerClientesOccidente() {
		return utilizaSerClientesOccidente;
	}
	
	/** 
	 * Sets utilizaSerClientesOccidente value
	 */
	public void setUtilizaSerClientesOccidente(final Boolean utilizaSerClientesOccidente) {
		this.utilizaSerClientesOccidente = utilizaSerClientesOccidente;
	}

	/**
	 * Returns utilizaSerProductosOccidente value
	 */
	public Boolean getUtilizaSerProductosOccidente() {
		return utilizaSerProductosOccidente;
	}
	
	/** 
	 * Sets utilizaSerProductosOccidente value
	 */
	public void setUtilizaSerProductosOccidente(final Boolean utilizaSerProductosOccidente) {
		this.utilizaSerProductosOccidente = utilizaSerProductosOccidente;
	}

	/**
	 * Returns consolidaNotificacionesCliente value
	 */
	public Boolean getConsolidaNotificacionesCliente() {
		return consolidaNotificacionesCliente;
	}
	
	/** 
	 * Sets consolidaNotificacionesCliente value
	 */
	public void setConsolidaNotificacionesCliente(final Boolean consolidaNotificacionesCliente) {
		this.consolidaNotificacionesCliente = consolidaNotificacionesCliente;
	}

	/**
	 * Returns asignacionCodBarrasFac value
	 */
	public EnumAsigCodBarras getAsignacionCodBarrasFac() {
		return asignacionCodBarrasFac;
	}
	
	/** 
	 * Sets asignacionCodBarrasFac value
	 */
	public void setAsignacionCodBarrasFac(final EnumAsigCodBarras asignacionCodBarrasFac) {
		this.asignacionCodBarrasFac = asignacionCodBarrasFac;
	}

	/**
	 * Returns reintentosFinalizarPSE value
	 */
	public Long getReintentosFinalizarPSE() {
		return reintentosFinalizarPSE;
	}
	
	/** 
	 * Sets reintentosFinalizarPSE value
	 */
	public void setReintentosFinalizarPSE(final Long reintentosFinalizarPSE) {
		this.reintentosFinalizarPSE = reintentosFinalizarPSE;
	}

	/**
	 * Returns utilizaDetalleBodega value
	 */
	public Boolean getUtilizaDetalleBodega() {
		return utilizaDetalleBodega;
	}
	
	/** 
	 * Sets utilizaDetalleBodega value
	 */
	public void setUtilizaDetalleBodega(final Boolean utilizaDetalleBodega) {
		this.utilizaDetalleBodega = utilizaDetalleBodega;
	}

	/**
	 * Returns tiempoInvocacionCambioEstado value
	 */
	public Long getTiempoInvocacionCambioEstado() {
		return tiempoInvocacionCambioEstado;
	}
	
	/** 
	 * Sets tiempoInvocacionCambioEstado value
	 */
	public void setTiempoInvocacionCambioEstado(final Long tiempoInvocacionCambioEstado) {
		this.tiempoInvocacionCambioEstado = tiempoInvocacionCambioEstado;
	}

	/**
	 * Returns tiempoInvocacionPendiente value
	 */
	public Long getTiempoInvocacionPendiente() {
		return tiempoInvocacionPendiente;
	}
	
	/** 
	 * Sets tiempoInvocacionPendiente value
	 */
	public void setTiempoInvocacionPendiente(final Long tiempoInvocacionPendiente) {
		this.tiempoInvocacionPendiente = tiempoInvocacionPendiente;
	}

	/**
	 * Returns tiempoMaxConfirmacionPSE value
	 */
	public Long getTiempoMaxConfirmacionPSE() {
		return tiempoMaxConfirmacionPSE;
	}
	
	/** 
	 * Sets tiempoMaxConfirmacionPSE value
	 */
	public void setTiempoMaxConfirmacionPSE(final Long tiempoMaxConfirmacionPSE) {
		this.tiempoMaxConfirmacionPSE = tiempoMaxConfirmacionPSE;
	}

	/**
	 * Returns entregaClavesEF value
	 */
	public EnumTipoEntregaClaves getEntregaClavesEF() {
		return entregaClavesEF;
	}
	
	/** 
	 * Sets entregaClavesEF value
	 */
	public void setEntregaClavesEF(final EnumTipoEntregaClaves entregaClavesEF) {
		this.entregaClavesEF = entregaClavesEF;
	}

	/**
	 * Returns entregaClavesCliente value
	 */
	public EnumTipoEntregaClaves getEntregaClavesCliente() {
		return entregaClavesCliente;
	}
	
	/** 
	 * Sets entregaClavesCliente value
	 */
	public void setEntregaClavesCliente(final EnumTipoEntregaClaves entregaClavesCliente) {
		this.entregaClavesCliente = entregaClavesCliente;
	}

	/**
	 * Returns esquemaConexionLDAP value
	 */
	public EnumEsquemaConexionLDAP getEsquemaConexionLDAP() {
		return esquemaConexionLDAP;
	}
	
	/** 
	 * Sets esquemaConexionLDAP value
	 */
	public void setEsquemaConexionLDAP(final EnumEsquemaConexionLDAP esquemaConexionLDAP) {
		this.esquemaConexionLDAP = esquemaConexionLDAP;
	}

	/**
	 * Returns pagaMoraSaldoFavor value
	 */
	public Boolean getPagaMoraSaldoFavor() {
		return pagaMoraSaldoFavor;
	}
	
	/** 
	 * Sets pagaMoraSaldoFavor value
	 */
	public void setPagaMoraSaldoFavor(final Boolean pagaMoraSaldoFavor) {
		this.pagaMoraSaldoFavor = pagaMoraSaldoFavor;
	}

	/**
	 * Returns modoFTPPassive value
	 */
	public Boolean getModoFTPPassive() {
		return modoFTPPassive;
	}
	
	/** 
	 * Sets modoFTPPassive value
	 */
	public void setModoFTPPassive(final Boolean modoFTPPassive) {
		this.modoFTPPassive = modoFTPPassive;
	}

	/**
	 * Returns separadorRtaWSAutenticacion value
	 */
	public String getSeparadorRtaWSAutenticacion() {
		return separadorRtaWSAutenticacion;
	}
	
	/** 
	 * Sets separadorRtaWSAutenticacion value
	 */
	public void setSeparadorRtaWSAutenticacion(final String separadorRtaWSAutenticacion) {
		this.separadorRtaWSAutenticacion = separadorRtaWSAutenticacion;
	}

	/**
	 * Returns appWSAutorizacion value
	 */
	public String getAppWSAutorizacion() {
		return appWSAutorizacion;
	}
	
	/** 
	 * Sets appWSAutorizacion value
	 */
	public void setAppWSAutorizacion(final String appWSAutorizacion) {
		this.appWSAutorizacion = appWSAutorizacion;
	}

	/**
	 * Returns cuandoReversarConstitucion value
	 */
	public EnumReversarConstitucion getCuandoReversarConstitucion() {
		return cuandoReversarConstitucion;
	}
	
	/** 
	 * Sets cuandoReversarConstitucion value
	 */
	public void setCuandoReversarConstitucion(final EnumReversarConstitucion cuandoReversarConstitucion) {
		this.cuandoReversarConstitucion = cuandoReversarConstitucion;
	}

	/**
	 * Returns separadorRtaWSAutorizacion value
	 */
	public String getSeparadorRtaWSAutorizacion() {
		return separadorRtaWSAutorizacion;
	}
	
	/** 
	 * Sets separadorRtaWSAutorizacion value
	 */
	public void setSeparadorRtaWSAutorizacion(final String separadorRtaWSAutorizacion) {
		this.separadorRtaWSAutorizacion = separadorRtaWSAutorizacion;
	}

	/**
	 * Returns causacionInteresMora value
	 */
	public EnumTipoCausacionMora getCausacionInteresMora() {
		return causacionInteresMora;
	}
	
	/** 
	 * Sets causacionInteresMora value
	 */
	public void setCausacionInteresMora(final EnumTipoCausacionMora causacionInteresMora) {
		this.causacionInteresMora = causacionInteresMora;
	}

	/**
	 * Returns validaDesembolsoDistribuido value
	 */
	public Boolean getValidaDesembolsoDistribuido() {
		return validaDesembolsoDistribuido;
	}
	
	/** 
	 * Sets validaDesembolsoDistribuido value
	 */
	public void setValidaDesembolsoDistribuido(final Boolean validaDesembolsoDistribuido) {
		this.validaDesembolsoDistribuido = validaDesembolsoDistribuido;
	}

	/**
	 * Returns fechaProceso value
	 */
	public Date getFechaProceso() {
		return fechaProceso;
	}
	
	/** 
	 * Sets fechaProceso value
	 */
	public void setFechaProceso(final Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	/**
	 * Returns accionCastigo value
	 */
	public EnumAccionCastigo getAccionCastigo() {
		return accionCastigo;
	}
	
	/** 
	 * Sets accionCastigo value
	 */
	public void setAccionCastigo(final EnumAccionCastigo accionCastigo) {
		this.accionCastigo = accionCastigo;
	}

	/**
	 * Returns utilizaSerValidarClientes value
	 */
	public Boolean getUtilizaSerValidarClientes() {
		return utilizaSerValidarClientes;
	}
	
	/** 
	 * Sets utilizaSerValidarClientes value
	 */
	public void setUtilizaSerValidarClientes(final Boolean utilizaSerValidarClientes) {
		this.utilizaSerValidarClientes = utilizaSerValidarClientes;
	}
	
	/**
	 * Returns ajustaVolanteUnidad value
	 */
	public Boolean getAjustaVolanteUnidad() {
		return ajustaVolanteUnidad;
	}
	
	/** 
	 * Sets ajustaVolanteUnidad value
	 */
	public void setAjustaVolanteUnidad(final Boolean ajustaVolanteUnidad) {
		this.ajustaVolanteUnidad = ajustaVolanteUnidad;
	}
			
	/**
	 * @return
	 */
	public Boolean getPermitePagoReferenciaPago() {
		return permitePagoReferenciaPago;
	}

	/**
	 * @param permitePagoReferenciaPago
	 */
	public void setPermitePagoReferenciaPago(Boolean permitePagoReferenciaPago) {
		this.permitePagoReferenciaPago = permitePagoReferenciaPago;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getPermitePagoObligaciones() {
		return permitePagoObligaciones;
	}

	/**
	 * 
	 * @param permitePagoObligaciones
	 */
	public void setPermitePagoObligaciones(Boolean permitePagoObligaciones) {
		this.permitePagoObligaciones = permitePagoObligaciones;
	}

	/*************************************************************************/

	

	public Boolean getConsolidaDesembolsosAnalizar() {
		return consolidaDesembolsosAnalizar;
	}

	public void setConsolidaDesembolsosAnalizar(Boolean consolidaDesembolsosAnalizar) {
		this.consolidaDesembolsosAnalizar = consolidaDesembolsosAnalizar;
	}

	/**
	 * Returns a string representation of the object.
	 */
	@Override
	public String toString() {
		return getClass().getName() + "|id=" + id;
	}

	
	/**
	 * @return the informativoPagoPSE
	 */
	public String getInformativoPagoPSE() {
		return informativoPagoPSE;
	}

	/**
	 * @param informativoPagoPSE the informativoPagoPSE to set
	 */
	public void setInformativoPagoPSE(String informativoPagoPSE) {
		this.informativoPagoPSE = informativoPagoPSE;
	}

	/**
	 * @return the digitalizaTitulos
	 */
	public Boolean getDigitalizaTitulos() {
		return digitalizaTitulos;
	}

	/**
	 * @param digitalizaTitulos the digitalizaTitulos to set
	 */
	public void setDigitalizaTitulos(Boolean digitalizaTitulos) {
		this.digitalizaTitulos = digitalizaTitulos;
	}

	/**
	 * @return the liquidaTotalidadSaldoFavor
	 */
	public Boolean getLiquidaTotalidadSaldoFavor() {
		return liquidaTotalidadSaldoFavor;
	}

	/**
	 * @param liquidaTotalidadSaldoFavor the liquidaTotalidadSaldoFavor to set
	 */
	public void setLiquidaTotalidadSaldoFavor(Boolean liquidaTotalidadSaldoFavor) {
		this.liquidaTotalidadSaldoFavor = liquidaTotalidadSaldoFavor;
	}

	/**
	 * @return the autorizarNegociosADC
	 */
	public String getAutorizarNegociosADC() {
		return autorizarNegociosADC;
	}

	/**
	 * @param autorizarNegociosADC the autorizarNegociosADC to set
	 */
	public void setAutorizarNegociosADC(String autorizarNegociosADC) {
		this.autorizarNegociosADC = autorizarNegociosADC;
	}

	/**
	 * @return the autorizarNegociosLT
	 */
	public String getAutorizarNegociosLT() {
		return autorizarNegociosLT;
	}

	/**
	 * @param autorizarNegociosLT the autorizarNegociosLT to set
	 */
	public void setAutorizarNegociosLT(String autorizarNegociosLT) {
		this.autorizarNegociosLT = autorizarNegociosLT;
	}

	/**
	 * @return the autorizarNegociosCF
	 */
	public String getAutorizarNegociosCF() {
		return autorizarNegociosCF;
	}

	/**
	 * @param autorizarNegociosCF the autorizarNegociosCF to set
	 */
	public void setAutorizarNegociosCF(String autorizarNegociosCF) {
		this.autorizarNegociosCF = autorizarNegociosCF;
	}

	/**
	 * @return the autorizarNegociosDT
	 */
	public String getAutorizarNegociosDT() {
		return autorizarNegociosDT;
	}

	/**
	 * @param autorizarNegociosDT the autorizarNegociosDT to set
	 */
	public void setAutorizarNegociosDT(String autorizarNegociosDT) {
		this.autorizarNegociosDT = autorizarNegociosDT;
	}

	/**
	 * @return the cobraGMFADC
	 */
	public Boolean getCobraGMFADC() {
		return cobraGMFADC;
	}

	/**
	 * @param cobraGMFADC the cobraGMFADC to set
	 */
	public void setCobraGMFADC(Boolean cobraGMFADC) {
		this.cobraGMFADC = cobraGMFADC;
	}

	/**
	 * @return the cobraGMFASaldoFavor
	 */
	public Boolean getCobraGMFASaldoFavor() {
		return cobraGMFASaldoFavor;
	}

	/**
	 * @param cobraGMFASaldoFavor the cobraGMFASaldoFavor to set
	 */
	public void setCobraGMFASaldoFavor(Boolean cobraGMFASaldoFavor) {
		this.cobraGMFASaldoFavor = cobraGMFASaldoFavor;
	}

	/**
	 * @return the cobraGMFDesembolso
	 */
	public Boolean getCobraGMFDesembolso() {
		return cobraGMFDesembolso;
	}

	/**
	 * @param cobraGMFDesembolso the cobraGMFDesembolso to set
	 */
	public void setCobraGMFDesembolso(Boolean cobraGMFDesembolso) {
		this.cobraGMFDesembolso = cobraGMFDesembolso;
	}

	/**
	 * @return the muestraFechaPagoFuentePago
	 */
	public Boolean getMuestraFechaPagoFuentePago() {
		return muestraFechaPagoFuentePago;
	}

	/**
	 * @param muestraFechaPagoFuentePago the muestraFechaPagoFuentePago to set
	 */
	public void setMuestraFechaPagoFuentePago(Boolean muestraFechaPagoFuentePago) {
		this.muestraFechaPagoFuentePago = muestraFechaPagoFuentePago;
	}

	/**
	 * @return the permitePagoObligacionPaga
	 */
	public Boolean getPermitePagoObligacionPaga() {
		return permitePagoObligacionPaga;
	}

	/**
	 * @param permitePagoObligacionPaga the permitePagoObligacionPaga to set
	 */
	public void setPermitePagoObligacionPaga(Boolean permitePagoObligacionPaga) {
		this.permitePagoObligacionPaga = permitePagoObligacionPaga;
	}

	/**
	 * @return the manejaFechaPago
	 */
	public Boolean getManejaFechaPago() {
		return manejaFechaPago;
	}

	/**
	 * @param manejaFechaPago the manejaFechaPago to set
	 */
	public void setManejaFechaPago(Boolean manejaFechaPago) {
		this.manejaFechaPago = manejaFechaPago;
	}

	/**
	 * @return the abonosAObligacionEspecifica
	 */
	public Boolean getAbonosAObligacionEspecifica() {
		return abonosAObligacionEspecifica;
	}

	/**
	 * @param abonosAObligacionEspecifica the abonosAObligacionEspecifica to set
	 */
	public void setAbonosAObligacionEspecifica(Boolean abonosAObligacionEspecifica) {
		this.abonosAObligacionEspecifica = abonosAObligacionEspecifica;
	}

	/**
	 * @return the llaveEncripcionScratch
	 */
	public String getLlaveEncripcionScratch() {
		return llaveEncripcionScratch;
	}

	/**
	 * @param llaveEncripcionScratch the llaveEncripcionScratch to set
	 */
	public void setLlaveEncripcionScratch(String llaveEncripcionScratch) {
		this.llaveEncripcionScratch = llaveEncripcionScratch;
	}

	/**
	 * @return
	 */
	public String getUrlExternaCierreSesionEF() {
		return urlExternaCierreSesionEF;
	}

	/**
	 * @param urlExternaCierreSesionEF
	 */
	public void setUrlExternaCierreSesionEF(String urlExternaCierreSesionEF) {
		this.urlExternaCierreSesionEF = urlExternaCierreSesionEF;
	}

	/**
	 * @return
	 */
	public String getUrlExternaCierreSesionCliente() {
		return urlExternaCierreSesionCliente;
	}

	/**
	 * @param urlExternaCierreSesionCliente
	 */
	public void setUrlExternaCierreSesionCliente(
			String urlExternaCierreSesionCliente) {
		this.urlExternaCierreSesionCliente = urlExternaCierreSesionCliente;
	}

	public EnumDiaHabilitaPSE getDiaHabilitaPSE() {
		return diaHabilitaPSE;
	}

	public void setDiaHabilitaPSE(EnumDiaHabilitaPSE diaHabilitaPSE) {
		this.diaHabilitaPSE = diaHabilitaPSE;
	}

	public String getHoraInicioPSE() {
		return horaInicioPSE;
	}

	public void setHoraInicioPSE(String horaInicioPSE) {
		this.horaInicioPSE = horaInicioPSE;
	}

	public String getHoraFinalPSE() {
		return horaFinalPSE;
	}

	public void setHoraFinalPSE(String horaFinalPSE) {
		this.horaFinalPSE = horaFinalPSE;
	}

	public String getMensajeDiaHabilitaPSE() {
		return mensajeDiaHabilitaPSE;
	}

	public void setMensajeDiaHabilitaPSE(String mensajeDiaHabilitaPSE) {
		this.mensajeDiaHabilitaPSE = mensajeDiaHabilitaPSE;
	}

	public Boolean getObligaCorreosMismoDominio() {
		return obligaCorreosMismoDominio;
	}

	public void setObligaCorreosMismoDominio(Boolean obligaCorreosMismoDominio) {
		this.obligaCorreosMismoDominio = obligaCorreosMismoDominio;
	}

	public Boolean getMuestraPlazoMaximoProrroga() {
		return muestraPlazoMaximoProrroga;
	}

	public void setMuestraPlazoMaximoProrroga(Boolean muestraPlazoMaximoProrroga) {
		this.muestraPlazoMaximoProrroga = muestraPlazoMaximoProrroga;
	}

	public Boolean getMuestraNumFacturaVolantePago() {
		return muestraNumFacturaVolantePago;
	}

	public void setMuestraNumFacturaVolantePago(Boolean muestraNumFacturaVolantePago) {
		this.muestraNumFacturaVolantePago = muestraNumFacturaVolantePago;
	}

	public Boolean getPermiteCaracteresEspeciales() {
		return permiteCaracteresEspeciales;
	}

	public void setPermiteCaracteresEspeciales(Boolean permiteCaracteresEspeciales) {
		this.permiteCaracteresEspeciales = permiteCaracteresEspeciales;
	}

	public Boolean getControlDualDesembolso() {
		return controlDualDesembolso;
	}

	public void setControlDualDesembolso(Boolean controlDualDesembolso) {
		this.controlDualDesembolso = controlDualDesembolso;
	}

	public EnumTipoAmortizacionDescuentos getAmortizacionDescuentos() {
		return amortizacionDescuentos;
	}

	public void setAmortizacionDescuentos(
			EnumTipoAmortizacionDescuentos amortizacionDescuentos) {
		this.amortizacionDescuentos = amortizacionDescuentos;
	}

	public Boolean getDevSaldosAFavorAplicativo() {
		return devSaldosAFavorAplicativo;
	}

	public void setDevSaldosAFavorAplicativo(Boolean devSaldosAFavorAplicativo) {
		this.devSaldosAFavorAplicativo = devSaldosAFavorAplicativo;
	}

	public Boolean getIngresoExcluyenteRC() {
		return ingresoExcluyenteRC;
	}

	public void setIngresoExcluyenteRC(Boolean ingresoExcluyenteRC) {
		this.ingresoExcluyenteRC = ingresoExcluyenteRC;
	}

	public Boolean getMuestraUsuLDAP() {
		return muestraUsuLDAP;
	}

	public void setMuestraUsuLDAP(Boolean muestraUsuLDAP) {
		this.muestraUsuLDAP = muestraUsuLDAP;
	}
	
	/**
	 * CU001 Inicio
	 * @return muestraUsuFunCliente
	 */
	public Boolean getMuestraUsuFunCliente() {
		return muestraUsuFunCliente;
	}

	public void setMuestraUsuFunCliente(Boolean muestraUsuFunCliente) {
		this.muestraUsuFunCliente = muestraUsuFunCliente;
	}
	/**
	 * CU001 fin
	 */

	public String getTextAutorizacionFactEspeciales() {
	    return textAutorizacionFactEspeciales;
	}

	public void setTextAutorizacionFactEspeciales(
	    String textAutorizacionFactEspeciales) {
	    this.textAutorizacionFactEspeciales = textAutorizacionFactEspeciales;
	}


    
    /**
     * @return dias de gracia confirming
     */
    public Long getDiasGraciaConfirming() {
        return diasGraciaConfirming;
    }

    /**
     * @param diasGraciaConfirming
     */
    public void setDiasGraciaConfirming(Long diasGraciaConfirming) {
        this.diasGraciaConfirming = diasGraciaConfirming;
    }

    /**
     * @return diasGraciaDescuentoTitulos
     */
    public Long getDiasGraciaDescuentoTitulos() {
        return diasGraciaDescuentoTitulos;
    }

    /**
     * @param diasGraciaDescuentoTitulos
     */
    public void setDiasGraciaDescuentoTitulos(Long diasGraciaDescuentoTitulos) {
        this.diasGraciaDescuentoTitulos = diasGraciaDescuentoTitulos;
    }

    /**
     * @return diasGraciaLineaTriangular
     */
    public Long getDiasGraciaLineaTriangular() {
        return diasGraciaLineaTriangular;
    }

    /**
     * @param diasGraciaLineaTriangular
     */
    public void setDiasGraciaLineaTriangular(Long diasGraciaLineaTriangular) {
        this.diasGraciaLineaTriangular = diasGraciaLineaTriangular;
    }

    /**
     * @return diasGraicADC
     */
    public Long getDiasGraciaADC() {
        return diasGraciaADC;
    }

    /**
     * @param diasGraciaADC
     */
    public void setDiasGraciaADC(Long diasGraciaADC) {
        this.diasGraciaADC = diasGraciaADC;
    }

   
    /**
     * @return the controlTasaUsuraLT
     */
    public Boolean getControlTasaUsuraLT() {
        return controlTasaUsuraLT;
    }

    /**
     * @param controlTasaUsuraLT the controlTasaUsuraLT to set
     */
    public void setControlTasaUsuraLT(Boolean controlTasaUsuraLT) {
        this.controlTasaUsuraLT = controlTasaUsuraLT;
    }
    
      
    /**
     * @return the controlTasaUsuraADC
     */
    public Boolean getControlTasaUsuraADC() {
        return controlTasaUsuraADC;
    }
    
    
    /**
     * @param controlTasaUsuraADC the controlTasaUsuraADC to set
     */
    public void setControlTasaUsuraADC(Boolean controlTasaUsuraADC) {
        this.controlTasaUsuraADC = controlTasaUsuraADC;
    }
      
    
	/**
	 * @return the confirmComputadorSeguro
	 */
	public Boolean getConfirmComputadorSeguro() {
		return confirmComputadorSeguro;
	}

	/**
	 * @param confirmComputadorSeguro the confirmComputadorSeguro to set
	 */
	public void setConfirmComputadorSeguro(Boolean confirmComputadorSeguro) {
		this.confirmComputadorSeguro = confirmComputadorSeguro;
	}

	
		
	/**
	 * @return the solicitaValorFacIVA
	 */
	public Boolean getSolicitaValorFacIVA() {
		return solicitaValorFacIVA;
	}

	/**
	 * @param solicitaValorFacIVA the solicitaValorFacIVA to set
	 */
	public void setSolicitaValorFacIVA(Boolean solicitaValorFacIVA) {
		this.solicitaValorFacIVA = solicitaValorFacIVA;
	}
	
	/**
	 * @return the cantidadProrrogasPermitidas
	 */
	public Long getCantidadProrrogasPermitidas() {
		return cantidadProrrogasPermitidas;
	}
	
	/**
	 * @param cantidadProrrogasPermitidas the cantidadProrrogasPermitidas to set
	 */
	public void setCantidadProrrogasPermitidas(Long cantidadProrrogasPermitidas) {
		this.cantidadProrrogasPermitidas = cantidadProrrogasPermitidas;
	}
	
	/**
	 * @return the permiteProrrogasOblVenc
	 */
	public Boolean getPermiteProrrogasOblVenc() {
		return permiteProrrogasOblVenc;
	}
	
	/**
	 * @param permiteProrrogasOblVenc the permiteProrrogasOblVenc to set
	 */
	public void setPermiteProrrogasOblVenc(Boolean permiteProrrogasOblVenc) {
		this.permiteProrrogasOblVenc = permiteProrrogasOblVenc;
	}

	/**
	 * @return the formaCalcularValorProrroga
	 */
	public EnumFormaCalcularValorProrroga getFormaCalcularValorProrroga() {
		return formaCalcularValorProrroga;
	}
	
		
	/**
	 * @return the permiteAbonosCuentaDeudor
	 */
	public Boolean getPermiteAbonosCuentaDeudor() {
		return permiteAbonosCuentaDeudor;
	}

	/**
	 * @param permiteAbonosCuentaDeudor the permiteAbonosCuentaDeudor to set
	 */
	public void setPermiteAbonosCuentaDeudor(Boolean permiteAbonosCuentaDeudor) {
		this.permiteAbonosCuentaDeudor = permiteAbonosCuentaDeudor;
	}

	/**
	 * @param formaCalcularValorProrroga the formaCalcularValorProrroga to set
	 */
	public void setFormaCalcularValorProrroga(
			EnumFormaCalcularValorProrroga formaCalcularValorProrroga) {
		this.formaCalcularValorProrroga = formaCalcularValorProrroga;
	}
	

	/**
	 * @param diasAdicVigPasswordUsuario the diasAdicVigPasswordUsuario to set
	 */
	public Long getDiasAdicVigPasswordUsuario() {
		return diasAdicVigPasswordUsuario;
	}

	/**
	 * @param diasAdicVigPasswordUsuario the diasAdicVigPasswordUsuario to set
	 */
	public void setDiasAdicVigPasswordUsuario(Long diasAdicVigPasswordUsuario) {
		this.diasAdicVigPasswordUsuario = diasAdicVigPasswordUsuario;
	}
	
	
	/**
	 * @return the cantPaginasAutenticacion
	 */
	public String getCantPaginasAutenticacion() {
		return cantPaginasAutenticacion;
	}
	
	public EnumMedioPagoDesemAsist getMedioPagoDesembAsist() {
		return medioPagoDesembAsist;
	}

	public void setMedioPagoDesembAsist(EnumMedioPagoDesemAsist medioPagoDesembAsist) {
		this.medioPagoDesembAsist = medioPagoDesembAsist;
	}


	/**
	 * @param cantPaginasAutenticacion the cantPaginasAutenticacion to set
	 */
	public void setCantPaginasAutenticacion(String cantPaginasAutenticacion) {
		this.cantPaginasAutenticacion = cantPaginasAutenticacion;
	}
	
	public Boolean getPermiteAnticipoTitulos() {
		return permiteAnticipoTitulos;
	}

	public void setPermiteAnticipoTitulos(Boolean permiteAnticipoTitulos) {
		this.permiteAnticipoTitulos = permiteAnticipoTitulos;
	}

	public String getNumeroTituloAnticipado() {
		return numeroTituloAnticipado;
	}

	public void setNumeroTituloAnticipado(String numeroTituloAnticipado) {
		this.numeroTituloAnticipado = numeroTituloAnticipado;
	}

	public Boolean getMuestraEndeudamiento() {
		return muestraEndeudamiento;
	}

	public void setMuestraEndeudamiento(Boolean muestraEndeudamiento) {
		this.muestraEndeudamiento = muestraEndeudamiento;
	}
	
	public String getMensajeNavegador() {
		return mensajeNavegador;
	}

	public void setMensajeNavegador(String mensajeNavegador) {
		this.mensajeNavegador = mensajeNavegador;
	}

		
	public Boolean getPermiteAgrupacionTitulosDT() {
		return permiteAgrupacionTitulosDT;
	}

	public void setPermiteAgrupacionTitulosDT(Boolean permiteAgrupacionTitulosDT) {
		this.permiteAgrupacionTitulosDT = permiteAgrupacionTitulosDT;
	}

	public Boolean getPermiteAgrupacionFacturasCF() {
		return permiteAgrupacionFacturasCF;
	}

	public void setPermiteAgrupacionFacturasCF(Boolean permiteAgrupacionFacturasCF) {
		this.permiteAgrupacionFacturasCF = permiteAgrupacionFacturasCF;
	}
	

	
	/**
	 * @return the terminosCondCFsinRespVend
	 */
	public String getTerminosCondCFsinRespVend() {
		return terminosCondCFsinRespVend;
	}

	/**
	 * @param terminosCondCFsinRespVend the terminosCondCFsinRespVend to set
	 */
	public void setTerminosCondCFsinRespVend(String terminosCondCFsinRespVend) {
		this.terminosCondCFsinRespVend = terminosCondCFsinRespVend;
	}

	/**
	 * @return the terminosCondCFsinRespComp
	 */
	public String getTerminosCondCFsinRespComp() {
		return terminosCondCFsinRespComp;
	}

	/**
	 * @param terminosCondCFsinRespComp the terminosCondCFsinRespComp to set
	 */
	public void setTerminosCondCFsinRespComp(String terminosCondCFsinRespComp) {
		this.terminosCondCFsinRespComp = terminosCondCFsinRespComp;
	}

	/**
	 * @return the terminosCondCFconRespComp
	 */
	public String getTerminosCondCFconRespComp() {
		return terminosCondCFconRespComp;
	}

	/**
	 * @param terminosCondCFconRespComp the terminosCondCFconRespComp to set
	 */
	public void setTerminosCondCFconRespComp(String terminosCondCFconRespComp) {
		this.terminosCondCFconRespComp = terminosCondCFconRespComp;
	}

	/**
	 * @return the terminosCondLTCargComp
	 */
	public String getTerminosCondLTCargComp() {
		return terminosCondLTCargComp;
	}

	/**
	 * @param terminosCondLTCargComp the terminosCondLTCargComp to set
	 */
	public void setTerminosCondLTCargComp(String terminosCondLTCargComp) {
		this.terminosCondLTCargComp = terminosCondLTCargComp;
	}

	/**
	 * @return the terminosCondLTCargVend
	 */
	public String getTerminosCondLTCargVend() {
		return terminosCondLTCargVend;
	}

	/**
	 * @param terminosCondLTCargVend the terminosCondLTCargVend to set
	 */
	public void setTerminosCondLTCargVend(String terminosCondLTCargVend) {
		this.terminosCondLTCargVend = terminosCondLTCargVend;
	}

	/**
	 * @return the terminosCondLTAutorizacionVend
	 */
	public String getTerminosCondLTAutorizacionVend() {
		return terminosCondLTAutorizacionVend;
	}

	/**
	 * @param terminosCondLTAutorizacionVend the terminosCondLTAutorizacionVend to set
	 */
	public void setTerminosCondLTAutorizacionVend(
			String terminosCondLTAutorizacionVend) {
		this.terminosCondLTAutorizacionVend = terminosCondLTAutorizacionVend;
	}

	/**
	 * @param maxNumeroFacturasCargueLinea the maxNumeroFacturasCargueLinea to set
	 */
	public void setMaxNumeroFacturasCargueLinea(
			Long maxNumeroFacturasCargueLinea) {
		this.maxNumeroFacturasCargueLinea = maxNumeroFacturasCargueLinea;
	}

	/**
	 * @return the maxNumeroFacturasCargueLinea
	 */
	public Long getMaxNumeroFacturasCargueLinea() {
		return maxNumeroFacturasCargueLinea;
	}

	/**
	 * @param consolidaDesembolsosAsistidos the consolidaDesembolsosAsistidos to set
	 */
	public void setConsolidaDesembolsosAsistidos(
			Boolean consolidaDesembolsosAsistidos) {
		this.consolidaDesembolsosAsistidos = consolidaDesembolsosAsistidos;
	}

	/**
	 * @return the consolidaDesembolsosAsistidos
	 */
	public Boolean getConsolidaDesembolsosAsistidos() {
		return consolidaDesembolsosAsistidos;
	}

	/**
	 * 
	 * @param mensajeBienvenida the mensajeBienvenida to set
	 */
	public void setMensajeBienvenida(String mensajeBienvenida) {
		this.mensajeBienvenida = mensajeBienvenida;
	}
	
	/**
	 * 
	 * @return the mensajeBienvenida
	 */
	public String getMensajeBienvenida() {
		return mensajeBienvenida;
	}
	
	/**
	 * 
	 * @param mensajeInformacion the mensajeInformacion to set
	 */
	public String getMensajeInformacion() {
		return mensajeInformacion;
	}

	/**
	 * 
	 * @return the mensajeInformacion
	 */
	public void setMensajeInformacion(String mensajeInformacion) {
		this.mensajeInformacion = mensajeInformacion;
	}

	/**
	 * @return the aceptaTerminosCondiciones
	 */
	public Boolean getAceptaTerminosCondiciones() {
		return aceptaTerminosCondiciones;
	}

	/**
	 * @param aceptaTerminosCondiciones the aceptaTerminosCondiciones to set
	 */
	public void setAceptaTerminosCondiciones(Boolean aceptaTerminosCondiciones) {
		this.aceptaTerminosCondiciones = aceptaTerminosCondiciones;
	}
	
		

	/**
	 * @return the terminosCondDtAutorizacionComp
	 */
	public String getTerminosCondDtAutorizacionComp() {
		return terminosCondDtAutorizacionComp;
	}

	/**
	 * @param terminosCondDtAutorizacionComp the terminosCondDtAutorizacionComp to set
	 */
	public void setTerminosCondDtAutorizacionComp(
			String terminosCondDtAutorizacionComp) {
		this.terminosCondDtAutorizacionComp = terminosCondDtAutorizacionComp;
	}

	/**
	 * @return the formaPresentaPlanLt
	 */
	public EnumFormPresentaPlanCliente getFormaPresentaPlanLt() {
		return formaPresentaPlanLt;
	}

	/**
	 * @param formaPresentaPlanLt the formaPresentaPlanLt to set
	 */
	public void setFormaPresentaPlanLt(
			EnumFormPresentaPlanCliente formaPresentaPlanLt) {
		this.formaPresentaPlanLt = formaPresentaPlanLt;
	}

	/**
	 * @param ctrlPerfilesProductoRolCliente the ctrlPerfilesProductoRolCliente to set
	 */
	public void setCtrlPerfilesProductoRolCliente(
			Boolean ctrlPerfilesProductoRolCliente) {
		this.ctrlPerfilesProductoRolCliente = ctrlPerfilesProductoRolCliente;
	}

	/**
	 * @return the ctrlPerfilesProductoRolCliente
	 */
	public Boolean getCtrlPerfilesProductoRolCliente() {
		return ctrlPerfilesProductoRolCliente;
	}
	
	
	/**
	 * @return the manejaTablaDescuento
	 */
	public Boolean getManejaTablaDescuento() {
		return manejaTablaDescuento;
	}

	/**
	 * @param manejaTablaDescuento the manejaTablaDescuento to set
	 */
	public void setManejaTablaDescuento(Boolean manejaTablaDescuento) {
		this.manejaTablaDescuento = manejaTablaDescuento;
	}
	
	

	/**
	 * Metodo encargado de retornar el valor del atributo tipoFlujoDT
	 * @return El tipoFlujoDT asociado a la clase
	 */
	public EnumTipoFlujoDT getTipoFlujoDT() {
		return tipoFlujoDT;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tipoFlujoDT
	 * @param tipoFlujoDT El nuevo tipoFlujoDT a modificar.
	 */
	public void setTipoFlujoDT(final EnumTipoFlujoDT tipoFlujoDT) {
		this.tipoFlujoDT = tipoFlujoDT;
	}
	
	
	/**
	 * Metodo encargado de retornar el valor del atributo estadoFormNegociacion
	 * @return El estadoFormNegociacion asociado a la clase
	 */
	public EnumEstadoTitulo getEstadoFormNegociacion() {
		return estadoFormNegociacion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estadoFormNegociacion
	 * @param estadoFormNegociacion El nuevo estadoFormNegociacion a modificar.
	 */
	public void setEstadoFormNegociacion(EnumEstadoTitulo estadoFormNegociacion) {
		this.estadoFormNegociacion = estadoFormNegociacion;
	}
	
	/**
	 * Método encargado de retornar el valor del atributo metodoAsignacionOficina
	 * @return El metodoAsignacionOficina asociado a la clase
	 */
	public EnumMetodoAsignacionOficina getMetodoAsignacionOficina() {
		return metodoAsignacionOficina;
	}

	/**
	 * Método encargado de modificar el valor del atributo metodoAsignacionOficina
	 * @param metodoAsignacionOficina El nuevo metodoAsignacionOficina a modificar
	 */
	public void setMetodoAsignacionOficina(
			EnumMetodoAsignacionOficina metodoAsignacionOficina) {
		this.metodoAsignacionOficina = metodoAsignacionOficina;
	}  

	/**
	 * Método encargado de retornar el valor del atributo cargaMontosMaximos
	 * @return El cargaMontosMaximos asociado a la clase
	 */
	public Boolean getCargaMontosMaximos() {
		return cargaMontosMaximos;
	}

	/**
	 * Método encargado de modificar el valor del atributo cargaMontosMaximos
	 * @param cargaMontosMaximos El nuevo cargaMontosMaximos a modificar.
	 */
	public void setCargaMontosMaximos(Boolean cargaMontosMaximos) {
		this.cargaMontosMaximos = cargaMontosMaximos;
	}

	/**
	 * Método encargado de retornar el valor del atributo abonoParcialACuenta
	 * @return El abonoParcialACuenta asociado a la clase
	 */
	public Boolean getAbonoParcialACuenta() {
		return abonoParcialACuenta;
	}

	/**
	 * Método encargado de modificar el valor del atributo abonoParcialACuenta
	 * @param abonoParcialACuenta El nuevo abonoParcialACuenta a modificar.
	 */
	public void setAbonoParcialACuenta(Boolean abonoParcialACuenta) {
		this.abonoParcialACuenta = abonoParcialACuenta;
	}

	/**
	 * Método encargado de retornar el valor del atributo reconoceDevDctoComprador
	 * @return El reconoceDevDctoComprador asociado a la clase
	 */
	public Boolean getReconoceDevDctoComprador() {
		return reconoceDevDctoComprador;
	}

	/**
	 * Método encargado de modificar el valor del atributo reconoceDevDctoComprador
	 * @param reconoceDevDctoComprador El nuevo reconoceDevDctoComprador a modificar.
	 */
	public void setReconoceDevDctoComprador(Boolean reconoceDevDctoComprador) {
		this.reconoceDevDctoComprador = reconoceDevDctoComprador;
	}

	/**
	 * Método encargado de retornar el valor del atributo permiteFinanciacionLT
	 * @return El permiteFinanciacionLT asociado a la clase
	 */
	public Boolean getPermiteFinanciacionLT() {
		return permiteFinanciacionLT;
	}

	/**
	 * Método encargado de modificar el valor del atributo permiteFinanciacionLT
	 * @param permiteFinanciacionLT El nuevo permiteFinanciacionLT a modificar.
	 */
	public void setPermiteFinanciacionLT(Boolean permiteFinanciacionLT) {
		this.permiteFinanciacionLT = permiteFinanciacionLT;
	}

	/**
	 * Método encargado de retornar el valor del atributo primeraProrrogaCancelaObl
	 * @return El primeraProrrogaCancelaObl asociado a la clase
	 */
	public Boolean getPrimeraProrrogaCancelaObl() {
		return primeraProrrogaCancelaObl;
	}

	/**
	 * Método encargado de modificar el valor del atributo primeraProrrogaCancelaObl
	 * @param primeraProrrogaCancelaObl El nuevo primeraProrrogaCancelaObl a modificar.
	 */
	public void setPrimeraProrrogaCancelaObl(Boolean primeraProrrogaCancelaObl) {
		this.primeraProrrogaCancelaObl = primeraProrrogaCancelaObl;
	}

	/**
	 * Método encargado de retornar el valor del atributo terminosCondProrroga
	 * @return El terminosCondProrroga asociado a la clase
	 */
	public String getTerminosCondProrroga() {
		return terminosCondProrroga;
	}

	/**
	 * Método encargado de modificar el valor del atributo terminosCondProrroga
	 * @param terminosCondProrroga El nuevo terminosCondProrroga a modificar.
	 */
	public void setTerminosCondProrroga(String terminosCondProrroga) {
		this.terminosCondProrroga = terminosCondProrroga;
	}

	
	/**
	 * Método encargado de retornar el valor del atributo incluyeFormatoUsuariosEF
	 * @return El incluyeFormatoUsuariosEF asociado a la clase
	 */
	public  Boolean getIncluyeFormatoUsuariosEF() {
		return incluyeFormatoUsuariosEF;
	}

	/**
	 * Método encargado de modificar el valor del atributo incluyeFormatoUsuariosEF
	 * @param incluyeFormatoUsuariosEF El nuevo incluyeFormatoUsuariosEF a modificar.
	 */
	public void setIncluyeFormatoUsuariosEF(final Boolean incluyeFormatoUsuariosEF) {
		this.incluyeFormatoUsuariosEF = incluyeFormatoUsuariosEF;
	}
	
	/**
	 * Método encargado de retornar el valor del atributo autogestionSegCFSinResp
	 * @return El autogestionSegCFSinResp asociado a la clase
	 */
	public  Boolean getAutogestionSegCFSinResp() {
		return autogestionSegCFSinResp;
	}

	/**
	 * Método encargado de modificar el valor del atributo manejaReembolso
	 * @param manejaReembolso El nuevo manejaReembolso a modificar.
	 */
	public void setManejaReembolso(final Boolean manejaReembolso) {
		this.manejaReembolso = manejaReembolso;
	}
	
	/**
	 * Método encargado de retornar el valor del atributo manejaReembolso
	 * @return El manejaReembolso asociado a la clase
	 */
	public  Boolean getManejaReembolso() {
		return manejaReembolso;
	}
	
	/**
	 * Método encargado de modificar el valor del atributo asignaInfoContacto
	 * @param asignaInfoContacto El nuevo asignaInfoContacto a modificar.
	 */
	public void setAsignaInfoContacto(final Boolean asignaInfoContacto) {
		this.asignaInfoContacto = asignaInfoContacto;
	}
	
	/**
	 * Método encargado de retornar el valor del atributo asignaInfoContacto
	 * @return El asignaInfoContacto asociado a la clase
	 */
	public  Boolean getAsignaInfoContacto() {
		return asignaInfoContacto;
	}

	/**
	 * Método encargado de modificar el valor del atributo autogestionSegCFSinResp
	 * @param autogestionSegCFSinResp El nuevo autogestionSegCFSinResp a modificar.
	 */
	public void setAutogestionSegCFSinResp(final Boolean autogestionSegCFSinResp) {
		this.autogestionSegCFSinResp = autogestionSegCFSinResp;
	}

	/**
	 * Método encargado de retornar el valor del atributo manejoCalificacionClientes
	 * @return El manejoCalificacionClientes asociado a la clase
	 */
	public  EnumManejoCalificacion getManejoCalificacionClientes() {
		return manejoCalificacionClientes;
	}

	/**
	 * Método encargado de modificar el valor del atributo manejoCalificacionClientes
	 * @param manejoCalificacionClientes El nuevo manejoCalificacionClientes a modificar.
	 */
	public void setManejoCalificacionClientes(final EnumManejoCalificacion manejoCalificacionClientes) {
		this.manejoCalificacionClientes = manejoCalificacionClientes;
	}

	/**
	 * Método encargado de retornar el valor del atributo responsableAsigClaves
	 * @return El responsableAsigClaves asociado a la clase
	 */
	public  String getResponsableAsigClaves() {
		return responsableAsigClaves;
	}
	

	/**
	 * @return the confirmingNuevo
	 */
	public Boolean getConfirmingNuevo() {
		return confirmingNuevo;
	}

	/**
	 * @param confirmingNuevo the confirmingNuevo to set
	 */
	public void setConfirmingNuevo(Boolean confirmingNuevo) {
		this.confirmingNuevo = confirmingNuevo;
	}

	/**
	 * @return the muestraTerminos
	 */
	public Boolean getMuestraTerminos() {
		return muestraTerminos;
	}

	/**
	 * @param muestraTerminos the muestraTerminos to set
	 */
	public void setMuestraTerminos(Boolean muestraTerminos) {
		this.muestraTerminos = muestraTerminos;
	}

	/**
	 * Método encargado de modificar el valor del atributo responsableAsigClaves
	 * @param responsableAsigClaves El nuevo responsableAsigClaves a modificar.
	 */
	public void setResponsableAsigClaves(final String responsableAsigClaves) {
		this.responsableAsigClaves = responsableAsigClaves;
	}

	/**
	 * Método encargado de retornar el valor del atributo puestoAsigClaves
	 * @return El puestoAsigClaves asociado a la clase
	 */
	public  String getPuestoAsigClaves() {
		return puestoAsigClaves;
	}

	/**
	 * Método encargado de modificar el valor del atributo puestoAsigClaves
	 * @param puestoAsigClaves El nuevo puestoAsigClaves a modificar.
	 */
	public void setPuestoAsigClaves(final String puestoAsigClaves) {
		this.puestoAsigClaves = puestoAsigClaves;
	}

	@Override
	public Object clone(){
        try{
            return super.clone();
        }catch(CloneNotSupportedException ex){
           // logger.error("No se puede Duplicar");
        }
        return null;
    }
	

	/** @generated */
	public Object deepClone() {
	try{
		ParametroEntidad clone = (ParametroEntidad) super.clone();
		if(this.getEntidadFinanciera() != null){
			//clone.setEntidadFinanciera((EntidadFinanciera)this.getEntidadFinanciera().clone());
		}
	
		if(this.getEntidadFinanciera() != null){
			//clone.setEntidadFinanciera((EntidadFinanciera)this.getEntidadFinanciera().deepClone());
		}
		
//		clone.setProductosConProgorra(null);
//		for (PraEnt_Producto kid : this.getProductosConProgorra()) {
//			clone.addProductosConProrroga((PraEnt_Producto)kid.clone());
//		}
		
	
		return clone;
	}catch(CloneNotSupportedException ex){
	   // logger.error("No se puede Duplicar");
	}
	return null;
	}

	/** 
	 * Returns a hash code value for the object.
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/** 
	 * Indicates whether some other object is "equal to" this one.
	 */
	 @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ParametroEntidad other = (ParametroEntidad) obj;
        if (id == null && (other.id != null)) {
                return false;
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
	 
	public Date getP1HoraInicio() {
		return p1HoraInicio;
	}

	public void setP1HoraInicio(Date p1HoraInicio) {
		this.p1HoraInicio = p1HoraInicio;
	}
	
	public Date getP1HoraFinal() {
		return p1HoraFinal;
	}

	public void setP1HoraFinal(Date p1HoraFinal) {
		this.p1HoraFinal = p1HoraFinal;
	}
	
	public Boolean getP1DiaHabil() {
		return p1DiaHabil;
	}

	public void setP1DiaHabil(Boolean p1DiaHabil) {
		this.p1DiaHabil = p1DiaHabil;
	}
	
	public Date getP2HoraInicio() {
		return p2HoraInicio;
	}
	
	public void setP2HoraInicio(Date p2HoraInicio) {
		this.p2HoraInicio = p2HoraInicio;
	}

	public Date getP2HoraFinal() {
		return p2HoraFinal;
	}

	public void setP2HoraFinal(Date p2HoraFinal) {
		this.p2HoraFinal = p2HoraFinal;
	}
	
	public Boolean getP2DiaHabil() {
		return p2DiaHabil;
	}

	public void setP2DiaHabil(Boolean p2DiaHabil) {
		this.p2DiaHabil = p2DiaHabil;
	}
	
	public Date getP3HoraInicio() {
		return p3HoraInicio;
	}

	public void setP3HoraInicio(Date p3HoraInicio) {
		this.p3HoraInicio = p3HoraInicio;
	}
	
	public Date getP3HoraFinal() {
		return p3HoraFinal;
	}

	public void setP3HoraFinal(Date p3HoraFinal) {
		this.p3HoraFinal = p3HoraFinal;
	}
	
	public Boolean getP3DiaHabil() {
		return p3DiaHabil;
	}

	public void setP3DiaHabil(Boolean p3DiaHabil) {
		this.p3DiaHabil = p3DiaHabil;
	}

	public Boolean getCausacionMoraDiferenciada() {
		return causacionMoraDiferenciada;
	}

	public void setCausacionMoraDiferenciada(Boolean causacionMoraDiferenciada) {
		this.causacionMoraDiferenciada = causacionMoraDiferenciada;
	}

	public Long getDiasBaseDescuento() {
		return diasBaseDescuento;
	}

	public void setDiasBaseDescuento(Long diasBaseDescuento) {
		this.diasBaseDescuento = diasBaseDescuento;
	}

	public Boolean getValidaFacturaElectronica() {
		return validaFacturaElectronica;
	}

	public void setValidaFacturaElectronica(Boolean validaFacturaElectronica) {
		this.validaFacturaElectronica = validaFacturaElectronica;
	}
	
	/**
	 * @return the cantRegCons
	 */
	public Long getCantRegCons() {
		return cantRegCons;
	}

	/**
	 * @param cantRegCons the cantRegCons to set
	 */
	public void setCantRegCons(Long cantRegCons) {
		this.cantRegCons = cantRegCons;
	}

	public Boolean getMuestraCupoCompradores() {
		return muestraCupoCompradores;
	}

	public void setMuestraCupoCompradores(Boolean muestraCupoCompradores) {
		this.muestraCupoCompradores = muestraCupoCompradores;
	}

	/**
	 * @return the permiteDebitosAutomaticos
	 */
	public Boolean getPermiteDebitosAutomaticos() {
		return permiteDebitosAutomaticos;
	}

	/**
	 * @param permiteDebitosAutomaticos the permiteDebitosAutomaticos to set
	 */
	public void setPermiteDebitosAutomaticos(Boolean permiteDebitosAutomaticos) {
		this.permiteDebitosAutomaticos = permiteDebitosAutomaticos;
	}

	/**
	 * @return the paraFacturasNoNegociadas
	 */
	public Boolean getPagaFacturasNoNegociadas() {
		return pagaFacturasNoNegociadas;
	}

	/**
	 * @param paraFacturasNoNegociadas the paraFacturasNoNegociadas to set
	 */
	public void setPagaFacturasNoNegociadas(Boolean pagaFacturasNoNegociadas) {
		this.pagaFacturasNoNegociadas = pagaFacturasNoNegociadas;
	}

	/**
	 * @return the manejaCentavosDesembolso
	 */
	public Boolean getManejaCentavosDesembolso() {
		return manejaCentavosDesembolso;
	}

	/**
	 * @param manejaCentavosDesembolso the manejaCentavosDesembolso to set
	 */
	public void setManejaCentavosDesembolso(Boolean manejaCentavosDesembolso) {
		this.manejaCentavosDesembolso = manejaCentavosDesembolso;
	}

	public EnumConsecutivoObligaciones getConsecutivoObligaciones() {
		return consecutivoObligaciones;
	}

	public void setConsecutivoObligaciones(
			EnumConsecutivoObligaciones consecutivoObligaciones) {
		this.consecutivoObligaciones = consecutivoObligaciones;
	}

	public Boolean getSolicitaActaAprobacionCupo() {
		return solicitaActaAprobacionCupo;
	}

	public void setSolicitaActaAprobacionCupo(Boolean solicitaActaAprobacionCupo) {
		this.solicitaActaAprobacionCupo = solicitaActaAprobacionCupo;
	}

	public Boolean getAccFactElect() {
		return accFactElect;
	}

	public void setAccFactElect(Boolean accFactElect) {
		this.accFactElect = accFactElect;
	}

	public Boolean getValVarNetFactElect() {
		return valVarNetFactElect;
	}

	public void setValVarNetFactElect(Boolean valVarNetFactElect) {
		this.valVarNetFactElect = valVarNetFactElect;
	}

	public String getTerminosCondCFSinRespCompAut() {
		return terminosCondCFSinRespCompAut;
	}

	public void setTerminosCondCFSinRespCompAut(String terminosCondCFSinRespCompAut) {
		this.terminosCondCFSinRespCompAut = terminosCondCFSinRespCompAut;
	}
	
	public EnumMomentoCobrarProrroga getMomentoCobrarProrroga() {
		return momentoCobrarProrroga;
	}

	public void setMomentoCobrarProrroga(
			EnumMomentoCobrarProrroga momentoCobrarProrroga) {
		this.momentoCobrarProrroga = momentoCobrarProrroga;
	}

	public Long getDiasParaSolicitarProrrogas() {
		return diasParaSolicitarProrrogas;
	}

	public void setDiasParaSolicitarProrrogas(Long diasParaSolicitarProrrogas) {
		this.diasParaSolicitarProrrogas = diasParaSolicitarProrrogas;
	}

	public Date getHoraMaximaGeneracion() {
		return horaMaximaGeneracion;
	}

	public void setHoraMaximaGeneracion(Date horaMaximaGeneracion) {
		this.horaMaximaGeneracion = horaMaximaGeneracion;
	}

	public Date getHoraMaxSolicitudProrrogas() {
		return horaMaxSolicitudProrrogas;
	}

	public void setHoraMaxSolicitudProrrogas(Date horaMaxSolicitudProrrogas) {
		this.horaMaxSolicitudProrrogas = horaMaxSolicitudProrrogas;
	}

	public Boolean getPermiteTasaProrroga() {
		return permiteTasaProrroga;
	}

	public void setPermiteTasaProrroga(Boolean permiteTasaProrroga) {
		this.permiteTasaProrroga = permiteTasaProrroga;
	}

	public Boolean getFechaProrrogaAutomatica() {
		return fechaProrrogaAutomatica;
	}

	public void setFechaProrrogaAutomatica(Boolean fechaProrrogaAutomatica) {
		this.fechaProrrogaAutomatica = fechaProrrogaAutomatica;
	}

//	public List<PraEnt_Producto> getProductosConProgorra() {
//		if (this.productosConProgorra == null) {
//			this.productosConProgorra = new java.util.ArrayList<PraEnt_Producto>();
//		}
//		return productosConProgorra;
//	}
//
//	public void setProductosConProgorra(List<PraEnt_Producto> productosConProgorra) {
//		this.productosConProgorra = productosConProgorra;
//	}
//
//	public void addProductosConProrroga(PraEnt_Producto producto) {
//		if (producto == null) return;
//		getProductosConProgorra().add(producto);
//		producto.setParametroEntidad(this);
//	
//	}
//
//	public void removeProductosConProrroga(PraEnt_Producto producto) {
//		if (producto == null) return;
//		getProductosConProgorra().remove(producto);
//		producto.setParametroEntidad(null);
//	}

//	public void removeAllProductosConProrroga() {
//		List<PraEnt_Producto> remove = new java.util.ArrayList<PraEnt_Producto>();
//		remove.addAll(getProductosConProgorra());
//		for (PraEnt_Producto element : remove) {
//			removeProductosConProrroga(element);
//		}	
//	}
	
	public Boolean getManejaNotasCredito() {
		return manejaNotasCredito;
	}

	public void setManejaNotasCredito(Boolean manejaNotasCredito) {
		this.manejaNotasCredito = manejaNotasCredito;
	}

	public Boolean getPermiteDesembolsoMora() {
		return permiteDesembolsoMora;
	}

	public void setPermiteDesembolsoMora(Boolean permiteDesembolsoMora) {
		this.permiteDesembolsoMora = permiteDesembolsoMora;
	}

	public Boolean getPermiteUsuariosSegFunc() {
		return permiteUsuariosSegFunc;
	}

	public void setPermiteUsuariosSegFunc(Boolean permiteUsuariosSegFunc) {
		this.permiteUsuariosSegFunc = permiteUsuariosSegFunc;
	}

	public Boolean getManejaCalendariosCF() {
		return manejaCalendariosCF;
	}

	public void setManejaCalendariosCF(Boolean manejaCalendariosCF) {
		this.manejaCalendariosCF = manejaCalendariosCF;
	}

	public Boolean getMuestraTokenIngreso() {
		return muestraTokenIngreso;
	}

	public void setMuestraTokenIngreso(Boolean muestraTokenIngreso) {
		this.muestraTokenIngreso = muestraTokenIngreso;
	}

	public Long getTiempoLimProcesAutoriFactCF() {
		return tiempoLimProcesAutoriFactCF;
	}

	public void setTiempoLimProcesAutoriFactCF(Long tiempoLimProcesAutoriFactCF) {
		this.tiempoLimProcesAutoriFactCF = tiempoLimProcesAutoriFactCF;
	}

	public Boolean getPagaMoraConDesembolso() {
		return pagaMoraConDesembolso;
	}

	public void setPagaMoraConDesembolso(Boolean pagaMoraConDesembolso) {
		this.pagaMoraConDesembolso = pagaMoraConDesembolso;
	}
	
	/**
	 * @return the abonosCuentaSinReferencia
	 */
	public Boolean getAbonosCuentaSinReferencia() {
		return abonosCuentaSinReferencia;
	}

	/**
	 * @param abonosCuentaSinReferencia the abonosCuentaSinReferencia to set
	 */
	public void setAbonosCuentaSinReferencia(Boolean abonosCuentaSinReferencia) {
		this.abonosCuentaSinReferencia = abonosCuentaSinReferencia;
	}

	public Long getTiempoLimProcesoConPagos() {
		return tiempoLimProcesoConPagos;
	}

	public void setTiempoLimProcesoConPagos(Long tiempoLimProcesoConPagos) {
		this.tiempoLimProcesoConPagos = tiempoLimProcesoConPagos;
	}

	public Long getMaxNumeroPagosEnLinea() {
		return maxNumeroPagosEnLinea;
	}

	public void setMaxNumeroPagosEnLinea(Long maxNumeroPagosEnLinea) {
		this.maxNumeroPagosEnLinea = maxNumeroPagosEnLinea;
	}
	
	/**
	 * @return the cobraGMFDescuentoCero
	 */
	public Boolean getCobraGMFDescuentoCero() {
		return cobraGMFDescuentoCero;
	}
	
	/**
	 * @param cobraGMFDescuentoCero the cobraGMFDescuentoCero to set
	 */
	public void setCobraGMFDescuentoCero(Boolean cobraGMFDescuentoCero) {
		this.cobraGMFDescuentoCero = cobraGMFDescuentoCero;
	}

	public EnumModalidadADC getModalidadADC() {
		return modalidadADC;
	}

	public void setModalidadADC(EnumModalidadADC modalidadADC) {
		this.modalidadADC = modalidadADC;
	}

	public Boolean getCupoDTPorcNegociacion() {
		return cupoDTPorcNegociacion;
	}

	public void setCupoDTPorcNegociacion(Boolean cupoDTPorcNegociacion) {
		this.cupoDTPorcNegociacion = cupoDTPorcNegociacion;
	}

	public String getTerminosCondFactElectronica() {
		return terminosCondFactElectronica;
	}

	public void setTerminosCondFactElectronica(String terminosCondFactElectronica) {
		this.terminosCondFactElectronica = terminosCondFactElectronica;
	}

	/**
	 * @return the pseTextoServicioCliente
	 */
	public String getPseTextoServicioCliente() {
		return pseTextoServicioCliente;
	}

	/**
	 * @param pseTextoServicioCliente the pseTextoServicioCliente to set
	 */
	public void setPseTextoServicioCliente(String pseTextoServicioCliente) {
		this.pseTextoServicioCliente = pseTextoServicioCliente;
	}
	
	/**
	 * @return the cufeObligatorio
	 */
	public Boolean getCufeObligatorio() {
		return cufeObligatorio;
	}

	/**
	 * @param cufeObligatorio the cufeObligatorio to set
	 */
	public void setCufeObligatorio(Boolean cufeObligatorio) {
		this.cufeObligatorio = cufeObligatorio;
	}

	public Boolean getManejaTasaDiferencial() {
		return manejaTasaDiferencial;
	}

	public void setManejaTasaDiferencial(Boolean manejaTasaDiferencial) {
		this.manejaTasaDiferencial = manejaTasaDiferencial;
	}

	public Boolean getRadianValidaEventos() {
		return radianValidaEventos;
	}

	public void setRadianValidaEventos(Boolean radianValidaEventos) {
		this.radianValidaEventos = radianValidaEventos;
	}

	public Boolean getRadianPrimeroEndosa() {
		return radianPrimeroEndosa;
	}

	public void setRadianPrimeroEndosa(Boolean radianPrimeroEndosa) {
		this.radianPrimeroEndosa = radianPrimeroEndosa;
	}

	public String getCIIU() {
		return CIIU;
	}

	public void setCIIU(String cIIU) {
		CIIU = cIIU;
	}

	public Boolean getCuatroxmilpse() {
		return cuatroxmilpse;
	}

	public void setCuatroxmilpse(Boolean cuatroxmilpse) {
		this.cuatroxmilpse = cuatroxmilpse;
	}

	public Date getPse_fecha_ultima_lista_bancos() {
		return pse_fecha_ultima_lista_bancos;
	}

	public void setPse_fecha_ultima_lista_bancos(Date pse_fecha_ultima_lista_bancos) {
		this.pse_fecha_ultima_lista_bancos = pse_fecha_ultima_lista_bancos;
	}

	public String getPse_mensaje_tipo_persona() {
		return pse_mensaje_tipo_persona;
	}

	public void setPse_mensaje_tipo_persona(String pse_mensaje_tipo_persona) {
		this.pse_mensaje_tipo_persona = pse_mensaje_tipo_persona;
	}
	
	
}

