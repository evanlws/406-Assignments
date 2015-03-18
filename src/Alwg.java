import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class Alwg extends Graph{

	LinkedList<Edge>[] adjacencyList;

	@SuppressWarnings("unchecked")
	public Alwg(int numNodes, int numEdges, String edgesList) {
		super(numNodes, numEdges, edgesList);
		adjacencyList = new LinkedList[numNodes + 1];
		for (int i = 0; i < numNodes + 1; i++) {
			adjacencyList[i] = new  LinkedList<Edge>();
		}

		for (int i = 0; i < edgeIntegerArray.length; i += 3) {
			adjacencyList[edgeIntegerArray[i + 1]].add(new Edge(edgeIntegerArray[i], edgeIntegerArray[i + 1], edgeIntegerArray[i + 2]));
			adjacencyList[edgeIntegerArray[i]].add(new Edge(edgeIntegerArray[i + 1], edgeIntegerArray[i], edgeIntegerArray[i + 2]));
		}
		printTestData();
	}

	protected void putEdge(int i, int j, int w) {
		adjacencyList[i].add(new Edge(i, j, w));
		adjacencyList[j].add(new Edge(j, i, w));
	}

	protected void putEdge(int i, int j) {
		System.out.println("Please enter a weight");
	}

	protected void putEdge(Edge e) {
		putEdge(e.vertex1, e.vertex2, e.weight);
	}

	protected void removeEdge(int i, int j) {
		Iterator<Edge> iter = adjacencyList[j].iterator();
		while (iter.hasNext()) {
			Edge e = iter.next();
			if (e.vertex1 == i) {
				adjacencyList[j].remove();
			}
		}
		Iterator<Edge> iter2 = adjacencyList[i].iterator();
		while (iter2.hasNext()) {
			Edge e = iter2.next();
			if (e.vertex1 == j) {
				adjacencyList[i].remove();
			}
		}
	}

	protected void removeEdge(Edge e) {
		removeEdge(e.vertex1, e.vertex2);
	}

	protected boolean existsEdge(int i, int j) {
		for(Edge e: adjacencyList[j]) {
			if (e.vertex1 == i) {
				return true;
			}
		}
		for(Edge e: adjacencyList[i]) {
			if (e.vertex1 == j) {
				return true;
			}
		}
		return false;
	}

	protected Node[] adjacentVertices(int i) {
		Node[] nodeArray = new Node[0];
		for (Edge e: adjacencyList[i]) {
			nodeArray = addElement(nodeArray, new Node(e.vertex2));
		}
		return nodeArray;
	}

	protected int outDegree(int i) {
		return 0;
	}

	protected int inDegree(int i) {
		return 0;
	}
	
	protected int degree(int i) {
		int count = 0;
		for (int j = 0; j < adjacencyList.length; j++) {
			Iterator<Edge> it = adjacencyList[j].iterator();
			while(it.hasNext()) {
				if(it.next().vertex1 == 1) {
					count++;
				}
			}
		}
		return count + adjacencyList[i].size();
	}

	protected boolean areAdjacent(int i, int j) {
		if(existsEdge(i, j)) {
			return true;
		}
		return false;
	}

	protected int[] inDegreeArray() {
		int [] array = new int[numNodes + 1];
		for (int i = 1; i < numNodes + 1; i++) {
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

		//Print statements
		System.out.println("The Adjacency List Weighted Graph is:");
		for (int i = 0; i < adjacencyList.length; i++) {
			Iterator<Edge> it = adjacencyList[i].iterator();
			while (it.hasNext()){
				Edge e = it.next();
				System.out.println(i + " -> " + e.vertex1 + " , " + e.weight + " -> ");
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
