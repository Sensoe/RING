package IHM;

import java.awt.*;

import javax.swing.*;

public class AfficheGraphique extends JPanel{

	private Image image1;
	private int compteur;
	
	public AfficheGraphique(){}
	
	public void setCompteur(int compteur){
		this.compteur=compteur;
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		int largeur = this.getWidth();
		int longueur = this.getHeight();
		if (compteur == 1){
			String nom = "/Users/laptop/Documents/DUT Informatique/S2/Java/RING/machampfront.png";
			this.image1 = Toolkit.getDefaultToolkit().getImage(nom);
			g.drawImage(image1, largeur/3, longueur/3, 192, 192, this);
		}
		
		else if (compteur == 2){
			String nom = "/Users/laptop/Documents/DUT Informatique/S2/Java/RING/alakazamfront.png";
			this.image1 = Toolkit.getDefaultToolkit().getImage(nom);
			g.drawImage(image1, largeur/3, longueur/3, 192, 192, this);
		}
		
		else if (compteur == 3){
			String nom = "/Users/laptop/Documents/DUT Informatique/S2/Java/RING/lucariofront.png";
			this.image1 = Toolkit.getDefaultToolkit().getImage(nom);
			g.drawImage(image1, largeur/3, longueur/3, 192, 192, this);
		}
	}
}
