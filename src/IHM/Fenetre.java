package IHM;

import javax.swing.*;

import Sauvegarde.Sauvegarde;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Fenetre extends JFrame{
	
	private JButton jouer,creeCombattant,quitter,options;
	private Fenetre fen;
	private Container cFen;
	
	public Fenetre(String titre, int w, int h) throws FileNotFoundException, IOException{
		super(titre);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initialiseMenu();
		this.centreEcran(w,h);
		this.setVisible(true);
		this.setResizable(false);
		Sauvegarde save = new Sauvegarde();
	}
	
	public void centreEcran(int w, int h) {
		Toolkit aTK= Toolkit.getDefaultToolkit();
		Dimension dim = aTK.getScreenSize();
		this.setBounds((dim.width-w)/2, (dim.height-h)/2, w, h);
	}
	
	public void initialiseMenu(){
        JPanel p = new PanelMenu(this);
        this.getContentPane().add(p);
	}
	
	public void initPanelPlay(){
		JPanel p = new PanelPlay(this);
        this.getContentPane().add(p);
	}
	
	public void initPanelCreatePerso(){
		JPanel p = new PanelCreatePersonnage(this);
        this.getContentPane().add(p);
	}
	
	public void initSelectPerso(){
		JPanel p = new PanelPlayPersonnage(this);
        this.getContentPane().add(p);
	}
}
