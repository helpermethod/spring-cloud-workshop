package de.predic8.cloud;

import org.springframework.stereotype.Component;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@Component
public class NamesClientFallback implements NamesClient {
	@Override
	public String names(String shortName) {
		return shortName;
	}
}
