package diaSemana;

public class Main {
	
	public static void duvidarDeMim(GestorTarefas gt) {
		for (int i = 0; i < 30; i++) {
			int diaRandom = (int) (Math.random() * DiaDaSemana.values().length);
			
			System.out.println("Resultado da escolha: " + DiaDaSemana.values()[diaRandom]);
			
			System.out.println(gt.mostraTarefas(DiaDaSemana.values()[diaRandom]));
		}
	}

	public static void main(String[] args) {
		System.out.println("................. A criar Gestor de Tarefas.................");
		GestorTarefas gt = GestorTarefas.createGestor();
		
		if (gt == null) {
			System.out.println("................. Abortado.................");
			return;
		}
		
		gt.add(new Tarefa("Segunda", "Tarefa Cansada"));
		
		
		System.out.println("................. Mostrar Tarefas de um dia ao calhas.................");
		
		int diaRandom = (int) (Math.random() * DiaDaSemana.values().length);
		
		System.out.println("Resultado da escolha: " + DiaDaSemana.values()[diaRandom]);
		
		System.out.println(gt.mostraTarefas(DiaDaSemana.values()[diaRandom]));
		

		System.out.println("................. Mostrar as Tarefas todas.................");
		
		System.out.println(gt);
		
		//duvidarDeMim(gt);
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
