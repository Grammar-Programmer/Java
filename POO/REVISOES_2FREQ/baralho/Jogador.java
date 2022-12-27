package baralho;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	
	private String nome;
	private List<Carta> mao;
	
	public Jogador(String nome, List<Carta> vector) {
		this.nome = nome;
		mao = new ArrayList<>(vector);
	}
	
	public Jogador(String nome) {
		this.nome = nome;
		mao = new ArrayList<>();
	}
	
	public void addCard(Carta c) {
		if (c.inHand())
			return;
		
		c.updateCard(true);
		mao.add(c);
	}
	
	public void removeCard(Carta c) {
		c.updateCard(false);
		mao.remove(c);
	}
	
	public int getPontos() {
		int pts = 0;
		for (Carta c : mao)
			pts += c.getOrdem().getPontuacao();
		
		return pts;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		String str = "Nome: " + nome + "\n";
		for (Carta c : mao)
			str += c + "\n";
		
		return str;
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
