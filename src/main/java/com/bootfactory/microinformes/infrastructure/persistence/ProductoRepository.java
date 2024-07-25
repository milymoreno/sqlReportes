package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bootfactory.microinformes.domain.model.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	@Query(value = "select p.* from producto p join entfin_producto  e on p.id=e.producto_id"
			+ " WHERE \r\n"
			+ "e.entidadfinanciera_id=:idEntidadFinanciera\r\n", nativeQuery = true)
	public List<Producto> listarProductosbyEntidadFinanciera( Long idEntidadFinanciera);
	
	
	@Query(value="select p from Producto p\r\n"
			+ "where p.id = :idProducto")
	public List<Producto> buscarProductoById(@Param("idProducto") Long idProducto);

}
