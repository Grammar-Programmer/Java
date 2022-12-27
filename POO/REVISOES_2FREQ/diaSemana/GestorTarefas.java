package diaSemana;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class GestorTarefas {
	
	private Map<Integer, List<String>> tarefasBD;
	
	GestorTarefas(){
		tarefasBD = new HashMap<>();
	}
	
// Adders
	public void add(Tarefa tarefa) {
		List<String> tarefas;
		int dia = tarefa.getDiaSemana().ordinal();
		String tarefaNome = tarefa.getTarefa();
		
		if (tarefasBD.containsKey(dia)) {
			tarefas = tarefasBD.get(dia);
			tarefas.add(tarefaNome);
		} else {
			tarefas = new ArrayList<>();
			tarefas.add(tarefaNome);
			tarefasBD.put(dia, tarefas);	
		}
	}
	
	public String mostraTarefas(DiaDaSemana diaSemana) {
		String str = diaSemana + "\n";
		if (tarefasBD.containsKey(diaSemana.ordinal()))
			for (String tarefa : tarefasBD.get(diaSemana.ordinal()))
				str += tarefa + "\n";
		else 
			str += "FREEEEE AY YOOOO" + "\n";
			
		str += diaSemana.nextDay() + "\n";
		if (tarefasBD.containsKey(diaSemana.nextDay().ordinal()))
			for (String tarefa : tarefasBD.get(diaSemana.nextDay().ordinal()))
				str += tarefa + "\n";
		else 
			str += "FREEEEE AY YOOOO" + "\n";
		
		return str;
	}
	
	public static GestorTarefas createGestor() {
		GestorTarefas gt = new GestorTarefas();
		try (Scanner sc = new Scanner(new File("tarefas.txt"))){			
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] tarefa = line.split(";");
				gt.add(new Tarefa(tarefa[0], tarefa[1]));
			}
			 
			return gt;
		} catch (FileNotFoundException e) {
			return null;
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		for (Entry<Integer, List<String>> e : tarefasBD.entrySet()) {
			str += DiaDaSemana.values()[e.getKey()] + ": "+ e.getValue() + "\n";
		}
		
		return str;
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
