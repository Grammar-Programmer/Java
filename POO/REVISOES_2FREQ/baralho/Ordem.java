package baralho;

public enum Ordem {
	
	DOIS(0), TRES(0), QUATRO(0), CINCO(0), SEIS(10), SETE(0), OITO(0), NOVE(0), DEZ(0), DAMA(2), VALETE(3), REI(4), AS(11); 
	
	private int pontuacao;
	
	private Ordem(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
