package com.bootfactory.microinformes.application.service;

import java.time.LocalDate;

import com.bootfactory.microinformes.application.response.ReporteOperacionesGerente;

public interface IVisOperacionesGerente {

	public ReporteOperacionesGerente listarPaginado(LocalDate fechaInicial, LocalDate fechaFinal, 
			int registroInicial, int registroFinal);
}
