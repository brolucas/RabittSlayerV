
public class Joueur extends Perso{
	private String symb = "J";
	private int PA;

	
	public Joueur() {
		PA=5;
		
	}
	
	public int getPA() {
		return this.PA;
	}
	public void setPA( int nbr) {
		this.PA= nbr;
	}

	public String getSymb() {
		return symb;
	}

	public void setSymb(String symb) {
		this.symb = symb;
	}
	
}
