package Capacite.Content;

import Capacite.*;
import Combattant.*;

public class SortSoin1 extends Sort{
	
	private static String nom = "Sort de soin mineur";
	private static int puissance = 40;
	private static int facilite = 100;
	
	public SortSoin1(Combattant c){
		super(c, nom, puissance, facilite);
	}

}
