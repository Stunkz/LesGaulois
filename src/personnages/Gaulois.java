package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force / 3) * effetPotion);
	}
	
	public void boirePotion(int potionForce) {
		parler("Merci Druide, je sens que ma force est " + potionForce + " fois décuplée.");
		effetPotion = potionForce;
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		System.out.println("Création du gaulois...");
		Gaulois kevinix = new Gaulois("Kevinix", 5);
		kevinix.parler("Colinix recivix dans la boitolix");
		System.out.println(kevinix);
		System.out.println("Création du romain");
		Romain alexandrus = new Romain("Alexandrus", 10);
		kevinix.frapper(alexandrus);
		kevinix.boirePotion(4);
		kevinix.frapper(alexandrus);
	}
}
