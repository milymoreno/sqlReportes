package com.bootfactory.microinformes.domain.model.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "TASA")
public class Tasa implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Identificador único de la tasa
	 */
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	/**
	 * Plazo de facturación
	 */
	@Column(name="PLAZOFACTURACION")
	private Long plazoFacturacion;
	
	
	/**
	 * Tasa de interés que determina el Spread 
	 */
	@Column(name="SPREADDCTO",length = 0, unique = false, precision = 0, scale = 0, nullable = true, columnDefinition = "NUMBER(9,6)", insertable = true, updatable = true)
	private Double spreadDcto;
	
	/**
	 * Tasa Fija de Dcto
	 */
	@Column(name="TASAFIJADCTO",length = 0, unique = false, precision = 0, scale = 0, nullable = true, columnDefinition = "NUMBER(9,6)", insertable = true, updatable = true)
	private Double tasaFijaDcto;
	
	/**
	 * Unico dia de dcto 
	 */
	@Column(name="UNICODIADCTO")
	private Long unicoDiaDcto; 
	
	/**
	 * Descuento único
	 */
	@Column(name="DCTOUNICO",length = 0, unique = false, precision = 0, scale = 0, nullable = true, columnDefinition = "NUMBER(9,6)", insertable = true, updatable = true)
	private Double dctoUnico;
	
	@Version
	@Column(name="VERSION")
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlazoFacturacion() {
		return plazoFacturacion;
	}

	public void setPlazoFacturacion(Long plazoFacturacion) {
		this.plazoFacturacion = plazoFacturacion;
	}

	public Double getSpreadDcto() {
		return spreadDcto;
	}

	public void setSpreadDcto(Double spreadDcto) {
		this.spreadDcto = spreadDcto;
	}

	public Double getTasaFijaDcto() {
		return tasaFijaDcto;
	}

	public void setTasaFijaDcto(Double tasaFijaDcto) {
		this.tasaFijaDcto = tasaFijaDcto;
	}

	public Long getUnicoDiaDcto() {
		return unicoDiaDcto;
	}

	public void setUnicoDiaDcto(Long unicoDiaDcto) {
		this.unicoDiaDcto = unicoDiaDcto;
	}

	public Double getDctoUnico() {
		return dctoUnico;
	}

	public void setDctoUnico(Double dctoUnico) {
		this.dctoUnico = dctoUnico;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dctoUnico, id, plazoFacturacion, spreadDcto, tasaFijaDcto, unicoDiaDcto, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tasa other = (Tasa) obj;
		return Objects.equals(dctoUnico, other.dctoUnico) && Objects.equals(id, other.id)
				&& Objects.equals(plazoFacturacion, other.plazoFacturacion)
				&& Objects.equals(spreadDcto, other.spreadDcto) && Objects.equals(tasaFijaDcto, other.tasaFijaDcto)
				&& Objects.equals(unicoDiaDcto, other.unicoDiaDcto) && Objects.equals(version, other.version);
	}	
	
}
