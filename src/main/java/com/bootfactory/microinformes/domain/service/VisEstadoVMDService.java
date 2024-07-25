package com.bootfactory.microinformes.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.VisEstadoVMDMapper;
import com.bootfactory.microinformes.application.modelDTO.VisEstadoVMDDTO;
import com.bootfactory.microinformes.application.service.IVisEstadoVMDService;
import com.bootfactory.microinformes.domain.model.entity.VisEstadoVMD;
import com.bootfactory.microinformes.infrastructure.persistence.VisEstadoVMDRepository;

@Service
public class VisEstadoVMDService implements IVisEstadoVMDService {
	
	private final VisEstadoVMDRepository repository;
	private final VisEstadoVMDMapper mapper;

	
	public VisEstadoVMDService(VisEstadoVMDMapper mapper, VisEstadoVMDRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}
	
	@Override
	public Long contar(Long idEntidadFinanciera) {
			return  repository.contar(idEntidadFinanciera);
	}
	
	@Override
	public List<VisEstadoVMDDTO> listar(Long idEntidadFinanciera) {
		List<VisEstadoVMD> estados = repository.listar(idEntidadFinanciera);
		return mapper.toDtoList(estados);
	}
	
	@Override
	public List<VisEstadoVMDDTO> listarPaginado(Long idEntidadFinanciera, int registroInicial, int numeroRegistros) {
		int inicio = registroInicial;
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<VisEstadoVMD> estados = repository.listarPaginado(idEntidadFinanciera, inicio, registroFinal);
		return mapper.toDtoList(estados);
	}
	
	@Override
	public Long contarPorCliente(Long tipoIdentificacion, String identificacion, Long idEntidadFinanciera) {
		return repository.contarPorCliente(tipoIdentificacion, identificacion, idEntidadFinanciera);

	}
	
	@Override
	public List<VisEstadoVMDDTO> listarPorCliente(Long tipoIdentificacion, String identificacion,
			Long idEntidadFinanciera) {

		List<VisEstadoVMD> estados = repository.listarPorCliente(tipoIdentificacion, identificacion,
				idEntidadFinanciera);
		return mapper.toDtoList(estados);
	}
	
	@Override
	public List<VisEstadoVMDDTO> listarPorClientePaginado(Long tipoIdentificacion, String identificacion,
			Long idEntidadFinanciera, int registroInicial, int numeroRegistros) {
		int inicio = registroInicial;
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<VisEstadoVMD> estados = repository.listarPorClientePaginado(tipoIdentificacion, identificacion,
				idEntidadFinanciera, inicio, registroFinal);
		return mapper.toDtoList(estados);
	}


}
