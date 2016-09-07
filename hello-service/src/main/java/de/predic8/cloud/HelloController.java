package de.predic8.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@RestController
public class HelloController {
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/greetings/{shortName}")
	public String hello(@PathVariable("shortName") String shortName) {
		URI uri = UriComponentsBuilder.fromUri(discoveryClient.getInstances("name-service").get(0).getUri())
				.path("/name/{shortName}")
				.buildAndExpand(shortName)
				.toUri();

		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

		return "Hello " + response.getBody() + "!";
	}
}
