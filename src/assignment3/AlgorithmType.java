package assignment3;

public enum AlgorithmType {
	Warshall("Warshall"), Floyd("Floyd"), MatrixMultiplication("MatrixMultiplication"), Knapsack("Knapsack");
	private String value;
	private AlgorithmType(String value) {
		this.value = value;
	}
	public String algorithmType(){
		return this.value;
	}
}
