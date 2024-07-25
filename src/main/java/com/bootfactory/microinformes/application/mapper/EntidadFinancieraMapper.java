package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.EntidadFinancieraDTO;
import com.bootfactory.microinformes.domain.model.entity.EntidadFinanciera;

@Mapper(componentModel = "spring")
public interface EntidadFinancieraMapper {
		
	@Mappings({
		@Mapping(target="numeroIdentificacion",source = "entidadFinanciera.numId")		
	})
		EntidadFinancieraDTO entidadFinancieraToentidadFinancieraDTO(EntidadFinanciera entidadFinanciera);
		
	@Mappings({
		@Mapping(target="numId",source = "entidadFinancieraDTO.numeroIdentificacion")		
	})
		EntidadFinanciera entidadFinancieraDTOToentidadFinanciera(EntidadFinancieraDTO entidadFinancieraDTO);
		
		List<EntidadFinancieraDTO> toDtoList(List<EntidadFinanciera> entidades);

	

}
