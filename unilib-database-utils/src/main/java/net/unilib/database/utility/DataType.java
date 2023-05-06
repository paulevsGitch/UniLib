package net.unilib.database.utility;

/**
 * Types of data that SQL can store. This is not a complete enum of all data types, only for most frequently used
 * for plugin development. If you need more data types please make a new ticket on
 * <a href="https://github.com/paulevsGitch/UniLib/issues">issue tracker</a>
 */
public enum DataType {
	TINYINT("TINYINT", false),
	SMALLINT("SMALLINT", false),
	INT("INT", false),
	BIGINT("BIGINT", false),
	FLOAT("FLOAT", false),
	REAL("REAL", false),
	CHAR("CHAR", true),
	VARCHAR("VARCHAR", true),
	BINARY("BINARY", true),
	VARBINARY("VARBINARY", true),
	BLOB("BLOB", true);
	
	/**
	 * Type name in SQL syntax
	 */
	public final String asString;
	
	/**
	 * If type has size will be {@code true}.
	 * <br>
	 * Examples: BINARY(12), VARCHAR(255)
	 */
	public final boolean hasSize;
	
	DataType(String asString, boolean hasSize) {
		this.asString = asString;
		this.hasSize = hasSize;
	}
}
