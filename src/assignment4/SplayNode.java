package assignment4;

public class SplayNode {
	SplayNode left;
	SplayNode right;
	SplayNode parent;
	int number;
	
	public SplayNode(){
		this(0,null,null,null);
	}
	
	public SplayNode(int num){
		this(num,null,null,null);
	}
	
	public SplayNode(int number, SplayNode left, SplayNode right, SplayNode parent){
		this.number = number;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}
