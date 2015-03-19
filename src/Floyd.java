public class Floyd {

	
	public static int[][] transitiveClosure(Graph graph, int [][] theMatrix){
		int [][] matrix = theMatrix;
		for(int n = 1; n < graph.numNodes + 1; n++){
			for(int m = 1; m < graph.numNodes + 1; n++){
				if((n != m) && (matrix[n][m] == 0)){
				}
			}
		}
		for(int k = 1; k < graph.numNodes + 1; k++){
			for(int i = 1; i < graph.numNodes + 1; i++){
				for(int j = 1; j < graph.numNodes + 1; j++ ){
						matrix[i][j] = Math.min(matrix[i][j], (matrix[i][k] + matrix[k][j]));
				}
			}
		}
		
		return matrix;
		//Still need to find shortest path between 2 given nodes
	}
}
