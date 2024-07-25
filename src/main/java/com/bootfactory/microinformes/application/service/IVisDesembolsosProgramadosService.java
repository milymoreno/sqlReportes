package com.bootfactory.microinformes.application.service;

import java.time.LocalDate;

import com.bootfactory.microinformes.application.response.ReporteDesembolsosProgramados;

public interface IVisDesembolsosProgramadosService {

	ReporteDesembolsosProgramados listar(LocalDate fechaCorte);

}
