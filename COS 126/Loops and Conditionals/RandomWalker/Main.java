package RandomWalker;

/* Moves N steps, each step is random and with |step| = 1
 * Shows Points Traveled
 * Shows The Up Right Point in Graph
 * Shows Graph: x = point
 * 				- = line where y = 0
 * 
 * % java Main 10            % java Main 20
 * Number of Steps: 10				 Number of Steps: 20
 * Trajectory Points:				 Trajectory Points:
 * (0, -1)                           (0, 1)
 * (0, 0)                            (-1, 1)
 * (0, 1)                            (-1, 2)
 * (0, 2)                            (0, 2)
 * (-1, 2)                           (1, 2)
 * (-2, 2)                           (1, 3)
 * (-2, 1)                           (0, 3)
 * (-1, 1)                           (-1, 3)
 * (-2, 1)                           (-2, 3)
 * (-3, 1)                           (-3, 3)
 * Distance Traveled: 10             (-3, 2)
 * Max Point: (3, 2)                 (-4, 2)
 * Graph:                            (-4, 1)
 *  xx...                            (-3, 0)                                                                   
 *  ----    -> y=0                   (-3, 1)
 *  x...                             (-4, 0)
 *                                   (-4, -1)
 *                                   (-3, -1)
 *                                   (-3, -2)
 *                                   (-3, -3)
 *                                   Distance Traveled: 18
 *                                   Max Point: (4, 3)
 *                                   Graph:
 *                                    x x x... 
 *                                   xxxxxx...
 *                                    -------    -> y=0 
 *                                    xx...                                                 
 * */

public class Main {

	public static void main(String[] args) {
		int numberOfSteps = 120;
		if (args.length > 0)
			numberOfSteps = Integer.parseInt(args[0]);

		double probability = 0.25;
		String graphSymbol = "x";
		RandomWalker rw = RandomWalker.create(numberOfSteps, probability, graphSymbol);
		
		System.out.println("Number of Steps: "+ rw.getSteps());
		
		System.out.println("Trajectory Points:");
		rw.printTrajectory();
		
		System.out.println("Distance Traveled: "+ (int)rw.getDistanceTraveled());
		
		System.out.println("Max Point: " + rw.getGraph().getUpRightPointInAxis());
		
		System.out.println("Graph: \n"+ rw.getGraph());
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
