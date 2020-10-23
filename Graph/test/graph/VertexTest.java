package graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VertexTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		
		Vertex vAB = new Vertex(A, B, 10);
		Vertex vABPrime = new Vertex(A, B, 10);
		Vertex vBC = new Vertex(B, C, 8);
		
		assertTrue(vAB.destination == B);
		assertTrue(vAB.origin == A);
		assertTrue(vAB.distance == 10);
		assertTrue(vAB.equals(vABPrime));
		assertFalse(vAB.equals(vBC));
	}

}
