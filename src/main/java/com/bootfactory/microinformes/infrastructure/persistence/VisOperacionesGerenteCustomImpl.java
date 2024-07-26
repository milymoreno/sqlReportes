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
				"""
                WITH distinctOperaciones AS ( SELECT distinct  FECHA AS fecha, TIPO_OPERACION AS  tipoOperacion, NUMERO_REFERENCIA AS numeroReferencia ,	NUMERO_OBLIGACION AS  numeroObligacion, PRODUCTO AS  producto, TIP_IDENT_DEUDOR AS  tipoIdent,	NUM_ID_DEUDOR AS  numId, NOMBRE_DEUDOR AS  nombre,VALOR AS valor,  CODIGO_GERENTE_RELACION AS  codigoGerenteRelacion, NOMBRE_GERENTE_RELACION AS  nombreGerenteRelacion, 	CODIGO_GERENTE_PRODUCTO AS  codigoGerenteProducto, 	NOMBRE_GERENTE_PRODUCTO AS  nombreGerenteProducto, APELLIDO1_DEUDOR AS apellido1, APELLIDO2_DEUDOR AS apellido2, SIGLA_DEUDOR AS sigla, TIPO_CLIENTE_DEUDOR AS tipoCliente \
                 FROM
                									 V_OPERACIONES_GERENTE  
                								where
                									1=1 
                """);
		

		if (fechaInicial != null && fechaFinal != null) {
			queryString.append("AND FECHA BETWEEN :fechaInicial AND :fechaFinal "); 
		}
		
		queryString.append("""
                ), NumerosFilas AS (SELECT do.*, ROW_NUMBER() 
                												OVER ( ORDER BY fecha asc, tipoOperacion asc ,numeroReferencia asc) AS FilaExt 
                												FROM distinctOperaciones do)
                	SELECT * FROM NumerosFilas WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
                """);
		
		

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
				"""
                SELECT COUNT(*) AS totalRegistros
                FROM (
                    SELECT DISTINCT 
                        FECHA, 
                        TIPO_OPERACION, 
                        NUMERO_REFERENCIA, 
                        NUMERO_OBLIGACION, 
                        PRODUCTO, 
                        TIP_IDENT_DEUDOR, 
                        NUM_ID_DEUDOR, 
                        NOMBRE_DEUDOR, 
                        VALOR, 
                        CODIGO_GERENTE_RELACION, 
                        NOMBRE_GERENTE_RELACION, 
                        CODIGO_GERENTE_PRODUCTO, 
                        NOMBRE_GERENTE_PRODUCTO, 
                        APELLIDO1_DEUDOR, 
                        APELLIDO2_DEUDOR, 
                        SIGLA_DEUDOR, 
                        TIPO_CLIENTE_DEUDOR
                    FROM
                        V_OPERACIONES_GERENTE            
                    WHERE
                        1=1
                """
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
	
	
	
	
