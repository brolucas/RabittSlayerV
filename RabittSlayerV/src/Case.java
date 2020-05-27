
public class Case  {
	PNJ pnj;
	Joueur j;
	String Symb;
	int etat=0;
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
		this.etat=1;
	}
	public void setpnj(PNJ t) {
		this.pnj = t;
		this.Symb = t.getSymb();
		t.setPosition(this.i, this.y);
		this.etat=1;
	}
	public void setJoueur(Joueur t) {
		this.j = t;
		this.Symb = t.getSymb();
		t.setPosition(this.i, this.y);
		this.etat=1;
		
	}
	public PNJ getpnj(){
		return this.pnj;
		
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
	public void setetat(int e) {
		this.etat=e;
		
	}
	public int getetat() {
		return this.etat;
	}
	
	
}
