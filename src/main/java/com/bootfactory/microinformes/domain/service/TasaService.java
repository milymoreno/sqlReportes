package com.bootfactory.microinformes.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.TasaMapper;
import com.bootfactory.microinformes.application.modelDTO.TasaDTO;
import com.bootfactory.microinformes.application.service.ITasaService;
import com.bootfactory.microinformes.domain.model.entity.Tasa;
import com.bootfactory.microinformes.infrastructure.persistence.TasaRepository;

@Service
public class TasaService implements ITasaService{
	private final TasaRepository repository;
	private final TasaMapper mapper;

	public TasaService( TasaRepository repository,TasaMapper mapper) {
		super();
		this.repository = repository;
		this.mapper=mapper;
	}

	
	public List<TasaDTO> listarTasas() {
		List<Tasa> tasas = repository.listarTasas();
		return mapper.toDtoList(tasas);
	}

}
