package model;
import assignment3.Warshall;

public class Amdg extends Graph{

	int [][] matrix;

	public Amdg(int numNodes, int numEdges, String edgesList) {
		super(numNodes, numEdges, edgesList);

		matrix = new int[numNodes + 1][numNodes + 1];
		for (int i = 0; i < edgeIntegerArray.length; i += 2) {
			matrix[edgeIntegerArray[i]][edgeIntegerArray[i + 1]] = 1;
		}
		printTestData();
	}

	public void putEdge(int i, int j) {
		matrix[i][j] = 1;
	}
	
	public void putEdge(Edge e) {
		putEdge(e.vertex1, e.vertex2);
	}

	public void removeEdge(int i, int j) {
		matrix[i][j] = 0;
	}
	
	public void removeEdge(Edge e) {
		removeEdge(e.vertex1, e.vertex2);
	}

	public boolean existsEdge(int i, int j) {
		if(matrix[i][j] == 1) {
			return true;
		}
		return false;
	}

	public boolean areAdjacent(int i, int j) {
		if (existsEdge(i, j)) {
			return true;
		}
		return false;
	}
	
	public Node[] adjacentVertices(int i) {
		Node[] nodeArray =  new Node[0];
		for (int j = 0; j < matrix.length; j++) {
			if (areAdjacent(i, j)) {
				nodeArray = addElement(nodeArray, new Node(j));
			}
		}
		return nodeArray;
	}

	public int inDegree(int i) {
		int count = 0;
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[j][i] == 1) {
				count++;
			}
		}
		return count;
	}

	public int outDegree(int i) {
		int count = 0;
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[i][j] == 1) {
				count++;
			}
		}
		return count;
	}
	
	public int[] inDegreeArray() {
		int [] array = new int[numNodes + 1];
		for (int i = 0; i < numNodes + 1; i++) {
			array[i] = inDegree(i);
		}
		return array;
	}
	
	public void printTestData() {

		//Print statements
		System.out.println("The Adjacency Matrix Directed Graph is: ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Warshall's transitive closure is: ");
		int[][] transitiveClosure = Warshall.transitiveClosure(matrix);
		for (int i = 0; i < transitiveClosure.length; i++) {
			for (int j = 0; j < transitiveClosure.length; j++) {
				System.out.print(transitiveClosure[i][j] + " ");
			}
			System.out.println();
		}	
	}

}
