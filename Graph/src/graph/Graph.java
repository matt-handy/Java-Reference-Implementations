package graph;

import java.util.HashSet;
import java.util.Set;

public class Graph {

	private Set<Node> nodes = new HashSet<>();
	private Set<Vertex> vertices = new HashSet<>();
	
	public Set<Vertex> getVertices(){
		return new HashSet<>(vertices);
	}
	
	public Set<Node> getNodes(){
		return new HashSet<>(nodes);
	}
	
	public void addVertex(Node origin, Node dest, int len) {
		Vertex newVertex = new Vertex(origin, dest, len);
		for(Vertex vertex : vertices) {
			if(newVertex.equals(vertex)) {
				return;
			}
		}
		//Hash eliminates duplicate entries
		nodes.add(newVertex.destination);
		nodes.add(newVertex.origin);
		vertices.add(newVertex);
	}
}
