package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import model.Aldg;
import model.Alwdg;
import model.Alwg;
import model.Amdg;
import model.Amwdg;
import model.Amwg;
import model.GraphTester;
import model.GraphType;

public class WarshallFloydMatrixKnapsackTester extends JPanel {

	private static final long serialVersionUID = 1L;
	AlgorithmType algorithmType;
	String algorithmStringType;
	
	//File properties
	private File selectedFile;
	private Scanner fileStream;
	private JFileChooser chooseFile;
	
	public WarshallFloydMatrixKnapsackTester() throws FileNotFoundException {
		chooseFile = new JFileChooser();
		if(chooseFile.showOpenDialog(WarshallFloydMatrixKnapsackTester.this) == JFileChooser.APPROVE_OPTION){
			selectedFile = chooseFile.getSelectedFile();
			fileStream = new Scanner(selectedFile);
			algorithmStringType = fileStream.nextLine();
			for (AlgorithmType algorithm: AlgorithmType.values()){
				if (algorithmStringType.equals(algorithm.algorithmType())){
					algorithmType = algorithm;
					break;
				}
			}
			numNodes = Integer.parseInt(fileStream.nextLine());
			numEdges = Integer.parseInt(fileStream.nextLine());
			edgesList = fileStream.nextLine();
			
			switch (algorithmType) {
			case Warshall:
				Warshall.transitiveClosure(graph, theMatrix);
				break;
			case Floyd:
				Floyd.transitiveClosure(matrix);
				break;
			case MatrixMultiplication:
				MatrixMultiplication.matrixMultiplicationProblem(n, di);
				break;
			case Knapsack:
				Knapsack.solution(v, w, n, W);
				break;
			default:
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		try{
			new WarshallFloydMatrixKnapsackTester();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			throw ex;
		}
	}

}
