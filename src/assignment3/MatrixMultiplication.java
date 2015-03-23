package assignment3;

import java.util.PriorityQueue;

public class MatrixMultiplication {

	protected static String str = "";
	
	public static int[][] matrixMultiplicationProblem(int n, int [] di) {
		int [][] N = new int[n][n];
		
		for(int i = 0; i < (n - 1); i++){
			N[i][i] = 0;
		}
		for(int b = 1; b < (n-1); b++){
			for(int i = 0; i < (n-b-1); i++){
				int j = i + b;
				PriorityQueue<int[][]> que = new PriorityQueue<int[][]>();
				for(int k = i; k < (j-1); k++){
					int number = N[i][k] + N[k + 1][j] + (di[i]*di[k + 1] * di[j + 1]);
					int [][] kValues = new int [1][2];
					kValues [0][0] = number;
					kValues [0][1] = k;
					que.add(kValues);
				}
				int [][] minimum = que.poll();
				N[i][j] = minimum[0][0];
				N[j][i] = minimum[0][1];
			}
		}
		int firstNumber = N[N.length - 1][0];
		printTheOrder(0,firstNumber);
		printTheOrder(firstNumber + 1, N.length - 1);
		System.out.println("Parentesis matrices: " + str);
		
		return N;
	}
	
	/*protected static Comparator<int[][]> theComparator = new Comparator<int[][]>(){
		public int compare(int[][] obj1, int [][] obj2){
			return (int) (obj1[0][0] - obj2[0][0]);
		}
	};*/
	
	protected static void printTheOrder(int n, int m){
		if(n == m){
			str += "A[" + n + "]";
		}
		
	}

}
