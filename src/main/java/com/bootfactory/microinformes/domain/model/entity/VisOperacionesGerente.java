package com.bootfactory.microinformes.domain.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bootfactory.microinformes.domain.model.enums.EnumRolCliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_OPERACIONES_GERENTE")
public class VisOperacionesGerente {

	@Id
	@Column(name = "ID_OPERACION")
	private Long id;
	
	@Column(name = "ID_DEUDOR")
	private Long idDeudor;
	
	@Column(name = "NUM_ID_DEUDOR")
	private String numId;
	
	@Column(name = "NOMBRE_DEUDOR")
	private String nombre;
	
	@Column(name = "APELLIDO1_DEUDOR")
	private String apellido1;
	
	@Column(name = "APELLIDO2_DEUDOR")
	private String apellido2;
	
	@Column(name = "SIGLA_DEUDOR")
	private String sigla;
	
	@Column(name = "TIPO_CLIENTE_DEUDOR")
	private Long tipo_cliente;
	
	@Column(name = "TIP_IDENT_DEUDOR")
	private String tipoIdent;
	
	@Column(name = "TIPO_OPERACION", length = 4, columnDefinition = "CHAR(4)")
	private String tipoOperacion;
	
	@Column(name = "NUMERO_REFERENCIA")
	private String numeroReferencia;	
	
	@Column(name = "NUMERO_OBLIGACION")
	private String numeroObligacion;
	
	@Column(name = "VALOR")
	private BigDecimal valor;
	
	@Column(name = "CODIGO_GERENTE_RELACION")
	private String codigoGerenteRelacion;
	
	@Column(name = "NOMBRE_GERENTE_RELACION")
	private String nombreGerenteRelacion;
	
	@Column(name = "CODIGO_GERENTE_PRODUCTO")
	private String codigoGerenteProducto;
	
	@Column(name = "NOMBRE_GERENTE_PRODUCTO")
	private String nombreGerenteProducto;
	
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ROL_CLIENTE")
	private EnumRolCliente rol;
	
	@Column(name = "FECHA")
	private LocalDateTime fecha;
	
	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "PRODUCTO")
	private String producto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDeudor() {
		return idDeudor;
	}

	public void setIdDeudor(Long idDeudor) {
		this.idDeudor = idDeudor;
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

	public Long getTipo_cliente() {
		return tipo_cliente;
	}

	public void setTipo_cliente(Long tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}

	public String getTipoIdent() {
		return tipoIdent;
	}

	public void setTipoIdent(String tipoIdent) {
		this.tipoIdent = tipoIdent;
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

	public EnumRolCliente getRol() {
		return rol;
	}

	public void setRol(EnumRolCliente rol) {
		this.rol = rol;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	

}
