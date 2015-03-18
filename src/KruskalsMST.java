import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

public class KruskalsMST {

	static HashSet<Integer>[] setArray;
	static HashSet<Edge> treeEdges;
	
	@SuppressWarnings("unchecked")
	public static HashSet<Edge> minimumSpanningTree(Queue<Edge> edgeQueue, int numNodes) {

		//Initialize variables and create the set and tree
		setArray = new HashSet[numNodes + 1];
		//makeSet to fill the set with the vertices
		makeSet(numNodes);
		treeEdges = new HashSet<Edge>();
		Edge minimumWeightEdge = null;
		int numEdgesQueue = edgeQueue.size() - 1;
		
		//While T has fewer than (n-1) edges
		while(treeEdges.size() < numEdgesQueue) {
			//Remove minimum weight queue
			minimumWeightEdge = edgeQueue.poll();
			//If they aren't from the same subset
			if(find(minimumWeightEdge.vertex1) != find(minimumWeightEdge.vertex2)) {
				//Add to T
				treeEdges.add(minimumWeightEdge);
				//Union
				union(minimumWeightEdge.vertex1, minimumWeightEdge.vertex2);
			}
		}

		return treeEdges;
	}

	//Make the sets
	private static void makeSet(int j){
		for (int i = 1; i < j + 1; i++){
			setArray[i] = new HashSet<Integer>();
			setArray[i].add(i);
		}
	}
	//Find where the subsets
	private static int find(int x){
		for (int i = 1; i < setArray.length; i++) {
			Iterator<Integer> it = setArray[i].iterator();
			while(it.hasNext()) {
				int value = it.next();
				if (value == x) {
					return i;
				}
			}			
		}
		return 0;
	}
	
	private static void union(int x, int y) {
		setArray[y] = setArray[x];
	}

}