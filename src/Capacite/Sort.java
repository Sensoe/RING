package Capacite;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serializable;

import javax.swing.JLabel;

import Combattant.*;

public abstract class Sort implements Serializable {
	
	protected String nom;
	protected int puissance;
	protected int facilite;
	private Combattant c;
	
	public Sort(Combattant c, String nom, int puissance, int facilite){
		this.c=c;
		this.nom=nom;
		this.puissance=puissance;
		this.facilite=facilite;
	}

	public int efficaciteATK(){
		int temp = (c.getConcentration()*this.puissance)/50;
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
		float jet = (float)((c.getIntelligence()*this.facilite)/5000.0f*100.0f);
		float random =(int) (Math.random() * (higher-lower)) + lower;
		if(random >= 0.0f && random <= jet)
			return true;
		return false;
	}
	
	public int efficaciteDEF(){
		int temp = (c.getConcentration()*this.puissance)/50;
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
		float jet = (float)((c.getIntelligence()*this.facilite)/5000.0f*100.0f);
		float random =(int) (Math.random() * (higher-lower)) + lower;
		if(random >= 0.0f && random <= jet)
			return true;
		return false;
	}
	
	public int efficaciteSOIN(){
		int temp = (c.getConcentration()*this.puissance)/50;
		float lower = 0.75f;
		float higher = 1.15f;
		float efficacite = (float) ((Math.random() * (higher-lower)) + lower)* temp;
		return (int) efficacite;
	}
	
	/**
	 * @return True si la valeur tiree est comprise entre 0 et jet
	 * sinon return false
	 */
	public boolean reussiteSOIN(){
		int lower = 0;
		int higher = 100;
		float jet = (float)((c.getIntelligence()*this.facilite)/5000.0f*100.0f);
		float random =(int) (Math.random() * (higher-lower)) + lower;
		if(random >= 0.0f && random <= jet)
			return true;
		return false;
	}
	
	public int efficaciteREMEDE(){
		int temp = (c.getForce()*this.puissance)/50;
		float lower = 0.75f;
		float higher = 1.15f;
		float efficacite = (float) ((Math.random() * (higher-lower)) + lower)* temp;
		return (int) efficacite;
	}
	
	/**
	 * @return True si la valeur tiree est comprise entre 0 et jet
	 * sinon return false
	 */
	public boolean reussiteREMEDE(){
		int lower = 0;
		int higher = 100;
		float jet = (float)((c.getDexterite()*this.facilite)/5000.0f*100.0f);
		float random =(int) (Math.random() * (higher-lower)) + lower;
		if(random >= 0.0f && random <= jet)
			return true;
		return false;
	}
	
	public String toString(){
		String s = "Nom : " + this.nom + "\nType : Sort" + "\nPuissance : " + this.puissance +
				"\nFacilité : " + this.facilite + "\n";
		return s;
	}

}

/*pOuest.setLayout(new GridLayout (7,1));

forceSelec = new JLabel();
forceSelec.setForeground(Color.black);
dexteriteSelec = new JLabel();
dexteriteSelec.setForeground(Color.black);
concentrationSelec = new JLabel();
concentrationSelec.setForeground(Color.black);
intelligenceSelec = new JLabel();
intelligenceSelec.setForeground(Color.black);
classeSelec = new JLabel();
classeSelec.setForeground(Color.black);
xpSelec = new JLabel();
xpSelec.setForeground(Color.black);

JLabel forceSelecLb = new JLabel("Force :");
forceSelecLb.setForeground(Color.black);
JLabel dexteriteSelecLb = new JLabel("Dextérité :");
dexteriteSelecLb.setForeground(Color.black);
JLabel concentrationSelecLb = new JLabel("Concentration :");
concentrationSelecLb.setForeground(Color.black);
JLabel intelligenceSelecLb = new JLabel("Intelligence :");
intelligenceSelecLb.setForeground(Color.black);
JLabel classeSelecLb = new JLabel("Classe :");
classeSelecLb.setForeground(Color.black);
JLabel xpSelecLb = new JLabel("Expérience :");
xpSelecLb.setForeground(Color.black);

classe.setPreferredSize(new Dimension(100, 20));
classe.addItem("Guerrier");
classe.addItem("Mage");
classe.addItem("Chasseur");

pOuest.add(classeSelecLb);
pOuest.add(classe);
pOuest.add(xpSelecLb);
pOuest.add(xpSelec);
pOuest.add(intelligenceSelecLb);
pOuest.add(intelligenceSelec);
pOuest.add(concentrationSelecLb);
pOuest.add(concentrationSelec);
pOuest.add(forceSelecLb);
pOuest.add(forceSelec);
pOuest.add(dexteriteSelecLb);
pOuest.add(dexteriteSelec);*/
