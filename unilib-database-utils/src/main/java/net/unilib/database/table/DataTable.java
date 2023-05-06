package net.unilib.database.table;

import net.risingworld.api.database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DataTable {
	private final List<ColumnEntry> columns;
	private final Database database;
	public final String name;
	
	protected DataTable(Database database, String name, List<ColumnEntry> columns) {
		this.database = database;
		this.columns = columns;
		this.name = name;
	}
	
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
	
	public ResultSet queryAll() {
		try {
			return database.executeQuery("SELECT * FROM `" + name + "`");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet query(String condition) {
		try {
			return database.executeQuery("SELECT * FROM `" + name + "` " + condition);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet query(String name, Object value) {
		return query("WHERE `" + name + "` = " + value);
	}
	
	public ResultSet query(String name1, Object value1, String name2, Object value2) {
		return query("WHERE `" + name1 + "` = " + value1 + " AND `" + name2 + "` = " + value2);
	}
	
	public ResultSet query(String name1, Object value1, String name2, Object value2, String name3, Object value3) {
		return query("WHERE `" + name1 + "` = " + value1 + " AND `" + name2 + "` = " + value2 + " AND `" + name3 + "` = " + value3);
	}
}
