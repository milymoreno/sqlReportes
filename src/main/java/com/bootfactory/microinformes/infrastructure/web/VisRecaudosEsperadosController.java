package com.bootfactory.microinformes.infrastructure.web;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootfactory.microinformes.application.response.ReporteRecaudosEsperados;
import com.bootfactory.microinformes.application.service.IVisRecaudosEsperadosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/reporteRecaudosEsperados")
@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Datos obtenidos correctamente"),
		@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
		@ApiResponse(responseCode = "401", description = "No autorizado"),
		@ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
		@ApiResponse(responseCode = "500", description = "Error interno del servidor") })
@CrossOrigin(origins = "*") // Permitir solicitudes desde este origen PROVISIONAL PARA PRUEBAS LOCALES
public class VisRecaudosEsperadosController {

	private final IVisRecaudosEsperadosService service;

	public VisRecaudosEsperadosController(IVisRecaudosEsperadosService service) {
		this.service = service;
	}

	@Operation(description = "Obtiene el Reporte Recaudos Esperados")
	@GetMapping("/")
	public ResponseEntity<ReporteRecaudosEsperados> generarReporte(
			@Parameter(name = "fechaCorte", description = "Fecha Corte", example = "dd/MM/yyyy", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(required = false) LocalDate fechaCorte
			) {

		return listar(fechaCorte);

	}

	private ResponseEntity<ReporteRecaudosEsperados> listar(LocalDate fechaCorte) {
		ReporteRecaudosEsperados reporte = service.listar(fechaCorte);
		return ResponseEntity.ok(reporte);
	}

}
