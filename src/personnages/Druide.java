package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		this.forcePotion = 1;

		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � "
				+ effetPotionMax + ".");
	}

	public void preparerPotion() {
		Random random = new Random();
		int potion = random.nextInt(effetPotionMin, effetPotionMax);
		if (potion > 7) {
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

	public static void main(String[] args) {
		System.out.println("Cr�ation du Druide");
		Druide legall = new Druide("Herv� Le Gall", 5, 10);
		legall.parler("She has everything...");
		legall.preparerPotion();
	}
}
