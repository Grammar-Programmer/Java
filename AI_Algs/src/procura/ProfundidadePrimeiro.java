package procura;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ProfundidadePrimeiro {
	
// Atributos
	private Stack<Node> stack;
	private List<Node> path;
	
// Construtores
	ProfundidadePrimeiro() {
		stack = new Stack<>();
		path = new ArrayList<>();
	}
	
// Procura Interface
	/**
	 * Se o nó atual for o nó destino encontrámos a solução.<p>
	 * Se o nó atual for um nó já visitado queremos voltar para trás.<p>
	 * Se o nó atual não tiver mais nós seguintes verificamos se é o nó final.<p>
	 * Se o nó atual tiver mais nós seguintes procuramos o último nó adicionado.<p>
	 * 
	 * @param actual - Nó atual
	 * @param objective - Nó que queremos chegar
	 * @return Uma lista de nós que representa o caminho encontrado pelo algoritmo de Profundidade-Primeiro
	 */
	List<Node> findPath(Node actual, Node objective) {
//		System.out.println(actual);
		if (actual.equals(objective)) {
			addPath(actual);
			return path;
		}
		
		if (actual.isVisitado()) {
			removePath(stack.peek());
			return findPath(stack.pop(), objective);
		}
		
		List<Node> nodes = actual.getNextNodes();
		addPath(actual);
		
		if (nodes != null)
			pushAll(nodes);
		else if (!actual.equals(objective)) {
			removePath(stack.peek());
			return findPath(stack.pop(), objective);
		};
		
		return findPath(stack.peek(), objective);
	}
	
// Auxiliar Functions
	private void pushAll(List<Node> nodes) {
		for (Node n : nodes)
			stack.push(n);
	}
	
	private void addPath(Node n) {
		n.ficouVisitado();
		path.add(n);
	}
	
	private void removePath(Node n) {
		int index = path.indexOf(n);
		if (index == -1)
			return;
		for (int i = path.size() - 1; index <= i; i--)
			path.remove(i);
	}
	
// Extra Functions
	void reset() {
		stack = new Stack<>();
		path = new ArrayList<>();
	}
}
