package com.bootfactory.microinformes.infrastructure.web;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootfactory.microinformes.application.response.ReporteAmortizacion;
import com.bootfactory.microinformes.application.service.IVisAmortizacionService;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/reporteAmortizacion")
@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Datos obtenidos correctamente"),
		@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
		@ApiResponse(responseCode = "401", description = "No autorizado"),
		@ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
		@ApiResponse(responseCode = "500", description = "Error interno del servidor") })
@CrossOrigin(origins = "*") // Permitir solicitudes desde este origen PROVISIONAL PARA PRUEBAS LOCALES
public class VisAmortizacionController {
	
	private final IVisAmortizacionService service;

	public VisAmortizacionController(IVisAmortizacionService service) {
		this.service = service;
	}

	
	@Operation(description = "Obtiene el Reporte de Amortizacion")
	@GetMapping("/")
	public ResponseEntity<ReporteAmortizacion> generarReporte(
			@Parameter(name = "idProducto", description = "id del producto",required = false)   @RequestParam(required = false) Long idProducto,
			@Parameter(name = "nroObligacion", description = "número de obligación", required = false)   @RequestParam(required = false) String nroObligacion,
			@Parameter(name = "fechaInicial", description = "Fecha inicial",example = "dd/MM/yyyy", required = false)  @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(required = false) LocalDate fechaInicial,
			@Parameter(name = "fechaFinal", description = "Fecha final", example = "dd/MM/yyyy",required = false)      @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(required = false) LocalDate fechaFinal,
			@Parameter(name = "registroInicial", description = "Número de registro inicial", required = true) @RequestParam("registroInicial") int registroInicial,
			@Parameter(name = "numeroRegistros", description = "Número de registros por página", required = true) @RequestParam("numeroRegistros") int numeroRegistros) throws FactoringBusinessLogicException {
	
			return listarPaginado(idProducto,nroObligacion,fechaInicial, fechaFinal,  registroInicial,numeroRegistros);
				
	}

	private ResponseEntity<ReporteAmortizacion> listarPaginado(Long idProducto,String nroObligacion,LocalDate fechaInicial, LocalDate fechaFinal,int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException {
		ReporteAmortizacion reporte=service.listarPaginado(idProducto,nroObligacion,fechaInicial, fechaFinal, registroInicial, numeroRegistros);
		return ResponseEntity.ok(reporte);
	}
	

}
