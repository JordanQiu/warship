package org.sevenup.rest.controller.common;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@Produces(MediaType.APPLICATION_JSON)
public class LocationController {

}
