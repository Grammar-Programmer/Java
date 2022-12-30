package divisoesEletrodomesticos;

public class Eletrodomestico {

	private String tipo;
	private Marca marca;
	private int potencia;
	
	Eletrodomestico(String tipo, String marca, int potencia){
		this.tipo = tipo;
		this.marca = Marca.valueOf(marca);
		this.potencia = potencia;
	}
	
	Eletrodomestico(String tipo, Marca marca, int potencia){
		this.tipo = tipo;
		this.marca = marca;
		this.potencia = potencia;
	}
	
	public String gettipo() {
		return tipo;
	}
	
	public Marca getmarca() {
		return marca;
	}
	
	public int getpotencia() {
		return potencia;
	}
	
	@Override
	public String toString() {
		return "Tipo: " + tipo + " Marca: " + marca + " Potencia: " + potencia + "W";
	}
}
