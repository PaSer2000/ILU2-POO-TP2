package controleur;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
	ControlEmmenager control1;
	ControlVerifierIdentite control2;	
	ControlPrendreEtal control3;
	ControlTrouverEtalVendeur control4;
	ControlLibererEtal control5;
	ControlAfficherMarche control6;
	
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
		control6 = new ControlAfficherMarche(village);
		
		control1.ajouterGaulois("Bonemine", 3);
		control3.prendreEtal("Bonemine", "fleurs", 10);	
	}
	

	@Test
	void testControlAfficherMarche() {
		assertNotNull(control6);
	}

	@Test
	void testDonnerInfosMarche() {
		fail("Not yet implemented");
	}

}
