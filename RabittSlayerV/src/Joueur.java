
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Joueur  implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	/**
	 * 
	 */
	private boolean mort = false;
	private int nivBless =0;
	int Level;
	private String nom;
	private Terrain t;
	private String symb = "J";
	private int PA;
	private int adresse=0;
	private int Force=0;
	private int resistance=0;
	private int Degreaat=18;
	public Equipement equipement[]= new Equipement[2];
	public ArrayList<Equipement> sac = new ArrayList<Equipement>();
	private int[] position = new int[2];
	private ArrayList<Equipement> aproxi = new ArrayList<Equipement>();
	private ArrayList<PNJ> ennemie = new ArrayList<PNJ>();
	private int xp ;
	public Joueur() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Entrer votre nom ");
		String test2 = sc2.next();
		this.setNom(test2);
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
			this.setAdresse(this.getAdresse() +temp);
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
		
		
		PA=30;
		
	}
	public ArrayList<Equipement> getaproxi(){
		return this.aproxi;
	}
	public ArrayList<PNJ> gete(){
		return this.ennemie;
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
	public void deplacementh() {
		if (this.PA <2 ) {
			System.out.println("PAs assez de Point d'action");
			System.out.println("Vos PA" + this.getPA());
			return;
		}
		int x = this.getPosition()[0];
		int y = this.getPosition()[1];
		this.gett().tab[x][y].del();
		this.gett().tab[x][y].setetat();
		this.t.tab[x-1][y].setJoueur(this);
		this.setPosition(x-1, y);
		System.out.println("Je me deplace" );
		this.PA = this.PA - 2;
		System.out.println("Il vous reste :" + (this.getPA()) +"PA" );
		
	}
	public void deplacementb() {
		if (this.PA <2 ) {
			System.out.println("PAs assez de Point d'action");
			System.out.println("Vos PA" + this.getPA());
			return;
		}
		int x = this.getPosition()[0];
		int y = this.getPosition()[1];
		this.gett().tab[x][y].del();
		this.gett().tab[x][y].setetat();
		this.t.tab[x+1][y].setJoueur(this);
		this.setPosition(x+1, y);
		System.out.println("Je me deplace" );
		this.PA = this.PA - 2;
		System.out.println("Il vous reste :" + (this.getPA()) +"PA" );
		
	}
	public void deplacementd() {
		if (this.PA <2 ) {
			System.out.println("PAs assez de Point d'action");
			System.out.println("Vos PA" + this.getPA());
			return;
		}
		int x = this.getPosition()[0];
		int y = this.getPosition()[1];
		this.gett().tab[x][y].del();
		this.gett().tab[x][y].setetat();
		this.t.tab[x][y+1].setJoueur(this);
		this.setPosition(x, y+1);
		System.out.println("Je me deplace" );
		this.PA = this.PA - 2;
		System.out.println("Il vous reste :" + (this.getPA()) +"PA" );
		
	}
	public void deplacementg() {
		if (this.PA <2 ) {
			System.out.println("PAs assez de Point d'action");
			System.out.println("Vos PA" + this.getPA());
			return;
		}
		int x = this.getPosition()[0];
		int y = this.getPosition()[1];
		this.gett().tab[x][y].del();
		this.gett().tab[x][y].setetat();
		this.t.tab[x][y-1].setJoueur(this);
		this.setPosition(x, y-1);
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
		System.out.println("Vous avez " + toString(this.getAdresse()) +" point(s) en Adresse !");
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
	public void parcourir2() {
		int x = this.position[0];
		int y = this.position[1];
		int i =0;
		if (this.t.tab[x-1][y].Symb == "L" || this.t.tab[x-1][y].Symb == "B") {
			this.ennemie.add(this.t.tab[x-1][y].getpnj());
			i++;
		}
		 if (this.t.tab[x+1][y].Symb == "L" || this.t.tab[x+1][y].Symb == "B") {
			this.ennemie.add(this.t.tab[x+1][y].getpnj());
			i++;
		}
		 if  (this.t.tab[x][y+1].Symb == "L" || this.t.tab[x][y+1].Symb == "B") {
			this.ennemie.add(this.t.tab[x][y+1].getpnj());
			i++;
		}
		 if (this.t.tab[x][y-1].Symb == "L"|| this.t.tab[x][y-1].Symb == "B") {
			this.ennemie.add(this.t.tab[x][y-1].getpnj());
			i++;
		}
		
	}
	public void parcourir() {
		int x = this.position[0];
		int y = this.position[1];
		int i =0;
		if (this.t.tab[x-1][y].Symb == "L"|| this.t.tab[x-1][y].Symb == "B") {
			System.out.println(i+ " " +"pour");
			this.t.tab[x-1][y].getpnj().DonnetonBlaze();
			this.ennemie.add(this.t.tab[x-1][y].getpnj());
			i++;
		}
		 if (this.t.tab[x+1][y].Symb == "L"| this.t.tab[x+1][y].Symb == "B") {
			System.out.println(i+ " "+ "pour");
			this.t.tab[x+1][y].getpnj().DonnetonBlaze();
			this.ennemie.add(this.t.tab[x+1][y].getpnj());
			i++;
		}
		 if  (this.t.tab[x][y+1].Symb == "L"|| this.t.tab[x][y+1].Symb == "B") {
			System.out.println(i+ " " +"pour");
			this.t.tab[x][y+1].getpnj().DonnetonBlaze();
			this.ennemie.add(this.t.tab[x][y+1].getpnj());
			i++;
		}
		 if (this.t.tab[x][y-1].Symb == "L"|| this.t.tab[x][y-1].Symb == "B") {
			System.out.println(i+ " "+ "pour");
			this.t.tab[x][y-1].getpnj().DonnetonBlaze();
			this.ennemie.add(this.t.tab[x][y-1].getpnj());
			i++;
		}
		
	}
	public void parcourirE() {
		int x = this.position[0];
		int y = this.position[1];
		int i =0;
		if (this.t.tab[x-1][y].Symb == "E") {
			System.out.println(i+ " " +"pour");
			this.t.tab[x-1][y].getequip().donnetontype();
			this.aproxi.add(this.t.tab[x-1][y].getequip());
			i++;
		}
		 if (this.t.tab[x+1][y].Symb == "E") {
			System.out.println(i+ " "+ "pour");
			this.t.tab[x+1][y].getequip().donnetontype();
			this.aproxi.add(this.t.tab[x+1][y].getequip());
			i++;
		}
		 if  (this.t.tab[x][y+1].Symb == "E") {
			System.out.println(i+ " " +"pour");
			this.t.tab[x][y+1].getequip().donnetontype();
			this.aproxi.add(this.t.tab[x][y+1].getequip());
			i++;
		}
		 if (this.t.tab[x][y-1].Symb == "E") {
			System.out.println(i+ " "+ "pour");
			this.t.tab[x][y-1].getequip().donnetontype();
			this.aproxi.add(this.t.tab[x][y-1].getequip());
			i++;
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
	
	public void Attaquer(PNJ p) {
				
				int[] a =Calcul(this.getAdresse());
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
				System.out.println("total attaque " + total);
				PNJ soumisattaque;
				soumisattaque = p;
				System.out.println("Esquive de l'adversaire : " + soumisattaque.getesq());
				if (soumisattaque.getesq() < total) {
					soumisattaque.prendredegat(this);
					if (soumisattaque.nivBless >= 5) {
						soumisattaque.setMort(true);
						this.t.removePNJ(soumisattaque);
						int temp = this.Alea(0, 100);
						if(temp >= 85) {
							int x = soumisattaque.getPosition()[0];
							int y = soumisattaque.getPosition()[1];
							this.gett().tab[x][y].del();
							Equipement e = new VetementSimple();
							this.t.tab[x][y].setequip(e);
						}
						this.setXp(this.getXp()+5);
						System.out.println("Vous avez Gagner 5 d'experience");
						if (this.getXp() == 10 ) {
							this.LvlUp();
						}
					}
					 
				}
				else {
					System.out.println("L'ennemie esquive  le coup");
				}
				
				
			
			
			
			
		}
	

	private void LvlUp() {
		this.Level = this.Level+1;
		System.out.println("Level up");
		System.out.println("Vous etes niveau : " + this.Level);
		System.out.println("Vous avez 5 points a attribuer ");
		this.Degreaat = 5;
		Scanner sc = new Scanner(System.in);
		while (this.Degreaat != 0) {
			if(this.Degreaat == 5) {
				System.out.println("Vous avez 5 degrés a repartir entre les 3 categories");
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
			this.setAdresse(this.getAdresse() +temp);
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
		
	}
	public int[] getPosition() {
		return position;
	}

	public void setPosition(int position, int pos) {
		this.position[0]=position;
		this.position[1]=pos;
	}

	
	public void toStringPNJ(PNJ m) {
		System.out.println(m.getnom());
	}
	public int getForce() {
		return this.Force;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	public int getAdresse() {
		return adresse;
	}
	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}
	public void prendredegat(PNJ p) {
		int[] a =this.Calcul(this.resistance);
		int[] b = this.Calcul(this.equipement[1].getSolidité());
		int[] c = new int[2];
		c[0]= a[0]+b[0];
		c[1]= a[1]+b[1];
		System.out.println(toString(c[0])+" D + "+toString(c[1]));
		int def=0;
		while (c[0]>0) {
			def = def+ Alea(1,6);
			c[0]=c[0]-1;
		}
		def= def+c[1];
		System.out.println("Total Defence Joueur :");
		System.out.println(def);
		System.out.println("Total attaque PNJ");
		int deg = p.deg;
		System.out.println(deg);
		if (deg < def) {
			System.out.println("Le coup est bloquer");
			return;
		}
		else {
			System.out.println("Vous ne bloqur pas le coup");
			int calc = deg- def;
			int compteur=0;
			while (true) {
				if (calc<3 ) {
					break;
				}
				calc = calc -3;
				compteur = compteur+1;
				this.setnivBless(compteur);
			
		}
			System.out.println("Niveau de blessure :" +this.nivBless);
		}
;
		if (this.nivBless >= 5 ) {
			this.setMort(true);
		}
		}
	private void setnivBless(int nbr) {
		this.nivBless = nbr;
		
	}
	public int getnivbless() {
		
		return this.nivBless;
	}
	public boolean isMort() {
		return mort;
	}
	public void setMort(boolean mort) {
		this.mort = mort;
	}

	
}
