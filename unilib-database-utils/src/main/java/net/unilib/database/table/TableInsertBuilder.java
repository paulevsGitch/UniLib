package net.unilib.database.table;

import java.util.ArrayList;
import java.util.List;

/**
 * Table insert request builder
 */
public class TableInsertBuilder {
	private static final TableInsertBuilder INSTANCE = new TableInsertBuilder();
	
	private final List<String> names = new ArrayList<>(256);
	private final List<Object> objects = new ArrayList<>(256);
	private DataTable table;
	
	private TableInsertBuilder() {}
	
	/**
	 * Starts a new request building for specified {@link DataTable}
	 * All inserters are the same instance (not multi-thread-safe)
	 * @param table target {@link DataTable}
	 * @return {@link TableInsertBuilder} instance
	 */
	public static TableInsertBuilder start(DataTable table) {
		INSTANCE.names.clear();
		INSTANCE.objects.clear();
		INSTANCE.table = table;
		return INSTANCE;
	}
	
	/**
	 * Add new value to request
	 * @param name {@link String} column name
	 * @param value {@link Object} value
	 * @return {@link TableInsertBuilder} instance
	 */
	public TableInsertBuilder add(String name, Object value) {
		names.add(name);
		objects.add(value);
		return this;
	}
	
	/**
	 * Finish request construction and insert data into table
	 */
	public void insert() {
		table.insert(names, objects);
	}
}
