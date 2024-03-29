package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {

	ControlEmmenager control;
	
	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village des Tests",10,10);
		Chef chef = new Chef("Abraracourcix",10,village);
		village.setChef(chef);
		
		control = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(control);
	}

	@Test
	void testIsHabitant() {
		control.ajouterGaulois("Bonemine", 3);
		assertTrue(control.isHabitant("Bonemine"));
		assertFalse(control.isHabitant("Astérix"));
		assertTrue(control.isHabitant("Abraracourcix"));
		for(int i = 0; i<10; i++) {
			control.ajouterGaulois("Gaulois"+i, 4);
		}
		control.ajouterGaulois("Pressix", 3);
		assertFalse(control.isHabitant("Pressix"));
	}

	@Test
	void testAjouterDruide() {
		control.ajouterDruide("Panoramix", 2, 5, 8);
		assertTrue(control.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterGaulois() {
		control.ajouterGaulois("Obélix", 10);
		assertTrue(control.isHabitant("Obélix"));
	}

}
