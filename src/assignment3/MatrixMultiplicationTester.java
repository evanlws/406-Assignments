package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class MatrixMultiplicationTester extends JPanel {
	
	private static final long serialVersionUID = 1L;
	int[] di;
	int n;
	File selectedFile;
	Scanner fileStream;
	private JFileChooser chooseFile;

	public MatrixMultiplicationTester() throws FileNotFoundException {
		chooseFile = new JFileChooser();

		if(chooseFile.showOpenDialog(MatrixMultiplicationTester.this) == JFileChooser.APPROVE_OPTION){
			selectedFile = chooseFile.getSelectedFile();
			fileStream = new Scanner(selectedFile);
			n = Integer.parseInt(fileStream.nextLine());
			di = new int[n];
			String[] diArray = fileStream.nextLine().split("[ ]+");
			di = new int[diArray.length];

			for (int i = 0; i < diArray.length; i++) {
				di[i] = Integer.parseInt(diArray[i]);
			}
			printMatrix(MatrixMultiplication.matrixMultiplicationProblem(n, di));
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
