package com.bootfactory.microinformes.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.VistaEstadoMMMapper;
import com.bootfactory.microinformes.application.modelDTO.VisEstadoMMDTO;
import com.bootfactory.microinformes.application.service.IVisEstadoMMService;
import com.bootfactory.microinformes.domain.model.entity.VisEstadoMM;
import com.bootfactory.microinformes.infrastructure.persistence.VisEstadoMMRepository;



@Service
public class VisEstadoMMService implements IVisEstadoMMService {

	private final VisEstadoMMRepository repository;
	private final VistaEstadoMMMapper mapper;

	public VisEstadoMMService(VistaEstadoMMMapper mapper, VisEstadoMMRepository repository) {
		super();
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public Long contar(Long idEntidadFinanciera) {
			return  repository.contar(idEntidadFinanciera);
	
	}
	@Override
	public List<VisEstadoMMDTO> listar(Long idEntidadFinanciera) {
		List<VisEstadoMM> estados = repository.listar(idEntidadFinanciera);
		return mapper.toDtoList(estados);
	}
	@Override
	public List<VisEstadoMMDTO> listarPaginado(Long idEntidadFinanciera, int registroInicial, int numeroRegistros) {
		int inicio = registroInicial;
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<VisEstadoMM> estados = repository.listarPaginado(idEntidadFinanciera, inicio, registroFinal);
		return mapper.toDtoList(estados);
	}

	
	@Override
	public Long contarPorCliente(Long tipoIdentificacion, String identificacion, Long idEntidadFinanciera) {
		return repository.contarPorCliente(tipoIdentificacion, identificacion, idEntidadFinanciera);

	}
	@Override
	public List<VisEstadoMMDTO> listarPorCliente(Long tipoIdentificacion, String identificacion,
			Long idEntidadFinanciera) {

		List<VisEstadoMM> estados = repository.listarPorCliente(tipoIdentificacion, identificacion,
				idEntidadFinanciera);
		return mapper.toDtoList(estados);
	}
	@Override
	public List<VisEstadoMMDTO> listarPorClientePaginado(Long tipoIdentificacion, String identificacion,
			Long idEntidadFinanciera, int registroInicial, int numeroRegistros) {
		int inicio = registroInicial;
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<VisEstadoMM> estados = repository.listarPorClientePaginado(tipoIdentificacion, identificacion,
				idEntidadFinanciera, inicio, registroFinal);
		return mapper.toDtoList(estados);
	}

}
