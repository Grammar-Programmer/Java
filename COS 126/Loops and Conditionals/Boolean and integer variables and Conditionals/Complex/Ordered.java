public class Ordered {

	// Requirements: Wanted Order: compare(...) returns <= 0
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean isOrdered(Comparable[] array, int compMulti) {
		for (int i = 0; i < array.length - 1; i++) {
			if (compMulti * array[i].compareTo(array[i + 1]) > 0) {
				return false;
			}
		}

		return true;
	}

	// Formats in wanted array
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> Comparable[] format(Object[] vector, Format<T> form) {
		if (!(vector instanceof Comparable[]))
			throw new IllegalArgumentException("Array must implement Comparable");

		Comparable[] vector2 = new Comparable[vector.length];
		
		for (int i = 0; i < vector.length; i++) {
			vector2[i] = (Comparable) form.format((T) vector[i]);
		}
		return vector2;
	}

	// WantedArray => Change it if needed, but not in main argument obviously
	@SuppressWarnings("rawtypes")
	public static void main(String[] wantedArray) {

		// Create Comparable Multiplier (Ascending Order and Descending Order)
		int compASC = 1;
		int compDESC = -1;

		// Create Format => Change it if needed
		Format<String> format = str -> Integer.parseInt(str);

		// Formats array
		Comparable[] formated = format(wantedArray, format);

		// Returns true if is strictly ascending order or in strictly descending order
		System.out.println(isOrdered(formated, compASC) || isOrdered(formated, compDESC));
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
