package graph.dijkstra;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import graph.Graph;
import graph.Node;

class DijkstraTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testTrivial() {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		
		Graph graph = new Graph();
		graph.addVertex(A, B, 10);
		graph.addVertex(B, C, 8);
		graph.addVertex(C, D, 2);
		graph.addVertex(D, E, 4);
		
		Dijkstra dijkstra = new Dijkstra(graph);
		assertTrue(dijkstra.buildSearch(A));
		Map<Node, Integer> distance = dijkstra.getDistances();
		assertEquals(distance.get(A), 0);
		assertEquals(distance.get(B), 10);
		assertEquals(distance.get(C), 18);
		assertEquals(distance.get(D), 20);
		assertEquals(distance.get(E), 24);
		
		Map<Node, Node> previous = dijkstra.getPrevious();
		assertEquals(previous.get(A), null);
		assertEquals(previous.get(B), A);
		assertEquals(previous.get(C), B);
		assertEquals(previous.get(D), C);
		assertEquals(previous.get(E), D);
	}
	
	@Test
	void testSmallGraph() {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		
		Graph graph = new Graph();
		graph.addVertex(A, B, 10);
		graph.addVertex(B, C, 8);
		graph.addVertex(C, D, 2);
		graph.addVertex(D, E, 4);
		graph.addVertex(A, D, 6);
		
		Dijkstra dijkstra = new Dijkstra(graph);
		assertTrue(dijkstra.buildSearch(A));
		Map<Node, Integer> distance = dijkstra.getDistances();
		assertEquals(distance.get(A), 0);
		assertEquals(distance.get(B), 10);
		assertEquals(distance.get(C), 8);
		assertEquals(distance.get(D), 6);
		assertEquals(distance.get(E), 10);
		
		Map<Node, Node> previous = dijkstra.getPrevious();
		assertEquals(previous.get(A), null);
		assertEquals(previous.get(B), A);
		assertEquals(previous.get(C), D);
		assertEquals(previous.get(D), A);
		assertEquals(previous.get(E), D);
	}

}
