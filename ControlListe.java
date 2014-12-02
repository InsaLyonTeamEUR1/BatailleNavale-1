import java.awt.event.ActionEvent;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
public class ControlListe implements ActionListener {
 
 Fenetre fen;
int i;
int j;
int compt; 

 
  public ControlListe(Fenetre fen) {
    this.fen = fen;    
  }
  
  
 
  public void actionPerformed(ActionEvent ev){	   

	  fen.comptnombre=0;
	  System.out.println("Veuillez placer un " +fen.liste.getSelectedItem());
	
	  for(int i=0;i<5;i++){
		if(fen.liste.getSelectedItem()==fen.items[i]) {
			compt=i;
			if(compt==0){
				fen.compFin=5;
			}
			if(compt==1){
				fen.compFin=4;
			}
			if(compt==2 || compt==3){
				fen.compFin=3;
			}
			if(compt==4 ){
				fen.compFin=2;
			}
		}
	  }
	 
	 

	
											 
  }
      
}
