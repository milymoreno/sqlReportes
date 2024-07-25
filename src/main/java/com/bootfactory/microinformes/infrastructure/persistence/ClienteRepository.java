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

	
	@Query(value = "select count(distinct c.id) FROM v_estado_mm v JOIN CLIENTE c on c.numId=v.NUM_ID_CLIENTE\r\n"
		+ "join tident on tident.id=c.tipoidentificacion_id\r\n"
		+ " WHERE \r\n"
		+ "c.estado=:estado\r\n"
		+ "and c.ENTIDADFINANCIERA_ID=:idEntidadFinanciera\r\n"
		+ "and c.ESFUENTEPAGO=1\r\n"
		+ "and tident.codigo=:tipoIdentificacion\r\n" 
		+ "and c.numId=:identificacion\r\n", nativeQuery = true)
	Long contarPagadorByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
		@Param("tipoIdentificacion") Long tipoIdentificacion,@Param("identificacion") String identificacion,
		@Param("estado") EnumEstadoEntidad estado);

	@Query(value = "SELECT     distinct cliente.id,cliente.numid,cliente.razonsocial,cliente.sigla,cliente.nombre,cliente.apellido1,cliente.apellido2,cliente.tipocliente,cliente.tipoidentificacion_id,cliente.entidadfinanciera_id,cliente.esFuentePago,cliente.esdeudor, cliente.estado\r\n"
		+ "FROM ( select c.*,rownum as FilaExt  FROM v_estado_mm v JOIN CLIENTE c on c.numId=v.NUM_ID_CLIENTE\r\n"
		+ "join tident on tident.id=c.tipoidentificacion_id\r\n"
		+ " WHERE \r\n"
		+ "c.estado=:estado\r\n"
		+ "and c.ENTIDADFINANCIERA_ID=:idEntidadFinanciera\r\n"
		+ "and c.ESFUENTEPAGO=1\r\n"
		+ "and tident.codigo=:tipoIdentificacion\r\n" 
		+ "and c.numId=:identificacion\r\n"
		+ "order by tident.descripcion asc,c.NUMID asc) cliente\r\n"
		+ "        WHERE FilaExt BETWEEN :registroInicial AND :registroFinal", nativeQuery = true)
	List<Cliente> buscarPagadorByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
		@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
		@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
		@Param("registroFinal") int registroFinal);


	
	
	
	
	
	
	@Query(value = "select count(CLIENTE.id) from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "join tident on tident.id=cliente.tipoidentificacion_id\r\n"
			+ "join entidadfinanciera on cliente.ENTIDADFINANCIERA_ID=entidadfinanciera.id\r\n"
			+ "join entfin_moneda on entfin_moneda.ENTIDADFINANCIERA_ID=entidadfinanciera.id \r\n"
			+ "join moneda on entfin_moneda.MONEDA_ID=moneda.id\r\n"
			+ "join producto on comprador.producto_id=producto.id\r\n" + "WHERE \r\n" + "comprador.estado=:estado\r\n"
			+ "and CLIENTE.ENTIDADFINANCIERA_ID=:idEntidadFinanciera\r\n" + "and producto.id=8749\r\n", nativeQuery = true)
	Long contarCompradoresADC(Long idEntidadFinanciera, EnumEstadoEntidad estado);

	@Query(value = "SELECT * FROM ( select CLIENTE.*,rownum as FilaExt  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "join tident on tident.id=cliente.tipoidentificacion_id\r\n"
			+ "join entidadfinanciera on cliente.ENTIDADFINANCIERA_ID=entidadfinanciera.id\r\n"
			+ "join entfin_moneda on entfin_moneda.ENTIDADFINANCIERA_ID=entidadfinanciera.id \r\n"
			+ "join moneda on entfin_moneda.MONEDA_ID=moneda.id\r\n"
			+ "join producto on comprador.producto_id=producto.id\r\n" + "WHERE \r\n" + "comprador.estado=:estado\r\n"
			+ "and CLIENTE.ENTIDADFINANCIERA_ID=:idEntidadFinanciera\r\n" + "and producto.id=8749\r\n"
			+ "order by tident.descripcion asc,CLIENTE.NUMID asc) "
			+ "        WHERE FilaExt BETWEEN :registroInicial AND :registroFinal", nativeQuery = true)
	List<Cliente> listarCompradoresADCPaginado(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);

	
	@Query(value = " select count(CLIENTE.id) from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "join tident on tident.id=cliente.tipoidentificacion_id\r\n"
			+ "join entidadfinanciera on cliente.ENTIDADFINANCIERA_ID=entidadfinanciera.id\r\n"
			+ "join entfin_moneda on entfin_moneda.ENTIDADFINANCIERA_ID=entidadfinanciera.id \r\n"
			+ "join moneda on entfin_moneda.MONEDA_ID=moneda.id\r\n"
			+ "join producto on comprador.producto_id=producto.id\r\n" + "WHERE \r\n" + "comprador.estado=:estado\r\n"
			+ "and CLIENTE.ENTIDADFINANCIERA_ID=:idEntidadFinanciera\r\n" + "and producto.id=8749\r\n"
			+ "and tident.codigo=:tipoIdentificacion\r\n", nativeQuery = true)
	Long contarCompradoresADCByTipoIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("estado") EnumEstadoEntidad estado);

	@Query(value = "SELECT * FROM ( select CLIENTE.*,rownum as FilaExt  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "join tident on tident.id=cliente.tipoidentificacion_id\r\n"
			+ "join entidadfinanciera on cliente.ENTIDADFINANCIERA_ID=entidadfinanciera.id\r\n"
			+ "join entfin_moneda on entfin_moneda.ENTIDADFINANCIERA_ID=entidadfinanciera.id \r\n"
			+ "join moneda on entfin_moneda.MONEDA_ID=moneda.id\r\n"
			+ "join producto on comprador.producto_id=producto.id\r\n" + "WHERE \r\n" + "comprador.estado=:estado\r\n"
			+ "and CLIENTE.ENTIDADFINANCIERA_ID=:idEntidadFinanciera\r\n" + "and producto.id=8749\r\n"
			+ "and tident.codigo=:tipoIdentificacion\r\n" 
			+ "order by tident.descripcion asc,CLIENTE.NUMID asc) "
			+ "        WHERE FilaExt BETWEEN :registroInicial AND :registroFinal", nativeQuery = true)
	List<Cliente> listarCompradoresADCByTipoIdentificacionPaginado(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	
	@Query(value = " select count(CLIENTE.id) from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "join tident on tident.id=cliente.tipoidentificacion_id\r\n"
			+ "join entidadfinanciera on cliente.ENTIDADFINANCIERA_ID=entidadfinanciera.id\r\n"
			+ "join entfin_moneda on entfin_moneda.ENTIDADFINANCIERA_ID=entidadfinanciera.id \r\n"
			+ "join moneda on entfin_moneda.MONEDA_ID=moneda.id\r\n"
			+ "join producto on comprador.producto_id=producto.id\r\n" + "WHERE \r\n" + "comprador.estado=:estado\r\n"
			+ "and CLIENTE.ENTIDADFINANCIERA_ID=:idEntidadFinanciera\r\n" + "and producto.id=8749\r\n"
			+ "and tident.codigo=:tipoIdentificacion\r\n" + "and CLIENTE.numId>=:identificacion\r\n", nativeQuery = true)
	Long contarCompradoresADCByIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("estado") EnumEstadoEntidad estado);

	@Query(value = "SELECT * FROM ( select CLIENTE.*,rownum as FilaExt  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "join tident on tident.id=cliente.tipoidentificacion_id\r\n"
			+ "join entidadfinanciera on cliente.ENTIDADFINANCIERA_ID=entidadfinanciera.id\r\n"
			+ "join entfin_moneda on entfin_moneda.ENTIDADFINANCIERA_ID=entidadfinanciera.id \r\n"
			+ "join moneda on entfin_moneda.MONEDA_ID=moneda.id\r\n"
			+ "join producto on comprador.producto_id=producto.id\r\n" + "WHERE \r\n" + "comprador.estado=:estado\r\n"
			+ "and CLIENTE.ENTIDADFINANCIERA_ID=:idEntidadFinanciera\r\n" + "and producto.id=8749\r\n"
			+ "and tident.codigo=:tipoIdentificacion\r\n" + "and CLIENTE.numId>=:identificacion\r\n"
			+ "order by tident.descripcion asc,CLIENTE.NUMID asc) "
			+ "        WHERE FilaExt BETWEEN :registroInicial AND :registroFinal", nativeQuery = true)
	List<Cliente> listarCompradoresADCByIdentificacionPaginado(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	
	

	@Query(value = "select count(distinct c.id ) FROM v_estado_vmd v JOIN CLIENTE c on c.numId=v.NUM_ID_CLIENTE\r\n"
			+ "join tident on tident.id=c.tipoidentificacion_id\r\n"
			+ "join entidadfinanciera on c.ENTIDADFINANCIERA_ID=entidadfinanciera.id\r\n"
			+ "WHERE \r\n" + "c.estado=:estado\r\n"
			+ "and c.ENTIDADFINANCIERA_ID=:idEntidadFinanciera\r\n" 
			+ "and c.ESDEUDOR=1\r\n"
			+ "and tident.codigo=:tipoIdentificacion\r\n" 
			+ "and c.numId=:identificacion\r\n", nativeQuery = true)
	Long contarDeudorByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("tipoIdentificacion") Long tipoIdentificacion,@Param("identificacion") String identificacion,
			@Param("estado") EnumEstadoEntidad estado);

	@Query(value = "SELECT     distinct cliente.id,cliente.numid,cliente.razonsocial,cliente.sigla,cliente.nombre,cliente.apellido1,cliente.apellido2,cliente.tipocliente,cliente.tipoidentificacion_id,cliente.entidadfinanciera_id,cliente.esFuentePago,cliente.esdeudor, cliente.estado\r\n"
			+ " FROM ( select c.*,rownum as FilaExt  FROM v_estado_vmd v JOIN CLIENTE c on c.numId=v.NUM_ID_CLIENTE\r\n"
			+ "join tident on tident.id=c.tipoidentificacion_id\r\n"
			+ "join entidadfinanciera on c.ENTIDADFINANCIERA_ID=entidadfinanciera.id\r\n"
			+ "WHERE  c.estado=:estado\r\n"
			+ "and c.ENTIDADFINANCIERA_ID=:idEntidadFinanciera\r\n"
			+ "and c.ESDEUDOR=1\r\n"
			+ "and tident.codigo=:tipoIdentificacion\r\n"
			+ "and c.numId=:identificacion\r\n"
			+ "order by tident.descripcion asc,C.NUMID asc) cliente\r\n"
			+ "        WHERE FilaExt BETWEEN :registroInicial AND :registroFinal", nativeQuery = true)
	List<Cliente> buscarDeudorByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	
	//--------------------------------------Clientes NO ADC----------------------------------------------------------------------
	
	
	@Query(value="SELECT count(c.id) FROM Cliente c WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera \r\n"
			+ "				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado\r\n"
			+ "				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))\r\n"
			+ "				AND c.estado = :estado \r\n"
			+ "				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado\r\n"
			+ "								 and producto.id=8749)",nativeQuery=true)
	Long contarClientesNoADCPaginado(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado);
	
	
	
	@Query(value="SELECT * FROM (SELECT c.*,rownum as FilaExt FROM Cliente c WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera \r\n"
			+ "				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado\r\n"
			+ "				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))\r\n"
			+ "				AND c.estado = :estado \r\n"
			+ "				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado\r\n"
			+ "								 and producto.id=8749)\r\n"
			+ "			 )\r\n"
			+ "WHERE FilaExt BETWEEN :registroInicial AND :registroFinal",nativeQuery=true)
	List<Cliente> listarClientesNoADCPaginado(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	
	
	@Query(value="SELECT count(c.id) FROM Cliente c \r\n"
			+ "JOIN tident on tident.id=c.tipoidentificacion_id \r\n"
			+ "WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera \r\n"
			+ "				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado\r\n"
			+ "				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))\r\n"
			+ "				AND c.estado = :estado \r\n"
			+ "				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado\r\n"
			+ "								 and producto.id=8749)"
			+ "AND tident.codigo=:tipoIdentificacion\r\n",nativeQuery=true)
	Long contarClientesNoADCByTipoIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado);
	
	
	
	@Query(value="SELECT * FROM (SELECT c.*,rownum as FilaExt FROM Cliente c \r\n"
			+ "JOIN tident on tident.id=c.tipoidentificacion_id \r\n"
			+ "WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera \r\n"
			+ "				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado\r\n"
			+ "				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))\r\n"
			+ "				AND c.estado = :estado \r\n"
			+ "				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado\r\n"
			+ "								 and producto.id=8749)\r\n"
			+ "AND tident.codigo=:tipoIdentificacion\r\n"
			+ "			 )\r\n"
			+ "WHERE FilaExt BETWEEN :registroInicial AND :registroFinal",nativeQuery=true)
	List<Cliente> listarClientesNoADCByTipoIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	@Query(value="SELECT count(c.id) FROM Cliente c \r\n"
			+ "JOIN tident on tident.id=c.tipoidentificacion_id \r\n"
			+ "WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera \r\n"
			+ "				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado\r\n"
			+ "				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))\r\n"
			+ "				AND c.estado = :estado \r\n"
			+ "				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado\r\n"
			+ "								 and producto.id=8749)"
			+ "AND tident.codigo=:tipoIdentificacion\r\n"
			+ "AND c.numId>=:identificacion\r\n",nativeQuery=true)
	Long contarClientesNoADCByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado);
	
	
	
	@Query(value="SELECT * FROM (SELECT c.*,rownum as FilaExt FROM Cliente c \r\n"
			+ "JOIN tident on tident.id=c.tipoidentificacion_id \r\n"
			+ "WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera \r\n"
			+ "				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado\r\n"
			+ "				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))\r\n"
			+ "				AND c.estado = :estado \r\n"
			+ "				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado\r\n"
			+ "								 and producto.id=8749)\r\n"
			+ "AND tident.codigo=:tipoIdentificacion\r\n"
			+ "AND c.numId>=:identificacion\r\n"
			+ "			 )\r\n"
			+ "WHERE FilaExt BETWEEN :registroInicial AND :registroFinal",nativeQuery=true)
	List<Cliente> listarClientesNoADCByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	
	@Query(value="SELECT count(c.id) FROM Cliente c \r\n"
			+ "JOIN tident on tident.id=c.tipoidentificacion_id \r\n"
			+ "WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera \r\n"
			+ "				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado\r\n"
			+ "				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))\r\n"
			+ "				AND c.estado = :estado \r\n"
			+ "				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado\r\n"
			+ "								 and producto.id=8749)"
			+ "AND tident.codigo=:tipoIdentificacion\r\n"
			+ "AND c.numId=:identificacion\r\n",nativeQuery=true)
	Long contarClienteNoADCByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado);
	
	
	@Query(value="SELECT * FROM (SELECT c.*,rownum as FilaExt FROM Cliente c \r\n"
			+ "JOIN tident on tident.id=c.tipoidentificacion_id \r\n"
			+ "WHERE c.ENTIDADFINANCIERA_ID = :idEntidadFinanciera \r\n"
			+ "				AND c.id NOT IN (select l.CLIENTE_ID from ListaExcepcion l WHERE l.CLIENTE_ID is not null AND l.estado = :estado\r\n"
			+ "				AND (l.causalBloqueo = :causabloqueo or l.causalBloqueo = :causalistaexcep ))\r\n"
			+ "				AND c.estado = :estado \r\n"
			+ "				AND c.id NOT IN (select CLIENTE.id  from CONDICIONCOMPRADOR condicion JOIN COMPRADOR comprador ON condicion.COMPRADOR_ID =comprador.id\r\n"
			+ "								 JOIN CLIENTE ON COMPRADOR.CLIENTE_ID=cliente.id\r\n"
			+ "								 join producto on comprador.producto_id=producto.id  WHERE   comprador.estado=:estado\r\n"
			+ "								 and producto.id=8749)\r\n"
			+ "AND tident.codigo=:tipoIdentificacion\r\n"
			+ "AND c.numId=:identificacion\r\n"
			+ "			 )\r\n"
			+ "WHERE FilaExt BETWEEN :registroInicial AND :registroFinal",nativeQuery=true)
	List<Cliente> buscarClientesNoADCByTipoEIdentificacion(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("tipoIdentificacion") Long tipoIdentificacion, @Param("identificacion") String identificacion,
			@Param("causabloqueo") EnumCausalBloqueo causabloqueo, @Param("causalistaexcep") EnumCausalBloqueo causalistaexcep,
			@Param("estado") EnumEstadoEntidad estado, @Param("registroInicial") int registroInicial,
			@Param("registroFinal") int registroFinal);
	
	
	
	
	@Query(value="SELECT cliente  FROM Cliente cliente \r\n"
			+ " WHERE cliente.numId = :numeroIdentificacion \r\n"
			+ " AND cliente.entidadFinanciera.id = :idEntidadFinanciera \r\n"
			+ " AND cliente.tipoIdentificacion.codigo = :codTipoIdentificacion \r\n"
			+ " AND cliente.estado=:estado")
	List<Cliente> buscarCliente(@Param("idEntidadFinanciera") Long idEntidadFinanciera,@Param("codTipoIdentificacion") Long codTipoIdentificacion,@Param("numeroIdentificacion") String numeroIdentificacion,@Param("estado") EnumEstadoEntidad estado);

}