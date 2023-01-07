package RandomWalker;

public class Point {

	public static final Point UP = new Point(0, 1);
	public static final Point DOWN = new Point(0, -1);
	public static final Point LEFT = new Point(-1, 0);
	public static final Point RIGHT = new Point(1, 0);

	private int x;
	private int y;

// Constructors
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

// Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

// Operations
	public Point add(Point p) {
		return new Point(x + p.x, y + p.y);
	}

	@Override
	public boolean equals(Object p) {
		return p != null && p instanceof Point && ((Point) p).x == x && ((Point) p).y == y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
