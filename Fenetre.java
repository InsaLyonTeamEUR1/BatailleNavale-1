import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Vector;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.Border;


import java.awt.Dimension;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Fenetre extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int[] order,tab;
	JLabel l1, l2,l3,global,ci;
	JButton[][] grille=  new JButton[10][10];
    JButton[][] grille2=  new JButton[10][10];
	Dimension taille = new Dimension(150,150);
	JComboBox liste;
	ButtonGroup group = new ButtonGroup();
    JRadioButton rb1 = new JRadioButton("Horizontale");
    JRadioButton rb2 = new JRadioButton("Verticale");
	boolean init=false;
	 public ControlButton control;
	 public ControlMenu controle;
	 public ControlListe control1;
	 ImageIcon image;
	 int compteur;
	int comptplace=0;
	int comptnombre;
	 String chaine ;
	 int compFin;
	 JMenuItem item1,item2;
	 int k=0;
	 float s;
	 String u,monscore,bestScores;
	 String[] items = { "Porte-avion : 5 cases", "Croiseur : 4 cases","Contre-torpilleurs : 3 cases","Sous-marin : 3 cases","Torpilleur : 2 cases" };
	 
	 
	 public Fenetre() {
		  
		     initAttribut();
			 creerWidget();
			 pack(); // Fixe la taille par d�faut
			 setVisible(true); // Affiche la fenetre
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Gestion de la fermeture
			 }
			
			 
		  
		  
	 
	
	 
	
	 
	/*public void FinJeu(){
		System.out.println(compFin);
		 if(compteur<0){
			 for(int i=0;i<16;i++){
				 b[i].setEnabled(false);
				}
			 l3.setText("0");
			 c.stop();
			 JOptionPane d = new JOptionPane();
			  JOptionPane.showMessageDialog( this, "Vous avez perdu", "Defaite",
			                       JOptionPane.ERROR_MESSAGE );
			   
			  JDialog fenErr = d.createDialog("Scores");
		 }
		if(compFin==8){
			c.stop();
		MeilleurScore();	
		JOptionPane d = new JOptionPane();
		  JOptionPane.showMessageDialog( this, "Vous avez gagner en "+score, "Victoire",
		                       JOptionPane.ERROR_MESSAGE );
		   
		  JDialog fenErr = d.createDialog("Scores");
		}
		
	 }*/
	 
	 public void initAttribut(){
		 
		 control = new ControlButton(this);
		 controle = new ControlMenu(this);
		 control1=new ControlListe(this);
		
		
	 }
	 
	
		

	 
	 
	 public void creerWidget(){
 
		 JMenuBar barMenu = new JMenuBar();
		 JMenu menu = new JMenu("Menu");
		 item1 = new JMenuItem("Nouvelle partie");
		 item1.addActionListener(controle);
		 item2 = new JMenuItem("Règles");
		 item2.addActionListener(controle);
		 menu.add(item1);
		 menu.add(item2);
		 barMenu.add(menu);
		 setJMenuBar(barMenu);





		 liste=new JComboBox(items);
		 liste.addActionListener(control1);
		 group.add(rb1);
		 rb1.addActionListener(control);
		 group.add(rb2);
		 rb2.addActionListener(control);
		
		// liste=new JComboBox(items);
		// liste.addActionListener(control1);
         //rb1.addActionListener(control1);
         //rb2.addActionListener(control1);
		 JTextField jtText = new JTextField("Grille Adversaire");
		 JTextField jtText2 = new JTextField("                 ");
		 
		 JPanel pan = new JPanel(new GridLayout(11,11));
		 JPanel pangauche = new JPanel();
         JPanel panboutton = new JPanel();


		
		 
		 
		 	for(int i=0;i<11;i++){
		 		JLabel mi= new JLabel("          "+i);
		 		pan.add(mi);
		 	}
			 
		 	 
		 	
		 for(int i=0;i<10;i++){
			 if(i==0){
				 ci= new JLabel("          A");
				 pan.add(ci);
			 }
			
			 if(i==1){
				  ci= new JLabel("          B");
				  pan.add(ci);
			 } 
			 if(i==2){
				 ci= new JLabel("          C");
				  pan.add(ci);
			 }
			 if(i==3){
				 ci= new JLabel("          D");
				  pan.add(ci);
			 }
			 if(i==4){
				 ci= new JLabel("          E");
				  pan.add(ci);
			 }
			 if(i==5){
				 ci= new JLabel("          F");
				  pan.add(ci);
			 }
			 if(i==6){
				 ci= new JLabel("          G");
				  pan.add(ci);
			 }
			 if(i==7){
				 ci= new JLabel("          H");
				  pan.add(ci);
			 }
			 if(i==8){
				 ci= new JLabel("          I");
				  pan.add(ci);
			 }
			 if(i==9){
				 ci= new JLabel("          J");
				  pan.add(ci);
			 }


			for(int j=0;j<10;j++){
                grille[i][j]= new JButton();


                pan.add(grille[i][j]);

                grille[i][j].addActionListener(control);
                grille[i][j].setIcon(new ImageIcon("src/mer.jpg"));
                grille[i][j].setDisabledIcon(new ImageIcon("src/bateaux.jpg"));
            }

		 }


        JPanel pan2 = new JPanel(new GridLayout(11,11));
		 for(int i=0;i<11;i++){
			 JLabel mi= new JLabel("          "+i);
			 pan2.add(mi);
		 }

		 for(int i=0;i<10;i++){
			 if(i==0){
				 ci= new JLabel("          A");
				 pan2.add(ci);
			 }

			 if(i==1){
				 ci= new JLabel("          B");
				 pan2.add(ci);
			 }
			 if(i==2){
				 ci= new JLabel("          C");
				 pan2.add(ci);
			 }
			 if(i==3){
				 ci= new JLabel("          D");
				 pan2.add(ci);
			 }
			 if(i==4){
				 ci= new JLabel("          E");
				 pan2.add(ci);
			 }
			 if(i==5){
				 ci= new JLabel("          F");
				 pan2.add(ci);
			 }
			 if(i==6){
				 ci= new JLabel("          G");
				 pan2.add(ci);
			 }
			 if(i==7){
				 ci= new JLabel("          H");
				 pan2.add(ci);
			 }
			 if(i==8){
				 ci= new JLabel("          I");
				 pan2.add(ci);
			 }
			 if(i==9){
				 ci= new JLabel("          J");
				 pan2.add(ci);
			 }


			 for(int j=0;j<10;j++){
				 grille2[i][j]= new JButton();
				grille2[i][j].setSize(20,20);

				 pan2.add(grille2[i][j]);

				 grille2[i][j].addActionListener(control);
				 grille2[i][j].setIcon(new ImageIcon("src/mer.jpg"));

			 }

		 }
		 
		 // cr�ation de tous les composants graphiques de la fen�tre
		 JPanel pandroite = new JPanel();
		 JPanel pan6 = new JPanel();
         panboutton.add(rb1);
         panboutton.add(rb2);

         pangauche.setLayout(new BoxLayout(pangauche, BoxLayout.Y_AXIS));
         pangauche.add(liste);
         pangauche.add(panboutton);
		 pangauche.add(pan);

		 pan6.setLayout(new BoxLayout(pan6, BoxLayout.Y_AXIS));
		 pan6.add(jtText);
		 pan6.add(jtText2);
		 pandroite.setLayout(new BoxLayout(pandroite, BoxLayout.Y_AXIS));
		 pandroite.add(pan6);
		 pandroite.add(pan2);

         JPanel pan2grille = new JPanel();
         pan2grille.setLayout(new BoxLayout(pan2grille, BoxLayout.LINE_AXIS));
         pan2grille.add(pangauche);
         pan2grille.add(pandroite);

         JPanel pan4 = new JPanel();


         pan4.add(pan2grille);

         //pan1.add(pan2,BorderLayout.EAST);
		 setContentPane(pan4);
		 
		 
	/*	
		 
		 JPanel p2 = new JPanel();
		 p2.add(l1);
		 p2.add(chro);
		 
		 JPanel p3 = new JPanel();
		 p3.add(l2);
		 p3.add(l3);
		 
		 JPanel global = new JPanel();
		 global.setLayout(new BoxLayout(global, BoxLayout.Y_AXIS));
		 global.add(p2);
		 global.add(p1);
		 global.add(p3);
		 setContentPane(global);*/
		 
	 }

}
