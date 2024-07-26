package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootfactory.microinformes.domain.model.entity.Cliente;
import com.bootfactory.microinformes.domain.model.enums.EnumCausalBloqueo;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoEntidad;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>,ClienteRepositoryCustom {

	
	@Query(value = """
        select count(distinct c.id) FROM v_estado_mm v JOIN CLIENTE c on c.numId=v.NUM_ID_CLIENTE
        join tident on tident.id=c.tipoidentificacion_id
         WHERE 
        c.estado=:estado
        and c.ENTIDADFINANCIERA_ID=:idEntidadFinanciera
        and c.ESFUENTEPAGO=1
        and tident.codigo=:tipoIdentificacion
        and c.numId=:identificacion
        """, nativeQuery = true)
	Long contarPagadorByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
		@Param("tipoIdentificacion") Long tipoIdentificacion,@Param("identificacion") String identificacion,
		@Param("estado") EnumEstadoEntidad estado);

	@Query(value = """
        SELECT     distinct cliente.id,cliente.numid,cliente.razonsocial,cliente.sigla,cliente.nombre,cliente.apellido1,cliente.apellido2,cliente.tipocliente,cliente.tipoidentificacion_id,cliente.entidadfinanciera_id,cliente.esFuentePago,cliente.esdeudor, cliente.estado
        FROM ( select c.*,rownum as FilaExt  FROM v_estado_mm v JOIN CLIENTE c on c.numId=v.NUM_ID_CLIENTE
        join tident on tident.id=c.tipoidentificacion_id
         WHERE 
        c.estado=:estado
        and c.ENTIDADFINANCIERA_ID=:idEntidadFinanciera
        and c.ESFUENTEPAGO=1
        and tident.codigo=:tipoIdentificacion
        and c.numId=:identificacion
        order by tident.descripcion asc,c.NUMID asc) cliente
                WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
        """, nativeQuery = true)
	List<Cliente> buscarPagadorByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
		@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
		@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
		@Param("registroFinal") int registroFinal);


	
	
	
	
	
	
	@Query(value = """
            select count(CLIENTE.id) from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            join tident on tident.id=cliente.tipoidentificacion_id
            join entidadfinanciera on cliente.ENTIDADFINANCIERA_ID=entidadfinanciera.id
            join entfin_moneda on entfin_moneda.ENTIDADFINANCIERA_ID=entidadfinanciera.id 
            join moneda on entfin_moneda.MONEDA_ID=moneda.id
            join producto on comprador.producto_id=producto.id
            WHERE 
            comprador.estado=:estado
            and CLIENTE.ENTIDADFINANCIERA_ID=:idEntidadFinanciera
            and producto.id=8749
            """, nativeQuery = true)
	Long contarCompradoresADC(Long idEntidadFinanciera, EnumEstadoEntidad estado);

	@Query(value = """
            SELECT * FROM ( select CLIENTE.*,rownum as FilaExt  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            join tident on tident.id=cliente.tipoidentificacion_id
            join entidadfinanciera on cliente.ENTIDADFINANCIERA_ID=entidadfinanciera.id
            join entfin_moneda on entfin_moneda.ENTIDADFINANCIERA_ID=entidadfinanciera.id 
            join moneda on entfin_moneda.MONEDA_ID=moneda.id
            join producto on comprador.producto_id=producto.id
            WHERE 
            comprador.estado=:estado
            and CLIENTE.ENTIDADFINANCIERA_ID=:idEntidadFinanciera
            and producto.id=8749
            order by tident.descripcion asc,CLIENTE.NUMID asc) \
                    WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
            """, nativeQuery = true)
	List<Cliente> listarCompradoresADCPaginado(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);

	
	@Query(value = """
             select count(CLIENTE.id) from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            join tident on tident.id=cliente.tipoidentificacion_id
            join entidadfinanciera on cliente.ENTIDADFINANCIERA_ID=entidadfinanciera.id
            join entfin_moneda on entfin_moneda.ENTIDADFINANCIERA_ID=entidadfinanciera.id 
            join moneda on entfin_moneda.MONEDA_ID=moneda.id
            join producto on comprador.producto_id=producto.id
            WHERE 
            comprador.estado=:estado
            and CLIENTE.ENTIDADFINANCIERA_ID=:idEntidadFinanciera
            and producto.id=8749
            and tident.codigo=:tipoIdentificacion
            """, nativeQuery = true)
	Long contarCompradoresADCByTipoIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("estado") EnumEstadoEntidad estado);

	@Query(value = """
            SELECT * FROM ( select CLIENTE.*,rownum as FilaExt  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            join tident on tident.id=cliente.tipoidentificacion_id
            join entidadfinanciera on cliente.ENTIDADFINANCIERA_ID=entidadfinanciera.id
            join entfin_moneda on entfin_moneda.ENTIDADFINANCIERA_ID=entidadfinanciera.id 
            join moneda on entfin_moneda.MONEDA_ID=moneda.id
            join producto on comprador.producto_id=producto.id
            WHERE 
            comprador.estado=:estado
            and CLIENTE.ENTIDADFINANCIERA_ID=:idEntidadFinanciera
            and producto.id=8749
            and tident.codigo=:tipoIdentificacion
            order by tident.descripcion asc,CLIENTE.NUMID asc) \
                    WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
            """, nativeQuery = true)
	List<Cliente> listarCompradoresADCByTipoIdentificacionPaginado(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	
	@Query(value = """
             select count(CLIENTE.id) from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            join tident on tident.id=cliente.tipoidentificacion_id
            join entidadfinanciera on cliente.ENTIDADFINANCIERA_ID=entidadfinanciera.id
            join entfin_moneda on entfin_moneda.ENTIDADFINANCIERA_ID=entidadfinanciera.id 
            join moneda on entfin_moneda.MONEDA_ID=moneda.id
            join producto on comprador.producto_id=producto.id
            WHERE 
            comprador.estado=:estado
            and CLIENTE.ENTIDADFINANCIERA_ID=:idEntidadFinanciera
            and producto.id=8749
            and tident.codigo=:tipoIdentificacion
            and CLIENTE.numId>=:identificacion
            """, nativeQuery = true)
	Long contarCompradoresADCByIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("estado") EnumEstadoEntidad estado);

	@Query(value = """
            SELECT * FROM ( select CLIENTE.*,rownum as FilaExt  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            join tident on tident.id=cliente.tipoidentificacion_id
            join entidadfinanciera on cliente.ENTIDADFINANCIERA_ID=entidadfinanciera.id
            join entfin_moneda on entfin_moneda.ENTIDADFINANCIERA_ID=entidadfinanciera.id 
            join moneda on entfin_moneda.MONEDA_ID=moneda.id
            join producto on comprador.producto_id=producto.id
            WHERE 
            comprador.estado=:estado
            and CLIENTE.ENTIDADFINANCIERA_ID=:idEntidadFinanciera
            and producto.id=8749
            and tident.codigo=:tipoIdentificacion
            and CLIENTE.numId>=:identificacion
            order by tident.descripcion asc,CLIENTE.NUMID asc) \
                    WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
            """, nativeQuery = true)
	List<Cliente> listarCompradoresADCByIdentificacionPaginado(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	
	

	@Query(value = """
            select count(distinct c.id ) FROM v_estado_vmd v JOIN CLIENTE c on c.numId=v.NUM_ID_CLIENTE
            join tident on tident.id=c.tipoidentificacion_id
            join entidadfinanciera on c.ENTIDADFINANCIERA_ID=entidadfinanciera.id
            WHERE 
            c.estado=:estado
            and c.ENTIDADFINANCIERA_ID=:idEntidadFinanciera
            and c.ESDEUDOR=1
            and tident.codigo=:tipoIdentificacion
            and c.numId=:identificacion
            """, nativeQuery = true)
	Long contarDeudorByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("tipoIdentificacion") Long tipoIdentificacion,@Param("identificacion") String identificacion,
			@Param("estado") EnumEstadoEntidad estado);

	@Query(value = """
            SELECT     distinct cliente.id,cliente.numid,cliente.razonsocial,cliente.sigla,cliente.nombre,cliente.apellido1,cliente.apellido2,cliente.tipocliente,cliente.tipoidentificacion_id,cliente.entidadfinanciera_id,cliente.esFuentePago,cliente.esdeudor, cliente.estado
             FROM ( select c.*,rownum as FilaExt  FROM v_estado_vmd v JOIN CLIENTE c on c.numId=v.NUM_ID_CLIENTE
            join tident on tident.id=c.tipoidentificacion_id
            join entidadfinanciera on c.ENTIDADFINANCIERA_ID=entidadfinanciera.id
            WHERE  c.estado=:estado
            and c.ENTIDADFINANCIERA_ID=:idEntidadFinanciera
            and c.ESDEUDOR=1
            and tident.codigo=:tipoIdentificacion
            and c.numId=:identificacion
            order by tident.descripcion asc,C.NUMID asc) cliente
                    WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
            """, nativeQuery = true)
	List<Cliente> buscarDeudorByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	
	//--------------------------------------Clientes NO ADC----------------------------------------------------------------------
	
	
	@Query(value="""
            SELECT count(c.id) FROM Cliente c WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera 
            				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado
            				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))
            				AND c.estado = :estado 
            				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado
            								 and producto.id=8749)\
            """,nativeQuery=true)
	Long contarClientesNoADCPaginado(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado);
	
	
	
	@Query(value="""
            SELECT * FROM (SELECT c.*,rownum as FilaExt FROM Cliente c WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera 
            				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado
            				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))
            				AND c.estado = :estado 
            				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado
            								 and producto.id=8749)
            			 )
            WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
            """,nativeQuery=true)
	List<Cliente> listarClientesNoADCPaginado(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	
	
	@Query(value="""
            SELECT count(c.id) FROM Cliente c 
            JOIN tident on tident.id=c.tipoidentificacion_id 
            WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera 
            				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado
            				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))
            				AND c.estado = :estado 
            				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado
            								 and producto.id=8749)\
            AND tident.codigo=:tipoIdentificacion
            """,nativeQuery=true)
	Long contarClientesNoADCByTipoIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado);
	
	
	
	@Query(value="""
            SELECT * FROM (SELECT c.*,rownum as FilaExt FROM Cliente c 
            JOIN tident on tident.id=c.tipoidentificacion_id 
            WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera 
            				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado
            				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))
            				AND c.estado = :estado 
            				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado
            								 and producto.id=8749)
            AND tident.codigo=:tipoIdentificacion
            			 )
            WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
            """,nativeQuery=true)
	List<Cliente> listarClientesNoADCByTipoIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	@Query(value="""
            SELECT count(c.id) FROM Cliente c 
            JOIN tident on tident.id=c.tipoidentificacion_id 
            WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera 
            				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado
            				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))
            				AND c.estado = :estado 
            				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado
            								 and producto.id=8749)\
            AND tident.codigo=:tipoIdentificacion
            AND c.numId>=:identificacion
            """,nativeQuery=true)
	Long contarClientesNoADCByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado);
	
	
	
	@Query(value="""
            SELECT * FROM (SELECT c.*,rownum as FilaExt FROM Cliente c 
            JOIN tident on tident.id=c.tipoidentificacion_id 
            WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera 
            				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado
            				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))
            				AND c.estado = :estado 
            				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado
            								 and producto.id=8749)
            AND tident.codigo=:tipoIdentificacion
            AND c.numId>=:identificacion
            			 )
            WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
            """,nativeQuery=true)
	List<Cliente> listarClientesNoADCByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	
	@Query(value="""
            SELECT count(c.id) FROM Cliente c 
            JOIN tident on tident.id=c.tipoidentificacion_id 
            WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera 
            				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado
            				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))
            				AND c.estado = :estado 
            				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado
            								 and producto.id=8749)\
            AND tident.codigo=:tipoIdentificacion
            AND c.numId=:identificacion
            """,nativeQuery=true)
	Long contarClienteNoADCByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado);
	
	
	@Query(value="""
            SELECT * FROM (SELECT c.*,rownum as FilaExt FROM Cliente c 
            JOIN tident on tident.id=c.tipoidentificacion_id 
            WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera 
            				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado
            				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))
            				AND c.estado = :estado 
            				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id
            								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id
            								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado
            								 and producto.id=8749)
            AND tident.codigo=:tipoIdentificacion
            AND c.numId=:identificacion
            			 )
            WHERE FilaExt BETWEEN :registroInicial AND :registroFinal\
            """,nativeQuery=true)
	List<Cliente> buscarClientesNoADCByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	
	
	
	@Query(value="""
            SELECT cliente  FROM Cliente cliente 
             WHERE cliente.numId = :numeroIdentificacion 
             AND cliente.entidadFinanciera.id = :idEntidadFinanciera 
             AND cliente.tipoIdentificacion.codigo = :codTipoIdentificacion 
             AND cliente.estado=:estado\
            """)
	List<Cliente> buscarCliente(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("codTipoIdentificacion") Long codTipoIdentificacion,@Param("numeroIdentificacion") String numeroIdentificacion,@Param("estado") EnumEstadoEntidad estado);

}