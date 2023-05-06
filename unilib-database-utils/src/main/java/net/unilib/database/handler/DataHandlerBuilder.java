package net.unilib.database.handler;

import net.risingworld.api.Plugin;
import net.risingworld.api.World;
import net.risingworld.api.database.Database;
import net.unilib.database.table.DataTable;
import net.unilib.database.table.DataTableBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Builder that will construct {@link DataHandler} instance.
 * This builder will construct handler that handles single {@link Database} with several tables
 */
public class DataHandlerBuilder {
	private static final DataHandlerBuilder INSTANCE = new DataHandlerBuilder();
	
	private final Map<String, DataTable> tables = new HashMap<>();
	private Database database;
	
	private DataHandlerBuilder() {}
	
	/**
	 * Starts building process, will return a builder instance.
	 * All builders are the same instance (not multi-thread-safe)
	 * @param plugin {@link Plugin} that execute this method
	 * @param name {@link String} database name
	 * @param type {@link DatabaseType} database type
	 * @return {@link DataHandlerBuilder} instance
	 */
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
	
	/**
	 * Starts building process, will return a builder instance.
	 * All builders are the same instance (not multi-thread-safe).
	 * This builder will make {@link DataHandler} for existing database
	 * @param database {@link Database} that execute this method
	 * @return {@link DataHandlerBuilder} instance
	 */
	public static DataHandlerBuilder start(Database database) {
		INSTANCE.database = database;
		INSTANCE.tables.clear();
		return INSTANCE;
	}
	
	/**
	 * Add table to the database
	 * @param table {@link DataTable} to add
	 * @return {@link DataHandlerBuilder} instance
	 */
	public DataHandlerBuilder addTable(DataTable table) {
		tables.put(table.name, table);
		return this;
	}
	
	/**
	 * Start a table construction with {@link DataTableBuilder}.
	 * Table will be connected to this {@link DataHandlerBuilder}
	 * @param name {@link String} table name
	 * @return {@link DataTableBuilder} instance (started)
	 */
	public DataTableBuilder makeTable(String name) {
		return DataTableBuilder.start(database, name, this);
	}
	
	/**
	 * Finish building process and creates a new {@link DataHandler}
	 * @return {@link DataHandler}
	 */
	public DataHandler build() {
		tables.values().forEach(DataTable::createIfNotExist);
		return new DataHandler(tables);
	}
}
