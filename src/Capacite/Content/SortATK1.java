package Capacite.Content;

import Capacite.*;
import Combattant.*;

public class SortATK1 extends Sort{
	
	private static String nom = "Boule de feu mineur";
	private static int puissance = 27;
	private static int facilite = 95;
	
	public SortATK1(Combattant c){
		super(c, nom, puissance, facilite);
	}

}
