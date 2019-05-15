package com.facebooklogin.utilities;

import java.util.Random;


/**
 * This class holds the utility function for Property file Random Number generation.
 *
 */
public class RandomNumberUtil {

	Random rm = new Random();

	public static String generateMobileNumber(int string_length)
	{
		String chars = "123456789";
		//int string_length = 12;
		String randomstring ="";
		for (int i=0; i < string_length; i++) {
		 Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(chars.length());
		 randomstring += chars.substring(randomInt,randomInt+1);
		}
		String returnString="0469" + randomstring;
		return returnString;

	}
	
	
	public static String generatePassword()
	{
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int string_length = 10;
		String randomstring ="";
		for (int i=0; i < string_length; i++) {
		 Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(chars.length());
		 randomstring += chars.substring(randomInt,randomInt+1);
		}
		//print(randomstring);
		return randomstring;

	}

	public static String generatefirstNameAndLastName()
	{
		String chars = "abcdefghijklmnopqrstuvwxyz";
		int string_length = 3;
		String randomstring ="";
		for (int i=0; i < string_length; i++) {
		 Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(chars.length());
		 randomstring += chars.substring(randomInt,randomInt+1);
		}
		System.out.println("String Generated: " + randomstring);
		return randomstring;

	}



}
