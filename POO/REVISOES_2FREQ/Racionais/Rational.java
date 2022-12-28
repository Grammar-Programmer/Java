package Racionais;

public class Rational implements Comparable<Rational> {
	
	private int numerator;
	private int denominator;

	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}

	@Override
	public int compareTo(Rational other) {
		return numerator * other.denominator - other.numerator * denominator;
	}
	
	@Override
	public boolean equals(Object r) {
		return r != null && compareTo((Rational)r) == 0;
	}
	
	// Not the best Implementation for the job
	@Override
	public int hashCode() {
		Rational r = simplify();
		if (r.numerator == numerator)
			return numerator * denominator;
		
		return hashCode(r);
	}
	
	private static int hashCode(Rational r) {
		return r.hashCode();
	}
	
	public Rational simplify() {
		int max, min;
		if (denominator > numerator) {
			max = denominator;
			min = numerator;
		} else {
			max = numerator;
			min = denominator;
		}

		if (max / min != 0 && numerator != 1)
			return new Rational(numerator / min, denominator / min);
		
		return this; 
	}
}
