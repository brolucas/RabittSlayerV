
public class Case  {
	PNJ pnj;
	Joueur j;
	String Symb;
	boolean vide;
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
		this.vide=true;
	}
	public Case(Joueur j, int i, int y) {
		this.Symb = j.getSymb();
		this.i = i;
		this.i = y;
		this.vide = false;
	}
	public Case(PNJ pnj, int i, int y) {
		this.Symb = pnj.getSymb();
		this.i = i;
		this.y = y;
		this.vide = false;
	}
	public void setpnj(PNJ t) {
		this.pnj = t;
		this.Symb = t.getSymb();
		t.setPosition(this.i, this.y);
		this.vide = false;
	}
	public void setJoueur(Joueur t) {
		this.j = t;
		this.Symb = t.getSymb();
		t.setPosition(this.i, this.y);
		this.vide = false;
	}
	public PNJ getpnj(){
		return this.pnj;
		
	}
	public boolean havepnj() {
		if ( vide = true) {
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
