package net.unilib.terrain;

public class ULTerrainMaterial {
	public final String name;
	public final int rgba;
	public final byte id;
	
	protected ULTerrainMaterial(byte id, String name, int argb) {
		this.id = id;
		this.name = name;
		this.rgba = argb;
	}
}
