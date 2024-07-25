package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.VisEstadoVMDDTO;
import com.bootfactory.microinformes.domain.model.entity.VisEstadoVMD;

@Mapper(componentModel = "spring")
public interface VisEstadoVMDMapper {
	
	@Mappings({

		@Mapping(target="identificacionCliente",source = "visEstadoVMD.numId"),
		@Mapping(target="tipoIdentificacionCliente",source = "visEstadoVMD.tident"),
		@Mapping(target = "nombreCliente", expression = "java(visEstadoVMD.getTipoCliente() == 1 ? visEstadoVMD.getSigla() : (visEstadoVMD.getNombre() + \" \" + visEstadoVMD.getApellido1() + \" \" + visEstadoVMD.getApellido2()))"),
		@Mapping(target = "apellido1Cliente", source = "visEstadoVMD.apellido1"),
		@Mapping(target = "apellido2Cliente", source = "visEstadoVMD.apellido2"),
		@Mapping(target = "siglaCliente", source = "visEstadoVMD.sigla"),
		@Mapping(target = "tipoCliente", source = "visEstadoVMD.tipoCliente"),
        @Mapping(target = "producto", source = "visEstadoVMD.productoVMD"),
		@Mapping(target = "condicion", source = "visEstadoVMD.condicionVMD"),
		@Mapping(target="identificacionContraparte",source = "visEstadoVMD.numIdContraparte"),
		@Mapping(target="tipoIdentificacionContraparte",source = "visEstadoVMD.tidentContraparte"),
		@Mapping(target = "nombreContraparte", expression = "java(visEstadoVMD.getTipoContraparte() == 1 ? visEstadoVMD.getSiglaContraparte() : (visEstadoVMD.getNombreContraparte() + \" \" + visEstadoVMD.getApellido1Contraparte() + \" \" + visEstadoVMD.getApellido2Contraparte()))"),
		@Mapping(target = "apellido1Contraparte", source = "visEstadoVMD.apellido1Contraparte"),
		@Mapping(target = "apellido2Contraparte", source = "visEstadoVMD.apellido2Contraparte"),
		@Mapping(target = "siglaContraparte", source = "visEstadoVMD.siglaContraparte"),
		@Mapping(target = "tipoContraparte", source = "visEstadoVMD.tipoContraparte"),
		@Mapping(target = "da", source = "visEstadoVMD.daVMD"),
		@Mapping(target = "recibe", source = "visEstadoVMD.recibeVMD"),@Mapping(target = "modalidad", source = "visEstadoVMD.modalidadVMD"),
		@Mapping(target = "valor", source = "visEstadoVMD.valorVMD"),
		@Mapping(target = "disponible", source = "visEstadoVMD.disponibleVMD"),
		@Mapping(target = "utilizado", source = "visEstadoVMD.utilizadoVMD"),
		@Mapping(target = "estado", source = "visEstadoVMD.estadoVMD"),
		@Mapping(target = "moneda", source = "visEstadoVMD.monedaVMD")
	})
	
	
	VisEstadoVMDDTO visEstadoVMDToVisEstadoVMDDTO(VisEstadoVMD visEstadoVMD);
	
	@Mappings({

		@Mapping(target="numId",source = "visEstadoVMDDTO.identificacionCliente"),
		@Mapping(target="tident",source = "visEstadoVMDDTO.tipoIdentificacionCliente"),
		@Mapping(target = "nombre", source = "visEstadoVMDDTO.nombreCliente"),
		@Mapping(target = "apellido1", source = "visEstadoVMDDTO.apellido1Cliente"),
		@Mapping(target = "apellido2", source = "visEstadoVMDDTO.apellido2Cliente"),
		@Mapping(target = "sigla", source = "visEstadoVMDDTO.siglaCliente"),
		@Mapping(target = "tipoCliente", source = "visEstadoVMDDTO.tipoCliente"),
        @Mapping(target = "productoVMD", source = "visEstadoVMDDTO.producto"),
		@Mapping(target = "condicionVMD", source = "visEstadoVMDDTO.condicion"),
		@Mapping(target="numIdContraparte",source = "visEstadoVMDDTO.identificacionContraparte"),
		@Mapping(target="tidentContraparte",source = "visEstadoVMDDTO.tipoIdentificacionContraparte"),
		@Mapping(target = "nombreContraparte", source = "visEstadoVMDDTO.nombreContraparte"),
		@Mapping(target = "apellido1Contraparte", source = "visEstadoVMDDTO.apellido1Contraparte"),
		@Mapping(target = "apellido2Contraparte", source = "visEstadoVMDDTO.apellido2Contraparte"),
		@Mapping(target = "siglaContraparte", source = "visEstadoVMDDTO.siglaContraparte"),
		@Mapping(target = "tipoContraparte", source = "visEstadoVMDDTO.tipoContraparte"),
		@Mapping(target = "daVMD", source = "visEstadoVMDDTO.da"),
		@Mapping(target = "recibeVMD", source = "visEstadoVMDDTO.recibe"),
		@Mapping(target = "modalidadVMD", source = "visEstadoVMDDTO.modalidad"),
		@Mapping(target = "valorVMD", source = "visEstadoVMDDTO.valor"),
		@Mapping(target = "disponibleVMD", source = "visEstadoVMDDTO.disponible"),
		@Mapping(target = "utilizadoVMD", source = "visEstadoVMDDTO.utilizado"),
		@Mapping(target = "estadoVMD", source = "visEstadoVMDDTO.estado"),
		@Mapping(target = "monedaVMD", source = "visEstadoVMDDTO.moneda")
	})
	VisEstadoVMD visEstadoVMDDTOToVisEstadoVMD(VisEstadoVMDDTO visEstadoVMDDTO);
	
	List<VisEstadoVMDDTO> toDtoList(List<VisEstadoVMD> estados);



}
