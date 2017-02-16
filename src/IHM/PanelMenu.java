package IHM;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PanelMenu extends JPanel {
	
	private JButton jouer,creeCombattant,quitter,options;
	private Fenetre fen;
	private Container cFen;
	private Image image;

	PanelMenu(Fenetre fen){
		this.fen = fen;
        this.fen.setTitle("RING");
        this.cFen = fen.getContentPane();
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
        jouer = new JButton("JOUER");
        jouer.setPreferredSize(new Dimension(150,40));
        test1.add(jouer);
        creeCombattant = new JButton("CREE COMBATTANT");
        creeCombattant.setPreferredSize(new Dimension(150,40));
        test2.add(creeCombattant);
        options = new JButton("OPTIONS");
        options.setPreferredSize(new Dimension(150,40));
        test3.add(options);
        quitter = new JButton("QUITTER");
        quitter.setPreferredSize(new Dimension(150,40));
        test4.add(quitter);
        centre.add(test1);
        centre.add(test2);
        centre.add(test3);
        centre.add(test4);
        
        Font boutton = new Font("impact",Font.PLAIN,15);
        MenuBoutonListener lis = new MenuBoutonListener();
        
        jouer.setForeground(Color.BLACK);
        jouer.setFont(boutton);
        jouer.addActionListener(lis);
        
        creeCombattant.setForeground(Color.BLACK);
        creeCombattant.setFont(boutton);
        creeCombattant.addActionListener(lis);
        
        options.setForeground(Color.BLACK);
        options.setFont(boutton);
        options.addActionListener(lis);
        
        quitter.setForeground(Color.BLACK);
        quitter.setFont(boutton);
        quitter.addActionListener(lis);
        
        // Creation du Panel sud de Menu //
        sud.setLayout(new GridLayout(1,1));
        sud.setBackground(Color.LIGHT_GRAY);
       
	}
	
	/**
	 * Listener du menu
	 * Initialise différent panel en fonctione de ce que l'utilisateur selectionne
	 *
	 */
	class MenuBoutonListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String s = e.getActionCommand();
			if (s.equals("JOUER")){
				PanelMenu.this.cFen.removeAll();
				PanelMenu.this.fen.initPanelPlay();
				PanelMenu.this.cFen.validate();
			}
			
			else if (s.equals("CREE COMBATTANT")){
				PanelMenu.this.cFen.removeAll();
				PanelMenu.this.fen.initPanelCreatePerso();
				PanelMenu.this.cFen.validate();
			}
			
			else if (s.equals("QUITTER")){
				PanelMenu.this.fen.dispose();
			}
		}
	}
}
