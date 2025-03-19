package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		StringBuilder dialogue = new StringBuilder();
		if (infosMarche.length == 0) {
			System.out.println("Le marche est vide, revenez plus tard.\n");
		} else {
			System.out.println(nomAcheteur + ", vous trouverez au marche:\n");
			for (int i = 0, j = 0; i < infosMarche.length; i++) {
				if (i == 0) {
					dialogue.append("- " + infosMarche[i] + " qui vend ");
				} else if (j == 1) {
					dialogue.append(infosMarche[i] + " ");
				} else if (j == 2) {
					dialogue.append(infosMarche[i] + "\n");
					System.out.println(dialogue.toString());
				} else if (j == 3) {
					j = 0;
					dialogue = new StringBuilder();
					dialogue.append("- " + infosMarche[i] + " qui vend ");
				}
				j++;
			}
		}
	}
}
