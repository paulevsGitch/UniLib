package net.unilib.database;

import net.risingworld.api.utils.Vector3f;

/**
 * Converter for some objects to store them in database
 */
public class DataConvertor {
	/**
	 * Convert vector into binary string (to store in BINARY(12) format)
	 * @param vector {@link Vector3f} input
	 * @return {@link String} binary representation
	 */
	public static String vectorToBinary(Vector3f vector) {
		return "0x" +
			Integer.toHexString(Float.floatToIntBits(vector.x)) +
			Integer.toHexString(Float.floatToIntBits(vector.y)) +
			Integer.toHexString(Float.floatToIntBits(vector.z));
	}
	
	/**
	 * Convert binary string (BINARY(12) format) into a {@link Vector3f}
	 * @param binaryString {@link String} to convert
	 * @return {@link Vector3f}
	 */
	public static Vector3f vectorFromBinary(String binaryString) {
		float x = Float.intBitsToFloat((int) Long.parseLong(binaryString.substring(2, 10), 16));
		float y = Float.intBitsToFloat((int) Long.parseLong(binaryString.substring(10, 18), 16));
		float z = Float.intBitsToFloat((int) Long.parseLong(binaryString.substring(18, 26), 16));
		return new Vector3f(x, y, z);
	}
}
