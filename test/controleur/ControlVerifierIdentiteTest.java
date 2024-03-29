package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	
	ControlEmmenager control1;
	ControlVerifierIdentite control2;
	
	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village des Tests",10,10);
		Chef chef = new Chef("Abraracourcix",10,village);
		village.setChef(chef);
		
		control1 = new ControlEmmenager(village);		
		control2 = new ControlVerifierIdentite(village);
		
		control1.ajouterGaulois("Bonemine", 3);
	}

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(control2);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(control2.verifierIdentite("Bonemine"));
		assertFalse(control2.verifierIdentite("Obélix"));
	}

}
