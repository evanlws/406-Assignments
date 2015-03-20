package model;

import java.util.Iterator;
import java.util.LinkedList;

import assignment2.TopologicalSort;

public class Aldg extends Graph {

	LinkedList<Edge>[] adjacencyList;

	@SuppressWarnings("unchecked")
	public Aldg(int numNodes, int numEdges, String edgesList) {
		super(numNodes, numEdges, edgesList);
		adjacencyList = new LinkedList[numNodes + 1];
		for (int i = 0; i < numNodes + 1; i++) {
			adjacencyList[i] = new  LinkedList<Edge>();
		}

		for (int i = 0; i < edgeIntegerArray.length; i += 2) {
			adjacencyList[edgeIntegerArray[i]].add(new Edge(edgeIntegerArray[i], edgeIntegerArray[i + 1]));
		}
		printTestData();
	}

	public void putEdge(int i, int j) {
		adjacencyList[j].add(new Edge(i, j));
	}

	public void putEdge(Edge e) {
		putEdge(e.vertex1, e.vertex2);
	}


	public void removeEdge(int i, int j) {
		int count = 0;
		for(Edge e : adjacencyList[i]) {
			if (e.vertex1 == j) {
				adjacencyList[i].remove(count);
			}
			count++;
		}
	}

	public void removeEdge(Edge e) {
		removeEdge(e.vertex1, e.vertex2);
	}

	public boolean existsEdge(int i, int j) {
		for(Edge e: adjacencyList[i]) {
			if (e.vertex1 == j) {
				return true;
			}
		}
		for(Edge e: adjacencyList[j]) {
			if (e.vertex1 == i) {
				return true;
			}
		}
		return false;
	}

	public Node[] adjacentVertices(int i) {
		Node[] nodeArray = new Node[0];
		for (Edge e: adjacencyList[i]) {
			nodeArray = addElement(nodeArray, new Node(e.vertex2));
		}
		return nodeArray;
	}

	public int inDegree(int i) {
		int count = 0;
		for (int j = 0; j < adjacencyList.length; j++) {
			Iterator<Edge> it = adjacencyList[j].iterator();
			while (it.hasNext()) {
				if(it.next().vertex2 == i) {
					count++;
				}
			}
		}
		return count;
	}

	public int outDegree(int i) {
		return adjacencyList[i].size();
	}

	public boolean areAdjacent(int i, int j) {
		if(existsEdge(i, j)) {
			return true;
		}
		return false;
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
		System.out.println("The Adjacency List Directed Graph is: ");
		for (int i = 0; i < adjacencyList.length; i++) {
			Iterator<Edge> it = adjacencyList[i].iterator();
			while (it.hasNext()){
				System.out.println(i + " -> " + it.next().vertex2 + " -> ");
			}
		}

		System.out.println("The sorted array is: ");
		int[] sortedArray = TopologicalSort.sortedArray(this, inDegreeArray());
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
		System.out.println();
	}

}
