package direction;
import java.util.Scanner;

public enum Direction {

	EAST, NORTH, WEST, SOUTH;
	
	
	public static Direction askUser() {
		Scanner sc = new Scanner(System.in);
		return Direction.valueOf(sc.nextLine());		
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
