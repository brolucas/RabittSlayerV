
public abstract class PNJ {
	String nom ; 
	String etat = "En forme";
	String symb;
	int ini ;
	int att;
	int esq;
	int def;
	int deg;
	
	public String getnom() { return this.nom; }
	protected void setnom(String type) {this.nom = type;}
	public String getSymb() {
		return symb;
	}
	public void setSymb(String symb) {
		this.symb = symb;
	}
	public void deplacement(int nbr) {
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getini() { return this.ini; }
	protected void setini(int type) {this.ini = type;}
	
	public int getatt() { return this.att; }
	protected void setatt(int type) {this.att = type;}
	
	public int getesq() { return this.esq; }
	protected void setesq(int type) {this.esq = type;}
	
	public int getdef() { return this.def; }
	protected void setdef(int type) {this.def = type;}
	
	public int getdeg() { return this.deg; }
	protected void setdeg(int type) {this.deg = type;}
}
