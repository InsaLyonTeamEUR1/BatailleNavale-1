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
    boolean check=false; // permet de faire les verifs chevauchement


    public ControlButton(Fenetre fen) {
        this.fen = fen;
    }



    public void actionPerformed(ActionEvent e) {
        fen.compteur = 0; // compteur qui sert a désactiver le nombre de cases pour un bateaux choisit (5cases retourner si on choisit le porte-avion)


        // Verfification des chevauchements et dépassement de la grilles lors des placements des bateaux
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                if (e.getSource() == fen.grille[i][j]) {
                    if (fen.rb1.isSelected()) {
                        if(i>10-fen.compFin){
                            check=false;

                        }
                        else{
                            check=true;
                        }
                        for(int k=0;k< fen.compFin;k++){ // compFin est le compteur qui permet de savoir la longueur du bateaux donc de savoir cb de cases ils faut désactiver
                            if(fen.grille[i+k][j].isEnabled() && check==true)
                                check=true;
                            else{
                                check=false;
                            }
                        }


                    }
                    if (fen.rb2.isSelected()) {
                        if(j>10-fen.compFin ){
                            check=false;

                        }
                        else{
                            check=true;
                        }
                        for(int k=0;k< fen.compFin;k++){
                            if(fen.grille[i][j+k].isEnabled() && check==true)
                                check=true;
                            else{
                                check=false;
                            }
                        }

                    }
                }
            }

        }


        // comptnombre est le compteur quu permet de ne placer d'une sorte de bateaux, il s'incrémente
        if (fen.comptnombre==0) {  //lorsque le placement c'est bien fait et ce rénitialise lorsqu'on choisit un nouvelle bateaux a poser grâce a liste
            if (fen.comptplace > 5) { // comtplace permet de savoir combien de bateaux on déja été poser , et le placement s'arrete lorsque les 5 bateaux sont poser (d'ou le if)
                System.out.println("fini de placer tout les jetons");
            } else {
                fen.compteur=0;
                while (fen.compteur < fen.compFin) {
                    for (i = 0; i < 10; i++) {
                        for (j = 0; j < 10; j++) {
                            if (e.getSource() == fen.grille[i][j]) {
                                if (fen.rb1.isSelected()) {
                                    if(check==true){
                                        fen.grille[i+fen.compteur][j].setDisabledIcon(new ImageIcon("src/bateaux.jpg"));
                                        fen.grille[i + fen.compteur][j].setEnabled(false);


                                    }

                                }
                                if (fen.rb2.isSelected()) {
                                    if(check==true){
                                        fen.grille[i][j+fen.compteur].setDisabledIcon(new ImageIcon("src/bateaux.jpg"));
                                        fen.grille[i][j + fen.compteur].setEnabled(false);

                                    }

                                }
                            }
                        }

                    }
                    fen.compteur++;
                }
            }
            if(check==true){fen.comptnombre++;}



            if(e.getSource()==fen.rb1 || e.getSource()==fen.rb2 || check==false){
                fen.comptnombre=0;
                System.out.println("vous avez choisi une position");
            }
            else{
                fen.liste.removeItem(fen.liste.getSelectedItem());
                fen.comptplace++;

            }

        }
        if(check==false){fen.comptnombre=0;}
        else{
            System.out.println("placement 1 fois");

        }
    }

}
