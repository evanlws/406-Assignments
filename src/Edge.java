import java.util.Comparator;

public class Edge {

	int vertex1;
	int vertex2;
	int weight;

	public Edge(int vertex1, int vertex2, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	public Edge(int vertex1, int vertex2) { 
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = 0;
	}
	
	public String description() {
		return "Edge: v1: " + this.vertex1 + " v2: " + this.vertex2;
	}
	
	public static Comparator<Edge> weightComparator = new Comparator<Edge>() {

		public int compare(Edge e1, Edge e2) {
		   int edge1 = e1.weight;
		   int edge2 = e2.weight;

		   return edge1 - edge2;
		}
	};
}
