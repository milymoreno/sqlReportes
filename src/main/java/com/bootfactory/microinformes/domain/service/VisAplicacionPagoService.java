package com.bootfactory.microinformes.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.VisAplicacionPagoMapper;
import com.bootfactory.microinformes.application.modelDTO.TipoIdentificacionDTO;
import com.bootfactory.microinformes.application.modelDTO.VisAplicacionPagoDTO;
import com.bootfactory.microinformes.application.response.ReporteAplicacionPago;
import com.bootfactory.microinformes.application.service.ITipoIdentificacionService;
import com.bootfactory.microinformes.application.service.IVisAplicacionPagoService;
import com.bootfactory.microinformes.domain.model.entity.VisAplicacionPagoOperativo;
import com.bootfactory.microinformes.infrastructure.messaging.MessageService;
import com.bootfactory.microinformes.infrastructure.persistence.VisAplicacionPagoRepository;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;
@Service
public class VisAplicacionPagoService implements IVisAplicacionPagoService{
	
	@Autowired
	private MessageService messageService;
	private final VisAplicacionPagoRepository repository;
	private final VisAplicacionPagoMapper mapper;
	private final ITipoIdentificacionService identificacionService;
	
	public VisAplicacionPagoService(VisAplicacionPagoRepository repository,VisAplicacionPagoMapper mapper,ITipoIdentificacionService identificacionService) {
		this.repository=repository;
		this.mapper=mapper;
		this.identificacionService=identificacionService;
		
	}


	@Override
	public ReporteAplicacionPago listarPaginado(Long idEntidadFinanciera,String referenciaPago, String nroObligacion, LocalDate fechaInicial,
			LocalDate fechaFinal, LocalDate fechaAplicacionContableInicial, LocalDate fechaAplicacionContableFinal,
			Long codTipoIdentificacionComprador, String identificacionComprador, Long codTipoIdentificacionVendedor,
			String identificacionVendedor, int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException {
		
		
		String descTipoIdentificacionComprador=null;
		String descTipoIdentificacionVendedor=null;
		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = null;
		List<VisAplicacionPagoOperativo> movimientos = new ArrayList<VisAplicacionPagoOperativo>();
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<VisAplicacionPagoDTO> datos = new ArrayList<VisAplicacionPagoDTO>();
		ReporteAplicacionPago reporte = new ReporteAplicacionPago();
		if (fechaInicial != null && fechaFinal != null) {
			mensaje = validarFechas(fechaInicial, fechaFinal);
		}
		if (fechaAplicacionContableInicial != null && fechaAplicacionContableFinal != null) {
			mensaje = validarFechas(fechaAplicacionContableInicial, fechaAplicacionContableFinal);
		}
		
		if(codTipoIdentificacionComprador!=null && codTipoIdentificacionComprador!=0) {
			TipoIdentificacionDTO identificacionDTO=consultarTipoIdentificacion(idEntidadFinanciera, codTipoIdentificacionComprador);
			descTipoIdentificacionComprador=identificacionDTO.getDescripcion();
		}
		if(codTipoIdentificacionVendedor!=null && codTipoIdentificacionVendedor!=0) {
			TipoIdentificacionDTO identificacionDTO=consultarTipoIdentificacion(idEntidadFinanciera, codTipoIdentificacionVendedor);
			descTipoIdentificacionVendedor=identificacionDTO.getDescripcion();
		}
		if (mensaje == null) {
						
			nroTotalRegistros = repository.contar( referenciaPago,nroObligacion,  fechaInicial,
					 fechaFinal,  fechaAplicacionContableInicial,  fechaAplicacionContableFinal,
					 descTipoIdentificacionComprador,  identificacionComprador,  descTipoIdentificacionVendedor,
					 identificacionVendedor);
			if (nroTotalRegistros > 0) {
				movimientos = repository.listarPaginado( referenciaPago,  nroObligacion,  fechaInicial,
						 fechaFinal,  fechaAplicacionContableInicial,  fechaAplicacionContableFinal,
						 descTipoIdentificacionComprador,  identificacionComprador,  descTipoIdentificacionVendedor,
						 identificacionVendedor, registroInicial,registroFinal);
				datos = mapper.toDtoList(movimientos);
			} else {
				exitoso = false;
				mensaje = messageService.getMessage("reporteIntereses.message.sinResultados");
			}

		}

		reporte.setNroTotalRegistros(nroTotalRegistros);
		reporte.setMensaje(mensaje);
		reporte.setExitoso(exitoso);
		reporte.setDatos(datos);
		return reporte;

	}

	private String validarFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
		String mensaje = "";
		if (fechaInicial != null && (fechaInicial.isBefore(LocalDate.now()) || fechaInicial.isEqual(LocalDate.now()))) {
			if (fechaFinal.isBefore(LocalDate.now()) || fechaFinal.isEqual(LocalDate.now())) {
				if (fechaFinal.isAfter(fechaInicial) || fechaFinal.isEqual(fechaInicial)) {
					return null;
				} else {
					mensaje = messageService.getMessage("reporteIntereses.regla.fechas.3");
				}
			} else {
				mensaje = messageService.getMessage("reporteIntereses.regla.fechas.2");
			}
		} else {
			mensaje = messageService.getMessage("reporteIntereses.regla.fechas.1");
		}
		return mensaje;
	}
	
	
	private TipoIdentificacionDTO consultarTipoIdentificacion(Long idEntidadFinanciera,Long codTipoIdentificacion) throws FactoringBusinessLogicException {
		List<TipoIdentificacionDTO> tipoIdentificacion = identificacionService.buscarTipoIdentificacionByCodigo(idEntidadFinanciera, codTipoIdentificacion);
		if (!tipoIdentificacion.isEmpty()) {
			return tipoIdentificacion.get(0);
		} else {
			throw new FactoringBusinessLogicException(messageService.getMessage("reporteAmortizacion.mensaje.error.productoNoExiste"),
					FactoringBusinessLogicException.SeverityException.ERROR, "ERR-");
		}

	}
		
		
		
	

}
