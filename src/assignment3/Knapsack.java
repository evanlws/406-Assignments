package assignment3;

public class Knapsack {

	public Knapsack(int [] v,int [] w, int n, int W){

		int [][] M = new int[n+1][W + 1];
		for(int j = 0; j < W; j++){
			M[0][j] = 0;
		}
		for(int i = 0; i < n ; i++){
			for(int j = 0; j < W ; j++){
				if((j - w[i]) >= 0) {
					M[i][j] = Math.max( M[i-1][j] , (v[i] + M[i-1][j - w[i]] ));
				} else {
					M[i][j] = M[i-1][j];
				}
			}
		}
	}
}
