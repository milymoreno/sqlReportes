package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.VisAmortizacionDTO;
import com.bootfactory.microinformes.domain.model.entity.VisAmortizacion;

@Mapper(componentModel = "spring")
public interface VisAmortizacionMapper {
	
	@Mappings({
		@Mapping(target="id",source = "visAmortizacion.id"),
		@Mapping(target="producto", source = "visAmortizacion.nombreProducto"),
		@Mapping(target="obligacion",source = "visAmortizacion.numeroObligacion"),
		@Mapping(target="nombreDeudor", expression = "java(mapearNombre(visAmortizacion))"),
		@Mapping(target="amortizacionDia",source = "visAmortizacion.amortizacionDia"),
		@Mapping(target="amortizacionAcumulada",source = "visAmortizacion.amortizacionAcumulada"),
		@Mapping(target="fecha",source = "visAmortizacion.fechaAmortizacion"),
		
	})
	
	VisAmortizacionDTO visAmortizacionToVisAmortizacionDTO(VisAmortizacion visAmortizacion);
	
	List<VisAmortizacionDTO> toDtoList(List<VisAmortizacion> registros);
	
	default String mapearNombre(VisAmortizacion visAmortizacion) {
        return visAmortizacion.getTipoCliente() == 1 ?
        		visAmortizacion.getSiglaCliente() :
        			visAmortizacion.getNombreCliente() + " " + visAmortizacion.getApellido1Cliente() + " " + visAmortizacion.getApellido2Cliente();
    }

}
