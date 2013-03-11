package com.numberologicality;

import org.joda.time.LocalDate;
import java.util.TreeMap;


class Person {

	String fullName = "";
	LocalDate birthday = new LocalDate();
	TreeMap<String, Integer> numbers = new TreeMap<String, Integer>();

    Person(String name, String bday) {
	
    	fullName = name;
		birthday = parseLocalDate(bday);
	
    }
    
    private LocalDate parseLocalDate(String bday) {
    	LocalDate date = new LocalDate();
    	date = LocalDate.parse(bday);
        return date;
   }
}