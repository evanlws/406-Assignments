package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import assignment3.AlgorithmType;

public class SplayTreeTester extends JPanel {
	String nodeList;
	String stringArray [];
	int nodeArray [];
	String parameters = "[ ]+";
	
	
	private static final long serialVersionUID = 1L;
	AlgorithmType algorithmType;
	String algorithmStringType;
	
	//File properties
	private File selectedFile;
	private Scanner fileStream;
	private JFileChooser chooseFile;
	
	public SplayTreeTester() throws FileNotFoundException {
		chooseFile = new JFileChooser();
		SplayTree splay = new SplayTree();
		if(chooseFile.showOpenDialog(SplayTreeTester.this) == JFileChooser.APPROVE_OPTION){
			selectedFile = chooseFile.getSelectedFile();
			fileStream = new Scanner(selectedFile);
			nodeList = fileStream.nextLine();
			stringArray = nodeList.split(parameters);
			nodeArray = new int[stringArray.length];
			for(int i = 0; i < stringArray.length; i++){
				nodeArray[i] = Integer.parseInt(stringArray[i]);
			}
			for(int j = 0; j < nodeArray.length; j++){
				splay.insert(nodeArray[j]);
			}
			splay.print();
			
			
		}
	}
	public static void main(String[] args) throws Exception {
		try{
			new SplayTreeTester();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			throw ex;
		}
	}
}

