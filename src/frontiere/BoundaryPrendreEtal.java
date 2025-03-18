package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis desole " + nomVendeur + " mais il faut etre un habitant de notre village pour commencer ici.\n");
		}else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un etal.\n");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Desole " + nomVendeur + " je n'ai plus d'etal qui ne soit pas occupé.");
			} else {
				System.out.println("C'est parfait, il me reste un etal pour vous!\nIl me faudrait quelques renseignements:\n");
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder question1 = new StringBuilder();
		question1.append("Quel produit souhaitez-vous vendre ?\n");
		String produit = Clavier.entrerChaine(question1.toString());
		StringBuilder question2 = new StringBuilder();
		question2.append("Combien souhaitez-vous en vendre ?\n");
		int nbProduit = Clavier.entrerEntier(question2.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			System.out.println("Le vendeur " + " s'est installe a l'etal n°" + numeroEtal + "\n");
		}
	}
}
