package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import com.bootfactory.microinformes.domain.model.entity.VisAmortizacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class VisAmortizacionRepositoryCustomImpl implements VisAmortizacionRepositoryCustom{
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long contar(LocalDate fechaInicial, LocalDate fechaFinal, String nroObligacion,String nombreProducto) {

		StringBuilder queryString = new StringBuilder(
				"SELECT COUNT(a.ID_VISTA) FROM V_AMORTIZACION a WHERE 1=1\r\n");

		if (nroObligacion != null && !nroObligacion.equals("0")) {
			queryString.append("AND a.NUMERO_OBLIGACION=:nroObligacion\r\n");
		}

		if (fechaInicial != null ) {
			if( fechaFinal != null) {
				queryString.append("AND a.FECHA_AMORTIZACION BETWEEN :fechaInicial AND :fechaFinal\r\n");
		}else {
			queryString.append("AND a.FECHA_AMORTIZACION >= :fechaInicial\r\n");
		}
		}
		
		if(nombreProducto!=null && !nombreProducto.equals("0")) {
			queryString.append("AND a.NOMBRE_PRODUCTO=:nombreProducto\r\n");
		}

		Query query = entityManager.createNativeQuery(queryString.toString());

		if (nroObligacion != null && !nroObligacion.equals("0")) {
			query.setParameter("nroObligacion", nroObligacion);
		}

		if (fechaInicial != null) { 
			query.setParameter("fechaInicial", fechaInicial);
			
		}
		if(fechaFinal != null)  {
			query.setParameter("fechaFinal", fechaFinal);
		}
		if(nombreProducto!=null && !nombreProducto.equals("0")) {
			query.setParameter("nombreProducto", nombreProducto);
		}
		return ((Number) query.getSingleResult()).longValue();

	}

	@Override
	public List<VisAmortizacion> listarPaginado(LocalDate fechaInicial, LocalDate fechaFinal,
			String nroObligacion,String nombreProducto, int registroInicial, int registroFinal) {

		StringBuilder queryString = new StringBuilder(
				"WITH NumerosFilas AS (SELECT a.*, ROW_NUMBER() OVER (ORDER BY  a.FECHA_AMORTIZACION  ASC,NUMERO_OBLIGACION asc ) AS FilaExt  FROM V_AMORTIZACION a where 1=1 ");
		
		if (nroObligacion != null && !nroObligacion.equals("0")) {
			queryString.append("AND a.NUMERO_OBLIGACION=:nroObligacion\r\n");
		}

		if (fechaInicial != null ) {
			if( fechaFinal != null) {
				queryString.append("AND a.FECHA_AMORTIZACION BETWEEN :fechaInicial AND :fechaFinal\r\n");
		}else {
			queryString.append("AND a.FECHA_AMORTIZACION >= :fechaInicial\r\n");
		}
		}
		
		if(nombreProducto!=null && !nombreProducto.equals("0")) {
			queryString.append("AND a.NOMBRE_PRODUCTO=:nombreProducto\r\n");
		}
		
		queryString.append(") SELECT * FROM NumerosFilas WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\r\n");

		Query query = entityManager.createNativeQuery(queryString.toString(), VisAmortizacion.class);

		
		if (nroObligacion != null && !nroObligacion.equals("0")) {
			query.setParameter("nroObligacion", nroObligacion);
		}

		if (fechaInicial != null) { 
			query.setParameter("fechaInicial", fechaInicial);
			
		}
		if(fechaFinal != null)  {
			query.setParameter("fechaFinal", fechaFinal);
		}
		if(nombreProducto!=null && !nombreProducto.equals("0")) {
			query.setParameter("nombreProducto", nombreProducto);
		}
		query.setParameter("registroInicial", registroInicial);
		query.setParameter("registroFinal", registroFinal);

		return query.getResultList();
	}

}
