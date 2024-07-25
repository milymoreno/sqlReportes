package com.bootfactory.microinformes.application.modelDTO;

import java.math.BigDecimal;
import java.util.Date;

public class VisOperacionesGerenteDTO {

	private Date fecha;
	private String tipoOperacion;
	private String numeroReferencia;
	private String numeroObligacion;
	private String producto;
	private String tipoIdent;
	private String numId;
	private String nombre;
	private BigDecimal valor;
	private String codigoGerenteRelacion;
	private String nombreGerenteRelacion;
	private String codigoGerenteProducto;
	private String nombreGerenteProducto;
	private String apellido1;
	private String apellido2;
	private String sigla;
	private Integer tipoCliente;
	
	
	
	
	public VisOperacionesGerenteDTO(Date fecha, String tipoOperacion, String numeroReferencia,
			String numeroObligacion, String producto, String tipoIdent, String numId, String nombre, BigDecimal valor,
			String codigoGerenteRelacion, String nombreGerenteRelacion, String codigoGerenteProducto,
			String nombreGerenteProducto,String apellido1,String apellido2,String sigla,Integer tipoCliente,BigDecimal filaExt) {
		super();
		this.fecha = fecha;
		this.tipoOperacion = tipoOperacion;
		this.numeroReferencia = numeroReferencia;
		this.numeroObligacion = numeroObligacion;
		this.producto = producto;
		this.tipoIdent = tipoIdent;
		this.numId = numId;
		this.nombre = nombre;
		this.valor = valor;
		this.codigoGerenteRelacion = codigoGerenteRelacion;
		this.nombreGerenteRelacion = nombreGerenteRelacion;
		this.codigoGerenteProducto = codigoGerenteProducto;
		this.nombreGerenteProducto = nombreGerenteProducto;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.sigla=sigla;
		this.tipoCliente=tipoCliente;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public String getNumeroReferencia() {
		return numeroReferencia;
	}
	public void setNumeroReferencia(String numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}
	public String getNumeroObligacion() {
		return numeroObligacion;
	}
	public void setNumeroObligacion(String numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getTipoIdent() {
		return tipoIdent;
	}
	public void setTipoIdent(String tipoIdent) {
		this.tipoIdent = tipoIdent;
	}
	public String getNumId() {
		return numId;
	}
	public void setNumId(String numId) {
		this.numId = numId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getCodigoGerenteRelacion() {
		return codigoGerenteRelacion;
	}
	public void setCodigoGerenteRelacion(String codigoGerenteRelacion) {
		this.codigoGerenteRelacion = codigoGerenteRelacion;
	}
	public String getNombreGerenteRelacion() {
		return nombreGerenteRelacion;
	}
	public void setNombreGerenteRelacion(String nombreGerenteRelacion) {
		this.nombreGerenteRelacion = nombreGerenteRelacion;
	}
	public String getCodigoGerenteProducto() {
		return codigoGerenteProducto;
	}
	public void setCodigoGerenteProducto(String codigoGerenteProducto) {
		this.codigoGerenteProducto = codigoGerenteProducto;
	}
	public String getNombreGerenteProducto() {
		return nombreGerenteProducto;
	}
	public void setNombreGerenteProducto(String nombreGerenteProducto) {
		this.nombreGerenteProducto = nombreGerenteProducto;
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

	public Integer getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Integer tipo_cliente) {
		this.tipoCliente = tipo_cliente;
	}
	

//	private Long idDeudor;


//	private EnumRolCliente rol;
//
//	private String username;
	

}
