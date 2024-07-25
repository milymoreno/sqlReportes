package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import com.bootfactory.microinformes.domain.model.entity.VisIntereses;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class VisInteresesRepositoryCustomImpl implements VisInteresesRepositoryCustom {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long contar(Boolean esReporteMora,LocalDate fechaInicial, LocalDate fechaFinal, String nroObligacion,String nombreProducto) {

		StringBuilder queryString = new StringBuilder(
				"SELECT COUNT(a.ID_VISTA) FROM V_INTERESES a WHERE 1=1\r\n");
		
		if(esReporteMora) {
			queryString.append("AND a.INTERESES_MORA_DIA<>0\r\n");
		}else {
			queryString.append("AND a.INTERESES_DIA<>0\r\n");
		}

		if (nroObligacion != null && !nroObligacion.equals("0")) {
			queryString.append("AND a.NUMERO_OBLIGACION=:nroObligacion\r\n");
		}

		if (fechaInicial != null ) {
			if( fechaFinal != null) {
				queryString.append("AND a.FECHA_CAUSACION BETWEEN :fechaInicial AND :fechaFinal\r\n");
		}else {
			queryString.append("AND a.FECHA_CAUSACION >= :fechaInicial\r\n");
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
	public List<VisIntereses> listarPaginado(Boolean esReporteMora, LocalDate fechaInicial, LocalDate fechaFinal,
			String nroObligacion,String nombreProducto, int registroInicial, int registroFinal) {

		StringBuilder queryString = new StringBuilder(
				"WITH NumerosFilas AS (SELECT a.*, ROW_NUMBER() OVER (ORDER BY  a.FECHA_CAUSACION  ASC,NUMERO_OBLIGACION asc ) AS FilaExt  FROM V_INTERESES a where 1=1\r\n");
		
		if(esReporteMora) {
			queryString.append("AND a.INTERESES_MORA_DIA<>0\r\n");
		}else {
			queryString.append("AND a.INTERESES_DIA<>0\r\n");
		}
		
		if (nroObligacion != null && !nroObligacion.equals("0")) {
			queryString.append("AND a.NUMERO_OBLIGACION=:nroObligacion\r\n");
		}

		if (fechaInicial != null ) {
			if( fechaFinal != null) {
				queryString.append("AND a.FECHA_CAUSACION BETWEEN :fechaInicial AND :fechaFinal\r\n");
		}else {
			queryString.append("AND a.FECHA_CAUSACION >= :fechaInicial\r\n");
		}
		}
		
		if(nombreProducto!=null && !nombreProducto.equals("0")) {
			queryString.append("AND a.NOMBRE_PRODUCTO=:nombreProducto\r\n");
		}
		
		queryString.append(") SELECT * FROM NumerosFilas WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\r\n");

		Query query = entityManager.createNativeQuery(queryString.toString(), VisIntereses.class);

		
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
