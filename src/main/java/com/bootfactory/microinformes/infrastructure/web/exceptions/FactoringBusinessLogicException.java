package com.bootfactory.microinformes.infrastructure.web.exceptions;

public class FactoringBusinessLogicException extends Exception {

    /**
     * Enumerción con los posibles niveles de severidad de la excepción generada
     * 
     * @author ogiral
     */
    public enum SeverityException {
        ERROR, WARNING
    }

    /**
     * Default serial version ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Es el codigo del mensaje para la internacionalización, en caso de que el
     * mensaje deba mostrarse al usuario final
     */
    private String userMessageCode;

    /**
     * Nivel de severidad de esta excepcion
     */
    private SeverityException level = SeverityException.ERROR;

    private Exception rootException;
    
    /**
     * Arreglo de parámetros
     */
    private Object[] params;

    /**
     * @param message
     * @param level
     */
    public FactoringBusinessLogicException(String message, SeverityException level) {
        super(message);
        this.level = level;
    }

    /**
     * @param message
     * @param userCode
     * @param level
     */
    public FactoringBusinessLogicException(String message, SeverityException level,
            String userCode) {
        super(message);
        this.userMessageCode = userCode;
        this.level = level;
    }
    
    /**
     * 
     * @param message mensaje asociado a la Excepción lanzada
     * @param level Nivel de Severidad de la Excepción
     * @param userCode Código del mensaje, en caso de que se requiera mostrar al usuario
     * @param params Arreglo de parámetros que serán mostrados en el mensaje asociado al userCode
     * @author aosorio
     */
    public FactoringBusinessLogicException(String message, SeverityException level,
            String userCode, Object... params) {
        this.userMessageCode = userCode;
        this.level = level;
        this.params = params;
    }

    public FactoringBusinessLogicException(Exception stack, String message,
            SeverityException level) {
        super(message, stack);
        this.level = level;
        this.rootException = stack;
    }

    /**
     * @param stack
     * @param userCode
     * @param level
     */
    public FactoringBusinessLogicException(Exception stack, String message,
            SeverityException level, String userCode) {
        super(message, stack);
        this.userMessageCode = userCode;
        this.level = level;
        this.rootException = stack;
    }
    
    /**
     * 
     * @param stack Excepción encapsulada por el FactoringException
     * @param message mensaje asociado a la Excepción lanzada
     * @param level Nivel de Severidad de la Excepción
     * @param userCode Código del mensaje, en caso de que se requiera mostrar al usuario
     * @param params Arreglo de parámetros que serán mostrados en el mensaje asociado al userCode
     * 
     * @author aosorio
     */
    public FactoringBusinessLogicException(Exception stack, String message,
            SeverityException level, String userCode, Object... params) {
        super(message);
        this.userMessageCode = userCode;
        this.level = level;
        this.rootException = stack;
        this.params = params;
    }    

    /**
     * @return
     */
    public SeverityException getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(SeverityException level) {
        this.level = level;
    }

    /**
     * @return
     */
    public String getUserMessageCode() {
        return userMessageCode;
    }

    /**
     * @param userMessageCode
     */
    public void setUserMessageCode(String userMessageCode) {
        this.userMessageCode = userMessageCode;
    }

    public String getMessage() {
        if (this.rootException != null) {
            return rootException.toString() + " - " + super.getMessage();
        }
        return super.getMessage();
    }
    
    /**
     * Retorna el arreglo de parámetros asignados a la Excepción
     * @return params
     */    
    public Object[] getParams() {
        return params;
    }
    
    /**
     * Asigna un valor al atributo params
     * @param params
     */
    public void setParams(Object[] params) {
        this.params = params;
    }

}
