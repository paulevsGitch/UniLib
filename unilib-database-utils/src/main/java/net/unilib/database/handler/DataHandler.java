package net.unilib.database.handler;

import net.risingworld.api.database.Database;
import net.unilib.database.table.DataTable;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Single {@link Database} storage that can read, write and update database
 */
public class DataHandler {
	private final Map<String, DataTable> tables = new HashMap<>();
	
	protected DataHandler(Map<String, DataTable> tables) {
		this.tables.putAll(tables);
	}
	
	public ResultSet queryAll(String tableName) {
		DataTable table = tables.get(tableName);
		return table == null ? null : table.queryAll();
	}
	
	public ResultSet query(String tableName, String condition) {
		DataTable table = tables.get(tableName);
		return table == null ? null : table.query(condition);
	}
	
	public ResultSet query(String tableName, String name, Object value) {
		DataTable table = tables.get(tableName);
		return table == null ? null : table.query(name, value);
	}
	
	public ResultSet query(String tableName, String name1, Object value1, String name2, Object value2) {
		DataTable table = tables.get(tableName);
		return table == null ? null : table.query(name1, value1, name2, value2);
	}
	
	public ResultSet query(String tableName, String name1, Object value1, String name2, Object value2, String name3, Object value3) {
		DataTable table = tables.get(tableName);
		return table == null ? null : table.query(name1, value1, name2, value2, name3, value3);
	}
}
