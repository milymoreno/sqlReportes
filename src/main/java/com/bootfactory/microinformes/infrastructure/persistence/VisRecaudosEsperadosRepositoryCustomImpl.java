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
				"""
                SELECT
                    CASE nombre_producto
                        WHEN 'ADC'                  THEN
                            'ADC'
                        WHEN 'CONFIRMING'           THEN
                            'CF'
                        WHEN 'DESCUENTO DE TITULOS' THEN
                            'TV'
                        WHEN 'LINEA TRIANGULAR'     THEN
                            'LT'
                    END                    AS producto,
                    SUM(capital)           AS capital,
                    SUM(interes_corriente) AS interesCorrientes,
                    SUM(interes_mora)      AS interesMora,
                    SUM(otros)             AS otros,
                    SUM(total)             AS total
                FROM
                    v_recaudos_esperados
                WHERE
                        estado_obligacion = 0
                """
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
