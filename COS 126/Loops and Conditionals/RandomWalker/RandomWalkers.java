package RandomWalker;

/* 
 * % java RandomWalkers	 N	   T
 *  N = steps
 *  T = Repeat T times
 * 
 * % java RandomWalkers 100 100000         % java RandomWalkers 400 100000
 * mean squared distance = 100.15086       mean squared distance = 401.22024
 * 
 * % java RandomWalkers 100 100000         % java RandomWalkers 800 100000
 * mean squared distance = 99.95274        mean squared distance = 797.5106
 * 
 * % java RandomWalkers 200 100000         % java RandomWalkers 1600 100000
 * mean squared distance = 199.57664       mean squared distance = 1600.13064
 * */

public class RandomWalkers {

	public static void main(String[] args) {
		int times = 100000;
		int numberOfSteps = 400 ;
		
		if (args.length > 0) {
			numberOfSteps = Integer.parseInt(args[0]);
			if (args.length > 1)
				times = Integer.parseInt(args[1]);
		}
		
		double probability = 0.25;
		String graphSymbol = "x";
		double totalDistance = 0;
		
		RandomWalker[] rwVector = new RandomWalker[times];
		for (int i = 0; i < times; i++) {
			rwVector[i] = RandomWalker.create(numberOfSteps, probability, graphSymbol);
			totalDistance += rwVector[i].getDistanceTraveled();
		}
		
		System.out.println("mean squared distance = " + totalDistance / times);

	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
