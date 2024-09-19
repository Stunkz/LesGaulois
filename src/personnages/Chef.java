package personnages;

public class Chef {
	private String nom;
	private int force;
	private Village village;

	public Chef(String nom, int force, Village village) {
		this.nom = nom;
		this.force = force;
		this.village = village;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le chef " + nom + " du village " + village.getNom() + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}
	
	public static void main(String[] args) {
		System.out.println("Création du chef");
		System.out.println("Création du romain");
		Village paulsab = new Village("Paul Sabatier");
		Chef rey = new Chef("Jerome Rey", 1000000, paulsab);
		rey.parler("L'administration romaine a peur de moi !");
		Romain alexandre = new Romain("Alexandre", 1);
		alexandre.parler("Monsieur j'ai pas compris l'exercice 2 vous pouvez m'expliquer ?");
		rey.frapper(alexandre);
		rey.parler("C'est la plus belle claque que j'ai jamais donné");
	}
}