package model;

import assignment2.*;
import assignment3.*;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Amwg extends Graph {

	int [][] matrix;

	public Amwg(int numNodes, int numEdges, String edgesList) {
		super(numNodes, numEdges, edgesList);

		matrix = new int[numNodes + 1][numNodes + 1];
		for (int i = 0; i < edgeIntegerArray.length; i += 3) {
			matrix[edgeIntegerArray[i]][edgeIntegerArray[i + 1]] = edgeIntegerArray[i + 2];
			matrix[edgeIntegerArray[i + 1]][edgeIntegerArray[i]] = edgeIntegerArray[i + 2];
		}
		printTestData();
	}

	public void putEdge(int i, int j, int w) {
		matrix[i][j] = w;
		matrix[j][i] = w;
	}

	public void putEdge(int i, int j) {
		System.out.println("Please enter a weight");
	}
	
	public void putEdge(Edge e) {
		putEdge(e.vertex1, e.vertex2, e.weight);
	}

	public void removeEdge(int i, int j) {
		matrix[i][j] = 0;
		matrix[j][i] = 0;
	}
	
	public void removeEdge(Edge e) {
		removeEdge(e.vertex1, e.vertex2);
	}

	public boolean existsEdge(int i, int j) {
		if(matrix[i][j] != 0 || matrix[j][i] != 0) {
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

	public boolean areAdjacent(int i, int j) {
		if (existsEdge(i, j)) {
			return true;
		}
		return false;
	}

	public int inDegree(int i) {
		int count = 0;
		for (int j = 0; j < matrix.length; j++) {
			if (j > i) {
				if (matrix[j][i] != 0) {
					count++;
				}
			}
		}
		return count;
	}

	public int outDegree(int i) {
		int count = 0;
		for (int j = 0; j < matrix.length; j++) {
			if(i > j) {
				if (matrix[i][j] != 0) {
					count++;
				}
			}
		}
		return count;
	}

	public int degree(int i) {
		int count = 0;
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[i][j] != 0 || matrix[j][i] != 0) {
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
	
	public Queue<Edge> getPriorityQueue() {
		PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<Edge>(numEdges, Edge.weightComparator);
		for (int i = 0; i < edgeIntegerArray.length; i += 3) {
			edgePriorityQueue.offer(new Edge(edgeIntegerArray[i], edgeIntegerArray[i + 1], edgeIntegerArray[i + 2]));
		}
		return edgePriorityQueue;
	}
	
	public void printTestData() {

		//Print Statements
		System.out.println("The Adjacency Matrix Weighted Graph is: ");
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
