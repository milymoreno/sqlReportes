package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.DesembolsosProgramadosDTO;

public interface VisDesembolsosProgramadosRepositoryCustom {

	public List<DesembolsosProgramadosDTO> listar(LocalDate fechaCorte);
}
