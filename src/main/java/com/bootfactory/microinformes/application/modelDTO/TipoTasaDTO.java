package com.bootfactory.microinformes.application.modelDTO;

import com.bootfactory.microinformes.domain.model.entity.EntidadFinanciera;
import com.bootfactory.microinformes.domain.model.enums.EnumCaracteristicaTasa;
import com.bootfactory.microinformes.domain.model.enums.EnumTipoInteres;
import com.bootfactory.microinformes.domain.model.enums.EnumTipoTasa;

public class TipoTasaDTO {

	private Long id;
	private String nombre;
	private EnumTipoTasa tipoTasa;
	private Long version;
	private EnumTipoInteres tipoInteres;
	private EnumCaracteristicaTasa caracteristicaTasa;
	private String texto;
	private Boolean permiteRegistro;
	private Double periodicidad;
	private Boolean tasaVariableReferencia;
	private Long codigoTasaCargueArchivo;
	private String codigoProductoNovacion;
	private String codigoSubproductoNovacion;
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
