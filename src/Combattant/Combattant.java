package Combattant;

import java.io.*;
import java.util.*;

import Capacite.*;
import Capacite.Content.*;
import Sauvegarde.*;

public abstract class Combattant implements Serializable {

	protected String nom;
	protected int force = 0;
	protected int dexterite = 0;
	protected int intelligence = 0;
	protected int concentration = 0;
	protected int vie;
	protected int xp;
	protected ArrayList<Arme> arme;
	protected ArrayList<Bouclier> bouclier; 
	protected ArrayList<Sort> sort; 
	
	/**
	 * Constructeur par défaut
	 */
	public Combattant(){
		this.nom="";
		this.xp=1;
		this.arme = new ArrayList<Arme>();
        this.bouclier  = new ArrayList<Bouclier>();
        this.sort = new ArrayList<Sort>();
	}
	
	/**
	 * Constructeur Champs à champs
	 * @param nom
	 * @param force
	 * @param dexterite
	 * @param intelligence
	 * @param concentration
	 */
	public Combattant(String nom, int force, int dexterite, int intelligence, int concentration){
		this.nom=nom;
		this.force=force;
		this.dexterite=dexterite;
		this.intelligence=intelligence;
		this.concentration=concentration;
		this.xp=1;
		this.arme = new ArrayList<Arme>();
        this.bouclier  = new ArrayList<Bouclier>();
        this.sort = new ArrayList<Sort>();
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the force
	 */
	public int getForce() {
		return force;
	}
	/**
	 * @param force the force to set
	 */
	public void setForce(int force) {
		this.force = force;
	}
	/**
	 * @return the dexterite
	 */
	public int getDexterite() {
		return dexterite;
	}
	/**
	 * @param dexterite the dexterite to set
	 */
	public void setDexterite(int dexterite) {
		this.dexterite = dexterite;
	}
	/**
	 * @return the intelligence
	 */
	public int getIntelligence() {
		return intelligence;
	}
	/**
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	/**
	 * @return the concentration
	 */
	public int getConcentration() {
		return concentration;
	}
	/**
	 * @param concentration the concentration to set
	 */
	public void setConcentration(int concentration) {
		this.concentration = concentration;
	}
	/**
	 * @return the vie
	 */
	public int getVie() {
		return vie;
	}
	/**
	 * @param vie the vie to set
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	/**
	 * @return the xp
	 */
	public int getXp() {
		return xp;
	}
	/**
	 * @param xp the xp to set
	 */
	public void setXp(int xp) {
		this.xp = xp;
	}

	/**
	 * @return the arme
	 */
	public ArrayList<Arme> getArme() {
		return arme;
	}

	/**
	 * @param arme the arme to set
	 */
	public void ajouterArme(Arme arme){
        this.arme.add(arme);
	}

	/**
	 * @return the bouclier
	 */
	public ArrayList<Bouclier> getBouclier() {
		return bouclier;
	}

	/**
	 * @param bouclier the bouclier to set
	 */
	public void ajouterBouclier(Bouclier bouclier){
        this.bouclier.add(bouclier);
	}

	/**
	 * @return the sort
	 */
	public ArrayList<Sort> getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void ajouterSort(Sort sort){
        this.sort.add(sort);
	}

	public int pointDispo(){
		return ((100+this.xp)-(this.force + this.dexterite + this.intelligence + this.concentration)-1);
	}
	
	public boolean regleStat(){
		if ((this.force + this.dexterite + this.intelligence + this.concentration < 100 + this.xp) &&
				(this.xp >=1 && this.xp <=20))
			return true;
		return false;
	}
	
	/**
	 * Met les stats du combattant a zero
	 */
	public void resetCombattant(){
		this.force=0;
		this.dexterite=0;
		this.intelligence=0;
		this.concentration=0;
	}
	
	/**
	 * Initialise la vie en fonction des stats
	 */
	public void initVie(){
		this.vie= 200 - (this.force+this.dexterite+this.intelligence+this.concentration) + this.xp*3;
	}
	
	/**
	 * Méthode pour sauvegarder le combattant dans un fichier .combattant
	 * @throws IOException
	 */
	public void sauvegardeCombattant() throws IOException{
		if(!(nomUtiliser())){
	        File fichier =  new File(Sauvegarde.getPathSauvegardeCombattants()+this.nom+".combattant") ;
	        FileOutputStream fos = new FileOutputStream(fichier);
	        ObjectOutputStream oos =  new ObjectOutputStream(fos) ;
	        oos.writeObject(this) ;
	        oos.close();
	        fos.close();
		}
    }
	
	/**
	 * Chargement du combattant grâce au nom donnée par l'utilisateur
	 * @param nom
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Combattant chargerCombattant(String nom) throws IOException, ClassNotFoundException{
        File fichier =  new File(Sauvegarde.getPathSauvegardeCombattants()+nom+".combattant") ;
        FileInputStream fis =new FileInputStream(fichier);
        ObjectInputStream ois =  new ObjectInputStream(fis) ;
        Combattant combattant = (Combattant)ois.readObject() ;
        ois.close();
        fis.close();
        return combattant;
    }
	
	 public boolean nomUtiliser(){
         File fichier =  new File(Sauvegarde.getPathSauvegardeCombattants()+this.nom+".combattant");
         if(fichier.exists())
             return true;
         return false;
     }
	
	public void init(){
		Scanner input = new Scanner (System.in);
		System.out.println("Entrez le nom de votre personnage");
		this.nom=input.next();
	}
	
	public String toString(){
		String s="";
		if (this instanceof Guerrier) s+="Classe : Guerrier \n";
		else if (this instanceof Mage) s+="Classe : Mage \n";
		else if (this instanceof Chasseur) s+="Classe : Chasseur \n";
		s+="Nom : " + this.nom + "\nVie : " + this.vie + "\nXP : " + this.xp + "\nForce : " + this.force
				+ "\nDextérité : " + this.dexterite + "\nIntelligence : " + this.intelligence 
				+ "\nConcentration : " + this.concentration + "\n";
		if (!arme.isEmpty()){
			Epee1 e1 = (Epee1) arme.get(0);
			s+= e1.toString();
		}
		
		else if (!bouclier.isEmpty()){
			Bouclier1 b1 = (Bouclier1) bouclier.get(0);
			s+= b1.toString();
		}
		
		else if (!sort.isEmpty()){
			Remede1 r1 = (Remede1) sort.get(0);
		}
		return s;
	}
}
