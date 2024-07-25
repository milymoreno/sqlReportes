package com.bootfactory.microinformes.application.modelDTO;

import java.math.BigDecimal;
import java.util.Date;

public class VisInformeCarteraDTO {
	
	
	
	private String obligacion;
	private String numeroFactura;
	private String identificacion;
	private String nombre;
	private String idenContraparte;
	private String nombreContraparte;
	private BigDecimal totalCapital;
	private BigDecimal totalInteresCorriente;
	private BigDecimal totalMora;
	private BigDecimal totalOtrosCargos;
	private BigDecimal saldoALaFecha;
	private Date fechaVencimiento;
	private Long diasMora;
	
	
	public String getObligacion() {
		return obligacion;
	}
	public void setObligacion(String obligacion) {
		this.obligacion = obligacion;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdenContraparte() {
		return idenContraparte;
	}
	public void setIdenContraparte(String idenContraparte) {
		this.idenContraparte = idenContraparte;
	}
	public String getNombreContraparte() {
		return nombreContraparte;
	}
	public void setNombreContraparte(String nombreContraparte) {
		this.nombreContraparte = nombreContraparte;
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
	public BigDecimal getTotalMora() {
		return totalMora;
	}
	public void setTotalMora(BigDecimal totalMora) {
		this.totalMora = totalMora;
	}
	public BigDecimal getTotalOtrosCargos() {
		return totalOtrosCargos;
	}
	public void setTotalOtrosCargos(BigDecimal totalOtrosCargos) {
		this.totalOtrosCargos = totalOtrosCargos;
	}
	public BigDecimal getSaldoALaFecha() {
		return saldoALaFecha;
	}
	public void setSaldoALaFecha(BigDecimal saldoALaFecha) {
		this.saldoALaFecha = saldoALaFecha;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Long getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(Long diasMora) {
		this.diasMora = diasMora;
	}
	
	
	

	

}
