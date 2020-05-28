import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Joueur {
	private String Etat = "En forme";
	private Terrain t;
	private String symb = "J";
	private int PA;
	private int adresse=0;
	private int Force=0;
	private int resistance=0;
	private int Degreaat=18;
	public Equipement equipement[]= new Equipement[2];
	private int[] position = new int[2];
	private ArrayList<PNJ> ennemie ;
	
	public Joueur() {
		equipement[0]= new EpeeSimple();
		equipement[1]= new VetementSimple();
		Scanner sc = new Scanner(System.in);
		while (this.Degreaat != 0) {
			if(this.Degreaat == 18) {
				System.out.println("Vous avez 18 degrés a repartir entre les 3 categories");
			}
			System.out.println("Combien desirez vous en mettre en Force ?");
			int temp = sc.nextInt();
			while (temp  >this.Degreaat) {
				System.out.println("Combien desirez vous en mettre en Force ?");
				temp = sc.nextInt();
			}
			this.Degreaat = this.Degreaat - temp;
			this.Force = this.Force +temp;
			if (this.Degreaat == 0) {
				break;
			}
			System.out.println("Il vous reste " + toString(Degreaat) + " point(s) a attribuer");
			System.out.println("Combien desirez vous en mettre en Adresse ?");
			temp = sc.nextInt();
			while (temp > this.Degreaat ) {
				System.out.println("Combien desirez vous en mettre en Adresse ?");
				temp = sc.nextInt();	
			}
			this.Degreaat = this.Degreaat - temp;
			this.adresse = this.adresse +temp;
			if (this.Degreaat == 0) {
				break;
			}
			System.out.println("Il vous reste " + toString(Degreaat) + " point(s) a attribuer");
			System.out.println("Combien desirez vous en mettre en Résistance ?");
			temp = sc.nextInt();
			while (temp> this.Degreaat) {
				System.out.println("Combien desirez vous en mettre en Résistance ?");
				temp = sc.nextInt();
			}
			this.Degreaat = this.Degreaat - temp;
			this.resistance = this.resistance +temp;
			if (this.Degreaat == 0) {
				break;
			}
			System.out.println("Il vous reste " + toString(Degreaat) + " point(s) a attribuer");
			}
		
		
		PA=5;
		
	}
	public Terrain gett() {
		return this.t;
	}
	public void setT(Terrain t) {
		this.t=t;
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
	public void deplacement() {
		if (this.PA <2 ) {
			System.out.println("PAs assez de Point d'action");
			System.out.println("Vos PA" + this.getPA());
		}
		System.out.println("Taper h ou b ou g ou d");
		Scanner sc = new Scanner(System.in);
		String direction = sc.next();
		int x = this.getPosition()[0];
		int y = this.getPosition()[1];
		if (direction== "h") {
			this.t.tab[x-1][y].setJoueur(this);
			this.t.tab[this.getPosition()[x]][y].delJ();
			this.setPosition(x-1,y);
			this.t.tab[x-1][y].maj();
			
		}
		else if(direction == "b") {
			this.t.tab[x+1][y].setJoueur(this);
			this.t.tab[this.getPosition()[x]][y].delJ();
			this.setPosition(x+1,y);
			this.t.tab[x+1][y].maj();
			
		}
		else if (direction == "g") {
			this.t.tab[x][y-1].setJoueur(this);
			this.t.tab[this.getPosition()[x]][y].delJ();
			this.setPosition(x,y-1);
			this.t.tab[x][y-1].maj();
			
		}
		else if (direction == "d") {
			this.t.tab[x][y+1].setJoueur(this);
			this.t.tab[this.getPosition()[x]][y].delJ();
			this.setPosition(x,y+1);
			this.t.tab[x][y+1].maj();
		}
		System.out.println("Je me deplace" );
		this.PA = this.PA - 2;
		System.out.println("Il vous reste :" + (this.getPA()) +"PA" );
		
	}
	public String toString(int i ) {
		String 	str = "";
		str = str+ i;
		return str;
	}
	public void getStat() {
		System.out.println("Vous avez " + toString(this.Force) +" point(s) en Force !");
		System.out.println("Vous avez " + toString(this.adresse) +" point(s) en Adresse !");
		System.out.println("Vous avez " + toString(this.resistance) +" point(s) en Résistance !");
		
		
	}
	public void equipementListe() {
		System.out.println("Je suis equiper de :");
		for (int i=0 ; i< equipement.length; i++) {
			System.out.println(this.equipement[i].getType());
		}	
	}
	public int Alea(int min , int max) {
		Random random = new Random();
		int nb;
		nb = min+random.nextInt(max-min);
		return nb;
	}
	public int[] Calcul(int i) {
		int tab[]= new int[2];
		int temp = 0;
		while ((i-3)>0) {
			temp= temp+1;
			i = i-3;
		}
		tab[0]=temp;
		tab[1]= i;
		return tab;
		
	}
	public void parcourir() {
		if (ennemie != null) {
			for (int i=0 ; i < this.ennemie.size();i++) {
				System.out.println(i+" pour :");
				this.ennemie.get(i).DonnetonBlaze();
		}
			}
		
	}
	public boolean test() {
		if(ennemie != null) {
			if(this.ennemie.isEmpty()==false) {
				return true;
			}
			
		}
		return false;
	
		}
	
	public void Attaquer() {
			if (this.PA <3) {
				System.out.println("Pas assez de point d'action");
				System.out.println(this.PA);
				return;
			}
			if(this.test()==false) {
				System.out.println("Pas d'ennemie atteignable");
				return;
			}
			else {
				System.out.println("******************************* Phase de Combat ***********************************");
				System.out.println("Liste cible possible :");
				System.out.println("Taper ");
				boolean temp;
				temp=this.test();
				if (temp==true) {
					this.parcourir();
				}
				Scanner sc = new Scanner(System.in);
				int VD = sc.nextInt();
				int[] a =Calcul(this.adresse);
				int[] b = Calcul(this.equipement[0].getManiabilité());
				int[] c = new int[2];
				c[0]= a[0]+b[0];
				c[1]= a[1]+b[1];
				System.out.println(toString(c[0])+" D + "+toString(c[1]));
				int total=0;
				while (c[0]>0) {
					total = total+ Alea(1,6);
					c[0]=c[0]-1;
				}
				total= total+c[1];
				System.out.println(total);
				PNJ soumisattaque;
				soumisattaque = this.ennemie.get(VD);
				System.out.println("Esquive de l'adversaire : " + soumisattaque.getesq());
				if (soumisattaque.getesq() < total) {
					soumisattaque.prendredegat(this);
				}
				else {
					System.out.println("L'ennemie Bloque le coup");
				}
				
				
			}
			System.out.println("***************************FIN DE PHASE DE COMBAT**************************");
			this.PA = this.PA - 3;
		}
	

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int position, int pos) {
		this.position[0]=position;
		this.position[1]=pos;
	}
	public ArrayList<PNJ> getEnnemie(){
		return this.ennemie;
	}
	public void setennemie(ArrayList<PNJ>mechant) {;
		for(int i=0 ; i<mechant.size();i++) {
			this.ennemie.add(mechant.get(i));	
		}
	}
	public void toStringPNJ(PNJ m) {
		System.out.println(m.getnom());
	}
	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
	}
	public int getForce() {
		return this.Force;
	}

	
}
