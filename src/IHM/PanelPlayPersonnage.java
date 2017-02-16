package IHM;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import Capacite.Content.*;
import Combattant.*;

public class PanelPlayPersonnage extends JPanel{

	private Fenetre fen;
	private Container cFen;
	private JLabel nomCombattant1Lb, nomCombattant2Lb, vieSelecLb, classeSelecLbN1, classeSelecLbN2;
	private JTextField nomCombattant1, nomCombattant2, force1, force2, dexterite1, dexterite2,
	concentration1, concentration2, intelligence1, intelligence2, vieG1, vieD1;
	private JButton buttonCombattant1, buttonCombattant2, buttonATK1, buttonDEF1, buttonSORT1, buttonATK2, buttonDEF2,
	buttonSORT2, but2;
	private Combattant combattant1, combattant2;
	private AfficheGraphiqueSelect afficheGraphSelect;
	private boolean guerrierG = false, mageG = false, chasseurG = false, guerrierD = false, mageD = false, 
			chasseurD = false, valideG = false, valideD = false;
	private JComboBox classe1, classe2;
	private int degatG, degatD, protectionG, protectionD, soinG, soinD;
	
	PanelPlayPersonnage(Fenetre fen){
		this.fen=fen;
		this.cFen = this.fen.getContentPane();
		this.combattant1 = new Guerrier();
		this.combattant2 = new Mage();
		this.initialise();
	}
	
	public void initialise(){
		
		fen.add(this.getPanelNorth(), BorderLayout.NORTH);
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
	 * Reset les booleans à "gauche" à zero pour avoir uniquement une classe valide
	 */
	public void resetBooleanG(){
		this.guerrierG=false;
		this.mageG=false;
		this.chasseurG=false;
	}
	
	/**
	 * Reset les booleans à "droite" à zero pour avoir uniquement une classe valide
	 */
	public void resetBooleanD(){
		this.guerrierD=false;
		this.mageD=false;
		this.chasseurD=false;
	}
	
	/**
	 * refresh les stats lors du chargement du combattant gauche
	 */
	public void refreshStatG(){
		nomCombattant1.setText(combattant1.getNom());
		vieG1.setText(""+combattant1.getVie());
		force1.setText(""+combattant1.getForce());
		dexterite1.setText(""+combattant1.getDexterite());
		intelligence1.setText(""+combattant1.getIntelligence());
		concentration1.setText(""+combattant1.getConcentration());
	}
	
	/**
	 * refresh les stats lors du chargement du combattant droite
	 */
	public void refreshStatD(){
		nomCombattant2.setText(combattant2.getNom());
		vieD1.setText(""+combattant2.getVie());
		force2.setText(""+combattant2.getForce());
		dexterite2.setText(""+combattant2.getDexterite());
		intelligence2.setText(""+combattant2.getIntelligence());
		concentration2.setText(""+combattant2.getConcentration());
	}
	
	/**
	 * refresh la vie du combattant gauche lors du combat
	 */
	public void refreshCombatG(){
		if(combattant1.getVie() <=0){
			PanelPlayPersonnage.this.cFen.removeAll();
			PanelPlayPersonnage.this.fen.initialiseMenu();
			PanelPlayPersonnage.this.cFen.validate();
			JOptionPane.showMessageDialog(cFen, "J2 a gagné !", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		vieG1.setText(""+combattant1.getVie());
	}
	
	/**
	 * refresh la vie du combattant droite lors du combat
	 */
	public void refreshCombatD(){
		if(combattant2.getVie() <= 0){
			PanelPlayPersonnage.this.cFen.removeAll();
			PanelPlayPersonnage.this.fen.initialiseMenu();
			PanelPlayPersonnage.this.cFen.validate();
			JOptionPane.showMessageDialog(cFen, "J1 a gagné !", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		vieD1.setText(""+combattant2.getVie());
	}
	
	/**
	 * JTextfield pour entrer le nom des 2 combattants puis bouton de chargement pour chaque combattant
	 * @return un panel
	 */
	public JPanel getPanelNorth(){
		JPanel pNorth = new JPanel();
		
		SelectPersoListener lis = new SelectPersoListener();
		PersoListenerG classPersoG = new PersoListenerG();
		PersoListenerD classPersoD = new PersoListenerD();
		
		JPanel sum = new JPanel(new GridLayout(2, 1, 5, 5));
		JPanel left = new JPanel(new GridLayout(1, 2, 5, 5));
		nomCombattant1Lb = new JLabel("Combattant 1 : ");
		nomCombattant1 = new JTextField("");
		nomCombattant1.setPreferredSize(new Dimension(100, 20));
		
		JPanel right = new JPanel(new GridLayout(1, 2, 5, 5));
		nomCombattant2Lb = new JLabel("Combattant 2 : ");
		nomCombattant2 = new JTextField("");
		nomCombattant2.setPreferredSize(new Dimension(100, 20));
		
		JPanel southleft = new JPanel(new GridLayout(1, 3, 5, 5));
		buttonCombattant1 = new JButton("CHARGER J1");
		buttonCombattant1.addActionListener(lis);
		classeSelecLbN1 = new JLabel("Classe :");
		classeSelecLbN1.setForeground(Color.black);
		classe1 = new JComboBox();
		classe1.setPreferredSize(new Dimension(110, 20));
		classe1.addItemListener(classPersoG);
		classe1.addItem("Guerrier");
		classe1.addItem("Mage");
		classe1.addItem("Chasseur");
		
		JPanel southright = new JPanel(new GridLayout(1, 3, 5 ,5));
		buttonCombattant2 = new JButton("CHARGER J2");
		buttonCombattant2.addActionListener(lis);
		classeSelecLbN2 = new JLabel("Classe :");
		classeSelecLbN2.setForeground(Color.black);
		classe2 = new JComboBox();
		classe2.setPreferredSize(new Dimension(110, 20));
		classe2.addItemListener(classPersoD);
		classe2.addItem("Guerrier");
		classe2.addItem("Mage");
		classe2.addItem("Chasseur");
		
		left.add(nomCombattant1Lb);
		left.add(nomCombattant1);
	    right.add(nomCombattant2Lb);
		right.add(nomCombattant2);
		southleft.add(classeSelecLbN1);
        southleft.add(classe1);
		southleft.add(buttonCombattant1);
		southright.add(classeSelecLbN2);
        southright.add(classe2);
        southright.add(buttonCombattant2);
		
		sum.add(left);
		sum.add(right);
		sum.add(southleft);
		sum.add(southright);
		pNorth.add(sum);
		return pNorth;
	}
	
	/**
	 * Summary of the first fighter
	 * @return un panel
	 */
	public JPanel getPanelWest(){
		JPanel pWest=new JPanel();
		pWest.setLayout(new GridLayout(14,1));
		
		ActionGListener action = new ActionGListener();
		
		vieSelecLb = new JLabel("Points de vie :");
		vieSelecLb.setForeground(Color.black);
		vieG1 = new JTextField("");
		vieG1.setEditable(false);
		
        force1 = new JTextField("");
        force1.setEditable(false);
        force1.setForeground(Color.BLACK);
        JLabel forceLabel = new JLabel("Force :");
        forceLabel.setForeground(Color.BLACK);

        dexterite1 = new JTextField("");
        dexterite1.setEditable(false);
        dexterite1.setForeground(Color.BLACK);
        JLabel dexteriteLabel = new JLabel("Dextérité :");
        dexteriteLabel.setForeground(Color.BLACK);
		
        concentration1 = new JTextField("");
        concentration1.setEditable(false);
        concentration1.setForeground(Color.BLACK);
        JLabel concentrationLabel = new JLabel("Concentration :");
        concentrationLabel.setForeground(Color.BLACK);
        
        intelligence1 = new JTextField("");
        intelligence1.setEditable(false);
        intelligence1.setForeground(Color.BLACK);
        JLabel intelligenceLabel = new JLabel("Intelligence :");
        intelligenceLabel.setForeground(Color.BLACK);
        
    	buttonATK1 = new JButton("Attaquer");
    	buttonATK1.setEnabled(false);
    	buttonATK1.addActionListener(action);
        
    	buttonDEF1 = new JButton("Défendre");
    	buttonDEF1.setEnabled(false);
    	buttonDEF1.addActionListener(action);
    	
    	buttonSORT1 = new JButton("Soin");
    	buttonSORT1.setEnabled(false);
    	buttonSORT1.addActionListener(action);
        
        pWest.add(vieSelecLb);
        pWest.add(vieG1);
        pWest.add(forceLabel);
        pWest.add(force1);
        pWest.add(dexteriteLabel);
        pWest.add(dexterite1);
        pWest.add(intelligenceLabel);
        pWest.add(intelligence1);
        pWest.add(concentrationLabel);
        pWest.add(concentration1);
        pWest.add(buttonATK1);
        pWest.add(buttonDEF1);
        pWest.add(buttonSORT1);
        
		return pWest;
	}
	
	/**
	 * Affichage du panel graphique avec les images en fontion de la classe du combattant
	 * @return un panel graphique
	 */
	public JPanel getPanelCenter(){
		afficheGraphSelect = new AfficheGraphiqueSelect();
		return afficheGraphSelect;
	}
	
	/**
	 * Summary of the second fighter
	 * @return un panel
	 */
	public JPanel getPanelEast(){
		JPanel pEast=new JPanel();
		pEast.setLayout(new GridLayout(14,1));
		
		ActionDListener action = new ActionDListener();
		
		vieSelecLb = new JLabel("Points de vie :");
		vieSelecLb.setForeground(Color.black);
		vieD1 = new JTextField("");
		vieD1.setEditable(false);
		
        force2 = new JTextField("");
        force2.setEditable(false);
        force2.setForeground(Color.BLACK);
        JLabel forceLabel = new JLabel("Force :");
        forceLabel.setForeground(Color.BLACK);

        dexterite2 = new JTextField("");
        dexterite2.setEditable(false);
        dexterite2.setForeground(Color.BLACK);
        JLabel dexteriteLabel = new JLabel("Dextérité :");
        dexteriteLabel.setForeground(Color.BLACK);
		
        concentration2 = new JTextField("");
        concentration2.setEditable(false);
        concentration2.setForeground(Color.BLACK);
        JLabel concentrationLabel = new JLabel("Concentration :");
        concentrationLabel.setForeground(Color.BLACK);
        
        intelligence2 = new JTextField("");
        intelligence2.setEditable(false);
        intelligence2.setForeground(Color.BLACK);
        JLabel intelligenceLabel = new JLabel("Intelligence :");
        intelligenceLabel.setForeground(Color.BLACK);
        
        buttonATK2 = new JButton("Attaquer");
    	buttonATK2.setEnabled(false);
    	buttonATK2.addActionListener(action);
        
    	buttonDEF2 = new JButton("Défendre");
    	buttonDEF2.setEnabled(false);
    	buttonDEF2.addActionListener(action);
    	
    	buttonSORT2 = new JButton("Soin");
    	buttonSORT2.setEnabled(false);
    	buttonSORT2.addActionListener(action);
        
        pEast.add(vieSelecLb);
        pEast.add(vieD1);
        pEast.add(forceLabel);
        pEast.add(force2);
        pEast.add(dexteriteLabel);
        pEast.add(dexterite2);
        pEast.add(intelligenceLabel);
        pEast.add(intelligence2);
        pEast.add(concentrationLabel);
        pEast.add(concentration2);
        pEast.add(buttonATK2);
        pEast.add(buttonDEF2);
        pEast.add(buttonSORT2);
        
		return pEast;
	}
	
	/**
	 * bouton annuler pour retourner au menu
	 * bouton combattre pour combattre
	 * @return un panel
	 */
	public JPanel getPanelSouth(){
		JPanel pSouth = new JPanel();
		SelectPersoListener selectPersoLis=new SelectPersoListener();
		JButton but1 = new JButton("Annuler");
		but1.addActionListener(selectPersoLis);
    	but2 = new JButton("Combattre");
    	but2.addActionListener(selectPersoLis);
    	pSouth.add(but1);
    	pSouth.add(but2);
		return pSouth;
	}
	
	/**
	 * 
	 * Listener pour charger les personnages, retourner au menu et combattre
	 *
	 */
	class SelectPersoListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String s = e.getActionCommand();
			
			if (s.equals("Annuler")){
				PanelPlayPersonnage.this.cFen.removeAll();
				PanelPlayPersonnage.this.fen.initPanelPlay();
				PanelPlayPersonnage.this.cFen.validate();
			}
			
			else if (s.equals("Combattre")){
				if(valideG && valideD){
					buttonATK1.setEnabled(true);
					buttonDEF1.setEnabled(true);
					buttonSORT1.setEnabled(true);
					but2.setEnabled(false);
					buttonCombattant1.setEnabled(false);
					buttonCombattant2.setEnabled(false);
					nomCombattant1.setEditable(false);
					nomCombattant2.setEditable(false);
					classe1.setEnabled(false);
					classe2.setEnabled(false);
				}
				else
					JOptionPane.showMessageDialog(cFen, "Vous devez charger les deux personnages avant de combattre !", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if (s.equals("CHARGER J1")){
				if(guerrierG){
					String name = nomCombattant1.getText();
					PanelPlayPersonnage.this.afficheGraphSelect.setGuerrierG(true);
					try {
						combattant1 = (Guerrier) Combattant.chargerCombattant(name);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					PanelPlayPersonnage.this.valideG=true;
					refreshStatG();
					PanelPlayPersonnage.this.afficheGraphSelect.repaint();
				}
				
				else if (mageG){
					String name = nomCombattant1.getText();
					PanelPlayPersonnage.this.afficheGraphSelect.setMageG(true);
					try {
						combattant1 = (Mage) Combattant.chargerCombattant(name);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					PanelPlayPersonnage.this.valideG=true;
					refreshStatG();
					PanelPlayPersonnage.this.afficheGraphSelect.repaint();
				}
				
				else if (chasseurG){
					String name = nomCombattant1.getText();
					PanelPlayPersonnage.this.afficheGraphSelect.setChasseurG(true);
					try {
						combattant1 = (Chasseur) Combattant.chargerCombattant(name);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					PanelPlayPersonnage.this.valideG=true;
					refreshStatG();
					PanelPlayPersonnage.this.afficheGraphSelect.repaint();
				}
			}
			
			else if (s.equals("CHARGER J2")){
				if (guerrierD){
					String name = nomCombattant2.getText();
					PanelPlayPersonnage.this.afficheGraphSelect.setGuerrierD(true);
					try {
						combattant2 = (Guerrier) Combattant.chargerCombattant(name);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					PanelPlayPersonnage.this.valideD=true;
					refreshStatD();
					PanelPlayPersonnage.this.afficheGraphSelect.repaint();
				}
				
				else if (mageD){
					String name = nomCombattant2.getText();
					PanelPlayPersonnage.this.afficheGraphSelect.setMageD(true);
					try {
						combattant2 = (Mage) Combattant.chargerCombattant(name);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					PanelPlayPersonnage.this.valideD=true;
					refreshStatD();
					PanelPlayPersonnage.this.afficheGraphSelect.repaint();
				}
				
				else if (chasseurD){
					String name = nomCombattant2.getText();
					PanelPlayPersonnage.this.afficheGraphSelect.setChasseurD(true);
					try {
						combattant2 = (Chasseur) Combattant.chargerCombattant(name);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					PanelPlayPersonnage.this.valideD=true;
					refreshStatD();
					PanelPlayPersonnage.this.afficheGraphSelect.repaint();
				}
				
			}
			
		}
	}
	
	/**
	 * Listener pour exécuter le choix de l'utilisateur
	 * Met a false les boutons de l'utilisateur après utilisation
	 */
	class ActionGListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String s = e.getActionCommand();
			
			if (s.equals("Attaquer")){
				if(combattant1 instanceof Guerrier){
					Epee1 e1 = new Epee1(combattant1);
					degatG = e1.efficaciteATK();
					
					if (e1.reussiteATK()){
						combattant2.setVie(combattant2.getVie()-degatG);
						refreshCombatD();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "L'attaque a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(false);
					buttonDEF1.setEnabled(false);
					buttonSORT1.setEnabled(false);
					buttonATK2.setEnabled(true);
					buttonDEF2.setEnabled(true);
					buttonSORT2.setEnabled(true);
				}
				
				else if (combattant1 instanceof Mage){
					SortATK1 sa1 = new SortATK1(combattant1);
					degatG = sa1.efficaciteATK();
					
					if (sa1.reussiteATK()){
						combattant2.setVie(combattant2.getVie()-degatG);
						refreshCombatD();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "L'attaque a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(false);
					buttonDEF1.setEnabled(false);
					buttonSORT1.setEnabled(false);
					buttonATK2.setEnabled(true);
					buttonDEF2.setEnabled(true);
					buttonSORT2.setEnabled(true);
				}
				
				else if (combattant1 instanceof Chasseur){
					SortATK1 sa1 = new SortATK1(combattant1);
					degatG = sa1.efficaciteATK();
					
					if (sa1.reussiteATK()){
						combattant2.setVie(combattant2.getVie()-degatG);
						refreshCombatD();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "L'attaque a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(false);
					buttonDEF1.setEnabled(false);
					buttonSORT1.setEnabled(false);
					buttonATK2.setEnabled(true);
					buttonDEF2.setEnabled(true);
					buttonSORT2.setEnabled(true);
				}
			}
			
			else if (s.equals("Défendre")){
				if(combattant1 instanceof Guerrier){
					Bouclier1 b1 = new Bouclier1(combattant1);
					protectionG = b1.efficaciteDEF();
					
					if (b1.reussiteDEF()){
						combattant1.setVie(combattant1.getVie()+protectionG);
						refreshCombatG();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "La défense a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(false);
					buttonDEF1.setEnabled(false);
					buttonSORT1.setEnabled(false);
					buttonATK2.setEnabled(true);
					buttonDEF2.setEnabled(true);
					buttonSORT2.setEnabled(true);
				}
				
				else if (combattant1 instanceof Mage){
					SortDEF1 sd1 = new SortDEF1(combattant1);
					protectionG = sd1.efficaciteDEF();
					if(sd1.reussiteDEF()){
						combattant1.setVie(combattant1.getVie()+protectionG);
						refreshCombatG();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "La défense a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(false);
					buttonDEF1.setEnabled(false);
					buttonSORT1.setEnabled(false);
					buttonATK2.setEnabled(true);
					buttonDEF2.setEnabled(true);
					buttonSORT2.setEnabled(true);
				}
				
				else if (combattant1 instanceof Chasseur){
					Bouclier1 b1 = new Bouclier1(combattant1);
					protectionG = b1.efficaciteDEF();
					if (b1.reussiteDEF()){
						combattant1.setVie(combattant1.getVie()+protectionG);
						refreshCombatG();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "La défense a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(false);
					buttonDEF1.setEnabled(false);
					buttonSORT1.setEnabled(false);
					buttonATK2.setEnabled(true);
					buttonDEF2.setEnabled(true);
					buttonSORT2.setEnabled(true);
				}
			}
			
			else if (s.equals("Soin")){
				if(combattant1 instanceof Guerrier){
					Remede1 r1 = new Remede1(combattant1);
					soinG = r1.efficaciteREMEDE();
					if(r1.reussiteREMEDE()){
						combattant1.setVie(combattant1.getVie()+soinG);
						refreshCombatG();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "Le remède a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(false);
					buttonDEF1.setEnabled(false);
					buttonSORT1.setEnabled(false);
					buttonATK2.setEnabled(true);
					buttonDEF2.setEnabled(true);
					buttonSORT2.setEnabled(true);
				}
				
				else if (combattant1 instanceof Mage){
					SortSoin1 ss1 = new SortSoin1(combattant1);
					soinG = ss1.efficaciteSOIN();
					if (ss1.reussiteSOIN()){
					combattant1.setVie(combattant1.getVie()+soinG);
					refreshCombatG();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "Le soin a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(false);
					buttonDEF1.setEnabled(false);
					buttonSORT1.setEnabled(false);
					buttonATK2.setEnabled(true);
					buttonDEF2.setEnabled(true);
					buttonSORT2.setEnabled(true);
				}
				
				else if (combattant1 instanceof Chasseur){
					Remede1 r1 = new Remede1(combattant1);
					soinG = r1.efficaciteREMEDE();
					if (r1.reussiteREMEDE()){
					combattant1.setVie(combattant1.getVie()+soinG);
					refreshCombatG();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "Le soin a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(false);
					buttonDEF1.setEnabled(false);
					buttonSORT1.setEnabled(false);
					buttonATK2.setEnabled(true);
					buttonDEF2.setEnabled(true);
					buttonSORT2.setEnabled(true);
				}
			}	
		}
	}
	
	/**
	 * Listener pour exécuter le choix de l'utilisateur
	 * Met a false les boutons de l'utilisateur après utilisation
	 */
	class ActionDListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String s = e.getActionCommand();
			
			if (s.equals("Attaquer")){
				if(combattant2 instanceof Guerrier){
					Epee1 e1 = new Epee1(combattant2);
					degatD = e1.efficaciteATK();
					if (e1.reussiteATK()){
					combattant1.setVie(combattant1.getVie()-degatD);
					refreshCombatG();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "L'attaque a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(true);
					buttonDEF1.setEnabled(true);
					buttonSORT1.setEnabled(true);
					buttonATK2.setEnabled(false);
					buttonDEF2.setEnabled(false);
					buttonSORT2.setEnabled(false);
				}
				
				else if (combattant2 instanceof Mage){
					SortATK1 sa1 = new SortATK1(combattant2);
					degatG = sa1.efficaciteATK();
					if (sa1.reussiteATK()){
					combattant1.setVie(combattant1.getVie()-degatG);
					refreshCombatG();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "L'attaque a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(true);
					buttonDEF1.setEnabled(true);
					buttonSORT1.setEnabled(true);
					buttonATK2.setEnabled(false);
					buttonDEF2.setEnabled(false);
					buttonSORT2.setEnabled(false);
				}
				
				else if (combattant2 instanceof Chasseur){
					SortATK1 sa1 = new SortATK1(combattant2);
					degatD = sa1.efficaciteATK();
					if (sa1.reussiteATK()){
						combattant1.setVie(combattant1.getVie()-degatD);
						refreshCombatG();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "L'attaque a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(true);
					buttonDEF1.setEnabled(true);
					buttonSORT1.setEnabled(true);
					buttonATK2.setEnabled(false);
					buttonDEF2.setEnabled(false);
					buttonSORT2.setEnabled(false);
				}
			}
			
			else if (s.equals("Défendre")){
				if(combattant2 instanceof Guerrier){
					Bouclier1 b1 = new Bouclier1(combattant2);
					protectionD = b1.efficaciteDEF();
					if(b1.reussiteDEF()){
						combattant2.setVie(combattant2.getVie()+protectionD);
						refreshCombatD();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "La défense a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(true);
					buttonDEF1.setEnabled(true);
					buttonSORT1.setEnabled(true);
					buttonATK2.setEnabled(false);
					buttonDEF2.setEnabled(false);
					buttonSORT2.setEnabled(false);
				}
				
				else if (combattant2 instanceof Mage){
					SortDEF1 sd1 = new SortDEF1(combattant2);
					protectionD = sd1.efficaciteDEF();
					if (sd1.reussiteDEF()){
						combattant2.setVie(combattant2.getVie()+protectionD);
						refreshCombatD();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "La défense a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(true);
					buttonDEF1.setEnabled(true);
					buttonSORT1.setEnabled(true);
					buttonATK2.setEnabled(false);
					buttonDEF2.setEnabled(false);
					buttonSORT2.setEnabled(false);
				}
				
				else if (combattant2 instanceof Chasseur){
					Bouclier1 b1 = new Bouclier1(combattant2);
					protectionD = b1.efficaciteDEF();
					if (b1.reussiteDEF()){
						combattant2.setVie(combattant2.getVie()+protectionD);
						refreshCombatD();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "La défense a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(true);
					buttonDEF1.setEnabled(true);
					buttonSORT1.setEnabled(true);
					buttonATK2.setEnabled(false);
					buttonDEF2.setEnabled(false);
					buttonSORT2.setEnabled(false);
				}
			}
			
			else if (s.equals("Soin")){
				if(combattant2 instanceof Guerrier){
					Remede1 r1 = new Remede1(combattant2);
					soinD = r1.efficaciteREMEDE();
					if (r1.reussiteREMEDE()){
					combattant2.setVie(combattant2.getVie()+soinD);
					refreshCombatD();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "Le soin a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(true);
					buttonDEF1.setEnabled(true);
					buttonSORT1.setEnabled(true);
					buttonATK2.setEnabled(false);
					buttonDEF2.setEnabled(false);
					buttonSORT2.setEnabled(false);
				}
				
				else if (combattant2 instanceof Mage){
					SortSoin1 ss1 = new SortSoin1(combattant2);
					soinD = ss1.efficaciteSOIN();
					if(ss1.reussiteSOIN()){
						combattant2.setVie(combattant2.getVie()+soinD);
						refreshCombatD();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "Le soin a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(true);
					buttonDEF1.setEnabled(true);
					buttonSORT1.setEnabled(true);
					buttonATK2.setEnabled(false);
					buttonDEF2.setEnabled(false);
					buttonSORT2.setEnabled(false);
				}
				
				else if (combattant2 instanceof Chasseur){
					Remede1 r1 = new Remede1(combattant2);
					soinD = r1.efficaciteREMEDE();
					if(r1.reussiteREMEDE()){
						combattant2.setVie(combattant2.getVie()+soinD);
						refreshCombatD();
					}
					else{
						JOptionPane.showMessageDialog(cFen, "Le soin a échoué !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					buttonATK1.setEnabled(true);
					buttonDEF1.setEnabled(true);
					buttonSORT1.setEnabled(true);
					buttonATK2.setEnabled(false);
					buttonDEF2.setEnabled(false);
					buttonSORT2.setEnabled(false);
				}
			}
		}
	}
	
	/**
	 * Met un true un parametre pour connaitre la classe a charger
	 * 
	 */
	class PersoListenerG implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(classe1.getSelectedItem().toString() == "Guerrier"){
				PanelPlayPersonnage.this.resetBooleanG();
				PanelPlayPersonnage.this.guerrierG = true;
			}
			
			else if (classe1.getSelectedItem().toString() == "Mage"){
				PanelPlayPersonnage.this.resetBooleanG();
				PanelPlayPersonnage.this.mageG = true;
			}
			
			else if (classe1.getSelectedItem().toString() == "Chasseur"){
				PanelPlayPersonnage.this.resetBooleanG();
				PanelPlayPersonnage.this.chasseurG = true;
			}
		}
	}
	
	class PersoListenerD implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (classe2.getSelectedItem().toString() == "Guerrier"){
				PanelPlayPersonnage.this.resetBooleanD();
				PanelPlayPersonnage.this.guerrierD = true;
			}
			
			else if (classe2.getSelectedItem().toString() == "Mage"){
				PanelPlayPersonnage.this.resetBooleanD();
				PanelPlayPersonnage.this.mageD = true;
			}
			
			else if (classe2.getSelectedItem().toString() == "Chasseur"){
				PanelPlayPersonnage.this.resetBooleanD();
				PanelPlayPersonnage.this.chasseurD = true;
			}
		}
	}
}
