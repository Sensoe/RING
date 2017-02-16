package Combattant;

import java.io.*;
import java.util.*;

import Capacite.Content.Epee1;
import Sauvegarde.*;

public class TestCombattant {
	
	private static String GUERRIER = "Guerrier";
	private static String MAGE = "Mage";
	private static String CHASSEUR = "Chasseur";
	private static String OUI = "Y";

	public static void main(String[] args) {
		
		try {
			Sauvegarde save = new Sauvegarde();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int s2=0;
		Scanner input = new Scanner (System.in);
		System.out.println("//////////RING//////////");
		System.out.println("1 - Jouer");
		System.out.println("2 - Créer un personnage");
		System.out.println("3 - Charger un personnage");
		System.out.println("////////////////////////");
		s2=input.nextInt();
		
		if(s2==1){
			String s="";
			String s1 = "";
			System.out.println("Choissisez une classe (Guerrier, Mage ou Chasseur)");
			s=input.next();
			if(s.equals(GUERRIER)){
				Guerrier g1 = new Guerrier();
				g1.init();
				System.out.println(g1);
				Epee1 E1 = new Epee1(g1);
				System.out.println(E1.efficaciteATK());
				g1.ajouterArme(E1);
				System.out.println(""+g1.getArme());
				System.out.println("Voulez vous sauver votre personnage ? (Y/N)");
				s1=input.next();
				if (s1.equals(OUI))
				try {
					g1.sauvegardeCombattant();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			else if(s.equals(MAGE)){
				Mage m1 = new Mage();
				m1.setNom("Test2");
				System.out.println(m1);
			}
			
			else if(s.equals(CHASSEUR)){
				Chasseur c1 = new Chasseur();
				c1.setNom("Test3");
				System.out.println(c1);
			}
		}
		
		else if(s2==2){
			
			
			try {
					String nom = "";
					System.out.println("Entrez le nom du personnage à charger");
					nom=input.next();
					Guerrier g2 = (Guerrier) Combattant.chargerCombattant(nom);
					System.out.println(g2);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
	}
}
