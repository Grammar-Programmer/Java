public class Ordered {
	
	public static void main(String[] args) {
		boolean isOrdered = false;	
				
		if (Integer.parseInt(args[0]) < Integer.parseInt(args[1]) && Integer.parseInt(args[1]) < Integer.parseInt(args[2]))
			isOrdered = true;
		
		else if (Integer.parseInt(args[0]) > Integer.parseInt(args[1]) && Integer.parseInt(args[1]) > Integer.parseInt(args[2]))
			isOrdered = true;
		
		System.out.println(isOrdered);
	}
}
