
public class Terrain {
	private Joueur j;
	private int taille;
	public  String tab[][] ;
	
	
	public Terrain(int t) {
		this.taille = t;
		this.tab = new String[t][t];
		for(int i=0; i<this.tab.length; i++)
		{
			for (int j=0;j < tab[i].length; j++) {
				if(i==0 || i== taille-1 || j==0 || j==taille-1) { 
					tab[i][j]= new Element("mur").getsymb();	
				}
				else {
					tab[i][j]= new Element("aupif").getsymb();				
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
	            System.out.print(tab[i][j] + " ");
	         }
	         System.out.println();
	      }
	      System.out.println();
	}

}
