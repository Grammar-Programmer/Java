package autocomplete.utils;

public class LastIndex implements BSAction {

	// lastIndex must be {array}.length - 1
	private int lastIndex;

	public LastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	// (1)
	// mid + 1 > a.length - 1 -> ERROR
	@Override
	public int getLimit() {
		return lastIndex;
	}

	// (2)
	// If previous have the same value.
	// Example: Key = 3
	// Before: [1, 2, 3, 3, 3, 6]
	// Process: 6 / 2 = 3; Cut the array to find last key
	// After: [3, 6]

	// (2)
	// Process: 6 / 2 = 3
	@Override
	public int getIndexKey(int mid) {
		return mid + 1;
	}

	// (2)
	// Process: Cut the array to find last key
	@Override
	public void setCorner(int[] corners, int mid) {
		corners[0] = mid + 1;
	}
}
