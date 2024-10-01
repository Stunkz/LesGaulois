package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void ajouterHabitant(Gaulois villageois) {
		this.villageois[nbVillageois] = villageois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numeroVillageois) {
		return villageois[numeroVillageois];
	}

	public String getNom() {
		return nom;
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + "vivent les légendaires gaulois : ");
		int nbVillageois = 0;
		for (Gaulois villageois = trouverHabitant(nbVillageois); villageois != null || nbVillageois >= 30;) {
			System.out.println("- " + villageois.getNom());
			nbVillageois++;
			villageois = trouverHabitant(nbVillageois);
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Paul Sabatier", 30);
		
		// Gaulois gaulois = village.trouverHabitant(30);
		
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 25);
		
		village.setChef(abraracourcix);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		
		// Gaulois gaulois = village.trouverHabitant(1);
		// System.out.println(gaulois);
		
		village.afficherVillageois();
	}
}