package test;

import net.unilib.database.DataType;
import net.unilib.database.handler.DataHandler;
import net.unilib.database.handler.DataHandlerBuilder;
import net.unilib.database.handler.DatabaseType;
import net.unilib.database.table.DataTable;
import net.unilib.database.table.DataTableBuilder;

import java.sql.ResultSet;

public class Test {
	public static void main(String[] args) {
		DataTable table = DataTableBuilder
			.start(myDatabase, "test")
			.addColumn("a", DataType.INT)
			.addColumn("b", DataType.BINARY, 5)
			.build();
		table.createIfNotExist();
		ResultSet result = table.query("a", 2);
		result = table.query("a", 2, "b", "0xFFFF");
		
		DataHandlerBuilder builder = DataHandlerBuilder.start(myPlugin, "data", DatabaseType.PLUGIN);
		builder.makeTable("testTable").addColumn("player", DataType.VARCHAR, 255).addColumn("myID", DataType.INT).build();
		DataHandler pluginData = builder.build();
		
		ResultSet result = pluginData.queryAll("testTable");
		while (result.next()) System.out.println("Player: " + result.getString("player"));
		
		result = pluginData.query("testTable", "myID", 10);
		while (result.next()) System.out.println("Player: " + result.getString("player"));
	}
}
