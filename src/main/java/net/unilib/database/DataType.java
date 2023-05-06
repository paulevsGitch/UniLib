package net.unilib.database;

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
	
	public final String asString;
	public final boolean hasSize;
	
	DataType(String asString, boolean hasSize) {
		this.asString = asString;
		this.hasSize = hasSize;
	}
}
