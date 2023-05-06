package net.unilib.database.handler;

import net.risingworld.api.Plugin;
import net.risingworld.api.World;
import net.risingworld.api.database.Database;
import net.unilib.database.table.DataTable;
import net.unilib.database.table.DataTableBuilder;

import java.util.HashMap;
import java.util.Map;

public class DataHandlerBuilder {
	private static final DataHandlerBuilder INSTANCE = new DataHandlerBuilder();
	
	private final Map<String, DataTable> tables = new HashMap<>();
	private Database database;
	
	private DataHandlerBuilder() {}
	
	public static DataHandlerBuilder start(Plugin plugin, String name, DatabaseType type) {
		if (!name.endsWith(".db")) name += ".db";
		INSTANCE.tables.clear();
		switch (type) {
			case PLUGIN -> INSTANCE.database = plugin.getSQLiteConnection(plugin.getPath() + "/" + name);
			case WORLD -> INSTANCE.database = plugin.getSQLiteConnection(World.getWorldFolder().getAbsolutePath() + "/" + name);
			case CUSTOM -> INSTANCE.database = plugin.getSQLiteConnection(name);
		}
		return INSTANCE;
	}
	
	public DataHandlerBuilder addTable(DataTable table) {
		tables.put(table.name, table);
		return this;
	}
	
	public DataTableBuilder makeTable(String name) {
		return DataTableBuilder.start(database, name, this);
	}
	
	public DataHandler build() {
		return new DataHandler(tables);
	}
}
