package net.unilib.config;

import net.risingworld.api.Plugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {
	private final Map<String, ConfigEntry<?>> entries = new HashMap<>();
	private final Map<String, String> preEntries = new HashMap<>();
	private final List<String> order = new ArrayList<>();
	private final File file;
	
	public Config(File file) {
		this.file = file;
		if (file.exists()) load();
	}
	
	public void save() {
		if (!file.exists()) writeFile();
		else if (entries.size() != preEntries.size()) writeFile();
	}
	
	public void addEntry(String name, float value, String... comments) {
		String stored = preEntries.get(name);
		if (stored != null) value = Float.parseFloat(stored);
		entries.put(name, new ConfigEntry<>(name, value, List.of(comments)));
		order.add(name);
	}
	
	public void addEntry(String name, int value, String... comments) {
		String stored = preEntries.get(name);
		if (stored != null) value = Integer.parseInt(stored);
		entries.put(name, new ConfigEntry<>(name, value, List.of(comments)));
		order.add(name);
	}
	
	public void addEntry(String name, boolean value, String... comments) {
		String stored = preEntries.get(name);
		if (stored != null) value = Boolean.parseBoolean(stored);
		entries.put(name, new ConfigEntry<>(name, value, List.of(comments)));
		order.add(name);
	}
	
	public void addEntry(String name, String value, String... comments) {
		String stored = preEntries.get(name);
		if (stored != null) value = stored;
		entries.put(name, new ConfigEntry<>(name, value, List.of(comments)));
		order.add(name);
	}
	
	public boolean getBool(String name) {
		return (Boolean) entries.get(name).value;
	}
	
	public float getFloat(String name) {
		return (Float) entries.get(name).value;
	}
	
	public int getInt(String name) {
		return (Integer) entries.get(name).value;
	}
	
	public String getString(String name) {
		return (String) entries.get(name).value;
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
			String[] parts = line.split("=");
			String name = parts[0].trim();
			String value = parts[1].trim();
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
