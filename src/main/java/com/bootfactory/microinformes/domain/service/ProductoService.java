package com.bootfactory.microinformes.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.ProductoMapper;
import com.bootfactory.microinformes.application.modelDTO.ProductoDTO;
import com.bootfactory.microinformes.application.service.IProductoService;
import com.bootfactory.microinformes.domain.model.entity.Producto;
import com.bootfactory.microinformes.infrastructure.persistence.ProductoRepository;

@Service
public class ProductoService implements IProductoService{
	
	
	private final ProductoRepository repository;
	private final ProductoMapper mapper;

	public ProductoService(ProductoRepository repository , ProductoMapper mapper ) {
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public List<ProductoDTO> listarProductosbyEntidadFinanciera(Long idEntidadFinanciera) {

		List<Producto> monedas = repository.listarProductosbyEntidadFinanciera(idEntidadFinanciera);
		return mapper.toDtoList(monedas);

	}
	
	@Override
	public List<Producto> obtenerProductoporId(Long idProducto) {
		return repository.buscarProductoById(idProducto);
	}

	

}
