package com.bootfactory.microinformes.infrastructure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootfactory.microinformes.application.modelDTO.ReporteClienteDTO;
import com.bootfactory.microinformes.application.service.IClienteService;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/cliente")
@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Datos obtenidos correctamente"),
		@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
		@ApiResponse(responseCode = "401", description = "No autorizado"),
		@ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
		@ApiResponse(responseCode = "500", description = "Error interno del servidor") })
@CrossOrigin(origins = "*") // Permitir solicitudes desde este origen PROVISIONAL PARA PRUEBAS LOCALES
public class ClienteController {

	
	private final IClienteService service;

	public ClienteController(IClienteService service) {
		this.service = service;
	}


	@Operation(description = "Obtiene lista de cliente de acuerdo al caso de uso que lo invoca ")
	@GetMapping("/{idCasoUso}/{idEntidadFinanciera}/{tipoIdentificacion}/{identificacion}/{nombre}/{registroInicial}/{numeroRegistros}")
	public ResponseEntity<ReporteClienteDTO> listarClientes(
			@Parameter(name = "idCasoUso", description = "Id del caso de Uso 1-Listar CompradoresADC,10-Crear CompradorADC Buscar Persona, 2-ReporteEstadoMM Buscar Persona, 20-ReporteEstadoMM buscar, 3-ReporteEstadoVMD Buscar Persona, 30-ReporteEstadoVMD buscar, 4-ReporteInformeCartera , 5-ReportePagoOperativo Buscar persona COMPRADOR,5O -ReportePagoOperativo Buscar COMPRADOR, 6-ReportePagoOperativo Buscar persona VENDEDOR, 60-ReportePagoOperativo Buscar VENDEDOR", required = true) @PathVariable("idCasoUso") int idCasoUso,
			@Parameter(name = "idEntidadFinanciera", description = "Id de la entidad financiera", required = true) @PathVariable("idEntidadFinanciera") Long idEntidadFinanciera,
			@Parameter(name = "tipoIdentificacion", description = "Código de tipo de identificación.  Si no se desea aplicar el filtro debe tener valor 0. Ejemplos: 1 NIT , 2 Cédula de Ciudadanía, 3	Cédula Extranjería Residente, 4	Cédula Extranjería No Residente, 5	Tarjeta de Identidad, 6	Cédula de Extranjería, 7	Pasaporte, 8	Registro Civil", required = true) @PathVariable("tipoIdentificacion") Long tipoIdentificacion,
			@Parameter(name = "identificacion", description = "Número de identificación .  Si no se desea aplicar el filtro debe tener valor 0.", required = true) @PathVariable("identificacion") String identificacion,
			@Parameter(name = "nombre", description = "Nombre. .  Si no se desea aplicar el filtro debe tener valor 0", required = true) @PathVariable("nombre") String nombre,
			@Parameter(name = "registroInicial", description = "Número de registro inicial", required = true) @PathVariable("registroInicial") int registroInicial,
			@Parameter(name = "numeroRegistros", description = "Número de registros por página", required = true) @PathVariable("numeroRegistros") int numeroRegistros) throws FactoringBusinessLogicException {
		
		switch (idCasoUso) {
		case 1:
			return listarCompradoresADC(idEntidadFinanciera,tipoIdentificacion,identificacion,registroInicial,numeroRegistros);
		case 10:
			return listarClientesNoADC(idEntidadFinanciera, tipoIdentificacion, identificacion, nombre,registroInicial, numeroRegistros);
		case 2:
			return listarPagadores(idEntidadFinanciera,tipoIdentificacion,identificacion,nombre,registroInicial,numeroRegistros);
		case 20:
			return buscarPagador(idEntidadFinanciera, tipoIdentificacion, identificacion, registroInicial, numeroRegistros);
		case 3:
			return listardeudores(idEntidadFinanciera,tipoIdentificacion,identificacion,nombre,registroInicial,numeroRegistros);
		case 30:
			return buscarDeudor(idEntidadFinanciera, tipoIdentificacion, identificacion, registroInicial, numeroRegistros);
		case 4:
			return listarClientesHabilitados(idEntidadFinanciera,tipoIdentificacion,identificacion,nombre,registroInicial,numeroRegistros);
		case 5:
			return listarCompradoresPagoOperativo(false,idEntidadFinanciera,tipoIdentificacion,identificacion,nombre,registroInicial,numeroRegistros);
		case 50:
			return listarCompradoresPagoOperativo(true,idEntidadFinanciera,tipoIdentificacion,identificacion,nombre,registroInicial,numeroRegistros);
		case 6:
			return listarVendedoresPagoOperativo(false,idEntidadFinanciera,tipoIdentificacion,identificacion,nombre,registroInicial,numeroRegistros);
		case 60: 
			return listarVendedoresPagoOperativo(true,idEntidadFinanciera,tipoIdentificacion,identificacion,nombre,registroInicial,numeroRegistros);
		default:
			throw new IllegalArgumentException("Unexpected value: " + idCasoUso);
		}
	}
	
	
	

	private ResponseEntity<ReporteClienteDTO> listarCompradoresADC(Long idEntidadFinanciera,
			Long tipoIdentificacion, String identificacion, int registroInicial, int numeroRegistros) {
		ReporteClienteDTO reporte =service.listarCompradoresADC(idEntidadFinanciera, tipoIdentificacion, identificacion, registroInicial, numeroRegistros);
		return ResponseEntity.ok(reporte);
	}
	
	
	private ResponseEntity<ReporteClienteDTO> listarClientesNoADC(Long idEntidadFinanciera,
			Long tipoIdentificacion, String identificacion,String nombre, int registroInicial, int numeroRegistros) {
		ReporteClienteDTO reporte =service.listarClientesNoADC(idEntidadFinanciera, tipoIdentificacion, identificacion,nombre, registroInicial, numeroRegistros);
		return ResponseEntity.ok(reporte);
	}
	

	
	
	private ResponseEntity<ReporteClienteDTO> listarPagadores(Long idEntidadFinanciera,
			Long tipoIdentificacion, String identificacion,String nombre, int registroInicial, int numeroRegistros) {
		ReporteClienteDTO reporte =service.listarPagadores(idEntidadFinanciera, tipoIdentificacion, identificacion, nombre,registroInicial, numeroRegistros);
		return ResponseEntity.ok(reporte);
	}
	
	private ResponseEntity<ReporteClienteDTO> buscarPagador(Long idEntidadFinanciera,
			Long tipoIdentificacion, String identificacion, int registroInicial, int numeroRegistros) {
		ReporteClienteDTO reporte =service.buscarPagador(idEntidadFinanciera, tipoIdentificacion, identificacion, registroInicial, numeroRegistros);
		return ResponseEntity.ok(reporte);
	}
	
	private ResponseEntity<ReporteClienteDTO> listardeudores(Long idEntidadFinanciera,
			Long tipoIdentificacion, String identificacion,String nombre, int registroInicial, int numeroRegistros) {
		ReporteClienteDTO reporte =service.listarDeudores(idEntidadFinanciera, tipoIdentificacion, identificacion, nombre,registroInicial, numeroRegistros);
		return ResponseEntity.ok(reporte);
	}
	
	private ResponseEntity<ReporteClienteDTO> buscarDeudor(Long idEntidadFinanciera,
			Long tipoIdentificacion, String identificacion, int registroInicial, int numeroRegistros) {
		ReporteClienteDTO reporte =service.buscarDeudor(idEntidadFinanciera, tipoIdentificacion, identificacion, registroInicial, numeroRegistros);
		return ResponseEntity.ok(reporte);
	}
	
	private ResponseEntity<ReporteClienteDTO> listarClientesHabilitados(Long idEntidadFinanciera,
			Long tipoIdentificacion, String identificacion,String nombre, int registroInicial, int numeroRegistros) {
		ReporteClienteDTO reporte =service.listarClientesHabilitados(idEntidadFinanciera, tipoIdentificacion, identificacion, nombre,registroInicial, numeroRegistros);
		return ResponseEntity.ok(reporte);
	}
	
	
	private ResponseEntity<ReporteClienteDTO> listarVendedoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera,
			Long tipoIdentificacion, String identificacion,String nombre, int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException {
		ReporteClienteDTO reporte =service.listarVendedoresPagoOperativo(isBuscar,idEntidadFinanciera, tipoIdentificacion, identificacion, nombre,registroInicial, numeroRegistros);
		return ResponseEntity.ok(reporte);
	}
	
	
	private ResponseEntity<ReporteClienteDTO> listarCompradoresPagoOperativo(boolean isBuscar, Long idEntidadFinanciera,
			Long tipoIdentificacion, String identificacion,String nombre, int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException {
		ReporteClienteDTO reporte =service.listarCompradoresPagoOperativo(isBuscar,idEntidadFinanciera, tipoIdentificacion, identificacion, nombre,registroInicial, numeroRegistros);
		return ResponseEntity.ok(reporte);
	}
	
	

}
