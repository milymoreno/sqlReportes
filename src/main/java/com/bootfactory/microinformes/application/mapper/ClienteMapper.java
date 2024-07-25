package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.ClienteDTO;
import com.bootfactory.microinformes.domain.model.entity.Cliente;


@Mapper(componentModel = "spring")
public interface ClienteMapper {
		
	@Mappings({
		@Mapping(target="numeroIdentificacion",source = "cliente.numId"),
		@Mapping(target="entidadFinanciera.numeroIdentificacion",source = "cliente.entidadFinanciera.numId")
	})
		ClienteDTO clienteToclienteDTO(Cliente cliente);
		
	@Mappings({
		@Mapping(target="numId",source = "clienteDTO.numeroIdentificacion"),
		@Mapping(target="entidadFinanciera.numId",source = "clienteDTO.entidadFinanciera.numeroIdentificacion")
	})
		Cliente clienteDTOTocliente(ClienteDTO clienteDTO);
		
		List<ClienteDTO> toDtoList(List<Cliente> estados);

	

}
