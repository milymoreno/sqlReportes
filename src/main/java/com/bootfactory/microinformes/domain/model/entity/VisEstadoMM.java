package com.bootfactory.microinformes.domain.model.entity;

import java.math.BigDecimal;

import com.bootfactory.microinformes.domain.model.enums.EnumEstadoEntidad;
import com.bootfactory.microinformes.domain.model.enums.EnumRolCliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


/**
 * The Class VisEstadoMM.
 */
@Entity
@Table(name = "V_ESTADO_MM")
public class VisEstadoMM {

	/** The id_vista. */
	private Long id_vista;
	
	/** The num id. */
	private String numId;
	
	/** The tident. */
	private String tident;
	
	/** The nombre. */
	private String nombre;
	
	/** The apellido1. */
	private String apellido1;

	/** The apellido2. */
	private String apellido2;

	/** The sigla. */
	private String sigla;
	
	/** The tipo cliente. */
	private Long tipoCliente;
	
	/** The entidad financiera. */
	private Long entidadFinanciera;
	
	/** The producto mm. */
	private String productoMM;
	
	/** The valor mm. */
	private BigDecimal valorMM;
	
	/** The disponible mm. */
	private BigDecimal disponibleMM;
	
	/** The utilizado mm. */
	private BigDecimal utilizadoMM;
	
	/** The estado mm. */
	private EnumEstadoEntidad estadoMM;
	
	/** The moneda mm. */
	private String	monedaMM;
	
	/** The nombre_gerente. */
	private String	nombreGerente;
		
	/** The apellido1_gerente. */
	private String	apellido1Gerente;
	
	/** The apellido2_gerente. */
	private String apellido2Gerente;
	
	/** The rol cliente. */
	@Enumerated(value = EnumType.ORDINAL)
	private EnumRolCliente rolCliente;
	
	public VisEstadoMM() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the id_vista.
	 * 
	 * @return the id_vista
	 */
	@Id
	@Column(name = "ID_VISTA")
	public Long getId_vista() {
		return id_vista;
	}

	/**
	 * Sets the id_vista.
	 * 
	 * @param id_vista the new id_vista
	 */
	public void setId_vista(Long id_vista) {
		this.id_vista = id_vista;
	}

	/**
	 * Gets the num id.
	 * 
	 * @return the num id
	 */
	@Column(name = "NUM_ID_CLIENTE")
	public String getNumId() {
		return numId;
	}

	/**
	 * Sets the num id.
	 * 
	 * @param numId the new num id
	 */
	public void setNumId(String numId) {
		this.numId = numId;
	}
	
	/**
	 * Gets the tident.
	 * 
	 * @return the tident
	 */
	@Column(name = "TIPOIDENT_CLIENTE")
	public String getTident() {
		return tident;
	}

	/**
	 * Sets the tident.
	 * 
	 * @param tident the new tident
	 */
	public void setTident(String tident) {
		this.tident = tident;
	}
	
	/**
	 * Gets the nombre.
	 * 
	 * @return the nombre
	 */
	@Column(name = "NOMBRE_CLIENTE")
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 * 
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the apellido1.
	 * 
	 * @return the apellido1
	 */
	@Column(name = "APELLIDO1_CLIENTE")
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Sets the apellido1.
	 * 
	 * @param apellido1 the new apellido1
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	/**
	 * Gets the apellido2.
	 * 
	 * @return the apellido2
	 */
	@Column(name = "APELLIDO2_CLIENTE")
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Sets the apellido2.
	 * 
	 * @param apellido2 the new apellido2
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	/**
	 * Gets the sigla.
	 * 
	 * @return the sigla
	 */
	@Column(name = "SIGLA_CLIENTE")
	public String getSigla() {
		return sigla;
	}

	/**
	 * Sets the sigla.
	 * 
	 * @param sigla the new sigla
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	/**
	 * Gets the tipo cliente.
	 * 
	 * @return the tipo cliente
	 */
	@Column(name = "TIPO_CLIENTE")
	public Long getTipoCliente() {
		return tipoCliente;
	}

	/**
	 * Sets the tipo cliente.
	 * 
	 * @param tipoCliente the new tipo cliente
	 */
	public void setTipoCliente(Long tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	/**
	 * Gets the producto mm.
	 * 
	 * @return the producto mm
	 */
	@Column(name = "PRODUCTO_MM")
	public String getProductoMM() {
		return productoMM;
	}

	/**
	 * Sets the producto mm.
	 * 
	 * @param productoMM the new producto mm
	 */
	public void setProductoMM(String productoMM) {
		this.productoMM = productoMM;
	}
	
	/**
	 * Gets the valor mm.
	 * 
	 * @return the valor mm
	 */
	@Column(name = "VALOR_MM")
	public BigDecimal getValorMM() {
		return valorMM;
	}

	/**
	 * Sets the valor mm.
	 * 
	 * @param valorMM the new valor mm
	 */
	public void setValorMM(BigDecimal valorMM) {
		this.valorMM = valorMM;
	}
	
	/**
	 * Gets the disponible mm.
	 * 
	 * @return the disponible mm
	 */
	@Column(name = "DISPONIBLE_MM")
	public BigDecimal getDisponibleMM() {
		return disponibleMM;
	}

	/**
	 * Sets the disponible mm.
	 * 
	 * @param disponibleMM the new disponible mm
	 */
	public void setDisponibleMM(BigDecimal disponibleMM) {
		this.disponibleMM = disponibleMM;
	}
	
	/**
	 * Gets the utilizado mm.
	 * 
	 * @return the utilizado mm
	 */
	@Column(name = "UTILIZADO_MM")
	public BigDecimal getUtilizadoMM() {
		return utilizadoMM;
	}

	/**
	 * Sets the utilizado mm.
	 * 
	 * @param utilizadoMM the new utilizado mm
	 */
	public void setUtilizadoMM(BigDecimal utilizadoMM) {
		this.utilizadoMM = utilizadoMM;
	}
	
	/**
	 * Gets the estado mm.
	 * 
	 * @return the estado mm
	 */

	@Column(name="ESTADO_MM", precision=10, scale=0)
    @Enumerated(value=EnumType.ORDINAL)
	public EnumEstadoEntidad getEstadoMM() {
		return estadoMM;
	}

	/**
	 * Sets the estado mm.
	 * 
	 * @param estadoMM the new estado mm
	 */
	public void setEstadoMM(EnumEstadoEntidad estadoMM) {
		this.estadoMM = estadoMM;
	}
	
	/**
	 * Gets the moneda mm.
	 * 
	 * @return the moneda mm
	 */
	@Column(name = "MONEDA_MM")
	public String getMonedaMM() {
		return monedaMM;
	}

	/**
	 * Sets the moneda mm.
	 * 
	 * @param monedaMM the new moneda mm
	 */
	public void setMonedaMM(String monedaMM) {
		this.monedaMM = monedaMM;
	}
	
	/**
	 * Gets the nombre_gerente.
	 * 
	 * @return the nombre_gerente
	 */
	@Column(name = "NOMBRE_GERENTE_MM")
	public String getNombreGerente() {
		return nombreGerente;
	}

	/**
	 * Sets the nombre_gerente.
	 * 
	 * @param nombre_gerente the new nombre_gerente
	 */
	public void setNombreGerente(String nombreGerente) {
		this.nombreGerente = nombreGerente;
	}
	
	/**
	 * Gets the apellido1_gerente.
	 * 
	 * @return the apellido1_gerente
	 */
	@Column(name = "APELLIDO1_GERENTE_MM")
	public String getApellido1Gerente() {
		return apellido1Gerente;
	}

	/**
	 * Sets the apellido1_gerente.
	 * 
	 * @param apellido1_gerente the new apellido1_gerente
	 */
	public void setApellido1Gerente(String apellido1Gerente) {
		this.apellido1Gerente = apellido1Gerente;
	}
	
	/**
	 * Gets the apellido2_gerente.
	 * 
	 * @return the apellido2_gerente
	 */
	@Column(name = "APELLIDO2_GERENTE_MM")
	public String getApellido2Gerente() {
		return apellido2Gerente;
	}

	/**
	 * Sets the apellido2_gerente.
	 * 
	 * @param apellido2_gerente the new apellido2_gerente
	 */
	public void setApellido2Gerente(String apellido2Gerente) {
		this.apellido2Gerente = apellido2Gerente;
	}
	
	/**
	 * Gets the rol cliente.
	 * 
	 * @return the rol cliente
	 */
	@Column(name = "rol_cliente")
	public EnumRolCliente getRolCliente() {
		return rolCliente;
	}

	/**
	 * Sets the rol cliente.
	 * 
	 * @param rolCliente the new rol cliente
	 */
	public void setRolCliente(EnumRolCliente rolCliente) {
		this.rolCliente = rolCliente;
	}
	
	/**
	 * Gets the entidad financiera.
	 * 
	 * @return the entidad financiera
	 */
	@Column(name = "ENTIDAD_FINANCIERA")
	public Long getEntidadFinanciera() {
		return entidadFinanciera;
	}

	/**
	 * Sets the entidad financiera.
	 * 
	 * @param entidadFinanciera the new entidad financiera
	 */
	public void setEntidadFinanciera(Long entidadFinanciera) {
		this.entidadFinanciera = entidadFinanciera;
	}


	
	/**
	 * Obtener nombre cliente.
	 * 
	 * @return Nombre del Cliente
	 */
	@Transient
	public String obtenerNombreCliente()
	{
		if(this.tipoCliente==1)
			return this.sigla;
		else
			return this.nombre+" "+this.apellido1+" "+this.apellido2;
	}
	
}

