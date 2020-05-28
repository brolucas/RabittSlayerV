import java.util.Random;

public abstract class PNJ {
	int nivBless =0;
	String nom ; 
	String etat = "En forme";
	String symb;
	int ini ;
	int att;
	int esq;
	int def;
	int deg;
	private int[] position = new int[2];
	
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
	public int[] getPosition() {
		return position;
	}
	public void setPosition(int posi , int posy) {
		this.position[0]= posi;
		this.position[1]= posy;
	}
	public int Alea(int min , int max) {
		Random random = new Random();
		int nb;
		nb = min+random.nextInt(max-min);
		return nb;
	}
	public void DonnetonBlaze() {
		System.out.println(this.getnom());
	}
	public void prendredegat(Joueur j) {
		int[] a =j.Calcul(j.getForce());
		int[] b = j.Calcul(j.equipement[0].getImpact());
		int[] c = new int[2];
		c[0]= a[0]+b[0];
		c[1]= a[1]+b[1];
		System.out.println(j.toString(c[0])+" D + "+j.toString(c[1]));
		int total=0;
		while (c[0]>0) {
			total = total+ Alea(1,6);
			c[0]=c[0]-1;
		}
		total= total+c[1];
		System.out.println("Total degat Joueur :");
		System.out.println(total);
		System.out.println("Total defence PNJ");
		int temp = this.getdef();
		System.out.println(temp);
		int calc =temp - total;
		int compteur=0;
		while (calc >0) {
			if (calc<3 ) {
				break;
			}
			calc = calc -3;
			compteur = compteur+1;
		}
		this.setnivBless(compteur);
		
	}
	public void setnivBless(int i) {
		this.nivBless = this.nivBless + i;
		
	}
}
