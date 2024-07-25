package com.bootfactory.microinformes.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.VisInformeCarteraMapper;
import com.bootfactory.microinformes.application.modelDTO.EntidadFinancieraDTO;
import com.bootfactory.microinformes.application.modelDTO.VisInformeCarteraDTO;
import com.bootfactory.microinformes.application.response.ReporteInformeCartera;
import com.bootfactory.microinformes.application.service.IEntidadFinancieraService;
import com.bootfactory.microinformes.application.service.IVisInformeCarteraService;
import com.bootfactory.microinformes.domain.model.entity.Cliente;
import com.bootfactory.microinformes.domain.model.entity.VisInformeCartera;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoEntidad;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoObligacion;
import com.bootfactory.microinformes.domain.model.enums.EnumRolCliente;
import com.bootfactory.microinformes.infrastructure.messaging.MessageService;
import com.bootfactory.microinformes.infrastructure.persistence.ClienteRepository;
import com.bootfactory.microinformes.infrastructure.persistence.VisInformeCarteraRepository;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;
@Service
public class VisInformeCarteraService implements IVisInformeCarteraService{
	
	
	@Autowired
	private MessageService messageService;

	private final VisInformeCarteraRepository repository;
	private final VisInformeCarteraMapper mapper;
	private final ClienteRepository clienteRepository;
	private final IEntidadFinancieraService entidadFinancieraService;

	public VisInformeCarteraService(VisInformeCarteraRepository repository, VisInformeCarteraMapper mapper,ClienteRepository clienteRepository,IEntidadFinancieraService entidadFinancieraService) {
		this.mapper = mapper;
		this.repository = repository;
		this.clienteRepository=clienteRepository;
		this.entidadFinancieraService=entidadFinancieraService;
	}

	
	

	@Override
	public ReporteInformeCartera listarPaginado(Long idEntidadFinanciera, Long codTipoIdentificacion,String identificacion,int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException {
		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = null;
		List<VisInformeCarteraDTO> datosReporte = new ArrayList<VisInformeCarteraDTO>();
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<VisInformeCartera> datos = new ArrayList<VisInformeCartera>();
		ReporteInformeCartera reporte = new ReporteInformeCartera();
		EntidadFinancieraDTO entidadFinanciera=buscarEntidadFinanciera(idEntidadFinanciera);
		String tipoIdentificacion=null;
		String numeroIdentificacion=null;
		if(codTipoIdentificacion!=null && identificacion!=null){
			Cliente cliente=buscarCliente(entidadFinanciera.getId(), codTipoIdentificacion, identificacion, EnumEstadoEntidad.HABILITADO);
			tipoIdentificacion=cliente.getTipoIdentificacion().getDescripcion();
			numeroIdentificacion=cliente.getNumId();
		}
			nroTotalRegistros = repository.contar(entidadFinanciera.getId(),tipoIdentificacion,numeroIdentificacion,EnumRolCliente.DEUDOR,EnumEstadoObligacion.ACTIVA);
			if (nroTotalRegistros > 0) {
				datos = repository.listarPaginado(entidadFinanciera.getId(),tipoIdentificacion,numeroIdentificacion,EnumRolCliente.DEUDOR,EnumEstadoObligacion.ACTIVA, registroInicial,
						registroFinal);
				datosReporte = mapper.toDtoList(datos);
			} else {
				exitoso = false;
				mensaje = messageService.getMessage("reporteInformeCartera.message.sinResultados");
			}

		

		reporte.setNroTotalRegistros(nroTotalRegistros);
		reporte.setMensaje(mensaje);
		reporte.setExitoso(exitoso);
		reporte.setDatos(datosReporte);
		return reporte;
	}
	
	
	private Cliente buscarCliente(Long idEntidadFinanciera, Long codTipoIdentificacion, String identificacion, EnumEstadoEntidad estado) throws FactoringBusinessLogicException{
		List<Cliente> cliente=clienteRepository.buscarCliente(idEntidadFinanciera, codTipoIdentificacion, identificacion, EnumEstadoEntidad.HABILITADO);
		if(!cliente.isEmpty()) {
			return cliente.get(0);
		
		} else {
			throw new FactoringBusinessLogicException(messageService.getMessage("reporteInformeCartera.message.clienteNoExiste"),
					FactoringBusinessLogicException.SeverityException.ERROR, "ERR-");
		
		}
	}
	
	private EntidadFinancieraDTO buscarEntidadFinanciera(Long IdEntidadFinanciera) throws FactoringBusinessLogicException{
		List<EntidadFinancieraDTO> entidadFinancieraDTOs=entidadFinancieraService.obtenerEntidadFinanciera(IdEntidadFinanciera);
		if(!entidadFinancieraDTOs.isEmpty()) {
			return entidadFinancieraDTOs.get(0);
		} else {
			throw new FactoringBusinessLogicException(messageService.getMessage("reporteInformeCartera.message.entidadFinancieraNoExiste"),
					FactoringBusinessLogicException.SeverityException.ERROR, "ERR-");
		
		}
	}

}
