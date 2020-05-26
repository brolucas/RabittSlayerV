import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Joueur {
	private Terrain t;
	private String symb = "J";
	private int PA;
	private int adresse=0;
	private int Force=0;
	private int resistance=0;
	private int Degreaat=18;
	public Equipement equipement[]= new Equipement[2];
	private int[] position = new int[2];
	private ArrayList<PNJ> ennemie = new ArrayList<PNJ>();
	
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
	public void deplacement(int nbr) {
		System.out.println("Je me deplace" );
		System.out.println("Il vous reste :" + (this.getPA()-nbr) +"PA" );
		
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
		int i =0;
		for (PNJ e:ennemie) {
			System.out.println(i+" pour :");
			toStringPNJ(e);
			
		}
	}
	public void Attaquer() {
		this.DetectPNJ();
		if (this.ennemie.isEmpty() ) {
			System.out.println("Pas d'ennemie atteignable");
			return;
		}
		else {
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
			System.out.println("Liste cible possible :");
			System.out.println("Taper ");
			this.parcourir();
			Scanner sc = new Scanner(System.in);
			int VD = sc.nextInt();
			this.ennemie.get(VD);
		}
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
	public void setennemie(ArrayList<PNJ>mechant) {
		ennemie = new ArrayList<PNJ>();
		for(PNJ e:mechant) {
			this.ennemie.add(e);	
		}
	}
	public void toStringPNJ(PNJ m) {
		System.out.println(m.getnom());
	}
	public void DetectPNJ()  {
		int[] temp2 = new int[2];
		temp2[0] = this.getPosition()[0];
		temp2[1]= this.getPosition()[1];
		int i;
		int j;
		i = temp2[0];
		j = temp2[1];
		ArrayList<PNJ> myList = new ArrayList<PNJ>() ;
		int compteur=0;
		while ( compteur <1) {
			if ( this.t.tab[i-1][j].havepnj() == true) {
				myList.add(this.t.tab[i-1][j].getpnj());
			}
				if (this.t.tab[i][j-1].havepnj() == true)  {
					myList.add(this.t.tab[i][j-1].getpnj());
				}
				if (this.t.tab[i][j+1].havepnj() == true ) {
					myList.add(this.t.tab[i][j+1].getpnj());
					
				}
				
			if (this.t.tab[i+1][j].havepnj() == true ) {
				myList.add(this.t.tab[i+1][j].getpnj());
			}
			
			compteur=compteur+1;
			

		}
		this.setennemie(myList);
		
	}

	
}
