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
	int numNodes;
	int numEdges;
	String edgesList;
	int numMatrices;
	String dataArray;
	String valueArray;
	String weightArray;
	int numValues;
	int knapsackWeight; 
	
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
			
			switch (algorithmType) {
			case Warshall:
				numNodes = Integer.parseInt(fileStream.nextLine());
				numEdges = Integer.parseInt(fileStream.nextLine());
				edgesList = fileStream.nextLine();
				new Amdg(numNodes, numEdges, edgesList);
				break;
			case Floyd:
				numNodes = Integer.parseInt(fileStream.nextLine());
				numEdges = Integer.parseInt(fileStream.nextLine());
				edgesList = fileStream.nextLine();
				new Amwdg(numNodes, numEdges, edgesList);
				break;
			case MatrixMultiplication:
				numMatrices = Integer.parseInt(fileStream.nextLine());
				dataArray = fileStream.nextLine();
				MatrixMultiplication.matrixMultiplicationProblem(numMatrices, dataArray);
				break;
			case Knapsack:
				valueArray = fileStream.nextLine();
				weightArray = fileStream.nextLine();
				numValues = Integer.parseInt(fileStream.nextLine());
				knapsackWeight = Integer.parseInt(fileStream.nextLine());
				Knapsack.solution(valueArray, weightArray, numValues, knapsackWeight);
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
