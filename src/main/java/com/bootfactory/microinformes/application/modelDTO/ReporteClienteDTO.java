package com.bootfactory.microinformes.application.modelDTO;

import java.util.List;

	public record ReporteClienteDTO(List<ClienteGenericoDTO> datos,Long nroTotalRegistros,boolean exitoso,String mensaje){

}
