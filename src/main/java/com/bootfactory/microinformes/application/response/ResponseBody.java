package com.bootfactory.microinformes.application.response;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = TipoIdentificacionResponse.class, name = "success"),
		@JsonSubTypes.Type(value = TasaResponse.class, name = "success"),
		@JsonSubTypes.Type(value = TipoTasaResponse.class, name = "success"),
		@JsonSubTypes.Type(value = ParametrosResponse.class, name = "success"),
		})
public abstract class ResponseBody {

	String mensaje;
	Long nroTotalRegistros;
	boolean exitoso;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Long getNroTotalRegistros() {
		return nroTotalRegistros;
	}

	public void setNroTotalRegistros(Long nroTotalRegistros) {
		this.nroTotalRegistros = nroTotalRegistros;
	}

	public boolean isExitoso() {
		return exitoso;
	}

	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}

}
