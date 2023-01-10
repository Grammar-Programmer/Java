package autocomplete;

import java.util.Comparator;

import autocomplete.utils.BSAction;
import autocomplete.utils.FirstIndex;
import autocomplete.utils.LastIndex;

public class BinarySearchDeluxe {

	// Returns the index of the first key in the sorted array a[]
	// that is equal to the search key, or -1 if no such key.
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if (a == null || key == null || comparator == null)
			throw new  IllegalArgumentException("Arguments can not be null");
		return binarySearch(a, key, comparator, new FirstIndex());
	}

	// Returns the index of the last key in the sorted array a[]
	// that is equal to the search key, or -1 if no such key.
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if (a == null || key == null || comparator == null)
			throw new  IllegalArgumentException("Arguments can not be null");
		return binarySearch(a, key, comparator, new LastIndex(a.length - 1));
	}

	private static <Key> int binarySearch(Key[] a, Key key, Comparator<Key> comparator, BSAction action) {
		int[] corners = { 0, a.length - 1 };
		while (corners[0] <= corners[1]) {
			int mid = corners[0] + (corners[1] - corners[0]) / 2;
			if (comparator.compare(key, a[mid]) < 0)
				corners[1] = mid - 1;
			else if (comparator.compare(key, a[mid]) > 0)
				corners[0] = mid + 1;
			else {
				int result = action.result(corners, mid, comparator, key, a);
				if (result != BSAction.INVALID_RESULT)
					return result;

				action.setCorner(corners, mid);
			}
		}
		return BSAction.INVALID_RESULT;
	}

	// unit testing (required)
	public static void main(String[] args) {
		System.out.println("Lexicographic order");
		// Lexicographic order
		Term[] list1 = { new Term("ABC", 0), new Term("Beta", 1), new Term("Maresia", 2), new Term("Marbles", 3),
				new Term("Marbles", 4), new Term("Marbles", 5), new Term("Mark Evans", 6), new Term("Zed", 7) };

		Term term1 = new Term("Marbles", 1);
		int r = "Marbles".length() - 4;
		String subTerm = "Marbles".substring(0, r);
		// Finding term1
		System.out.println(
				"First index with subTerm " + subTerm + ": " + firstIndexOf(list1, term1, Term.byPrefixOrder(r)));
		System.out.println(
				"Last index with subTerm " + subTerm + ": " + lastIndexOf(list1, term1, Term.byPrefixOrder(r)));

		
		System.out.println("\nDescending order by weight");
		// Descending order by weight
		Term[] list2 = { new Term("Marbles", 7), new Term("Zed", 5), new Term("Finn", 5), new Term("Nest", 5), new Term("Better", 5),
				new Term("Beta", 3), new Term("ABC", 1) };
		int weight = 5;
		Term term2 = new Term("Finn", weight);

		// Finding term2
		System.out.println(
				"First index with weight " + weight + ": " + firstIndexOf(list2, term2, Term.byReverseWeightOrder()));
		System.out.println(
				"Last index with weight " + weight + ": " + lastIndexOf(list2, term2, Term.byReverseWeightOrder()));

	}
}
