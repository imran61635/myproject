package utils;

import java.util.Random;

public class randomNumberGenerator {
	public static String get9RandomNumber() {
		Random random = new Random();
		//This produces 9 digit random number
		String num=String.format("%09d", random.nextInt(1000000000));
		return num;
	}
	public static String get4RandomNumber() {
		Random random = new Random();
		//This produces 4 digit random number
		String num=String.format("%04d", random.nextInt(10000));
		return num;
	}

}
