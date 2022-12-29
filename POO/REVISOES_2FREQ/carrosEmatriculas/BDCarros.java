package carrosEmatriculas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;

public class BDCarros {
	
	private Map<String, Carro> map = new HashMap<>();
	
	private static BDCarros INSTANCE = null;
	
	private BDCarros(){}
	
	public static BDCarros getInstance() {
		if (INSTANCE == null)		
			INSTANCE = new BDCarros();
		
		return INSTANCE;
	}
	
	public void add(Carro carro) {
		map.put(carro.getMatricula(), carro);
	}
	
	public void remove(Carro carro) {
		map.remove(carro.getMatricula());
	}
	
	public Set<Carro> getInfo(Predicate<Carro> predicate){
		Set<Carro> carros = new HashSet<>();
		for (Entry<String, Carro> e  : map.entrySet())
			if (predicate.test(e.getValue()))
				carros.add(e.getValue());
		
		return carros;
	}
	
	public int numberOfCarros(int ano) {
		return getInfo(c -> c.getAno() == ano).size();
	}
	
	public Set<String> getMatriculas(String marca){
		Predicate<Carro> predicate = c -> c.getMarca().equals(marca);
		Set<String> matriculas = new HashSet<>();
		
		for (Entry<String, Carro> e  : map.entrySet())
			if (predicate.test(e.getValue()))
				matriculas.add(e.getKey());
		
		return matriculas;
	}
	
	Set<Entry<String, Carro>> getCars(){
		return map.entrySet();
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
