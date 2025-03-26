package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private BoundaryAfficherMarche boundaryAfficherMarche;
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		int choixUtilisateur;
		if (!controlAcheterProduit.appartenirVillage(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.\n");
		} else {
			do {
				StringBuilder question = new StringBuilder();
				question.append("1 - je veux acheter un produit.\n");
				question.append("2 - je veux avoir une vue d'ensemble du marché.\n");
				question.append("3 - quitter l'application.\n");
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1: {
					//TODO
					break;
				}
				case 2: {
					boundaryAfficherMarche.afficherMarche(nomAcheteur);
					break;
				}
				case 3: {
					System.out.println("Au revoir client " + nomAcheteur + "\n");
					break;
				}
				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 ou 3 !\n");
					break;
				}
			} while (choixUtilisateur!=3);
		}
	}
}
