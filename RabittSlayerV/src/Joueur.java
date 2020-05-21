import java.util.Random;
import java.util.Scanner;

public class Joueur extends Characters{
	private String symb = "J";
	private int PA;
	private int adresse=0;
	private int Force=0;
	private int resistance=0;
	private int Degreaat=18;
	public Equipement equipement[]= new Equipement[2];
	
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
	public void Attaquer() {
		System.out.println(Alea(1,6));
	}
	
}
