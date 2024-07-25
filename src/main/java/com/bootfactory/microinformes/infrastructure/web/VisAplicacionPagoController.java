package com.bootfactory.microinformes.infrastructure.web;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootfactory.microinformes.application.response.ReporteAplicacionPago;
import com.bootfactory.microinformes.application.service.IVisAplicacionPagoService;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/reporteAplicacionPagoOperativo")
@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Datos obtenidos correctamente"),
		@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
		@ApiResponse(responseCode = "401", description = "No autorizado"),
		@ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
		@ApiResponse(responseCode = "500", description = "Error interno del servidor") })
@CrossOrigin(origins = "*") // Permitir solicitudes desde este origen PROVISIONAL PARA PRUEBAS LOCALES
public class VisAplicacionPagoController {
	
	
	private final IVisAplicacionPagoService service;

	public VisAplicacionPagoController(IVisAplicacionPagoService service) {
		this.service = service;
	}

	
	@Operation(description = "Obtiene el Reporte de AplicacionPagoOperativo")
	@GetMapping("/")
	public ResponseEntity<ReporteAplicacionPago> generarReporte(
			@Parameter(name = "idEntidadFinanciera", description = "Id de la entidad financiera", required = true) @RequestParam(required = true) Long idEntidadFinanciera,
			@Parameter(name = "referenciaPago", description = "referencia de pago",required = false)   @RequestParam(required = false) String referenciaPago,
			@Parameter(name = "nroObligacion", description = "número de obligación", required = false)   @RequestParam(required = false) String nroObligacion,
			@Parameter(name = "fechaInicial", description = "Fecha inicial",example = "dd/MM/yyyy", required = false)  @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(required = false) LocalDate fechaInicial,
			@Parameter(name = "fechaFinal", description = "Fecha final", example = "dd/MM/yyyy",required = false)      @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(required = false) LocalDate fechaFinal,
			@Parameter(name = "fechaAplicacionContableInicial", description = "Fecha inferior aplicacion contable",example = "dd/MM/yyyy", required = false)  @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(required = false) LocalDate fechaAplicacionContableInicial,
			@Parameter(name = "fechaAplicacionContableFinal", description = "Fecha superior aplicacion contable", example = "dd/MM/yyyy",required = false)      @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(required = false) LocalDate fechaAplicacionContableFinal,
			@Parameter(name = "codTipoIdentificacionComprador", description = "código tipo identificación Comprador",required = false)   @RequestParam(required = false) Long codTipoIdentificacionComprador,
			@Parameter(name = "identificacionComprador", description = "número identificación comprador",required = false)   @RequestParam(required = false) String identificacionComprador,
			@Parameter(name = "codTipoIdentificacionVendedor", description = "código tipo identificación Vendedor",required = false)   @RequestParam(required = false) Long codTipoIdentificacionVendedor,
			@Parameter(name = "identificacionVendedor", description = "número identificación comprador",required = false)   @RequestParam(required = false) String identificacionVendedor,
			@Parameter(name = "registroInicial", description = "Número de registro inicial", required = true) @RequestParam("registroInicial") int registroInicial,
			@Parameter(name = "numeroRegistros", description = "Número de registros por página", required = true) @RequestParam("numeroRegistros") int numeroRegistros) throws FactoringBusinessLogicException {
	
			return listarPaginado(idEntidadFinanciera,referenciaPago,nroObligacion,fechaInicial, fechaFinal,fechaAplicacionContableInicial,fechaAplicacionContableFinal,codTipoIdentificacionComprador,identificacionComprador,	codTipoIdentificacionVendedor,identificacionVendedor,registroInicial,numeroRegistros);
				
	}

	private ResponseEntity<ReporteAplicacionPago> listarPaginado(Long idEntidadFinanciera,String referenciaPago, String nroObligacion,
			LocalDate fechaInicial, LocalDate fechaFinal, LocalDate fechaAplicacionContableInicial,
			LocalDate fechaAplicacionContableFinal, Long codTipoIdentificacionComprador, String identificacionComprador,
			Long codTipoIdentificacionVendedor, String identificacionVendedor, int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException {
		ReporteAplicacionPago reporte=service.listarPaginado( idEntidadFinanciera, referenciaPago, nroObligacion, fechaInicial,  fechaFinal,
				fechaAplicacionContableInicial,  fechaAplicacionContableFinal, codTipoIdentificacionComprador,identificacionComprador,codTipoIdentificacionVendedor, identificacionVendedor, registroInicial, numeroRegistros);
		return ResponseEntity.ok(reporte);
	}


	
	

}
