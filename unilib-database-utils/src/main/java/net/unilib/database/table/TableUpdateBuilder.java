package net.unilib.database.table;

import java.util.HashMap;
import java.util.Map;

/**
 * Table update request builder
 */
public class TableUpdateBuilder {
	private static final TableUpdateBuilder INSTANCE = new TableUpdateBuilder();
	
	private final Map<String, Object> data = new HashMap<>(256);
	private String condition;
	private DataTable table;
	
	private TableUpdateBuilder() {}
	
	/**
	 * Starts a new request building for specified {@link DataTable}
	 * All updaters are the same instance (not multi-thread-safe)
	 * @param table target {@link DataTable}
	 * @return {@link TableUpdateBuilder} instance
	 */
	public static TableUpdateBuilder start(DataTable table, String condition) {
		INSTANCE.data.clear();
		INSTANCE.table = table;
		INSTANCE.condition = condition;
		return INSTANCE;
	}
	
	/**
	 * Add new value to request
	 * @param name {@link String} column name
	 * @param value {@link Object} value
	 * @return {@link TableUpdateBuilder} instance
	 */
	public TableUpdateBuilder add(String name, Object value) {
		data.put(name, value);
		return this;
	}
	
	/**
	 * Finish request construction and updates data in the table
	 */
	public void update() {
		table.update(condition, data);
	}
}
