package com.bootfactory.microinformes.domain.model.entity;

import java.io.Serializable;

import com.bootfactory.microinformes.domain.model.enums.EnumCaracteristicaTasa;
import com.bootfactory.microinformes.domain.model.enums.EnumTipoInteres;
import com.bootfactory.microinformes.domain.model.enums.EnumTipoTasa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "TIPOTASA") 
public class TipoTasa implements Serializable, Cloneable{
	

	private static final long serialVersionUID = 1L;
	@Column(name = "NOMBRE" )
	private String nombre;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "TIPOTASA" )
	private EnumTipoTasa tipoTasa;
	@Version
	@Column(name = "VERSION" )
	private Long version;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "TIPOINTERES" )
	private EnumTipoInteres tipoInteres;

	@ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ENTIDADFINANCIERA_ID" )
	private EntidadFinanciera entidadFinanciera;

	@Column(name = "CARACTERISTICA_TASA")
	private EnumCaracteristicaTasa caracteristicaTasa;

	@Column(name = "TEXTO")
	private String texto;
	
	@Column(name = "PERMITE_REGISTRO",  nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean permiteRegistro;
	
	@Column(name = "PERIODICIDAD")
	private Double periodicidad;
	
	@Column(name = "TASA_VARIABLE_REFERENCIA", nullable=true, columnDefinition="NUMBER(1) DEFAULT 0")
	private Boolean tasaVariableReferencia;
	
	@Column(name = "CODIGO_TASA_CARGUE_ARCHIVO")
	private Long codigoTasaCargueArchivo;
	
	@Column(name = "CODIGO_PRODUCTO_NOVACION")
	private String codigoProductoNovacion;
	
	@Column(name = "CODIGO_SUBPRODUCTO_NOVACION")
	private String codigoSubproductoNovacion;
	
	@Column(name = "CODIGO_DESTINOECONOMICO_NOV")
	private String codigoDestinoEconomicoNovacion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EnumTipoTasa getTipoTasa() {
		return tipoTasa;
	}

	public void setTipoTasa(EnumTipoTasa tipoTasa) {
		this.tipoTasa = tipoTasa;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public EnumTipoInteres getTipoInteres() {
		return tipoInteres;
	}

	public void setTipoInteres(EnumTipoInteres tipoInteres) {
		this.tipoInteres = tipoInteres;
	}

	public EntidadFinanciera getEntidadFinanciera() {
		return entidadFinanciera;
	}

	public void setEntidadFinanciera(EntidadFinanciera entidadFinanciera) {
		this.entidadFinanciera = entidadFinanciera;
	}

	public EnumCaracteristicaTasa getCaracteristicaTasa() {
		return caracteristicaTasa;
	}

	public void setCaracteristicaTasa(EnumCaracteristicaTasa caracteristicaTasa) {
		this.caracteristicaTasa = caracteristicaTasa;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Boolean getPermiteRegistro() {
		return permiteRegistro;
	}

	public void setPermiteRegistro(Boolean permiteRegistro) {
		this.permiteRegistro = permiteRegistro;
	}

	public Double getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(Double periodicidad) {
		this.periodicidad = periodicidad;
	}

	public Boolean getTasaVariableReferencia() {
		return tasaVariableReferencia;
	}

	public void setTasaVariableReferencia(Boolean tasaVariableReferencia) {
		this.tasaVariableReferencia = tasaVariableReferencia;
	}

	public Long getCodigoTasaCargueArchivo() {
		return codigoTasaCargueArchivo;
	}

	public void setCodigoTasaCargueArchivo(Long codigoTasaCargueArchivo) {
		this.codigoTasaCargueArchivo = codigoTasaCargueArchivo;
	}

	public String getCodigoProductoNovacion() {
		return codigoProductoNovacion;
	}

	public void setCodigoProductoNovacion(String codigoProductoNovacion) {
		this.codigoProductoNovacion = codigoProductoNovacion;
	}

	public String getCodigoSubproductoNovacion() {
		return codigoSubproductoNovacion;
	}

	public void setCodigoSubproductoNovacion(String codigoSubproductoNovacion) {
		this.codigoSubproductoNovacion = codigoSubproductoNovacion;
	}

	public String getCodigoDestinoEconomicoNovacion() {
		return codigoDestinoEconomicoNovacion;
	}

	public void setCodigoDestinoEconomicoNovacion(String codigoDestinoEconomicoNovacion) {
		this.codigoDestinoEconomicoNovacion = codigoDestinoEconomicoNovacion;
	}
	
	
}

