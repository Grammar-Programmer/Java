package procura;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teste_ProfundidadePrimeiro {
	
	public static void main(String[] args) {
		List<Node> nodes = new ArrayList<>();
		Node objective = new Node("S6");
		Node s8 = new Node("S9");
		Node s7 = new Node("S8", Arrays.asList(s8));
		Node s6 = new Node("S7", Arrays.asList(s7));
		Node s5 = new Node("S5");
		Node s4 = new Node("S4", Arrays.asList(objective, s6, s5));
		Node s3 = new Node("S3", Arrays.asList(s4));
		Node s2 = new Node("S2", Arrays.asList(s4));
		Node first = new Node("S1", Arrays.asList(s3, s2));
		
		ProfundidadePrimeiro pp = new ProfundidadePrimeiro();
		List<Node> path = pp.findPath(first, objective);
		
		System.out.print(path);
	}

}
