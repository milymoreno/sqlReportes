package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.VisInteresesDTO;
import com.bootfactory.microinformes.domain.model.entity.VisIntereses;




@Mapper(componentModel = "spring")
public interface VisInteresesMapper {	
	@Mappings({
	@Mapping(target="id",source = "visIntereses.id"),
	@Mapping(target="producto", source = "visIntereses.nombreProducto"),
	@Mapping(target="obligacion",source = "visIntereses.numeroObligacion"),
	@Mapping(target="nombreDeudor", expression = "java(mapearNombre(visIntereses))"),
	@Mapping(target="interesesDia",source = "visIntereses.interesesDia"),
	@Mapping(target="interesesAcumulados",source = "visIntereses.interesesAcumulados"),
	@Mapping(target="interesesMoraDia",source = "visIntereses.interesesMoraDia"),
	@Mapping(target="interesesMoraAcumulados",source = "visIntereses.interesesMoraAcumulados"),
	@Mapping(target="fecha",source = "visIntereses.fechaCausacion"),
	
})

	VisInteresesDTO visInteresesToVisInteresesDTO(VisIntereses visIntereses);

List<VisInteresesDTO> toDtoList(List<VisIntereses> registros);

default String mapearNombre(VisIntereses visIntereses) {
    return visIntereses.getTipoCliente() == 1 ?
    		visIntereses.getSiglaCliente() :
    			visIntereses.getNombreCliente() + " " + visIntereses.getApellido1Cliente() + " " + visIntereses.getApellido2Cliente();
}

}
