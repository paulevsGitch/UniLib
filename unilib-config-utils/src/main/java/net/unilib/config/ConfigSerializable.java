package net.unilib.config;

/**
 * Interface that allows class define how it should be serialized to string
 * and deserialized back
 */
public interface ConfigSerializable {
	String asString();
	ConfigSerializable fromString(String value);
}
