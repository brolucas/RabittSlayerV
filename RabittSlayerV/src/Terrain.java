import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	public void deplacementJ(Joueur j) {
		if (j.getPA() <2 ) {
			System.out.println("PAs assez de Point d'action");
			System.out.println("Vos PA" + j.getPA());
		}
		System.out.println("Taper h ou b ou g ou d");
		Scanner sc = new Scanner(System.in);
		String direction = sc.next();
		int x = j.getPosition()[0];
		int y = j.getPosition()[1];
		if (direction== "h") {
			this.tab[x-1][y].setJoueur(j);
			this.tab[j.getPosition()[x]][y].delJ();
			j.setPosition(x-1,y);
			this.tab[x-1][y].setSymbJ(j);
			
		}
		else if(direction == "b") {
			this.tab[x+1][y].setJoueur(j);
			this.tab[j.getPosition()[x]][y].delJ();
			j.setPosition(x+1,y);
			this.tab[x+1][y].setSymbJ(j);;
			
		}
		else if (direction == "g") {
			this.tab[x][y-1].setJoueur(j);
			this.tab[j.getPosition()[x]][y].delJ();
			j.setPosition(x,y-1);
			this.tab[x][y-1].setSymbJ(j);;
			
		}
		else if (direction == "d") {
			this.tab[x][y+1].setJoueur(j);
			this.tab[j.getPosition()[x]][y].delJ();
			j.setPosition(x,y+1);
			this.tab[x][y+1].setSymbJ(j);;
		}
		System.out.println("Je me deplace" );
		j.setPA(j.getPA()-2);
		System.out.println("Il vous reste :" + (j.getPA()) +"PA" );
		
	}
	
	public void placerPNJ(PNJ j) {
		int a =j.Alea(1,9);
		int b = j.Alea(1,9);
		j.setPosition(a, b);
		this.tab[a][b].setpnj(j);
	}
	public Joueur getJ() {
		return this.j;
	}

	
}
