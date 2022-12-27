package direction;

public class Main {
	
	public  static String print(String playerName, Direction d) {
		return playerName + " is now facing " + d.name() + " (" + d.ordinal() * 90 + " degrees)";
	}
	
	public static void main(String[] args) {
		
		String playerName = "Lara Croft";
		
		for (Direction d : Direction.values()) {
			System.out.println(print(playerName, d));
		}
		
		for (int i = 0; i < Direction.values().length; i++)
			System.out.println(print(playerName, Direction.askUser()));
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
