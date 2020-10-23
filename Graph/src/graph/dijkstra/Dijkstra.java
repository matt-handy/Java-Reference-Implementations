package graph.dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import graph.Graph;
import graph.Node;
import graph.Vertex;

public class Dijkstra {
	
	private Map<Node, Integer> distance = null;
	private Map<Node, Node> previous = null;

	private Graph targetGraph;
	
	public static final int INFINITY = -1;
	
	public Dijkstra(Graph graph) {
		this.targetGraph = graph;
	}
	
	public boolean buildSearch(Node origin) {
		distance = new HashMap<>();
		previous = new HashMap<>();
		for(Node node : targetGraph.getNodes()) {
			if(node.equals(origin)) {
				distance.put(node, 0);
			}else {
				distance.put(node, INFINITY);
			}
			previous.put(node, null);
		}
		Set<Node> toTestNodes = new HashSet<>(targetGraph.getNodes()); 
		while(!toTestNodes.isEmpty()) {
			Node currentTarget = getCurrentClosestNode(toTestNodes);
			toTestNodes.remove(currentTarget);
			Set<Vertex> adjacentVertices = getAllTouchingVertexAndInNodeSet(currentTarget, toTestNodes);
			for(Vertex candidate : adjacentVertices) {
				Node canNode;
				if(candidate.destination == currentTarget) {
					canNode = candidate.origin;
				}else {
					canNode = candidate.destination;
				}
				int altDistance = distance.get(currentTarget) + candidate.distance;
				if(distance.get(canNode) == INFINITY ||
						altDistance < distance.get(canNode)) {
					distance.put(canNode, altDistance);
					previous.put(canNode, currentTarget);
				}
			}
		}
		
			return true;
	}
	
	private Node getCurrentClosestNode(Set<Node> nodes) {
		Node currentClosest = null;
		for(Node node : nodes) {
			if(currentClosest == null ||
					distance.get(currentClosest) == INFINITY ||
					(distance.get(currentClosest) > distance.get(node) &&
							distance.get(node) != INFINITY) ) {
				currentClosest = node;
			}
		}
		return currentClosest;
	}
	
	private Set<Vertex> getAllTouchingVertexAndInNodeSet(Node node, Set<Node> nodes){
		Set<Vertex> touchpoints = new HashSet<>();
		for(Vertex v : targetGraph.getVertices()) {
			if(v.origin == node) {
				if(nodes.contains(v.destination)) {
					touchpoints.add(v);
				}
			}else if(v.destination == node) {
				if(nodes.contains(v.origin)) {
					touchpoints.add(v);
				}
			}
		}
		return touchpoints;
	}
	
	public Map<Node, Integer> getDistances() {
		if(distance != null) {
			return distance;
		}else {
			throw new IllegalStateException("Need to build results first");
		}
	}
	
	public Map<Node, Node> getPrevious() {
		if(previous != null) {
			return previous;
		}else {
			throw new IllegalStateException("Need to build results first");
		}
	}
}
