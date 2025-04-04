package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irreductibles", 3, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlEmmenager = new ControlVerifierIdentite(village);
		assertNotNull(controlEmmenager, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlEmmenager = new ControlVerifierIdentite(village);
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		assertTrue(controlEmmenager.verifierIdentite(abraracourcix.getNom()));
		assertTrue(controlEmmenager.verifierIdentite(bonemine.getNom()));
		assertFalse(controlEmmenager.verifierIdentite("Le vendeur n'existe pas"));
	}

}
