package autocomplete.utils;

import java.util.Comparator;

public interface BSAction {

	public static final Integer INVALID_RESULT = -1;

	default <Key> Integer result(int[] corners, int mid, Comparator<Key> comp, Key key, Key[] a) {

		// (1)
		// Array index [0, ..., (length -1)]
		if (mid == getLimit())
			return mid;

		// (2)
		if (comp.compare(key, a[getIndexKey(mid)]) != 0)
			return mid;

		// (2)
		setCorner(corners, mid);

		return INVALID_RESULT;
	}

	void setCorner(int[] corners, int mid);

	int getLimit();

	int getIndexKey(int mid);
}
