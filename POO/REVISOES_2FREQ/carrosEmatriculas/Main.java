package carrosEmatriculas;

import java.util.Map.Entry;

public class Main {
	
	public static final int FIRST_CAR = 1886;

	public static void addRandomCars(BDCarros bdCarros, int numberCars, int range) {
		while (numberCars > 0) {
			bdCarros.add(new Carro(randomMarca(), randomMatricula(), randomAno(range)));
			numberCars--;
		}
	}

	public static String randomMatricula() {
		String str = "";
		for (int i = 0; i < Carro.MATRICULA_SIZE; i++) {
			for (int j = 0; j < Carro.PARTE_SIZE; j++) {
				if (Math.random() < 0.5)
					str += (char) ((int) (Math.random() * ('Z' - 'A' + 1) + 'A'));
				else
					str += (int) (Math.random() * 10);
			}
			str += Carro.NEW_SEPARATOR;
		}
		
		return str;
	}

	public static Marca randomMarca() {
		return Marca.values()[(int)(Math.random() * Marca.values().length)];
	}
	
	public static int randomAno(int range) {
		return (int)(Math.random() * range + FIRST_CAR);
	}
	
	public static int getRange() {
		return (int)(System.currentTimeMillis() / 1000 / 60 / 60 / 24 / 365) + 1969 - FIRST_CAR;	
	}

	public static void main(String[] args) {

		BDCarros bdCarros = BDCarros.getInstance();
		int size = 11;
		int range = getRange();
		System.out.println(".................Adding " + size + " Cars in map.................");
		addRandomCars(bdCarros, size, range);
		System.out.println(".................Printing all cars.................");
		for (Entry<String,Carro> e : bdCarros.getCars())
			System.out.println(e.getValue());
		
		int ano = 2013;
		System.out.println("Numero de carros no ano " + ano + ": " + bdCarros.numberOfCarros(ano));
		bdCarros.add(new Carro(randomMarca(), randomMatricula(), ano));
		bdCarros.add(new Carro(randomMarca(), randomMatricula(), ano));
		bdCarros.add(new Carro(randomMarca(), randomMatricula(), ano));
		System.out.println("Numero de carros no ano " + ano + ": " + bdCarros.numberOfCarros(ano));
		
		String marca = "Cupra";
		System.out.println("Mostra carros da marca " + marca + ": " + bdCarros.getMatriculas(marca));
		bdCarros.add(new Carro(marca, randomMatricula(), randomAno(range)));
		bdCarros.add(new Carro(marca, randomMatricula(), randomAno(range)));
		bdCarros.add(new Carro(marca, randomMatricula(), randomAno(range)));
		System.out.println("Mostra carros da marca " + marca + ": " + bdCarros.getMatriculas(marca));
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
