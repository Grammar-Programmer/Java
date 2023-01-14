package autocomplete;

import java.util.Comparator;

public class Term implements Comparable<Term> {

	private String query;
	private long weight;

	// Initializes a term with the given query string and weight.
	public Term(String query, long weight) {
		if (query == null || weight < 0)
			throw new IllegalArgumentException("Query null or weight is negative");
		this.query = query;
		this.weight = weight;
	}

	// Compares the two terms in descending order by weight.
	public static Comparator<Term> byReverseWeightOrder() {
		return (t1, t2) -> (int) (t2.weight - t1.weight);
	}

	// Compares the two terms in lexicographic order,
	// but using only the first r characters of each query.
	public static Comparator<Term> byPrefixOrder(int r) {
		if (r < 0)
			throw new IllegalArgumentException(" r is negative");

		return (t1, t2) -> {
			int lim = Math.min(Math.min(r, t1.query.length()), t2.query.length());
			int result = t1.query.substring(0, lim).compareTo(t2.query.substring(0, lim));
			if (result != 0)
				return result;
			return  t1.query.length() - t2.query.length();
		};
	}

	// Compares the two terms in lexicographic order by query.
	public int compareTo(Term that) {
		return query.compareTo(that.query);
	}

	// Returns a string representation of this term in the following format:
	// the weight, followed by a tab, followed by the query.
	@Override
	public String toString() {
		return weight + "\t\t" + query;
	}

	// unit testing (required)
	public static void main(String[] args) {
		long weight = 111;
		String query = "Testing";
		Term t1 = new Term(query, weight);
		Term t2 = new Term("CowBoy", 19);

		System.out.println(t1);
		System.out.println(t2);

		Comparator<Term> c1 = Term.byPrefixOrder(3);
		System.out.println("ByPrefixOrder: " + c1.compare(t1, t2));

		c1 = Term.byReverseWeightOrder();
		System.out.println("ByReverseWeightOrder: " + c1.compare(t1, t2));

		System.out.println("Comparable: " + t1.compareTo(t2));
	}

}
