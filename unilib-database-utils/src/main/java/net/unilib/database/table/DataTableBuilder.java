package net.unilib.database.table;

import net.risingworld.api.database.Database;
import net.unilib.database.DataType;
import net.unilib.database.handler.DataHandlerBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTableBuilder {
	private static final DataTableBuilder INSTANCE = new DataTableBuilder();
	
	private List<ColumnEntry> columns = new ArrayList<>();
	private DataHandlerBuilder handlerBuilder;
	private Database database;
	private String name;
	
	private DataTableBuilder() {}
	
	public static DataTableBuilder start(Database database, String name, DataHandlerBuilder handlerBuilder) {
		INSTANCE.handlerBuilder = handlerBuilder;
		return start(database, name);
	}
	
	public static DataTableBuilder start(Database database, String name) {
		INSTANCE.name = name;
		INSTANCE.database = database;
		INSTANCE.columns.clear();
		return INSTANCE;
	}
	
	public DataTableBuilder addColumn(String name, DataType type, int size) {
		columns.add(new ColumnEntry(name, type, size));
		return this;
	}
	
	public DataTableBuilder addColumn(String name, DataType type) {
		return this.addColumn(name, type, 1);
	}
	
	public DataTable build() {
		DataTable table = new DataTable(database, name, Collections.unmodifiableList(columns));
		if (handlerBuilder != null) {
			handlerBuilder.addTable(table);
		}
		return table;
	}
}
