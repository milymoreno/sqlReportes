package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.VisEstadoMMDTO;
import com.bootfactory.microinformes.domain.model.entity.VisEstadoMM;

@Mapper(componentModel = "spring")
public interface VistaEstadoMMMapper {
	
	@Mappings({
		@Mapping(target="tipoIdentificacion",source = "visEstadoMM.tident"),
		@Mapping(target="identificacion",source = "visEstadoMM.numId"),
	    @Mapping(target = "nombre", expression = "java(visEstadoMM.getTipoCliente() == 1 ? visEstadoMM.getSigla() : (visEstadoMM.getNombre() + \" \" + visEstadoMM.getApellido1() + \" \" + visEstadoMM.getApellido2()))"),
        @Mapping(target = "producto", source = "visEstadoMM.productoMM"),
		@Mapping(target = "montoMaximo", source = "visEstadoMM.valorMM"),
		@Mapping(target = "disponible", source = "visEstadoMM.disponibleMM"),
		@Mapping(target = "utilizado", source = "visEstadoMM.utilizadoMM"),
		@Mapping(target = "estado", source = "visEstadoMM.estadoMM"),
		@Mapping(target = "moneda", source = "visEstadoMM.monedaMM"),
		@Mapping(target = "nombreGerente", source = "visEstadoMM.nombreGerente")
	})
	
	
	VisEstadoMMDTO visestadoMMToVisEstadoMMDTO(VisEstadoMM visEstadoMM);
	
	@Mappings({
		@Mapping(target="tident",source = "visEstadoMMDTO.tipoIdentificacion"),
		@Mapping(target="numId",source = "visEstadoMMDTO.identificacion"),
		@Mapping(target = "nombre", source = "visEstadoMMDTO.nombre"),
		@Mapping(target = "productoMM", source = "visEstadoMMDTO.producto"),
		@Mapping(target = "valorMM", source = "visEstadoMMDTO.montoMaximo"),
		@Mapping(target = "disponibleMM", source = "visEstadoMMDTO.disponible"),
		@Mapping(target = "utilizadoMM", source = "visEstadoMMDTO.utilizado"),
		@Mapping(target = "estadoMM", source = "visEstadoMMDTO.estado"),
		@Mapping(target = "monedaMM", source = "visEstadoMMDTO.moneda"),
		@Mapping(target = "nombreGerente", source = "visEstadoMMDTO.nombreGerente")
	})
	VisEstadoMM visestadoMMDTOToVisEstadoMM(VisEstadoMMDTO visEstadoMMDTO);
	
	List<VisEstadoMMDTO> toDtoList(List<VisEstadoMM> estados);

}
