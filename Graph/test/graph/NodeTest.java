package graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeTest {

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
		
		Node C = A;
		
		//Put a baseline test in case nodes have state that needs to be compared later
		assertTrue(C.equals(A));
		assertFalse(B.equals(A));
	}

}
