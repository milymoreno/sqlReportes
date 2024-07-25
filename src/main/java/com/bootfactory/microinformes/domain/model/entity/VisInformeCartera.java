package com.bootfactory.microinformes.domain.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.bootfactory.microinformes.domain.model.enums.EnumEstadoObligacion;
import com.bootfactory.microinformes.domain.model.enums.EnumRolCliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_INFORME_CARTERA")
public class VisInformeCartera {

	@Id
	@Column(name = "ID_VISTA")
	private Long id_vista;
	@Column(name = "NUMID_CLIENTE")
	private String numId;
	@Column(name = "TIDENT_CLIENTE")
	private String tident;
	@Column(name = "NOMBRE_CLIENTE")
	private String nombre;
	@Column(name = "APELLIDO1_CLIENTE")
	private String apellido1;
	@Column(name = "APELLIDO2_CLIENTE")
	private String apellido2;
	@Column(name = "SIGLA_CLIENTE")
	private String sigla;
	@Column(name = "TIPO_CLIENTE")
	private Long tipoCliente;
	@Column(name = "ENTIDAD_FINANCIERA")
	private Long entidadFinanciera;
	@Column(name = "OBLIGACION_ID")
	private Long obligacionId;
	@Column(name = "ESTADO_OBLIGACION")
	@Enumerated(value = EnumType.ORDINAL)
	private EnumEstadoObligacion estadoObligacion;
	@Column(name = "FECHA_VENCIMIENTO")
	private Date fechavencimiento;
	@Column(name = "TOTAL_CAPITAL")
	private BigDecimal totalCapital;
	@Column(name = "TOTAL_INTERES_CORRIENTE")
	private BigDecimal totalInteresCorriente;
	@Column(name = "TOTAL_INTERES_MORA")
	private BigDecimal totalInteresMora;
	@Column(name = "OTROS")
	private BigDecimal totalOtros;
	@Column(name = "SALDO_OBLIGACION")
	private BigDecimal saldoObligacion;
	@Column(name = "ROL_CLIENTE")
	@Enumerated(value = EnumType.ORDINAL)
	private EnumRolCliente rolCliente;
	@Column(name = "OBLIGACION")
	private String numeroObligacion;
	@Column(name = "DIAS_MORA")
	private Long diasMora;
	@Column(name = "NUMERO_FACTURA")
	private String numeroFactura;
	@Column(name = "NUMID_CONTRAPARTE")
	private String numIdContraparte;
	@Column(name = "NOMBRE_CONTRAPARTE")
	private String nombreContraparte;
	public Long getId_vista() {
		return id_vista;
	}
	public void setId_vista(Long id_vista) {
		this.id_vista = id_vista;
	}
	public String getNumId() {
		return numId;
	}
	public void setNumId(String numId) {
		this.numId = numId;
	}
	public String getTident() {
		return tident;
	}
	public void setTident(String tident) {
		this.tident = tident;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Long getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(Long tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public Long getEntidadFinanciera() {
		return entidadFinanciera;
	}
	public void setEntidadFinanciera(Long entidadFinanciera) {
		this.entidadFinanciera = entidadFinanciera;
	}
	public Long getObligacionId() {
		return obligacionId;
	}
	public void setObligacionId(Long obligacionId) {
		this.obligacionId = obligacionId;
	}
	public EnumEstadoObligacion getEstadoObligacion() {
		return estadoObligacion;
	}
	public void setEstadoObligacion(EnumEstadoObligacion estadoObligacion) {
		this.estadoObligacion = estadoObligacion;
	}
	public Date getFechavencimiento() {
		return fechavencimiento;
	}
	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	public BigDecimal getTotalCapital() {
		return totalCapital;
	}
	public void setTotalCapital(BigDecimal totalCapital) {
		this.totalCapital = totalCapital;
	}
	public BigDecimal getTotalInteresCorriente() {
		return totalInteresCorriente;
	}
	public void setTotalInteresCorriente(BigDecimal totalInteresCorriente) {
		this.totalInteresCorriente = totalInteresCorriente;
	}
	public BigDecimal getTotalInteresMora() {
		return totalInteresMora;
	}
	public void setTotalInteresMora(BigDecimal totalInteresMora) {
		this.totalInteresMora = totalInteresMora;
	}
	public BigDecimal getTotalOtros() {
		return totalOtros;
	}
	public void setTotalOtros(BigDecimal totalOtros) {
		this.totalOtros = totalOtros;
	}
	public BigDecimal getSaldoObligacion() {
		return saldoObligacion;
	}
	public void setSaldoObligacion(BigDecimal saldoObligacion) {
		this.saldoObligacion = saldoObligacion;
	}
	public EnumRolCliente getRolCliente() {
		return rolCliente;
	}
	public void setRolCliente(EnumRolCliente rolCliente) {
		this.rolCliente = rolCliente;
	}
	public String getNumeroObligacion() {
		return numeroObligacion;
	}
	public void setNumeroObligacion(String numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}
	public Long getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(Long diasMora) {
		this.diasMora = diasMora;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public String getNumIdContraparte() {
		return numIdContraparte;
	}
	public void setNumIdContraparte(String numIdContraparte) {
		this.numIdContraparte = numIdContraparte;
	}
	public String getNombreContraparte() {
		return nombreContraparte;
	}
	public void setNombreContraparte(String nombreContraparte) {
		this.nombreContraparte = nombreContraparte;
	}
	
	

}
