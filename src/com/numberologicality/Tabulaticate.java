package com.numberologicality;

import java.util.TreeMap;
import org.joda.time.LocalDate;

abstract class Tabulaticate {
	static TreeMap<Character, Integer> totalCount     = new TreeMap<Character, Integer>();
	static TreeMap<Character, Integer> vowelCount     = new TreeMap<Character, Integer>();
	static TreeMap<Character, Integer> consonantCount = new TreeMap<Character, Integer>();
	
	static char[] dissectedName = {};
	
	static void parseName(String name){
	
		totalCount.clear();
		vowelCount.clear();
		consonantCount.clear();

		dissectedName = name.toLowerCase().toCharArray();

		for(int i=0; i < dissectedName.length; i++){
			Letter.set(dissectedName[i]);
			if(Letter.isReallyALetter()){
				if(totalCount.containsKey(Letter.allegedLetter)){
					int n = totalCount.get(Letter.allegedLetter) + 1;
					totalCount.put(Letter.allegedLetter, n);
				} else { 
					totalCount.put(Letter.allegedLetter, 1);
				}
				
				if(Letter.isAVowel()){
					if(i > 0 && dissectedName[i-1] == '!'){
						if(consonantCount.containsKey(Letter.allegedLetter)){
							int n = consonantCount.get(Letter.allegedLetter) + 1;
							consonantCount.put(Letter.allegedLetter, n);
						} else { 
							consonantCount.put(Letter.allegedLetter, 1);
						}
					} else {
						if(vowelCount.containsKey(Letter.allegedLetter)){
							int n = vowelCount.get(Letter.allegedLetter) + 1;
							vowelCount.put(Letter.allegedLetter, n);
						} else { 
							vowelCount.put(Letter.allegedLetter, 1);
						}
					}

				} else {
					if(i > 0 && dissectedName[i-1] == '!'){
						if(vowelCount.containsKey(Letter.allegedLetter)){
							int n = vowelCount.get(Letter.allegedLetter) + 1;
							vowelCount.put(Letter.allegedLetter, n);
						} else { 
							vowelCount.put(Letter.allegedLetter, 1);
						}
					} else {
						if(consonantCount.containsKey(Letter.allegedLetter)){
							int n = consonantCount.get(Letter.allegedLetter) + 1;
							consonantCount.put(Letter.allegedLetter, n);
						} else { 
							consonantCount.put(Letter.allegedLetter, 1);
						}
					}
				}
			}
		}		
	}

	static int tabulate(TreeMap<Character, Integer> tm){
	
		int total = 0;
		
		for(int i = 0; i < Letter.allLetters.length; i++ ){
			Letter.set(Letter.allLetters[i]);
			if(tm.containsKey(Letter.allLetters[i])){
				int n = tm.get(Letter.allLetters[i]) * Letter.numberValue;
				total += n;
			}
		}
		//System.out.println("Total:" + total);
		return reduce(total);
	}
	
	static int reduce(int number){
	
		int n = 0;
				
		while(number > 0){
			n += number % 10;
			number = (number-(number%10))/10;
			if( n > 9 ){
				n = reduce(n);
			}
		}
		return n;
	}
	
	static int calculateLifePath(LocalDate bday){

		int lp = bday.getYear() + bday.getMonthOfYear() + bday.getDayOfMonth();
		//System.out.println("lp: " + lp);
		return reduce(lp);
	}
	
	static void calculateNameNumbers(Person person){
	
		int n= 0;
	
		parseName(person.fullName);

		n = tabulate(totalCount);
		//System.out.println("tc: " + n);
		person.numbers.put("Expression", n);

		n = tabulate(vowelCount);
		//System.out.println("vc: " + n);
		person.numbers.put("Soul", n);
		
		n = tabulate(consonantCount);
		//System.out.println("cc: " + n);
		person.numbers.put("Persona", n);
	}
	
	static void process(Person person){
	
		person.numbers.put("Life Path", calculateLifePath(person.birthday));
		calculateNameNumbers(person);

	}
}

