package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[MAXEQUIPEMENT];
	private int nbEquipement = 0;
	
	private static final int MAXEQUIPEMENT = 2;

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
	
	private boolean isForcePositive() {
		return force > 0;
	}

	public void recevoirCoup(int forceCoup) {
		// Precondition
		
		int forceDebut = force;
		
		force -= forceCoup;
		assert isForcePositive();
		
		if (force > 0) {
			parler("Aïe");
		} else if (force < -20) {
			parler("*se desintègre*");
		} else {
			parler("J'abandonne......");
		}
		
		int forceFin = force;
		
		// Postcondition
		assert forceDebut > forceFin;
	}
	
	private void afficherEquipement() {
		for (int i = 0; i < MAXEQUIPEMENT; i++) {
			Equipement equipement = equipements[i];
			System.out.println(equipement);
		}
	}
	
	private void equiperEquipement(Equipement equipement) {
		this.equipements[nbEquipement] = equipement;
		nbEquipement++;
		
		System.out.println("Le soldat " + " s'équipe avec un " + equipement + ".");
		assert isFullyEquipped();
	}
	
	private boolean isFullyEquipped() {
		return nbEquipement <= MAXEQUIPEMENT;
	}
	
	private boolean isAlreadyEquipped(Equipement equipementToCheck) {
		boolean returnValue = false;
		int nbEquipement = 0;
		
		while (nbEquipement < MAXEQUIPEMENT) {
			Equipement equipementIteration = equipements[nbEquipement];
			nbEquipement++;
			
			if (equipementToCheck == equipementIteration) {
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	public void sEquiper(Equipement equipementAEquiper) {
		
		// Precondition
		assert equipementAEquiper != null;
		
		switch (nbEquipement) {
		case 0: {
			equiperEquipement(equipementAEquiper);
			break;
		}
		case 1: {
			if (isAlreadyEquipped(equipementAEquiper)) {
				System.out.println("Le soldat " + " possède déjà un " + equipementAEquiper);
			} else {
				equiperEquipement(equipementAEquiper);
			}
			break;
		}
		default:
			System.out.println("Le soldat " + " est déjà bien protégé");
			break;
		}
	
		// Postcondition
		assert isAlreadyEquipped(equipementAEquiper);
	}
	
	public static void main(String[] args) {
		System.out.println("Création du romain");
		Romain minus = new Romain("Minus", 6);
		minus.parler("Hmmmmm");
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
