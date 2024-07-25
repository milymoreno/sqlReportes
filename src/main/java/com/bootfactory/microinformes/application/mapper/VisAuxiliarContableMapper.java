package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.VisAuxiliarContableDTO;
import com.bootfactory.microinformes.domain.model.entity.VisAuxiliarContable;

@Mapper(componentModel = "spring")
public interface VisAuxiliarContableMapper {
	
	@Mappings({

		
	})
	
	VisAuxiliarContableDTO visAuxiliarContableToVisAuxiliarContableDTO(VisAuxiliarContable visAuxiliarContable);
	
	List<VisAuxiliarContableDTO> toDtoList(List<VisAuxiliarContable> registros);

}
