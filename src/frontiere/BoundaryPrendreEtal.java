package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//TODO a completer
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !\n");
		System.out.println("Il me faudrait quelques renseignements :\n");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?\n");
		int nbProduit = Clavier.entrerEntier("Quel produit souhaitez-vous vendre ?\n");
		controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);




	}
}
