/*
 * Evan Lewis
 * Assignment 1
 * Due 2/11/15
 * 
 * Each item should be placed on its own line
 * Line 1 should be one of the following Graph Types:
 * 
 * ALWDG:Adjacency List Weighted Directed Graph
 * AMWDG:Adjacency Matrix Weighted Directed Graph
 * ALDG:Adjacency List Directed Graph
 * AMDG:Adjacency Matrix Directed Graph
 * ALWG:Adjacency List Weighted Graph
 * AMWG:Adjacency Matrix Weighted Graph
 * 
 * Line 2 should be the number of nodes
 * Line 3 should be the number of edges
 * Line 4 should be the list of edges with a space between each number
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class GraphTester extends JPanel {

	private static final long serialVersionUID = 1L;
	//Graph properties
	GraphType graphType;
	String graphStringType;
	int numNodes = 0;
	int numEdges = 0;
	String edgesList;
	
	//File properties
	File selectedFile;
	Scanner fileStream;
	private JFileChooser chooseFile;

	public GraphTester() throws FileNotFoundException{
		chooseFile = new JFileChooser();
		if(chooseFile.showOpenDialog(GraphTester.this) == JFileChooser.APPROVE_OPTION){
			selectedFile = chooseFile.getSelectedFile();
			fileStream = new Scanner(selectedFile);
			graphStringType = fileStream.nextLine();
			for (GraphType graph: GraphType.values()){
				if (graphStringType.equals(graph.graphType())){
					graphType = graph;
					break;
				}
			}
			numNodes = Integer.parseInt(fileStream.nextLine());
			numEdges = Integer.parseInt(fileStream.nextLine());
			edgesList = fileStream.nextLine();
			
			switch (graphType) {
			case ALWDG:
				new Alwdg(numNodes, numEdges, edgesList);
				break;
			case AMWDG:
				new Amwdg(numNodes, numEdges, edgesList);
				break;
			case ALDG:
				new Aldg(numNodes, numEdges, edgesList);
				break;
			case AMDG:
				new Amdg(numNodes, numEdges, edgesList);
				break;
			case ALWG:
				new Alwg(numNodes, numEdges, edgesList);
				break;
			case AMWG:
				new Amwg(numNodes, numEdges, edgesList);
				break;
			default:
				break;
			}
		}
	}

	public static void main(String []args) throws Exception{
		try{
			new GraphTester();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			throw ex;
		}
	}

}
