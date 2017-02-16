package Combattant;

import java.util.*;

public class Guerrier extends Combattant{
	
	public Guerrier(){
		super();
	}
	
	public Guerrier(String nom, int force, int dexterite, int intelligence, int concentration){
		super(nom, force, dexterite, intelligence, concentration);
	}
	
	
	
	public boolean regleStat(){
		if((this.force >= this.dexterite+10) && (this.dexterite+10 >=this.intelligence+10) && 
				(this.intelligence+10 >= this.concentration) && this.pointDispo() >= 0)
				return true;
		return false;
	}
	
	public void init(){
		super.init();
		Scanner sc = new Scanner(System.in);
		do{
			super.resetCombattant();
			System.out.println(this.pointDispo() + " points restant");
			System.out.println("Entrez la force de votre personnage");
			this.force=sc.nextInt();
			System.out.println(this.pointDispo() + " points restant");
			System.out.println("Entrez la dextérité de votre personnage");
			this.dexterite=sc.nextInt();
			System.out.println(this.pointDispo() + " points restant");
			System.out.println("Entrez l'intelligence de votre personnage");
			this.intelligence=sc.nextInt();
			System.out.println(this.pointDispo() + " points restant");
			System.out.println("Entrez la concentration de votre personnage");
			this.concentration=sc.nextInt();
			super.initVie();
		}while(!(super.regleStat()&&this.regleStat()));
	}
	
}
