package com.bootfactory.microinformes.application.service;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.ProductoDTO;
import com.bootfactory.microinformes.domain.model.entity.Producto;

public interface IProductoService {
	
	public List<ProductoDTO> listarProductosbyEntidadFinanciera(Long idEntidadFinanciera);

	List<Producto> obtenerProductoporId(Long idProducto);

}
