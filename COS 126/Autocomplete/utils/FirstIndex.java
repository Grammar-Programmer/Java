package autocomplete.utils;

public class FirstIndex implements BSAction {

	private int firstIndex = 0;

	FirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public FirstIndex() {
	}

	// (1)
	// mid - 1 < 0 -> ERROR
	@Override
	public int getLimit() {
		return firstIndex;
	}

	// (2)
	// If previous have the same value.
	// Example: Key = 3
	// Before: [1, 2, 3, 3, 4, 5, 6]
	// Process: 7 / 2 = 3.5 -> 3; Cut the array to find previous key
	// After: [1, 2, 3]

	// (2)
	// Process: 7 / 2 = 3.5 -> 3
	@Override
	public int getIndexKey(int mid) {
		return mid - 1;
	}

	// (2)
	// Process: Cut the array to find previous key
	@Override
	public void setCorner(int[] corners, int mid) {
		corners[1] = mid - 1;
	}

}
