package com.numberologicality;

import java.io.*;

public class Numberologicality {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter name: ");
		String sName = br.readLine();

		System.out.print("Enter bday (yyyy-mm-dd):");
		String sBday = br.readLine();

		Person chump = new Person( sName , sBday );
		
		System.out.println("name: " + chump.fullName);
		System.out.println("bday: " + chump.birthday);
		
		Tabulaticate.process(chump);

		System.out.println("Expression: " + chump.numbers.get("Expression"));
		System.out.println("Soul: "       + chump.numbers.get("Soul"));
		System.out.println("Persona: "    + chump.numbers.get("Persona"));
		System.out.println("Life Path: "  + chump.numbers.get("Life Path"));
	}
}
