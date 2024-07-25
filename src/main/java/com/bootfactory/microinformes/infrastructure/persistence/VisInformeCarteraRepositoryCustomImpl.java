package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.VisOperacionesGerenteDTO;
import com.bootfactory.microinformes.domain.model.entity.VisInformeCartera;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoObligacion;
import com.bootfactory.microinformes.domain.model.enums.EnumRolCliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class VisInformeCarteraRepositoryCustomImpl implements VisInformeCarteraRepositoryCustom{
	
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<VisInformeCartera> listarPaginado(Long idEntidadFinanciera, String descripcionTipoIdentificacion, String identificacion, EnumRolCliente rolCliente,
			EnumEstadoObligacion estadoObligacion, int registroInicial, int registroFinal) {
		StringBuilder queryString = new StringBuilder(
				"SELECT * FROM (SELECT cartera.*,ROW_NUMBER() OVER (ORDER BY  cartera.OBLIGACION  ASC) AS FilaExt FROM V_INFORME_CARTERA cartera WHERE 1=1\r\n");
		
		
		
		if (rolCliente != null ) {
			queryString.append("AND ROL_CLIENTE= :rolCliente\r\n");
		}
		
		if (estadoObligacion != null ) {
			queryString.append("AND ESTADO_OBLIGACION= :estadoObligacion\r\n");
		}
		
		if (idEntidadFinanciera != null ) {
			queryString.append("AND ENTIDAD_FINANCIERA= :idEntidadFinanciera\r\n");
		}
		
		
		if (descripcionTipoIdentificacion != null ) {
			queryString.append("AND TIDENT_CLIENTE= :descripcionTipoIdentificacion\r\n");
		}
		
		if (identificacion != null ) {
			queryString.append("AND NUMID_CLIENTE= :identificacion\r\n");
		}
		
		queryString.append(")\r\n"
				+ "        WHERE FilaExt BETWEEN :registroInicial AND :registroFinal");
		

		Query query = entityManager.createNativeQuery(queryString.toString(),VisInformeCartera.class);
		
		
		
		if (rolCliente != null ) {
			query.setParameter("rolCliente", rolCliente);
		}
		if (estadoObligacion != null ) {
			query.setParameter("estadoObligacion", estadoObligacion);
		}
		if (idEntidadFinanciera != null ) {
			query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		}
		
		
		if (descripcionTipoIdentificacion != null ) {
			query.setParameter("descripcionTipoIdentificacion", descripcionTipoIdentificacion);
		}
		
		if (identificacion != null ) {
			query.setParameter("identificacion", identificacion);
		}
			


		query.setParameter("registroInicial", registroInicial);
		query.setParameter("registroFinal", registroFinal);

		return query.getResultList();
	}
	
	
	@Override
	public Long contar(Long idEntidadFinanciera, String descripcionTipoIdentificacion, String identificacion, EnumRolCliente rolCliente,
			EnumEstadoObligacion estadoObligacion) {
		StringBuilder queryString = new StringBuilder(
				"SELECT COUNT(*) FROM V_INFORME_CARTERA WHERE 1=1\r\n"
				);

		if (rolCliente != null ) {
			queryString.append("AND ROL_CLIENTE= :rolCliente\r\n ");
		}
		
		if (estadoObligacion != null ) {
			queryString.append("AND ESTADO_OBLIGACION= :estadoObligacion\r\n");
		}
		
		if (idEntidadFinanciera != null ) {
			queryString.append("AND ENTIDAD_FINANCIERA= :idEntidadFinanciera\r\n");
		}
		
		
		if (descripcionTipoIdentificacion != null ) {
			queryString.append("AND TIDENT_CLIENTE= :descripcionTipoIdentificacion\r\n");
		}
		
		if (identificacion != null ) {
			queryString.append("AND NUMID_CLIENTE= :identificacion\r\n");
		}
		
		Query query = entityManager.createNativeQuery(queryString.toString());

		if (rolCliente != null ) {
			query.setParameter("rolCliente", rolCliente);
		}
		if (estadoObligacion != null ) {
			query.setParameter("estadoObligacion", estadoObligacion);
		}
		if (idEntidadFinanciera != null ) {
			query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		}
		
		
		if (descripcionTipoIdentificacion != null ) {
			query.setParameter("descripcionTipoIdentificacion", descripcionTipoIdentificacion);
		}
		
		if (identificacion != null ) {
			query.setParameter("identificacion", identificacion);
		}
		
				
		return ((Number) query.getSingleResult()).longValue();
	}

}
