package com.bootfactory.microinformes.application.modelDTO;

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

public class ParametroEntidadDTO {

	private Long tiempoLimProcesoConPagos;

	private Long maxNumeroPagosEnLinea;

	private Date p1HoraInicio;

	private Date p1HoraFinal;

	private Boolean p1DiaHabil;

	private Date p2HoraInicio;

	private Date p2HoraFinal;

	private Boolean p2DiaHabil;

	private Date p3HoraInicio;

	private Date p3HoraFinal;

	private Boolean p3DiaHabil;

	private Long diasNotificacionVencimiento;

	private String algoritmo;

	private Long id;

	private BigDecimal valorLimiteMicroCredito;

	private Long version;

	private Long numeroMesesCalendario;

	private String politicasSeguridad;

	private String nombreSkin;

	private String nombreLogo;

	private String politicasPrivacidad;

	private String configuracionSeguridad;

	private String infoContacto;

	private String infoDireccion;

	private Boolean controlDesembolsoAsistido;

	private Boolean servicioListaBloqueo;

	private Boolean adminTasasManual;

	private Long numeroDiasAnticVencOblig;

	private Long numeroDiasVencReportar;

	private String diasNotificacionVencimientoObl;

	private EnumModoVDM informacionVDM;

	private Double paramRevPlanLT;

	private Long plaMaxPlanes;

	private Boolean codigoBarrasVariable;

	private Boolean consolidaDesembolsos;

	private String nombreCartaNotificacion;

	private String firmaCartaNotificacion;

	private String nombreCargoCartaNotificacion;

	private String cargoCartaNotificacion;

	private Boolean validaNumerosCuenta;

	private String algoritmoValidacionCuentas;

	private Boolean validaServicioLeaIndirecto;

	private Boolean validaServicioDesembolso;

	private EnumEsquemaSeguridad esquemaSeguridad;

	private Long numeroDiasDesembolso;

	private Boolean validaProvisionesCastigar;

	private EnumAutorizaDTSinResponsabilidad autorizaDTSinResponsabilidad;

	private Boolean requiereOfDesembolsoCheque;

	private Boolean protegeReferencia;

	private Boolean administraCuentasContables;

	private EnumNumeracionObligacion numeracionObligaciones;

	private EnumNumeracionCondicion numeracionCondiciones;

	private String algoritmoReferencia;

	private Long diasNotVigPasswordUsuario;

	private Boolean cobraImpuesto4x1000;

	private Boolean cobraImpuestoLT;

	private Boolean utilizaSerClientesOccidente;

	private Boolean utilizaSerProductosOccidente;

	private Boolean consolidaNotificacionesCliente;

	private EnumAsigCodBarras asignacionCodBarrasFac;

	private Long reintentosFinalizarPSE;

	private Boolean utilizaDetalleBodega;

	private Long tiempoInvocacionCambioEstado;

	private Long tiempoInvocacionPendiente;

	private Long tiempoMaxConfirmacionPSE;

	private EnumTipoEntregaClaves entregaClavesEF;

	private EnumTipoEntregaClaves entregaClavesCliente;

	private EnumEsquemaConexionLDAP esquemaConexionLDAP;

	private Boolean pagaMoraSaldoFavor;

	private Boolean modoFTPPassive;

	private String separadorRtaWSAutenticacion;

	private String appWSAutorizacion;

	private EnumReversarConstitucion cuandoReversarConstitucion;

	private String separadorRtaWSAutorizacion;

	private EnumTipoCausacionMora causacionInteresMora;

	private Boolean validaDesembolsoDistribuido;

	private Date fechaProceso;

	private EnumAccionCastigo accionCastigo;

	private Boolean utilizaSerValidarClientes;

	private Boolean ajustaVolanteUnidad;

	private Boolean digitalizaTitulos;

	private Boolean consolidaDesembolsosAnalizar;

	private String informativoPagoPSE;

	private String contactoInfoPSE;

	private Boolean liquidaTotalidadSaldoFavor;

	private String autorizarNegociosLT;

	private String autorizarNegociosCF;

	private String autorizarNegociosADC;

	private String autorizarNegociosDT;

	private Long maxNumeroFacturasCargueLinea;

	private Boolean cobraGMFADC = false;

	private Boolean cobraGMFASaldoFavor = false;

	private Boolean cobraGMFDesembolso = false;

	private Boolean muestraFechaPagoFuentePago = false;

	private Boolean permitePagoObligacionPaga = false;

	private Boolean manejaFechaPago = false;

	private Boolean abonosAObligacionEspecifica = false;

	private String llaveEncripcionScratch;

	private Boolean permitePagoReferenciaPago = false;

	private Boolean permitePagoObligaciones = false;

	private Boolean muestraNumFacturaVolantePago = false;

	private EnumDiaHabilitaPSE diaHabilitaPSE;

	private String horaInicioPSE;

	private String horaFinalPSE;

	private String mensajeDiaHabilitaPSE;

	private Boolean permiteCaracteresEspeciales = false;

	private String urlExternaCierreSesionEF;

	private String urlExternaCierreSesionCliente;

	private Boolean obligaCorreosMismoDominio = false;

	private Boolean muestraPlazoMaximoProrroga = false;

	private Boolean controlDualDesembolso = false;

	private EnumTipoAmortizacionDescuentos amortizacionDescuentos;

	private Boolean devSaldosAFavorAplicativo = true;

	private Long diasGraciaConfirming = 0L;

	private Long diasGraciaDescuentoTitulos = 0L;

	private Long diasGraciaLineaTriangular = 0L;

	private Long diasGraciaADC = 0L;

	private Boolean controlTasaUsuraLT = false;

	private Boolean controlTasaUsuraADC = false;

	private Boolean ingresoExcluyenteRC = false;

	private Boolean muestraUsuLDAP = true;

	private Boolean muestraUsuFunCliente = true;

	private String textAutorizacionFactEspeciales;

	private Boolean solicitaValorFacIVA = Boolean.FALSE;

	private Long cantidadProrrogasPermitidas = 1L;

	private Boolean permiteProrrogasOblVenc = Boolean.FALSE;

	private EnumFormaCalcularValorProrroga formaCalcularValorProrroga;

	private Boolean permiteAbonosCuentaDeudor = false;

	private Long diasAdicVigPasswordUsuario = 0L;
	private String cantPaginasAutenticacion;

	private EnumMedioPagoDesemAsist medioPagoDesembAsist;

	private Boolean permiteAnticipoTitulos = false;

	private String numeroTituloAnticipado;

	private Boolean muestraEndeudamiento = false;

	private String mensajeNavegador;

	private Boolean permiteAgrupacionTitulosDT;

	private Boolean permiteAgrupacionFacturasCF;

	private String terminosCondCFsinRespVend;

	private String terminosCondCFsinRespComp;

	private String terminosCondCFconRespComp;

	private String terminosCondLTCargComp;

	private String terminosCondLTCargVend;

	private String terminosCondLTAutorizacionVend;

	private Boolean consolidaDesembolsosAsistidos = false;

	private String mensajeBienvenida;

	private String mensajeInformacion;

	private Boolean aceptaTerminosCondiciones = false;

	private EnumFormPresentaPlanCliente formaPresentaPlanLt;

	private Boolean ctrlPerfilesProductoRolCliente = false;

	private Boolean manejaTablaDescuento = false;

	private String terminosCondDtAutorizacionComp;

	private EnumTipoFlujoDT tipoFlujoDT;

	private EnumEstadoTitulo estadoFormNegociacion;

	private EnumMetodoAsignacionOficina metodoAsignacionOficina;

	private Boolean cargaMontosMaximos = Boolean.FALSE;

	private Boolean solicitaActaAprobacionCupo = Boolean.FALSE;

	private Boolean abonoParcialACuenta = false;

	private Boolean reconoceDevDctoComprador;

	private Boolean permiteFinanciacionLT;

	private Boolean primeraProrrogaCancelaObl;

	private String terminosCondProrroga;

	private Boolean incluyeFormatoUsuariosEF = Boolean.FALSE;

	private Boolean autogestionSegCFSinResp = Boolean.FALSE;

	private Boolean manejaReembolso = Boolean.FALSE;

	private Boolean confirmingNuevo = Boolean.FALSE;

	private Boolean muestraTerminos = Boolean.FALSE;

	private Boolean asignaInfoContacto = Boolean.FALSE;

	private String responsableAsigClaves;

	private String puestoAsigClaves;

	private EnumManejoCalificacion manejoCalificacionClientes;

	private Boolean causacionMoraDiferenciada;

	private Long diasBaseDescuento = 360L;

	private Boolean validaFacturaElectronica;

	private Boolean accFactElect;

	private Boolean valVarNetFactElect;
	private Long cantRegCons;

	private Boolean muestraCupoCompradores;

	private Boolean permiteDebitosAutomaticos;
	private Boolean pagaFacturasNoNegociadas;

	private Boolean manejaCentavosDesembolso = false;

	private EnumConsecutivoObligaciones consecutivoObligaciones;

	private String terminosCondCFSinRespCompAut;

	private EnumMomentoCobrarProrroga momentoCobrarProrroga;

	private Long diasParaSolicitarProrrogas = 0L;

	private Date horaMaxSolicitudProrrogas;

	private Boolean permiteTasaProrroga = false;
	private Boolean fechaProrrogaAutomatica = false;

//		  // Productos con Prórroga
//			@Column(name = "PRODUCTOSPRORROGA")
//			@OneToMany(fetch = FetchType.LAZY, mappedBy = "parametroEntidad", cascade = CascadeType.REFRESH)
//			private List<PraEnt_Producto> productosConProgorra;
//			
//			

	private Date horaMaximaGeneracion;

	private Boolean manejaNotasCredito = Boolean.FALSE;

	private Boolean permiteDesembolsoMora = Boolean.FALSE;

	private Boolean permiteUsuariosSegFunc = false;

	private Boolean manejaCalendariosCF = false;

	private Boolean muestraTokenIngreso = false;

	private Long tiempoLimProcesAutoriFactCF;

	private Boolean pagaMoraConDesembolso;
	private Boolean abonosCuentaSinReferencia = false;

	private Boolean cobraGMFDescuentoCero = false;

	private EnumModalidadADC modalidadADC;

	private Boolean cupoDTPorcNegociacion = true;

	private String terminosCondFactElectronica;

	private String pseTextoServicioCliente;

	private Boolean cufeObligatorio = false;

	private Boolean manejaTasaDiferencial = false;

	private Boolean radianValidaEventos = false;

	private Boolean radianPrimeroEndosa = false;

	private String CIIU;
	private Boolean cuatroxmilpse;

	private Date pse_fecha_ultima_lista_bancos;

	private String pse_mensaje_tipo_persona;

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

	public Long getDiasNotificacionVencimiento() {
		return diasNotificacionVencimiento;
	}

	public void setDiasNotificacionVencimiento(Long diasNotificacionVencimiento) {
		this.diasNotificacionVencimiento = diasNotificacionVencimiento;
	}

	public String getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorLimiteMicroCredito() {
		return valorLimiteMicroCredito;
	}

	public void setValorLimiteMicroCredito(BigDecimal valorLimiteMicroCredito) {
		this.valorLimiteMicroCredito = valorLimiteMicroCredito;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getNumeroMesesCalendario() {
		return numeroMesesCalendario;
	}

	public void setNumeroMesesCalendario(Long numeroMesesCalendario) {
		this.numeroMesesCalendario = numeroMesesCalendario;
	}

	public String getPoliticasSeguridad() {
		return politicasSeguridad;
	}

	public void setPoliticasSeguridad(String politicasSeguridad) {
		this.politicasSeguridad = politicasSeguridad;
	}

	public String getNombreSkin() {
		return nombreSkin;
	}

	public void setNombreSkin(String nombreSkin) {
		this.nombreSkin = nombreSkin;
	}

	public String getNombreLogo() {
		return nombreLogo;
	}

	public void setNombreLogo(String nombreLogo) {
		this.nombreLogo = nombreLogo;
	}

	public String getPoliticasPrivacidad() {
		return politicasPrivacidad;
	}

	public void setPoliticasPrivacidad(String politicasPrivacidad) {
		this.politicasPrivacidad = politicasPrivacidad;
	}

	public String getConfiguracionSeguridad() {
		return configuracionSeguridad;
	}

	public void setConfiguracionSeguridad(String configuracionSeguridad) {
		this.configuracionSeguridad = configuracionSeguridad;
	}

	public String getInfoContacto() {
		return infoContacto;
	}

	public void setInfoContacto(String infoContacto) {
		this.infoContacto = infoContacto;
	}

	public String getInfoDireccion() {
		return infoDireccion;
	}

	public void setInfoDireccion(String infoDireccion) {
		this.infoDireccion = infoDireccion;
	}

	public Boolean getControlDesembolsoAsistido() {
		return controlDesembolsoAsistido;
	}

	public void setControlDesembolsoAsistido(Boolean controlDesembolsoAsistido) {
		this.controlDesembolsoAsistido = controlDesembolsoAsistido;
	}

	public Boolean getServicioListaBloqueo() {
		return servicioListaBloqueo;
	}

	public void setServicioListaBloqueo(Boolean servicioListaBloqueo) {
		this.servicioListaBloqueo = servicioListaBloqueo;
	}

	public Boolean getAdminTasasManual() {
		return adminTasasManual;
	}

	public void setAdminTasasManual(Boolean adminTasasManual) {
		this.adminTasasManual = adminTasasManual;
	}

	public Long getNumeroDiasAnticVencOblig() {
		return numeroDiasAnticVencOblig;
	}

	public void setNumeroDiasAnticVencOblig(Long numeroDiasAnticVencOblig) {
		this.numeroDiasAnticVencOblig = numeroDiasAnticVencOblig;
	}

	public Long getNumeroDiasVencReportar() {
		return numeroDiasVencReportar;
	}

	public void setNumeroDiasVencReportar(Long numeroDiasVencReportar) {
		this.numeroDiasVencReportar = numeroDiasVencReportar;
	}

	public String getDiasNotificacionVencimientoObl() {
		return diasNotificacionVencimientoObl;
	}

	public void setDiasNotificacionVencimientoObl(String diasNotificacionVencimientoObl) {
		this.diasNotificacionVencimientoObl = diasNotificacionVencimientoObl;
	}

	public EnumModoVDM getInformacionVDM() {
		return informacionVDM;
	}

	public void setInformacionVDM(EnumModoVDM informacionVDM) {
		this.informacionVDM = informacionVDM;
	}

	public Double getParamRevPlanLT() {
		return paramRevPlanLT;
	}

	public void setParamRevPlanLT(Double paramRevPlanLT) {
		this.paramRevPlanLT = paramRevPlanLT;
	}

	public Long getPlaMaxPlanes() {
		return plaMaxPlanes;
	}

	public void setPlaMaxPlanes(Long plaMaxPlanes) {
		this.plaMaxPlanes = plaMaxPlanes;
	}

	public Boolean getCodigoBarrasVariable() {
		return codigoBarrasVariable;
	}

	public void setCodigoBarrasVariable(Boolean codigoBarrasVariable) {
		this.codigoBarrasVariable = codigoBarrasVariable;
	}

	public Boolean getConsolidaDesembolsos() {
		return consolidaDesembolsos;
	}

	public void setConsolidaDesembolsos(Boolean consolidaDesembolsos) {
		this.consolidaDesembolsos = consolidaDesembolsos;
	}

	public String getNombreCartaNotificacion() {
		return nombreCartaNotificacion;
	}

	public void setNombreCartaNotificacion(String nombreCartaNotificacion) {
		this.nombreCartaNotificacion = nombreCartaNotificacion;
	}

	public String getFirmaCartaNotificacion() {
		return firmaCartaNotificacion;
	}

	public void setFirmaCartaNotificacion(String firmaCartaNotificacion) {
		this.firmaCartaNotificacion = firmaCartaNotificacion;
	}

	public String getNombreCargoCartaNotificacion() {
		return nombreCargoCartaNotificacion;
	}

	public void setNombreCargoCartaNotificacion(String nombreCargoCartaNotificacion) {
		this.nombreCargoCartaNotificacion = nombreCargoCartaNotificacion;
	}

	public String getCargoCartaNotificacion() {
		return cargoCartaNotificacion;
	}

	public void setCargoCartaNotificacion(String cargoCartaNotificacion) {
		this.cargoCartaNotificacion = cargoCartaNotificacion;
	}

	public Boolean getValidaNumerosCuenta() {
		return validaNumerosCuenta;
	}

	public void setValidaNumerosCuenta(Boolean validaNumerosCuenta) {
		this.validaNumerosCuenta = validaNumerosCuenta;
	}

	public String getAlgoritmoValidacionCuentas() {
		return algoritmoValidacionCuentas;
	}

	public void setAlgoritmoValidacionCuentas(String algoritmoValidacionCuentas) {
		this.algoritmoValidacionCuentas = algoritmoValidacionCuentas;
	}

	public Boolean getValidaServicioLeaIndirecto() {
		return validaServicioLeaIndirecto;
	}

	public void setValidaServicioLeaIndirecto(Boolean validaServicioLeaIndirecto) {
		this.validaServicioLeaIndirecto = validaServicioLeaIndirecto;
	}

	public Boolean getValidaServicioDesembolso() {
		return validaServicioDesembolso;
	}

	public void setValidaServicioDesembolso(Boolean validaServicioDesembolso) {
		this.validaServicioDesembolso = validaServicioDesembolso;
	}

	public EnumEsquemaSeguridad getEsquemaSeguridad() {
		return esquemaSeguridad;
	}

	public void setEsquemaSeguridad(EnumEsquemaSeguridad esquemaSeguridad) {
		this.esquemaSeguridad = esquemaSeguridad;
	}

	public Long getNumeroDiasDesembolso() {
		return numeroDiasDesembolso;
	}

	public void setNumeroDiasDesembolso(Long numeroDiasDesembolso) {
		this.numeroDiasDesembolso = numeroDiasDesembolso;
	}

	public Boolean getValidaProvisionesCastigar() {
		return validaProvisionesCastigar;
	}

	public void setValidaProvisionesCastigar(Boolean validaProvisionesCastigar) {
		this.validaProvisionesCastigar = validaProvisionesCastigar;
	}

	public EnumAutorizaDTSinResponsabilidad getAutorizaDTSinResponsabilidad() {
		return autorizaDTSinResponsabilidad;
	}

	public void setAutorizaDTSinResponsabilidad(EnumAutorizaDTSinResponsabilidad autorizaDTSinResponsabilidad) {
		this.autorizaDTSinResponsabilidad = autorizaDTSinResponsabilidad;
	}

	public Boolean getRequiereOfDesembolsoCheque() {
		return requiereOfDesembolsoCheque;
	}

	public void setRequiereOfDesembolsoCheque(Boolean requiereOfDesembolsoCheque) {
		this.requiereOfDesembolsoCheque = requiereOfDesembolsoCheque;
	}

	public Boolean getProtegeReferencia() {
		return protegeReferencia;
	}

	public void setProtegeReferencia(Boolean protegeReferencia) {
		this.protegeReferencia = protegeReferencia;
	}

	public Boolean getAdministraCuentasContables() {
		return administraCuentasContables;
	}

	public void setAdministraCuentasContables(Boolean administraCuentasContables) {
		this.administraCuentasContables = administraCuentasContables;
	}

	public EnumNumeracionObligacion getNumeracionObligaciones() {
		return numeracionObligaciones;
	}

	public void setNumeracionObligaciones(EnumNumeracionObligacion numeracionObligaciones) {
		this.numeracionObligaciones = numeracionObligaciones;
	}

	public EnumNumeracionCondicion getNumeracionCondiciones() {
		return numeracionCondiciones;
	}

	public void setNumeracionCondiciones(EnumNumeracionCondicion numeracionCondiciones) {
		this.numeracionCondiciones = numeracionCondiciones;
	}

	public String getAlgoritmoReferencia() {
		return algoritmoReferencia;
	}

	public void setAlgoritmoReferencia(String algoritmoReferencia) {
		this.algoritmoReferencia = algoritmoReferencia;
	}

	public Long getDiasNotVigPasswordUsuario() {
		return diasNotVigPasswordUsuario;
	}

	public void setDiasNotVigPasswordUsuario(Long diasNotVigPasswordUsuario) {
		this.diasNotVigPasswordUsuario = diasNotVigPasswordUsuario;
	}

	public Boolean getCobraImpuesto4x1000() {
		return cobraImpuesto4x1000;
	}

	public void setCobraImpuesto4x1000(Boolean cobraImpuesto4x1000) {
		this.cobraImpuesto4x1000 = cobraImpuesto4x1000;
	}

	public Boolean getCobraImpuestoLT() {
		return cobraImpuestoLT;
	}

	public void setCobraImpuestoLT(Boolean cobraImpuestoLT) {
		this.cobraImpuestoLT = cobraImpuestoLT;
	}

	public Boolean getUtilizaSerClientesOccidente() {
		return utilizaSerClientesOccidente;
	}

	public void setUtilizaSerClientesOccidente(Boolean utilizaSerClientesOccidente) {
		this.utilizaSerClientesOccidente = utilizaSerClientesOccidente;
	}

	public Boolean getUtilizaSerProductosOccidente() {
		return utilizaSerProductosOccidente;
	}

	public void setUtilizaSerProductosOccidente(Boolean utilizaSerProductosOccidente) {
		this.utilizaSerProductosOccidente = utilizaSerProductosOccidente;
	}

	public Boolean getConsolidaNotificacionesCliente() {
		return consolidaNotificacionesCliente;
	}

	public void setConsolidaNotificacionesCliente(Boolean consolidaNotificacionesCliente) {
		this.consolidaNotificacionesCliente = consolidaNotificacionesCliente;
	}

	public EnumAsigCodBarras getAsignacionCodBarrasFac() {
		return asignacionCodBarrasFac;
	}

	public void setAsignacionCodBarrasFac(EnumAsigCodBarras asignacionCodBarrasFac) {
		this.asignacionCodBarrasFac = asignacionCodBarrasFac;
	}

	public Long getReintentosFinalizarPSE() {
		return reintentosFinalizarPSE;
	}

	public void setReintentosFinalizarPSE(Long reintentosFinalizarPSE) {
		this.reintentosFinalizarPSE = reintentosFinalizarPSE;
	}

	public Boolean getUtilizaDetalleBodega() {
		return utilizaDetalleBodega;
	}

	public void setUtilizaDetalleBodega(Boolean utilizaDetalleBodega) {
		this.utilizaDetalleBodega = utilizaDetalleBodega;
	}

	public Long getTiempoInvocacionCambioEstado() {
		return tiempoInvocacionCambioEstado;
	}

	public void setTiempoInvocacionCambioEstado(Long tiempoInvocacionCambioEstado) {
		this.tiempoInvocacionCambioEstado = tiempoInvocacionCambioEstado;
	}

	public Long getTiempoInvocacionPendiente() {
		return tiempoInvocacionPendiente;
	}

	public void setTiempoInvocacionPendiente(Long tiempoInvocacionPendiente) {
		this.tiempoInvocacionPendiente = tiempoInvocacionPendiente;
	}

	public Long getTiempoMaxConfirmacionPSE() {
		return tiempoMaxConfirmacionPSE;
	}

	public void setTiempoMaxConfirmacionPSE(Long tiempoMaxConfirmacionPSE) {
		this.tiempoMaxConfirmacionPSE = tiempoMaxConfirmacionPSE;
	}

	public EnumTipoEntregaClaves getEntregaClavesEF() {
		return entregaClavesEF;
	}

	public void setEntregaClavesEF(EnumTipoEntregaClaves entregaClavesEF) {
		this.entregaClavesEF = entregaClavesEF;
	}

	public EnumTipoEntregaClaves getEntregaClavesCliente() {
		return entregaClavesCliente;
	}

	public void setEntregaClavesCliente(EnumTipoEntregaClaves entregaClavesCliente) {
		this.entregaClavesCliente = entregaClavesCliente;
	}

	public EnumEsquemaConexionLDAP getEsquemaConexionLDAP() {
		return esquemaConexionLDAP;
	}

	public void setEsquemaConexionLDAP(EnumEsquemaConexionLDAP esquemaConexionLDAP) {
		this.esquemaConexionLDAP = esquemaConexionLDAP;
	}

	public Boolean getPagaMoraSaldoFavor() {
		return pagaMoraSaldoFavor;
	}

	public void setPagaMoraSaldoFavor(Boolean pagaMoraSaldoFavor) {
		this.pagaMoraSaldoFavor = pagaMoraSaldoFavor;
	}

	public Boolean getModoFTPPassive() {
		return modoFTPPassive;
	}

	public void setModoFTPPassive(Boolean modoFTPPassive) {
		this.modoFTPPassive = modoFTPPassive;
	}

	public String getSeparadorRtaWSAutenticacion() {
		return separadorRtaWSAutenticacion;
	}

	public void setSeparadorRtaWSAutenticacion(String separadorRtaWSAutenticacion) {
		this.separadorRtaWSAutenticacion = separadorRtaWSAutenticacion;
	}

	public String getAppWSAutorizacion() {
		return appWSAutorizacion;
	}

	public void setAppWSAutorizacion(String appWSAutorizacion) {
		this.appWSAutorizacion = appWSAutorizacion;
	}

	public EnumReversarConstitucion getCuandoReversarConstitucion() {
		return cuandoReversarConstitucion;
	}

	public void setCuandoReversarConstitucion(EnumReversarConstitucion cuandoReversarConstitucion) {
		this.cuandoReversarConstitucion = cuandoReversarConstitucion;
	}

	public String getSeparadorRtaWSAutorizacion() {
		return separadorRtaWSAutorizacion;
	}

	public void setSeparadorRtaWSAutorizacion(String separadorRtaWSAutorizacion) {
		this.separadorRtaWSAutorizacion = separadorRtaWSAutorizacion;
	}

	public EnumTipoCausacionMora getCausacionInteresMora() {
		return causacionInteresMora;
	}

	public void setCausacionInteresMora(EnumTipoCausacionMora causacionInteresMora) {
		this.causacionInteresMora = causacionInteresMora;
	}

	public Boolean getValidaDesembolsoDistribuido() {
		return validaDesembolsoDistribuido;
	}

	public void setValidaDesembolsoDistribuido(Boolean validaDesembolsoDistribuido) {
		this.validaDesembolsoDistribuido = validaDesembolsoDistribuido;
	}

	public Date getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public EnumAccionCastigo getAccionCastigo() {
		return accionCastigo;
	}

	public void setAccionCastigo(EnumAccionCastigo accionCastigo) {
		this.accionCastigo = accionCastigo;
	}

	public Boolean getUtilizaSerValidarClientes() {
		return utilizaSerValidarClientes;
	}

	public void setUtilizaSerValidarClientes(Boolean utilizaSerValidarClientes) {
		this.utilizaSerValidarClientes = utilizaSerValidarClientes;
	}

	public Boolean getAjustaVolanteUnidad() {
		return ajustaVolanteUnidad;
	}

	public void setAjustaVolanteUnidad(Boolean ajustaVolanteUnidad) {
		this.ajustaVolanteUnidad = ajustaVolanteUnidad;
	}

	public Boolean getDigitalizaTitulos() {
		return digitalizaTitulos;
	}

	public void setDigitalizaTitulos(Boolean digitalizaTitulos) {
		this.digitalizaTitulos = digitalizaTitulos;
	}

	public Boolean getConsolidaDesembolsosAnalizar() {
		return consolidaDesembolsosAnalizar;
	}

	public void setConsolidaDesembolsosAnalizar(Boolean consolidaDesembolsosAnalizar) {
		this.consolidaDesembolsosAnalizar = consolidaDesembolsosAnalizar;
	}

	public String getInformativoPagoPSE() {
		return informativoPagoPSE;
	}

	public void setInformativoPagoPSE(String informativoPagoPSE) {
		this.informativoPagoPSE = informativoPagoPSE;
	}

	public String getContactoInfoPSE() {
		return contactoInfoPSE;
	}

	public void setContactoInfoPSE(String contactoInfoPSE) {
		this.contactoInfoPSE = contactoInfoPSE;
	}

	public Boolean getLiquidaTotalidadSaldoFavor() {
		return liquidaTotalidadSaldoFavor;
	}

	public void setLiquidaTotalidadSaldoFavor(Boolean liquidaTotalidadSaldoFavor) {
		this.liquidaTotalidadSaldoFavor = liquidaTotalidadSaldoFavor;
	}

	public String getAutorizarNegociosLT() {
		return autorizarNegociosLT;
	}

	public void setAutorizarNegociosLT(String autorizarNegociosLT) {
		this.autorizarNegociosLT = autorizarNegociosLT;
	}

	public String getAutorizarNegociosCF() {
		return autorizarNegociosCF;
	}

	public void setAutorizarNegociosCF(String autorizarNegociosCF) {
		this.autorizarNegociosCF = autorizarNegociosCF;
	}

	public String getAutorizarNegociosADC() {
		return autorizarNegociosADC;
	}

	public void setAutorizarNegociosADC(String autorizarNegociosADC) {
		this.autorizarNegociosADC = autorizarNegociosADC;
	}

	public String getAutorizarNegociosDT() {
		return autorizarNegociosDT;
	}

	public void setAutorizarNegociosDT(String autorizarNegociosDT) {
		this.autorizarNegociosDT = autorizarNegociosDT;
	}

	public Long getMaxNumeroFacturasCargueLinea() {
		return maxNumeroFacturasCargueLinea;
	}

	public void setMaxNumeroFacturasCargueLinea(Long maxNumeroFacturasCargueLinea) {
		this.maxNumeroFacturasCargueLinea = maxNumeroFacturasCargueLinea;
	}

	public Boolean getCobraGMFADC() {
		return cobraGMFADC;
	}

	public void setCobraGMFADC(Boolean cobraGMFADC) {
		this.cobraGMFADC = cobraGMFADC;
	}

	public Boolean getCobraGMFASaldoFavor() {
		return cobraGMFASaldoFavor;
	}

	public void setCobraGMFASaldoFavor(Boolean cobraGMFASaldoFavor) {
		this.cobraGMFASaldoFavor = cobraGMFASaldoFavor;
	}

	public Boolean getCobraGMFDesembolso() {
		return cobraGMFDesembolso;
	}

	public void setCobraGMFDesembolso(Boolean cobraGMFDesembolso) {
		this.cobraGMFDesembolso = cobraGMFDesembolso;
	}

	public Boolean getMuestraFechaPagoFuentePago() {
		return muestraFechaPagoFuentePago;
	}

	public void setMuestraFechaPagoFuentePago(Boolean muestraFechaPagoFuentePago) {
		this.muestraFechaPagoFuentePago = muestraFechaPagoFuentePago;
	}

	public Boolean getPermitePagoObligacionPaga() {
		return permitePagoObligacionPaga;
	}

	public void setPermitePagoObligacionPaga(Boolean permitePagoObligacionPaga) {
		this.permitePagoObligacionPaga = permitePagoObligacionPaga;
	}

	public Boolean getManejaFechaPago() {
		return manejaFechaPago;
	}

	public void setManejaFechaPago(Boolean manejaFechaPago) {
		this.manejaFechaPago = manejaFechaPago;
	}

	public Boolean getAbonosAObligacionEspecifica() {
		return abonosAObligacionEspecifica;
	}

	public void setAbonosAObligacionEspecifica(Boolean abonosAObligacionEspecifica) {
		this.abonosAObligacionEspecifica = abonosAObligacionEspecifica;
	}

	public String getLlaveEncripcionScratch() {
		return llaveEncripcionScratch;
	}

	public void setLlaveEncripcionScratch(String llaveEncripcionScratch) {
		this.llaveEncripcionScratch = llaveEncripcionScratch;
	}

	public Boolean getPermitePagoReferenciaPago() {
		return permitePagoReferenciaPago;
	}

	public void setPermitePagoReferenciaPago(Boolean permitePagoReferenciaPago) {
		this.permitePagoReferenciaPago = permitePagoReferenciaPago;
	}

	public Boolean getPermitePagoObligaciones() {
		return permitePagoObligaciones;
	}

	public void setPermitePagoObligaciones(Boolean permitePagoObligaciones) {
		this.permitePagoObligaciones = permitePagoObligaciones;
	}

	public Boolean getMuestraNumFacturaVolantePago() {
		return muestraNumFacturaVolantePago;
	}

	public void setMuestraNumFacturaVolantePago(Boolean muestraNumFacturaVolantePago) {
		this.muestraNumFacturaVolantePago = muestraNumFacturaVolantePago;
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

	public Boolean getPermiteCaracteresEspeciales() {
		return permiteCaracteresEspeciales;
	}

	public void setPermiteCaracteresEspeciales(Boolean permiteCaracteresEspeciales) {
		this.permiteCaracteresEspeciales = permiteCaracteresEspeciales;
	}

	public String getUrlExternaCierreSesionEF() {
		return urlExternaCierreSesionEF;
	}

	public void setUrlExternaCierreSesionEF(String urlExternaCierreSesionEF) {
		this.urlExternaCierreSesionEF = urlExternaCierreSesionEF;
	}

	public String getUrlExternaCierreSesionCliente() {
		return urlExternaCierreSesionCliente;
	}

	public void setUrlExternaCierreSesionCliente(String urlExternaCierreSesionCliente) {
		this.urlExternaCierreSesionCliente = urlExternaCierreSesionCliente;
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

	public Boolean getControlDualDesembolso() {
		return controlDualDesembolso;
	}

	public void setControlDualDesembolso(Boolean controlDualDesembolso) {
		this.controlDualDesembolso = controlDualDesembolso;
	}

	public EnumTipoAmortizacionDescuentos getAmortizacionDescuentos() {
		return amortizacionDescuentos;
	}

	public void setAmortizacionDescuentos(EnumTipoAmortizacionDescuentos amortizacionDescuentos) {
		this.amortizacionDescuentos = amortizacionDescuentos;
	}

	public Boolean getDevSaldosAFavorAplicativo() {
		return devSaldosAFavorAplicativo;
	}

	public void setDevSaldosAFavorAplicativo(Boolean devSaldosAFavorAplicativo) {
		this.devSaldosAFavorAplicativo = devSaldosAFavorAplicativo;
	}

	public Long getDiasGraciaConfirming() {
		return diasGraciaConfirming;
	}

	public void setDiasGraciaConfirming(Long diasGraciaConfirming) {
		this.diasGraciaConfirming = diasGraciaConfirming;
	}

	public Long getDiasGraciaDescuentoTitulos() {
		return diasGraciaDescuentoTitulos;
	}

	public void setDiasGraciaDescuentoTitulos(Long diasGraciaDescuentoTitulos) {
		this.diasGraciaDescuentoTitulos = diasGraciaDescuentoTitulos;
	}

	public Long getDiasGraciaLineaTriangular() {
		return diasGraciaLineaTriangular;
	}

	public void setDiasGraciaLineaTriangular(Long diasGraciaLineaTriangular) {
		this.diasGraciaLineaTriangular = diasGraciaLineaTriangular;
	}

	public Long getDiasGraciaADC() {
		return diasGraciaADC;
	}

	public void setDiasGraciaADC(Long diasGraciaADC) {
		this.diasGraciaADC = diasGraciaADC;
	}

	public Boolean getControlTasaUsuraLT() {
		return controlTasaUsuraLT;
	}

	public void setControlTasaUsuraLT(Boolean controlTasaUsuraLT) {
		this.controlTasaUsuraLT = controlTasaUsuraLT;
	}

	public Boolean getControlTasaUsuraADC() {
		return controlTasaUsuraADC;
	}

	public void setControlTasaUsuraADC(Boolean controlTasaUsuraADC) {
		this.controlTasaUsuraADC = controlTasaUsuraADC;
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

	public Boolean getMuestraUsuFunCliente() {
		return muestraUsuFunCliente;
	}

	public void setMuestraUsuFunCliente(Boolean muestraUsuFunCliente) {
		this.muestraUsuFunCliente = muestraUsuFunCliente;
	}

	public String getTextAutorizacionFactEspeciales() {
		return textAutorizacionFactEspeciales;
	}

	public void setTextAutorizacionFactEspeciales(String textAutorizacionFactEspeciales) {
		this.textAutorizacionFactEspeciales = textAutorizacionFactEspeciales;
	}

	public Boolean getSolicitaValorFacIVA() {
		return solicitaValorFacIVA;
	}

	public void setSolicitaValorFacIVA(Boolean solicitaValorFacIVA) {
		this.solicitaValorFacIVA = solicitaValorFacIVA;
	}

	public Long getCantidadProrrogasPermitidas() {
		return cantidadProrrogasPermitidas;
	}

	public void setCantidadProrrogasPermitidas(Long cantidadProrrogasPermitidas) {
		this.cantidadProrrogasPermitidas = cantidadProrrogasPermitidas;
	}

	public Boolean getPermiteProrrogasOblVenc() {
		return permiteProrrogasOblVenc;
	}

	public void setPermiteProrrogasOblVenc(Boolean permiteProrrogasOblVenc) {
		this.permiteProrrogasOblVenc = permiteProrrogasOblVenc;
	}

	public EnumFormaCalcularValorProrroga getFormaCalcularValorProrroga() {
		return formaCalcularValorProrroga;
	}

	public void setFormaCalcularValorProrroga(EnumFormaCalcularValorProrroga formaCalcularValorProrroga) {
		this.formaCalcularValorProrroga = formaCalcularValorProrroga;
	}

	public Boolean getPermiteAbonosCuentaDeudor() {
		return permiteAbonosCuentaDeudor;
	}

	public void setPermiteAbonosCuentaDeudor(Boolean permiteAbonosCuentaDeudor) {
		this.permiteAbonosCuentaDeudor = permiteAbonosCuentaDeudor;
	}

	public Long getDiasAdicVigPasswordUsuario() {
		return diasAdicVigPasswordUsuario;
	}

	public void setDiasAdicVigPasswordUsuario(Long diasAdicVigPasswordUsuario) {
		this.diasAdicVigPasswordUsuario = diasAdicVigPasswordUsuario;
	}

	public String getCantPaginasAutenticacion() {
		return cantPaginasAutenticacion;
	}

	public void setCantPaginasAutenticacion(String cantPaginasAutenticacion) {
		this.cantPaginasAutenticacion = cantPaginasAutenticacion;
	}

	public EnumMedioPagoDesemAsist getMedioPagoDesembAsist() {
		return medioPagoDesembAsist;
	}

	public void setMedioPagoDesembAsist(EnumMedioPagoDesemAsist medioPagoDesembAsist) {
		this.medioPagoDesembAsist = medioPagoDesembAsist;
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

	public String getTerminosCondCFsinRespVend() {
		return terminosCondCFsinRespVend;
	}

	public void setTerminosCondCFsinRespVend(String terminosCondCFsinRespVend) {
		this.terminosCondCFsinRespVend = terminosCondCFsinRespVend;
	}

	public String getTerminosCondCFsinRespComp() {
		return terminosCondCFsinRespComp;
	}

	public void setTerminosCondCFsinRespComp(String terminosCondCFsinRespComp) {
		this.terminosCondCFsinRespComp = terminosCondCFsinRespComp;
	}

	public String getTerminosCondCFconRespComp() {
		return terminosCondCFconRespComp;
	}

	public void setTerminosCondCFconRespComp(String terminosCondCFconRespComp) {
		this.terminosCondCFconRespComp = terminosCondCFconRespComp;
	}

	public String getTerminosCondLTCargComp() {
		return terminosCondLTCargComp;
	}

	public void setTerminosCondLTCargComp(String terminosCondLTCargComp) {
		this.terminosCondLTCargComp = terminosCondLTCargComp;
	}

	public String getTerminosCondLTCargVend() {
		return terminosCondLTCargVend;
	}

	public void setTerminosCondLTCargVend(String terminosCondLTCargVend) {
		this.terminosCondLTCargVend = terminosCondLTCargVend;
	}

	public String getTerminosCondLTAutorizacionVend() {
		return terminosCondLTAutorizacionVend;
	}

	public void setTerminosCondLTAutorizacionVend(String terminosCondLTAutorizacionVend) {
		this.terminosCondLTAutorizacionVend = terminosCondLTAutorizacionVend;
	}

	public Boolean getConsolidaDesembolsosAsistidos() {
		return consolidaDesembolsosAsistidos;
	}

	public void setConsolidaDesembolsosAsistidos(Boolean consolidaDesembolsosAsistidos) {
		this.consolidaDesembolsosAsistidos = consolidaDesembolsosAsistidos;
	}

	public String getMensajeBienvenida() {
		return mensajeBienvenida;
	}

	public void setMensajeBienvenida(String mensajeBienvenida) {
		this.mensajeBienvenida = mensajeBienvenida;
	}

	public String getMensajeInformacion() {
		return mensajeInformacion;
	}

	public void setMensajeInformacion(String mensajeInformacion) {
		this.mensajeInformacion = mensajeInformacion;
	}

	public Boolean getAceptaTerminosCondiciones() {
		return aceptaTerminosCondiciones;
	}

	public void setAceptaTerminosCondiciones(Boolean aceptaTerminosCondiciones) {
		this.aceptaTerminosCondiciones = aceptaTerminosCondiciones;
	}

	public EnumFormPresentaPlanCliente getFormaPresentaPlanLt() {
		return formaPresentaPlanLt;
	}

	public void setFormaPresentaPlanLt(EnumFormPresentaPlanCliente formaPresentaPlanLt) {
		this.formaPresentaPlanLt = formaPresentaPlanLt;
	}

	public Boolean getCtrlPerfilesProductoRolCliente() {
		return ctrlPerfilesProductoRolCliente;
	}

	public void setCtrlPerfilesProductoRolCliente(Boolean ctrlPerfilesProductoRolCliente) {
		this.ctrlPerfilesProductoRolCliente = ctrlPerfilesProductoRolCliente;
	}

	public Boolean getManejaTablaDescuento() {
		return manejaTablaDescuento;
	}

	public void setManejaTablaDescuento(Boolean manejaTablaDescuento) {
		this.manejaTablaDescuento = manejaTablaDescuento;
	}

	public String getTerminosCondDtAutorizacionComp() {
		return terminosCondDtAutorizacionComp;
	}

	public void setTerminosCondDtAutorizacionComp(String terminosCondDtAutorizacionComp) {
		this.terminosCondDtAutorizacionComp = terminosCondDtAutorizacionComp;
	}

	public EnumTipoFlujoDT getTipoFlujoDT() {
		return tipoFlujoDT;
	}

	public void setTipoFlujoDT(EnumTipoFlujoDT tipoFlujoDT) {
		this.tipoFlujoDT = tipoFlujoDT;
	}

	public EnumEstadoTitulo getEstadoFormNegociacion() {
		return estadoFormNegociacion;
	}

	public void setEstadoFormNegociacion(EnumEstadoTitulo estadoFormNegociacion) {
		this.estadoFormNegociacion = estadoFormNegociacion;
	}

	public EnumMetodoAsignacionOficina getMetodoAsignacionOficina() {
		return metodoAsignacionOficina;
	}

	public void setMetodoAsignacionOficina(EnumMetodoAsignacionOficina metodoAsignacionOficina) {
		this.metodoAsignacionOficina = metodoAsignacionOficina;
	}

	public Boolean getCargaMontosMaximos() {
		return cargaMontosMaximos;
	}

	public void setCargaMontosMaximos(Boolean cargaMontosMaximos) {
		this.cargaMontosMaximos = cargaMontosMaximos;
	}

	public Boolean getSolicitaActaAprobacionCupo() {
		return solicitaActaAprobacionCupo;
	}

	public void setSolicitaActaAprobacionCupo(Boolean solicitaActaAprobacionCupo) {
		this.solicitaActaAprobacionCupo = solicitaActaAprobacionCupo;
	}

	public Boolean getAbonoParcialACuenta() {
		return abonoParcialACuenta;
	}

	public void setAbonoParcialACuenta(Boolean abonoParcialACuenta) {
		this.abonoParcialACuenta = abonoParcialACuenta;
	}

	public Boolean getReconoceDevDctoComprador() {
		return reconoceDevDctoComprador;
	}

	public void setReconoceDevDctoComprador(Boolean reconoceDevDctoComprador) {
		this.reconoceDevDctoComprador = reconoceDevDctoComprador;
	}

	public Boolean getPermiteFinanciacionLT() {
		return permiteFinanciacionLT;
	}

	public void setPermiteFinanciacionLT(Boolean permiteFinanciacionLT) {
		this.permiteFinanciacionLT = permiteFinanciacionLT;
	}

	public Boolean getPrimeraProrrogaCancelaObl() {
		return primeraProrrogaCancelaObl;
	}

	public void setPrimeraProrrogaCancelaObl(Boolean primeraProrrogaCancelaObl) {
		this.primeraProrrogaCancelaObl = primeraProrrogaCancelaObl;
	}

	public String getTerminosCondProrroga() {
		return terminosCondProrroga;
	}

	public void setTerminosCondProrroga(String terminosCondProrroga) {
		this.terminosCondProrroga = terminosCondProrroga;
	}

	public Boolean getIncluyeFormatoUsuariosEF() {
		return incluyeFormatoUsuariosEF;
	}

	public void setIncluyeFormatoUsuariosEF(Boolean incluyeFormatoUsuariosEF) {
		this.incluyeFormatoUsuariosEF = incluyeFormatoUsuariosEF;
	}

	public Boolean getAutogestionSegCFSinResp() {
		return autogestionSegCFSinResp;
	}

	public void setAutogestionSegCFSinResp(Boolean autogestionSegCFSinResp) {
		this.autogestionSegCFSinResp = autogestionSegCFSinResp;
	}

	public Boolean getManejaReembolso() {
		return manejaReembolso;
	}

	public void setManejaReembolso(Boolean manejaReembolso) {
		this.manejaReembolso = manejaReembolso;
	}

	public Boolean getConfirmingNuevo() {
		return confirmingNuevo;
	}

	public void setConfirmingNuevo(Boolean confirmingNuevo) {
		this.confirmingNuevo = confirmingNuevo;
	}

	public Boolean getMuestraTerminos() {
		return muestraTerminos;
	}

	public void setMuestraTerminos(Boolean muestraTerminos) {
		this.muestraTerminos = muestraTerminos;
	}

	public Boolean getAsignaInfoContacto() {
		return asignaInfoContacto;
	}

	public void setAsignaInfoContacto(Boolean asignaInfoContacto) {
		this.asignaInfoContacto = asignaInfoContacto;
	}

	public String getResponsableAsigClaves() {
		return responsableAsigClaves;
	}

	public void setResponsableAsigClaves(String responsableAsigClaves) {
		this.responsableAsigClaves = responsableAsigClaves;
	}

	public String getPuestoAsigClaves() {
		return puestoAsigClaves;
	}

	public void setPuestoAsigClaves(String puestoAsigClaves) {
		this.puestoAsigClaves = puestoAsigClaves;
	}

	public EnumManejoCalificacion getManejoCalificacionClientes() {
		return manejoCalificacionClientes;
	}

	public void setManejoCalificacionClientes(EnumManejoCalificacion manejoCalificacionClientes) {
		this.manejoCalificacionClientes = manejoCalificacionClientes;
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

	public Long getCantRegCons() {
		return cantRegCons;
	}

	public void setCantRegCons(Long cantRegCons) {
		this.cantRegCons = cantRegCons;
	}

	public Boolean getMuestraCupoCompradores() {
		return muestraCupoCompradores;
	}

	public void setMuestraCupoCompradores(Boolean muestraCupoCompradores) {
		this.muestraCupoCompradores = muestraCupoCompradores;
	}

	public Boolean getPermiteDebitosAutomaticos() {
		return permiteDebitosAutomaticos;
	}

	public void setPermiteDebitosAutomaticos(Boolean permiteDebitosAutomaticos) {
		this.permiteDebitosAutomaticos = permiteDebitosAutomaticos;
	}

	public Boolean getPagaFacturasNoNegociadas() {
		return pagaFacturasNoNegociadas;
	}

	public void setPagaFacturasNoNegociadas(Boolean pagaFacturasNoNegociadas) {
		this.pagaFacturasNoNegociadas = pagaFacturasNoNegociadas;
	}

	public Boolean getManejaCentavosDesembolso() {
		return manejaCentavosDesembolso;
	}

	public void setManejaCentavosDesembolso(Boolean manejaCentavosDesembolso) {
		this.manejaCentavosDesembolso = manejaCentavosDesembolso;
	}

	public EnumConsecutivoObligaciones getConsecutivoObligaciones() {
		return consecutivoObligaciones;
	}

	public void setConsecutivoObligaciones(EnumConsecutivoObligaciones consecutivoObligaciones) {
		this.consecutivoObligaciones = consecutivoObligaciones;
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

	public void setMomentoCobrarProrroga(EnumMomentoCobrarProrroga momentoCobrarProrroga) {
		this.momentoCobrarProrroga = momentoCobrarProrroga;
	}

	public Long getDiasParaSolicitarProrrogas() {
		return diasParaSolicitarProrrogas;
	}

	public void setDiasParaSolicitarProrrogas(Long diasParaSolicitarProrrogas) {
		this.diasParaSolicitarProrrogas = diasParaSolicitarProrrogas;
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

	public Date getHoraMaximaGeneracion() {
		return horaMaximaGeneracion;
	}

	public void setHoraMaximaGeneracion(Date horaMaximaGeneracion) {
		this.horaMaximaGeneracion = horaMaximaGeneracion;
	}

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

	public Boolean getAbonosCuentaSinReferencia() {
		return abonosCuentaSinReferencia;
	}

	public void setAbonosCuentaSinReferencia(Boolean abonosCuentaSinReferencia) {
		this.abonosCuentaSinReferencia = abonosCuentaSinReferencia;
	}

	public Boolean getCobraGMFDescuentoCero() {
		return cobraGMFDescuentoCero;
	}

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

	public String getPseTextoServicioCliente() {
		return pseTextoServicioCliente;
	}

	public void setPseTextoServicioCliente(String pseTextoServicioCliente) {
		this.pseTextoServicioCliente = pseTextoServicioCliente;
	}

	public Boolean getCufeObligatorio() {
		return cufeObligatorio;
	}

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
