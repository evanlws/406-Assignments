package assignment3;

import java.util.Arrays;

public class Knapsack {
	
	protected static int [][] M;
	protected static int [][] sub;
	protected static int []weights;
	
	public static int[][] solution(int [] v,int [] w, int n, int W){
		
		M = new int[n + 1][W + 1];
		sub = new int[n + 1][W + 1];
		weights = w;
		for(int j = 0; j < W; j++){
			M[0][j] = 0;
		}
		for(int i = 1; i <= n ; i++){
			for(int j = 1; j <= W ; j++){
				if((j - w[i]) >= 0){
					if(M[i-1][j] > (v[i] + M[i-1][j - w[i]] )){
						M[i][j] = M[i-1][j];
						sub[i][j] = -1;
					}
					else{
						M[i][j] = (v[i] + M[i-1][j - w[i]] );
						sub[i][j] = 1;
					}
				}
				else{
					M[i][j] = M[i-1][j];
				}
			}
		}
		return M;
		
		
	}
	
	public static void subset(int [][]solutionMatrix, int []weights){
		int[] subset = new int[weights.length];
		int numItems = 0;
		int i = solutionMatrix.length - 1;
			for (int j = solutionMatrix[0].length - 1; j >= 0 && i > 0;i--) {
				if (solutionMatrix[i][j] != solutionMatrix[i-1][j]) {
					subset[numItems] = i;
					j -= weights[i-1];
					numItems++;
				}
			}
		int [] optimal = Arrays.copyOfRange(subset, 0, numItems);
		System.out.print("the optimal subset is: { ");
		for(int m = 0; m < optimal.length; m++){
			System.out.print(optimal[m] + " , ");
		}
		System.out.println("} ");
	}

}