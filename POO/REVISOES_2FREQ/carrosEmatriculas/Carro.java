package carrosEmatriculas;

public class Carro {

	public static final String OLD_SEPARATOR = "-";
	public static final String NEW_SEPARATOR = " ";
	public static final int MATRICULA_SIZE = 3;
	public static final int PARTE_SIZE = 2;
	
	private Marca marca;
	private String matricula;
	private int ano;
	
	public Carro(String marca, String matricula, int ano) {
		matricula = formatMatricula(matricula);
		if (matricula == null)
			throw new IllegalArgumentException("Matricula Invalida");
		this.marca = Marca.valueOf(marca);
		this.matricula = matricula;
		this.ano = ano;
	}
	
	public Carro(Marca marca, String matricula, int ano) {
		matricula = formatMatricula(matricula);
		if (matricula == null)
			throw new IllegalArgumentException("Matricula Invalida");
		this.marca = marca;
		this.matricula = matricula;
		this.ano = ano;
	}
	
	public String getMarca() {
	 	return marca.name();
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public int getAno() {
		return ano;
	}
	
	public static String formatMatricula(String matricula) {
		String[] vector;
		if (matricula.contains(OLD_SEPARATOR))
			vector = matricula.split(OLD_SEPARATOR);
		else
			vector = matricula.split(NEW_SEPARATOR);
		
		if(vector.length != MATRICULA_SIZE || !isValidPartes(vector))
			return null;
		
		return String.join(NEW_SEPARATOR, vector[0], vector[1], vector[2]);
	}
	
	private static boolean isValidPartes(String[] partes) {
		for(String parte : partes)
			if (parte.length() != PARTE_SIZE)
				return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Marca: " + marca + " Matricula: " + matricula + " Ano de Fabrico: " + ano;
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
