
public class Element {
	private String name ;
	private String symb = "#";
	
	public Element(String n) {
		if (n=="mur") {
		this.name = n;
		this.symb = "#";
		
		}
		else {
			this.name = n ;
			this.symb = " ";}
	}
	public String getname() {
		return this.name;
	}
	public String getsymb() {
		return this.symb;
	}
}
