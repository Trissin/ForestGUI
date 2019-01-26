import java.awt.*;
import java.util.Random;
// imports

public class Tree { // tree superclass

    Random rng = new Random(); // random generator

    private int h, w, x;      // member data

    public Tree(int xPos){    // constructor

        h = rng.nextInt(25)+40;    // random height
        w = rng.nextInt(10)+15;     // random width
        x = xPos;  // position parameter
    }

    public int getHeight(){
        return h;
    } // method to return height

    public int getWidth(){
        return w;
    }  // method to return width

    public int getPos(){
        return x;
    }    // method to return position

    public void grow(Graphics g) {   // empty draw method to inherit
        // This method would paint a tree.
    }
}

/*  prototype random idea to make random more 'distributed'


        if (sector == 0){
            x = rng.nextInt(100);
        }
        else if (sector == 1){
            x = rng.nextInt(100)+100;
        }
        else if (sector == 2){
            x = rng.nextInt(100)+200;
        }
        else if (sector == 3){
            x = rng.nextInt(100)+300;
        }
        else if (sector == 4){
            x = rng.nextInt(100)+400;
        }
        else if (sector == 5){
            x = rng.nextInt(100)+500;
        }
        else if (sector == 6){
            x = rng.nextInt(100)+600;
        }
 */