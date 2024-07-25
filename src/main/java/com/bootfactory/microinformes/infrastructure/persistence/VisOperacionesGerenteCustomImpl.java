package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.VisOperacionesGerenteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class VisOperacionesGerenteCustomImpl implements VisOperacionesGerenteCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<VisOperacionesGerenteDTO> listarPaginado(LocalDate fechaInicial, LocalDate fechaFinal, int registroInicial,
			int registroFinal) {
		StringBuilder queryString = new StringBuilder(
				"WITH distinctOperaciones AS ( SELECT distinct  FECHA AS fecha, TIPO_OPERACION AS  tipoOperacion, NUMERO_REFERENCIA AS numeroReferencia ,	NUMERO_OBLIGACION AS  numeroObligacion, PRODUCTO AS  producto, TIP_IDENT_DEUDOR AS  tipoIdent,	NUM_ID_DEUDOR AS  numId, NOMBRE_DEUDOR AS  nombre,VALOR AS valor,  CODIGO_GERENTE_RELACION AS  codigoGerenteRelacion, NOMBRE_GERENTE_RELACION AS  nombreGerenteRelacion, 	CODIGO_GERENTE_PRODUCTO AS  codigoGerenteProducto, 	NOMBRE_GERENTE_PRODUCTO AS  nombreGerenteProducto, APELLIDO1_DEUDOR AS apellido1, APELLIDO2_DEUDOR AS apellido2, SIGLA_DEUDOR AS sigla, TIPO_CLIENTE_DEUDOR AS tipoCliente "
				+ " FROM\r\n"
				+ "									 V_OPERACIONES_GERENTE  \r\n"
				+ "								where\r\n"
				+ "									1=1 \r\n");
		

		if (fechaInicial != null && fechaFinal != null) {
			queryString.append("AND FECHA BETWEEN :fechaInicial AND :fechaFinal "); 
		}
		
		queryString.append("), NumerosFilas AS (SELECT do.*, ROW_NUMBER() \r\n"
				+ "												OVER ( ORDER BY fecha asc, tipoOperacion asc ,numeroReferencia asc) AS FilaExt \r\n"
				+ "												FROM distinctOperaciones do)\r\n"
				+ "	SELECT * FROM NumerosFilas WHERE FilaExt BETWEEN :registroInicial AND :registroFinal");
		
		

		Query query = entityManager.createNativeQuery(queryString.toString(),VisOperacionesGerenteDTO.class);
		
		
	
		if (fechaInicial != null && fechaFinal != null) {
			query.setParameter("fechaInicial", fechaInicial);
			query.setParameter("fechaFinal", fechaFinal);
		}
		query.setParameter("registroInicial", registroInicial);
		query.setParameter("registroFinal", registroFinal);

		return query.getResultList();
	}

	@Override
	public Long contar(LocalDate fechaInicial, LocalDate fechaFinal) {
		StringBuilder queryString = new StringBuilder(
				"SELECT COUNT(*) AS totalRegistros\r\n"
				+ "FROM (\r\n"
				+ "    SELECT DISTINCT \r\n"
				+ "        FECHA, \r\n"
				+ "        TIPO_OPERACION, \r\n"
				+ "        NUMERO_REFERENCIA, \r\n"
				+ "        NUMERO_OBLIGACION, \r\n"
				+ "        PRODUCTO, \r\n"
				+ "        TIP_IDENT_DEUDOR, \r\n"
				+ "        NUM_ID_DEUDOR, \r\n"
				+ "        NOMBRE_DEUDOR, \r\n"
				+ "        VALOR, \r\n"
				+ "        CODIGO_GERENTE_RELACION, \r\n"
				+ "        NOMBRE_GERENTE_RELACION, \r\n"
				+ "        CODIGO_GERENTE_PRODUCTO, \r\n"
				+ "        NOMBRE_GERENTE_PRODUCTO, \r\n"
				+ "        APELLIDO1_DEUDOR, \r\n"
				+ "        APELLIDO2_DEUDOR, \r\n"
				+ "        SIGLA_DEUDOR, \r\n"
				+ "        TIPO_CLIENTE_DEUDOR\r\n"
				+ "    FROM\r\n"
				+ "        V_OPERACIONES_GERENTE            \r\n"
				+ "    WHERE\r\n"
				+ "        1=1\r\n"
				);

		if (fechaInicial != null && fechaFinal != null) {
			queryString.append("AND FECHA BETWEEN :fechaInicial AND :fechaFinal ");
		}

		queryString.append( ") ");
		Query query = entityManager.createNativeQuery(queryString.toString());

		if (fechaInicial != null && fechaFinal != null) {
			query.setParameter("fechaInicial", fechaInicial);
			query.setParameter("fechaFinal", fechaFinal);
		}
		
		
		
		return ((Number) query.getSingleResult()).longValue();
	}

}
	
	
	
	
