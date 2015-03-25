package assignment3;

public class Warshall {

	public static int[][] transitiveClosure(int [][] theMatrix) {
		int [][] matrix = theMatrix;
		for(int k = 1; k < theMatrix.length + 1; k++) {
			for(int i = 1; i < theMatrix.length + 1; i++) {
				for(int j = 1; j < theMatrix.length + 1; j++) {
					if((matrix [i][k] == 1) && (matrix[k][j] == 1)) {
						matrix[i][j] = 1;
					}
				}
			}
		}
		return matrix;
	}
}
