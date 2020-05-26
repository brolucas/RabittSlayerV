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
		int a =j.Alea(1, 9);
		int b = j.Alea(1,9);
		j.setPosition(a, b);
		this.tab[a][b].setJoueur(j);
		j.setT(this);
	}
	public void placerPNJ(PNJ j) {
		int a =j.Alea(1,9);
		int b = j.Alea(1,9);
		j.setPosition(a, b);
		this.tab[a][b].setpnj(j);
	}
	public void DetectPNJ() {
		Joueur P;
		P = this.j;
		int[] temp2 = new int[2];
		temp2[0] = P.getPosition()[0];
		temp2[1]= P.getPosition()[1];
		int i;
		int j;
		i = temp2[0];
		j = temp2[1];
		ArrayList<PNJ> myList = new ArrayList<PNJ>() ;
		int compteur=0;
		while ( compteur <1) {
			if (this.tab[i-1][j].havepnj() == true) {
				myList.add(tab[i-1][j].getpnj());
			}
				if (this.tab[i][j-1].havepnj() == true)  {
					myList.add(tab[i][j-1].getpnj());
				}
				if (this.tab[i][j+1].havepnj() == true ) {
					myList.add(tab[i][j+1].getpnj());
					
				}
				
			if (this.tab[i+1][j].havepnj() == true ) {
				myList.add(tab[i+1][j].getpnj());
			}
			
			compteur=compteur+1;
			

		}
		P.setennemie(myList);
		
	}
	public Joueur getJ() {
		return this.j;
	}
}
