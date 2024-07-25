package com.bootfactory.microinformes.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.modelDTO.DesembolsosProgramadosDTO;
import com.bootfactory.microinformes.application.response.ReporteDesembolsosProgramados;
import com.bootfactory.microinformes.application.service.IVisDesembolsosProgramadosService;
import com.bootfactory.microinformes.infrastructure.messaging.MessageService;
import com.bootfactory.microinformes.infrastructure.persistence.VisDesembolsosProgramadosRepository;
@Service
public class VisDesembolsosProgramadosService implements IVisDesembolsosProgramadosService{

	
	@Autowired
	private MessageService messageService;

	private final VisDesembolsosProgramadosRepository repository;

	public VisDesembolsosProgramadosService(VisDesembolsosProgramadosRepository repository) {
		this.repository = repository;
	}

	@Override
	public ReporteDesembolsosProgramados listar(LocalDate fechaCorte) {
		ReporteDesembolsosProgramados reporte = new ReporteDesembolsosProgramados();
		List<DesembolsosProgramadosDTO> datos = new ArrayList<DesembolsosProgramadosDTO>();
		List<DesembolsosProgramadosDTO> tablaResultados = new ArrayList<DesembolsosProgramadosDTO>();
		datos = repository.listar(fechaCorte);
		tablaResultados=generarTabla(datos);
		reporte.setNroTotalRegistros(4L);
		reporte.setMensaje("");
		reporte.setExitoso(true);
		reporte.setDatos(tablaResultados);
		return reporte;
	}

	private List<DesembolsosProgramadosDTO> generarTabla(List<DesembolsosProgramadosDTO> datos) {

		List<DesembolsosProgramadosDTO> tabla = new ArrayList<DesembolsosProgramadosDTO>();

		DesembolsosProgramadosDTO ADC = new DesembolsosProgramadosDTO("ADC", new BigDecimal(0), new BigDecimal(0));
		DesembolsosProgramadosDTO CF = new DesembolsosProgramadosDTO("CF", new BigDecimal(0), new BigDecimal(0));
		DesembolsosProgramadosDTO LT = new DesembolsosProgramadosDTO("LT", new BigDecimal(0), new BigDecimal(0));
		DesembolsosProgramadosDTO TV = new DesembolsosProgramadosDTO("TV", new BigDecimal(0), new BigDecimal(0));

		for (DesembolsosProgramadosDTO desembolsosProgramadosDTOs : datos) {

			if (desembolsosProgramadosDTOs.getProducto().equals("ADC")) {
				ADC.setCantidad(desembolsosProgramadosDTOs.getCantidad());
				ADC.setTotal(desembolsosProgramadosDTOs.getTotal());
			} else if (desembolsosProgramadosDTOs.getProducto().equals("CF")) {
				CF.setCantidad(desembolsosProgramadosDTOs.getCantidad());
				CF.setTotal(desembolsosProgramadosDTOs.getTotal());
			} else if (desembolsosProgramadosDTOs.getProducto().equals("LT")) {
				LT.setCantidad(desembolsosProgramadosDTOs.getCantidad());
				LT.setTotal(desembolsosProgramadosDTOs.getTotal());
			} else if (desembolsosProgramadosDTOs.getProducto().equals("TV") ) {
				TV.setCantidad(desembolsosProgramadosDTOs.getCantidad());
				TV.setTotal(desembolsosProgramadosDTOs.getTotal());
			}

		}	

		tabla.add(ADC);
		tabla.add(CF);
		tabla.add(LT);
		tabla.add(TV);
		return tabla;
	}

}
