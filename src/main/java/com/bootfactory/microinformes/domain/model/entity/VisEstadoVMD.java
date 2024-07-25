package com.bootfactory.microinformes.domain.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.bootfactory.microinformes.domain.model.enums.EnumEstadoEntidad;
import com.bootfactory.microinformes.domain.model.enums.EnumRolCliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "V_ESTADO_VMD")
public class VisEstadoVMD {

	private Long id_vista;
	
	private String numId;
	
	private String tident;
	
	private String nombre;
	
	private String apellido1;

	private String apellido2;

	private String sigla;
	
	private Long tipoCliente;
	
	private String productoVMD;
	
	private String condicionVMD;
	
	private String numIdContraparte;
	
	private String tidentContraparte;
	
	private String nombreContraparte;
	
	private String apellido1Contraparte;

	private String apellido2Contraparte;

	private String siglaContraparte;
	
	private Long tipoContraparte;
	
	private String daVMD;
	
	private String recibeVMD;
	
	private Date fechaAprobacion;
	
	private Date fechaVigencia;
	
	private String modalidadVMD;
	
	private BigDecimal valorVMD;

	private BigDecimal disponibleVMD;

	private BigDecimal utilizadoVMD;

	private EnumEstadoEntidad estadoVMD;

	private String	monedaVMD;

	private String	nombreGerente;

	private String	apellido1Gerente;

	private String apellido2Gerente;

	@Enumerated(value = EnumType.ORDINAL)
	private EnumRolCliente rolCliente;

	private Long entidadFinanciera;
	
	private String observacion;

	@Id
	@Column(name = "ID_VISTA")
	public Long getId_vista() {
		return id_vista;
	}

	public void setId_vista(Long id_vista) {
		this.id_vista = id_vista;
	}
	
	@Column(name = "NUM_ID_CLIENTE")
	public String getNumId() {
		return numId;
	}

	public void setNumId(String numId) {
		this.numId = numId;
	}
	@Column(name = "TIPOIDENT_CLIENTE")
	public String getTident() {
		return tident;
	}

	public void setTident(String tident) {
		this.tident = tident;
	}
	
	@Column(name = "NOMBRE_CLIENTE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "APELLIDO1_CLIENTE")
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	@Column(name = "APELLIDO2_CLIENTE")
	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	@Column(name = "SIGLA_CLIENTE")
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Column(name = "TIPO_CLIENTE")
	public Long getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Long tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	@Column(name = "PRODUCTO_VMD")
	public String getProductoVMD() {
		return productoVMD;
	}

	public void setProductoVMD(String productoVMD) {
		this.productoVMD = productoVMD;
	}
	
	@Column(name = "CONDICION_VMD")
	public String getCondicionVMD() {
		return condicionVMD;
	}

	public void setCondicionVMD(String condicionVMD) {
		this.condicionVMD = condicionVMD;
	}
	
	@Column(name = "NUM_ID_CONTRAPARTE")
	public String getNumIdContraparte() {
		return numIdContraparte;
	}

	public void setNumIdContraparte(String numIdContraparte) {
		this.numIdContraparte = numIdContraparte;
	}
	
	@Column(name = "TIPOIDENT_CONTRAPARTE")
	public String getTidentContraparte() {
		return tidentContraparte;
	}

	public void setTidentContraparte(String tidentContraparte) {
		this.tidentContraparte = tidentContraparte;
	}
	
	@Column(name = "NOMBRE_CONTRAPARTE")
	public String getNombreContraparte() {
		return nombreContraparte;
	}

	public void setNombreContraparte(String nombreContraparte) {
		this.nombreContraparte = nombreContraparte;
	}
	
	@Column(name = "APELLIDO1_CONTRAPARTE")
	public String getApellido1Contraparte() {
		return apellido1Contraparte;
	}

	public void setApellido1Contraparte(String apellido1Contraparte) {
		this.apellido1Contraparte = apellido1Contraparte;
	}
	
	@Column(name = "APELLIDO2_CONTRAPARTE")
	public String getApellido2Contraparte() {
		return apellido2Contraparte;
	}

	public void setApellido2Contraparte(String apellido2Contraparte) {
		this.apellido2Contraparte = apellido2Contraparte;
	}
	
	@Column(name = "SIGLA_CONTRAPARTE")
	public String getSiglaContraparte() {
		return siglaContraparte;
	}

	public void setSiglaContraparte(String siglaContraparte) {
		this.siglaContraparte = siglaContraparte;
	}
	
	@Column(name = "TIPO_CONTRAPARTE")
	public Long getTipoContraparte() {
		return tipoContraparte;
	}

	public void setTipoContraparte(Long tipoContraparte) {
		this.tipoContraparte = tipoContraparte;
	}
	
	@Column(name = "DA_VMD", columnDefinition = "CHAR(2)")
	public String getDaVMD() {
		return daVMD;
	}

	public void setDaVMD(String daVMD) {
		this.daVMD = daVMD;
	}
	
	@Column(name = "RECIBE_VMD", columnDefinition = "CHAR(2)")
	public String getRecibeVMD() {
		return recibeVMD;
	}

	public void setRecibeVMD(String recibeVMD) {
		this.recibeVMD = recibeVMD;
	}
	
	@Column(name = "FECHA_APROBACION_VMD")
	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
	
	@Column(name = "FECHA_VIGENCIA_VMD")
	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}
	
	@Column(name = "MODALIDAD_VMD")
	public String getModalidadVMD() {
		return modalidadVMD;
	}

	public void setModalidadVMD(String modalidadVMD) {
		this.modalidadVMD = modalidadVMD;
	}
	
	@Column(name = "VALOR_VMD")
	public BigDecimal getValorVMD() {
		return valorVMD;
	}

	public void setValorVMD(BigDecimal valorVMD) {
		this.valorVMD = valorVMD;
	}
	
	@Column(name = "DISPONIBLE_VMD")
	public BigDecimal getDisponibleVMD() {
		return disponibleVMD;
	}

	public void setDisponibleVMD(BigDecimal disponibleVMD) {
		this.disponibleVMD = disponibleVMD;
	}
	
	@Column(name = "UTILIZADO_VMD")
	public BigDecimal getUtilizadoVMD() {
		return utilizadoVMD;
	}

	public void setUtilizadoVMD(BigDecimal utilizadoVMD) {
		this.utilizadoVMD = utilizadoVMD;
	}
	
	@Column(name="ESTADO_VMD", precision=10, scale=0)
    @Enumerated(value=EnumType.ORDINAL)
	public EnumEstadoEntidad getEstadoVMD() {
		return estadoVMD;
	}

	/**
	 * Sets the estado mm.
	 * 
	 * @param estadoMM the new estado mm
	 */
	public void setEstadoVMD(EnumEstadoEntidad estadoVMD) {
		this.estadoVMD = estadoVMD;
	}
	
	@Column(name = "MONEDA_VMD")
	public String getMonedaVMD() {
		return monedaVMD;
	}

	public void setMonedaVMD(String monedaVMD) {
		this.monedaVMD = monedaVMD;
	}
	
	@Column(name = "NOMBRE_GERENTE_VMD")
	public String getNombreGerente() {
		return nombreGerente;
	}

	public void setNombreGerente(String nombreGerente) {
		this.nombreGerente = nombreGerente;
	}
	
	@Column(name = "APELLIDO1_GERENTE_VMD")
	public String getApellido1Gerente() {
		return apellido1Gerente;
	}

	public void setApellido1Gerente(String apellido1Gerente) {
		this.apellido1Gerente = apellido1Gerente;
	}
	
	@Column(name = "APELLIDO2_GERENTE_VMD")
	public String getApellido2Gerente() {
		return apellido2Gerente;
	}

	public void setApellido2Gerente(String apellido2Gerente) {
		this.apellido2Gerente = apellido2Gerente;
	}
	
	@Column(name = "rol_cliente")
	public EnumRolCliente getRolCliente() {
		return rolCliente;
	}

	public void setRolCliente(EnumRolCliente rolCliente) {
		this.rolCliente = rolCliente;
	}
	
	@Column(name = "ENTIDAD_FINANCIERA")
	public Long getEntidadFinanciera() {
		return entidadFinanciera;
	}

	public void setEntidadFinanciera(Long entidadFinanciera) {
		this.entidadFinanciera = entidadFinanciera;
	}
	
	@Column(name = "OBSERVACION")
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	/**
	 * @return Nombre del Cliente
	 */
	@Transient
	public String obtenerNombreCliente()
	{
		String compuesto="";
		if(this.tipoCliente==1)
		{
			return this.sigla;
		}
		else
		{
			if(this.nombre!=null)
			{
				compuesto = compuesto.concat(this.nombre + " ");
			}
			if(this.apellido1!=null)
			{
				compuesto = compuesto.concat(this.apellido1 + " ");
			}
			if(this.apellido2!=null)
			{
				compuesto = compuesto.concat(this.apellido2 + " ");
			}
			return compuesto;
		}
	}

	/**
	 * @return Nombre de la Contraparte
	 */

	@Transient
	public String obtenerNombreContraparte()
	{
		String compuesto="";
		if(this.tipoContraparte==1)
		{
			return this.siglaContraparte;
		}
		else
		{
			if(this.nombreContraparte!=null)
			{
				compuesto = compuesto.concat(this.nombreContraparte + " ");
			}
			if(this.apellido1Contraparte!=null)
			{
				compuesto = compuesto.concat(this.apellido1Contraparte + " ");
			}
			if(this.apellido2Contraparte!=null)
			{
				compuesto = compuesto.concat(this.apellido2Contraparte + " ");
			}
			return compuesto;
		}
	}
}
