package net.unilib.database.handler;

/**
 * This enum represents database types by database location
 * @see #PLUGIN
 * @see #WORLD
 * @see #CUSTOM
 */
public enum DatabaseType {
	/**
	 * Database of this type will be located in plugin folder
	 */
	PLUGIN,
	
	/**
	 * Database of this type will be located in current world folder
	 */
	WORLD,
	
	/**
	 * Database of this type will be located in path specified in database name
	 */
	CUSTOM;
}
