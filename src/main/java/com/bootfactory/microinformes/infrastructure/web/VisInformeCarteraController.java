package com.bootfactory.microinformes.infrastructure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootfactory.microinformes.application.response.ReporteInformeCartera;
import com.bootfactory.microinformes.application.service.IVisInformeCarteraService;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/reporteInformeCartera")
@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Datos obtenidos correctamente"),
		@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
		@ApiResponse(responseCode = "401", description = "No autorizado"),
		@ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
		@ApiResponse(responseCode = "500", description = "Error interno del servidor") })
@CrossOrigin(origins = "*") // Permitir solicitudes desde este origen PROVISIONAL PARA PRUEBAS LOCALES
public class VisInformeCarteraController {
	
	private final IVisInformeCarteraService service;

	public VisInformeCarteraController(IVisInformeCarteraService service) {
		this.service = service;
	}

	
	@Operation(description = "Obtiene el Reporte Informe Cartera")
	@GetMapping("/")
	public ResponseEntity<ReporteInformeCartera> generarReporte(
			@Parameter(name = "idEntidadFinanciera", description = "Id Entidad Financiera", required = true)   @RequestParam(required = true) Long idEntidadFinanciera,
			@Parameter(name = "codTipoIdentificacion", description = "Código Tipo Identificación", required = false)   @RequestParam(required = false) Long codTipoIdentificacion,
			@Parameter(name = "identificacion", description = "Número Identificación Cliente", required = false)   @RequestParam(required = false) String identificacion,
			@Parameter(name = "registroInicial", description = "Número de registro inicial", required = true) @RequestParam("registroInicial") int registroInicial,
			@Parameter(name = "numeroRegistros", description = "Número de registros por página", required = true) @RequestParam("numeroRegistros") int numeroRegistros) throws FactoringBusinessLogicException {
	
			return listarPaginado(idEntidadFinanciera,codTipoIdentificacion,identificacion,  registroInicial,numeroRegistros);
				
	}

	private ResponseEntity<ReporteInformeCartera> listarPaginado(Long idEntidadFinanciera, Long codTipoIdentificacion,String identificacion,int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException {
		ReporteInformeCartera reporte=service.listarPaginado(idEntidadFinanciera,codTipoIdentificacion,identificacion,  registroInicial,numeroRegistros);
		return ResponseEntity.ok(reporte);
	}

}
