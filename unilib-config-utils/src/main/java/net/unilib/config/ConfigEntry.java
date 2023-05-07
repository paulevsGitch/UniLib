package net.unilib.config;

import net.risingworld.api.utils.Quaternion;
import net.risingworld.api.utils.Vector3f;
import net.risingworld.api.utils.Vector3i;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Class represents config entry
 * @param <T> stored data type
 */
public class ConfigEntry <T> {
	private final List<String> comments = new ArrayList<>();
	private final String name;
	protected final T value;
	
	protected ConfigEntry(String name, T value, List<String> comments) {
		this.comments.addAll(comments);
		this.value = value;
		this.name = name;
	}
	
	protected void append(FileWriter writer) throws IOException {
		for (String comment : comments) {
			writer.append("# ");
			writer.append(comment);
			writer.append('\n');
		}
		writer.append(name);
		writer.append(" = ");
		writer.append(valueAsString());
		writer.append('\n');
	}
	
	private String valueAsString() {
		if (value instanceof Vector3f vec) return String.format(Locale.ROOT, "%f, %f, %f", vec.x, vec.y, vec.z);
		if (value instanceof Vector3i vec) return String.format(Locale.ROOT, "%d, %d, %d", vec.x, vec.y, vec.z);
		if (value instanceof Quaternion q) return String.format(Locale.ROOT, "%f, %f, %f, %f", q.x, q.y, q.z, q.w);
		return String.valueOf(value);
	}
}
