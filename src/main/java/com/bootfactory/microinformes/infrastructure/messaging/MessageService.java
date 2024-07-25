package com.bootfactory.microinformes.infrastructure.messaging;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
@Service
public class MessageService {
	
	 @Autowired
	    private MessageSource messageSource;

	    public String getMessage(String key) {
	        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
	    }

		public String getMessage(String string, Object[] objects, Locale locale) {
			 return messageSource.getMessage(string, objects, locale);
		}

}
