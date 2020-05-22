
public class Case {
	PNJ pnj;
	Joueur j;
	String Symb;
	int i;
	int y;
	public Case(String t, int i, int y) {
		this.Symb= t;
		this.i = i;
		this.y = y;
		
	}
	public Case(int i, int y) {
		this.Symb = " ";
		this.i = i;
		this.y = y;
	}
	public Case(Joueur j, int i, int y) {
		this.Symb = j.getSymb();
		this.i = i;
		this.i = y;
	}
	public Case(PNJ pnj, int i, int y) {
		this.Symb = pnj.getSymb();
		this.i = i;
		this.y = y;
	}
	public void setpnj(PNJ t) {
		this.pnj = t;
		this.Symb = t.getSymb();
	}
	public void setJoueur(Joueur t) {
		this.j = t;
		this.Symb = t.getSymb();
	}
	public PNJ getpnj() {
		return this.pnj;
		
	}
	public boolean havepnj() {
		if (pnj != null) {
			return true;
		}
		else {return false;}
	}
	public void seti(int val) {
		this.i = val;
	}
	public void sety(int val) {
		this.y = val;
	}
	public int geti() {
		return this.i;
	}
	public int gety() {
		return this.y;
	}
	
	
}
