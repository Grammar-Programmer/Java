package baralho;

import java.util.ArrayList;
import java.util.List;

public class Carta {
	private Naipe naipe;
	private Ordem ordem;
	private boolean inHand;
	
	public static final int NUMCARTAS = 40;

	private static final List<Carta> cartas = new ArrayList<>(NUMCARTAS);
	
	static {
		for (int i = 0; i < Naipe.values().length; i++)
			for (int j = 0; j < Ordem.values().length; j++)
				cartas.add(new Carta(Naipe.values()[i], Ordem.values()[j]));
	}
	
	public static List<Carta> getBaralho(){
		return cartas;
	}

	private Carta(Naipe naipe, Ordem ordem) {
		this.naipe = naipe;
		this.ordem = ordem;
	}
	
	public static Carta getCarta(Carta c) {
		return getCarta(c.getNaipe(), c.getOrdem());
	}
	
	public static Carta getCarta(Naipe n, Ordem o) {
		return cartas.get(n.ordinal() * Ordem.values().length + o.ordinal() );
	}
	
	public Naipe getNaipe() {
		return naipe;
	}
	
	public Ordem getOrdem() {
		return ordem;
	}
	
	public void updateCard(boolean bool) {
		inHand = bool;
	}
	
	public boolean inHand() {
		return inHand;
	}
	
	@Override
	public String toString() {
		return ordem + " de " + naipe + " " + ordem.getPontuacao();
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
