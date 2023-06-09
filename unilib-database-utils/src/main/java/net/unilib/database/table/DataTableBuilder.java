package net.unilib.database.table;

import net.risingworld.api.database.Database;
import net.unilib.database.handler.DataHandlerBuilder;
import net.unilib.database.utility.DataConvertor;
import net.unilib.database.utility.DataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Builder that will construct {@link DataTable} instance.
 * The table wil always have an id column with increment integer as the first column
 */
public class DataTableBuilder {
	private static final DataTableBuilder INSTANCE = new DataTableBuilder();
	
	private List<ColumnEntry> columns = new ArrayList<>();
	private DataHandlerBuilder handlerBuilder;
	private Database database;
	private String name;
	
	private DataTableBuilder() {}
	
	/**
	 * Starts building process, will return a builder instance.
	 * All builders are the same instance (not multi-thread-safe).
	 * This method is used in {@link DataHandlerBuilder} to create table that
	 * will be stored in {@link net.unilib.database.handler.DataHandler}
	 * @param database {@link Database} where table will be located
	 * @param name Table name
	 * @param handlerBuilder {@link DataHandlerBuilder} that started building table
	 * @return {@link DataTableBuilder} instance
	 */
	public static DataTableBuilder start(Database database, String name, DataHandlerBuilder handlerBuilder) {
		INSTANCE.handlerBuilder = handlerBuilder;
		return start(database, name);
	}
	
	/**
	 * Starts building process, will return a builder instance.
	 * All builders are the same instance (not multi-thread-safe)
	 * @param database {@link Database} where table will be located
	 * @param name Table name
	 * @return {@link DataTableBuilder} instance
	 */
	public static DataTableBuilder start(Database database, String name) {
		INSTANCE.database = database;
		INSTANCE.name = name;
		INSTANCE.columns.clear();
		return INSTANCE;
	}
	
	/**
	 * Add new column into the table
	 * @param name {@link String} column name
	 * @param type {@link DataType} that column will have
	 * @param size Size of a datatype (for types that have size)
	 * @return {@link DataTableBuilder} instance
	 */
	public DataTableBuilder addColumn(String name, DataType type, int size) {
		columns.add(new ColumnEntry(name, type, size));
		return this;
	}
	
	/**
	 * Add new column into the table
	 * @param name {@link String} column name
	 * @param type {@link DataType} that column will have
	 * @return {@link DataTableBuilder} instance
	 */
	public DataTableBuilder addColumn(String name, DataType type) {
		return this.addColumn(name, type, 1);
	}
	
	/**
	 * Add column that will store a {@link net.risingworld.api.utils.Vector3f} values
	 * @param name {@link String} column name
	 * @return {@link DataTableBuilder} instance
	 */
	public DataTableBuilder addVectorColumn(String name) {
		return this.addColumn(name, DataType.BINARY, DataConvertor.VECTOR_BYTES);
	}
	
	/**
	 * Add column that will store a {@link net.risingworld.api.utils.Quaternion} values
	 * @param name {@link String} column name
	 * @return {@link DataTableBuilder} instance
	 */
	public DataTableBuilder addQuaternionColumn(String name) {
		return this.addColumn(name, DataType.BINARY, DataConvertor.QUATERNION_BYTES);
	}
	
	/**
	 * Finish building process and creates a new {@link DataTable}
	 * @return {@link DataTable}
	 */
	public DataTable build() {
		DataTable table = new DataTable(database, name, Collections.unmodifiableList(columns));
		table.createIfNotExist();
		if (handlerBuilder != null) {
			handlerBuilder.addTable(table);
			INSTANCE.handlerBuilder = null;
		}
		return table;
	}
}
