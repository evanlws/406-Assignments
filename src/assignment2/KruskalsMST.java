package assignment2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

import model.Edge;

public class KruskalsMST {

	static Set<Integer>[] theSet;
	static Set<Edge> tree;
	@SuppressWarnings("unchecked")
	public static Set<Edge> minimumSpanningtree(Queue<Edge> edgeQueue, int numNodes){
		theSet = new HashSet[numNodes + 1];
		for(int i = 1; i < numNodes + 1; i++){
			theSet[i] = new HashSet<Integer>();
			theSet[i].add(i);
		}
		tree = new HashSet<Edge>();
		Edge e = null;
		int numEdge = edgeQueue.size() - 1;
		while(tree.size() < numEdge){
			e = edgeQueue.poll();
			if(find(e.vertex1) != find(e.vertex2)){
				tree.add(e);
				union(e.vertex1, e.vertex2);
			}
		}
		return tree;

	}

	private static int find(int k){
		for(int i = 1; i < theSet.length; i++){
			Iterator<Integer> ite = theSet[i].iterator();
			while(ite.hasNext()){
				if(ite.next() == k){
					return i;
				}
			}

		}
		return 0;
	}

	private static void union(int i, int j){
		theSet[j] = theSet[i];
	}

}