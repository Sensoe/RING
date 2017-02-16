package Capacite.Content;

import Capacite.*;
import Combattant.*;

public class SortDEF1 extends Sort{
	
	private static String nom = "Barrière de force mineur";
	private static int puissance = 23;
	private static int facilite = 95;
	
	public SortDEF1(Combattant c){
		super(c, nom, puissance, facilite);
	}

}
