package com.bootfactory.microinformes.domain.model.enums;



/**
 * <strong>CC659:</strong><br />
 * Representa los distintos valores que puede tomar el parámetro Utiliza token del cliente de la entidad financiera.
 * 
 * @author prodas
 *
 */
public enum EnumUtilizaToken {
	
	/** No utiliza ni token ni scratch */
	NO_TOKEN_SCRATCH("ENM.UTILIZATOKEN.1"),
	/** Utiliza token y scratch */
	TOKEN_SCRATCH("ENM.UTILIZATOKEN.2"),
	/** Utiliza scratch pero no token */
	SCRATCH_NO_TOKEN("ENM.UTILIZATOKEN.3");
	
	/**
     * Código para el mensaje de internacionalización
     */
    private final String codMessg;

    /**
     * Constructor para un valor de una enumeracion
     * 
     * @param codMes
     *                Es el código para el mensaje de internacionalización
     */
    private EnumUtilizaToken(String codMes) {
        this.codMessg = codMes;
    }

    /**
     * Retorna el código del mensaje de internacionalización para el valor del
     * elemento de la enumeracion
     * 
     * @return codMessg Código de internacionalización
     */
    public String getCodMessg() {
        return codMessg;
    }
			
}
