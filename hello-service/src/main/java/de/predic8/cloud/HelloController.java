package de.predic8.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@RestController
public class HelloController {
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/greetings/{shortName}")
	public String hello(@PathVariable("shortName") String shortName) {
		String fullName = restTemplate.getForObject("http://name-service/names/{shortName}", String.class, shortName);

		return "Hello " + fullName + "!";
	}
}
