package net.unilib.config;

import net.risingworld.api.Plugin;
import net.risingworld.api.utils.Quaternion;
import net.risingworld.api.utils.Vector3f;
import net.risingworld.api.utils.Vector3i;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Config holder class, can save/load config data and provide stored values.
 * Values will be updated if necessary when "addEntry" method is called
 */
public class Config {
	private final Map<String, ConfigEntry<?>> entries = new HashMap<>();
	private final Map<String, String> preEntries = new HashMap<>();
	private final List<String> order = new ArrayList<>();
	private final File file;
	
	public Config(File file) {
		this.file = file;
		if (file.exists()) load();
	}
	
	/**
	 * Saves config file if necessary (there are changes that require saving)
	 */
	public void save() {
		if (!file.exists()) writeFile();
		else if (entries.size() != preEntries.size()) writeFile();
	}
	
	/**
	 * Add boolean entry to the config.
	 * If there is stored value in File it will use it instead
	 * @param name {@link String} entry name
	 * @param value {@code boolean} value
	 * @param comments Array of strings, comments will be added before entry. It is recommended to mention default value
	 */
	public void addEntry(String name, boolean value, String... comments) {
		String stored = preEntries.get(name);
		if (stored != null) value = Boolean.parseBoolean(stored);
		entries.put(name, new ConfigEntry<>(name, value, List.of(comments)));
		order.add(name);
	}
	
	/**
	 * Add float entry to the config.
	 * If there is stored value in File it will use it instead
	 * @param name {@link String} entry name
	 * @param value {@code float} value
	 * @param comments Array of strings, comments will be added before entry. It is recommended to mention default value
	 */
	public void addEntry(String name, float value, String... comments) {
		String stored = preEntries.get(name);
		if (stored != null) value = Float.parseFloat(stored);
		entries.put(name, new ConfigEntry<>(name, value, List.of(comments)));
		order.add(name);
	}
	
	/**
	 * Add int entry to the config.
	 * If there is stored value in File it will use it instead
	 * @param name {@link String} entry name
	 * @param value {@code int} value
	 * @param comments Array of strings, comments will be added before entry. It is recommended to mention default value
	 */
	public void addEntry(String name, int value, String... comments) {
		String stored = preEntries.get(name);
		if (stored != null) value = Integer.parseInt(stored);
		entries.put(name, new ConfigEntry<>(name, value, List.of(comments)));
		order.add(name);
	}
	
	/**
	 * Add {@link String} entry to the config.
	 * If there is stored value in File it will use it instead
	 * @param name {@link String} entry name
	 * @param value {@link String} value
	 * @param comments Array of strings, comments will be added before entry. It is recommended to mention default value
	 */
	public void addEntry(String name, String value, String... comments) {
		String stored = preEntries.get(name);
		if (stored != null) value = stored;
		entries.put(name, new ConfigEntry<>(name, value, List.of(comments)));
		order.add(name);
	}
	
	/**
	 * Add {@link Vector3f} entry to the config.
	 * If there is stored value in File it will use it instead
	 * @param name {@link String} entry name
	 * @param value {@link Vector3f} value
	 * @param comments Array of strings, comments will be added before entry. It is recommended to mention default value
	 */
	public void addEntry(String name, Vector3f value, String... comments) {
		String stored = preEntries.get(name);
		if (stored != null) {
			String[] parts = stored.split(",");
			value.x = Float.parseFloat(parts[0].trim());
			value.y = Float.parseFloat(parts[1].trim());
			value.z = Float.parseFloat(parts[2].trim());
		}
		entries.put(name, new ConfigEntry<>(name, value, List.of(comments)));
		order.add(name);
	}
	
	/**
	 * Add {@link Vector3i} entry to the config.
	 * If there is stored value in File it will use it instead
	 * @param name {@link String} entry name
	 * @param value {@link Vector3i} value
	 * @param comments Array of strings, comments will be added before entry. It is recommended to mention default value
	 */
	public void addEntry(String name, Vector3i value, String... comments) {
		String stored = preEntries.get(name);
		if (stored != null) {
			String[] parts = stored.split(",");
			value.x = Integer.parseInt(parts[0].trim());
			value.y = Integer.parseInt(parts[1].trim());
			value.z = Integer.parseInt(parts[2].trim());
		}
		entries.put(name, new ConfigEntry<>(name, value, List.of(comments)));
		order.add(name);
	}
	
	/**
	 * Add {@link Quaternion} entry to the config.
	 * If there is stored value in File it will use it instead
	 * @param name {@link String} entry name
	 * @param value {@link Quaternion} value
	 * @param comments Array of strings, comments will be added before entry. It is recommended to mention default value
	 */
	public void addEntry(String name, Quaternion value, String... comments) {
		String stored = preEntries.get(name);
		if (stored != null) {
			String[] parts = stored.split(",");
			value.x = Float.parseFloat(parts[0].trim());
			value.y = Float.parseFloat(parts[1].trim());
			value.z = Float.parseFloat(parts[2].trim());
			value.w = Float.parseFloat(parts[3].trim());
		}
		entries.put(name, new ConfigEntry<>(name, value, List.of(comments)));
		order.add(name);
	}
	
	/**
	 * Add {@link ConfigSerializable} entry to the config.
	 * If there is stored value in File it will use it instead.
	 * This method can be used to store enums and custom classes in the config
	 * @param name {@link String} entry name
	 * @param value {@link ConfigSerializable} value
	 * @param comments Array of strings, comments will be added before entry. It is recommended to mention default value
	 */
	public void addEntry(String name, ConfigSerializable value, String... comments) {
		String stored = preEntries.get(name);
		if (stored != null) value = value.fromString(stored);
		entries.put(name, new ConfigEntry<>(name, value, List.of(comments)));
		order.add(name);
	}
	
	/**
	 * Get boolean value from the config
	 * @param name {@link String} entry name
	 * @return {@code boolean}
	 */
	public boolean getBool(String name) {
		return (Boolean) entries.get(name).value;
	}
	
	/**
	 * Get float value from the config
	 * @param name {@link String} entry name
	 * @return {@code float}
	 */
	public float getFloat(String name) {
		return (Float) entries.get(name).value;
	}
	
	/**
	 * Get int value from the config
	 * @param name {@link String} entry name
	 * @return {@code int}
	 */
	public int getInt(String name) {
		return (Integer) entries.get(name).value;
	}
	
	/**
	 * Get {@link String} value from the config
	 * @param name {@link String} entry name
	 * @return {@link String}
	 */
	public String getString(String name) {
		return (String) entries.get(name).value;
	}
	
	/**
	 * Get {@link Vector3f} value from the config
	 * @param name {@link String} entry name
	 * @return {@link Vector3f}
	 */
	public Vector3f getVector3f(String name) {
		return (Vector3f) entries.get(name).value;
	}
	
	/**
	 * Get {@link Vector3i} value from the config
	 * @param name {@link String} entry name
	 * @return {@link Vector3i}
	 */
	public Vector3i getVector3i(String name) {
		return (Vector3i) entries.get(name).value;
	}
	
	/**
	 * Get {@link Quaternion} value from the config
	 * @param name {@link String} entry name
	 * @return {@link Quaternion}
	 */
	public Quaternion getQuaternion(String name) {
		return (Quaternion) entries.get(name).value;
	}
	
	/**
	 * Get {@link ConfigSerializable} value from the config.
	 * Value can represent enum or custom class
	 * @param name {@link String} entry name
	 * @return value that implements {@link ConfigSerializable}
	 */
	@SuppressWarnings("unchecked")
	public <V extends ConfigSerializable> V getSerializable(String name) {
		return (V) entries.get(name).value;
	}
	
	private void writeFile() {
		int max = entries.size() - 1;
		try {
			FileWriter writer = new FileWriter(file);
			for (int i = 0; i < order.size(); i++) {
				entries.get(order.get(i)).append(writer);
				if (i < max) writer.append('\n');
			}
			writer.flush();
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void load() {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(file.toPath());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		if (lines == null) return;
		lines.stream().filter(line -> line.length() > 2 && line.charAt(0) != '#').forEach(line -> {
			int split = line.indexOf('=');
			String name = line.substring(0, split).trim();
			String value = line.substring(split + 1).trim();
			preEntries.put(name, value);
		});
	}
	
	/**
	 * Create a new {@link Config} for selected {@link Plugin}
	 * @param plugin {@link Plugin} that config is created for
	 * @param name {@link String} config name
	 * @return {@link Config}
	 */
	public static Config make(Plugin plugin, String name) {
		File file = new File(plugin.getPath() + "/" + name + ".conf");
		return new Config(file);
	}
}
