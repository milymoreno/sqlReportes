package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.ClienteGenericoDTO;
import com.bootfactory.microinformes.domain.model.entity.Cliente;
import com.bootfactory.microinformes.domain.model.enums.EnumTipoCliente;

@Mapper(componentModel = "spring")
public interface ClienteGenericoMapper {
	
	@Mappings({
		@Mapping(target="id",source = "cliente.id"),
		@Mapping(target="tipoIdentificacion",source = "cliente.tipoIdentificacion.descripcion"),
		@Mapping(target="idTipoIdentificacion",source = "cliente.tipoIdentificacion.id"),
		@Mapping(target="numeroIdentificacion",source = "cliente.numId"),
		@Mapping(target="nombre", expression = "java(mapearNombre(cliente))"),
		@Mapping(target="moneda",constant = "PESOS"),
		
	})
	ClienteGenericoDTO clienteToClienteGenericoDTO(Cliente cliente);
	
	
	default String mapearNombre(Cliente cliente) {
        return cliente.getTipoCliente() == EnumTipoCliente.JURIDICO ?
                cliente.getSigla() :
                cliente.getNombre() + " " + cliente.getApellido1() + " " + cliente.getApellido2();
    }
	
	List<ClienteGenericoDTO> toDtoList(List<Cliente> estados);

}
