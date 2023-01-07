package RandomWalker;

import java.util.ArrayList;
import java.util.List;

public class RandomWalker {

	private Graph graph;
	private List<Point> trajectory;
	private int steps;
	private double UpProb;
	private double DownProb;
	private double LeftProb;
	private double RightProb;
	private Point lastPoint;

// Constructors
	RandomWalker(int steps, List<Point> trajectory, double UpProb, double DownProb, double LeftProb, double RightProb, Graph graph){
		this.steps = steps;
		this.trajectory = trajectory;
		this.UpProb =UpProb;
		this.DownProb = DownProb;
		this.LeftProb = LeftProb;
		this.RightProb = RightProb;
		this.graph = graph;
		if (!trajectory.isEmpty())
			this.lastPoint = trajectory.get(trajectory.size() - 1);
	}
	
	RandomWalker(int steps, List<Point> trajectory, double probability , Graph graph) {
		this (steps, trajectory, probability, probability, probability, probability, graph);
	}
	
	private RandomWalker(double UpProb, double DownProb, double LeftProb, double RightProb, Graph graph) {
		this (0, new ArrayList<>(), UpProb, DownProb, LeftProb, RightProb, graph);
	}

// Getters
	public double getDistanceTraveled() {
		return Math.sqrt(Math.pow(getLastPoint().getX(), 2) + Math.pow(getLastPoint().getY(), 2));
	}

	public Point getLastPoint() {
		return lastPoint;
	}
	
	public void printTrajectory() {
		trajectory.forEach(p -> System.out.println(p));
	}
	
	public int getSteps() {
		return steps;
	}
	
	public final Graph getGraph() {
		return graph;
	}
	
// Adders
	// Adds in trajectory and graph
	private void add(Point p) {
		if (lastPoint == null)
			lastPoint = p;
		else
			lastPoint = p.add(trajectory.get(trajectory.size() - 1));
		
		trajectory.add(lastPoint);
		graph.addPoint(lastPoint);
		steps++;
	}
	
	public void addRandom() {
		double result = Math.random();
		if (result < UpProb)
			add(Point.UP);
		else if (result < UpProb + DownProb)
			add(Point.DOWN);
		else if (result < UpProb + DownProb + LeftProb)
			add(Point.LEFT);
		else if (result < UpProb + DownProb + LeftProb + RightProb)
			add(Point.RIGHT);
	}
	

// Statics
	public static RandomWalker create(int numberOfPoints, double UpProb, double DownProb, double LeftProb,
				double RightProb, String pointSymbol) {
			RandomWalker rw = new RandomWalker(UpProb, DownProb, LeftProb, RightProb, new Graph(pointSymbol));
			
			while (numberOfPoints > 0) {
				rw.addRandom();
				numberOfPoints--;
			}
			
			return rw;
		}

	public static RandomWalker create(int numberOfPoints, double probability, String pointSymbol) {
		return create(numberOfPoints, probability, probability, probability, probability, pointSymbol);
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
