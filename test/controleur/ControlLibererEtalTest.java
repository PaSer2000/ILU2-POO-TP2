package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {

	ControlEmmenager control1;
	ControlVerifierIdentite control2;	
	ControlPrendreEtal control3;
	ControlTrouverEtalVendeur control4;
	ControlLibererEtal control5;
	
	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village des Tests",10,10);
		Chef chef = new Chef("Abraracourcix",10,village);
		village.setChef(chef);
		
		control1 = new ControlEmmenager(village);
		control2 = new ControlVerifierIdentite(village);
		control3 = new ControlPrendreEtal(control2,village);
		control4 = new ControlTrouverEtalVendeur(village);
		control5 = new ControlLibererEtal(control4);
		
		control1.ajouterGaulois("Bonemine", 3);
		control3.prendreEtal("Bonemine", "fleurs", 10);	
	}

	@Test
	void testControlLibererEtal() {
		assertNotNull(control5);
	}

	@Test
	void testIsVendeur() {
		assertTrue(control5.isVendeur("Bonemine"));
		assertFalse(control5.isVendeur("Abraracourcix"));
	}

	@Test
	void testLibererEtal() {
		String[] donneesVente = new String[5];
		donneesVente[0] = "true";
		donneesVente[1] = "Bonemine";
		donneesVente[2] = "fleurs";
		donneesVente[3] = "10";
		donneesVente[4] = "10";
		for (int i = 0; i<5; i++) {
			assertEquals(donneesVente[i],control5.libererEtal("Bonemine")[i]);
		}
	}

}