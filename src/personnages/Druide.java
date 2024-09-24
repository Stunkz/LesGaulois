package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion;
	private Random random = new Random();
	private static final int POTION_MOYENNE = 7;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		this.forcePotion = 1;

		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � "
				+ effetPotionMax + ".");
	}

	public void preparerPotion() {
		int potion = random.nextInt(effetPotionMin, effetPotionMax);
		if (potion > POTION_MOYENNE) {
			parler("J'ai pr�par� une super potion de force " + potion);
			this.forcePotion = potion;
		} else {
			parler("Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force " + potion);
			this.forcePotion = potion;
		}
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void booster(Gaulois gaulois) {
		if (!"Obelix".equals(gaulois.getNom())) {
			gaulois.boirePotion(forcePotion);
		} else {
			parler("Non, Ob�lix !... Tu n'auras pas de potion magique !");
		}
	}

	public static void main(String[] args) {
		System.out.println("Cr�ation du Druide");
		Druide legall = new Druide("Herv� Le Gall", 5, 10);
		legall.parler("She has everything...");
		legall.preparerPotion();
	}
}
