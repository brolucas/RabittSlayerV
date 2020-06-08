
public class Partie {
	Jeu jeu;
	
	
	
	
	public Partie() {
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
				jeu.activegame = jeu;
			}
	}
}
