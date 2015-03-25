package assignment3;

import model.Graph;

public class Floyd {

	protected static int [][] matrix;
	protected static int [][] preMatrix;
	
	public static int[][] transitiveClosure(int [][] theMatrix){
		matrix = theMatrix;
		preMatrix = theMatrix;
		for(int n = 1; n < matrix.length; n++){
			for(int m = 1; m < matrix.length; m++){
				if((n != m) && (matrix[n][m] == 0)){
					matrix[n][m] = Integer.MAX_VALUE;
				}
			}
		}
		for(int k = 1; k < matrix.length ; k++){
			for(int i = 1; i < matrix.length ; i++){
				for(int j = 1; j < matrix.length ; j++ ){
					if(!(matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE)){
						if(matrix[i][j] > matrix[i][k] + matrix[k][j]){
							matrix[i][j] = matrix[i][k] + matrix[k][j];
							preMatrix[i][j] = preMatrix[k][j];
						}
					}
				}
			}
		}
		
		
		return matrix;
	}
	public static void printPath(int i, int j){
		if(i != j){
			printPath(i , preMatrix[i][j]);
		}
		System.out.print(j + " --> ");
	}
}
