package net.unilib.database.utility;

import net.risingworld.api.utils.Quaternion;
import net.risingworld.api.utils.Vector3f;
import net.risingworld.api.utils.Vector3i;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Converter for some objects to store them in database
 */
public class DataConvertor {
	public static final int VECTOR_BYTES = 3 * 4;
	public static final int QUATERNION_BYTES = 4 * 4;
	private static final int VECTOR_STRING_LENGTH = VECTOR_BYTES * 2 + 2;
	private static final int QUATERNION_STRING_LENGTH = QUATERNION_BYTES * 2 + 2;
	private static final StringBuffer CONVERT_BUFFER = new StringBuffer(8);
	
	/**
	 * Convert vector into binary string (to store in BINARY(12) format)
	 * @param vector {@link Vector3f} input
	 * @return {@link String} binary representation
	 */
	public static String vectorToBinary(Vector3f vector) {
		StringBuilder builder = new StringBuilder(VECTOR_STRING_LENGTH);
		builder.append("'0x");
		toBinaryString(builder, vector.x, vector.y, vector.z);
		builder.append("'");
		return builder.toString();
	}
	
	/**
	 * Convert binary string (BINARY(12) format) into a {@link Vector3f}
	 * @param binaryString {@link String} to convert
	 * @return {@link Vector3f}
	 */
	public static Vector3f vector3fFromBinary(String binaryString) {
		float x = parseFloat(binaryString.substring(2, 10));
		float y = parseFloat(binaryString.substring(10, 18));
		float z = parseFloat(binaryString.substring(18, 26));
		return new Vector3f(x, y, z);
	}
	
	/**
	 * Get {@link Vector3f} value from {@link ResultSet} by name
	 * @param set {@link ResultSet} to get value from
	 * @param name {@link String} column name
	 * @return {@link Vector3f}
	 */
	public static Vector3f getVector3f(ResultSet set, String name) {
		try {
			return vector3fFromBinary(set.getString(name));
		}
		catch (SQLException e) {
			e.printStackTrace();
			return new Vector3f();
		}
	}
	
	/**
	 * Convert vector into binary string (to store in BINARY(12) format)
	 * @param vector {@link Vector3i} input
	 * @return {@link String} binary representation
	 */
	public static String vectorToBinary(Vector3i vector) {
		StringBuilder builder = new StringBuilder(VECTOR_STRING_LENGTH);
		builder.append("'0x");
		toBinaryString(builder, vector.x, vector.y, vector.z);
		builder.append("'");
		return builder.toString();
	}
	
	/**
	 * Convert binary string (BINARY(12) format) into a {@link Vector3i}
	 * @param binaryString {@link String} to convert
	 * @return {@link Vector3i}
	 */
	public static Vector3i vector3iFromBinary(String binaryString) {
		int x = parseInt(binaryString.substring(2, 10));
		int y = parseInt(binaryString.substring(10, 18));
		int z = parseInt(binaryString.substring(18, 26));
		return new Vector3i(x, y, z);
	}
	
	/**
	 * Get {@link Vector3i} value from {@link ResultSet} by name
	 * @param set {@link ResultSet} to get value from
	 * @param name {@link String} column name
	 * @return {@link Vector3i}
	 */
	public static Vector3i getVector3i(ResultSet set, String name) {
		try {
			return vector3iFromBinary(set.getString(name));
		}
		catch (SQLException e) {
			e.printStackTrace();
			return new Vector3i();
		}
	}
	
	/**
	 * Convert {@link Quaternion} into binary string (to store in BINARY(16) format)
	 * @param quaternion {@link Quaternion} input
	 * @return {@link String} binary representation
	 */
	public static String quaternionToBinary(Quaternion quaternion) {
		StringBuilder builder = new StringBuilder(QUATERNION_STRING_LENGTH);
		builder.append("'0x");
		toBinaryString(builder, quaternion.x, quaternion.y, quaternion.z, quaternion.w);
		builder.append("'");
		return builder.toString();
	}
	
	/**
	 * Convert binary string (BINARY(16) format) into a {@link Quaternion}
	 * @param binaryString {@link String} to convert
	 * @return {@link Quaternion}
	 */
	public static Quaternion quaternionFromBinary(String binaryString) {
		float x = parseFloat(binaryString.substring(2, 10));
		float y = parseFloat(binaryString.substring(10, 18));
		float z = parseFloat(binaryString.substring(18, 26));
		float w = parseFloat(binaryString.substring(26, 34));
		return new Quaternion(x, y, z, w);
	}
	
	/**
	 * Get {@link Quaternion} value from {@link ResultSet} by name
	 * @param set {@link ResultSet} to get value from
	 * @param name {@link String} column name
	 * @return {@link Quaternion}
	 */
	public static Quaternion getQuaternion(ResultSet set, String name) {
		try {
			return quaternionFromBinary(set.getString(name));
		}
		catch (SQLException e) {
			e.printStackTrace();
			return Quaternion.IDENTITY.copy();
		}
	}
	
	private static int parseInt(String string) {
		return (int) Long.parseLong(string, 16);
	}
	
	private static float parseFloat(String string) {
		return Float.intBitsToFloat((int) Long.parseLong(string, 16));
	}
	
	private static void toBinaryString(StringBuilder builder, float... values) {
		for (float value : values) {
			builder.append(toBinary(Float.floatToIntBits(value)));
		}
	}
	
	private static void toBinaryString(StringBuilder builder, int... values) {
		for (int value : values) {
			builder.append(toBinary(value));
		}
	}
	
	private static CharSequence toBinary(int value) {
		String hex = Integer.toHexString(value);
		if (hex.length() == 8) return hex;
		CONVERT_BUFFER.setLength(0);
		for (byte i = (byte) hex.length(); i < 8; i++) {
			CONVERT_BUFFER.append('0');
		}
		CONVERT_BUFFER.append(hex);
		return CONVERT_BUFFER;
	}
}
