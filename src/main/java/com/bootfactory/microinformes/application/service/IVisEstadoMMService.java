package com.bootfactory.microinformes.application.service;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.VisEstadoMMDTO;

public interface IVisEstadoMMService {

	public List<VisEstadoMMDTO> listar(Long idEntidadFinanciera);

	public Long contar(Long idEntidadFinanciera);

	public List<VisEstadoMMDTO> listarPaginado(Long idEntidadFinanciera, int registroInicial, int numeroRegistros);

	public Long contarPorCliente(Long tipoIdentificacion, String identificacion,
			Long idEntidadFinanciera);

	public List<VisEstadoMMDTO> listarPorCliente(Long tipoIdentificacion, String identificacion,
			Long idEntidadFinanciera);

	public List<VisEstadoMMDTO> listarPorClientePaginado(Long tipoIdentificacion, String identificacion,
			Long idEntidadFinanciera, int registroInicial, int numeroRegistros);

}
