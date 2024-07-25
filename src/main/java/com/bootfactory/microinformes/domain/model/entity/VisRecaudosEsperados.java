package com.bootfactory.microinformes.domain.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.bootfactory.microinformes.domain.model.enums.EnumEstadoObligacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_RECAUDOS_ESPERADOS")
public class VisRecaudosEsperados {
	
	
	@Id
	@Column(name = "ID_OBLIGACION")
	private Long id_obligacion;
	@Column(name = "ESTADO_OBLIGACION")
	@Enumerated(value = EnumType.ORDINAL)
	private EnumEstadoObligacion estado_obligacion;
	@Column(name = "FECHA_VENCIMIENTO")
	private Date fecha_vencimiento;
	@Column(name = "NOMBRE_PRODUCTO")
	private String nombre_producto;
	@Column(name = "CAPITAL")
	private BigDecimal capital;
	@Column(name = "INTERES_CORRIENTE")
	private BigDecimal interes_corriente;
	@Column(name = "INTERES_MORA")
	private BigDecimal interes_mora;
	@Column(name = "OTROS")
	private BigDecimal otros;
	@Column(name = "TOTAL")
	private BigDecimal total;
	public Long getId_obligacion() {
		return id_obligacion;
	}
	public void setId_obligacion(Long id_obligacion) {
		this.id_obligacion = id_obligacion;
	}
	public EnumEstadoObligacion getEstado_obligacion() {
		return estado_obligacion;
	}
	public void setEstado_obligacion(EnumEstadoObligacion estado_obligacion) {
		this.estado_obligacion = estado_obligacion;
	}
	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}
	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public BigDecimal getCapital() {
		return capital;
	}
	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}
	public BigDecimal getInteres_corriente() {
		return interes_corriente;
	}
	public void setInteres_corriente(BigDecimal interes_corriente) {
		this.interes_corriente = interes_corriente;
	}
	public BigDecimal getInteres_mora() {
		return interes_mora;
	}
	public void setInteres_mora(BigDecimal interes_mora) {
		this.interes_mora = interes_mora;
	}
	public BigDecimal getOtros() {
		return otros;
	}
	public void setOtros(BigDecimal otros) {
		this.otros = otros;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	

}
