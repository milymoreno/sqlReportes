package com.bootfactory.microinformes.application.service;

import java.time.LocalDate;

import com.bootfactory.microinformes.application.response.ReporteRecaudosEsperados;

public interface IVisRecaudosEsperadosService {

	ReporteRecaudosEsperados listar(LocalDate fechaCorte);
	

}
