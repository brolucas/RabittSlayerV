
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
		this.etat=1;
	
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
	public void delJ() {
		this.j = null;
	}
	public void maj() {
		if (this.j != null) {
			this.setSymbJ(this.j);
			this.etat= 1;
		}
		if (this.pnj != null) {
			this.setSymb(this.pnj);
			this.etat=1;
		}
		else {
			this.etat = 0;
		}
		
	}
	public void setSymbJ(Joueur j) {
		this.Symb = j.getSymb();
	}
	public void setSymb(PNJ p) {
		this.Symb = p.getSymb();
	}
	
	
}
