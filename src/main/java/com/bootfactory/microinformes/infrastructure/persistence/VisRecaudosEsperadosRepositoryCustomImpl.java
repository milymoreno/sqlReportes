package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.RecaudosEsperadosDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class VisRecaudosEsperadosRepositoryCustomImpl implements VisRecaudosEsperadosRepositoryCustom{

	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RecaudosEsperadosDTO> listar(LocalDate fechaCorte) {
		StringBuilder queryString = new StringBuilder(
				"SELECT\r\n"
				+ "    CASE nombre_producto\r\n"
				+ "        WHEN 'ADC'                  THEN\r\n"
				+ "            'ADC'\r\n"
				+ "        WHEN 'CONFIRMING'           THEN\r\n"
				+ "            'CF'\r\n"
				+ "        WHEN 'DESCUENTO DE TITULOS' THEN\r\n"
				+ "            'TV'\r\n"
				+ "        WHEN 'LINEA TRIANGULAR'     THEN\r\n"
				+ "            'LT'\r\n"
				+ "    END                    AS producto,\r\n"
				+ "    SUM(capital)           AS capital,\r\n"
				+ "    SUM(interes_corriente) AS interesCorrientes,\r\n"
				+ "    SUM(interes_mora)      AS interesMora,\r\n"
				+ "    SUM(otros)             AS otros,\r\n"
				+ "    SUM(total)             AS total\r\n"
				+ "FROM\r\n"
				+ "    v_recaudos_esperados\r\n"
				+ "WHERE\r\n"
				+ "        estado_obligacion = 0\r\n"
				 );
		

		if (fechaCorte != null ) {
			queryString.append("AND FECHA_VENCIMIENTO= :fechaCorte\r\n");                                                                              
		}
		
		queryString.append("GROUP BY ( nombre_producto)\r\n");
		
		
		

		Query query = entityManager.createNativeQuery(queryString.toString(),RecaudosEsperadosDTO.class);
		
		
	
		if (fechaCorte != null) {
			query.setParameter("fechaCorte", fechaCorte);
		}
		

		return query.getResultList();
	}
}
