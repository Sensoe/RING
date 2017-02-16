package IHM;

import java.awt.*;

import javax.swing.*;

public class AfficheGraphiqueSelect extends JPanel{

	private Image image1, image2;
	private boolean guerrierG = false, mageG = false, chasseurG = false, guerrierD = false, mageD = false, 
			chasseurD = false;
	
	/**
	 * @param guerrierG the guerrierG to set
	 */
	public void setGuerrierG(boolean guerrierG) {this.guerrierG = guerrierG;}

	/**
	 * @param mageG the mageG to set
	 */
	public void setMageG(boolean mageG) {this.mageG = mageG;}

	/**
	 * @param chasseurG the chasseurG to set
	 */
	public void setChasseurG(boolean chasseurG) {this.chasseurG = chasseurG;}

	/**
	 * @param guerrierD the guerrierD to set
	 */
	public void setGuerrierD(boolean guerrierD) {this.guerrierD = guerrierD;}

	/**
	 * @param mageD the mageD to set
	 */
	public void setMageD(boolean mageD) {this.mageD = mageD;}

	/**
	 * @param chasseurD the chasseurD to set
	 */
	public void setChasseurD(boolean chasseurD) {this.chasseurD = chasseurD;}

	public AfficheGraphiqueSelect(){}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int largeur = this.getWidth();
		int longueur = this.getHeight();
		
		if (guerrierG) {
			String nom = "/Users/laptop/Documents/DUT Informatique/S2/Java/RING/machampback.png";
			this.image1 = Toolkit.getDefaultToolkit().getImage(nom);
			g.drawImage(image1, 0, longueur/2, 192, 192, this);
		}
		
		if (mageG) {
			String nom = "/Users/laptop/Documents/DUT Informatique/S2/Java/RING/alakazamback.png";
			this.image1 = Toolkit.getDefaultToolkit().getImage(nom);
			g.drawImage(image1, 0, longueur/2, 192, 192, this);
		}
		
		if (chasseurG) {
			String nom = "/Users/laptop/Documents/DUT Informatique/S2/Java/RING/lucarioback.png";
			this.image1 = Toolkit.getDefaultToolkit().getImage(nom);
			g.drawImage(image1, 0, longueur/2, 192, 192, this);
		}
		
		if (guerrierD){
			String nom = "/Users/laptop/Documents/DUT Informatique/S2/Java/RING/machampfront.png";
			this.image2 = Toolkit.getDefaultToolkit().getImage(nom);
			g.drawImage(image2, largeur/2, 0, 192, 192, this);
		}
		
		if (mageD) {
			String nom = "/Users/laptop/Documents/DUT Informatique/S2/Java/RING/alakazamfront.png";
			this.image2 = Toolkit.getDefaultToolkit().getImage(nom);
			g.drawImage(image2, largeur/2, 0, 192, 192, this);
		}
		
		if (chasseurD){
			String nom = "/Users/laptop/Documents/DUT Informatique/S2/Java/RING/lucariofront.png";
			this.image2 = Toolkit.getDefaultToolkit().getImage(nom);
			g.drawImage(image2, largeur/2, 0, 192, 192, this);
		}
		
	}
	
}
