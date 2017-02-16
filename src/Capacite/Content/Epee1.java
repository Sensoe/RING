package Capacite.Content;

import Capacite.*;
import Combattant.*;

public class Epee1 extends Arme{

	private static String nom = "Epée de bois";
	private static int impact = 26;
	private static int maniabilite = 95;
	
	public Epee1(Combattant c){
		super(c, nom, impact, maniabilite);
	}
}
