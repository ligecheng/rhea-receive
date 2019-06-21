package com.admin.util;

import java.util.Random;

public final class Tool {

	public static final String randomNum(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(new Random().nextInt(10));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String randomNum = randomNum(9);
		System.out.println(randomNum);
	}

}
