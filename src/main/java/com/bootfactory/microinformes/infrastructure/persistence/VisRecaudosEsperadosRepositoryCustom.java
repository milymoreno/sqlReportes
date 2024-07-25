package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.RecaudosEsperadosDTO;

public interface VisRecaudosEsperadosRepositoryCustom {
	
	public List<RecaudosEsperadosDTO> listar(LocalDate fechaCorte);

}
