package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bootfactory.microinformes.application.modelDTO.ProductoDTO;
import com.bootfactory.microinformes.domain.model.entity.Producto;
@Mapper(componentModel = "spring")
public interface ProductoMapper {
ProductoDTO productoToProductoDTO(Producto producto);
	
	List<ProductoDTO> toDtoList(List<Producto> productos);

}




	
