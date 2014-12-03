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
	JLabel l1, l2,l3,nbtour,global,ci;
	JButton[][] grille=  new JButton[10][10];
    JButton[][] grille2=  new JButton[10][10];
	Dimension taille = new Dimension(150,150);
	JComboBox liste;
	ButtonGroup group = new ButtonGroup();
    JRadioButton rb1 = new JRadioButton("Vertical");
    JRadioButton rb2 = new JRadioButton("Horizontal");
	boolean init=false;
	 public ControlButton control;
	 public ControlMenu controle;
	 public ControlListe control1;
	 ImageIcon image;
	 int compteur, tour;
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
			 pack(); // Fixe la taille par défaut
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
		 JTextField jtText = new JTextField("Grille Adversaire"); // Zone de text a droit ou il y a écrit Grille Adversaire
		 JTextField jtText2 = new JTextField("                 "); // Zone de text mais vide, utulisé juste pour mettre a niveau les 2 grilles
		 
		 JPanel pan = new JPanel(new GridLayout(11,11)); // Pan = panel contenant les numéros (0-10) les lettre sur le coter (a-j) et la grille
		 JPanel pangauche = new JPanel();				// pangauche comme est indiqer dans le nom est le panel contenant tout les élemnts de gauche : liste/boutton/grille
         JPanel panboutton = new JPanel();				// panboutton contient les 2 boutton pour choisir la posotion


		
		 
	// création de la 1er grille (gauche)	 
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

            }

		 }


        JPanel pan2 = new JPanel(new GridLayout(11,11));	//pan2 = panel contenant les éléments de la grille droite : numéros/chiffre/grille
		 for(int i=0;i<11;i++){								// création de la 2em grille
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
		 
		 // creation de tous les composants graphiques de la fenetre
		 JPanel pandroite = new JPanel();
		 JPanel pan6 = new JPanel();
         panboutton.add(rb1);		// Ajout du bouton rb1(verticale) sur le panel panboutton qui va contenir les 2 bouttons de posotion
         panboutton.add(rb2);		// Ajout du bouton rb2(horizontal) sur le panel panboutton qui va contenir les 2 bouttons de position

         pangauche.setLayout(new BoxLayout(pangauche, BoxLayout.Y_AXIS)); // Création du panel de gauche, le BoxLayout.Y_Axis permet de mettre chaque élément sur une ligne
         pangauche.add(liste);												//Sur le 1er ligne = tout en haut on ajoute la liste au panel 
         pangauche.add(panboutton);											// Sur la 2em ligne= en dessou de la liste on ajoute le panel panboutton qui contient les 2 boutton de position 
		 pangauche.add(pan);												// Enfin en dessou des boutton on ajoute la grillr au panel 

		 pan6.setLayout(new BoxLayout(pan6, BoxLayout.Y_AXIS));				//pan6 suit le meme fonctionnement que le panel pangauche
		 pan6.add(jtText);													// on ajoute au panel un jtText(Grille adversaire)
		 pan6.add(jtText2);													// Ajout au panel du jtText vide
		 pandroite.setLayout(new BoxLayout(pandroite, BoxLayout.Y_AXIS));	
		 pandroite.add(pan6);												// sur le pandroite on ajoute en haut le pan6 qui contient 2 ligne :  les 2 jtText ajouter ci dessu
		 pandroite.add(pan2);												// sur le pandroite on ajoute en dessu des jtText la grille

         JPanel pan2grille = new JPanel();									// création d'un panel pan2grille qui va contenir le panelgauche et le paneldroite
         pan2grille.setLayout(new BoxLayout(pan2grille, BoxLayout.LINE_AXIS));
         pan2grille.add(pangauche);
         pan2grille.add(pandroite);
	
	JPanel compteurt = new JPanel();
        compteurt.setLayout(new BoxLayout(compteurt, BoxLayout.Y_AXIS));
        compteurt.add(pan2grille);
        nbtour = new JLabel("Tour : "+tour);
        compteurt.add(nbtour);
        //pan1.add(pan2,BorderLayout.EAST);
        setContentPane(compteurt);			// Ajout a la fenetre qui va s'afficher le panel qui contient les 2 grilles + les liste... 	
      

         //pan1.add(pan2,BorderLayout.EAST);
		 	
		 
	 }

}
