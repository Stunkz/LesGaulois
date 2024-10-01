package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isForcePositive();
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	private Boolean isForcePositive() {
		return force > 0;
	}

	public void recevoirCoup(int forceCoup) {
		// Precondition
		assert isForcePositive();
		
		int forceDebut = force;
		
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else if (force < -20) {
			parler("*se desintègre*");
		} else {
			parler("J'abandonne......");
		}
		
		// Postcondition
		assert forceDebut > force;
	}
	
	public static void main(String[] args) {
		System.out.println("Création du romain");
		Romain minus = new Romain("Minus", 6);
		minus.parler("Hmmmmm");
	}
}
