package org.sevenup.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
public class WebMvcConfiguration extends WebMvcConfigurationSupport{

}
