package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
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
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else if (force < -20) {
			parler("*se desint�gre*");
		} else {
			parler("J'abandonne......");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Cr�ation du romain");
		Romain alexandre = new Romain("Alexandre", 1);
		alexandre.parler("Hmmmmm");
	}
}
