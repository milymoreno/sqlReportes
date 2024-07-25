package com.bootfactory.microinformes.infrastructure.web;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootfactory.microinformes.application.response.ReporteAuxiliarContable;
import com.bootfactory.microinformes.application.service.IVisAuxiliarContableService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/reporteAuxiliarContable")
@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Datos obtenidos correctamente"),
		@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
		@ApiResponse(responseCode = "401", description = "No autorizado"),
		@ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
		@ApiResponse(responseCode = "500", description = "Error interno del servidor") })
@CrossOrigin(origins = "*") // Permitir solicitudes desde este origen PROVISIONAL PARA PRUEBAS LOCALES
public class VisAuxiliarContableController {

	
	private final IVisAuxiliarContableService service;

	public VisAuxiliarContableController(IVisAuxiliarContableService service) {
		this.service = service;
	}

	
	@Operation(description = "Obtiene el Reporte Auxiliar Contable")
	@GetMapping("/")
	public ResponseEntity<ReporteAuxiliarContable> generarReporte(
			@Parameter(name = "fechaInicial", description = "Fecha inicial",example = "dd/MM/yyyy", required = false)  @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(required = false) LocalDate fechaInicial,
			@Parameter(name = "fechaFinal", description = "Fecha final", example = "dd/MM/yyyy",required = false)      @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(required = false) LocalDate fechaFinal,
			@Parameter(name = "nroObligacion", description = "Número de obligación", required = false) @RequestParam(required = false) String nroObligacion,
			@Parameter(name = "registroInicial", description = "Número de registro inicial", required = true) @RequestParam("registroInicial") int registroInicial,
			@Parameter(name = "numeroRegistros", description = "Número de registros por página", required = true) @RequestParam("numeroRegistros") int numeroRegistros) {
	
			return listarPaginado(fechaInicial, fechaFinal, nroObligacion, registroInicial,numeroRegistros);
				
	}

	private ResponseEntity<ReporteAuxiliarContable> listarPaginado(LocalDate fechaInicial, LocalDate fechaFinal,String nroObligacion, int registroInicial, int numeroRegistros) {
		ReporteAuxiliarContable reporte=service.listarPaginado(fechaInicial, fechaFinal, nroObligacion, registroInicial, numeroRegistros);
		return ResponseEntity.ok(reporte);
	}
	

	

}
