package assignment3;

public class Warshall {

	public static int[][] transitiveClosure(int [][] theMatrix) {
		int [][] matrix = theMatrix;
		for(int k = 1; k < theMatrix.length; k++) {
			for(int i = 1; i < theMatrix.length; i++) {
				for(int j = 1; j < theMatrix.length; j++) {
					if((matrix [i][k] == 1) && (matrix[k][j] == 1)) {
						matrix[i][j] = 1;
					}
				}
			}
		}
		return matrix;
	}
}
