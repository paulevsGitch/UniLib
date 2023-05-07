package net.unilib.database.table;

import net.risingworld.api.database.Database;
import net.risingworld.api.utils.Vector3f;
import net.unilib.database.utility.DataConvertor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class represents single table in the {@link Database}.
 * It can read, write, update it and make requests
 */
public class DataTable {
	private final List<ColumnEntry> columns;
	private final Database database;
	public final String name;
	
	/**
	 * Creates a new {@link DataTable} instance
	 * @param database {@link Database} where table will be located
	 * @param name {@link String} table name
	 * @param columns {@link List} of {@link ColumnEntry} that will form table columns
	 */
	protected DataTable(Database database, String name, List<ColumnEntry> columns) {
		this.database = database;
		this.columns = columns;
		this.name = name;
	}
	
	/**
	 * Will create table if it doesn't exist in the {@link DataTable}
	 */
	public void createIfNotExist() {
		StringBuilder builder = new StringBuilder("CREATE TABLE IF NOT EXISTS `");
		builder.append(name);
		builder.append("` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL");
		columns.forEach(column -> {
			builder.append(", `");
			builder.append(column.name);
			builder.append("` ");
			builder.append(column.type);
			if (column.type.hasSize) {
				builder.append("(");
				builder.append(column.size);
				builder.append(")");
			}
		});
		builder.append(")");
		database.execute(builder.toString());
	}
	
	/**
	 * Get {@link ResultSet} with all table values
	 * @return {@link ResultSet}
	 */
	public ResultSet queryAll() {
		try {
			return database.executeQuery("SELECT * FROM `" + name + "`");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get {@link ResultSet} with condition (SQL language).
	 * <br>
	 * Example: query("WHERE `id` = 5")
	 * @param condition {@link String} representation of SQL condition
	 * @return {@link ResultSet}
	 */
	public ResultSet query(String condition) {
		try {
			return database.executeQuery("SELECT * FROM `" + name + "` " + condition);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get {@link ResultSet} with one condition (object equals value)
	 * @param name {@link String} column name
	 * @param value {@link Object} value to check
	 * @return {@link ResultSet}
	 */
	public ResultSet query(String name, Object value) {
		value = convertType(value);
		return query("WHERE `" + name + "` = " + value);
	}
	
	/**
	 * Get {@link ResultSet} with two conditions (object equals value)
	 * @param name1 {@link String} first column name
	 * @param value1 {@link Object} first value to check
	 * @param name2 {@link String} second column name
	 * @param value2 {@link Object} second value to check
	 * @return {@link ResultSet}
	 */
	public ResultSet query(String name1, Object value1, String name2, Object value2) {
		value1 = convertType(value1);
		value2 = convertType(value2);
		return query("WHERE `" + name1 + "` = " + value1 + " AND `" + name2 + "` = " + value2);
	}
	
	/**
	 * Get {@link ResultSet} with three conditions (object equals value)
	 * @param name1 {@link String} first column name
	 * @param value1 {@link Object} first value to check
	 * @param name2 {@link String} second column name
	 * @param value2 {@link Object} second value to check
	 * @param name3 {@link String} third column name
	 * @param value3 {@link Object} third value to check
	 * @return {@link ResultSet}
	 */
	public ResultSet query(String name1, Object value1, String name2, Object value2, String name3, Object value3) {
		value1 = convertType(value1);
		value2 = convertType(value2);
		value3 = convertType(value3);
		return query("WHERE `" + name1 + "` = " + value1 + " AND `" + name2 + "` = " + value2 + " AND `" + name3 + "` = " + value3);
	}
	
	/**
	 * Start {@link TableInsertBuilder} for this table
	 * @return {@link TableInsertBuilder}
	 */
	public TableInsertBuilder startInsert() {
		return TableInsertBuilder.start(this);
	}
	
	/**
	 * Insert new row into table
	 * @param data {@link Map} that contains new row data
	 */
	public void insert(Map<String, Object> data) {
		List<String> names = new ArrayList<>(data.size());
		List<Object> values = new ArrayList<>(data.size());
		data.forEach((name, obj) -> {
			names.add(name);
			values.add(obj);
		});
		insert(names, values);
	}
	
	/**
	 * Insert new row into table. Both arguments should have equal size and have same indexes.
	 * @param names array of {@link String} column names
	 * @param values array of {@link Object} values
	 */
	public void insert(String[] names, String[] values) {
		insert(List.of(names), List.of(values));
	}
	
	/**
	 * Insert new row into table. Both arguments should have equal size and have same indexes.
	 * Use {@link TableInsertBuilder} for properly created inserts
	 * @param names {@link List} of {@link String} column names
	 * @param values {@link List} of {@link Object} values
	 */
	public void insert(List<String> names, List<Object> values) {
		if (names.isEmpty()) return;
		StringBuilder builder = new StringBuilder("INSERT INTO `");
		builder.append(name);
		
		builder.append("` (`");
		builder.append(names.get(0));
		for (short i = 1; i < names.size(); i++) {
			builder.append("`, `");
			builder.append(names.get(i));
		}
		
		builder.append("`) VALUES ('");
		builder.append(convertType(values.get(0)));
		for (short i = 1; i < names.size(); i++) {
			builder.append("', '");
			builder.append(convertType(values.get(i)));
		}
		builder.append("')");
		
		database.executeUpdate(builder.toString());
	}
	
	/**
	 * Remove row in table with condition (SQL language).
	 * <br>
	 * Example: delete("WHERE `id` = 5")
	 * @param condition {@link String} representation of SQL condition
	 */
	public void delete(String condition) {
		database.executeUpdate("DELETE * FROM `" + name + "` " + condition);
	}
	
	/**
	 * Remove row in table with one condition (object equals value)
	 * @param name {@link String} column name
	 * @param value {@link Object} value to check
	 */
	public void delete(String name, Object value) {
		value = convertType(value);
		delete("WHERE `" + name + "` = " + value);
	}
	
	/**
	 * Remove row in table with two conditions (object equals value)
	 * @param name1 {@link String} first column name
	 * @param value1 {@link Object} first value to check
	 * @param name2 {@link String} second column name
	 * @param value2 {@link Object} second value to check
	 */
	public void delete(String name1, Object value1, String name2, Object value2) {
		value1 = convertType(value1);
		value2 = convertType(value2);
		delete("WHERE `" + name1 + "` = " + value1 + " AND `" + name2 + "` = " + value2);
	}
	
	/**
	 * Remove row in table with three conditions (object equals value)
	 * @param name1 {@link String} first column name
	 * @param value1 {@link Object} first value to check
	 * @param name2 {@link String} second column name
	 * @param value2 {@link Object} second value to check
	 * @param name3 {@link String} third column name
	 * @param value3 {@link Object} third value to check
	 */
	public void delete(String name1, Object value1, String name2, Object value2, String name3, Object value3) {
		value1 = convertType(value1);
		value2 = convertType(value2);
		value3 = convertType(value3);
		delete("WHERE `" + name1 + "` = " + value1 + " AND `" + name2 + "` = " + value2 + " AND `" + name3 + "` = " + value3);
	}
	
	private Object convertType(Object obj) {
		if (obj instanceof Vector3f vec) return DataConvertor.vectorToBinary(vec);
		return obj;
	}
}
