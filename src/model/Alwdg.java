package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import assignment2.KruskalsMST;
import assignment2.TopologicalSort;

public class Alwdg extends Graph{

	LinkedList<Edge>[] adjacencyList;

	@SuppressWarnings("unchecked")
	public Alwdg(int numNodes, int numEdges, String edgesList) {
		super(numNodes, numEdges, edgesList);
		adjacencyList = new LinkedList[numNodes + 1];
		for (int i = 0; i < numNodes + 1; i++) {
			adjacencyList[i] = new  LinkedList<Edge>();
		}

		for (int i = 0; i < edgeIntegerArray.length; i += 3) {
			adjacencyList[edgeIntegerArray[i]].add(new Edge(edgeIntegerArray[i], edgeIntegerArray[i + 1], edgeIntegerArray[i + 2]));
		}
		printTestData();
	}

	public void putEdge(int i, int j, int w) {
		adjacencyList[i].add(new Edge(i, j, w));
	}
	
	public void putEdge(Edge e) {
		putEdge(e.vertex1, e.vertex2, e.weight);
	}

	public void putEdge(int i, int j) {
		System.out.println("Please enter a weight");
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
			if (e.vertex2 == j) {
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
	
	public Queue<Edge> getPriorityQueue() {
		PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<Edge>(numEdges, Edge.weightComparator);
		for (int i = 0; i < edgeIntegerArray.length; i += 3) {
			edgePriorityQueue.offer(new Edge(edgeIntegerArray[i], edgeIntegerArray[i + 1], edgeIntegerArray[i + 2]));
		}
		return edgePriorityQueue;
	}

	public void printTestData() {
		
		//Print statements
		System.out.println("The Adjacency List Weighted Directed Graph is: ");
		for (int i = 0; i < adjacencyList.length; i++) {
			Iterator<Edge> it = adjacencyList[i].iterator();
			while (it.hasNext()){
				Edge e = it.next();
				System.out.println(i + " -> " + e.vertex2 + " , " + e.weight + " -> ");
			}
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
