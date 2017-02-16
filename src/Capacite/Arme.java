package Capacite;

import java.io.*;

import Combattant.*;

public abstract class Arme implements Serializable{
	
	protected String nom;
	protected int impact;
	protected int maniabilite;
	private Combattant c;
	
	/**
	 * Constructeur champ à champ
	 * @param c
	 * @param nom
	 * @param impact
	 * @param maniabilite
	 */
	public Arme(Combattant c, String nom, int impact, int maniabilite){
		this.c=c;
		this.nom=nom;
		this.impact=impact;
		this.maniabilite=maniabilite;
	}
	
	/**
	 * @return the c
	 */
	public Combattant getC() {
		return c;
	}

	/**
	 * 
	 * @return les degats infliges par l'arme
	 */
	public int efficaciteATK(){
		int temp= (int)(c.getForce()*this.impact)/50;
		float lower = 0.75f;
		float higher = 1.15f;
		float efficacite = (float) ((Math.random() * (higher-lower)) + lower)* temp;
		return (int) efficacite;
	}
	
	/**
	 * @return True si la valeur tiree est comprise entre 0 et jet
	 * sinon return false
	 */
	public boolean reussiteATK(){
		int lower = 0;
		int higher = 100;
		float jet = (float)((c.getDexterite()*this.maniabilite)/5000.0f*100.0f);
		float random =(int) (Math.random() * (higher-lower)) + lower;
		if(random >= 0.0f && random <= jet)
			return true;
		return false;
	}
	
	/**
	 * calcul la défense
	 * @return l'efficacite de la defense
	 */
	public int efficaciteDEF(){
		int temp = (int) (c.getForce()*this.impact)/100;
		float lower = 0.75f;
		float higher = 1.15f;
		float efficacite = (float) ((Math.random() * (higher-lower)) + lower)* temp;
		return (int) efficacite;
	}
	
	/**
	 * @return True si la valeur tiree est comprise entre 0 et jet
	 * sinon return false
	 */
	public boolean reussiteDEF(){
		int lower = 0;
		int higher = 100;
		float jet = (float)((c.getDexterite()*this.maniabilite)/10000.0f*100.0f);
		float random =(int) (Math.random() * (higher-lower)) + lower;
		if(random >= 0.0f && random <= jet)
			return true;
		return false;
	}
	
	public String toString(){
		String s = "Nom : " + this.nom + "\nType : Arme" + "\nImpact : " + this.impact +
				"\nManiabilité : " + this.maniabilite + "\n";
		return s;
	}
}
