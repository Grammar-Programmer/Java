package Racionais;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void addRandomNumbers(List<Rational> list, int nElements, int range) {
		while(nElements > 0) {
			list.add(new Rational((int)(Math.random() * range), (int)(Math.random() * range)));
			nElements--;
		}
	}
	
	public static void main(String[] args) {
		List<Rational> list = new ArrayList<>();
		int numberOfElements = 13;
		int range = 712;
		System.out.println(".................Adding " + numberOfElements + " elements to List.................");
		addRandomNumbers(list, numberOfElements, range);
		
		
		System.out.println("\n.................Printing List without an Order.................");
		System.out.println(list);
		
		System.out.println("\n.................Printing List with Comparable Order.................");
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println("\n.................Printing List with Inverse Comparable Order(Using a Comparator).................");
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
		System.out.println("\n.................Printing List with Comparator Order.................");
		Collections.sort(list, (c1, c2) -> c1.getDenominator() - c2.getDenominator());
		System.out.println(list);
		
		System.out.println("\n.................Checking hashCode() and equals(Object o).................");
		int numerator = 1;
		int denominator = 2;
		int multiplier = 3;
		int offset = 1;
		Rational r1 = new Rational(numerator, denominator);
		Rational r2 = new Rational(numerator * multiplier, denominator * multiplier);
		Rational r3 = new Rational(numerator * multiplier + offset, denominator * multiplier + offset);
		System.out.println("Rational: "+ r1 +" HashCode: "+ r1.hashCode());
		System.out.println("Rational: "+ r2 +" HashCode: "+ r2.hashCode());
		System.out.println("Rational: "+ r3 +" HashCode: "+ r3.hashCode());
		System.out.println("Are they r1 and r2 equal: " + r1.equals(r2));
		System.out.println("Are they r3 and r1 equal: " + r3.equals(r1));
		System.out.println("Are they r3 and r2 equal: " + r3.equals(r2));
	}
}
