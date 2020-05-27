import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
	private ArrayList<Joueur> j = new ArrayList<Joueur>();
	private ArrayList<PNJ> Pnj = new ArrayList<PNJ>();
	Terrain T;

	public Jeu(Joueur[]jo,PNJ[]pnj) {
		Terrain t = new Terrain(10);
		this.T= t;
		for (Joueur e:jo) {
			this.j.add(e);
		}
		for (PNJ p:pnj) {
			this.Pnj.add(p);
		}
		
	}
	public void DetectPNJ(Joueur joueur)  {
		int[] temp2 = new int[2];
		temp2[0] = joueur.getPosition()[0];
		temp2[1]= joueur.getPosition()[1];
		int i;
		int j;
		i = temp2[0];
		j = temp2[1];
		int compteur=0;
		while ( compteur <1) {
			if ( this.T.tab[i-1][j].getetat()==1) {
				joueur.getEnnemie().add(this.T.tab[i-1][j].getpnj());
			}
				if ( this.T.tab[i-1][j].getetat()==1)  {
					joueur.getEnnemie().add(this.T.tab[i][j-1].getpnj());
				}
				if ( this.T.tab[i-1][j].getetat()==1) {
					joueur.getEnnemie().add(this.T.tab[i][j+1].getpnj());
					
				}
				
			if ( this.T.tab[i-1][j].getetat()==1) {
				joueur.getEnnemie().add(this.T.tab[i+1][j].getpnj());
			}
			
			compteur=compteur+1;
			

		}
		
		
	}
	public int Alea(int min , int max) {
		Random random = new Random();
		int nb;
		nb = min+random.nextInt(max-min);
		return nb;
	}
	public void TourdeJeuJoueur(Joueur j1) {
		j1.getStat();
		j1.equipementListe();
		System.out.println("Vos point d'action : "+ j1.getPA());
		System.out.println("Que souhaitez vous faire ?");
		System.out.println("Taper :");
		System.out.println("1 pour attaquer");
		System.out.println("2 pour se deplacer");
		System.out.println("3 pour gerer l'inventaire");
		System.out.println("4 pour se reposer");
		System.out.println("5 pour Sauvegarder la Partie");
		System.out.println("===============================================================");
		
		Scanner sc = new Scanner(System.in);
		int temp =sc.nextInt();
		if (temp == 1) {
			this.DetectPNJ(j1);
			j1.Attaquer();
		}
	}

	public static void main(String[] args) {
		int test ;
		Joueur j1 = new Joueur();
		test = j1.Alea(1,6);
		PNJ[] temp = new PNJ[test];
		for (int i =0; i < test; i++) {
			PNJ Lapin =  new LapinBasiqueAvecUnCouteau();
			Lapin.setnom("Lapin"+i);
			temp[i] =  Lapin; 
		}
		Joueur[] temp2 = new Joueur[1];
		temp2[0]=j1;
		Jeu jeu =  new Jeu(temp2,temp);
		while (j1.getEtat() == "En forme") {
			jeu.T.placerJoueur(j1);
			for (PNJ p:jeu.Pnj) {
				jeu.T.placerPNJ(p);
				
			}
			jeu.T.affiche();
			jeu.TourdeJeuJoueur(j1);
		
		}
		

	}

}
