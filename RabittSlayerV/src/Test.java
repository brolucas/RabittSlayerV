
public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur j1 = new Joueur();
		PNJ LapinGarou = new LapinBasiqueAvecUnCouteau();
		//System.out.println(Teddy.getPA());
		//System.out.println(Teddy.getadresse());
		Terrain tester = new Terrain(10);
		//tester.affiche();
		tester.placerJoueur(j1);
		tester.tab[3][3].setpnj(LapinGarou);;
		tester.affiche();
		j1.getStat();
		//j1.Attaquer();
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
