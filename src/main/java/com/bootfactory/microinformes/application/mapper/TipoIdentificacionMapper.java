package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.ClienteDTO;
import com.bootfactory.microinformes.application.modelDTO.TipoIdentificacionDTO;
import com.bootfactory.microinformes.domain.model.entity.Cliente;
import com.bootfactory.microinformes.domain.model.entity.TipoIdentificacion;

@Mapper(componentModel = "spring")
public interface TipoIdentificacionMapper {
	
	@Mappings({
		@Mapping(target="id",source = "tipoIdentificacion.id"),
		@Mapping(target="codigo",source = "tipoIdentificacion.codigo"),
		@Mapping(target="descripcion",source = "tipoIdentificacion.descripcion"),
	})
	TipoIdentificacionDTO tipoIdentificacionToTipoIdentificacionDTO(TipoIdentificacion tipoIdentificacion);
	
	List<TipoIdentificacionDTO> toDtoList(List<TipoIdentificacion> tiposIdentificacion);

}
