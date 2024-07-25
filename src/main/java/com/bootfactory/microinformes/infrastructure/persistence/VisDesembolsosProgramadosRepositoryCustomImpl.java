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
				+ "    count(titulo_id)           AS cantidad,\r\n"
				+ "    sum(valor_titulo) AS total\r\n"
				+ "FROM\r\n"
				+ "    V_DESEMBOLSOS_PROGRAMADOS\r\n"
				+ "WHERE\r\n"
				+ "        ESTADO_TITULO = 2\r\n"
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
