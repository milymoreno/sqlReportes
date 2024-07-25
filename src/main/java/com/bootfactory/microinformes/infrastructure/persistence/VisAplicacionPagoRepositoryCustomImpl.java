package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import com.bootfactory.microinformes.domain.model.entity.VisAplicacionPagoOperativo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class VisAplicacionPagoRepositoryCustomImpl implements VisAplicacionPagoRepositoryCustom{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Long contar(String referenciaPago, String nroObligacion, LocalDate fechaInicial, LocalDate fechaFinal,
			LocalDate fechaAplicacionContableInicial, LocalDate fechaAplicacionContableFinal,
			String descTipoIdentificacionComprador, String identificacionComprador, String descTipoIdentificacionVendedor,
			String identificacionVendedor) {
		
		StringBuilder queryString = new StringBuilder(
				"SELECT COUNT(a.V_ID) FROM V_APLICACION_PAGO a WHERE 1=1\r\n");
		
		if(referenciaPago!=null && !referenciaPago.equals("0")){
			queryString.append("AND a.REFERENCIAPAGO=:referenciaPago\r\n");
		}
		
		if (nroObligacion != null && !nroObligacion.equals("0")) {
			queryString.append("AND a.NUMERO=:nroObligacion\r\n");
		}

		if (fechaInicial != null ) {
			if( fechaFinal != null) {
				queryString.append("AND a.FECHA_APLICACION BETWEEN :fechaInicial AND :fechaFinal\r\n");
		}else {
			queryString.append("AND a.FECHA_APLICACION >= :fechaInicial\r\n");
		}
		}
			
		if (fechaAplicacionContableInicial != null ) {
			if( fechaAplicacionContableFinal != null) {
				queryString.append("AND a.FECHA_APLICACION_CONTABLE BETWEEN :fechaAplicacionContableInicial AND :fechaAplicacionContableFinal\r\n");
		}else {
			queryString.append("AND a.FECHA_APLICACION_CONTABLE >= :fechaAplicacionContableInicial\r\n");
		}	
		}
		
		if(descTipoIdentificacionComprador!=null && !descTipoIdentificacionComprador.equals("0")) {
			queryString.append("AND a.TI_COMPRADOR=:descTipoIdentificacionComprador\r\n");
		}
		
		if(identificacionComprador!=null && !identificacionComprador.equals("0")) {
			queryString.append("AND a.COMPRADOR_NUMID=:identificacionComprador\r\n");
		}
		
		
		if(descTipoIdentificacionVendedor!=null && !descTipoIdentificacionVendedor.equals("0")) {
			queryString.append("AND a.TI_VENDEDOR=:descTipoIdentificacionVendedor\r\n");
		}
		
		if(identificacionVendedor!=null && !identificacionVendedor.equals("0")) {
			queryString.append("AND a.VENDEDOR_NUMID=:identificacionVendedor\r\n");
		}

		Query query = entityManager.createNativeQuery(queryString.toString());
		
		if(referenciaPago!=null && !referenciaPago.equals("0")){
			query.setParameter("referenciaPago", referenciaPago);
		}
		
		if (nroObligacion != null && !nroObligacion.equals("0")) {
			query.setParameter("nroObligacion", nroObligacion);
		}

		if (fechaInicial != null ) {
			query.setParameter("fechaInicial", fechaInicial);
		}
		if( fechaFinal != null) {
			query.setParameter("fechaFinal", fechaFinal);
		
		}
			
		if (fechaAplicacionContableInicial != null ) {
			query.setParameter("fechaAplicacionContableInicial", fechaAplicacionContableInicial);
		}
		if( fechaAplicacionContableFinal != null) {
				query.setParameter("fechaAplicacionContableFinal", fechaAplicacionContableFinal);
		}
		
		
		if(descTipoIdentificacionComprador!=null && !descTipoIdentificacionComprador.equals("0")) {
			query.setParameter("descTipoIdentificacionComprador",descTipoIdentificacionComprador);
		}
		
		if(identificacionComprador!=null && !identificacionComprador.equals("0")) {
			query.setParameter("identificacionComprador",identificacionComprador);
		}
		
		
		if(descTipoIdentificacionVendedor!=null && !descTipoIdentificacionVendedor.equals("0")) {
			query.setParameter("descTipoIdentificacionVendedor",descTipoIdentificacionVendedor);
		}
		
		if(identificacionVendedor!=null && !identificacionVendedor.equals("0")) {
			query.setParameter("identificacionVendedor",identificacionVendedor);
		}
		
		return ((Number) query.getSingleResult()).longValue();
	}

	public List<VisAplicacionPagoOperativo> listarPaginado(String referenciaPago, String nroObligacion, LocalDate fechaInicial,
			LocalDate fechaFinal, LocalDate fechaAplicacionContableInicial, LocalDate fechaAplicacionContableFinal,
			String descTipoIdentificacionComprador, String identificacionComprador, String descTipoIdentificacionVendedor,
			String identificacionVendedor, int registroInicial, int registroFinal){
		
		StringBuilder queryString = new StringBuilder(
				"SELECT * FROM ( SELECT a.*, rownum as FilaExt FROM V_APLICACION_PAGO a WHERE 1=1\r\n");
		
		if(referenciaPago!=null && !referenciaPago.equals("0")){
			queryString.append("AND a.REFERENCIAPAGO=:referenciaPago\r\n");
		}
		
		if (nroObligacion != null && !nroObligacion.equals("0")) {
			queryString.append("AND a.NUMERO=:nroObligacion\r\n");
		}

		if (fechaInicial != null ) {
			if( fechaFinal != null) {
				queryString.append("AND a.FECHA_APLICACION BETWEEN :fechaInicial AND :fechaFinal\r\n");
		}else {
			queryString.append("AND a.FECHA_APLICACION >= :fechaInicial\r\n");
		}
		}
			
		if (fechaAplicacionContableInicial != null ) {
			if( fechaAplicacionContableFinal != null) {
				queryString.append("AND a.FECHA_APLICACION_CONTABLE BETWEEN :fechaAplicacionContableInicial AND :fechaAplicacionContableFinal\r\n");
		}else {
			queryString.append("AND a.FECHA_APLICACION_CONTABLE >= :fechaAplicacionContableInicial\r\n");
		}	
		}
		
		if(descTipoIdentificacionComprador!=null && !descTipoIdentificacionComprador.equals("0")) {
			queryString.append("AND a.TI_COMPRADOR=:descTipoIdentificacionComprador\r\n");
		}
		
		if(identificacionComprador!=null && !identificacionComprador.equals("0")) {
			queryString.append("AND a.COMPRADOR_NUMID=:identificacionComprador\r\n");
		}
		
		
		if(descTipoIdentificacionVendedor!=null && !descTipoIdentificacionVendedor.equals("0")) {
			queryString.append("AND a.TI_VENDEDOR=:descTipoIdentificacionVendedor\r\n");
		}
		
		if(identificacionVendedor!=null && !identificacionVendedor.equals("0")) {
			queryString.append("AND a.VENDEDOR_NUMID=:identificacionVendedor\r\n");
		}
		
		
		
		queryString.append(") WHERE FilaExt BETWEEN :registroInicial AND :registroFinal");

		Query query = entityManager.createNativeQuery(queryString.toString(),VisAplicacionPagoOperativo.class);
		
		if(referenciaPago!=null && !referenciaPago.equals("0")){
			query.setParameter("referenciaPago", referenciaPago);
		}
		
		if (nroObligacion != null && !nroObligacion.equals("0")) {
			query.setParameter("nroObligacion", nroObligacion);
		}

		if (fechaInicial != null ) {
			query.setParameter("fechaInicial", fechaInicial);
		}
		if( fechaFinal != null) {
			query.setParameter("fechaFinal", fechaFinal);
		
		}
			
		if (fechaAplicacionContableInicial != null ) {
			query.setParameter("fechaAplicacionContableInicial", fechaAplicacionContableInicial);
		}
		if( fechaAplicacionContableFinal != null) {
				query.setParameter("fechaAplicacionContableFinal", fechaAplicacionContableFinal);
		}
		
		
		if(descTipoIdentificacionComprador!=null && !descTipoIdentificacionComprador.equals("0")) {
			query.setParameter("descTipoIdentificacionComprador",descTipoIdentificacionComprador);
		}
		
		if(identificacionComprador!=null && !identificacionComprador.equals("0")) {
			query.setParameter("identificacionComprador",identificacionComprador);
		}
		
		
		if(descTipoIdentificacionVendedor!=null && !descTipoIdentificacionVendedor.equals("0")) {
			query.setParameter("descTipoIdentificacionVendedor",descTipoIdentificacionVendedor);
		}
		
		if(identificacionVendedor!=null && !identificacionVendedor.equals("0")) {
			query.setParameter("identificacionVendedor",identificacionVendedor);
		}
		
		query.setParameter("registroInicial", registroInicial);
		query.setParameter("registroFinal", registroFinal);
		
		return query.getResultList();
		
	}

	


}
