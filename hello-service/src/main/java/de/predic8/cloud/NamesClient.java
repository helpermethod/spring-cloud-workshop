package de.predic8.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@FeignClient("name-service")
public interface NamesClient {
	@RequestMapping("/names/{shortName}")
	String names(@PathVariable("shortName") String shortName);
}
