public class ID {
	private String ID;

	public ID(String ID) {
		this.ID = ID;
	}

	public boolean equals(String a) {
		boolean answer = false;
		if (ID.equals(a)) {
			answer = true;
		}
		return answer;
	}
	
	public int hashcode(){
		Integer hashcode = Integer.parseInt(ID);
		Integer a = hashcode.hashCode();
		return a;
	}
	@Override
	public String toString(){
		return ID;
	}
}
