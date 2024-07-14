package com.manfertej.Sherlock.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class SherlockConfig {

    /**
     * Bean to access long strings instead of hardcoding them.
     */
    @Bean
    public MessageSource messageSource() {

        ResourceBundleMessageSource messageSource
                = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

}
