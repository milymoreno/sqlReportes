package com.bootfactory.microinformes.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.VisAmortizacionMapper;
import com.bootfactory.microinformes.application.modelDTO.VisAmortizacionDTO;
import com.bootfactory.microinformes.application.response.ReporteAmortizacion;
import com.bootfactory.microinformes.application.service.IProductoService;
import com.bootfactory.microinformes.application.service.IVisAmortizacionService;
import com.bootfactory.microinformes.domain.model.entity.Producto;
import com.bootfactory.microinformes.domain.model.entity.VisAmortizacion;
import com.bootfactory.microinformes.infrastructure.messaging.MessageService;
import com.bootfactory.microinformes.infrastructure.persistence.VisAmortizacionRepository;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;
@Service
public class VisAmortizacionService implements IVisAmortizacionService{

	
	
	@Autowired
	private MessageService messageService;

	private final VisAmortizacionRepository repository;
	private final VisAmortizacionMapper mapper;
	private final IProductoService productoService;

	public VisAmortizacionService(VisAmortizacionMapper mapper, VisAmortizacionRepository repository,IProductoService productoService) {
		this.mapper = mapper;
		this.repository = repository;
		this.productoService=productoService;
	}

	@Override
	public ReporteAmortizacion listarPaginado(Long idProducto, String nroObligacion, LocalDate fechaInicial,
			LocalDate fechaFinal, int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException {

		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = null;
		String nombreProducto=null;
		List<VisAmortizacion> movimientos = new ArrayList<VisAmortizacion>();
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<VisAmortizacionDTO> datos = new ArrayList<VisAmortizacionDTO>();
		ReporteAmortizacion reporte = new ReporteAmortizacion();
		if (fechaInicial != null && fechaFinal != null) {
			mensaje = validarFechas(fechaInicial, fechaFinal);
		}
		if (mensaje == null) {
			if(idProducto!=null) {
				Producto producto=consultarProducto(idProducto);
				nombreProducto=producto.getNombre();
			}
			
			nroTotalRegistros = repository.contar(fechaInicial, fechaFinal, nroObligacion,nombreProducto);
			if (nroTotalRegistros > 0) {
				movimientos = repository.listarPaginado(fechaInicial, fechaFinal, nroObligacion,nombreProducto, registroInicial,
						registroFinal);
				datos = mapper.toDtoList(movimientos);
			} else {
				exitoso = false;
				mensaje = messageService.getMessage("reporteAmortizacion.message.sinResultados");
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
					mensaje = messageService.getMessage("reporteAmortizacion.regla.fechas.3");
				}
			} else {
				mensaje = messageService.getMessage("reporteAmortizacion.regla.fechas.2");
			}
		} else {
			mensaje = messageService.getMessage("reporteAmortizacion.regla.fechas.1");
		}
		return mensaje;
	}
	


	private Producto consultarProducto(Long idProducto) throws FactoringBusinessLogicException {
		List<Producto> producto = productoService.obtenerProductoporId(idProducto);
		if (!producto.isEmpty()) {
			return producto.get(0);
		} else {
			throw new FactoringBusinessLogicException(messageService.getMessage("reporteAmortizacion.mensaje.error.productoNoExiste"),
					FactoringBusinessLogicException.SeverityException.ERROR, "ERR-");
		}

	}
}
