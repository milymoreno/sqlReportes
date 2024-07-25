package com.bootfactory.microinformes.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bootfactory.microinformes.application.modelDTO.VisAplicacionPagoDTO;
import com.bootfactory.microinformes.domain.model.entity.VisAmortizacion;
import com.bootfactory.microinformes.domain.model.entity.VisAplicacionPagoOperativo;

@Mapper(componentModel = "spring")
public interface VisAplicacionPagoMapper {
	
	@Mappings({
		@Mapping(target="referencia",source = "visAplicacionPagoOperativo.referenciapago"),
		@Mapping(target="valorTotal",source = "visAplicacionPagoOperativo.valorPago"),
		@Mapping(target="estadoReferenciaPago",source = "visAplicacionPagoOperativo.estadoPago"),
		@Mapping(target="referenciasPagoRelacionadas",source = "visAplicacionPagoOperativo.numeroRelacionado"),
		@Mapping(target="numeroObligacion",source = "visAplicacionPagoOperativo.numero"),
		@Mapping(target="numeroRelacionado",source = "visAplicacionPagoOperativo.numeroRelacionado"),
		@Mapping(target="numIdvendedor", expression = "java(concatenarIdentificacion(visAplicacionPagoOperativo.getTiVendedor(),visAplicacionPagoOperativo.getVendedorNumid()))"),
		@Mapping(target="nombreVendedor", source = "visAplicacionPagoOperativo.nombreVendedor"),
		@Mapping(target="numIdComprador", expression = "java(concatenarIdentificacion(visAplicacionPagoOperativo.getTiComprador(),visAplicacionPagoOperativo.getCompradorNumid()))"),
		@Mapping(target="nombreComprador",source = "visAplicacionPagoOperativo.nombreComprador"),
		@Mapping(target="conceptoAplicadoPago",source = "visAplicacionPagoOperativo.concepto"),
		@Mapping(target="valorPagoAplicado",source = "visAplicacionPagoOperativo.valor"),
		@Mapping(target="fechaAplicacion",source = "visAplicacionPagoOperativo.fechaAplicacion"),
		@Mapping(target="fechaAplicacionContable",source = "visAplicacionPagoOperativo.fechaAplicacionContable"),
		@Mapping(target="estadoObligacion",source = "visAplicacionPagoOperativo.estadoObligacion"),
				
	})
	
	
	VisAplicacionPagoDTO VisAplicacionPagoOperativoToVisAplicacionPagoDTO(VisAplicacionPagoOperativo visAplicacionPagoOperativo);
	
	List<VisAplicacionPagoDTO> toDtoList(List<VisAplicacionPagoOperativo> registros);

	default String concatenarIdentificacion(String tipoIdentificacion, String numeroIdentificacion) {
        return tipoIdentificacion + " " + numeroIdentificacion;
    }
	

}
