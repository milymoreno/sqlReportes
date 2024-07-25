package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bootfactory.microinformes.application.modelDTO.ParametroEntidadDTO;
import com.bootfactory.microinformes.domain.model.entity.ParametroEntidad;

@Mapper(componentModel = "spring")
public interface ParametroEntidadMapper {

	
	ParametroEntidadDTO parametroEntidadToparametroEntidadDTO(ParametroEntidad parametroEntidad);
	
	List<ParametroEntidadDTO> toDtoList(List<ParametroEntidad> parametrosEntidad);
}
