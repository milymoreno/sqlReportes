package com.bootfactory.microinformes.infrastructure.web;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootfactory.microinformes.application.modelDTO.ReporteMMDTO;
import com.bootfactory.microinformes.application.modelDTO.VisEstadoMMDTO;
import com.bootfactory.microinformes.application.service.IVisEstadoMMService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/reporteEstadoMM")
@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Datos obtenidos correctamente"),
		@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
		@ApiResponse(responseCode = "401", description = "No autorizado"),
		@ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
		@ApiResponse(responseCode = "500", description = "Error interno del servidor")})
@CrossOrigin(origins = "*") // Permitir solicitudes desde este origen PROVISIONAL PARA PRUEBAS LOCALES
public class VisEstadoMMController {

	private final IVisEstadoMMService service;

	public VisEstadoMMController(IVisEstadoMMService service) {
		this.service = service;
	}

	@Operation(description = "Obtiene la lista  de todos los datos monto máximo para los pagadores filtrado por  id de la entidad financiera")
	@GetMapping("/{idEntidadFinanciera}/{tipoIdentificacion}/{identificacion}/{registroInicial}/{numeroRegistros}")
	public ResponseEntity<ReporteMMDTO> generarReporte(
			@Parameter(name = "idEntidadFinanciera", description = "Id de la entidad financiera", required = true) @PathVariable("idEntidadFinanciera") Long idEntidadFinanciera,
			@Parameter(name = "tipoIdentificacion", description = "Código de tipo de identificación del pagador.  Si la consulta no se realizapor cliente debe tener valor 0. Ejemplos: 1 NIT , 2 Cédula de Ciudadanía, 3	Cédula Extranjería Residente, 4	Cédula Extranjería No Residente, 5	Tarjeta de Identidad, 6	Cédula de Extranjería, 7	Pasaporte, 8	Registro Civil", required = true) @PathVariable("tipoIdentificacion") Long tipoIdentificacion,
			@Parameter(name = "identificacion", description = "Número de identificación del pagador. Si la consulta no se realizapor cliente debe tener valor 0", required = true) @PathVariable("identificacion") String identificacion,
			@Parameter(name = "registroInicial", description = "Número de registro inicial. Para resultados no paginados debe tener valor 0", required = true) @PathVariable("registroInicial") int registroInicial,
			@Parameter(name = "numeroRegistros", description = "Número de registros por página. Para resultados no paginados debe tener valor 0", required = true) @PathVariable("numeroRegistros") int numeroRegistros) {
		if (registroInicial != 0 && numeroRegistros != 0) {
			return listarPaginado(idEntidadFinanciera, tipoIdentificacion, identificacion, registroInicial,
					numeroRegistros);
		} else {
			return listarNoPaginado(idEntidadFinanciera, tipoIdentificacion, identificacion);
			  
		}
	}

	private ResponseEntity<ReporteMMDTO> listarPaginado(Long idEntidadFinanciera, Long tipoIdentificacion,
			String identificacion, int registroInicial, int numeroRegistros) {
		Long nroTotalRegistros;
		List<VisEstadoMMDTO> datos;
		if (tipoIdentificacion != 0 && !identificacion.equals("0")) {
			nroTotalRegistros=service.contarPorCliente(Long.valueOf(tipoIdentificacion), identificacion,
					Long.valueOf(idEntidadFinanciera));
			datos= service.listarPorClientePaginado(Long.valueOf(tipoIdentificacion), identificacion,
					Long.valueOf(idEntidadFinanciera), registroInicial, numeroRegistros);
		} else {
			nroTotalRegistros=service.contar(idEntidadFinanciera);
			datos= service.listarPaginado(Long.valueOf(idEntidadFinanciera), registroInicial, numeroRegistros);
		}
		ReporteMMDTO reporte= new ReporteMMDTO(datos,nroTotalRegistros);
		return ResponseEntity.ok(reporte);
	}

	private ResponseEntity<ReporteMMDTO> listarNoPaginado(Long idEntidadFinanciera, Long tipoIdentificacion,
			String identificacion) {
		Long nroTotalRegistros;
		List<VisEstadoMMDTO> datos;
		if (tipoIdentificacion != 0 && !identificacion.equals("0")) {
			nroTotalRegistros=service.contarPorCliente(Long.valueOf(tipoIdentificacion), identificacion,
					Long.valueOf(idEntidadFinanciera));
			datos= service.listarPorCliente(Long.valueOf(tipoIdentificacion), identificacion,
					Long.valueOf(idEntidadFinanciera));
		} else {
			nroTotalRegistros=service.contar(idEntidadFinanciera);
			datos= service.listar(Long.valueOf(idEntidadFinanciera));
		}
		 ReporteMMDTO reporte= new ReporteMMDTO(datos,nroTotalRegistros);
		return ResponseEntity.ok(reporte);
	}

}
