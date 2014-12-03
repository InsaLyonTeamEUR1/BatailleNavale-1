import java.awt.event.ActionEvent;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.*;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
public class ControlMenu implements ActionListener {
 
 Fenetre fene;

 

 
  public ControlMenu(Fenetre fene) {
    this.fene = fene;    
  }
  
  
 
  public void actionPerformed(ActionEvent a) {

       if(a.getSource()==fene.item1){
           fene.setVisible(false);
           fene= new Fenetre();
       }

	  if(a.getSource()==fene.item2){
		  
		 JOptionPane d = new JOptionPane();
		 JOptionPane.showMessageDialog( fene, "La bataille navale oppose deux joueurs qui s'affrontent. Chacun a une flotte composée \n" +
                         " de 5 bateaux, qui sont, en général, les suivants : 1 porte-avion (5 cases), 1 croiseur (4 cases), \n " +
                         "1 contre torpilleur (3 cases), 1 sous-marin (3 cases), 1 torpilleur (2 cases). Au début du jeu, \n " +
                         "chaque joueur place ses bateaux sur sa grille. Celle-ci est toujours numérotée de A à J \n " +
                         "verticalement et de 1 à 10 horizontalement. Un à un, les joueurs vont \"tirer\" sur une case \n" +
                         " de l'adversaire. Par exemple B.3 ou encore H.8. Le but est donc de couler les bateaux adverses. \n " +
                         "En général, les jeux de société prévoient des pions blancs pour les tirs dans l'eau (donc qui ne \n " +
                         "touchent aucun bateau adverse) et des pions rouges pour les \"touché\". Au fur et à mesure, il \n " +
                         "faut mettre les pions sur sa propre grille afin de se souvenir de nos tirs passés.",
				                       "Règles", JOptionPane.ERROR_MESSAGE );
				   
				 JDialog fenErr = d.createDialog("Règles");
			
		  
		   
  
	  }
		
	  }
	  
      
}
