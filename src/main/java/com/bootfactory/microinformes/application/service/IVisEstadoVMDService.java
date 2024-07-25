package com.bootfactory.microinformes.application.service;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.VisEstadoVMDDTO;

public interface IVisEstadoVMDService {

	Long contar(Long idEntidadFinanciera);

	public List<VisEstadoVMDDTO> listar(Long idEntidadFinanciera);

	public List<VisEstadoVMDDTO> listarPaginado(Long idEntidadFinanciera, int registroInicial, int numeroRegistros);

	Long contarPorCliente(Long tipoIdentificacion, String identificacion, Long idEntidadFinanciera);

	public List<VisEstadoVMDDTO> listarPorCliente(Long tipoIdentificacion, String identificacion,
			Long idEntidadFinanciera);

	public List<VisEstadoVMDDTO> listarPorClientePaginado(Long tipoIdentificacion, String identificacion,
			Long idEntidadFinanciera, int registroInicial, int numeroRegistros);

}
