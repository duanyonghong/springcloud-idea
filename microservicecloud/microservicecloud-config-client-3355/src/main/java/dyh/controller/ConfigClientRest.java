package dyh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigClientRest {
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;
	
	@Value("${server.port}")
	private String port;
	
	
	@RequestMapping(value="config")
	@ResponseBody
	public String getConfig() {
		String str = "applicationName: " + applicationName + ", eurekaServers: " + eurekaServers + ", port: " + port;
		System.out.println("****str: " + str);
		return str;
	}
}
