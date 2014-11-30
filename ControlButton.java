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
public class ControlButton implements ActionListener {

    Fenetre fen;
    int i;
    int j;



    public ControlButton(Fenetre fen) {
        this.fen = fen;
    }



    public void actionPerformed(ActionEvent e) {
        fen.compteur = 0;


        if (fen.comptnombre==0) {
        if (fen.comptplace > 5) {
            System.out.println("fini de placer tout les jetons");
        } else {

            while (fen.compteur < fen.compFin) {
                for (i = 0; i < 10; i++) {
                    for (j = 0; j < 10; j++) {
                        if (e.getSource() == fen.grille[i][j]) {
                            if (fen.rb1.isSelected()) {
                                fen.grille[i + fen.compteur][j].setEnabled(false);
                            }
                            if (fen.rb2.isSelected()) {
                                fen.grille[i][j + fen.compteur].setEnabled(false);
                            }
                        }
                    }

                }
                fen.compteur++;
            }
        }

            fen.comptnombre++;
            if(e.getSource()==fen.rb1 || e.getSource()==fen.rb2){
                fen.comptnombre=0;
                System.out.println("vous avez choisi une position");
            }
            else{
                fen.comptplace++;
            }

    }
        else{
            System.out.println("placement 1 fois");
        }
    }

}
