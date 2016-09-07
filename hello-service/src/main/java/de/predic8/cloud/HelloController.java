package de.predic8.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@RestController
public class HelloController {
	@Autowired
	private DiscoveryClient discoveryClient;
	@Value("${spring.application.name}")
	private String applicationName;

	@RequestMapping("/hello")
	public String hello() {
		discoveryClient.getInstances(applicationName).forEach(i -> {
			System.out.println(i.getServiceId());
			System.out.println(i.getHost());
			System.out.println(i.getPort());
			i.getMetadata().forEach((k, v) -> {
				System.out.println("k: " + k + " v: " + v);
			});
		});

		return "Hello World!";
	}
}
