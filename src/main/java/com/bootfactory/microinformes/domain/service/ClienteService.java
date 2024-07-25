package com.bootfactory.microinformes.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.ClienteGenericoMapper;
import com.bootfactory.microinformes.application.mapper.ClienteMapper;
import com.bootfactory.microinformes.application.modelDTO.ClienteGenericoDTO;
import com.bootfactory.microinformes.application.modelDTO.ReporteClienteDTO;
import com.bootfactory.microinformes.application.modelDTO.TipoIdentificacionDTO;
import com.bootfactory.microinformes.application.service.IClienteService;
import com.bootfactory.microinformes.application.service.ITipoIdentificacionService;
import com.bootfactory.microinformes.domain.model.entity.Cliente;
import com.bootfactory.microinformes.domain.model.entity.Producto;
import com.bootfactory.microinformes.domain.model.enums.EnumCausalBloqueo;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoEntidad;
import com.bootfactory.microinformes.infrastructure.messaging.MessageService;
import com.bootfactory.microinformes.infrastructure.persistence.ClienteRepository;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;

@Service
public class ClienteService implements IClienteService {

	@Autowired
    private MessageService messageService;

	private final ClienteRepository repository;
	private final ClienteMapper mapper;
	private final ClienteGenericoMapper mapperGenerico;
	private final ITipoIdentificacionService identificacionService;

	public ClienteService(ClienteMapper mapper, ClienteRepository repository, ClienteGenericoMapper mapperGenerico,ITipoIdentificacionService identificacionService) {
		super();
		this.mapper = mapper;
		this.repository = repository;
		this.mapperGenerico = mapperGenerico;
		this.identificacionService=identificacionService;
	}


	public ReporteClienteDTO buscarPagador(Long idEntidadFinanciera, Long tipoIdentificacion, String identificacion,
			int registroInicial, int numeroRegistros) {
		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = "";
		List<Cliente> pagadores = new ArrayList<Cliente>();
		int inicio = registroInicial;
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<ClienteGenericoDTO> datos = new ArrayList<ClienteGenericoDTO>();
		ReporteClienteDTO reporte;
		nroTotalRegistros = repository.contarPagadorByTipoEIdentificacion(idEntidadFinanciera, tipoIdentificacion,
				identificacion, EnumEstadoEntidad.HABILITADO);
		if (nroTotalRegistros != 0) {
			pagadores = repository.buscarPagadorByTipoEIdentificacion(idEntidadFinanciera, tipoIdentificacion,
					identificacion, EnumEstadoEntidad.HABILITADO, registroInicial, registroFinal);
			datos = mapperGenerico.toDtoList(pagadores);
		} else {
			mensaje = messageService.getMessage("buscarPersona.messages.sinResultados");
		}
		return new ReporteClienteDTO(datos, nroTotalRegistros, exitoso, mensaje);

	}


	public ReporteClienteDTO buscarDeudor(Long idEntidadFinanciera, Long tipoIdentificacion, String identificacion,
			int registroInicial, int numeroRegistros) {
		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = "";
		List<Cliente> deudores = new ArrayList<Cliente>();
		int inicio = registroInicial;
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<ClienteGenericoDTO> datos = new ArrayList<ClienteGenericoDTO>();
		ReporteClienteDTO reporte;
		nroTotalRegistros = repository.contarDeudorByTipoEIdentificacion(idEntidadFinanciera, tipoIdentificacion,
				identificacion, EnumEstadoEntidad.HABILITADO);
		if (nroTotalRegistros != 0) {
			deudores = repository.buscarDeudorByTipoEIdentificacion(idEntidadFinanciera, tipoIdentificacion,
					identificacion, EnumEstadoEntidad.HABILITADO, registroInicial, registroFinal);
			datos = mapperGenerico.toDtoList(deudores);
		} else {
			 mensaje = messageService.getMessage("buscarPersona.messages.sinResultados");
		}
		return new ReporteClienteDTO(datos, nroTotalRegistros, exitoso, mensaje);

	}

	public ReporteClienteDTO listarCompradoresADC(Long idEntidadFinanciera, Long tipoIdentificacion,
			String identificacion, int registroInicial, int numeroRegistros) {
		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = "";
		List<Cliente> compradores = new ArrayList<Cliente>();
		int inicio = registroInicial;
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<ClienteGenericoDTO> datos = new ArrayList<ClienteGenericoDTO>();
		ReporteClienteDTO reporte;
		if (tipoIdentificacion != 0) {

			if (!identificacion.equals("0")) {
				nroTotalRegistros = repository.contarCompradoresADCByIdentificacion(idEntidadFinanciera,
						tipoIdentificacion, identificacion, EnumEstadoEntidad.HABILITADO);
				if (nroTotalRegistros != 0) {
					compradores = repository.listarCompradoresADCByIdentificacionPaginado(idEntidadFinanciera,
							tipoIdentificacion, identificacion, EnumEstadoEntidad.HABILITADO, registroInicial,
							registroFinal);
					datos = mapperGenerico.toDtoList(compradores);
				} else {
					mensaje = "No se encontraron resultados";
				}
				return new ReporteClienteDTO(datos, nroTotalRegistros, exitoso, mensaje);
			} else {
				nroTotalRegistros = repository.contarCompradoresADCByTipoIdentificacion(idEntidadFinanciera,
						tipoIdentificacion, EnumEstadoEntidad.HABILITADO);
				if (nroTotalRegistros != 0) {
					compradores = repository.listarCompradoresADCByTipoIdentificacionPaginado(idEntidadFinanciera,
							tipoIdentificacion, EnumEstadoEntidad.HABILITADO, registroInicial, registroFinal);
					datos = mapperGenerico.toDtoList(compradores);
				} else {
					mensaje = messageService.getMessage("buscarPersona.messages.sinResultados");
				}
				return new ReporteClienteDTO(datos, nroTotalRegistros, exitoso, mensaje);

			}

		} else {
			nroTotalRegistros = repository.contarCompradoresADC(idEntidadFinanciera, EnumEstadoEntidad.HABILITADO);
			if (nroTotalRegistros != 0) {
				compradores = repository.listarCompradoresADCPaginado(idEntidadFinanciera, EnumEstadoEntidad.HABILITADO,
						inicio, registroFinal);
				datos = mapperGenerico.toDtoList(compradores);
			} else {
				mensaje = messageService.getMessage("buscarPersona.messages.sinResultados");
			}
			return new ReporteClienteDTO(datos, nroTotalRegistros, exitoso, mensaje);
		}

	}


	public ReporteClienteDTO listarPagadores(Long idEntidadFinanciera, Long tipoIdentificacion, String identificacion,
			String nombre, int registroInicial, int numeroRegistros) {
		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = "";
		List<Cliente> pagadores = new ArrayList<Cliente>();
		int inicio = registroInicial;
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<ClienteGenericoDTO> datos = new ArrayList<ClienteGenericoDTO>();
		ReporteClienteDTO reporte;
		nroTotalRegistros = repository.contarPagadores(idEntidadFinanciera, EnumEstadoEntidad.HABILITADO,
				tipoIdentificacion, identificacion, nombre);
		if (nroTotalRegistros != 0) {
			pagadores = repository.listarPagadores(idEntidadFinanciera, EnumEstadoEntidad.HABILITADO,
					tipoIdentificacion, identificacion, nombre, inicio, registroFinal);
			datos = mapperGenerico.toDtoList(pagadores);
		} else {
			mensaje = messageService.getMessage("buscarPersona.messages.sinResultados");
		}
		return new ReporteClienteDTO(datos, nroTotalRegistros, exitoso, mensaje);

	}

	public ReporteClienteDTO listarDeudores(Long idEntidadFinanciera, Long tipoIdentificacion, String identificacion,
			String nombre, int registroInicial, int numeroRegistros) {
		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = "";
		List<Cliente> pagadores = new ArrayList<Cliente>();
		int inicio = registroInicial;
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<ClienteGenericoDTO> datos = new ArrayList<ClienteGenericoDTO>();
		ReporteClienteDTO reporte;
		nroTotalRegistros = repository.contarDeudores(idEntidadFinanciera, EnumEstadoEntidad.HABILITADO,
				tipoIdentificacion, identificacion, nombre);
		if (nroTotalRegistros != 0) {
			pagadores = repository.listarDeudores(idEntidadFinanciera, EnumEstadoEntidad.HABILITADO, tipoIdentificacion,
					identificacion, nombre, inicio, registroFinal);
			datos = mapperGenerico.toDtoList(pagadores);
		} else {
			mensaje = messageService.getMessage("buscarPersona.messages.sinResultados");
		}
		return new ReporteClienteDTO(datos, nroTotalRegistros, exitoso, mensaje);

	}

	public ReporteClienteDTO listarClientesNoADC(Long idEntidadFinanciera, Long tipoIdentificacion,
			String identificacion, String nombre, int registroInicial, int numeroRegistros) {
		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = "";
		List<Cliente> clientes = new ArrayList<Cliente>();
		int inicio = registroInicial;
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<ClienteGenericoDTO> datos = new ArrayList<ClienteGenericoDTO>();
		ReporteClienteDTO reporte;
		nroTotalRegistros = repository.contarClientesNoADC(idEntidadFinanciera,EnumEstadoEntidad.HABILITADO,EnumCausalBloqueo.CAUSALBLOQUEOADM, EnumCausalBloqueo.CAUSALLISTAEXCEP,
				 tipoIdentificacion,
				identificacion,nombre);
		if (nroTotalRegistros != 0) {
			clientes = repository.listarClientesNoADC(idEntidadFinanciera, EnumEstadoEntidad.HABILITADO,EnumCausalBloqueo.CAUSALBLOQUEOADM, EnumCausalBloqueo.CAUSALLISTAEXCEP,
					 tipoIdentificacion,
						identificacion,nombre,
					 inicio, registroFinal);
			datos = mapperGenerico.toDtoList(clientes);
		} else {
			mensaje = messageService.getMessage("buscarPersona.messages.sinResultados");
		}
		return new ReporteClienteDTO(datos, nroTotalRegistros, exitoso, mensaje);

	}


	@Override
	public ReporteClienteDTO listarClientesHabilitados(Long idEntidadFinanciera, Long codTipoIdentificacion,
			String identificacion, String nombre, int registroInicial, int numeroRegistros) {
		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = "";
		List<Cliente> clientes = new ArrayList<Cliente>();
		int inicio = registroInicial;
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<ClienteGenericoDTO> datos = new ArrayList<ClienteGenericoDTO>();
		ReporteClienteDTO reporte;
		nroTotalRegistros = repository.contarClientes(idEntidadFinanciera, codTipoIdentificacion,
				identificacion,EnumEstadoEntidad.HABILITADO,nombre);
		if (nroTotalRegistros != 0) {
			clientes = repository.listarClientesPaginado(idEntidadFinanciera, codTipoIdentificacion,
					identificacion,EnumEstadoEntidad.HABILITADO,nombre, inicio, registroFinal);
			datos = mapperGenerico.toDtoList(clientes);
		} else {
			mensaje = messageService.getMessage("buscarPersona.messages.sinResultados");
		}
		return new ReporteClienteDTO(datos, nroTotalRegistros, exitoso, mensaje);
	}


	@Override
	public ReporteClienteDTO listarVendedoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera, Long codTipoIdentificacion,
			String identificacion, String nombre, int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException {
		Long idTipoIdentificacion=0L;
		Long nroTotalRegistros = 0L;
		boolean exitoso = true;
		String mensaje = "";
		List<Cliente> clientes = new ArrayList<Cliente>();
		int inicio = registroInicial;
		int registroFinal = (registroInicial + numeroRegistros) - 1;
		List<ClienteGenericoDTO> datos = new ArrayList<ClienteGenericoDTO>();
		if(codTipoIdentificacion!=null && codTipoIdentificacion!=0) {
			TipoIdentificacionDTO identificacionDTO=consultarTipoIdentificacion(idEntidadFinanciera, codTipoIdentificacion);
			idTipoIdentificacion=identificacionDTO.getId();
		}
		nroTotalRegistros = repository.contarVendedoresPagoOperativo(isBuscar,idEntidadFinanciera, idTipoIdentificacion,
				identificacion,EnumEstadoEntidad.HABILITADO,nombre);
		if (nroTotalRegistros != 0) {
			clientes = repository.listarVendedoresPagoOperativo(isBuscar,idEntidadFinanciera, idTipoIdentificacion,
					identificacion,EnumEstadoEntidad.HABILITADO,nombre, inicio, registroFinal);
			datos = mapperGenerico.toDtoList(clientes);
		} else {
			if(isBuscar) {
				mensaje = messageService.getMessage("reporteAplicacionPagoOperativo.message.sinResultadosVendedor");
			}else {
			mensaje = messageService.getMessage("buscarPersona.messages.sinResultados");
			}
		}
		return new ReporteClienteDTO(datos, nroTotalRegistros, exitoso, mensaje);
	}


	@Override
	public ReporteClienteDTO listarCompradoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera, Long codTipoIdentificacion,
			String identificacion, String nombre, int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException {
		Long idTipoIdentificacion=0L;
			Long nroTotalRegistros = 0L;
	boolean exitoso = true;
	String mensaje = "";
	List<Cliente> clientes = new ArrayList<Cliente>();
	int inicio = registroInicial;
	int registroFinal = (registroInicial + numeroRegistros) - 1;
	List<ClienteGenericoDTO> datos = new ArrayList<ClienteGenericoDTO>();
	if(codTipoIdentificacion!=null && codTipoIdentificacion!=0) {
		TipoIdentificacionDTO identificacionDTO=consultarTipoIdentificacion(idEntidadFinanciera, codTipoIdentificacion);
		idTipoIdentificacion=identificacionDTO.getId();
	}
	nroTotalRegistros = repository.contarCompradoresPagoOperativo(isBuscar,idEntidadFinanciera, idTipoIdentificacion,
			identificacion,EnumEstadoEntidad.HABILITADO,nombre);
	if (nroTotalRegistros != 0) {
		clientes = repository.listarCompradoresPagoOperativo(isBuscar,idEntidadFinanciera, idTipoIdentificacion,
				identificacion,EnumEstadoEntidad.HABILITADO,nombre, inicio, registroFinal);
		datos = mapperGenerico.toDtoList(clientes);
	} else {
		if(isBuscar) {
			mensaje = messageService.getMessage("reporteAplicacionPagoOperativo.message.sinResultadosComprador");
		}else {
		mensaje = messageService.getMessage("buscarPersona.messages.sinResultados");
		}
	}
	return new ReporteClienteDTO(datos, nroTotalRegistros, exitoso, mensaje);
	

}
	
	
	private TipoIdentificacionDTO consultarTipoIdentificacion(Long idEntidadFinanciera,Long codTipoIdentificacion) throws FactoringBusinessLogicException {
		List<TipoIdentificacionDTO> tipoIdentificacion = identificacionService.buscarTipoIdentificacionByCodigo(idEntidadFinanciera, codTipoIdentificacion);
		if (!tipoIdentificacion.isEmpty()) {
			return tipoIdentificacion.get(0);
		} else {
			throw new FactoringBusinessLogicException(messageService.getMessage("reporteAmortizacion.mensaje.error.productoNoExiste"),
					FactoringBusinessLogicException.SeverityException.ERROR, "ERR-");
		}

	}
}