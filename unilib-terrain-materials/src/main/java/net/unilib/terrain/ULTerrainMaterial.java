package net.unilib.terrain;

public class ULTerrainMaterial {
	public final String name;
	public final int rgba;
	public final byte id;
	
	protected ULTerrainMaterial(int id, String name, int rgba) {
		this.id = (byte) id;
		this.name = name;
		this.rgba = rgba;
	}
}
