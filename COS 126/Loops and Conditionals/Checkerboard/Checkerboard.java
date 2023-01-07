/* . Create N x N Chess Board
 * .
 * . % java Checkerboard 4             % java Checkerboard 5
 * .	* * * *                           * * * * * 
 * .	 * * * *                           * * * * *
 * .	* * * *                           * * * * * 
 * .	 * * * *                           * * * * *
 * .	                                 * * * * * 
 * .
 * */
public class Checkerboard {

	public static String getStringFormated(int numberPerLine, int numberPerColumn, String simbol, String separator) {
		String str = "";

		for (int i = 0; i < numberPerLine; i++) {
			for (int j = 0; j < numberPerColumn; j++) {
				str += simbol + separator;
			}
			str += "\n";
			if (i % 2 == 0)
				str += separator;
		}

		return str;
	}

	public static void main(String[] args) {
		int numberPerLine = Integer.parseInt(args[0]);
		int numberPerColumn = Integer.parseInt(args[0]);
		String simbol = "*";
		String separator = " ";
		System.out.println(getStringFormated(numberPerLine, numberPerColumn, simbol, separator));
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
