import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
// imports

public class ForestPanel extends JPanel{ // panel class
    Random rng = new Random();               // create random generator

    int numTrees = rng.nextInt(8) + 16;  // random number of trees
    ArrayList<Pine> pineList = new ArrayList<Pine>();           // arraylist of pines
    ArrayList<Maple> mapleList = new ArrayList<Maple>();        // arraylist of maples
    ArrayList<Oak> oakList = new ArrayList<Oak>();              // arraylist of oaks
    ArrayList<Evergreen> everList = new ArrayList<Evergreen>(); // arraylist of evergreens


    Sun sun = new Sun();      // create the sun

    int numBirds = rng.nextInt(6)+4;    // random number of hummingbirds
    ArrayList<Bird> birdList = new ArrayList<Bird>();   // arraylist of hummingbirds

    public ForestPanel() {
        for (int i = 0; i < numTrees; i++) { // loop to add trees to array list
            int treeChoose = rng.nextInt(4);   // will determine the type of tree

            if (treeChoose == 0) {          // some pine trees

                pineList.add(new Pine(i * 800 / numTrees));    // add pines to pineList

            }
            else if (treeChoose == 1) {  // some maple trees

                mapleList.add(new Maple(i * 800 / numTrees));  // add maples to mapleList

            }
            else if (treeChoose == 2) {
                oakList.add(new Oak(i * 800 / numTrees));      // add oaks to oaklist
            }
            else if (treeChoose == 3){     // some evergreen trees
                everList.add(new Evergreen(i*800 / numTrees));  // add evergreens to everlist
            }

        }

        for (int i = 0; i < numBirds; i++){
            boolean sideStarter = rng.nextBoolean();
            if (sideStarter == true){
                birdList.add(new Bird(0));
            }
            else if (sideStarter == false){
                birdList.add(new Bird(800));
            }
        }

        this.setPreferredSize(new Dimension(800, 600));   // set screen dimensions
    }

    public void paintComponent(Graphics g) {   // draw method
        super.paintComponent(g);
        Color sky = new Color(5, 154, 244);    // custom sky
        Color dirt = new Color(120, 72, 0);      // custom ground
        /* ---------------------- Sky ---------------------------------*/
        g.setColor(sky);
        g.fillRect(0, 0, 800, 600);
        /* ---------------------- Ground ---------------------------------*/
        g.setColor(dirt);
        g.fillRect(0, 450, 800, 150);
        /* ---------------------- Pines ---------------------------------*/
        for (int i = 0; i < pineList.size(); i++) { // loop to draw the trees randomly
            pineList.get(i).grow(g);
        }
        /* ---------------------- Maples ---------------------------------*/
        for (int i = 0; i < mapleList.size(); i++) {
            mapleList.get(i).grow(g);
        }
        /* ---------------------- Oaks ----------------------------------*/
        for (int i = 0; i < oakList.size(); i++) {
            oakList.get(i).grow(g);
        }
        /* ---------------------- Oaks ----------------------------------*/
        for (int i = 0; i < everList.size(); i++){
            everList.get(i).grow(g);
        }
        /*----------------------- Sun ------------------------------------*/
        sun.draw(g);  // draw the sun

        /*----------------------- Bird ------------------------------------*/
        for (int i = 0; i < birdList.size(); i++){
            int startPos = birdList.get(i).getStart();
            if (startPos <400){
                birdList.get(i).flyRight(g);
            }
            else if (startPos >400){
                birdList.get(i).flyLeft(g);
            }
            else {
                System.out.println("Start Position error!");
            }
        }

        ActionListener taskPerformer = new ActionListener() {    // actionlistener for timer
            @Override
            public void actionPerformed(ActionEvent evt) {  // every x amt of time
                repaint();  // repaint the panel
            }
        };
        Timer timer = new Timer(1,taskPerformer); // timer for repainting
        timer.start();
    }

}
