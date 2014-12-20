package org.sevenup.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
public class WebMvcConfiguration extends WebMvcConfigurationSupport{
	@Bean @Autowired
	public DomainClassConverter domainClassConverter(ConversionService cs) {
	    return new DomainClassConverter(cs);
	}
}
