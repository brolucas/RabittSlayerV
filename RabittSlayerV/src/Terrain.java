import java.util.ArrayList;
import java.util.List;

public class Terrain {
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
		int a =j.Alea(this.taille-(this.taille+1), this.taille);
		int b = j.Alea(this.taille-(this.taille+1), this.taille);
		j.setPosition(a, b);
		this.tab[a][b].setJoueur(j);
		j.setT(this);
	}
	public ArrayList<PNJ> DetectPNJ(Joueur P) {
		int[] temp2 = new int[2];
		temp2= P.getPosition();
		int i;
		int j;
		i = temp2[0];
		j = temp2[1];
		ArrayList<PNJ> myList = new ArrayList<PNJ>();
		int compteur=0;
		while ( compteur <= 2) {
			if (this.tab[i][j].getpnj() != null && compteur != 1) {
			myList.add(tab[i][j].getpnj());
			}
			if (compteur ==1) {
				if (this.tab[i][j-1].getpnj() != null) {
					myList.add(tab[i][j-1].getpnj());
				}
				if (this.tab[i][j+1].getpnj() != null) {
					myList.add(tab[i][j+1].getpnj());
					
				}
				
			if (this.tab[i+1][j].pnj != null && compteur !=1) {
				myList.add(tab[i+1][j].getpnj());
			}
			}
			compteur=compteur+1;
			

		}
		return myList;
		
	}
}
