package com.bootfactory.microinformes.application.modelDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VisAuxiliarContableDTO {
	
	private String obligacion;
	
	private LocalDateTime  fechaAplicacionContable;
	
	private BigDecimal valorCredito;
	
	private BigDecimal valorDebito;
	
	private String cuentaContable;
	
	private Long concepto;

	public String getObligacion() {
		return obligacion;
	}

	public void setObligacion(String obligacion) {
		this.obligacion = obligacion;
	}

	public LocalDateTime getFechaAplicacionContable() {
		return fechaAplicacionContable;
	}

	public void setFechaAplicacionContable(LocalDateTime fechaAplicacionContable) {
		this.fechaAplicacionContable = fechaAplicacionContable;
	}

	public BigDecimal getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(BigDecimal valorCredito) {
		this.valorCredito = valorCredito;
	}

	public BigDecimal getValorDebito() {
		return valorDebito;
	}

	public void setValorDebito(BigDecimal valorDebito) {
		this.valorDebito = valorDebito;
	}

	public String getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public Long getConcepto() {
		return concepto;
	}

	public void setConcepto(Long concepto) {
		this.concepto = concepto;
	}

	
	


}
