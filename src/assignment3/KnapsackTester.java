package assignment3;
/*
 * 
 * Each item should be placed on its own line
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class KnapsackTester extends JPanel {

	private static final long serialVersionUID = 1L;
	//Knapsack properties
	int[] v  = new int[5];
	int[] w = new int[5];
	int n;
	int W;
		
	//File properties
	File selectedFile;
	Scanner fileStream;
	private JFileChooser chooseFile;

	public KnapsackTester() throws FileNotFoundException{
		chooseFile = new JFileChooser();
		if(chooseFile.showOpenDialog(KnapsackTester.this) == JFileChooser.APPROVE_OPTION){
			selectedFile = chooseFile.getSelectedFile();
			fileStream = new Scanner(selectedFile);
			
			n = Integer.parseInt(fileStream.nextLine());
			W = Integer.parseInt(fileStream.nextLine());
			
			//Parse the input data and create the edges and node array
			String[] vArray = fileStream.nextLine().split("[ ]+");
			v = new int[vArray.length]; 
			for (int i = 0; i < vArray.length; i++) {
				v[i] = Integer.parseInt(vArray[i]);
			}
			
			//Parse the input data and create the edges and node array
			String[] wArray = fileStream.nextLine().split("[ ]+");
			w = new int[wArray.length]; 
			for (int i = 0; i < wArray.length; i++) {
				w[i] = Integer.parseInt(wArray[i]);
			}
			
			printMatrix(Knapsack.knapsackSubset(v, w, n, W));
		}
	}

	public static void main(String []args) throws Exception {
		try {
			new KnapsackTester();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			throw ex;
		}
	}
	
	public static void printMatrix(int[][] matrix) {
		System.out.println("The matrix is: ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
