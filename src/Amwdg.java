import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Amwdg extends Graph {

	int [][] matrix;

	public Amwdg(int numNodes, int numEdges, String edgesList) {
		super(numNodes, numEdges, edgesList);

		matrix = new int[numNodes + 1][numNodes + 1];
		for (int i = 0; i < edgeIntegerArray.length; i += 3) {
			matrix[edgeIntegerArray[i]][edgeIntegerArray[i + 1]] = edgeIntegerArray[i + 2];
		}
		printTestData();
	}

	protected void putEdge(int i, int j, int w) {
		matrix[i][j] = w;
	}
	
	protected void putEdge(int i, int j) {
		System.out.println("Please enter a weight");
	}
	
	protected void putEdge(Edge e) {
		putEdge(e.vertex1, e.vertex2, e.weight);
	}

	protected void removeEdge(int i, int j) {
		matrix[i][j] = 0;
	}
	
	protected void removeEdge(Edge e) {
		removeEdge(e.vertex1, e.vertex2);
	}

	protected boolean existsEdge(int i, int j) {
		if(matrix[i][j] != 0) {
			return true;
		}
		return false;
	}

	protected Node[] adjacentVertices(int i) {
		Node[] nodeArray =  new Node[0];
		for (int j = 0; j < matrix.length; j++) {
			if (areAdjacent(i, j)) {
				nodeArray = addElement(nodeArray, new Node(j));
			}
		}
		return nodeArray;
	}

	protected boolean areAdjacent(int i, int j) {
		if (existsEdge(i, j)) {
			return true;
		}
		return false;
	}

	protected int inDegree(int i) {
		int count = 0;
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[j][i] != 0) {
				count++;
			}
		}
		return count;
	}

	protected int outDegree(int i) {
		int count = 0;
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[i][j] != 0) {
				count++;
			}
		}
		return count;
	}
	
	protected int[] inDegreeArray() {
		int [] array = new int[numNodes + 1];
		for (int i = 0; i < numNodes + 1; i++) {
			array[i] = inDegree(i);
		}
		return array;
	}
	
	protected Queue<Edge> getPriorityQueue() {
		PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<Edge>(numEdges, Edge.weightComparator);
		for (int i = 0; i < edgeIntegerArray.length; i += 3) {
			edgePriorityQueue.offer(new Edge(edgeIntegerArray[i], edgeIntegerArray[i + 1], edgeIntegerArray[i + 2]));
		}
		return edgePriorityQueue;
	}
	
	protected void printTestData() {

		//Print Statements
		System.out.println("The Adjacency Matrix Weighted Directed Graph is: ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("\n");
		}

		System.out.println("The sorted array is: ");
		int[] sortedArray = TopologicalSort.sortedArray(this, inDegreeArray());
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
		System.out.println();
		System.out.println("The MST is:");
		Set<Edge> edges = KruskalsMST.minimumSpanningTree(getPriorityQueue(), numNodes);
		Iterator<Edge> it = edges.iterator();
		while(it.hasNext()) {
			Edge e = it.next();
			System.out.println(e.vertex1 + " " + e.vertex2 + " " + e.weight);
		}
		
	}

}
