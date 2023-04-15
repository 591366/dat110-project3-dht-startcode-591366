package no.hvl.dat110.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static BigInteger hashOf(String entity) {

		BigInteger hashint = null;

		// Task: Hash a given string using MD5 and return the result as a BigInteger.

		// we use MD5 with 128 bits digest

		// compute the hash of the input 'entity'

		// convert the hash into hex format

		// convert the hex into BigInteger

		// return the BigInteger
		MessageDigest md;

		// using message digest to convert the string into MD5 hash, then turn
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(entity.getBytes());
			byte[] digest = md.digest();
			String hexValue = toHex(digest);
			hashint = new BigInteger(hexValue, 16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hashint;
	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5

		// compute the number of bits = bitSize()

		// compute the address size = 2 ^ number of bits

		// return the address size
		int bits = bitSize();
		double value = Math.pow(2, bits);
		String stringValue = new BigDecimal(value).toPlainString();
		BigInteger addressSize = new BigInteger(stringValue);

		return addressSize;
	}

	public static int bitSize() {

		int digestlen = 0;

		// find the digest length

		digestlen = 16;

		return digestlen * 8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}
