package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.OperacionesGerenteDTO;
import com.bootfactory.microinformes.application.modelDTO.VisOperacionesGerenteDTO;

@Mapper(componentModel = "spring")
public interface VisOperacionesGerenteMapper {
	

		
	@Mappings({
		@Mapping(target="tipoOperacion",source = "visOperacionesGerente.tipoOperacion"),
		@Mapping(target="numeroReferencia",source = "visOperacionesGerente.numeroReferencia"),
		@Mapping(target="numeroObligacion",source = "visOperacionesGerente.numeroObligacion"),
		@Mapping(target="producto",source = "visOperacionesGerente.producto"),
		@Mapping(target="tipoIdentificacionDeudor",source = "visOperacionesGerente.tipoIdent"),
		@Mapping(target="numeroIdentificacionDeudor",source = "visOperacionesGerente.numId"),
		@Mapping(target="nombreVendedor", expression = "java(mapearNombre(visOperacionesGerente))"),
		@Mapping(target="valorOperacion",source = "visOperacionesGerente.valor"),
		@Mapping(target="codigoGerenteRelacion",source = "visOperacionesGerente.codigoGerenteRelacion"),
		@Mapping(target="nombreGerenteRelacion",source = "visOperacionesGerente.nombreGerenteRelacion"),
		@Mapping(target="codigoGerenteProducto",source = "visOperacionesGerente.codigoGerenteProducto"),
		@Mapping(target="nombreGerenteProducto",source = "visOperacionesGerente.nombreGerenteProducto"),
				
	})
		
		OperacionesGerenteDTO visOperacionesGerenteDTOToOperacionesGerenteDTO(VisOperacionesGerenteDTO visOperacionesGerente);
		
		List<OperacionesGerenteDTO> toDtoList(List<VisOperacionesGerenteDTO> registros);

		default String mapearNombre(VisOperacionesGerenteDTO visOperacionesGerente) {
	        return visOperacionesGerente.getTipoCliente() == 1 ?
	        		visOperacionesGerente.getSigla() :
	        			visOperacionesGerente.getNombre() + " " + visOperacionesGerente.getApellido1() + " " + visOperacionesGerente.getApellido2();
	    }

}
