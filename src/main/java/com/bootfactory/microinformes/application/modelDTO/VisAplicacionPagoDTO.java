package com.bootfactory.microinformes.application.modelDTO;

import java.math.BigDecimal;
import java.util.Date;

import com.bootfactory.microinformes.domain.model.enums.EnumConceptoCartera;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoObligacion;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoPago;

public class VisAplicacionPagoDTO {

	private String referencia;
	private BigDecimal valorTotal;
	private EnumEstadoPago estadoReferenciaPago;
	private String referenciasPagoRelacionadas;
	private String numeroObligacion;
	private String numeroRelacionado;
	private String numIdvendedor;
	private String nombreVendedor;
	private String numIdComprador;
	private String nombreComprador;
	private EnumConceptoCartera conceptoAplicadoPago;
	private BigDecimal valorPagoAplicado;
	private Date fechaAplicacion;
	private Date fechaAplicacionContable;
	private EnumEstadoObligacion estadoObligacion;
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public EnumEstadoPago getEstadoReferenciaPago() {
		return estadoReferenciaPago;
	}
	public void setEstadoReferenciaPago(EnumEstadoPago estadoReferenciaPago) {
		this.estadoReferenciaPago = estadoReferenciaPago;
	}
	public String getReferenciasPagoRelacionadas() {
		return referenciasPagoRelacionadas;
	}
	public void setReferenciasPagoRelacionadas(String referenciasPagoRelacionadas) {
		this.referenciasPagoRelacionadas = referenciasPagoRelacionadas;
	}
	public String getNumeroObligacion() {
		return numeroObligacion;
	}
	public void setNumeroObligacion(String numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}
	
	public String getNumeroRelacionado() {
		return numeroRelacionado;
	}
	public void setNumeroRelacionado(String numeroRelacionado) {
		this.numeroRelacionado = numeroRelacionado;
	}
	public String getNumIdvendedor() {
		return numIdvendedor;
	}
	public void setNumIdvendedor(String numIdvendedor) {
		this.numIdvendedor = numIdvendedor;
	}
	public String getNombreVendedor() {
		return nombreVendedor;
	}
	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}
	public String getNumIdComprador() {
		return numIdComprador;
	}
	public void setNumIdComprador(String numIdComprador) {
		this.numIdComprador = numIdComprador;
	}
	public String getNombreComprador() {
		return nombreComprador;
	}
	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}
	public EnumConceptoCartera getConceptoAplicadoPago() {
		return conceptoAplicadoPago;
	}
	public void setConceptoAplicadoPago(EnumConceptoCartera conceptoAplicadoPago) {
		this.conceptoAplicadoPago = conceptoAplicadoPago;
	}
	public BigDecimal getValorPagoAplicado() {
		return valorPagoAplicado;
	}
	public void setValorPagoAplicado(BigDecimal valorPagoAplicado) {
		this.valorPagoAplicado = valorPagoAplicado;
	}
	public Date getFechaAplicacion() {
		return fechaAplicacion;
	}
	public void setFechaAplicacion(Date fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}
	
	public Date getFechaAplicacionContable() {
		return fechaAplicacionContable;
	}
	public void setFechaAplicacionContable(Date fechaAplicacionContable) {
		this.fechaAplicacionContable = fechaAplicacionContable;
	}
	public EnumEstadoObligacion getEstadoObligacion() {
		return estadoObligacion;
	}
	public void setEstadoObligacion(EnumEstadoObligacion estadoObligacion) {
		this.estadoObligacion = estadoObligacion;
	}
	
	

}
