package divisoesEletrodomesticos;

public class Main {
	
	public static void addRandomElements(Casa c,String[] tipos, int numElementos, int start, int end) {
		while(numElementos > 0) {
			c.add(randomDivisao().name(), new Eletrodomestico(tipos[(int)(Math.random() * tipos.length)], randomMarca(), randomPotencia(start, end)));
			numElementos--;
		}
	}
	
	public static Marca randomMarca() {
		return Marca.values()[(int)(Math.random() * Marca.values().length)];
	}
	
	public static Divisao  randomDivisao() {
		return Divisao.values()[(int)(Math.random() * Divisao.values().length)];
	}
	
	public static int randomPotencia(int start, int end) {
		return (int)(Math.random() * (end - start) + start);
	}
	
	public static void main(String[] args) {
		int start = 200;
		int end = 3000;
		int numElementos = 13;
		String[] tipos = {"LavaLoiça", "MicroOndas", "Televisão"};
		Casa c = Casa.getINSTANCE();
		addRandomElements(c, tipos, numElementos, start, end);
		
		System.out.println("Mostrar " + numElementos + " elementos na casa");
		System.out.println(c);
		
		
	}
}
