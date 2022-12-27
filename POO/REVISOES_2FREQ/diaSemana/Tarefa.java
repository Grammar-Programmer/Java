package diaSemana;

public class Tarefa {
	private String tarefa;
	private DiaDaSemana diaSemana;
	
	Tarefa (String diaSemana, String tarefa){
		this.tarefa = tarefa;
		this.diaSemana = DiaDaSemana.valueOf(diaSemana.toUpperCase());
	}
	
	public String getTarefa() {
		return tarefa;
	}
	
	public DiaDaSemana getDiaSemana() {
		return diaSemana;
	}

	@Override
	public String toString() {
		return tarefa;
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
