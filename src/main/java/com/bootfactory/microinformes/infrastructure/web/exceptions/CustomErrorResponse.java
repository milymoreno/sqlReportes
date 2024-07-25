package com.bootfactory.microinformes.infrastructure.web.exceptions;

import java.time.LocalDateTime;

public record CustomErrorResponse( LocalDateTime timestamp,int status, String error,String path) {


}
