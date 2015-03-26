package assignment3;

public class MatrixMultiplication {

	protected static String str = "";
	protected static int [][] N;
	protected static int [][] s;

	public static void matrixMultiplicationProblem(int n, String diString){
		N = new int[n][n];
		s = new int[n][n];
		int[] di;

		//Parse the input data and create the edges and node array
		String[] diStringArray = diString.split("[ ]+");
		di = new int [diStringArray.length]; 
		for (int i = 0; i < diStringArray.length; i++) {
			di[i] = Integer.parseInt(diStringArray[i]);
		}

		for(int i = 0; i < (n - 1); i++){
			N[i][i] = 0;
		}
		for(int b = 1; b <= (n-1); b++){
			for(int i = 0; i <= (n-b-1); i++){
				int j = i + b;
				N[i][j] = Integer.MAX_VALUE;
				for(int k = i; k <= (j-1); k++){
					int number = N[i][k] + N[k + 1][j] + (di[i]*di[k + 1] * di[j + 1]);
					if(number <= N[i][j]){
						N[i][j] = number;
						s[i][j] = k;
					}
				}
			}
		}
		System.out.println("The matrix multiplication result is: " + printOptimalParens(0, n - 1));
	}

	protected static String printOptimalParens(int i, int j){
		if(i == j){
			str += "A[" + i + "]";	
		}
		else{
			str += " (";
			printOptimalParens(i, s[i][j]);
			printOptimalParens(s[i][j] + 1, j);
			str += ") ";
		}
		return str;

	}

}
