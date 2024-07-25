package com.bootfactory.microinformes.infrastructure.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootfactory.microinformes.application.modelDTO.EntidadFinancieraDTO;
import com.bootfactory.microinformes.application.modelDTO.MonedaDTO;
import com.bootfactory.microinformes.application.modelDTO.ParametroEntidadDTO;
import com.bootfactory.microinformes.application.modelDTO.ProductoDTO;
import com.bootfactory.microinformes.application.modelDTO.TipoIdentificacionDTO;
import com.bootfactory.microinformes.application.modelDTO.TipoTasaDTO;
import com.bootfactory.microinformes.application.response.ParametrosResponse;
import com.bootfactory.microinformes.application.response.ResponseBody;
import com.bootfactory.microinformes.application.service.IEntidadFinancieraService;
import com.bootfactory.microinformes.application.service.IMonedaService;
import com.bootfactory.microinformes.application.service.IParametroEntidadService;
import com.bootfactory.microinformes.application.service.IProductoService;
import com.bootfactory.microinformes.application.service.ITipoIdentificacionService;
import com.bootfactory.microinformes.application.service.ITipoTasaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/parametros")
@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Datos obtenidos correctamente"),
		@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
		@ApiResponse(responseCode = "401", description = "No autorizado"),
		@ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
		@ApiResponse(responseCode = "500", description = "Error interno del servidor") })
@CrossOrigin(origins = "*") // Permitir solicitudes desde este origen PROVISIONAL PARA PRUEBAS LOCALES
public class ParametrosController {

	private final ITipoIdentificacionService tipoIdentificacionService;
	private final ITipoTasaService tipoTasaService;
	private final IParametroEntidadService parametroEntidadService;
	private final IEntidadFinancieraService entidadFinancieraService;
	private final IMonedaService monedaService;
	private final IProductoService productoService;

	public ParametrosController(ITipoIdentificacionService tipoIdentificacionService, ITipoTasaService tasaService,
			IParametroEntidadService parametroEntidadService, IEntidadFinancieraService entidadFinancieraService,
			IMonedaService monedaService, IProductoService productoService) {
		this.tipoIdentificacionService = tipoIdentificacionService;
		this.tipoTasaService = tasaService;
		this.parametroEntidadService = parametroEntidadService;
		this.entidadFinancieraService = entidadFinancieraService;
		this.monedaService = monedaService;
		this.productoService = productoService;
	}

	@Operation(description = "Obtiene lista de parámetros ")
	@GetMapping("/{idEntidadFinanciera}")
	public ResponseEntity<ResponseBody> listarParametros(
			@Parameter(name = "idEntidadFinanciera", description = "Id de la entidad financiera", required = true) @PathVariable("idEntidadFinanciera") Long idEntidadFinanciera) {

		ParametrosResponse parametrosResponse = new ParametrosResponse();

		List<ParametroEntidadDTO> parametrosEntidad = parametroEntidadService
				.obtenerParametroEntidad(idEntidadFinanciera);
		parametrosResponse.setParametrosEntidad(parametrosEntidad);

		List<TipoIdentificacionDTO> datosTipoIdentificacion = tipoIdentificacionService
				.listarTiposIdentificacion(idEntidadFinanciera);
		parametrosResponse.setTiposIdentificacion(datosTipoIdentificacion);

		List<TipoTasaDTO> datosTipoTasa = tipoTasaService.listarTiposTasas(idEntidadFinanciera);
		parametrosResponse.setTiposTasa(datosTipoTasa);

		List<EntidadFinancieraDTO> datosEntidadFinanciera = entidadFinancieraService
				.obtenerEntidadFinanciera(idEntidadFinanciera);
		parametrosResponse.setEntidadFinanciera(datosEntidadFinanciera);

		List<MonedaDTO> datosMoneda = monedaService.listarMonedasbyEntidadFinanciera(idEntidadFinanciera);
		parametrosResponse.setMonedas(datosMoneda);

		List<ProductoDTO> datosProducto = productoService.listarProductosbyEntidadFinanciera(idEntidadFinanciera);
		parametrosResponse.setProductos(datosProducto);

		parametrosResponse.setExitoso(true);

		return ResponseEntity.ok(parametrosResponse);

	}

}
