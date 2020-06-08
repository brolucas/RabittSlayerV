import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.*;
@Entity
public abstract class PNJ implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	int nivBless =0;
	String nom ; 
	boolean mort = false;
	String symb;
	int ini ;
	int att;
	int esq;
	int def;
	int deg;
	private int[] position = new int[2];
	
	public int[] getpos() {
		return this.position;
	}
	
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
	public boolean getMort() {
		return mort;
	}
	public void setMort(boolean etat) {
		this.mort = etat;
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
		if (total < temp) {
			System.out.println("Le coup est bloquer");
			return;
		}
		int calc = total- temp;
		int compteur=0;
		while (true) {
			if (calc<3 ) {
				break;
			}
			calc = calc -3;
			compteur = compteur+1;
		}
		this.setnivBless(compteur);
		System.out.println("Niveau de blessure :" +this.nivBless);
		}
		
	
	public void setnivBless(int i) {
		this.nivBless = this.nivBless + i;
		
	}

	public void Attaquer(Joueur j) {
		int[] a =j.Calcul(j.getAdresse());
		int[] b = j.Calcul(j.equipement[1].getEncombrement());
		int[] c = new int[2];
		c[0]= a[0]+b[0];
		c[1]= a[1]+b[1];
		System.out.println(j.toString(c[0])+" D + "+j.toString(c[1]));
		int esq=0;
		while (c[0]>0) {
			esq = esq+ Alea(1,6);
			c[0]=c[0]-1;
		}
		esq= esq+c[1];
		int attaque = this.att;
		if (attaque > esq) {
			System.out.println("Vous êtes touché");
			j.prendredegat(this);
			
		}
		else {
			System.out.println("coup esquivé");
		}
		
	}
}
