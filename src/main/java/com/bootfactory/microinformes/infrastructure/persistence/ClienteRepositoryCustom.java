package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import com.bootfactory.microinformes.domain.model.entity.Cliente;
import com.bootfactory.microinformes.domain.model.enums.EnumCausalBloqueo;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoEntidad;

public interface ClienteRepositoryCustom {
	
	public Long contarPagadores(Long idEntidadFinanciera, EnumEstadoEntidad estado,Long tipoIdentificacion, String identificacion,String nombre);
	
	public List<Cliente> listarPagadores(Long idEntidadFinanciera, EnumEstadoEntidad estado,Long tipoIdentificacion, String identificacion,String nombre,
			int registroInicial, int numeroRegistros);
	
	public Long contarDeudores(Long idEntidadFinanciera, EnumEstadoEntidad estado,Long tipoIdentificacion, String identificacion,String nombre);
	
	public List<Cliente> listarDeudores(Long idEntidadFinanciera, EnumEstadoEntidad estado,Long tipoIdentificacion, String identificacion,String nombre,
			int registroInicial, int numeroRegistros);
	
	public Long contarClientesNoADC(Long idEntidadFinanciera, EnumEstadoEntidad estado, EnumCausalBloqueo causabloqueo,  EnumCausalBloqueo causalistaexcep,Long tipoIdentificacion, String identificacion,String nombre);

	public List<Cliente> listarClientesNoADC(Long idEntidadFinanciera, EnumEstadoEntidad estado, EnumCausalBloqueo causabloqueo,  EnumCausalBloqueo causalistaexcep,Long tipoIdentificacion, String identificacion,String nombre,
			int registroInicial, int numeroRegistros);
	
	public Long contarClientes(Long idEntidadFinanciera,Long codTipoIdentificacion, String identificacion,EnumEstadoEntidad estado, String nombre);

	
	public List<Cliente> listarClientesPaginado(Long idEntidadFinanciera,Long codTipoIdentificacion, String identificacion,EnumEstadoEntidad estado, String nombre, int registroInicial, int numeroRegistros);

	Long contarCompradoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera, Long idTipoIdentificacion, String identificacion,
			EnumEstadoEntidad estado, String nombre);

	Long contarVendedoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera, Long idTipoIdentificacion, String identificacion,
			EnumEstadoEntidad estado, String nombre);

	List<Cliente> listarCompradoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera, Long idTipoIdentificacion,
			String identificacion, EnumEstadoEntidad estado, String nombre, int registroInicial, int numeroRegistros);

	List<Cliente> listarVendedoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera, Long idTipoIdentificacion,
			String identificacion, EnumEstadoEntidad estado, String nombre, int registroInicial, int numeroRegistros);
	
	

}
