package IHM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Combattant.*;
import IHM.PanelMenu.MenuBoutonListener;

public class PanelPlay extends JPanel{

	private Fenetre fen;
	private Container cFen;
	private JButton j1vsj2, retour;
	
	PanelPlay(Fenetre fen){
		this.fen=fen;
		this.cFen = this.fen.getContentPane();
		this.setLayout(new GridLayout(3,1));
        JPanel titre = new JPanel();
        JPanel centre = new JPanel();
        JPanel sud = new JPanel();
        this.add(titre);
        this.add(centre);
        this.add(sud);
        
        // Creation du panel Titre de Menu //
        JLabel title = new JLabel("RING");
        titre.setBackground(Color.LIGHT_GRAY);
        title.setFont(new Font("impact",Font.BOLD,80));
        title.setForeground(Color.BLACK);
        titre.add(title);
        
        // Creation du panel Centre de Menu //
        centre.setLayout(new GridLayout(4,1));
        JPanel test1 = new JPanel();
        test1.setBackground(Color.LIGHT_GRAY);
        JPanel test2 = new JPanel();
        test2.setBackground(Color.LIGHT_GRAY);
        JPanel test3 = new JPanel();
        test3.setBackground(Color.LIGHT_GRAY);
        JPanel test4 = new JPanel();
        test4.setBackground(Color.LIGHT_GRAY);
        j1vsj2 = new JButton("J1 VS J2");
        j1vsj2.setPreferredSize(new Dimension(150,40));
        test1.add(j1vsj2);
        retour = new JButton("RETOUR");
        retour.setPreferredSize(new Dimension(150,40));
        test1.add(j1vsj2);
        test2.add(retour);
        centre.add(test1);
        centre.add(test2);
        centre.add(test3);
        centre.add(test4);
        
        Font boutton = new Font("impact",Font.PLAIN,15);
        MenuBoutonListener lis = new MenuBoutonListener();
        
        j1vsj2.setForeground(Color.BLACK);
        j1vsj2.setFont(boutton);
        j1vsj2.addActionListener(lis);
        
        retour.setForeground(Color.BLACK);
        retour.setFont(boutton);
        retour.addActionListener(lis);
        
        // Creation du Panel sud de Menu //
        sud.setLayout(new GridLayout(1,1));
        sud.setBackground(Color.LIGHT_GRAY);  
	}
	
	class MenuBoutonListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String s = e.getActionCommand();
			if (s.equals("J1 VS J2")){
				PanelPlay.this.cFen.removeAll();
    			PanelPlay.this.fen.initSelectPerso();
    			PanelPlay.this.cFen.validate();
			}
			
			if (s.equals("RETOUR")){
				PanelPlay.this.cFen.removeAll();
    			PanelPlay.this.fen.initialiseMenu();
    			PanelPlay.this.cFen.validate();
			}
		}
	}
}
