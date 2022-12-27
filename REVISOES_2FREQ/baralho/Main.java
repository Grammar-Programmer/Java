package baralho;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static <T> void printList(List<T> list) {
		for (T e : list)
			System.out.println(e);
	}
	
	public static List<Carta> generateRandomCards(int n){
		List<Carta> cartas = new ArrayList<>();
		while (n > 0) {
			putRandomCard(cartas, Carta.getBaralho().get((int)(Math.random() * Carta.NUMCARTAS)));
			n--;
		}
		
		return cartas;
	}
	
	public static void putRandomCard(List<Carta> cartas, Carta c) {
		if (!(cartas.contains(c)) && !c.inHand()) {
			cartas.add(c);
			return;
		}
		
		putRandomCard(cartas, Carta.getBaralho().get((int)(Math.random() * Carta.NUMCARTAS)));		
	}
	
	public static void main(String[] args) {		
		System.out.println(".................Mostrar baralho.................");
		List<Carta> baralho = Carta.getBaralho();	
		printList(baralho);
		
		
		System.out.println("\n.................Gerar Jogadores e mostrar as suas informações.................");
		Jogador j1 = new Jogador("Grammar-Programmer");
		
		for (Carta c : generateRandomCards(10))
			j1.addCard(c);
		
		Jogador j2 = new Jogador("Alex", generateRandomCards(10));
		
		System.out.println(".................Jogador1.................");
		System.out.println(j1);
		
		System.out.println(".................Jogador2.................");
		System.out.println(j2);
		
		
		System.out.println(".................Teste de inserir uma carta que já está numa mão.................");
		j1.addCard(Carta.getCarta(Naipe.COPAS, Ordem.AS));
		j2.addCard(Carta.getCarta(Naipe.COPAS, Ordem.AS));
		
		System.out.println(".................Jogador1.................");
		System.out.println(j1);
		
		System.out.println(".................Jogador2.................");
		System.out.println(j2);
		
		
		System.out.println(".................Apresentar o Numero de Pontos.................");
		
		System.out.println(".................Jogador1.................");
		System.out.println(j1.getPontos());
		
		System.out.println(".................Jogador2.................");
		System.out.println(j2.getPontos());
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
