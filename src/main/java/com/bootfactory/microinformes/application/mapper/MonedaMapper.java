package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bootfactory.microinformes.application.modelDTO.MonedaDTO;
import com.bootfactory.microinformes.domain.model.entity.Moneda;

@Mapper(componentModel = "spring")
public interface MonedaMapper {
	
MonedaDTO MonedaToMonedaDTO(Moneda Moneda);
	
	List<MonedaDTO> toDtoList(List<Moneda> monedas);

}
