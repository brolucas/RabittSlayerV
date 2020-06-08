
import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Entity
public class Terrain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	private Joueur j;
	private int taille;
	public  Case tab[][] ;
	
	
	public Terrain(int t) {
		this.taille = t;
		this.tab = new Case[t][t];
		for(int i=0; i<this.tab.length; i++)
		{
			for (int j=0;j < tab[i].length; j++) {
				if(i==0 || i== taille-1 || j==0 || j==taille-1) { 
					tab[i][j]= new Case("#",i,j);	
				}
				else if (i==1 && j==8) {
					tab[i][j]= new Case("S",i,j);
					tab[i][j].setetat();
				}
				else {
					tab[i][j]= new Case(i,j);				
				}
			}
		}	 
	}
	public int getTaille() {
		return this.taille;
	}
	public void affiche() {
	      for (int i = 0;i < tab.length; i++) {
	         for (int j = 0;j < tab[i].length;j++) {
	            System.out.print(tab[i][j].Symb + " ");
	         }
	         System.out.println();
	      }
	      System.out.println();
	}
	public void placerJoueur(Joueur j) {
		int a;
		int b;
		 a =j.Alea(1, 8);
		 b = j.Alea(1,8);
		j.setPosition(a, b);
		this.tab[a][b].setJoueur(j);
		j.setT(this);
	}
	public void placerPNJ(PNJ j) {
		int a =j.Alea(1,7);
		int b = j.Alea(1,7);
		j.setPosition(a, b);
		this.tab[a][b].setpnj(j);
	}
	public Joueur getJ() {
		return this.j;
	}
	public boolean deplacementpossH(Joueur j) {
		int x = j.getPosition()[0];
		int y = j.getPosition()[1];
		if (j.gett().tab[x-1][y].etat==0) {
			return true;
		}
		else {
			return false;
		}
			
	}
	public boolean deplacementpossB(Joueur j) {
		int x = j.getPosition()[0];
		int y = j.getPosition()[1];
		if (j.gett().tab[x+1][y].etat==0) {
			return true;
		}
		else {
			return false;
		}
			
	}
	public boolean deplacementpossG(Joueur j) {
		int x = j.getPosition()[0];
		int y = j.getPosition()[1];
		if (j.gett().tab[x][y-1].etat==0) {
			return true;
		}
		else {
			return false;
		}
			
	}
	public boolean deplacementpossD(Joueur j) {
		int x = j.getPosition()[0];
		int y = j.getPosition()[1];
		if (j.gett().tab[x][y+1].etat==0) {
			return true;
		}
		else {
			return false;
		}
			
	}
	public void removePNJ(PNJ p) {
		int a =p.getPosition()[0];
		int b =p.getPosition()[1];
		this.tab[a][b].del();
		
	}
}
