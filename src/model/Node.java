package model;
public class Node {

	public int name;
	
	public Node(int name) {
		this.name = name;
	}
	
	public String description() {
		return "Node:  " + this.name;
	}

}
