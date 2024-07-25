

package com.bootfactory.microinformes.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.TipoIdentificacionMapper;
import com.bootfactory.microinformes.application.modelDTO.TipoIdentificacionDTO;
import com.bootfactory.microinformes.application.service.ITipoIdentificacionService;
import com.bootfactory.microinformes.domain.model.entity.TipoIdentificacion;
import com.bootfactory.microinformes.infrastructure.persistence.TipoIdentificacionRepository;

@Service
public class TipoIdentificacionService implements ITipoIdentificacionService {

	private final TipoIdentificacionRepository repository;
	private final TipoIdentificacionMapper mapper;

	public TipoIdentificacionService( TipoIdentificacionRepository repository,TipoIdentificacionMapper mapper) {
		super();
		this.repository = repository;
		this.mapper=mapper;
	}

	@Override
	public List<TipoIdentificacionDTO> listarTiposIdentificacion(Long idEntidadFinanciera) {
		List<TipoIdentificacion> tiposIdentificacion = repository.listarTiposIdentificacion(idEntidadFinanciera);
		return mapper.toDtoList(tiposIdentificacion);
	}
	
	@Override
	public List<TipoIdentificacionDTO> buscarTipoIdentificacionByCodigo(Long idEntidadFinanciera, Long codTipoIdentificacion) {
		List<TipoIdentificacion> tiposIdentificacion = repository.buscarTipoIdentificacionByCodigo(idEntidadFinanciera,codTipoIdentificacion);
		return mapper.toDtoList(tiposIdentificacion);
		
	}


}

