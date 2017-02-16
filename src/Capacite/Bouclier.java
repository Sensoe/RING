package Capacite;

import java.io.Serializable;

import Combattant.*;

public abstract class Bouclier implements Serializable {
	
	protected String nom;
	protected int protection;
	protected int maniabilite;
	private Combattant c;
	
	public Bouclier(Combattant c, String nom, int protection, int maniabilite){
		this.c=c;
		this.nom=nom;
		this.protection=protection;
		this.maniabilite=maniabilite;
	}
	
	/**
	 * 
	 * @return l'efficacite de la défense en int
	 */
	public int efficaciteDEF(){
		int temp = (int) (c.getForce()*this.protection)/50;
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
		float jet = (float)((c.getDexterite()*this.maniabilite)/5000.0f*100.0f);
		float random =(int) (Math.random() * (higher-lower)) + lower;
		if(random >= 0.0f && random <= jet)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @return l'efficacite de l'attaque en int
	 */
	public int efficaciteATK(){
		int temp = (int) (c.getForce()*this.protection)/100;
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
		float jet = (float)((c.getDexterite()*this.maniabilite)/10000.0f*100.0f);
		float random =(int) (Math.random() * (higher-lower)) + lower;
		if(random >= 0.0f && random <= jet)
			return true;
		return false;
	}
	
	public String toString(){
		String s = "Nom : " + this.nom + "\nType : Bouclier" + "\nProtection : " + this.protection +
				"\nManiabilité : " + this.maniabilite + "\n";
		return s;
	}

}
