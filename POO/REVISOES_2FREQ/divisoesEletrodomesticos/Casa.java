package divisoesEletrodomesticos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Casa {

	private static Map<String, List<Eletrodomestico>> eletrodomesticos;
	private static Casa INSTANCE = null;
	
	private Casa() {
		eletrodomesticos = new HashMap<>();
	}
	
	public static Casa getINSTANCE() {
		if (INSTANCE == null)
			INSTANCE = new Casa();
		
		return INSTANCE;
	}
	
	public void add(String divisao, Eletrodomestico eletrodomestico) {
		List<Eletrodomestico> list;
		if (eletrodomesticos.containsKey(divisao)) {
			list = eletrodomesticos.get(divisao);
			list.add(eletrodomestico);
		} else {
			list = new ArrayList<>();
			list.add(eletrodomestico);
			eletrodomesticos.put(divisao, list);
		}
	}
	
	
	@Override
	public String toString() {
		String str = "";
		for (Entry<String, List<Eletrodomestico>> e : eletrodomesticos.entrySet())
			str += "Divisao: " + e.getKey() + "\n" + e.getValue() + "\n";
		
		return str;
	}
}
