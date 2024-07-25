package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.TipoTasaDTO;
import com.bootfactory.microinformes.domain.model.entity.TipoTasa;

@Mapper(componentModel = "spring")
public interface TipoTasaMapper {

	
	
		TipoTasaDTO tipoTasaTotipoTasaDTO(TipoTasa tipoTasa);
		
		List<TipoTasaDTO> toDtoList(List<TipoTasa> tipostasas);

	


}
