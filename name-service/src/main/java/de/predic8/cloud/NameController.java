package de.predic8.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@RestController
public class NameController {
	private final Map<String, String> shortNameToFullName = new HashMap<>();

	@PostConstruct
	public void init() {
		shortNameToFullName.put("tbayer", "Thomas Bayer");
		shortNameToFullName.put("oweiler", "Oliver Weiler");
		shortNameToFullName.put("tpolley", "Tobias Polley");
	}

	@RequestMapping("/name/{shortName}")
	public String name(String shortName) {
		return shortNameToFullName.get(shortName);
	}
}