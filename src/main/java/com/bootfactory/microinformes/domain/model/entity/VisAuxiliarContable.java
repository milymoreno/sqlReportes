package com.bootfactory.microinformes.domain.model.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "V_AUXILIAR_CONTABLE")
public class VisAuxiliarContable {
	
	
		@Id
		@Column(name = "OBLIGACION")
		private String obligacion;
		
		@Column(name = "FECHA")
		private LocalDateTime  fechaAplicacionContable;
		
		@Column(name = "VALOR_CREDITO")
		private BigDecimal valorCredito;
		
		@Column(name = "VALOR_DEBITO")
		private BigDecimal valorDebito;
		
		@Column(name = "CUENTA_CONTABLE")
		private String cuentaContable;
		
		@Column(name = "CONCEPTO")
		private Long concepto;

		public String getObligacion() {
			return obligacion;
		}

		public void setObligacion(String obligacion) {
			this.obligacion = obligacion;
		}

		public LocalDateTime getFechaAplicacionContable() {
			return fechaAplicacionContable;
		}

		public void setFechaAplicacionContable(LocalDateTime fechaAplicacionContable) {
			this.fechaAplicacionContable = fechaAplicacionContable;
		}

		public BigDecimal getValorCredito() {
			return valorCredito;
		}

		public void setValorCredito(BigDecimal valorCredito) {
			this.valorCredito = valorCredito;
		}

		public BigDecimal getValorDebito() {
			return valorDebito;
		}

		public void setValorDebito(BigDecimal valorDebito) {
			this.valorDebito = valorDebito;
		}

		public String getCuentaContable() {
			return cuentaContable;
		}

		public void setCuentaContable(String cuentaContable) {
			this.cuentaContable = cuentaContable;
		}

		public Long getConcepto() {
			return concepto;
		}

		public void setConcepto(Long concepto) {
			this.concepto = concepto;
		}
		
		
		
	

}
