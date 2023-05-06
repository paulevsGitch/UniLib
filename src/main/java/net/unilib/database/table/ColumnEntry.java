package net.unilib.database.table;

import net.unilib.database.DataType;

public class ColumnEntry {
	public final String name;
	public final DataType type;
	public final int size;
	
	protected ColumnEntry(String name, DataType type, int size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
}
