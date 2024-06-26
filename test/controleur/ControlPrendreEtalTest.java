package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	ControlEmmenager control1;
	ControlVerifierIdentite control2;	
	ControlPrendreEtal control3;
	
	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village des Tests",10,10);
		Chef chef = new Chef("Abraracourcix",10,village);
		village.setChef(chef);
		
		control1 = new ControlEmmenager(village);
		control2 = new ControlVerifierIdentite(village);
		control3 = new ControlPrendreEtal(control2,village);

		
		control1.ajouterGaulois("Bonemine", 3);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(control3);
	}

	@Test
	void testResteEtals() {
		assertTrue(control3.resteEtals());
	    int nbEtals = control3.donnerNbEtal();
	    
		for (int i=0; i<nbEtals;i++) {
			control1.ajouterGaulois("Gaul"+i,4);
			control3.prendreEtal("Gaul"+i,"boeuf",6);
		}
		
		assertFalse(control3.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		assertEquals(1,control3.prendreEtal("Bonemine", "fleurs", 10));
		
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(control3.verifierIdentite("Bonemine"));
		assertFalse(control3.verifierIdentite("C�sar"));

	}

}

//�crire assert puis control+space pour voir tous les types de asserts disponibles