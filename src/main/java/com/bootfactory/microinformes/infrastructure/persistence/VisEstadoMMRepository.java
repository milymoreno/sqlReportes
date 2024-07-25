package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootfactory.microinformes.domain.model.entity.VisEstadoMM;

@Repository
public interface VisEstadoMMRepository extends JpaRepository<VisEstadoMM, Long> {

	@Query(value = "SELECT VISTA.*, rownum as FilaInt FROM V_ESTADO_MM VISTA WHERE ENTIDAD_FINANCIERA= :idEntidadFinanciera order by tipo_cliente desc,FilaInt desc", nativeQuery = true)
	List<VisEstadoMM> listar(@Param("idEntidadFinanciera") Long idEntidadFinanciera);

	@Query(value = "SELECT COUNT(id_vista) FROM V_ESTADO_MM  WHERE ENTIDAD_FINANCIERA= :idEntidadFinanciera", nativeQuery = true)
	Long contar(@Param("idEntidadFinanciera") Long idEntidadFinanciera);
	
	
	
	@Query(value = "SELECT * FROM ( SELECT V.*, rownum as FilaExt FROM  ( select VISTA.*, rownum as FilaInt from V_ESTADO_MM VISTA WHERE ENTIDAD_FINANCIERA= :idEntidadFinanciera order by estado_mm,tipo_cliente desc,FilaInt desc  ) V  ) WHERE FilaExt BETWEEN :registroInicial AND :registroFinal", nativeQuery = true,countQuery = "select count(id_vista) from v_estado_mm  WHERE ENTIDAD_FINANCIERA= :idEntidadFinanciera")
	List<VisEstadoMM> listarPaginado(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("registroInicial") int registroInicial, @Param("registroFinal") int registroFinal);
	
	@Query(value = "SELECT COUNT(vistaMM.id_vista) FROM V_ESTADO_MM vistaMM, "
			+ "        CLIENTE cliente " + "    JOIN" + "        tident tipo "
			+ "            on tipo.id=cliente.tipoidentificacion_id " + "    WHERE "
			+ "        tipo.descripcion=vistaMM.tipoident_cliente "
			+ "        and vistaMM.num_id_cliente=cliente.numid " + "        and tipo.codigo=:tipoIdentificacion "
			+ "        and cliente.numid=:identificacion "
			+ "        and cliente.entidadfinanciera_id=:idEntidadFinanciera " + "        and cliente.estado=0 "
			+ "        and cliente.esfuentepago=1 " , nativeQuery = true)
	Long contarPorCliente(@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("identificacion") String identificacion, @Param("idEntidadFinanciera") Long idEntidadFinanciera);
	
	@Query(value = "SELECT "
			+ "      vistaMM.*, rownum as FilaInt " + "    FROM " + "        V_ESTADO_MM vistaMM, "
			+ "        CLIENTE cliente " + "    JOIN" + "        tident tipo "
			+ "            on tipo.id=cliente.tipoidentificacion_id " + "    WHERE "
			+ "        tipo.descripcion=vistaMM.tipoident_cliente "
			+ "        and vistaMM.num_id_cliente=cliente.numid " + "        and tipo.codigo=:tipoIdentificacion "
			+ "        and cliente.numid=:identificacion "
			+ "        and cliente.entidadfinanciera_id=:idEntidadFinanciera " + "        and cliente.estado=0 "
			+ "        and cliente.esfuentepago=1 " + "   ORDER BY "
			+ "        vistaMM.tipo_cliente desc,FilaInt desc", nativeQuery = true)
	List<VisEstadoMM> listarPorCliente(@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("identificacion") String identificacion, @Param("idEntidadFinanciera") Long idEntidadFinanciera);
	
	
	
	@Query(value = "SELECT * FROM ( SELECT V.*, rownum as FilaExt FROM  (   SELECT "
			+ "      vistaMM.*, rownum as FilaInt " + "    FROM " + "        V_ESTADO_MM vistaMM, "
			+ "        CLIENTE cliente " + "    JOIN" + "        tident tipo "
			+ "            on tipo.id=cliente.tipoidentificacion_id " + "    WHERE "
			+ "        tipo.descripcion=vistaMM.tipoident_cliente "
			+ "        and vistaMM.num_id_cliente=cliente.numid " + "        and tipo.codigo=:tipoIdentificacion "
			+ "        and cliente.numid=:identificacion "
			+ "        and cliente.entidadfinanciera_id=:idEntidadFinanciera " + "        and cliente.estado=0 "
			+ "        and cliente.esfuentepago=1 " + "   ORDER BY "
			+ "        vistaMM.tipo_cliente desc,FilaInt desc  ) V  ) WHERE FilaExt BETWEEN :registroInicial AND :registroFinal", nativeQuery = true)
	List<VisEstadoMM> listarPorClientePaginado(@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("identificacion") String identificacion, @Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("registroInicial") int registroInicial, @Param("registroFinal") int registroFinal);

	

}
