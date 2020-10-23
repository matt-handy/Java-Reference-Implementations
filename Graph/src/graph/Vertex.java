package graph;

public class Vertex {

	public final Node origin;
	public final Node destination;
	public final int distance;

	public Vertex(Node origin, Node destination, int distance) {
		this.origin = origin;
		this.distance = distance;
		this.destination = destination;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Vertex) {
			Vertex otherV = (Vertex) other;
			if (otherV.origin == origin && otherV.destination == destination && otherV.distance == distance) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
	    return origin.hashCode() + destination.hashCode() + new Integer(distance).hashCode();
	}
}
