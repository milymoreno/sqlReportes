package com.bootfactory.microinformes.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.MonedaMapper;
import com.bootfactory.microinformes.application.modelDTO.MonedaDTO;
import com.bootfactory.microinformes.application.service.IMonedaService;
import com.bootfactory.microinformes.domain.model.entity.Moneda;
import com.bootfactory.microinformes.infrastructure.persistence.MonedaRepository;

@Service
public class MonedaService implements IMonedaService {

	private final MonedaRepository repository;
	private final MonedaMapper mapper;

	public MonedaService(MonedaMapper mapper, MonedaRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}

	public List<MonedaDTO> listarMonedasbyEntidadFinanciera(Long idEntidadFinanciera) {

		List<Moneda> monedas = repository.listarMonedasbyEntidadFinanciera(idEntidadFinanciera);
		return mapper.toDtoList(monedas);

	}

}
