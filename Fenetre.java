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
    JButton[][] grille= new JButton[10][10];
    JButton[][] grille2= new JButton[10][10];
    Dimension taille = new Dimension(150,150);
    JComboBox liste;
    JComboBox liste2;
    ButtonGroup group = new ButtonGroup();
    ButtonGroup group2 = new ButtonGroup();
    JRadioButton rb1 = new JRadioButton("Vertical");
    JRadioButton rb2 = new JRadioButton("Horizontal");
    JRadioButton rb1_2 = new JRadioButton("Vertical");
    JRadioButton rb2_2 = new JRadioButton("Horizontal");
    boolean init=false;
    public ControlButton control;
    public ControlButton2 control2;
    public ControlMenu controle;
    public ControlListe control1;
    public ControlListe2 controlL2;
    ImageIcon image;
    int compteur;
    int comptplace=1;
    int comptnombre;
    int comptplace2=1;
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
        control2= new ControlButton2(this);
        controlL2= new ControlListe2(this);
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
        liste2=new JComboBox(items);
        liste2.addActionListener(controlL2);
        group.add(rb1_2);
        rb1.addActionListener(control2);
        group.add(rb2_2);
        rb2.addActionListener(control2);
// liste=new JComboBox(items);
// liste.addActionListener(control1);
//rb1.addActionListener(control1);
//rb2.addActionListener(control1);
        JPanel pan = new JPanel(new GridLayout(11,11)); // Pan = panel contenant les numéros (0-10) les lettre sur le coter (a-j) et la grille
        JPanel pangauche = new JPanel(); // pangauche comme est indiqer dans le nom est le panel contenant tout les élemnts de gauche : liste/boutton/grille
        JPanel panboutton = new JPanel(); // panboutton contient les 2 boutton pour choisir la posotion
// création de la 1er grille (gauche)
        for(int i=0;i<11;i++){
            JLabel mi= new JLabel(" "+i);
            pan.add(mi);
        }
        for(int i=0;i<10;i++){
            if(i==0){
                ci= new JLabel(" A");
                pan.add(ci);
            }
            if(i==1){
                ci= new JLabel(" B");
                pan.add(ci);
            }
            if(i==2){
                ci= new JLabel(" C");
                pan.add(ci);
            }
            if(i==3){
                ci= new JLabel(" D");
                pan.add(ci);
            }
            if(i==4){
                ci= new JLabel(" E");
                pan.add(ci);
            }
            if(i==5){
                ci= new JLabel(" F");
                pan.add(ci);
            }
            if(i==6){
                ci= new JLabel(" G");
                pan.add(ci);
            }
            if(i==7){
                ci= new JLabel(" H");
                pan.add(ci);
            }
            if(i==8){
                ci= new JLabel(" I");
                pan.add(ci);
            }
            if(i==9){
                ci= new JLabel(" J");
                pan.add(ci);
            }
            for(int j=0;j<10;j++){
                grille[i][j]= new JButton();
                pan.add(grille[i][j]);
                grille[i][j].addActionListener(control);
                grille[i][j].setIcon(new ImageIcon("src/mer.jpg"));
            }
        }
        JPanel pan2 = new JPanel(new GridLayout(11,11)); //pan2 = panel contenant les éléments de la grille droite : numéros/chiffre/grille
        for(int i=0;i<11;i++){ // création de la 2em grille
            JLabel mi= new JLabel(" "+i);
            pan2.add(mi);
        }
        for(int i=0;i<10;i++){
            if(i==0){
                ci= new JLabel(" A");
                pan2.add(ci);
            }
            if(i==1){
                ci= new JLabel(" B");
                pan2.add(ci);
            }
            if(i==2){
                ci= new JLabel(" C");
                pan2.add(ci);
            }
            if(i==3){
                ci= new JLabel(" D");
                pan2.add(ci);
            }
            if(i==4){
                ci= new JLabel(" E");
                pan2.add(ci);
            }
            if(i==5){
                ci= new JLabel(" F");
                pan2.add(ci);
            }
            if(i==6){
                ci= new JLabel(" G");
                pan2.add(ci);
            }
            if(i==7){
                ci= new JLabel(" H");
                pan2.add(ci);
            }
            if(i==8){
                ci= new JLabel(" I");
                pan2.add(ci);
            }
            if(i==9){
                ci= new JLabel(" J");
                pan2.add(ci);
            }
            for(int j=0;j<10;j++){
                grille2[i][j]= new JButton();
                grille2[i][j].setSize(20,20);
                pan2.add(grille2[i][j]);
                grille2[i][j].addActionListener(control2);
                grille2[i][j].setIcon(new ImageIcon("src/mer.jpg"));
            }
        }
// creation de tous les composants graphiques de la fenetre
        JPanel panbouton2;
        panbouton2 = new JPanel();
        panbouton2.add(rb1_2);
        panbouton2.add(rb2_2);
        JPanel pandroite = new JPanel();
        JPanel pan6 = new JPanel();
        panboutton.add(rb1); // Ajout du bouton rb1(verticale) sur le panel panboutton qui va contenir les 2 bouttons de posotion
        panboutton.add(rb2); // Ajout du bouton rb2(horizontal) sur le panel panboutton qui va contenir les 2 bouttons de position
        pangauche.setLayout(new BoxLayout(pangauche, BoxLayout.Y_AXIS)); // Création du panel de gauche, le BoxLayout.Y_Axis permet de mettre chaque élément sur une ligne
        pangauche.add(liste); //Sur le 1er ligne = tout en haut on ajoute la liste au panel
        pangauche.add(panboutton); // Sur la 2em ligne= en dessou de la liste on ajoute le panel panboutton qui contient les 2 boutton de position
        pangauche.add(pan); // Enfin en dessou des boutton on ajoute la grillr au panel
        pan6.setLayout(new BoxLayout(pan6, BoxLayout.Y_AXIS)); //pan6 suit le meme fonctionnement que le panel pangauche
        pan6.add(liste2); // on ajoute au panel un jtText(Grille adversaire)
        pan6.add(panbouton2); // Ajout au panel du jtText vide
        pandroite.setLayout(new BoxLayout(pandroite, BoxLayout.Y_AXIS));
        pandroite.add(pan6); // sur le pandroite on ajoute en haut le pan6 qui contient 2 ligne : les 2 jtText ajouter ci dessu
        pandroite.add(pan2); // sur le pandroite on ajoute en dessu des jtText la grille
        JPanel pan2grille = new JPanel(); // création d'un panel pan2grille qui va contenir le panelgauche et le paneldroite
        pan2grille.setLayout(new BoxLayout(pan2grille, BoxLayout.LINE_AXIS));
        pan2grille.add(pangauche);
        pan2grille.add(pandroite);
//pan1.add(pan2,BorderLayout.EAST);
        setContentPane(pan2grille); // Ajout a la fenetre qui va s'afficher le panel qui contient les 2 grilles + les liste...
    }
}
