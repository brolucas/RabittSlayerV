
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur Teddy = new Joueur();
		//System.out.println(Teddy.getPA());
		//System.out.println(Teddy.getadresse());
		Terrain tester = new Terrain(10);
		tester.affiche();
		tester.tab[4][4]= Teddy.getSymb();
		tester.affiche();
	}

}
