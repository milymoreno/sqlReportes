package com.bootfactory.microinformes.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.VisOperacionesGerenteMapper;
import com.bootfactory.microinformes.application.modelDTO.OperacionesGerenteDTO;
import com.bootfactory.microinformes.application.modelDTO.VisOperacionesGerenteDTO;
import com.bootfactory.microinformes.application.response.ReporteOperacionesGerente;
import com.bootfactory.microinformes.application.service.IVisOperacionesGerente;
import com.bootfactory.microinformes.infrastructure.messaging.MessageService;
import com.bootfactory.microinformes.infrastructure.persistence.VisOperacionesGerenteRepository;
@Service
public class VisOperacionesGerenteService implements IVisOperacionesGerente{

	
	
	@Autowired
	private MessageService messageService;

	private final VisOperacionesGerenteRepository repository;
	private final VisOperacionesGerenteMapper mapper;

	public VisOperacionesGerenteService(VisOperacionesGerenteMapper mapper, VisOperacionesGerenteRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public ReporteOperacionesGerente listarPaginado(LocalDate fechaInicial, LocalDate fechaFinal,
			int registroInicial, int numeroRegistros) {

		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = null;
		List<OperacionesGerenteDTO> datosReporte = new ArrayList<OperacionesGerenteDTO>();
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<VisOperacionesGerenteDTO> datos = new ArrayList<VisOperacionesGerenteDTO>();
		ReporteOperacionesGerente reporte = new ReporteOperacionesGerente();
		if (fechaInicial != null && fechaFinal != null) {
			mensaje = validarFechas(fechaInicial, fechaFinal);
		}
		if (mensaje == null) {
			nroTotalRegistros = repository.contar(fechaInicial, fechaFinal);
			if (nroTotalRegistros > 0) {
				datos = repository.listarPaginado(fechaInicial, fechaFinal, registroInicial,
						registroFinal);
				datosReporte = mapper.toDtoList(datos);
			} else {
				exitoso = false;
				mensaje = messageService.getMessage("reporteAuxiliarContable.message.sinResultados");
			}

		}

		reporte.setNroTotalRegistros(nroTotalRegistros);
		reporte.setMensaje(mensaje);
		reporte.setExitoso(exitoso);
		reporte.setDatos(datosReporte);
		return reporte;

	}

	private String validarFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
		String mensaje = "";
		if (fechaInicial != null && (fechaInicial.isBefore(LocalDate.now()) || fechaInicial.isEqual(LocalDate.now()))) {
			if (fechaFinal.isBefore(LocalDate.now()) || fechaFinal.isEqual(LocalDate.now())) {
				if (fechaFinal.isAfter(fechaInicial) || fechaFinal.isEqual(fechaInicial)) {
					return null;
				} else {
					mensaje = messageService.getMessage("reporteAuxiliarContable.regla.6.6");
				}
			} else {
				mensaje = messageService.getMessage("reporteAuxiliarContable.regla.6.4");
			}
		} else {
			mensaje = messageService.getMessage("reporteAuxiliarContable.regla.6.3");
		}
		return mensaje;
	}
	
	
	
	
	


}
