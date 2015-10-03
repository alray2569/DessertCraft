package com.andrewlray.mcmods.dessertcraft.lib;

public final class DCMathHelper {

	public static long longBinExp(long n) {
		
		if (n < 0L) return 0L;
		
		long out = 1;
		long n2 = n;
		for (; n2 >= 0; n2--) {
			out *= 2;
		}
		return out;
	}

	public static boolean bitwiseFoldAnd(Long l) {
		return Long.bitCount(l) / Long.toString(l).length() == 1;
	}
}
