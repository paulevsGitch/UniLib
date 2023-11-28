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
	private static final StringBuffer TO_STR = new StringBuffer(Math.max(VECTOR_BYTES * 2 + 4, QUATERNION_BYTES * 2 + 4));
	private static final StringBuffer FROM_STR = new StringBuffer(8);
	private static final String BIN_START = "'0x";
	private static final String BIN_END = "'";
	
	/**
	 * Convert vector into binary string (to store in BINARY(12) format)
	 * @param vector {@link Vector3f} input
	 * @return {@link String} binary representation
	 */
	public static CharSequence vectorToBinary(Vector3f vector) {
		TO_STR.setLength(0);
		TO_STR.append(BIN_START);
		TO_STR.append(toBinary(vector.x));
		TO_STR.append(toBinary(vector.y));
		TO_STR.append(toBinary(vector.z));
		TO_STR.append(BIN_END);
		return TO_STR;
	}
	
	/**
	 * Convert binary string (BINARY(12) format) into a {@link Vector3f}
	 * @param binaryString {@link String} to convert
	 * @return {@link Vector3f}
	 */
	public static Vector3f vector3fFromBinary(CharSequence binaryString) {
		int index = binaryString.charAt(0) == '\'' ? 3 : 2;
		float x = Float.intBitsToFloat((int) Long.parseLong(binaryString, index, index + 8, 16));
		float y = Float.intBitsToFloat((int) Long.parseLong(binaryString, index + 8, index + 16, 16));
		float z = Float.intBitsToFloat((int) Long.parseLong(binaryString, index + 16, index + 24, 16));
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
	public static CharSequence vectorToBinary(Vector3i vector) {
		TO_STR.setLength(0);
		TO_STR.append(BIN_START);
		TO_STR.append(toBinary(vector.x));
		TO_STR.append(toBinary(vector.y));
		TO_STR.append(toBinary(vector.z));
		TO_STR.append(BIN_END);
		return TO_STR;
	}
	
	/**
	 * Convert binary string (BINARY(12) format) into a {@link Vector3i}
	 * @param binaryString {@link String} to convert
	 * @return {@link Vector3i}
	 */
	public static Vector3i vector3iFromBinary(CharSequence binaryString) {
		int index = binaryString.charAt(0) == '\'' ? 3 : 2;
		int x = (int) Long.parseLong(binaryString, index, index + 8, 16);
		int y = (int) Long.parseLong(binaryString, index + 8, index + 16, 16);
		int z = (int) Long.parseLong(binaryString, index + 16, index + 24, 16);
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
	public static CharSequence quaternionToBinary(Quaternion quaternion) {
		TO_STR.setLength(0);
		TO_STR.append(BIN_START);
		TO_STR.append(toBinary(quaternion.x));
		TO_STR.append(toBinary(quaternion.y));
		TO_STR.append(toBinary(quaternion.z));
		TO_STR.append(toBinary(quaternion.w));
		TO_STR.append(BIN_END);
		return TO_STR;
	}
	
	/**
	 * Convert binary string (BINARY(16) format) into a {@link Quaternion}
	 * @param binaryString {@link String} to convert
	 * @return {@link Quaternion}
	 */
	public static Quaternion quaternionFromBinary(CharSequence binaryString) {
		int index = binaryString.charAt(0) == '\'' ? 3 : 2;
		float x = Float.intBitsToFloat((int) Long.parseLong(binaryString, index, index + 8, 16));
		float y = Float.intBitsToFloat((int) Long.parseLong(binaryString, index + 8, index + 16, 16));
		float z = Float.intBitsToFloat((int) Long.parseLong(binaryString, index + 16, index + 24, 16));
		float w = Float.intBitsToFloat((int) Long.parseLong(binaryString, index + 24, index + 32, 16));
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
	
	private static CharSequence toBinary(float value) {
		return toBinary(Float.floatToIntBits(value));
	}
	
	private static CharSequence toBinary(int value) {
		String hex = Integer.toHexString(value);
		if (hex.length() == 8) return hex;
		FROM_STR.setLength(0);
		for (byte i = (byte) hex.length(); i < 8; i++) {
			FROM_STR.append('0');
		}
		FROM_STR.append(hex);
		return FROM_STR;
	}
}
