
public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur j1 = new Joueur();
		Characters LapinGarou = new Characters();
		//System.out.println(Teddy.getPA());
		//System.out.println(Teddy.getadresse());
		Terrain tester = new Terrain(10);
		//tester.affiche();
		tester.tab[4][4]= j1.getSymb();
		tester.tab[3][3]= LapinGarou.getSymb();
		tester.affiche();
		j1.getStat();
		j1.Attaquer();
		//Teddy.deplacement(2);
		 
		
		
		
		/*
		//Simulation d'un tour de Jeu (en cours)
		System.out.println(j1.getEtat());
		j1.equipementListe();
		System.out.println("Vos point d'action : "+ j1.getPA());
		System.out.println("Que souhaitez vous faire ?");
		//j1.deplacement(2);
		
		*/
		

	}

}
