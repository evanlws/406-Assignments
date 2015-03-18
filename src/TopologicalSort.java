import java.util.Stack;

public class TopologicalSort {
	
	public static int[] sortedArray(Graph graph, int[] inDegreeArray) {
		//Create stack S
		Stack<Integer> S = new Stack<Integer>();
		int[] outputArray = new int[inDegreeArray.length];
		for(int i = 1; i < inDegreeArray.length; i++) {
			if (inDegreeArray[i] == 0) {
				S.push(i);
			}
		}
		int cnt = 1;
		int u;
		while(!S.isEmpty()) {
			u = S.pop();
			outputArray[cnt] = u;
			cnt++;
			Node[] adjacentVerticesArray = graph.adjacentVertices(u);
			for (int j = 0; j < adjacentVerticesArray.length; j++) {
				int node = adjacentVerticesArray[j].name;
				//Reduce inDegree by 1
				inDegreeArray[node] -= 1;
				if (inDegreeArray[node] == 0) {
					S.push(node);
				}
				if(cnt > graph.numNodes) {
					return outputArray;
				}
			}
		}
		return outputArray;
	}
}
