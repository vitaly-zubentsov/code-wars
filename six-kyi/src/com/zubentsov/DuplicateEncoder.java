package com.zubentsov;


/*
 * The goal of this exercise is to convert a string to a new string
 * where each character in the new string is "(" if that character
 * appears only once in the original string, or ")" if that character
 * appears more than once in the original string. Ignore capitalization
 * when determining if a character is a duplicate.
 *    
 * Examples
 *    "din"      =>  "((("
 *    "recede"   =>  "()()()"
 *    "Success"  =>  ")())())"
 *    "(( @"     =>  "))((" 
 * 
 * Notes
 * Assertion messages may be unclear about what they display in some languages.
 * If you read "...It Should encode XXX", the "XXX" is the expected result,
 *  not the input!
 */

public class DuplicateEncoder {
	static String encode(String word) {
		word = word.toLowerCase();
		//initialize required variables 
		char[] characterOfWord = word.toCharArray();
		int lengthOfWord = characterOfWord.length;
		char[] result = new char[lengthOfWord];
		
		//go thru array of characters input word, 
		// compare value with each other 
		for (int i = 0; i < lengthOfWord; i++) {
			result[i] = '(';
			//compare character i before i index
			for (int j = 0; j < i; j++) {
				if (characterOfWord[i] == characterOfWord[j]) {
					result[i] = ')';
					break;
				}
			}
			
			//if the duplicated character is already found then stop 
			//passing through the array 
			if (result[i] != ')') {
				//compare character i after i index
				for (int j = i+1; j < lengthOfWord ; j++) {

					if (characterOfWord[i] == characterOfWord[j]) {
						result[i] = ')';
						break;
					}
				}
			}
		}
		return new String(result);
	}
	
	public static void main(String[] args) {
		System.out.println(encode("Prespecialized"));
		//System.out.println(encode("123"));
	}
}
