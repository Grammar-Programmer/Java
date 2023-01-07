package RandomWalker;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/* Requirements: SortedSet must have GraphComparator to work as intended
 */
public class Graph {

	private Point cornerPoint;
	private SortedSet<Point> points;
	private String pointSymbol;

// Constructors
	Graph(Point cornerPoint, SortedSet<Point> points, String pointSymbol) {
		this.cornerPoint = cornerPoint;
		this.points = points;
		this.pointSymbol = pointSymbol;
	}

	Graph(String pointSymbol) {
		points = new TreeSet<>(new GraphComparator());
		this.pointSymbol = pointSymbol;
	}

	public static class GraphComparator implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			if (o2.getY() == o1.getY())
				return o1.getX() - o2.getX();

			return o2.getY() - o1.getY();
		}

	}

// Getters
	public int getWidth() {
		return cornerPoint.getX() * 2;
	}

	public int getHeight() {
		return cornerPoint.getY() * 2;
	}

	public Point getUpRightPointInAxis() {		
		return cornerPoint;
	}
	
	public Point getUpLeftPointInAxis() {
		return new Point(-getUpRightPointInAxis().getX(), getUpRightPointInAxis().getY());
	}

// Adders
	public void addPoint(Point point) {
		points.add(point);
		setBigger(point);
	}
	
// Setters
	private void setBigger(Point p) {
		if (cornerPoint == null)
			cornerPoint = p;
		else
			cornerPoint = new Point(Math.max(cornerPoint.getX(), Math.abs(p.getX())), Math.max(cornerPoint.getY(), Math.abs(p.getY())));
	}

// Removes
	// Removes last occurrence
	public void removePoint(Point point) {
		points.remove(point);
		if (point.equals(cornerPoint))
			cornerPoint = getMaxPoint(points);
	}

// Statics
	public static Point getMaxPoint(SortedSet<Point> set) {
		if (set.size() < 1)
			throw new IllegalArgumentException("Empty List");

		int[] maxPoint = { set.last().getX(), set.last().getY() };

		for (Point p : set) {
			if (Math.abs(p.getX()) > maxPoint[0])
				maxPoint[0] = p.getX();

			if (Math.abs(p.getY()) > maxPoint[2])
				maxPoint[1] = p.getY();
		}

		return new Point(maxPoint[0], maxPoint[1]);
	}
	
	public static String getNStrings(int n, String str) {
		String string = "";
		for (int i = 0; i < n; i++)
			string += str;

		return string;
	}
	
	public void printTree() {
		points.forEach(p -> System.out.println(p));
	}

	@Override
	public String toString() {
		String str = "";
		boolean xLine = true;
		Point previousPoint = getUpLeftPointInAxis();
		for (Point p : points) {
			
			if (p.getY() == 0 && xLine) {
				str += "\n";
				str += getNStrings(getWidth(), "-");
				xLine = false;
			}
			
			if (p.getY() != previousPoint.getY()) {
				str += getNStrings(previousPoint.getY() - p.getY(), "\n");
				previousPoint = new Point(getUpLeftPointInAxis().getX(), p.getY());
			}
			
			str += getNStrings(p.getX() - previousPoint.getX() - 1, " ");
			str += pointSymbol;
			previousPoint = p;
		}
		
		return str;
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
