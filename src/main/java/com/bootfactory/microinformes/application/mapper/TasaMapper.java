package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bootfactory.microinformes.application.modelDTO.TasaDTO;
import com.bootfactory.microinformes.domain.model.entity.Tasa;

@Mapper(componentModel = "spring")
public interface TasaMapper {
	

	TasaDTO tasaToTasaDTO(Tasa tasa);
	
	List<TasaDTO> toDtoList(List<Tasa> tasas);

}
