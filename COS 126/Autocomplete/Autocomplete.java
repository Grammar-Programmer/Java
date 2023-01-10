package autocomplete;

import java.util.Arrays;

import autocomplete.utils.BSAction;

public class Autocomplete {

	private Term[] terms;

	// Initializes the data structure from the given array of terms.
	public Autocomplete(Term[] terms) {
		if (terms == null)
			throw new IllegalArgumentException("Arguments can not be null");
		this.terms = terms;
		Arrays.sort(this.terms);
	}

	// Returns all terms that start with the given prefix, in descending
	// order of weight.
	public Term[] allMatches(String prefix) {
		if (prefix == null)
			throw new IllegalArgumentException("Arguments can not be null");
		
		int start = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
		int end = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length())) + 1;

		if (start == BSAction.INVALID_RESULT || end == BSAction.INVALID_RESULT) 
			return new Term[] {new Term("0 results found.", 0)};
		
		Term[] result = new Term[end - start];
		for (int i = 0; start < end; i++, start++) {
			result[i] = terms[start];
		}

		Arrays.sort(result, Term.byReverseWeightOrder());

		return result;
	}

	// Returns the number of terms that start with the given prefix.
	public int numberOfMatches(String prefix) {
		if (prefix == null)
			throw new IllegalArgumentException("Arguments can not be null");
		
		int start = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
		int end = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length())) + 1;

		if (start == BSAction.INVALID_RESULT || end == BSAction.INVALID_RESULT) 
			return 0;
		
		return end - start;
	}

	private static void print(Term[] list) {
		for (Term t : list)
			System.out.println(t);
	}
	// unit testing (required)
	public static void main(String[] args) {
		Term[] terms = new Term[10];
		terms[0] = new Term("ABC", 12);
		terms[1] = new Term("Hello", 41);
		terms[2] = new Term("Mark", 51);
		terms[3] = new Term("Mars", 7);
		terms[4] = new Term("Mare", 0);
		terms[5] = new Term("Zed", 11);
		terms[6] = new Term("Crazy", 2);
		terms[7] = new Term("Test", 5);
		terms[8] = new Term("ABCD", 76);
		terms[9] = new Term("Finn", 1);
		
		Autocomplete autocomplete = new Autocomplete(terms);
		String prefix = "Mar";
		System.out.println(prefix);
		System.out.println("All matches with prefix " + prefix + ":");
		print(autocomplete.allMatches(prefix));
		System.out.println("Number of matches with prefix " + prefix + ": " + autocomplete.numberOfMatches(prefix));
		
		prefix = "ABC";
		System.out.println("\n" + prefix);
		System.out.println("All matches with prefix " + prefix + ":");
		print(autocomplete.allMatches(prefix));
		System.out.println("\nNumber of matches with prefix " + prefix + ": " + autocomplete.numberOfMatches(prefix));
		
		prefix = "J";
		System.out.println("\n" + prefix);
		System.out.println("All matches with prefix " + prefix + ":");
		print(autocomplete.allMatches(prefix));
		System.out.println("\nNumber of matches with prefix " + prefix + ": " + autocomplete.numberOfMatches(prefix));

	}

}
