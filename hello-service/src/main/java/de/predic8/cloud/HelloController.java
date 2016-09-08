package de.predic8.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@RestController
public class HelloController {
//	@Autowired
//	private NameResolver nameResolver;
	@Autowired
	private NamesClient namesClient;

	@RequestMapping("/greetings/{shortName}")
	public String hello(@PathVariable("shortName") String shortName) {
//		String fullName = nameResolver.names(shortName);
		String fullName = namesClient.names(shortName);

		return "Hello " + fullName + "!";
	}
}