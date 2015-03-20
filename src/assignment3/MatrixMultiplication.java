package assignment3;

public class MatrixMultiplication {

	int n;
	
	public MatrixMultiplication(int n){
		this.n = n;
		int j;
		int [][] N = new int[n][n];
		
		for(int i = 0; i < (n - 1); i++){
			N[i][i] = 0;
		}
		for(int b = 1; b < (n-1); b++){
			for(int i = 0; i < (n-b-1); i++){
				j = i + b;
				for(int k = i; k < (j-1); k++){
					// Unknown 
				}
			}
		}
	}

}

