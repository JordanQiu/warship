package org.sevenup.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "org.sevenup.rest" ,"org.sevenup.service","org.sevenup.repository"})
@Import({RepositoryConfiguration.class, WebMvcConfiguration.class})
public class CoreConfiguration {
}
