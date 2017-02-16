package IHM;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

import Capacite.*;
import Capacite.Content.*;
import Combattant.*;

public class PanelCreatePersonnage extends JPanel {

	private Fenetre fen;
	private Container cFen;
	private Combattant c;
	private AfficheGraphique afficheGraph;
	private JLabel classeSelecLb, capacite1Lb, capacite2Lb, pointDisponible;
	private JSpinner forceSpinner, dexteriteSpinner, concentrationSpinner, intelligenceSpinner;
	private JTextField force, dexterite, concentration, intelligence, nom;
	private JComboBox classe;
	private JComboBox capacite1;
	private JComboBox capacite2;
	private ArrayList<Arme> arme;
	private ArrayList<Bouclier> bouclier;
	private ArrayList<Sort> sort;
	
	
	PanelCreatePersonnage(Fenetre fen){
		this.fen=fen;
		this.cFen = this.fen.getContentPane();
		this.c= new Guerrier();
		this.initialise();
	}
	
	public void initialise(){
		
		/**
		 * Placement du Panel au centre
		 */
		fen.add(this.getPanelCenter(), BorderLayout.CENTER);
	    /**
	     * Placement du Panel a l'ouest
	     */
	    fen.add(this.getPanelWest(), BorderLayout.WEST);
	    /**
	     * Placement du Panel a l'est
	     */
	    fen.add(this.getPanelEast(), BorderLayout.EAST);
	    /**
	     * Placement du Panel au sud
	     */
	    fen.add(this.getPanelSouth(), BorderLayout.SOUTH);
	    fen.setVisible(true);
	}
	
	/**
	 * Met à jour les éléments modifiables
	 */
	public void refresh(){
		force.setText(""+forceSpinner.getValue());
		dexterite.setText(""+dexteriteSpinner.getValue());
		concentration.setText(""+concentrationSpinner.getValue());
		intelligence.setText(""+intelligenceSpinner.getValue());
		pointDisponible.setText(""+this.calculPointsDispo());
		this.afficheGraph.repaint();
	}
	
	/**
	 * Permet de calculer le nombre de point disponible dynamiquement
	 * @return le nombre de point restant
	 */
	public int calculPointsDispo(){
		int a = (int) (c.pointDispo() - ((int) forceSpinner.getValue()) - ((int) dexteriteSpinner.getValue()) -
				((int) concentrationSpinner.getValue()) - ((int) intelligenceSpinner.getValue()));
		return a;
	}
	
	/**
	 * Panel West, Personnalisation du combattant
	 * Choix de la classe, force, dextérite, l'intelligence, concentration et des capacités
	 * @return
	 */
	public JPanel getPanelWest() {
		JPanel pWest=new JPanel();
		pWest.setLayout(new GridLayout(14,1));
		
		SpinnerListener lis = new SpinnerListener();
		PersoListener img = new PersoListener();
		
		classeSelecLb = new JLabel("Classe :");
		classeSelecLb.setForeground(Color.black);
		classe = new JComboBox();
		classe.setPreferredSize(new Dimension(110, 20));
		classe.addItemListener(img);
		classe.addItem("Guerrier");
		classe.addItem("Mage");
		classe.addItem("Chasseur");
		
		forceSpinner = new JSpinner(new SpinnerNumberModel(c.getForce(),0,100,1));
		forceSpinner.addChangeListener(lis);
        force = new JTextField();
        force.setEditable(false);
        force.setText(""+forceSpinner.getValue());
        force.setBackground(Color.WHITE);
        force.setForeground(Color.BLACK);
        forceSpinner.setEditor(force);
        JLabel forceLabel = new JLabel("Force :");
        forceLabel.setForeground(Color.BLACK);
        
        dexteriteSpinner = new JSpinner(new SpinnerNumberModel(c.getDexterite(),0,100,1));
        dexteriteSpinner.addChangeListener(lis);
        dexterite = new JTextField();
        dexterite.setEditable(false);
        dexterite.setText(""+dexteriteSpinner.getValue());
        dexterite.setBackground(Color.WHITE);
        dexterite.setForeground(Color.BLACK);
        dexteriteSpinner.setEditor(dexterite);
        JLabel dexteriteLabel = new JLabel("Dextérité :");
        dexteriteLabel.setForeground(Color.BLACK);
		
		concentrationSpinner = new JSpinner(new SpinnerNumberModel(c.getConcentration(),0,100,1));
		concentrationSpinner.addChangeListener(lis);
        concentration = new JTextField();
        concentration.setEditable(false);
        concentration.setText(""+concentrationSpinner.getValue());
        concentration.setBackground(Color.WHITE);
        concentration.setForeground(Color.BLACK);
        concentrationSpinner.setEditor(concentration);
        JLabel concentrationLabel = new JLabel("Concentration :");
        concentrationLabel.setForeground(Color.BLACK);
        
        intelligenceSpinner = new JSpinner(new SpinnerNumberModel(c.getIntelligence(),0,100,1));
        intelligenceSpinner.addChangeListener(lis);
        intelligence = new JTextField();
        intelligence.setEditable(false);
        intelligence.setText(""+intelligenceSpinner.getValue());
        intelligence.setBackground(Color.WHITE);
        intelligence.setForeground(Color.BLACK);
        intelligenceSpinner.setEditor(intelligence);
        JLabel intelligenceLabel = new JLabel("Intelligence :");
        intelligenceLabel.setForeground(Color.BLACK);
        
    	capacite1Lb = new JLabel("Capacité 1 :");
        capacite1Lb.setForeground(Color.black);
        capacite1 = new JComboBox();
        capacite1.setPreferredSize(new Dimension(110, 20));
        capacite1.addItem("Epee");
        capacite1.addItem("Bouclier");
        capacite1.addItem("Boule de feu");
        capacite1.addItem("Barriere de force");
        capacite1.addItem("Sort de soin");
        capacite1.addItem("Remède");
        
        capacite2Lb = new JLabel("Capacité 2 :");
        capacite2Lb.setForeground(Color.black);
        capacite2 = new JComboBox();
		capacite2.setPreferredSize(new Dimension(110, 20));
		capacite2.addItem("Epee");
        capacite2.addItem("Bouclier");
        capacite2.addItem("Boule de feu");
        capacite2.addItem("Barriere de force");
        capacite2.addItem("Sort de soin");
        capacite2.addItem("Remède");
        
        pWest.add(classeSelecLb);
        pWest.add(classe);
        pWest.add(forceLabel);
        pWest.add(forceSpinner);
        pWest.add(dexteriteLabel);
        pWest.add(dexteriteSpinner);
        pWest.add(intelligenceLabel);
        pWest.add(intelligenceSpinner);
        pWest.add(concentrationLabel);
        pWest.add(concentrationSpinner);
        pWest.add(capacite1Lb);
        pWest.add(capacite1);
        pWest.add(capacite2Lb);
        pWest.add(capacite2);
        
		return pWest;
		
	}
	
	/**
	 * Affichage des images graphiques
	 * @return
	 */
	public JPanel getPanelCenter(){
		afficheGraph = new AfficheGraphique();
		return afficheGraph;
	}
	
	/**
	 * Personnalisation du personnage
	 * Choix du nom et affichage du nombre de point disponible
	 * @return
	 */
	public JPanel getPanelEast(){
    	JPanel pEast=new JPanel();
    	pEast.setLayout(new GridLayout (14,1));
    	
    	JLabel nomSelecLb = new JLabel("Nom :");
        nomSelecLb.setForeground(Color.black);
        nom=new JTextField("");
        nom.setPreferredSize(new Dimension(120, 20));
        
        JLabel pointDisponibleLabel = new JLabel("Points disponibles :");
        pointDisponibleLabel.setForeground(Color.BLACK);
        pointDisponible = new JLabel(""+c.pointDispo());
        pointDisponible.setForeground(Color.BLACK);
        pointDisponible.setHorizontalAlignment(JLabel.CENTER);
        pointDisponible.setVerticalAlignment(JLabel.CENTER);
        
    	pEast.add(nomSelecLb);
    	pEast.add(nom);
    	pEast.add(pointDisponibleLabel); 
    	pEast.add(pointDisponible);
    	
    	return pEast;    	
    }
	
	/**
	 * Annuler ou Creer un Combattant
	 * @return
	 */
	public JPanel getPanelSouth(){
		JPanel pSouth = new JPanel();
		CreateListener createLis=new CreateListener();
		JButton but1 = new JButton("Annuler");
		but1.addActionListener(createLis);
    	JButton but2 = new JButton("Creer Combattant");
    	but2.addActionListener(createLis);
    	pSouth.add(but1);
    	pSouth.add(but2);
		return pSouth;
	}
	
	/**
	 * Listerner pour la force, dexterite, l'intelligence et la concentration
	 * Appel de la méthode refresh pour actualiser la fenetre
	 */
	class SpinnerListener implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			refresh();
		}
	}
	
	/**
	 * Listener des JButton "Annuler" ou "Creer Combattant"
	 * Pour Annuler, retour au menu
	 * Pour Creer Combattant, Checking de la classe selection et creer le combattant en fonction des valeurs
	 * et des capacites donnés. Puis sauvegarde du combattant et retour au menu.
	 *
	 */
	class CreateListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		String s =e.getActionCommand();
    		
    		if (s.equals("Annuler")){
    			PanelCreatePersonnage.this.cFen.removeAll();
    			PanelCreatePersonnage.this.fen.initialiseMenu();
    			PanelCreatePersonnage.this.cFen.validate();
    		}
    		
    		else if (s.equals("Creer Combattant")){
    			if(classe.getSelectedItem().toString() == "Guerrier"){
    				int force, dexterite, intelligence, concentration;
    				String name = nom.getText();
    				force = (int) forceSpinner.getValue();
    				dexterite = (int) dexteriteSpinner.getValue();
    				intelligence = (int) intelligenceSpinner.getValue();
    				concentration = (int) concentrationSpinner.getValue();
    				
    				Guerrier g1 = new Guerrier(name, force, dexterite, intelligence, concentration);
    				g1.initVie();
    				
    				if (capacite1.getSelectedItem().toString() == "Epee"){
    					Epee1 e1 = new Epee1(g1);
    					g1.ajouterArme(e1);
    				}
    				
    				else if (capacite1.getSelectedItem().toString() == "Bouclier"){
    					Bouclier1 b1 = new Bouclier1(g1);
    					g1.ajouterBouclier(b1);
    				}
    				
    				else if (capacite1.getSelectedItem().toString() == "Remède"){
    					Remede1 r1 = new Remede1(g1);
    					g1.ajouterSort(r1);
    					
    				}
    				
    				if (capacite2.getSelectedItem().toString() == "Epee"){
    					Epee1 e1 = new Epee1(g1);
    					g1.ajouterArme(e1);
    				}
    				
    				else if (capacite2.getSelectedItem().toString() == "Bouclier"){
    					Bouclier1 b1 = new Bouclier1(g1);
    					g1.ajouterBouclier(b1);
    				}
    				
    				else if (capacite2.getSelectedItem().toString() == "Remède"){
    					Remede1 r1 = new Remede1(g1);
    					g1.ajouterSort(r1);
    					
    				}
    				
    				else{
    					JOptionPane.showMessageDialog(cFen, "Un guerrier ne peut avoir cette capacite... MISSION ABORT", "WARNING", JOptionPane.ERROR_MESSAGE);
    					PanelCreatePersonnage.this.cFen.removeAll();
    	    			PanelCreatePersonnage.this.fen.initialiseMenu();
    	    			PanelCreatePersonnage.this.cFen.validate();
    				}
    				
    				try {
    					g1.sauvegardeCombattant();
    					PanelCreatePersonnage.this.cFen.removeAll();
    	    			PanelCreatePersonnage.this.fen.initialiseMenu();
    	    			PanelCreatePersonnage.this.cFen.validate();
    	    			JOptionPane.showMessageDialog(cFen, "Votre Combattant a été sauvegardé", "Information", JOptionPane.INFORMATION_MESSAGE);
    				} catch (IOException ioe) {
    					ioe.printStackTrace();
    				}
    			}
    			else if(classe.getSelectedItem().toString() == "Mage"){
    				int force, dexterite, intelligence, concentration;
    				String name = nom.getText();
    				force = (int) forceSpinner.getValue();
    				dexterite = (int) dexteriteSpinner.getValue();
    				intelligence = (int) intelligenceSpinner.getValue();
    				concentration = (int) concentrationSpinner.getValue();
    				
    				Mage m1 = new Mage(name, force, dexterite, intelligence, concentration);
    				m1.initVie();
    				
    				if (capacite1.getSelectedItem().toString() == "Boule de feu"){
    					SortATK1 sa1 = new SortATK1(m1);
    					m1.ajouterSort(sa1);
    				}
    				
    				else if (capacite1.getSelectedItem().toString() == "Barriere de force"){
    					SortDEF1 sd1 = new SortDEF1(m1);
    					m1.ajouterSort(sd1);
    				}
    				
    				else if (capacite1.getSelectedItem().toString() == "Sort de soin"){
    					SortSoin1 ss1 = new SortSoin1(m1);
    					m1.ajouterSort(ss1);
    					
    				}
    				
    				if (capacite2.getSelectedItem().toString() == "Boule de feu"){
    					SortATK1 sa1 = new SortATK1(m1);
    					m1.ajouterSort(sa1);
    				}
    				
    				else if (capacite2.getSelectedItem().toString() == "Barriere de force"){
    					SortDEF1 sd1 = new SortDEF1(m1);
    					m1.ajouterSort(sd1);
    				}
    				
    				else if (capacite2.getSelectedItem().toString() == "Sort de soin"){
    					SortSoin1 ss1 = new SortSoin1(m1);
    					m1.ajouterSort(ss1);
    					
    				}
    				
    				else{
    					JOptionPane.showMessageDialog(cFen, "Un mage ne peut avoir cette capacite... MISSION ABORT", "WARNING", JOptionPane.ERROR_MESSAGE);
    					PanelCreatePersonnage.this.cFen.removeAll();
    	    			PanelCreatePersonnage.this.fen.initialiseMenu();
    	    			PanelCreatePersonnage.this.cFen.validate();
    				}
    				
    				try {
    					m1.sauvegardeCombattant();
    					PanelCreatePersonnage.this.cFen.removeAll();
    	    			PanelCreatePersonnage.this.fen.initialiseMenu();
    	    			PanelCreatePersonnage.this.cFen.validate();
    	    			JOptionPane.showMessageDialog(cFen, "Votre Combattant a été sauvegardé", "Information", JOptionPane.INFORMATION_MESSAGE);
    				} catch (IOException ioe) {
    					ioe.printStackTrace();
    				}	
    			}
    			
    			else if(classe.getSelectedItem().toString() == "Chasseur"){
    				int force, dexterite, intelligence, concentration;
    				String name = nom.getText();
    				force = (int) forceSpinner.getValue();
    				dexterite = (int) dexteriteSpinner.getValue();
    				intelligence = (int) intelligenceSpinner.getValue();
    				concentration = (int) concentrationSpinner.getValue();
    				
    				Chasseur c1 = new Chasseur(name, force, dexterite, intelligence, concentration);
    				c1.initVie();
    				
    				if (capacite1.getSelectedItem().toString() == "Boule de feu"){
    					SortATK1 sa1 = new SortATK1(c1);
    					c1.ajouterSort(sa1);
    				}
    				
    				else if (capacite1.getSelectedItem().toString() == "Barriere de force"){
    					SortDEF1 sd1 = new SortDEF1(c1);
    					c1.ajouterSort(sd1);
    				}
    				
    				else if (capacite1.getSelectedItem().toString() == "Sort de soin"){
    					SortSoin1 ss1 = new SortSoin1(c1);
    					c1.ajouterSort(ss1);
    					
    				}
    				
    				else if (capacite1.getSelectedItem().toString() == "Epee"){
    					Epee1 e1 = new Epee1(c1);
    					c1.ajouterArme(e1);
    				}
    				
    				else if (capacite1.getSelectedItem().toString() == "Bouclier"){
    					Bouclier1 b1 = new Bouclier1(c1);
    					c1.ajouterBouclier(b1);
    				}
    				
    				else if (capacite1.getSelectedItem().toString() == "Remède"){
    					Remede1 r1 = new Remede1(c1);
    					c1.ajouterSort(r1);
    					
    				}
    				
    				if (capacite2.getSelectedItem().toString() == "Boule de feu"){
    					SortATK1 sa1 = new SortATK1(c1);
    					c1.ajouterSort(sa1);
    				}
    				
    				else if (capacite2.getSelectedItem().toString() == "Barriere de force"){
    					SortDEF1 sd1 = new SortDEF1(c1);
    					c1.ajouterSort(sd1);
    				}
    				
    				else if (capacite2.getSelectedItem().toString() == "Sort de soin"){
    					SortSoin1 ss1 = new SortSoin1(c1);
    					c1.ajouterSort(ss1);
    					
    				}
    				
    				else if (capacite2.getSelectedItem().toString() == "Epee"){
    					Epee1 e1 = new Epee1(c1);
    					c1.ajouterArme(e1);
    				}
    				
    				else if (capacite2.getSelectedItem().toString() == "Bouclier"){
    					Bouclier1 b1 = new Bouclier1(c1);
    					c1.ajouterBouclier(b1);
    				}
    				
    				else if (capacite2.getSelectedItem().toString() == "Remède"){
    					Remede1 r1 = new Remede1(c1);
    					c1.ajouterSort(r1);
    					
    				}
    				
    				try {
    					c1.sauvegardeCombattant();
    					PanelCreatePersonnage.this.cFen.removeAll();
    	    			PanelCreatePersonnage.this.fen.initialiseMenu();
    	    			PanelCreatePersonnage.this.cFen.validate();
    	    			JOptionPane.showMessageDialog(cFen, "Votre Combattant a été sauvegardé", "Information", JOptionPane.INFORMATION_MESSAGE);
    				} catch (IOException ioe) {
    					ioe.printStackTrace();
    			}
    		}
    	}
    }
}
	
	/**
	 * Si on selectionne un guerrier, met un compteur à 1 à l'aide d'un setteur etc ...
	 *
	 */
	class PersoListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
			if(classe.getSelectedItem().toString() == "Guerrier"){
    			PanelCreatePersonnage.this.afficheGraph.setCompteur(1);
    			PanelCreatePersonnage.this.afficheGraph.repaint();
    		}
    		
    		else if (classe.getSelectedItem().toString() == "Mage"){
    			PanelCreatePersonnage.this.afficheGraph.setCompteur(2);
    			PanelCreatePersonnage.this.afficheGraph.repaint();
    		}
    		
    		else if (classe.getSelectedItem().toString() == "Chasseur"){
    			PanelCreatePersonnage.this.afficheGraph.setCompteur(3);
    			PanelCreatePersonnage.this.afficheGraph.repaint();
    		}
		}
		
	}
  }

