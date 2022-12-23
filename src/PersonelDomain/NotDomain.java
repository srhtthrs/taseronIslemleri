package PersonelDomain;

public class NotDomain {
	int id;
	String not;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNot() {
		return not;
	}
	public void setNot(String not) {
		this.not = not;
	}
	@Override
	public String toString() {
		return "--- "+ not;
	}
	
	

}
