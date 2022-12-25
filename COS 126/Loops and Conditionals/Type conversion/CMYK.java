public class CMYK {

	private double cyan, magenta, yellow, black;
		
	// White == 0
	CMYK() {
		this.cyan = 0;
		this.magenta = 0;
		this.yellow = 0;
		this.black = 1;
	}

	// White != 0
	CMYK(double cyan, double magenta, double yellow, double black) {
		this.cyan = verifyArgument(cyan);
		this.magenta = verifyArgument(magenta);
		this.yellow = verifyArgument(yellow);
		this.black = verifyArgument(black);
	}

	private static double verifyArgument(double value) {
		if (value > 1.0)
			throw new IllegalArgumentException("Value: " + value + " Out Of Bounds");
		if (value < 0.0)
			throw new IllegalArgumentException("Value: " + value + " Out Of Bounds");

		return value;
	}

	public double getC() {
		return cyan;
	}

	public double getM() {
		return magenta;
	}

	public double getY() {
		return yellow;
	}

	public double getB() {
		return black;
	}

	public double getW() {
		return 1 - black;
	}

	@Override
	public String toString() {
		return "Cyan = " + cyan + "\n" + "Magenta = " + magenta + "\n" + "Yellow = " + yellow + "\n" + "Black = "
				+ black;
	}

// Statics
	public static CMYK formatRGBToCMYK(int red, int green, int blue) {
		double temp_red = (red/ 255.0);
		double temp_green = (green/ 255.0);
		double temp_blue = (blue/ 255.0);
				
		double white = Math.max(temp_red, Math.max(temp_green, temp_blue));
		
		if (white == 0)
			return new CMYK();
		
		return new CMYK((white - temp_red) / white, (white - temp_green) / white, (white - temp_blue) / white,
				1 - white);
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
