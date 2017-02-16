package Capacite;

import Capacite.*;
import Capacite.Content.*;
import Combattant.*;


public class TestCapacite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Guerrier G1 = new Guerrier();
		Epee1 E1 = new Epee1(G1);
		System.out.println(E1.efficaciteATK());
		System.out.println(E1.getC());
		
		Bouclier1 B1 = new Bouclier1(G1);
		System.out.println(B1);
		
		/*int lower = 0;
		int higher = 100;
		float jet = (float)((45*50)/10000.0f*100.0f);
		float random =(int) (Math.random() * (higher-lower)) + lower;
		System.out.println(jet);
		System.out.println(random);
		//int random2 = (int)((1/jet)/2);
		//System.out.println(random2);
		if(random >= 0.0f && random <= jet){
			System.out.println("Vrai");
		}*/
		
	}

}
