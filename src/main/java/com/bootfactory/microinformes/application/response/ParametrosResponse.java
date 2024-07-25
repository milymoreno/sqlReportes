package com.bootfactory.microinformes.application.response;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.EntidadFinancieraDTO;
import com.bootfactory.microinformes.application.modelDTO.MonedaDTO;
import com.bootfactory.microinformes.application.modelDTO.ParametroEntidadDTO;
import com.bootfactory.microinformes.application.modelDTO.ProductoDTO;
import com.bootfactory.microinformes.application.modelDTO.TipoIdentificacionDTO;
import com.bootfactory.microinformes.application.modelDTO.TipoTasaDTO;
import com.bootfactory.microinformes.domain.model.entity.Moneda;

public class ParametrosResponse extends ResponseBody {

	List<TipoTasaDTO> tiposTasa;
	List<TipoIdentificacionDTO> tiposIdentificacion;
	List<ParametroEntidadDTO> parametrosEntidad;
	List<EntidadFinancieraDTO> entidadFinanciera;
	List<MonedaDTO> monedas;
	List<ProductoDTO> productos;

	public List<TipoTasaDTO> getTiposTasa() {
		return tiposTasa;
	}

	public void setTiposTasa(List<TipoTasaDTO> tiposTasa) {
		this.tiposTasa = tiposTasa;
	}

	public List<TipoIdentificacionDTO> getTiposIdentificacion() {
		return tiposIdentificacion;
	}

	public void setTiposIdentificacion(List<TipoIdentificacionDTO> tiposIdentificacion) {
		this.tiposIdentificacion = tiposIdentificacion;
	}

	public List<ParametroEntidadDTO> getParametrosEntidad() {
		return parametrosEntidad;
	}

	public void setParametrosEntidad(List<ParametroEntidadDTO> parametrosEntidad) {
		this.parametrosEntidad = parametrosEntidad;
	}

	public List<EntidadFinancieraDTO> getEntidadFinanciera() {
		return entidadFinanciera;
	}

	public void setEntidadFinanciera(List<EntidadFinancieraDTO> entidadFinanciera) {
		this.entidadFinanciera = entidadFinanciera;
	}

	public List<MonedaDTO> getMonedas() {
		return monedas;
	}

	public void setMonedas(List<MonedaDTO> monedas) {
		this.monedas = monedas;
	}

	public List<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoDTO> productos) {
		this.productos = productos;
	}
	
	
	
	
	
	

}
