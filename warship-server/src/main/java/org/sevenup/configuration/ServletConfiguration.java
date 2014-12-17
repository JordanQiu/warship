package org.sevenup.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(WebApplicationConfiguration.class)
@ImportResource({
  "classpath:spring/business-config.xml",
  "classpath:spring/tools-config.xml",
  "classpath:spring/mvc-core-config.xml"
})
public class ServletConfiguration {

}
