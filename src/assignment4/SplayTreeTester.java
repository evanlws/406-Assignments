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
			System.out.println();
			SplayNode two = splay.findNode(2);
			System.out.println("rank of two before inserting 6: " + splay.rank(two));
			System.out.println("size of two before inserting 6: " + splay.size(two));
			splay.insert(6);
			two = splay.findNode(2);
			System.out.println("rank of two after inserting 6: " + splay.rank(two));
			System.out.println("size of two after inserting 6: " + splay.size(two));
			System.out.println("Attempt deletion of 6: ");
			splay.remove(6);
			
			
			
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

