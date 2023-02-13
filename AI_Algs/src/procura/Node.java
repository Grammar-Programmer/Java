package procura;
import java.util.List;

public class Node implements Comparable<Node>{

// Atributos
	private List<Node> nextNodes;
	private boolean visitado = false;
	private String name;
	
// Construtores
	Node(String name, List<Node> nextNodes){
		this.nextNodes = nextNodes;
		this.name = name;
		nextNodes.sort(null);
	}
	
	Node(String name) {
		this.name = name;
	}
	
// Getters
	List<Node> getNextNodes(){
		return nextNodes;
	}
	
	String getName() {
		return name;
	}
	
	boolean isVisitado() {
		return visitado;
	}
	
// Setters
	void ficouVisitado() {
		visitado = true;
	}
	
	void addNextNode(Node n) {
		nextNodes.add(n);
		nextNodes.sort(null);
	}
	
// Object Class
	@Override
	public boolean equals(Object n) {
		return n instanceof Node && name.equals(((Node)n).getName());
	}
	
	@Override
	public String toString() {
		return "Node: " + name;
	}

// Comparable Interface
	@Override
	public int compareTo(Node o) {
		return name.compareTo(o.getName());
	}

}
