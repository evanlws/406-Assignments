public enum GraphType {
	ALWDG("ALWDG"), AMWDG("AMWDG"), ALDG("ALDG"), AMDG("AMDG"), ALWG("ALWG"), AMWG("AMWG");
	private String value;
	private GraphType(String value) {
		this.value = value;
	}
	public String graphType(){
		return this.value;
	}
}; 

