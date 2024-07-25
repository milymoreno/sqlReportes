package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.bootfactory.microinformes.domain.model.entity.VisAuxiliarContable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class VisAuxiliarContableRepositoryCustomImpl implements VisAuxiliarContableRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long contar(LocalDate fechaInicial, LocalDate fechaFinal, String nroObligacion) {

		StringBuilder queryString = new StringBuilder(
				"SELECT COUNT(aux.OBLIGACION) FROM V_AUXILIAR_CONTABLE aux WHERE 1=1");

		if (nroObligacion != null && !nroObligacion.equals("0")) {
			queryString.append("AND aux.OBLIGACION=:nroObligacion ");
		}

		if (fechaInicial != null && fechaFinal != null) {
			queryString.append("AND aux.FECHA BETWEEN :fechaInicial AND :fechaFinal ");
		}

		Query query = entityManager.createNativeQuery(queryString.toString());

		if (nroObligacion != null && !nroObligacion.equals("0")) {
			query.setParameter("nroObligacion", nroObligacion);
		}

		if (fechaInicial != null && fechaFinal != null) {
			query.setParameter("fechaInicial", fechaInicial);
			query.setParameter("fechaFinal", fechaFinal);
		}
		return ((Number) query.getSingleResult()).longValue();

	}

	@Override
	public List<VisAuxiliarContable> listarPaginado(LocalDate fechaInicial, LocalDate fechaFinal,
			String nroObligacion, int registroInicial, int registroFinal) {

		StringBuilder queryString = new StringBuilder(
				"WITH NumerosFilas AS (SELECT aux.*, ROW_NUMBER() OVER (ORDER BY  aux.CUENTA_CONTABLE  ASC) AS FilaExt  FROM V_AUXILIAR_CONTABLE aux where 1=1 ");
		
		if (nroObligacion != null && !nroObligacion.equals("0")) {
			queryString.append("AND aux.OBLIGACION=:nroObligacion ");
		}

		if (fechaInicial != null && fechaFinal != null) {
			queryString.append("AND aux.FECHA BETWEEN :fechaInicial AND :fechaFinal ");
		}
		
		queryString.append(")SELECT * FROM NumerosFilas WHERE FilaExt BETWEEN :registroInicial AND :registroFinal");

		Query query = entityManager.createNativeQuery(queryString.toString(), VisAuxiliarContable.class);

		
		if (nroObligacion != null && !nroObligacion.equals("0")) {
			query.setParameter("nroObligacion", nroObligacion);
		}
		if (fechaInicial != null && fechaFinal != null) {
			query.setParameter("fechaInicial", fechaInicial);
			query.setParameter("fechaFinal", fechaFinal);
		}
		query.setParameter("registroInicial", registroInicial);
		query.setParameter("registroFinal", registroFinal);

		return query.getResultList();
	}

}
