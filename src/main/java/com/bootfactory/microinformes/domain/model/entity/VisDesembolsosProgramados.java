package com.bootfactory.microinformes.domain.model.entity;


import java.math.BigDecimal;
import java.util.Date;

import com.bootfactory.microinformes.domain.model.enums.EnumEstadoTitulo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "V_DESEMBOLSOS_PROGRAMADOS")
public class VisDesembolsosProgramados {
	
	@Id
	@Column(name = "titulo_id")
	private Long tituloId;
	@Column(name = "entidad_financiera")
	private Long entidadFinanciera;
	@Column(name = "estado_titulo")
	@Enumerated(value = EnumType.ORDINAL)
	private EnumEstadoTitulo estadoTitulo;
	@Column(name = "fecha_pago")
	private Date fechaPago;
	@Column(name = "valor_titulo")
	private BigDecimal valorTitulo;
	@Column(name = "nombre_producto")
	private String nombreProducto;
	@Column(name = "cantidad_titulos")
	private int cantidadTitulos = 0;
	@Column(name = "valor_desembolso")
	private BigDecimal valorDesembolso = new BigDecimal(0);
	public Long getTituloId() {
		return tituloId;
	}
	public void setTituloId(Long tituloId) {
		this.tituloId = tituloId;
	}
	public Long getEntidadFinanciera() {
		return entidadFinanciera;
	}
	public void setEntidadFinanciera(Long entidadFinanciera) {
		this.entidadFinanciera = entidadFinanciera;
	}
	public EnumEstadoTitulo getEstadoTitulo() {
		return estadoTitulo;
	}
	public void setEstadoTitulo(EnumEstadoTitulo estadoTitulo) {
		this.estadoTitulo = estadoTitulo;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public BigDecimal getValorTitulo() {
		return valorTitulo;
	}
	public void setValorTitulo(BigDecimal valorTitulo) {
		this.valorTitulo = valorTitulo;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getCantidadTitulos() {
		return cantidadTitulos;
	}
	public void setCantidadTitulos(int cantidadTitulos) {
		this.cantidadTitulos = cantidadTitulos;
	}
	public BigDecimal getValorDesembolso() {
		return valorDesembolso;
	}
	public void setValorDesembolso(BigDecimal valorDesembolso) {
		this.valorDesembolso = valorDesembolso;
	}
	
	


}
