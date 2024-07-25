package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootfactory.microinformes.domain.model.entity.VisEstadoVMD;

@Repository
public interface VisEstadoVMDRepository extends JpaRepository<VisEstadoVMD, Long> {

	@Query(value = "SELECT VISTA.* FROM V_ESTADO_VMD VISTA WHERE ENTIDAD_FINANCIERA= :idEntidadFinanciera", nativeQuery = true)
	List<VisEstadoVMD> listar(@Param("idEntidadFinanciera") Long idEntidadFinanciera);

	@Query(value = "SELECT COUNT(id_vista) FROM V_ESTADO_VMD  WHERE ENTIDAD_FINANCIERA= :idEntidadFinanciera", nativeQuery = true)
	Long contar(@Param("idEntidadFinanciera") Long idEntidadFinanciera);

	@Query(value = "SELECT V.* FROM ( select VISTA.*, rownum as FilaExt from V_ESTADO_VMD VISTA WHERE ENTIDAD_FINANCIERA= :idEntidadFinanciera) V WHERE FilaExt BETWEEN :registroInicial AND :registroFinal", nativeQuery = true)
	List<VisEstadoVMD> listarPaginado(@Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("registroInicial") int registroInicial, @Param("registroFinal") int registroFinal);

	@Query(value = "SELECT COUNT(vistaVMD.id_vista)    FROM " + "        V_ESTADO_VMD vistaVMD, "
			+ "        CLIENTE cliente " + "    JOIN" + "        tident tipo "
			+ "            on tipo.id=cliente.tipoidentificacion_id " + "    WHERE "
			+ "        tipo.descripcion=vistaVMD.tipoident_cliente "
			+ "        and vistaVMD.num_id_cliente=cliente.numid " + "        and tipo.codigo=:tipoIdentificacion "
			+ "        and cliente.numid=:identificacion "
			+ "        and cliente.entidadfinanciera_id=:idEntidadFinanciera " + "        and cliente.estado=0 "
			+ "        and cliente.esDeudor=1 ", nativeQuery = true)
	Long contarPorCliente(@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("identificacion") String identificacion, @Param("idEntidadFinanciera") Long idEntidadFinanciera);

	@Query(value = "SELECT " + "      vistaVMD.* " + "    FROM " + "        V_ESTADO_VMD vistaVMD, "
			+ "        CLIENTE cliente " + "    JOIN" + "        tident tipo "
			+ "            on tipo.id=cliente.tipoidentificacion_id " + "    WHERE "
			+ "        tipo.descripcion=vistaVMD.tipoident_cliente "
			+ "        and vistaVMD.num_id_cliente=cliente.numid " + "        and tipo.codigo=:tipoIdentificacion "
			+ "        and cliente.numid=:identificacion "
			+ "        and cliente.entidadfinanciera_id=:idEntidadFinanciera " + "        and cliente.estado=0 "
			+ "        and cliente.esDeudor=1 ", nativeQuery = true)
	List<VisEstadoVMD> listarPorCliente(@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("identificacion") String identificacion, @Param("idEntidadFinanciera") Long idEntidadFinanciera);

	@Query(value = "SELECT * FROM ( SELECT vistaVMD.*, rownum as FilaExt FROM " + "        V_ESTADO_VMD vistaVMD, "
			+ "        CLIENTE cliente " + "    JOIN" + "        tident tipo "
			+ "            on tipo.id=cliente.tipoidentificacion_id " + "    WHERE "
			+ "        tipo.descripcion=vistaVMD.tipoident_cliente "
			+ "        and vistaVMD.num_id_cliente=cliente.numid " + "        and tipo.codigo=:tipoIdentificacion "
			+ "        and cliente.numid=:identificacion "
			+ "        and cliente.entidadfinanciera_id=:idEntidadFinanciera " + "        and cliente.estado=0 "
			+ "        and cliente.esDeudor=1) "
			+ "        WHERE FilaExt BETWEEN :registroInicial AND :registroFinal", nativeQuery = true)
	List<VisEstadoVMD> listarPorClientePaginado(@Param("tipoIdentificacion") Long tipoIdentificacion,
			@Param("identificacion") String identificacion, @Param("idEntidadFinanciera") Long idEntidadFinanciera,
			@Param("registroInicial") int registroInicial, @Param("registroFinal") int registroFinal);

}
