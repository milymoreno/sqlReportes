package com.bootfactory.microinformes.domain.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.bootfactory.microinformes.domain.model.enums.EnumConceptoCartera;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoObligacion;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoPago;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_APLICACION_PAGO")
public class VisAplicacionPagoOperativo {

	@Id
	@Column(name = "V_ID")
	private String VId;
	@Column(name = "REFERENCIAPAGO", length = 50)
	private String referenciapago;
	@Column(name = "NUMERO", length = 50)
	private String numero;
	@Column(name = "TI_VENDEDOR")
	private String tiVendedor;
	@Column(name = "VENDEDOR_NUMID", length = 50)
	private String vendedorNumid;
	@Column(name = "NOMBRE_VENDEDOR", length = 50)
	private String nombreVendedor;
	@Column(name = "TI_COMPRADOR")
	private String tiComprador;
	@Column(name = "COMPRADOR_NUMID", length = 50)
	private String compradorNumid;
	@Column(name = "NOMBRE_COMPRADOR", length = 50)
	private String nombreComprador;
	@Column(name = "CONCEPTO", precision = 10, scale = 0)
	@Enumerated(value = EnumType.ORDINAL)
	private EnumConceptoCartera concepto;
	@Column(name = "VALOR", precision = 18)
	private BigDecimal valor;
	@Column(name = "ESTADO_OBLIGACION", precision = 10, scale = 0)
	@Enumerated(value = EnumType.ORDINAL)
	private EnumEstadoObligacion estadoObligacion;
	@Column(name = "ESTADO_PAGO", precision = 10, scale = 0)
	@Enumerated(value = EnumType.ORDINAL)
	private EnumEstadoPago estadoPago;
	@Column(name = "ENTIDAD_FINANCIERA")
	private Long entidadFinanciera;
	@Column(name = "VALOR_PAGO", precision = 18)
	private BigDecimal valorPago;
	@Column(name = "FECHA_APLICACION", precision = 18)
	private Date fechaAplicacion;
	@Column(name = "VENDEDOR_ID")
	private BigDecimal idVendedor;
	@Column(name = "COMPRADOR_ID")
	private BigDecimal idComprador;
	@Column(name = "FECHA_APLICACION_CONTABLE", precision = 18)
	private Date fechaAplicacionContable;
	@Column(name = "NUMERO_RELACIONADO", precision = 18)
	private String numeroRelacionado;

	public String getVId() {
		return VId;
	}

	public void setVId(String vId) {
		VId = vId;
	}

	public String getReferenciapago() {
		return referenciapago;
	}

	public void setReferenciapago(String referenciapago) {
		this.referenciapago = referenciapago;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTiVendedor() {
		return tiVendedor;
	}

	public void setTiVendedor(String tiVendedor) {
		this.tiVendedor = tiVendedor;
	}

	public String getVendedorNumid() {
		return vendedorNumid;
	}

	public void setVendedorNumid(String vendedorNumid) {
		this.vendedorNumid = vendedorNumid;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public String getTiComprador() {
		return tiComprador;
	}

	public void setTiComprador(String tiComprador) {
		this.tiComprador = tiComprador;
	}

	public String getCompradorNumid() {
		return compradorNumid;
	}

	public void setCompradorNumid(String compradorNumid) {
		this.compradorNumid = compradorNumid;
	}

	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}

	public EnumConceptoCartera getConcepto() {
		return concepto;
	}

	public void setConcepto(EnumConceptoCartera concepto) {
		this.concepto = concepto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public EnumEstadoObligacion getEstadoObligacion() {
		return estadoObligacion;
	}

	public void setEstadoObligacion(EnumEstadoObligacion estadoObligacion) {
		this.estadoObligacion = estadoObligacion;
	}

	public EnumEstadoPago getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(EnumEstadoPago estadoPago) {
		this.estadoPago = estadoPago;
	}

	public Long getEntidadFinanciera() {
		return entidadFinanciera;
	}

	public void setEntidadFinanciera(Long entidadFinanciera) {
		this.entidadFinanciera = entidadFinanciera;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public Date getFechaAplicacion() {
		return fechaAplicacion;
	}

	public void setFechaAplicacion(Date fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	public BigDecimal getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(BigDecimal idVendedor) {
		this.idVendedor = idVendedor;
	}

	public BigDecimal getIdComprador() {
		return idComprador;
	}

	public void setIdComprador(BigDecimal idComprador) {
		this.idComprador = idComprador;
	}

	public Date getFechaAplicacionContable() {
		return fechaAplicacionContable;
	}

	public void setFechaAplicacionContable(Date fechaAplicacionContable) {
		this.fechaAplicacionContable = fechaAplicacionContable;
	}

	public String getNumeroRelacionado() {
		return numeroRelacionado;
	}

	public void setNumeroRelacionado(String numeroRelacionado) {
		this.numeroRelacionado = numeroRelacionado;
	}

}
