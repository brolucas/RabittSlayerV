import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
@Entity
public class Jeu implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	private Joueur j;
	private ArrayList<PNJ> Pnj = new ArrayList<PNJ>();
	Terrain T;
	Jeu activegame;
	int chg=1;
	

	

	public Jeu() {
		
	}

	public Jeu(Joueur jo,PNJ[]pnj) {
		Terrain t = new Terrain(10);
		this.T= t;
		for (PNJ p:pnj) {
			this.Pnj.add(p);
		}
		this.j = jo;
		jo.setT(t);
		
	}
	public void etagesup() {
		int x =this.j.Alea(2, 6);
		PNJ[] Pnj = new PNJ[x];
		for (int i =0; i < x; i++) {
			PNJ Lapin =  new LapinBasiqueAvecUnCouteau();
			Lapin.setnom("Lapin"+i);
			Pnj[i] =  Lapin; 
		}
		this.activegame =  new Jeu(this.j,Pnj);
	}
	
	public int Alea(int min , int max) {
		Random random = new Random();
		int nb;
		nb = min+random.nextInt(max-min);
		return nb;
	}
	public void TourdeJeuMechant() {
		for (PNJ p:this.Pnj) {
			int posx = p.getPosition()[0];
			int posy = p.getPosition()[1];
			if (posy >=5 && this.T.tab[posx][posy+1].getetat()==0) {
				this.T.tab[posx][posy].del();
				this.T.tab[posx][posy+1].setetat();
				this.T.tab[posx][posy+1].setpnj(p);;
			}
			else  {
				if (this.T.tab[posx][posy-1].getetat()!=0 ) {
					return;
				}
				this.T.tab[posx][posy].del();
				this.T.tab[posx][posy-1].setetat();
				this.T.tab[posx][posy-1].setpnj(p);;
			}
		}
	}
	public void TourdeJeuJoueur(Joueur j1) {
	
		System.out.println(j1.getNom());
		j1.getStat();
		j1.equipementListe();
		j1.parcourirE();
		int PosX = j1.getPosition()[0];
		int posY = j1.getPosition()[1];
		System.out.println("Vos point d'action : "+ j1.getPA());
		System.out.println("Que souhaitez vous faire ?");
		System.out.println("Taper :");
		System.out.println("1 pour attaquer");
		System.out.println("2 pour se deplacer");
		System.out.println("3 pour gerer l'inventaire");
		System.out.println("4 pour se reposer");
		System.out.println("5 pour Sauvegarder la Partie");
		
		if (j1.getPosition()[0]== 1 && j1.getPosition()[1]==8) {
			System.out.println("6 pour Prendre l'escalier");
		}
		System.out.println("7 pour Quitter sans sauvegarder");
		if (this.T.tab[PosX][posY].haveequi() == true ) {
			System.out.println("10 Rammasser equipement");
		}
		System.out.println("===============================================================");
		
		Scanner sc = new Scanner(System.in);
		int temp =sc.nextInt();
		while (temp > 6 || temp <0) {
			temp = sc.nextInt();	
		}
		if (temp == 1) {
			if (j1.getPA() <3) {
				System.out.println("Pas assez de point d'action");
				System.out.println(j1.getPA());
				return;
			}
			j1.parcourir2();
			boolean temp1 = j1.gete().isEmpty();
			if (temp1== true ) {
				System.out.println("Pas de cible disponible");
				return;
			}
			System.out.println("Liste cible possible :");
			System.out.println("Taper ");
			j1.parcourir();
			int VD;
			Scanner sc2 = new Scanner(System.in);
			VD = sc2.nextInt();
			while (VD  > j1.gete().size()|| VD < 0)  {
				VD = sc2.nextInt();
				
			}
			PNJ enemiecible ;
			enemiecible = j1.gete().get(VD);
			System.out.println("******************************* Phase de Combat ***********************************");
			while (j1.isMort() != true) {
				if(enemiecible.getMort()== true) {
					this.Pnj.remove(enemiecible);
					break;
				}
				this.activegame.BattlePhase(j1,enemiecible);
			}
			if (j1.isMort()== true) {
				System.out.println("Vous êtes Mort");
			}
			else {
				System.out.println("Vous avez gagner le combat");
				System.out.println("*******************************Fin  De Phase de Combat ***********************************");
				System.out.println("Votre niveau de Blessure :"  + j1.getnivbless());
			}
			j1.gete().clear();
		}
		else if (temp==2) {
			System.out.println(" Taper 1 pour monter, 2 pour descendre , 3 pour aller a droite et 4 pour aller a gauche ");
			
			Scanner sc2 = new Scanner(System.in);
			int temp2 =sc.nextInt();
			if (temp2 == 1) {
				if (j1.gett().deplacementpossH(j1)== true) {
					j1.deplacementh();
				}
				else {
					System.out.println("deplacement impossible");
				}
				
			}
				if (temp2 == 2) {
				if (j1.gett().deplacementpossB(j1)== true) {
					j1.deplacementb();
				}
				else {
					System.out.println("deplacement impossible");
				}
		}
				if(temp2==3) {
				if(j1.gett().deplacementpossD(j1)== true) {
					j1.deplacementd();
				}
				else {
					System.out.println("deplacement impossible");
				}
			}
				if(temp2==4) {
				if (j1.gett().deplacementpossG(j1)== true) {
					j1.deplacementg();
				}
				else {
					System.out.println("deplacement impossible");
				}
			}
			
	}
		else if(temp==3) {
			//a implementer
		}
		else if(temp==4) {
			j1.setPA(j1.getPA()+3);
		}
		else if(temp==5) {
			this.Sauvegarder();
		}
		else if(temp==6 && j1.getPosition()[0]==1 && j1.getPosition()[1]==8) {
				
				this.chg=0;
				
			
					
				}
		else if (temp==7) {
			this.activegame.quitter();
			
		}
		
	
		else if (temp==10 ) {
			j1.sac.add(j1.gett().tab[PosX][posY].getequip());
		}
	}
	private void BattlePhase(Joueur j, PNJ p) {
		int[] a =j.Calcul(j.getAdresse());
		int[] b = j.Calcul(j.equipement[1].getEncombrement());
		int[] c = new int[2];
		c[0]= a[0]+b[0];
		c[1]= a[1]+b[1];
		int total=0;
		while (c[0]>0) {
			total = total+ Alea(1,6);
			c[0]=c[0]-1;
		}
		total= total+c[1];
		if(total> p.ini) {
			System.out.println("Vous attaquer en premier ");
			j.Attaquer(p);
			p.Attaquer(j);
			
		}
		else {
			System.out.println("L'ennemie est plus rapide ");
			p.Attaquer(j);
			j.Attaquer(p);
		}
		
	}

	
		
			
			
			
			

		
		

	
	public void Sauvegarder() {	
		//em.getTransaction().begin();
		//em.persist(this.activegame);
		//em.getTransaction().commit();
		try {
			FileOutputStream fos = new FileOutputStream("sauv.txt");
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(this.activegame);
			fos.close();
			os.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Partie Sauvegardée");
		System.out.println("Voulez vous quitter la partie ?");
		System.out.println("Taper 0 pour oui et 1 pour non");
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		while (a != 0 && a !=1) {
			a= sc .nextInt();
		}
		if (a ==0) {
			//em.close();
			//emf.close();
			System.exit(0);
			
		}
	}
	
	
	public Jeu charger() {
		try {
			FileInputStream fis = new FileInputStream("sauv.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Jeu jeu = (Jeu) ois.readObject();
			ois.close();
			fis.close();

			return jeu;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public Jeu creerPartie() {
		int test ;
		Joueur j1 = new Joueur();
		test = j1.Alea(1,6);
		PNJ[] Pnj = new PNJ[test];
		for (int i =0; i < test; i++) {
			PNJ Lapin =  new LapinBasiqueAvecUnCouteau();
			Lapin.setnom("Lapin"+i);
			Pnj[i] =  Lapin; 
		}
		Jeu jeu2 =  new Jeu(j1,Pnj);
		return jeu2;

}

	public Joueur getJ() {
		return j;
	}

	public void setJ(Joueur j) {
		this.j = j;
	}
	public ArrayList<PNJ> getp(){
		return this.Pnj;
	}


	public void quitter() {
		System.exit(0);
		
	}
	public void maj(Jeu jeu) {
		this.activegame= jeu;
	}
	public static void main(String[] args) {
		
		System.out.println("Souhaitez vous charger une partie");
		System.out.println("Taper 0 pour oui et 1 pour non");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		while (a != 0 && a != 1) {
			a = sc.nextInt();
		}
		Jeu jeu = new Jeu();
		if (a==0) {
			try {
				FileInputStream fis = new FileInputStream("sauv.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				jeu = (Jeu) ois.readObject();
				ois.close();
				fis.close();
				jeu.activegame = jeu;
				
				
			}catch(Exception e) {
				e.printStackTrace();
				}
		}
		else {
			int test ;
			Joueur j1 = new Joueur();
			test = j1.Alea(1,6);
			PNJ[] Pnj = new PNJ[test];
			for (int i =0; i < test; i++) {
				PNJ Lapin =  new LapinBasiqueAvecUnCouteau();
				Lapin.setnom("Lapin"+i);
				Pnj[i] =  Lapin; 
			}
			jeu =  new Jeu(j1,Pnj);
				jeu.T.placerJoueur(j1);
				for (PNJ p:jeu.getp()) {
					jeu.T.placerPNJ(p);
					
				}
				PNJ Boss = new Boss();
				jeu.T.placerPNJ(Boss);
				jeu.activegame = jeu;
			}
		
		while (true) {
		
			if (jeu.chg==0) {
				int test = jeu.j.Alea(1,6);
				PNJ[] Pnj = new PNJ[test];
				for (int i =0; i < test; i++) {
					PNJ Lapin =  new LapinBasiqueAvecUnCouteau();
					Lapin.setnom("Lapin"+i);
					Pnj[i] =  Lapin; 
				}
				
				jeu = new Jeu(jeu.j,Pnj);
				jeu.T.placerJoueur(jeu.j);
				for (PNJ p:jeu.getp()) {
					jeu.T.placerPNJ(p);
					
				}
				jeu.activegame = jeu;
				PNJ Boss = new Boss();
				jeu.T.placerPNJ(Boss);
				
			}
			jeu.chg=1;
			jeu.T.affiche();
			jeu.TourdeJeuJoueur(jeu.j);
			jeu.T.affiche();
			jeu.TourdeJeuMechant();
			jeu.T.affiche();
		
		}
	}
}

