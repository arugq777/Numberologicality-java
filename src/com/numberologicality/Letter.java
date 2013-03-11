package com.numberologicality;

abstract class Letter {
	
	static char allegedLetter = ' ';
	static int numberValue;

	static char[] vowels     = {'a', 'e', 'i', 'o', 'u' };
	static char[] allLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
								'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 
								's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	static public void set(char letter){
		allegedLetter = letter;
		getValue(allegedLetter);
	}
	
	static public int getValue(char letter){
	
		for(int i = 0; i < allLetters.length; i++){

			int n = ( i + 1 ) % 9;

			if( n== 0 ){
				numberValue = 9;
			} else {
				numberValue = n;
			}

			if(letter == allLetters[i]){
				break;
			}
			//System.out.println(allegedLetter + " " + allLetters[i] + ": " + numberValue + " " + n);
		}
		return numberValue;
	}
	
	static public boolean isReallyALetter() {
		for(char c: allLetters) {
			if( allegedLetter == c ) {
				return true;
			}
		}
		return false;
	}
	
	static public boolean isAVowel() {
		for(char c: vowels) {
			if( allegedLetter == c ) {
				return true;
			}			
		}
		return false;
	}
}
