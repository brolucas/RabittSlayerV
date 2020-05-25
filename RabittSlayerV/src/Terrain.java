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
		this.tab[a][b].setJoueur(j);
	}
	public ArrayList<PNJ> DetectPNJ(Joueur P) {
		int[] temp2= P.getPosition();
		int i = temp2[0];
		int j = temp2[1];
		ArrayList<PNJ> myList = new ArrayList<PNJ>();
		int temp =i-1;
		while ( temp<= i+1 ) {
			int compteur=0;
			if (tab[i][j].pnj != null && compteur != 1) {
			myList.add(tab[i][j].getpnj());
			}
			if (compteur ==1) {
				if (tab[i][j-1].pnj != null) {
					myList.add(tab[i][j-1].getpnj());
				}
				if (tab[i][j+1].pnj != null) {
					myList.add(tab[i][j+1].getpnj());
					
				}
				
			if (tab[i+1][j].pnj != null && compteur !=1) {
				myList.add(tab[i+1][j].getpnj());
			}
			}
			compteur=compteur+1;

		}
		return myList;
		
	}
}
