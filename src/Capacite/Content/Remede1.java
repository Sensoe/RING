package Capacite.Content;

import Capacite.*;
import Combattant.*;

public class Remede1 extends Sort{
	
	private static String nom = "Potion de soin mineur";
	private static int puissance = 37;
	private static int facilite = 100;
	
	public Remede1(Combattant c){
		super(c, nom, puissance, facilite);
	}

}
