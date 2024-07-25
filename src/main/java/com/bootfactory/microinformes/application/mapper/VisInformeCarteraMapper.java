package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.VisInformeCarteraDTO;
import com.bootfactory.microinformes.application.modelDTO.VisOperacionesGerenteDTO;
import com.bootfactory.microinformes.domain.model.entity.VisInformeCartera;

@Mapper(componentModel = "spring")
public interface VisInformeCarteraMapper {

	
		@Mappings({
			@Mapping(target="obligacion",source = "visInformeCartera.numeroObligacion"),
			@Mapping(target="numeroFactura",source = "visInformeCartera.numeroFactura"),
			@Mapping(target="identificacion",source = "visInformeCartera.numId"),
			@Mapping(target="nombre",expression = "java(mapearNombre(visInformeCartera))"),
			@Mapping(target="idenContraparte",source = "visInformeCartera.numIdContraparte"),
			@Mapping(target="nombreContraparte",source = "visInformeCartera.nombreContraparte"),
			@Mapping(target="totalCapital",source = "visInformeCartera.totalCapital"),
			@Mapping(target="totalInteresCorriente",source = "visInformeCartera.totalInteresCorriente"),
			@Mapping(target="totalMora",source = "visInformeCartera.totalInteresMora"),
			@Mapping(target="totalOtrosCargos",source = "visInformeCartera.totalOtros"),
			@Mapping(target="saldoALaFecha",source = "visInformeCartera.saldoObligacion"),
			@Mapping(target="fechaVencimiento",source = "visInformeCartera.fechavencimiento"),
			@Mapping(target="diasMora",source = "visInformeCartera.diasMora"),
		
	})
		

	VisInformeCarteraDTO visInformeCarteraToVisInformeCarteraDTO(VisInformeCartera visInformeCartera);

	List<VisInformeCarteraDTO> toDtoList(List<VisInformeCartera> estados);

	default String mapearNombre(VisInformeCartera visInformeCartera) {
        return visInformeCartera.getTipoCliente() == 1 ?
        		visInformeCartera.getSigla() :
        			visInformeCartera.getNombre() + " " + visInformeCartera.getApellido1() + " " + visInformeCartera.getApellido2();
    }
}
