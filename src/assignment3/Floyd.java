package assignment3;

public class Floyd {

	public static int[][] transitiveClosure(int [][] matrix){
		for(int n = 1; n < matrix.length + 1; n++){
			for(int m = 1; m < matrix.length + 1; m++){
				if((n != m) && (matrix[n][m] == 0)){
					matrix[n][m] = Integer.MAX_VALUE;
				}
			}
		}
		for(int k = 1; k < matrix.length + 1; k++){
			for(int i = 1; i < matrix.length + 1; i++){
				for(int j = 1; j < matrix.length + 1; j++ ){
						matrix[i][j] = Math.min(matrix[i][j], (matrix[i][k] + matrix[k][j]));
				}
			}
		}
		
		return matrix;
		//Still need to find shortest path between 2 given nodes
	}
}
