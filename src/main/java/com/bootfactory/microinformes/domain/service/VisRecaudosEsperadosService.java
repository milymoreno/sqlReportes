package com.bootfactory.microinformes.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.modelDTO.RecaudosEsperadosDTO;
import com.bootfactory.microinformes.application.response.ReporteRecaudosEsperados;
import com.bootfactory.microinformes.application.service.IVisRecaudosEsperadosService;
import com.bootfactory.microinformes.infrastructure.messaging.MessageService;
import com.bootfactory.microinformes.infrastructure.persistence.VisRecaudosEsperadosRepository;

@Service
public class VisRecaudosEsperadosService implements IVisRecaudosEsperadosService {

	@Autowired
	private MessageService messageService;

	private final VisRecaudosEsperadosRepository repository;

	public VisRecaudosEsperadosService(VisRecaudosEsperadosRepository repository) {
		this.repository = repository;
	}

	@Override
	public ReporteRecaudosEsperados listar(LocalDate fechaCorte) {
		ReporteRecaudosEsperados reporte = new ReporteRecaudosEsperados();
		List<RecaudosEsperadosDTO> datos = new ArrayList<RecaudosEsperadosDTO>();
		List<RecaudosEsperadosDTO> tablaResultados = new ArrayList<RecaudosEsperadosDTO>();
		datos = repository.listar(fechaCorte);
		tablaResultados=generarTabla(datos);
		reporte.setNroTotalRegistros(4L);
		reporte.setMensaje("");
		reporte.setExitoso(true);
		reporte.setDatos(tablaResultados);
		return reporte;
	}

	private List<RecaudosEsperadosDTO> generarTabla(List<RecaudosEsperadosDTO> datos) {

		List<RecaudosEsperadosDTO> tabla = new ArrayList<RecaudosEsperadosDTO>();

		RecaudosEsperadosDTO ADC = new RecaudosEsperadosDTO("ADC", new BigDecimal(0), new BigDecimal(0),
				new BigDecimal(0), new BigDecimal(0), new BigDecimal(0));
		RecaudosEsperadosDTO CF = new RecaudosEsperadosDTO("CF", new BigDecimal(0), new BigDecimal(0),
				new BigDecimal(0), new BigDecimal(0), new BigDecimal(0));
		RecaudosEsperadosDTO LT = new RecaudosEsperadosDTO("LT", new BigDecimal(0), new BigDecimal(0),
				new BigDecimal(0), new BigDecimal(0), new BigDecimal(0));
		RecaudosEsperadosDTO TV = new RecaudosEsperadosDTO("TV", new BigDecimal(0), new BigDecimal(0),
				new BigDecimal(0), new BigDecimal(0), new BigDecimal(0));

		for (RecaudosEsperadosDTO recaudosEsperadosDTO : datos) {

			if (recaudosEsperadosDTO.getProducto().equals("ADC")) {
				ADC.setCapital(recaudosEsperadosDTO.getCapital());
				ADC.setInteresCorrientes(recaudosEsperadosDTO.getInteresCorrientes());
				ADC.setInteresMora(recaudosEsperadosDTO.getInteresMora());
				ADC.setOtros(recaudosEsperadosDTO.getOtros());
				ADC.setTotal(recaudosEsperadosDTO.getTotal());
			} else if (recaudosEsperadosDTO.getProducto().equals("CF")) {
				CF.setCapital(recaudosEsperadosDTO.getCapital());
				CF.setInteresCorrientes(recaudosEsperadosDTO.getInteresCorrientes());
				CF.setInteresMora(recaudosEsperadosDTO.getInteresMora());
				CF.setOtros(recaudosEsperadosDTO.getOtros());
				CF.setTotal(recaudosEsperadosDTO.getTotal());
			} else if (recaudosEsperadosDTO.getProducto().equals("LT")) {
				LT.setCapital(recaudosEsperadosDTO.getCapital());
				LT.setInteresCorrientes(recaudosEsperadosDTO.getInteresCorrientes());
				LT.setInteresMora(recaudosEsperadosDTO.getInteresMora());
				LT.setOtros(recaudosEsperadosDTO.getOtros());
				LT.setTotal(recaudosEsperadosDTO.getTotal());
			} else if (recaudosEsperadosDTO.getProducto().equals("TV") ) {
				TV.setCapital(recaudosEsperadosDTO.getCapital());
				TV.setInteresCorrientes(recaudosEsperadosDTO.getInteresCorrientes());
				TV.setInteresMora(recaudosEsperadosDTO.getInteresMora());
				TV.setOtros(recaudosEsperadosDTO.getOtros());
				TV.setTotal(recaudosEsperadosDTO.getTotal());
			}

		}	

		tabla.add(ADC);
		tabla.add(CF);
		tabla.add(LT);
		tabla.add(TV);
		return tabla;
	}

}
