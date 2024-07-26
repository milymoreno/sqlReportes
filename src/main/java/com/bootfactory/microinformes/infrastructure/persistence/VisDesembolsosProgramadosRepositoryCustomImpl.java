package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.DesembolsosProgramadosDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class VisDesembolsosProgramadosRepositoryCustomImpl implements VisDesembolsosProgramadosRepositoryCustom{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DesembolsosProgramadosDTO> listar(LocalDate fechaCorte) {
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
                    count(titulo_id)           AS cantidad,
                    sum(valor_titulo) AS total
                FROM
                    V_DESEMBOLSOS_PROGRAMADOS
                WHERE
                        ESTADO_TITULO = 2
                """
				 );
		

		if (fechaCorte != null ) {
			queryString.append("AND FECHA_PAGO= :fechaCorte\r\n");                                                                              
		}
		
		queryString.append("GROUP BY ( nombre_producto)\r\n");
		
		
		

		Query query = entityManager.createNativeQuery(queryString.toString(),DesembolsosProgramadosDTO.class);
		
		
	
		if (fechaCorte != null) {
			query.setParameter("fechaCorte", fechaCorte);
		}
		

		return query.getResultList();
	}

}
