package com.bootfactory.microinformes.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.VisAuxiliarContableMapper;
import com.bootfactory.microinformes.application.modelDTO.VisAuxiliarContableDTO;
import com.bootfactory.microinformes.application.response.ReporteAuxiliarContable;
import com.bootfactory.microinformes.application.service.IVisAuxiliarContableService;
import com.bootfactory.microinformes.domain.model.entity.VisAuxiliarContable;
import com.bootfactory.microinformes.infrastructure.messaging.MessageService;
import com.bootfactory.microinformes.infrastructure.persistence.VisAuxiliarContableRepository;

@Service
public class VisAuxiliarContableService implements IVisAuxiliarContableService {

	@Autowired
	private MessageService messageService;

	private final VisAuxiliarContableRepository repository;
	private final VisAuxiliarContableMapper mapper;

	public VisAuxiliarContableService(VisAuxiliarContableMapper mapper, VisAuxiliarContableRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public ReporteAuxiliarContable listarPaginado(LocalDate fechaInicial, LocalDate fechaFinal, String nroObligacion,
			int registroInicial, int numeroRegistros) {

		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = null;
		List<VisAuxiliarContable> movimientos = new ArrayList<VisAuxiliarContable>();
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<VisAuxiliarContableDTO> datos = new ArrayList<VisAuxiliarContableDTO>();
		ReporteAuxiliarContable reporte = new ReporteAuxiliarContable();
		if (fechaInicial != null && fechaFinal != null) {
			mensaje = validarFechas(fechaInicial, fechaFinal);
		}
		if (mensaje == null) {
			nroTotalRegistros = repository.contar(fechaInicial, fechaFinal, nroObligacion);
			if (nroTotalRegistros > 0) {
				movimientos = repository.listarPaginado(fechaInicial, fechaFinal, nroObligacion, registroInicial,
						registroFinal);
				datos = mapper.toDtoList(movimientos);
			} else {
				exitoso = false;
				mensaje = messageService.getMessage("reporteAuxiliarContable.message.sinResultados");
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
