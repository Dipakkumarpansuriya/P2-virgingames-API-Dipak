package com.virgin.utils;

import java.util.Random;

public class TestUtils {

	//Random Value Generator
	public static String getRandomValue(){
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		return Integer.toString(randomInt);
	}
}
