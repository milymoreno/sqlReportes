package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.TipoIdentificacionDTO;
import com.bootfactory.microinformes.domain.model.entity.Cliente;
import com.bootfactory.microinformes.domain.model.enums.EnumCausalBloqueo;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoEntidad;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ClienteRepositoryCustomImpl implements ClienteRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long contarPagadores(Long idEntidadFinanciera, EnumEstadoEntidad estado, Long tipoIdentificacion,
			String identificacion, String nombre) {
		StringBuilder queryString = new StringBuilder("""
                SELECT COUNT(DISTINCT c.ID) 
                FROM V_ESTADO_MM v 
                JOIN CLIENTE c ON c.NUMID=v.NUM_ID_CLIENTE
                JOIN TIDENT t on t.ID=c.TIPOIDENTIFICACION_ID
                WHERE c.ESTADO=:estado
                AND c.ENTIDADFINANCIERA_ID=:idEntidadFinanciera 
                AND c.ESFUENTEPAGO=1
                """);

		if (tipoIdentificacion != 0) {
			queryString.append("and t.CODIGO=:tipoIdentificacion ");
		}

		if (!identificacion.equals("0")) {
			queryString.append("AND lower(c.numId) like concat(lower(:identificacion),'%')");
		}

		if (!nombre.equals("0")) {
			queryString.append("""
                    AND ( lower(c.NOMBRE) like concat(lower(:nombre),'%') \
                     OR lower(c.APELLIDO1) like concat(lower(:nombre),'%') \
                     OR lower(c.APELLIDO2) like concat(lower(:nombre),'%') \
                     OR lower(c.SIGLA) like concat(lower(:nombre),'%') )\
                    """);
		}

		Query query = entityManager.createNativeQuery(queryString.toString());

		query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		query.setParameter("estado", estado);
		if (tipoIdentificacion != 0) {
			query.setParameter("tipoIdentificacion", tipoIdentificacion);
		}

		if (!identificacion.equals("0")) {
			query.setParameter("identificacion", identificacion);
		}

		if (!nombre.equals("0")) {
			query.setParameter("nombre", nombre);
		}

		return ((Number) query.getSingleResult()).longValue();

	}

	@Override
	public List<Cliente> listarPagadores(Long idEntidadFinanciera, EnumEstadoEntidad estado, Long tipoIdentificacion,
			String identificacion, String nombre, int registroInicial, int numeroRegistros) {
		StringBuilder queryString = new StringBuilder(
				"""
                WITH distinctClientes AS( SELECT distinct c.* ,tident.descripcion FROM Cliente c 
                JOIN tident ON tident.id=c.tipoidentificacion_id 
                INNER JOIN v_estado_mm v ON c.NUMID=v.NUM_ID_CLIENTE
                WHERE
                 c.estado=:estado
                 AND c.ENTIDADFINANCIERA_ID=:idEntidadFinanciera
                 AND  c.ESFUENTEPAGO=1\
                """);

		if (tipoIdentificacion != 0) {
			queryString.append("and tident.codigo=:tipoIdentificacion ");
		}

		if (!identificacion.equals("0")) {
			queryString.append("AND lower(c.numId) like concat(lower(:identificacion),'%')");
		}

		if (!nombre.equals("0")) {
			queryString.append("""
                    and ( lower(c.nombre) like concat(lower(:nombre),'%') \
                     or lower(c.apellido1) like concat(lower(:nombre),'%') \
                     or lower(c.apellido2) like concat(lower(:nombre),'%') \
                    or lower(c.sigla) like concat(lower(:nombre),'%') )\
                    """);
		}

		queryString.append("""
                 ORDER BY tident.descripcion asc, c.NUMID asc),
                NumerosFilas AS (
                    SELECT 
                        dc.*,         
                        ROW_NUMBER() OVER (ORDER BY  dc.numId ASC) AS FilaExt
                    FROM 
                        DistinctClientes dc
                )
                SELECT *
                FROM NumerosFilas
                WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
                """);

		Query query = entityManager.createNativeQuery(queryString.toString(), Cliente.class);

		query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		query.setParameter("estado", estado);
		query.setParameter("registroInicial", registroInicial);
		query.setParameter("registroFinal", numeroRegistros);
		if (tipoIdentificacion != 0) {
			query.setParameter("tipoIdentificacion", tipoIdentificacion);
		}

		if (!identificacion.equals("0")) {
			query.setParameter("identificacion", identificacion);
		}

		if (!nombre.equals("0")) {
			query.setParameter("nombre", nombre);
		}

		return query.getResultList();
	}

	@Override
	public Long contarDeudores(Long idEntidadFinanciera, EnumEstadoEntidad estado, Long tipoIdentificacion,
			String identificacion, String nombre) {
		StringBuilder queryString = new StringBuilder("""
                SELECT COUNT(DISTINCT c.ID)
                FROM V_ESTADO_VMD v 
                JOIN CLIENTE c ON c.NUMID=v.NUM_ID_CLIENTE
                JOIN TIDENT t on t.ID=c.TIPOIDENTIFICACION_ID
                WHERE c.ESTADO=:estado
                AND c.ENTIDADFINANCIERA_ID=:idEntidadFinanciera 
                AND c.ESDEUDOR=1
                """);

		if (tipoIdentificacion != 0) {
			queryString.append("and t.codigo=:tipoIdentificacion ");
		}

		if (!identificacion.equals("0")) {
			queryString.append("AND lower(c.numId) like concat(lower(:identificacion),'%')");
		}

		if (!nombre.equals("0")) {
			queryString.append("""
                    and ( lower(c.nombre) like concat(lower(:nombre),'%') \
                     or lower(c.apellido1) like concat(lower(:nombre),'%') \
                     or lower(c.apellido2) like concat(lower(:nombre),'%') \
                    or lower(c.sigla) like concat(lower(:nombre),'%') )\
                    """);
		}

		Query query = entityManager.createNativeQuery(queryString.toString());

		query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		query.setParameter("estado", estado);
		if (tipoIdentificacion != 0) {
			query.setParameter("tipoIdentificacion", tipoIdentificacion);
		}

		if (!identificacion.equals("0")) {
			query.setParameter("identificacion", identificacion);
		}

		if (!nombre.equals("0")) {
			query.setParameter("nombre", nombre);
		}

		return ((Number) query.getSingleResult()).longValue();

	}

	@Override
	public List<Cliente> listarDeudores(Long idEntidadFinanciera, EnumEstadoEntidad estado, Long tipoIdentificacion,
			String identificacion, String nombre, int registroInicial, int numeroRegistros) {
		StringBuilder queryString = new StringBuilder(
				"""
                WITH distinctClientes AS( SELECT distinct c.* ,tident.descripcion FROM Cliente c 
                JOIN tident ON tident.id=c.tipoidentificacion_id 
                INNER JOIN v_estado_vmd v ON c.id=v.id_cliente
                WHERE
                 c.estado=:estado
                 AND c.ENTIDADFINANCIERA_ID=:idEntidadFinanciera
                 AND c.ESDEUDOR=1\
                """);

		if (tipoIdentificacion != 0) {
			queryString.append("and tident.codigo=:tipoIdentificacion ");
		}

		if (!identificacion.equals("0")) {
			queryString.append("AND lower(c.numId) like concat(lower(:identificacion),'%')");
		}

		if (!nombre.equals("0")) {
			queryString.append("""
                    and ( lower(c.nombre) like concat(lower(:nombre),'%') \
                     or lower(c.apellido1) like concat(lower(:nombre),'%') \
                     or lower(c.apellido2) like concat(lower(:nombre),'%') \
                    or lower(c.sigla) like concat(lower(:nombre),'%') )\
                    """);
		}

		queryString.append("""
                 ORDER BY tident.descripcion asc, c.NUMID asc),
                NumerosFilas AS (
                    SELECT 
                        dc.*,         
                        ROW_NUMBER() OVER (ORDER BY  dc.numId ASC) AS FilaExt
                    FROM 
                        DistinctClientes dc
                )
                SELECT *
                FROM NumerosFilas
                WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
                """);

		Query query = entityManager.createNativeQuery(queryString.toString(), Cliente.class);

		query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		query.setParameter("estado", estado);
		query.setParameter("registroInicial", registroInicial);
		query.setParameter("registroFinal", numeroRegistros);
		if (tipoIdentificacion != 0) {
			query.setParameter("tipoIdentificacion", tipoIdentificacion);
		}

		if (!identificacion.equals("0")) {
			query.setParameter("identificacion", identificacion);
		}

		if (!nombre.equals("0")) {
			query.setParameter("nombre", nombre);
		}

		return query.getResultList();

	}

	@Override
	public Long contarClientesNoADC(Long idEntidadFinanciera, EnumEstadoEntidad estado, EnumCausalBloqueo causabloqueo,
			EnumCausalBloqueo causalistaexcep, Long tipoIdentificacion, String identificacion, String nombre) {
		StringBuilder queryString = new StringBuilder("""
                SELECT count(c.id) FROM Cliente c \
                JOIN tident on tident.id=c.tipoidentificacion_id \
                WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera 
                AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado
                AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))
                AND c.estado = :estado 
                AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
                JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
                JOIN producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado
                AND producto.id=8749)
                """);

		if (tipoIdentificacion != 0) {
			queryString.append("AND tident.codigo=:tipoIdentificacion\r\n");
		}

		if (!identificacion.equals("0")) {
			queryString.append("AND lower(c.numId) like concat(lower(:identificacion),'%')");
		}
		if (!nombre.equals("0")) {
			queryString.append("""
                    and ( lower(c.nombre) like concat(lower(:nombre),'%') \
                     or lower(c.apellido1) like concat(lower(:nombre),'%') \
                     or lower(c.apellido2) like concat(lower(:nombre),'%') \
                    or lower(c.sigla) like concat(lower(:nombre),'%') )
                    """);
		}

		Query query = entityManager.createNativeQuery(queryString.toString());

		query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		query.setParameter("estado", estado);
		query.setParameter("causabloqueo", causabloqueo);
		query.setParameter("causalistaexcep", causalistaexcep);
		if (tipoIdentificacion != 0) {
			query.setParameter("tipoIdentificacion", tipoIdentificacion);
		}

		if (!identificacion.equals("0")) {
			query.setParameter("identificacion", identificacion);
		}

		if (!nombre.equals("0")) {
			query.setParameter("nombre", nombre);
		}

		return ((Number) query.getSingleResult()).longValue();
	}

	@Override
	public List<Cliente> listarClientesNoADC(Long idEntidadFinanciera, EnumEstadoEntidad estado,
			EnumCausalBloqueo causabloqueo, EnumCausalBloqueo causalistaexcep, Long tipoIdentificacion,
			String identificacion, String nombre, int registroInicial, int numeroRegistros) {
		StringBuilder queryString = new StringBuilder("""
                SELECT * FROM (SELECT c.*,ROW_NUMBER() OVER(
                       ORDER BY
                            tident.descripcion asc,
                            c.NUMID asc)as FilaExt FROM Cliente c \
                JOIN tident on tident.id=c.tipoidentificacion_id \
                WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera
                AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado
                AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))
                AND c.estado = :estado
                AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
                JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
                JOIN producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado
                AND producto.id=8749)
                """);

		if (tipoIdentificacion != 0) {
			queryString.append("AND tident.codigo=:tipoIdentificacion\r\n");
		}

		if (!identificacion.equals("0")) {
			queryString.append("AND lower(c.numId) like concat(lower(:identificacion),'%')");
		}

		if (!nombre.equals("0")) {
			queryString.append("""
                    and ( lower(c.nombre) like concat(lower(:nombre),'%') \
                     or lower(c.apellido1) like concat(lower(:nombre),'%') \
                     or lower(c.apellido2) like concat(lower(:nombre),'%') \
                    or lower(c.sigla) like concat(lower(:nombre),'%') )
                    """);
		}

		queryString.append(
				" ORDER BY tident.descripcion asc,c.NUMID asc) WHERE FilaExt BETWEEN :registroInicial AND :registroFinal");

		Query query = entityManager.createNativeQuery(queryString.toString(), Cliente.class);

		query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		query.setParameter("estado", estado);
		query.setParameter("causabloqueo", causabloqueo);
		query.setParameter("causalistaexcep", causalistaexcep);
		query.setParameter("registroInicial", registroInicial);
		query.setParameter("registroFinal", numeroRegistros);
		if (tipoIdentificacion != 0) {
			query.setParameter("tipoIdentificacion", tipoIdentificacion);
		}

		if (!identificacion.equals("0")) {
			query.setParameter("identificacion", identificacion);
		}

		if (!nombre.equals("0")) {
			query.setParameter("nombre", nombre);
		}

		return query.getResultList();
	}

	public Long contarClientes(Long idEntidadFinanciera, Long codTipoIdentificacion, String identificacion,
			EnumEstadoEntidad estado, String nombre) {
		StringBuilder queryString = new StringBuilder("""
                SELECT count(c.id)
                				FROM CLIENTE c inner JOIN TIDENT ON TIDENT.ID=c.TIPOiDENTIFICACION_ID
                				WHERE 1=1
                """);

		if (idEntidadFinanciera != null && idEntidadFinanciera != 0) {
			queryString.append("AND c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera \r\n");
		}

		if (estado != null) {
			queryString.append("AND c.ESTADO = :estado \r\n");
		}
		if (codTipoIdentificacion != null && codTipoIdentificacion != 0) {
			queryString.append("AND tident.codigo=:codTipoIdentificacion\r\n");
		}

		if (identificacion != null && !identificacion.equals("0")) {
			queryString.append("AND lower(c.numId) like concat(lower(:identificacion),'%')\r\n");
		}

		if (nombre != null && !nombre.equals("0")) {
			queryString.append("""
                    and ( lower(c.nombre) like concat(lower(:nombre),'%') \
                     or lower(c.apellido1) like concat(lower(:nombre),'%') \
                     or lower(c.apellido2) like concat(lower(:nombre),'%') \
                    or lower(c.sigla) like concat(lower(:nombre),'%') )
                    """);
		}

		Query query = entityManager.createNativeQuery(queryString.toString());

		if (idEntidadFinanciera != null && idEntidadFinanciera != 0) {
			query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		}

		if (estado != null) {
			query.setParameter("estado", estado);
		}

		if (codTipoIdentificacion != null && codTipoIdentificacion != 0) {
			query.setParameter("codTipoIdentificacion", codTipoIdentificacion);
		}

		if (identificacion != null && !identificacion.equals("0")) {
			query.setParameter("identificacion", identificacion);
		}

		if (nombre != null && !nombre.equals("0")) {
			query.setParameter("nombre", nombre);
		}

		return ((Number) query.getSingleResult()).longValue();
	}

	public List<Cliente> listarClientesPaginado(Long idEntidadFinanciera, Long codTipoIdentificacion,
			String identificacion, EnumEstadoEntidad estado, String nombre, int registroInicial, int numeroRegistros) {
		StringBuilder queryString = new StringBuilder(
				"""
                SELECT * from (SELECT c.*,ROW_NUMBER() OVER (ORDER BY  tident.descripcion asc,c.NUMID asc) AS FilaExt
                FROM CLIENTE c  JOIN TIDENT ON TIDENT.ID=c.TIPOiDENTIFICACION_ID
                	WHERE 1=1
                """);

		if (idEntidadFinanciera != null && idEntidadFinanciera != 0) {
			queryString.append("AND c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera \r\n");
		}

		if (estado != null) {
			queryString.append("AND c.ESTADO = :estado \r\n");
		}
		if (codTipoIdentificacion != null && codTipoIdentificacion != 0) {
			queryString.append("AND tident.codigo=:codTipoIdentificacion\r\n");
		}

		if (identificacion != null && !identificacion.equals("0")) {
			queryString.append("AND lower(c.numId) like concat(lower(:identificacion),'%')\r\n");
		}

		if (nombre != null && !nombre.equals("0")) {
			queryString.append("""
                    and ( lower(c.nombre) like concat(lower(:nombre),'%') \
                     or lower(c.apellido1) like concat(lower(:nombre),'%') \
                     or lower(c.apellido2) like concat(lower(:nombre),'%') \
                    or lower(c.sigla) like concat(lower(:nombre),'%') )
                    """);
		}

		queryString.append(") WHERE FilaExt BETWEEN :registroInicial AND :registroFinal");

		Query query = entityManager.createNativeQuery(queryString.toString(), Cliente.class);

		if (idEntidadFinanciera != null && idEntidadFinanciera != 0) {
			query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		}

		if (estado != null) {
			query.setParameter("estado", estado);
		}

		if (codTipoIdentificacion != null && codTipoIdentificacion != 0) {
			query.setParameter("codTipoIdentificacion", codTipoIdentificacion);
		}

		if (identificacion != null && !identificacion.equals("0")) {
			query.setParameter("identificacion", identificacion);
		}

		if (nombre != null && !nombre.equals("0")) {
			query.setParameter("nombre", nombre);
		}

		query.setParameter("registroInicial", registroInicial);
		query.setParameter("registroFinal", numeroRegistros);

		return query.getResultList();
	}

	@Override
	public Long contarCompradoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera, Long idTipoIdentificacion,
			String identificacion, EnumEstadoEntidad estado, String nombre) {
		StringBuilder queryString = new StringBuilder("""
                SELECT COUNT(c.id) FROM CLIENTE c  JOIN TIDENT ON TIDENT.ID=c.TIPOiDENTIFICACION_ID
                WHERE 1=1
                """);

		if (estado != null) {
			queryString.append("AND c.ESTADO = :estado \r\n");
		}
		
		if (idEntidadFinanciera != null && idEntidadFinanciera != 0) {
			queryString.append("AND c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera\r\n");
		}

		if (idTipoIdentificacion!=null && idTipoIdentificacion != 0) {
			queryString.append("AND TIDENT.id=:idTipoIdentificacion\r\n");
		}

		if (identificacion!=null && !identificacion.equals("0")) {
			if(isBuscar) {
				queryString.append("AND c.numId= :identificacion\r\n");
			}else {
			queryString.append("AND lower(c.numId) like concat(lower(:identificacion),'%')");
			}
		}

		if (nombre!=null && !nombre.equals("0")) {
			queryString.append("""
                    AND ( lower(c.NOMBRE) like concat(lower(:nombre),'%') \
                     OR lower(c.APELLIDO1) like concat(lower(:nombre),'%') \
                     OR lower(c.APELLIDO2) like concat(lower(:nombre),'%') \
                     OR lower(c.SIGLA) like concat(lower(:nombre),'%') )\
                    """);
		}
		
		queryString.append("""
                AND c.id IN(
                    SELECT c2.id from
                     Cliente c2 
                    inner JOIN comprador comp ON comp.cliente_id = c2.id
                    where comp.id in (select vendedor_id from v_aplicacion_pago ))\
                """);

		Query query = entityManager.createNativeQuery(queryString.toString());

		query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		
		query.setParameter("estado", estado);
		if (idTipoIdentificacion!=null && idTipoIdentificacion != 0) {
			query.setParameter("idTipoIdentificacion", idTipoIdentificacion);
		}

		if (identificacion!=null && !identificacion.equals("0")) {
			query.setParameter("identificacion", identificacion);
		}

		if (nombre!=null && !nombre.equals("0")) {
			query.setParameter("nombre", nombre);
		}

		return ((Number) query.getSingleResult()).longValue();

	}

	@Override
	public Long contarVendedoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera, Long idTipoIdentificacion,
			String identificacion, EnumEstadoEntidad estado, String nombre) {
		StringBuilder queryString = new StringBuilder("""
                SELECT COUNT(c.id) FROM CLIENTE c  JOIN TIDENT ON TIDENT.ID=c.TIPOiDENTIFICACION_ID
                WHERE 1=1
                """);

		if (estado != null) {
			queryString.append("AND c.ESTADO = :estado \r\n");
		}
		
		if (idEntidadFinanciera != null && idEntidadFinanciera != 0) {
			queryString.append("AND c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera\r\n");
		}

		if (idTipoIdentificacion!=null && idTipoIdentificacion != 0) {
			queryString.append("AND TIDENT.id=:idTipoIdentificacion\r\n");
		}

		if (identificacion!=null && !identificacion.equals("0")) {
			if(isBuscar) {
				queryString.append("AND c.numId= :identificacion\r\n");
			}else {
			queryString.append("AND lower(c.numId) like concat(lower(:identificacion),'%')");
			}
		}

		if (nombre !=null && !nombre.equals("0")) {
			queryString.append("""
                    AND ( lower(c.NOMBRE) like concat(lower(:nombre),'%') \
                     OR lower(c.APELLIDO1) like concat(lower(:nombre),'%') \
                     OR lower(c.APELLIDO2) like concat(lower(:nombre),'%') \
                     OR lower(c.SIGLA) like concat(lower(:nombre),'%') )\
                    """);
		}
		
		queryString.append("""
                AND c.id IN(
                    SELECT c2.id from
                     Cliente c2 
                    inner JOIN vendedor vend ON vend.cliente_id = c2.id
                    where vend.id in (select comprador_id from v_aplicacion_pago ))\
                """);

		Query query = entityManager.createNativeQuery(queryString.toString());

		query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		
		query.setParameter("estado", estado);
		if (idTipoIdentificacion!=null && idTipoIdentificacion != 0) {
			query.setParameter("idTipoIdentificacion", idTipoIdentificacion);
		}

		if (identificacion!=null && !identificacion.equals("0")) {
			query.setParameter("identificacion", identificacion);
		}

		if (nombre !=null && !nombre.equals("0")) {
			query.setParameter("nombre", nombre);
		}

		return ((Number) query.getSingleResult()).longValue();
	}

	@Override
	public List<Cliente> listarCompradoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera, Long idTipoIdentificacion,
			String identificacion, EnumEstadoEntidad estado, String nombre, int registroInicial, int numeroRegistros) {
		StringBuilder queryString = new StringBuilder(
				"""
                SELECT * from (SELECT c.*,ROW_NUMBER() OVER (ORDER BY  tident.descripcion asc,c.NUMID asc) AS FilaExt
                FROM CLIENTE c  JOIN TIDENT ON TIDENT.ID=c.TIPOiDENTIFICACION_ID
                WHERE 1=1
                """);

		if (idEntidadFinanciera != null && idEntidadFinanciera != 0) {
			queryString.append("AND c.ENTIDADFINANCIERA_ID =:idEntidadFinanciera\r\n");
		}

		if (estado != null) {
			queryString.append("AND c.ESTADO = :estado \r\n");
		}
		if (idTipoIdentificacion != null && idTipoIdentificacion != 0) {
			queryString.append("AND tident.id=:idTipoIdentificacion\r\n");
		}

		if (identificacion != null && !identificacion.equals("0")) {
			if(isBuscar) {
				queryString.append("AND c.numId= :identificacion\r\n");
			}else {
			queryString.append("AND lower(c.numId) like concat(lower(:identificacion),'%')\r\n");
			}
		}

		if (nombre != null && !nombre.equals("0")) {
			queryString.append("""
                    and ( lower(c.nombre) like concat(lower(:nombre),'%') \
                     or lower(c.apellido1) like concat(lower(:nombre),'%') \
                     or lower(c.apellido2) like concat(lower(:nombre),'%') \
                    or lower(c.sigla) like concat(lower(:nombre),'%') )
                    """);
		}

		queryString.append("""
                AND c.id IN(
                    SELECT c2.id from
                     Cliente c2 
                    inner JOIN comprador comp ON comp.cliente_id = c2.id
                    where comp.id in (select vendedor_id from v_aplicacion_pago ))\
                ) WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
                """);

		Query query = entityManager.createNativeQuery(queryString.toString(), Cliente.class);

		if (idEntidadFinanciera != null && idEntidadFinanciera != 0) {
			query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		}

		if (estado != null) {
			query.setParameter("estado", estado);
		}

		if (idTipoIdentificacion != null && idTipoIdentificacion != 0) {
			query.setParameter("idTipoIdentificacion", idTipoIdentificacion);
		}

		if (identificacion != null && !identificacion.equals("0")) {
			query.setParameter("identificacion", identificacion);
		}

		if (nombre != null && !nombre.equals("0")) {
			query.setParameter("nombre", nombre);
		}

		query.setParameter("registroInicial", registroInicial);
		query.setParameter("registroFinal", numeroRegistros);

		return query.getResultList();

	}

	@Override
	public List<Cliente> listarVendedoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera, Long idTipoIdentificacion,
			String identificacion, EnumEstadoEntidad estado, String nombre, int registroInicial, int numeroRegistros) {
		
		StringBuilder queryString = new StringBuilder(
				"""
                SELECT * from (SELECT c.*,ROW_NUMBER() OVER (ORDER BY  tident.descripcion asc,c.NUMID asc) AS FilaExt
                FROM CLIENTE c  JOIN TIDENT ON TIDENT.ID=c.TIPOiDENTIFICACION_ID
                WHERE 1=1
                """);

		if (idEntidadFinanciera != null && idEntidadFinanciera != 0) {
			queryString.append("AND c.ENTIDADFINANCIERA_ID =:idEntidadFinanciera\r\n");
		}

		if (estado != null) {
			queryString.append("AND c.ESTADO = :estado \r\n");
		}
		if (idTipoIdentificacion != null && idTipoIdentificacion != 0) {
			queryString.append("AND tident.id=:idTipoIdentificacion\r\n");
		}

		if (identificacion != null && !identificacion.equals("0")) {
			if(isBuscar) {
				queryString.append("AND c.numId= :identificacion\r\n");
			}else {
			queryString.append("AND lower(c.numId) like concat(lower(:identificacion),'%')\r\n");
			}
		}

		if (nombre != null && !nombre.equals("0")) {
			queryString.append("""
                    and ( lower(c.nombre) like concat(lower(:nombre),'%') \
                     or lower(c.apellido1) like concat(lower(:nombre),'%') \
                     or lower(c.apellido2) like concat(lower(:nombre),'%') \
                    or lower(c.sigla) like concat(lower(:nombre),'%') )
                    """);
		}

		queryString.append("""
                AND c.id IN(
                    SELECT c2.id from
                     Cliente c2 
                    inner JOIN vendedor vend ON vend.cliente_id = c2.id
                    where vend.id in (select comprador_id from v_aplicacion_pago ))\
                ) WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
                """);

		Query query = entityManager.createNativeQuery(queryString.toString(), Cliente.class);

		if (idEntidadFinanciera != null && idEntidadFinanciera != 0) {
			query.setParameter("idEntidadFinanciera", idEntidadFinanciera);
		}

		if (estado != null) {
			query.setParameter("estado", estado);
		}

		if (idTipoIdentificacion != null && idTipoIdentificacion != 0) {
			query.setParameter("idTipoIdentificacion", idTipoIdentificacion);
		}

		if (identificacion != null && !identificacion.equals("0")) {
			query.setParameter("identificacion", identificacion);
		}

		if (nombre != null && !nombre.equals("0")) {
			query.setParameter("nombre", nombre);
		}

		query.setParameter("registroInicial", registroInicial);
		query.setParameter("registroFinal", numeroRegistros);

		return query.getResultList();

	}

	
	

}
