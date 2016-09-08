package de.predic8.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@Service
public class NameResolver {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "shortName")
	public String names(String shortName) {
		return restTemplate.getForObject("http://localhost:8081/names/{shortName}", String.class, shortName);
	}

	// return the shortName as a fallback
	public String shortName(String shortName) {
		return shortName;
	}
}
