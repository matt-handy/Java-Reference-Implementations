package graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGraphBuilding() {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		
		Graph graph = new Graph();
		graph.addVertex(A, B, 10);
		assertTrue(graph.getNodes().contains(A));
		assertTrue(graph.getNodes().contains(B));
		assertFalse(graph.getNodes().contains(C));
		
		graph.addVertex(B, C, 8);
		assertTrue(graph.getNodes().contains(A));
		assertTrue(graph.getNodes().contains(B));
		assertTrue(graph.getNodes().contains(C));

		assertEquals(graph.getNodes().size(), 3);
		assertEquals(graph.getVertices().size(), 2);
		
		//Try adding a duplicate vertex
		graph.addVertex(B, C, 8);
		assertTrue(graph.getNodes().contains(A));
		assertTrue(graph.getNodes().contains(B));
		assertTrue(graph.getNodes().contains(C));

		assertEquals(graph.getNodes().size(), 3);
		assertEquals(graph.getVertices().size(), 2);
		
		Vertex testAB = new Vertex(A, B, 10);
		Vertex testBC = new Vertex(B, C, 8);
		Vertex testCD = new Vertex(C, D, 8);

		assertTrue(graph.getVertices().contains(testAB));
		assertTrue(graph.getVertices().contains(testBC));
		assertFalse(graph.getVertices().contains(testCD));
		
		graph.addVertex(A, E, 100);
		Vertex testAE = new Vertex(A, E, 100);
		Vertex testAEPrime = new Vertex(A, E, 1000);
		assertTrue(graph.getVertices().contains(testAE));
		assertFalse(graph.getVertices().contains(testAEPrime));
	}

}
