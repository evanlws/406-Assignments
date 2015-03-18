import java.util.Arrays;

/*
 * Evan Lewis
 * Assignment 1
 * Due 2/11/15
 */

public abstract class Graph {

	int numNodes;
	int numEdges;
	
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

	protected int numNodes() {
		return this.numNodes;
	}

	protected int numEdges() {
		return this.numEdges;
	}

	protected Node[] adjacentVertices(Node i) {
		return adjacentVertices(i.name);
	}

	protected boolean areAdjacent(Node i, Node j) {
		return areAdjacent(i.name, j.name);
	}

	protected int degree(int i) {
		return inDegree(i) + outDegree(i);
	}

	protected int degree(Node i) {
		return degree(i.name);
	}

	protected int inDegree(Node i) {
		return inDegree(i.name);
	}

	protected int outDegree(Node i) {
		return outDegree(i.name);
	}
	
	protected boolean existsEdge(Edge e) {
		return existsEdge(e.vertex1, e.vertex2);
	}
		
	//Helper method to add nodes to array
	protected Node[] addElement(Node[] org, Node added) {
	    Node[] result = Arrays.copyOf(org, org.length + 1);
	    result[org.length] = added;
	    return result;
	}
	
	protected abstract void putEdge(int i, int j);
	
	protected abstract void putEdge(Edge e);

	protected abstract void removeEdge(int i, int j);
	
	protected abstract void removeEdge(Edge e);

	protected abstract boolean existsEdge(int i, int j);

	protected abstract Node[] adjacentVertices(int i);
		
	protected abstract int outDegree(int i);
	
	protected abstract int inDegree(int i);

	protected abstract boolean areAdjacent(int i, int j);
	
	protected abstract int[] inDegreeArray();
		
}
