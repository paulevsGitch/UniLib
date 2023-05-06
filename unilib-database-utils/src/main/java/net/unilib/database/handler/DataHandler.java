package net.unilib.database.handler;

import net.unilib.database.table.DataTable;
import net.unilib.database.table.TableInsertBuilder;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Multiple {@link DataTable} storage that can read, write and update tables.
 * Can represent database completely (or several databases if you need that, it is
 * recommended to use single {@link DataHandler} per database)
 */
public class DataHandler {
	private final Map<String, DataTable> tables = new HashMap<>();
	
	protected DataHandler(Map<String, DataTable> tables) {
		this.tables.putAll(tables);
	}
	
	/**
	 * Get {@link ResultSet} with all table values
	 * @param tableName {@link String} name of the table
	 * @return {@link ResultSet}
	 */
	public ResultSet queryAll(String tableName) {
		return getTableOrThrow(tableName).queryAll();
	}
	
	/**
	 * Get {@link ResultSet} with condition (SQL language).
	 * <br>
	 * Example: query("WHERE `id` = 5")
	 * @param tableName {@link String} name of the table
	 * @param condition {@link String} representation of SQL condition
	 * @return {@link ResultSet}
	 */
	public ResultSet query(String tableName, String condition) {
		return getTableOrThrow(tableName).query(condition);
	}
	
	/**
	 * Get {@link ResultSet} with one condition (object equals value)
	 * @param tableName {@link String} name of the table
	 * @param name {@link String} column name
	 * @param value {@link Object} value to check
	 * @return {@link ResultSet}
	 */
	public ResultSet query(String tableName, String name, Object value) {
		return getTableOrThrow(tableName).query(name, value);
	}
	
	/**
	 * Get {@link ResultSet} with two conditions (object equals value)
	 * @param tableName {@link String} name of the table
	 * @param name1 {@link String} first column name
	 * @param value1 {@link Object} first value to check
	 * @param name2 {@link String} second column name
	 * @param value2 {@link Object} second value to check
	 * @return {@link ResultSet}
	 */
	public ResultSet query(String tableName, String name1, Object value1, String name2, Object value2) {
		return getTableOrThrow(tableName).query(name1, value1, name2, value2);
	}
	
	/**
	 * Get {@link ResultSet} with three conditions (object equals value)
	 * @param tableName {@link String} name of the table
	 * @param name1 {@link String} first column name
	 * @param value1 {@link Object} first value to check
	 * @param name2 {@link String} second column name
	 * @param value2 {@link Object} second value to check
	 * @param name3 {@link String} third column name
	 * @param value3 {@link Object} third value to check
	 * @return {@link ResultSet}
	 */
	public ResultSet query(String tableName, String name1, Object value1, String name2, Object value2, String name3, Object value3) {
		return getTableOrThrow(tableName).query(name1, value1, name2, value2, name3, value3);
	}
	
	/**
	 * Start {@link TableInsertBuilder} for this table
	 * @param tableName {@link String} name of the table
	 * @return {@link TableInsertBuilder}
	 */
	public TableInsertBuilder startInsert(String tableName) {
		return getTableOrThrow(tableName).startInsert();
	}
	
	/**
	 * Insert new row into table
	 * @param tableName {@link String} name of the table
	 * @param data {@link Map} that contains new row data
	 */
	public void insert(String tableName, Map<String, Object> data) {
		getTableOrThrow(tableName).insert(data);
	}
	
	/**
	 * Insert new row into table. Both arguments should have equal size and have same indexes
	 * @param tableName {@link String} name of the table
	 * @param names array of {@link String} column names
	 * @param values array of {@link Object} values
	 */
	public void insert(String tableName, String[] names, String[] values) {
		getTableOrThrow(tableName).insert(names, values);
	}
	
	/**
	 * Insert new row into table. Both arguments should have equal size and have same indexes
	 * @param tableName {@link String} name of the table
	 * @param names {@link List} of {@link String} column names
	 * @param values {@link List} of {@link Object} values
	 */
	public void insert(String tableName, List<String> names, List<Object> values) {
		getTableOrThrow(tableName).insert(names, values);
	}
	
	private DataTable getTableOrThrow(String tableName) {
		DataTable table = tables.get(tableName);
		if (table == null) {
			throw new RuntimeException("Missing table with name " + tableName);
		}
		return table;
	}
}
