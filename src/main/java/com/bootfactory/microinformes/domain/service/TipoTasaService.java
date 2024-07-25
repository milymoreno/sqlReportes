package com.bootfactory.microinformes.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.TasaMapper;
import com.bootfactory.microinformes.application.mapper.TipoTasaMapper;
import com.bootfactory.microinformes.application.modelDTO.TasaDTO;
import com.bootfactory.microinformes.application.modelDTO.TipoTasaDTO;
import com.bootfactory.microinformes.application.service.ITasaService;
import com.bootfactory.microinformes.application.service.ITipoTasaService;
import com.bootfactory.microinformes.domain.model.entity.Tasa;
import com.bootfactory.microinformes.domain.model.entity.TipoTasa;
import com.bootfactory.microinformes.infrastructure.persistence.TasaRepository;
import com.bootfactory.microinformes.infrastructure.persistence.TipoTasaRepository;

@Service
public class TipoTasaService implements ITipoTasaService{
	private final TipoTasaRepository repository;
	private final TipoTasaMapper mapper;

	public TipoTasaService( TipoTasaRepository repository,TipoTasaMapper mapper) {
		super();
		this.repository = repository;
		this.mapper=mapper;
	}

	
	public List<TipoTasaDTO> listarTiposTasas(Long idEntidadFinanciera) {
		List<TipoTasa> tasas = repository.listartiposTasas(idEntidadFinanciera);
		return mapper.toDtoList(tasas);
	}

}
