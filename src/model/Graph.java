package model;
import java.util.Arrays;

public abstract class Graph {

	public int numNodes;
	public int numEdges;
	
	int [] edgeIntegerArray;
	
	public Graph(int numNodes, int numEdges, String edgesList) {
		
		this.numNodes = numNodes;
		this.numEdges = numEdges;

		//Parse the input data and create the edges and node array
		String[] edgeStringArray = edgesList.split("[ ]+");
		edgeIntegerArray = new int [edgeStringArray.length]; 
		for (int i = 0; i < edgeStringArray.length; i++) {
			edgeIntegerArray[i] = Integer.parseInt(edgeStringArray[i]);
		}
		
	}

	public int numNodes() {
		return this.numNodes;
	}

	public int numEdges() {
		return this.numEdges;
	}

	public Node[] adjacentVertices(Node i) {
		return adjacentVertices(i.name);
	}

	public boolean areAdjacent(Node i, Node j) {
		return areAdjacent(i.name, j.name);
	}

	public int degree(int i) {
		return inDegree(i) + outDegree(i);
	}

	public int degree(Node i) {
		return degree(i.name);
	}

	public int inDegree(Node i) {
		return inDegree(i.name);
	}

	public int outDegree(Node i) {
		return outDegree(i.name);
	}
	
	public boolean existsEdge(Edge e) {
		return existsEdge(e.vertex1, e.vertex2);
	}
		
	//Helper method to add nodes to array
	public Node[] addElement(Node[] org, Node added) {
	    Node[] result = Arrays.copyOf(org, org.length + 1);
	    result[org.length] = added;
	    return result;
	}
	
	public abstract void putEdge(int i, int j);
	
	public abstract void putEdge(Edge e);

	public abstract void removeEdge(int i, int j);
	
	public abstract void removeEdge(Edge e);

	public abstract boolean existsEdge(int i, int j);

	public abstract Node[] adjacentVertices(int i);
		
	public abstract int outDegree(int i);
	
	public abstract int inDegree(int i);

	public abstract boolean areAdjacent(int i, int j);
	
	public abstract int[] inDegreeArray();
		
}
